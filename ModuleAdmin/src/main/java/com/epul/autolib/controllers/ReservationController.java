package com.epul.autolib.controllers;

import com.epul.autolib.bo.Station;
import com.epul.autolib.domains.Reservation;
import com.epul.autolib.dto.ReservationDTO;
import com.epul.autolib.repositories.*;
import com.epul.autolib.utilitaires.EtatReservationEnum;
import com.epul.autolib.utilitaires.Layout;
import com.epul.autolib.utilitaires.VuesAlt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.jms.Topic;
import javax.jms.TopicConnectionFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@RequestMapping("/reservations")
@RestController
@CrossOrigin
public class ReservationController extends BasicController<Reservation> {

    private final ReservationRepository reservationRepository;
    private final VehiculeRepository vehiculeRepository;
    private final ClientRepository clientRepository;
    private final StationRepository stationRepository;

    @Resource(lookup = "java:jboss/exported/topic/DemandeReservationJmsTopic")
    private Topic topic;
    // On accède à l'EJB
    @Resource(mappedName = "java:/ConnectionFactory")
    private TopicConnectionFactory cf;

    @Autowired
    public ReservationController(ReservationRepository reservationRepository, VehiculeRepository vehiculeRepository,
                                 ClientRepository clientRepository, StationRepository stationRepository) {
        super(Reservation.class);
        this.reservationRepository = reservationRepository;
        this.vehiculeRepository = vehiculeRepository;
        this.clientRepository = clientRepository;
        this.stationRepository = stationRepository;
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
        String destinationPage = ADD;
        ReservationDTO reservationDTO = new ReservationDTO();
//        listesModifiablesReservation(request, reservationDTO);


        queryParameters.computeIfPresent("idVehicule", (key, value) -> {
            int idVehicule = Integer.parseInt(value);
            reservationDTO.setIdVehicule(idVehicule);
            reservationDTO.setVehicule(vehiculeRepository.getOne(idVehicule));
            return "";
        });

        queryParameters.computeIfPresent("idStation", (key, value) -> {
            int idStation = Integer.parseInt(value);
            Station station = stationRepository.getOne(idStation);
            reservationDTO.setStation(station);
            return "";
        });

        reservationDTO.setIdClient(1); // FIXME Récupérer depuis la session

        request.setAttribute("reservation", reservationDTO);

        // FIXME C'est juste pour tester
        reservationDTO.setDateReservation(new Timestamp(new Date().getTime()));
        return new Layout(destinationPage);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/valider/{id}")
    public ModelAndView validate(HttpServletRequest request, HttpServletResponse response, @PathVariable int id) throws Exception {
        try {
            Reservation reservation = reservationRepository.findById(id).orElse(null);

            if(reservation == null || reservation.getStatut().equals(EtatReservationEnum.CONFIRMED.getLabel())) {
                throw new Exception("Impossible de valider cette réservation.");
            }

            reservation.setStatut(EtatReservationEnum.CONFIRMED.getLabel());

            reservationRepository.save(reservation);
        } catch (Exception e) {
            request.getSession().setAttribute("erreur", e.getMessage());
        }

        return new Layout(LIST_RDR);
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
