package com.epul.autolib.controllers;

import com.epul.autolib.bo.Station;
import com.epul.autolib.repositories.StationRepository;
import com.epul.autolib.utilitaires.Vues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("")
@RestController
@CrossOrigin
public class StationController extends BasicController<Station> {

    private final StationRepository stationRepository;

    @Autowired
    StationController(StationRepository stationRepository) {
        super(Station.class);
        this.stationRepository = stationRepository;
    }

    @RequestMapping(value = "/stations")
    public String listeStations() {
        return Vues.Erreur.E404; // TODO
    }
}
