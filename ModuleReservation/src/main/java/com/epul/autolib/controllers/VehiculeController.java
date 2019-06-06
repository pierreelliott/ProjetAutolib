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

    private final VehiculeRepository vehiculeRepository;

    @Autowired
    VehiculeController(VehiculeRepository vehiculeRepository) {
        super(Station.class);
        this.vehiculeRepository = vehiculeRepository;
    }

    @RequestMapping(value = "/liste")
    public ModelAndView listeStations(HttpServletRequest request) {
        List<Vehicule> vehicules = vehiculeRepository.findAll();
        request.setAttribute("listeVehicule", vehicules);
        return new ModelAndView(Vues.Vehicules.LIST);
    }

//    @RequestMapping(value = "/carte")
//    public ModelAndView carteStations(HttpServletRequest request) {
//        return new ModelAndView(Vues.Erreur.E404); // TODO
//    }
}
