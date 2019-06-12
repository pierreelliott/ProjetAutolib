package com.epul.autolib.controllers;

import com.epul.autolib.bo.Station;
import com.epul.autolib.repositories.StationRepository;
import com.epul.autolib.utilitaires.Vues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@RequestMapping("/stations")
@RestController
@CrossOrigin
public class StationController extends BasicController<Station> {

    private final int nbStationsParPage = 15;

    private final StationRepository stationRepository;

    @Autowired
    StationController(StationRepository stationRepository) {
        super(Station.class);
        this.stationRepository = stationRepository;
    }

    @RequestMapping(value = "")
    public ModelAndView redirect(HttpServletRequest request) {
        return new ModelAndView("redirect:/stations/carte");
    }

    @RequestMapping(value = "/liste")
    public ModelAndView listeStations(HttpServletRequest request) {
        List<Station> stationsList = stationRepository.findAll();

        int page = 1;
        if(request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }

        // Pour pagination
        int startIndex = nbStationsParPage * (page - 1);
        int endIndex = Math.min((nbStationsParPage * page), stationsList.size());
        int nbPages = (int) Math.ceil((double) stationsList.size() / nbStationsParPage);
        request.setAttribute("nbPages", nbPages);
        request.setAttribute("currentPage", page);

        List<Station> stations = stationsList.subList(startIndex, endIndex);
        request.setAttribute("listeStation", stations);

        return new ModelAndView(Vues.Stations.LIST);
    }

    @RequestMapping(value = "/carte")
    public ModelAndView carteStations(HttpServletRequest request) {
        List<Station> stations = stationRepository.findAll();

        request.setAttribute("stations", stations);

        return new ModelAndView(Vues.Stations.CARTE);
    }
}
