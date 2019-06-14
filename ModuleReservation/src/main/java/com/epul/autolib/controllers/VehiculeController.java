package com.epul.autolib.controllers;

import com.epul.autolib.bo.*;
import com.epul.autolib.dto.TypeVehiculeDTO;
import com.epul.autolib.repositories.*;
import com.epul.autolib.utilitaires.EtatVehiculeEnum;
import com.epul.autolib.utilitaires.Utils;
import com.epul.autolib.utilitaires.Vues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/vehicules")
@RestController
@CrossOrigin
public class VehiculeController extends BasicController<Station> {

    private final int nbVehiculesParPage = 15;

    private final VehiculeRepository vehiculeRepository;
    private final TypeVehiculeRepository typeVehiculeRepository;
    private final BorneRepository borneRepository;
    private final ReservationRepository reservationRepository;
    private final ClientRepository clientRepository;
    private final UtiliseRepository utiliseRepository;

    @Autowired
    VehiculeController(VehiculeRepository vehiculeRepository, TypeVehiculeRepository typeVehiculeRepository,
                       BorneRepository borneRepository, ReservationRepository reservationRepository,
                       ClientRepository clientRepository, UtiliseRepository utiliseRepository) {
        super(Station.class);
        this.vehiculeRepository = vehiculeRepository;
        this.typeVehiculeRepository = typeVehiculeRepository;
        this.borneRepository = borneRepository;
        this.reservationRepository = reservationRepository;
        this.clientRepository = clientRepository;
        this.utiliseRepository = utiliseRepository;
    }

    @RequestMapping(value = "/liste2")
    public ModelAndView listeStations(HttpServletRequest request) {
        List<Vehicule> vehiculesList = vehiculeRepository.findAll();

        int page = 1;
        if(request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }

        // Pour pagination
        int startIndex = nbVehiculesParPage * (page - 1);
        int endIndex = Math.min((nbVehiculesParPage * page), vehiculesList.size());
        int nbPages = (int) Math.ceil((double) vehiculesList.size() / nbVehiculesParPage);
        request.setAttribute("nbPages", nbPages);
        request.setAttribute("currentPage", page);

        List<Vehicule> vehicules = vehiculesList.subList(startIndex, endIndex);
        request.setAttribute("listeVehicule", vehicules);

        return new ModelAndView(Vues.Vehicules.LIST+"2");
    }

    @RequestMapping(value = "/liste")
    public ModelAndView listeTypesVehicules(HttpServletRequest request) {
        List<TypeVehicule> typeVehiculeList = typeVehiculeRepository.findAll();

        // Dégueulasse mais bon...
        List<TypeVehiculeDTO> typeVehiculeDTOList = new ArrayList<>();
        for (TypeVehicule typeVehicule : typeVehiculeList) {
            final TypeVehiculeDTO typeVehiculeDTO = new TypeVehiculeDTO(typeVehicule);

            int nbVehicules = vehiculeRepository.countVehiculesByTypeVehiculeAndDisponibilite(typeVehicule, EtatVehiculeEnum.LIBRE.name());
            typeVehiculeDTO.setNbVehiculesLibres(nbVehicules);

            nbVehicules = vehiculeRepository.countVehiculesByTypeVehiculeAndDisponibilite(typeVehicule, EtatVehiculeEnum.RESERVE.name());
            typeVehiculeDTO.setNbVehiculesReserves(nbVehicules);

            nbVehicules = vehiculeRepository.countVehiculesByTypeVehiculeAndDisponibilite(typeVehicule, EtatVehiculeEnum.OCCUPE.name());
            typeVehiculeDTO.setNbVehiculesUtilises(nbVehicules);

            typeVehiculeDTOList.add(typeVehiculeDTO);
        }

        request.setAttribute("typeVehicule", typeVehiculeDTOList);

        return new ModelAndView(Vues.Vehicules.LIST);
    }

    @RequestMapping(value = "/retirer/{idVehicule}/{idReservation}")
    public ModelAndView retirerVehicule(HttpServletRequest request, @PathVariable int idVehicule, @PathVariable int idReservation) {
        Vehicule vehicule = vehiculeRepository.findById(idVehicule).orElse(null);
        Borne borne = borneRepository.findBorneByVehicule(vehicule);
        Client client = clientRepository.findById((Integer) request.getSession().getAttribute("id")).get();

        if (vehicule != null) {
            // Créer une nouvelle utilisation
            Utilise utilisation = new Utilise();
            utilisation.setClient(client);
            utilisation.setDate(Utils.localDateTimeToTimestamp(LocalDateTime.now()));
            utilisation.setVehicule(vehicule);
            utilisation.setBorneDepart(borne);
            utiliseRepository.save(utilisation);

            // changer la disponibilité du véhicule
            vehicule.setDisponibilite(EtatVehiculeEnum.OCCUPE.name());
            vehiculeRepository.save(vehicule);

            // le retirer de la borne
            borne.setEtatBorne(!borne.getEtatBorne());
            borne.setVehicule(null);
            borneRepository.save(borne);

            // MAJ la réservation pour qu'elle apparaisse terminée
            Reservation reservation = reservationRepository.findById(idReservation).orElse(null);
            if (reservation != null) {
                reservation.setDateEcheance(Utils.localDateTimeToTimestamp(LocalDateTime.now()));
                reservationRepository.save(reservation);
            }
        }

        return new ModelAndView(Vues.Reservations.LIST);
    }
}
