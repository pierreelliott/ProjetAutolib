package com.epul.autolib.controllers;


import com.epul.autolib.bo.Client;
import com.epul.autolib.meserreurs.MonException;
import com.epul.autolib.repositories.ClientRepository;
import com.epul.autolib.utilitaires.Utils;
import com.epul.autolib.utilitaires.Layout;
import com.epul.autolib.utilitaires.Vues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;

@RequestMapping("")
@RestController
@CrossOrigin
public class AuthentificationController extends BasicController<Client> {

    private final ClientRepository clientRepository;

    @Autowired
    public AuthentificationController(ClientRepository clientRepository) {
        super(Client.class);
        this.clientRepository = clientRepository;
    }

    @RequestMapping("/login")
    public ModelAndView pageLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        retrieveError(request);
        return new Layout(Vues.LOGIN);
    }

    @RequestMapping("/logout")
    public ModelAndView pageLogout(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        session.removeAttribute("id");
        return new Layout(Vues.INDEX_RDR);
    }

    @RequestMapping(method = RequestMethod.POST, value="/controleLogin")
    public ModelAndView controleLogin(HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {
        String destinationPage;
        {
            String login = request.getParameter("login");
            String pwd = request.getParameter("pwd");
            String message ="";
            try {

                Client client = clientRepository.findClientByLogin(login);
                if (client != null) {
                    try {
                        String pwdmd5 = Utils.md5(pwd);
                        if (client.getPassword().equals(pwdmd5)) {
                            HttpSession session = request.getSession();
                            session.setAttribute("id", client.getIdClient());
                            destinationPage = Vues.INDEX_RDR;
                        } else {
                            message = "mot de passe erroné";
                            request.setAttribute("message", message);
                            destinationPage = Vues.LOGIN;
                        }
                    } catch (NoSuchAlgorithmException e) {
                        request.setAttribute("MesErreurs", e.getMessage());
                        destinationPage = Vues.Erreur.ERREUR;
                    }
                } else {
                    message = "login erroné";
                    request.setAttribute("message", message);
                    destinationPage = Vues.LOGIN;
                }
            } catch (MonException e) {
                request.setAttribute("MesErreurs", e.getMessage());
                destinationPage = Vues.Erreur.ERREUR;
            }
        }
        return new Layout(destinationPage);
    }

    @RequestMapping("/inscription")
    public ModelAndView inscription(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return new Layout(Vues.Erreur.WIP);
    }

}
