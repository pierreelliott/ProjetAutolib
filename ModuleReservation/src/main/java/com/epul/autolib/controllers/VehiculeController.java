package com.epul.autolib.controllers;

import com.epul.autolib.bo.Station;
import com.epul.autolib.bo.Vehicule;
import com.epul.autolib.repositories.VehiculeRepository;
import com.epul.autolib.utilitaires.Vues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping("/vehicules")
@RestController
@CrossOrigin
public class VehiculeController extends BasicController<Station> {

    private final int nbVehiculesParPage = 15;

    private final VehiculeRepository vehiculeRepository;

    @Autowired
    VehiculeController(VehiculeRepository vehiculeRepository) {
        super(Station.class);
        this.vehiculeRepository = vehiculeRepository;
    }

    @RequestMapping(value = "/liste")
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

        return new ModelAndView(Vues.Vehicules.LIST);
    }

//    @RequestMapping(value = "/carte")
//    public ModelAndView carteStations(HttpServletRequest request) {
//        return new ModelAndView(Vues.Erreur.E404); // TODO
//    }
}
