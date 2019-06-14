package com.epul.autolib.utilitaires;

public class Vues {

    public static final String LOGIN = "vues/formLogin";

    public static final String INDEX = "index";
    public static final String INDEX_RDR = "redirect:/";

    public static class Stations {
        public static final String LIST = "vues/stations/liste";
        public static final String CARTE = "vues/stations/carte";
    }

    public static class Vehicules {
        public static final String LIST = "vues/vehicules/liste";

        public static final String LIST_RDR = "redirect:/vehicules/liste";
    }

    public static class Reservations {
        public static final String LIST = "vues/reservations/liste";
        public static final String ADD = "vues/reservations/nouveau";
        public static final String UPDATE = "vues/reservations/modifier";

        public static final String LIST_RDR = "redirect:/reservations/liste";
    }

    public static class Erreur { // Devraient plus être utiles
        public static final String E404 = "vues/404";
        public static final String ERREUR = "vues/Erreur";
        public static final String WIP = "vues/workInProgress";
    }

    // ========== Anciens exemples ============

    public static class Adherents {
        public static final String LIST = "vues/adherents/listerAdherents";
        public static final String ADD = "vues/adherents/ajouterAdherent";
        public static final String UPDATE = "vues/adherents/modifierAdherent";

        public static final String LIST_RDR = "redirect:/adherents/liste";
    }

    public static class Oeuvres {
        public static final String LIST = "vues/oeuvres/listerOeuvres";
        public static final String ADD = "vues/oeuvres/ajouterOeuvre";
        public static final String UPDATE = "vues/oeuvres/modifierOeuvre";

        public static final String LIST_RDR = "redirect:/oeuvres/liste";
    }
}