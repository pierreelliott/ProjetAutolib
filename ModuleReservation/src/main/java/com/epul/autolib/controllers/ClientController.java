package com.epul.autolib.controllers;

import com.epul.autolib.bo.Client;
import com.epul.autolib.repositories.ClientRepository;
import com.epul.autolib.utilitaires.Vues;
import com.epul.autolib.utilitaires.Layout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@RequestMapping("/clients")
@Controller
@CrossOrigin
public class ClientController extends BasicController<Client> {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientController(ClientRepository clientRepository) {
        super(Client.class);
        this.clientRepository = clientRepository;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/liste")
    public ModelAndView lister(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage;
        List<Client> list = null;
        try {
            retrieveError(request);

            list = clientRepository.findAll();
            request.setAttribute("listeClient", list);
            destinationPage = Vues.Clients.LIST;
        } catch (Exception e) {
            request.setAttribute("MesErreurs", e.getMessage());
            destinationPage = Vues.Erreur.ERREUR;
        }
        return new Layout(destinationPage);
    }
}

