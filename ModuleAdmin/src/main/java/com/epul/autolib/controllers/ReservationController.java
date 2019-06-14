package com.epul.autolib.controllers;

import com.epul.autolib.bo.Client;
import com.epul.autolib.bo.Reservation;
import com.epul.autolib.bo.Utilise;
import com.epul.autolib.dto.ReservationDTO;
import com.epul.autolib.dto.UtiliseDTO;
import com.epul.autolib.repositories.*;
import com.epul.autolib.utilitaires.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/reservations")
@RestController
@CrossOrigin
public class ReservationController extends BasicController<Reservation> {

    private final ReservationRepository reservationRepository;
    private final VehiculeRepository vehiculeRepository;
    private final ClientRepository clientRepository;
    private final StationRepository stationRepository;
    private final UtiliseRepository utiliseRepository;

    @Autowired
    public ReservationController(ReservationRepository reservationRepository, VehiculeRepository vehiculeRepository,
                                 ClientRepository clientRepository, StationRepository stationRepository, UtiliseRepository utiliseRepository) {
        super(Reservation.class);
        this.reservationRepository = reservationRepository;
        this.vehiculeRepository = vehiculeRepository;
        this.clientRepository = clientRepository;
        this.stationRepository = stationRepository;
        this.utiliseRepository = utiliseRepository;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/liste/{idClient}")
    public ModelAndView lister(HttpServletRequest request, HttpServletResponse response, @PathVariable int idClient) throws Exception {
        String destinationPage;
        try {
            retrieveError(request);

            Client client = clientRepository.findById(idClient).get();
            request.setAttribute("client", client);

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
}
