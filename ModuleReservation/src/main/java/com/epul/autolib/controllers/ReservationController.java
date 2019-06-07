package com.epul.autolib.controllers;

import com.epul.autolib.bo.Station;
import com.epul.autolib.bo.Reservation;
import com.epul.autolib.dto.ReservationDTO;
import com.epul.autolib.dto.ReservationDTOOld;
import com.epul.autolib.repositories.StationRepository;
import com.epul.autolib.repositories.VehiculeRepository;
import com.epul.autolib.service.ReservationService;
import com.epul.autolib.utilitaires.Layout;
import com.epul.autolib.utilitaires.Vues;
import com.epul.autolib.utilitaires.VuesAlt;
import com.epul.autolib.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.jms.Topic;
import javax.jms.TopicConnectionFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RequestMapping("/reservations")
@RestController
@CrossOrigin
public class ReservationController extends BasicController<Reservation> {

    private final ReservationRepository reservationRepository;
    private final VehiculeRepository vehiculeRepository;
    private final StationRepository stationRepository;
    private final ReservationService reservationService;

    @Resource(lookup = "java:jboss/exported/topic/DemandeReservationJmsTopic")
    private Topic topic;
    // On accède à l'EJB
    @Resource(mappedName = "java:/ConnectionFactory")
    private TopicConnectionFactory cf;

    @Autowired
    public ReservationController(ReservationRepository reservationRepository, VehiculeRepository vehiculeRepository, StationRepository stationRepository, ReservationService reservationService) {
        super(Reservation.class);
        this.reservationRepository = reservationRepository;
        this.vehiculeRepository = vehiculeRepository;
        this.stationRepository = stationRepository;
        this.reservationService = reservationService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/liste")
    public ModelAndView lister(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage;
        List<Reservation> list;
        try {
            retrieveError(request);

            list = reservationRepository.findAll();
            request.setAttribute("listeReservation", list);
            destinationPage = LIST;
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = VuesAlt.Erreur.E404;
        }
        return new Layout(destinationPage);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/nouveau")
    public ModelAndView ajouter(HttpServletRequest request, HttpServletResponse response, @RequestParam Map<String, String> queryParameters) throws Exception {
        ReservationDTO reservationDTO = new ReservationDTO();


        queryParameters.computeIfPresent("idVehicule", (key, value) -> {
            int idVehicule = Integer.parseInt(value);
            reservationDTO.setVehicule(vehiculeRepository.getOne(idVehicule));
            return "";
        });

        queryParameters.computeIfPresent("idStation", (key, value) -> {
            int idStation = Integer.parseInt(value);
            Station station = stationRepository.getOne(idStation);
            reservationDTO.setStation(station);
            return "";
        });

        request.setAttribute("reservation", reservationDTO);

        // FIXME C'est juste pour tester
        reservationDTO.setDateReservation(new Timestamp(new Date().getTime()));
        insert(request, response, reservationDTO);

        // TODO Envoyer sur la page de réservation

        return new Layout(Vues.Vehicules.LIST);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/insererReservation")
    public ModelAndView insert(HttpServletRequest request, HttpServletResponse response, @ModelAttribute ReservationDTO reservationDTO) throws Exception {
        String destinationPage;

        try {
            Exception exceptionAdherent = new Exception("Aucun adhérent sélectionné.");
            Exception exceptionOeuvre = new Exception("Aucune oeuvre sélectionnée.");

            if(reservationDTO.getIdClient() == null) {
                throw exceptionAdherent;
            }
            if(reservationDTO.getIdVehicule() == null) {
                throw exceptionOeuvre;
            }

            // TODO Vérification des informations renseignées

            reservationService.publier(reservationDTO, topic, cf);

            destinationPage = Vues.Vehicules.LIST;
        } catch (Exception e) { // TODO Gérer les erreurs
            destinationPage = Vues.Vehicules.LIST_RDR;
        }

        return new Layout(destinationPage);
    }


    @RequestMapping(method = RequestMethod.POST, value = "/modifierReservation")
    public ModelAndView update(HttpServletRequest request, HttpServletResponse response, @ModelAttribute ReservationDTOOld reservationDTOOld) throws Exception {
        String destinationPage;

        try {
            updateOrInsert(reservationDTOOld);

            destinationPage = LIST_RDR;
        } catch (Exception e) {
            request.getSession().setAttribute("idAdherent", reservationDTOOld.getIdAdherent());
            request.getSession().setAttribute("idOeuvre", reservationDTOOld.getIdOeuvrevente());
            request.getSession().setAttribute("dateReservation", reservationDTOOld.getDateReservation());

            request.getSession().setAttribute("erreur", e.getMessage());
            destinationPage = UPDATE_RDR + reservationDTOOld.getId();
        }

        return new Layout(destinationPage);
    }

    private void updateOrInsert(ReservationDTOOld reservationDTOOld) throws Exception {

    }

    @RequestMapping(method = RequestMethod.GET, value = "/supprimer/{id}")
    public ModelAndView delete(HttpServletRequest request, HttpServletResponse response, @PathVariable int id) throws Exception {
        try {
            reservationRepository.deleteById(id);
        } catch (Exception e) {
            request.getSession().setAttribute("erreur", "Impossible de supprimer cette réservation.");
        }

        return new Layout(LIST_RDR);
    }
}
