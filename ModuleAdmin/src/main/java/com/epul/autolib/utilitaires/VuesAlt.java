package com.epul.autolib.utilitaires;

import com.epul.autolib.domains.Adherent;
import com.epul.autolib.domains.Oeuvrevente;
import com.epul.autolib.domains.Reservation;

import java.util.HashMap;
import java.util.Map;

public class VuesAlt {

    private static final Map<Class, Map<String, String>> map = new HashMap<>();

    static {
        // TODO Utiliser les annotations pour déterminer les PATHS des JSP

        map.put(Adherent.class, new HashMap<>());
        map.get(Adherent.class).put("LIST", "vues/adherents/listerAdherents");
        map.get(Adherent.class).put("ADD", "vues/adherents/ajouterAdherent");
        map.get(Adherent.class).put("UPDATE", "vues/adherents/modifierAdherent");
        map.get(Adherent.class).put("LIST_RDR", "redirect:/adherents/liste");
        map.get(Adherent.class).put("ADD_RDR", "redirect:/adherents/nouveau");
        map.get(Adherent.class).put("UPDATE_RDR", "redirect:/adherents/modifier/");

        map.put(Oeuvrevente.class, new HashMap<>());
        map.get(Oeuvrevente.class).put("LIST", "vues/oeuvres/listerOeuvres");
        map.get(Oeuvrevente.class).put("ADD", "vues/oeuvres/ajouterOeuvre");
        map.get(Oeuvrevente.class).put("UPDATE", "vues/oeuvres/modifierOeuvre");
        map.get(Oeuvrevente.class).put("LIST_RDR", "redirect:/oeuvres/liste");
        map.get(Oeuvrevente.class).put("ADD_RDR", "redirect:/oeuvres/nouveau");
        map.get(Oeuvrevente.class).put("UPDATE_RDR", "redirect:/oeuvres/modifier/");

        map.put(Reservation.class, new HashMap<>());
        map.get(Reservation.class).put("LIST", "vues/reservations/listerReservations");
        map.get(Reservation.class).put("ADD", "vues/reservations/ajouterReservation");
        map.get(Reservation.class).put("UPDATE", "vues/reservations/modifierReservation");
        map.get(Reservation.class).put("LIST_RDR", "redirect:/reservations/liste");
        map.get(Reservation.class).put("ADD_RDR", "redirect:/reservations/nouveau");
        map.get(Reservation.class).put("UPDATE_RDR", "redirect:/reservations/modifier/");
    }

    private static String error = "vues/404";

    public static String LIST(Class classe) {
        return map.getOrDefault(classe, new HashMap<>()).getOrDefault("LIST", error);
    }

    public static String ADD(Class classe) {
        return map.getOrDefault(classe, new HashMap<>()).getOrDefault("ADD", error);
    }

    public static String UPDATE(Class classe) {
        return map.getOrDefault(classe, new HashMap<>()).getOrDefault("UPDATE", error);
    }

    public static String LIST_RDR(Class classe) {
        return map.getOrDefault(classe, new HashMap<>()).getOrDefault("LIST_RDR", error);
    }

    public static String ADD_RDR(Class classe) {
        return map.getOrDefault(classe, new HashMap<>()).getOrDefault("ADD_RDR", error);
    }

    public static String UPDATE_RDR(Class classe) {
        return map.getOrDefault(classe, new HashMap<>()).getOrDefault("UPDATE_RDR", error);
    }

    public static final String LOGIN = "vues/formLogin";

    public static final String INDEX = "index";
    public static final String INDEX_RDR = "redirect:/";

    public static class Erreur { // Devraient plus être utiles
        public static final String E404 = "vues/404";
        public static final String ERREUR = "vues/Erreur";
    }
}