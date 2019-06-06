package com.epul.autolib.controllers;


import com.epul.autolib.domains.Utilisateur;
import com.epul.autolib.meserreurs.MonException;
import com.epul.autolib.repositories.UtilisateurRepository;
import com.epul.autolib.utilitaires.FonctionsUtiles;
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
public class AuthentificationController {

    private final UtilisateurRepository utilisateurRepository;

    @Autowired
    public AuthentificationController(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @RequestMapping("/login")
    public ModelAndView pageLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return new Layout(Vues.LOGIN);
    }

    @RequestMapping(value = "logout")
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

                Utilisateur unUtilisateur;
                unUtilisateur = utilisateurRepository.getEntityUtilisateurByNomUtil(login);
                if (unUtilisateur != null)
                {
                    try {
                        String pwdmd5 = FonctionsUtiles.md5(pwd);
                        if (unUtilisateur.getMotPasse().equals(pwdmd5)) {
                            HttpSession session = request.getSession();
                            session.setAttribute("id", unUtilisateur.getId());
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

}
