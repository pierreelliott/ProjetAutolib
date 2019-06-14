package com.epul.autolib.controllers;

import com.epul.autolib.bo.Station;
import com.epul.autolib.bo.TypeVehicule;
import com.epul.autolib.bo.Vehicule;
import com.epul.autolib.dto.TypeVehiculeDTO;
import com.epul.autolib.repositories.TypeVehiculeRepository;
import com.epul.autolib.repositories.VehiculeRepository;
import com.epul.autolib.utilitaires.EtatVehiculeEnum;
import com.epul.autolib.utilitaires.Vues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/vehicules")
@RestController
@CrossOrigin
public class VehiculeController extends BasicController<Station> {

    private final int nbVehiculesParPage = 15;

    private final VehiculeRepository vehiculeRepository;
    private final TypeVehiculeRepository typeVehiculeRepository;

    @Autowired
    VehiculeController(VehiculeRepository vehiculeRepository, TypeVehiculeRepository typeVehiculeRepository) {
        super(Station.class);
        this.vehiculeRepository = vehiculeRepository;
        this.typeVehiculeRepository = typeVehiculeRepository;
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
}
