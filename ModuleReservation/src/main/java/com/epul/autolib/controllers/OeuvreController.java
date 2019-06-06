package com.epul.autolib.controllers;

import com.epul.autolib.domains.Oeuvrevente;
import com.epul.autolib.domains.Proprietaire;
import com.epul.autolib.repositories.OeuvreventeRepository;
import com.epul.autolib.repositories.ProprietaireRepository;
import com.epul.autolib.utilitaires.Layout;
import com.epul.autolib.utilitaires.Vues;
import com.epul.autolib.utilitaires.VuesAlt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RequestMapping("/oeuvres")
@RestController
@CrossOrigin
public class OeuvreController extends BasicController<Oeuvrevente> {

    private final OeuvreventeRepository oeuvreventeRepository;
    private final ProprietaireRepository proprietaireRepository;

    @Autowired
    public OeuvreController(OeuvreventeRepository oeuvreventeRepository, ProprietaireRepository proprietaireRepository) {
        super(Oeuvrevente.class);
        this.oeuvreventeRepository = oeuvreventeRepository;
        this.proprietaireRepository = proprietaireRepository;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/liste")
    public ModelAndView lister(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage;
        List<Oeuvrevente> list = null;
        try {
            retrieveError(request);

            list = oeuvreventeRepository.findAll();
            request.setAttribute("listeOeuvrevente", list);
            destinationPage = LIST;
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = VuesAlt.Erreur.ERREUR;
        }
        return new Layout(destinationPage);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/nouveau")
    public ModelAndView ajouter(HttpServletRequest request, HttpServletResponse response) throws Exception {
        retrieveError(request);

        List<Proprietaire> proprietaires = proprietaireRepository.findAll();
        request.setAttribute("listeProprietaire", proprietaires);

        return new Layout(ADD);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/insererOeuvre")
    public ModelAndView insert(HttpServletRequest request, HttpServletResponse response, @ModelAttribute Oeuvrevente oeuvre) throws Exception {
        String destinationPage;
        try {
            updateOrInsert(oeuvre);

            destinationPage = LIST_RDR;
        } catch (Exception e) {
            request.setAttribute("erreur", e.getMessage());
            destinationPage = ADD_RDR;
        }

        return new Layout(destinationPage);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/modifier/{id}")
    public ModelAndView modifier(HttpServletRequest request, HttpServletResponse response, @PathVariable int id) throws Exception {
        String destinationPage;
        try {
            Oeuvrevente oeuvre = oeuvreventeRepository.findById(id);
            request.setAttribute("unOeuvrevente", oeuvre);
            List<Proprietaire> proprietaires = proprietaireRepository.findAll();
            request.setAttribute("listeProprietaire", proprietaires);

            destinationPage = UPDATE;
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = Vues.Erreur.ERREUR;
        }

        return new Layout(destinationPage);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/modifierOeuvre")
    public ModelAndView update(HttpServletRequest request, HttpServletResponse response, @ModelAttribute Oeuvrevente oeuvre) throws Exception {
        String destinationPage;
        try {
            updateOrInsert(oeuvre);

            destinationPage = LIST_RDR;
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = Vues.Erreur.ERREUR;
        }

        return new Layout(destinationPage);
    }

    private void updateOrInsert(Oeuvrevente oeuvre) throws Exception {
        if(oeuvre.getIdProprietaire() == null) {
            throw new Exception("Aucun propriétaire.");
        }
        Proprietaire proprio = proprietaireRepository.findById(oeuvre.getIdProprietaire()).orElseThrow(() -> new Exception("Aucun propriétaire."));
        oeuvre.setProprietaire(proprio);

        oeuvreventeRepository.save(oeuvre);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/supprimer/{id}")
    public ModelAndView delete(HttpServletRequest request, HttpServletResponse response, @PathVariable int id) throws Exception {
        String destinationPage;
        try {
            oeuvreventeRepository.deleteById(id);

            destinationPage = LIST_RDR;
        } catch (Exception e) {
            request.getSession().setAttribute("erreur", e.getMessage());
            destinationPage = LIST_RDR;
        }

        return new Layout(destinationPage);
    }
}
