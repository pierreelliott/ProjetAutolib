package com.epul.autolib.controllers;


import com.epul.autolib.utilitaires.Layout;
import com.epul.autolib.utilitaires.Vues;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping("")
@Controller
@CrossOrigin
public class DefaultController implements ErrorController {

    @RequestMapping("/")
    public ModelAndView pageIndex(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return new Layout(Vues.INDEX);
    }

    @RequestMapping("/accueil")
    public ModelAndView pageAccueil(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return new Layout(Vues.INDEX_RDR);
    }

    @RequestMapping("/404/*")
    public ModelAndView erreur404(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return new Layout(Vues.Erreur.E404);
    }

    @RequestMapping("/error")
    public ModelAndView erreur(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return new Layout(Vues.Erreur.E404);
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
