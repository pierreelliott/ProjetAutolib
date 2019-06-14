package com.epul.autolib.controllers;

import com.epul.autolib.bo.Reservation;
import com.epul.autolib.bo.Station;
import com.epul.autolib.bo.Utilise;
import com.epul.autolib.dto.ReservationDTO;
import com.epul.autolib.dto.UtiliseDTO;
import com.epul.autolib.repositories.*;
import com.epul.autolib.service.ReservationService;
import com.epul.autolib.utilitaires.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequestMapping("/reservations")
@RestController
@CrossOrigin
public class ReservationController extends BasicController<Reservation> {

    private final ReservationRepository reservationRepository;
    private final VehiculeRepository vehiculeRepository;
    private final ClientRepository clientRepository;
    private final StationRepository stationRepository;
    private final ReservationService reservationService;
    private final UtiliseRepository utiliseRepository;

    @Autowired
    public ReservationController(ReservationRepository reservationRepository, VehiculeRepository vehiculeRepository,
                                 ClientRepository clientRepository, StationRepository stationRepository,
                                 ReservationService reservationService, UtiliseRepository utiliseRepository) {
        super(Reservation.class);
        this.reservationRepository = reservationRepository;
        this.vehiculeRepository = vehiculeRepository;
        this.clientRepository = clientRepository;
        this.stationRepository = stationRepository;
        this.reservationService = reservationService;
        this.utiliseRepository = utiliseRepository;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/liste")
    public ModelAndView lister(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage;
        try {
            retrieveError(request);

            Integer idClient = (Integer) request.getSession().getAttribute("id");

            List<Reservation> listeReservations = reservationRepository.findAllByClient_IdClient(idClient);
            List<ReservationDTO> listeReservationDTO = listeReservations.stream().map(ReservationDTO::new).collect(Collectors.toList());
            request.setAttribute("reservations", listeReservationDTO);

            List<Utilise> listeUtilises = utiliseRepository.findAllByClient_IdClient(idClient);
            List<UtiliseDTO> utiliseDTOList = listeUtilises.stream().map(UtiliseDTO::new).collect(Collectors.toList());
            request.setAttribute("vehiculesUtilises", utiliseDTOList);

            destinationPage = Vues.Reservations.LIST;
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = Vues.Erreur.E404;
        }
        return new Layout(destinationPage);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/nouveau/{idVehicule}")
    public ModelAndView ajouter(HttpServletRequest request, HttpServletResponse response, @PathVariable int idVehicule,
                                @RequestParam Map<String, String> queryParameters) throws Exception {
        ReservationDTO reservationDTO = new ReservationDTO();
//        listesModifiablesReservation(request, reservationDTO);


        reservationDTO.setIdVehicule(idVehicule);
        reservationDTO.setVehicule(vehiculeRepository.getOne(idVehicule));

        queryParameters.computeIfPresent("idStation", (key, value) -> {
            int idStation = Integer.parseInt(value);
            Station station = stationRepository.getOne(idStation);
            reservationDTO.setStation(station);
            return "";
        });

        Integer idClient = (Integer) request.getSession().getAttribute("id");
        reservationDTO.setIdClient(idClient);

        request.setAttribute("reservation", reservationDTO);

        LocalDateTime date = LocalDateTime.now();
        reservationDTO.setDateReservation(Utils.localDateTimeToTimestamp(date));
        reservationDTO.setDateEcheance(Utils.localDateTimeToTimestamp(date.plusMinutes(90)));

        insert(request, response, reservationDTO);
        return new Layout(Vues.Reservations.LIST_RDR);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/insererReservation")
    public ModelAndView insert(HttpServletRequest request, HttpServletResponse response, @ModelAttribute ReservationDTO reservationDTO) throws Exception {
        String destinationPage;

        try {
            Exception exceptionClient = new Exception("Aucun client sélectionné.");
            Exception exceptionVehicule = new Exception("Aucun véhicule sélectionnée.");

            if(reservationDTO.getIdClient() == null) {
                throw exceptionClient;
            }
            if(reservationDTO.getIdVehicule() == null) {
                throw exceptionVehicule;
            }

            // TODO Vérification des informations renseignées

            reservationService.publier(reservationDTO);

            destinationPage = Vues.Vehicules.LIST;
        } catch (Exception e) { // TODO Gérer les erreurs
            destinationPage = Vues.Vehicules.LIST_RDR;
        }

        return new Layout(destinationPage);
    }
}
