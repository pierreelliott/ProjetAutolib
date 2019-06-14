package com.epul.autolib.controllers;

import com.epul.autolib.utilitaires.VuesAlt;
import com.epul.autolib.domains.Adherent;
import com.epul.autolib.meserreurs.MonException;
import com.epul.autolib.repositories.AdherentRepository;
import com.epul.autolib.utilitaires.Vues;
import com.epul.autolib.utilitaires.Layout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@RequestMapping("/adherents")
@Controller
@CrossOrigin
public class AdherentController extends BasicController<Adherent> {

    private final AdherentRepository adherentRepository;

    @Autowired
    public AdherentController(AdherentRepository adherentRepository) {
        super(Adherent.class);
        this.adherentRepository = adherentRepository;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/liste")
    public ModelAndView lister(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage;
        List<Adherent> list = null;
        try {
            retrieveError(request);

            list = adherentRepository.findAll();
            request.setAttribute("listeAdherent", list);
            destinationPage = LIST;
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = VuesAlt.Erreur.ERREUR;
        }
        return new Layout(destinationPage);
    }

    @GetMapping("/getAdherent/{id}")
    public Adherent getAdherentById(@PathVariable(value = "id") int id) {
        return adherentRepository.findById(id).orElseThrow(
                () -> new MonException("Adherent", "id", id)
        );
    }

    @RequestMapping(value = "/nouveau")
    public ModelAndView ajouter(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return new Layout(ADD);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/insererAdherent")
    public ModelAndView insert(HttpServletRequest request, HttpServletResponse response, @ModelAttribute Adherent adherent) throws Exception {
        String destinationPage;
        try {
            adherentRepository.save(adherent);

            destinationPage = LIST_RDR;
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = VuesAlt.Erreur.ERREUR;
        }

        return new Layout(destinationPage);
    }

    @RequestMapping(value = "/modifier/{id}")
    public ModelAndView modifier(HttpServletRequest request, HttpServletResponse response, @PathVariable int id) throws Exception {
        String destinationPage;
        try {
            Adherent adherent = adherentRepository.findById(id).orElse(null);
            request.setAttribute("unAdherent", adherent);
            destinationPage = UPDATE;
//            destinationPage = "vues/adherents/test";
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = Vues.Erreur.ERREUR;
        }

        return new Layout(destinationPage);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/modifierAdherent")
    public ModelAndView update(HttpServletRequest request, HttpServletResponse response, @ModelAttribute Adherent adherent) throws Exception {
        String destinationPage;
        try {
            adherentRepository.save(adherent);

            destinationPage = LIST_RDR;
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = Vues.Erreur.ERREUR;
        }

        return new Layout(destinationPage);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/supprimer/{id}")
    public ModelAndView delete(HttpServletRequest request, HttpServletResponse response, @PathVariable int id) throws Exception {
        String destinationPage;
        try {
            adherentRepository.deleteById(id);

            destinationPage = LIST_RDR;
        } catch (Exception e) {
            request.getSession().setAttribute("erreur", e.getMessage());
            destinationPage = LIST_RDR;
        }

        return new Layout(destinationPage);
    }
}

