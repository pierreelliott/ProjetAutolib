package com.epul.autolib.controllers;

import com.epul.autolib.domains.Adherent;
import com.epul.autolib.domains.Oeuvrevente;
import com.epul.autolib.domains.Reservation;
import com.epul.autolib.dto.ReservationDTO;
import com.epul.autolib.repositories.AdherentRepository;
import com.epul.autolib.repositories.OeuvreventeRepository;
import com.epul.autolib.utilitaires.EtatReservationEnum;
import com.epul.autolib.utilitaires.Layout;
import com.epul.autolib.utilitaires.VuesAlt;
import com.epul.autolib.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.List;
import java.util.Map;

@RequestMapping("/reservations")
@RestController
@CrossOrigin
public class ReservationController extends BasicController<Reservation> {

    private final ReservationRepository reservationRepository;
    private final AdherentRepository adherentRepository;
    private final OeuvreventeRepository oeuvreventeRepository;

    @Autowired
    public ReservationController(ReservationRepository reservationRepository, AdherentRepository adherentRepository,
                                 OeuvreventeRepository oeuvreventeRepository) {
        super(Reservation.class);
        this.reservationRepository = reservationRepository;
        this.adherentRepository = adherentRepository;
        this.oeuvreventeRepository = oeuvreventeRepository;
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
        listesModifiablesReservation(request, reservationDTO);


        queryParameters.computeIfPresent("idOeuvre", (key, value) -> {
            reservationDTO.setIdOeuvrevente(Integer.parseInt(value));
            return "";
        });

        queryParameters.computeIfPresent("idAdherent", (key, value) -> {
            reservationDTO.setIdAdherent(Integer.parseInt(value));
            return "";
        });

        request.setAttribute("reservation", reservationDTO);

        return new Layout(destinationPage);
    }

    private void listesModifiablesReservation(HttpServletRequest request, ReservationDTO reservationDTO) {
        List<Adherent> listeAdherent;
        listeAdherent = adherentRepository.findAll();
        request.setAttribute("listeAdherent", listeAdherent);

        List<Oeuvrevente> listeOeuvrevente;
        listeOeuvrevente = oeuvreventeRepository.findAll();
        request.setAttribute("listeOeuvrevente", listeOeuvrevente);

        retrieveError(request);

        Object idAdherent = request.getSession().getAttribute("idAdherent");
        if(idAdherent != null) {
            request.getSession().removeAttribute("idAdherent");
            reservationDTO.setIdAdherent((Integer) idAdherent);
        }

        Object idOeuvre = request.getSession().getAttribute("idOeuvre");
        if (idOeuvre != null) {
            request.getSession().removeAttribute("idOeuvre");
            reservationDTO.setIdOeuvrevente((Integer) idOeuvre);
        }

        Object dateReservation = request.getSession().getAttribute("dateReservation");
        if (dateReservation != null) {
            request.getSession().removeAttribute("dateReservation");
            reservationDTO.setDateReservation((Date) dateReservation);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/insererReservation")
    public ModelAndView insert(HttpServletRequest request, HttpServletResponse response, @ModelAttribute ReservationDTO reservationDTO) throws Exception {
        String destinationPage;

        try {
            updateOrInsert(reservationDTO);

            destinationPage = LIST_RDR;
        } catch (Exception e) {
            request.getSession().setAttribute("idAdherent", reservationDTO.getIdAdherent());
            request.getSession().setAttribute("idOeuvre", reservationDTO.getIdOeuvrevente());
            request.getSession().setAttribute("dateReservation", reservationDTO.getDateReservation());

            String errorMessage;
            if(e instanceof DataIntegrityViolationException) {
                errorMessage = "L'oeuvre est déjà réservée pour cette date.";
            } else {
                errorMessage = e.getMessage();
            }
            request.getSession().setAttribute("erreur", errorMessage);
            destinationPage = ADD_RDR;
        }

        return new Layout(destinationPage);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/modifier/{id}")
    public ModelAndView modifier(HttpServletRequest request, HttpServletResponse response,
                                @PathVariable int id) throws Exception {
        ReservationDTO reservationDTO = reservationRepository.findById(id).orElse(null).toDTO();

        listesModifiablesReservation(request, reservationDTO);

        request.setAttribute("reservation", reservationDTO);

        return new Layout(UPDATE);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/modifierReservation")
    public ModelAndView update(HttpServletRequest request, HttpServletResponse response, @ModelAttribute ReservationDTO reservationDTO) throws Exception {
        String destinationPage;

        try {
            updateOrInsert(reservationDTO);

            destinationPage = LIST_RDR;
        } catch (Exception e) {
            request.getSession().setAttribute("idAdherent", reservationDTO.getIdAdherent());
            request.getSession().setAttribute("idOeuvre", reservationDTO.getIdOeuvrevente());
            request.getSession().setAttribute("dateReservation", reservationDTO.getDateReservation());

            request.getSession().setAttribute("erreur", e.getMessage());
            destinationPage = UPDATE_RDR + reservationDTO.getId();
        }

        return new Layout(destinationPage);
    }

    private void updateOrInsert(ReservationDTO reservationDTO) throws Exception {
        Exception exceptionAdherent = new Exception("Aucun adhérent sélectionné.");
        Exception exceptionOeuvre = new Exception("Aucune oeuvre sélectionnée.");

        if(reservationDTO.getIdAdherent() == null) {
            throw exceptionAdherent;
        }
        if(reservationDTO.getIdOeuvrevente() == null) {
            throw exceptionOeuvre;
        }

        Adherent adherent = adherentRepository.findById(reservationDTO.getIdAdherent()).orElseThrow(() -> exceptionAdherent);

        Oeuvrevente oeuvre = oeuvreventeRepository.findById(reservationDTO.getIdOeuvrevente()).orElseThrow(() -> exceptionOeuvre);

        reservationDTO.setAdherent(adherent);
        reservationDTO.setOeuvre(oeuvre);

        // Si on insère, le statut est null
        if(reservationDTO.getStatut() == null || reservationDTO.getStatut().isEmpty()) {
            reservationDTO.setStatut(EtatReservationEnum.PENDING.getLabel());
        }

        Reservation reservation = new Reservation(reservationDTO);

        reservationRepository.save(reservation);
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
