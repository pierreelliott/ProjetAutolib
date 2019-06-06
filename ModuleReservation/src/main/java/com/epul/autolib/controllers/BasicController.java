package com.epul.autolib.controllers;

import com.epul.autolib.utilitaires.VuesAlt;

import javax.servlet.http.HttpServletRequest;

public class BasicController<T> {

    private Class<T> classe;

    protected final String LIST;
    protected final String ADD;
    protected final String UPDATE;
    protected final String LIST_RDR;
    protected final String ADD_RDR;
    protected final String UPDATE_RDR;

    BasicController(Class<T> classe) {
        this.classe = classe;

        LIST = VuesAlt.LIST(classe);
        ADD = VuesAlt.ADD(classe);
        UPDATE = VuesAlt.UPDATE(classe);
        LIST_RDR = VuesAlt.LIST_RDR(classe);
        ADD_RDR = VuesAlt.ADD_RDR(classe);
        UPDATE_RDR = VuesAlt.UPDATE_RDR(classe);
    }

    Object retrieveError(HttpServletRequest request) {
        Object error = request.getSession().getAttribute("erreur");
        request.getSession().removeAttribute("erreur");
        request.setAttribute("erreur", error);
        return error;
    }
}
