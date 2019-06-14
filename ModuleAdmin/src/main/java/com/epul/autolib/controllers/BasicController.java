package com.epul.autolib.controllers;

import javax.servlet.http.HttpServletRequest;

public class BasicController<T> {

    private Class<T> classe;

    BasicController(Class<T> classe) {
        this.classe = classe;
    }

    Object retrieveError(HttpServletRequest request) {
        Object error = request.getSession().getAttribute("erreur");
        request.getSession().removeAttribute("erreur");
        request.setAttribute("erreur", error);

        Object message = request.getSession().getAttribute("message");
        request.getSession().removeAttribute("message");
        request.setAttribute("message", message);
        return error;
    }
}
