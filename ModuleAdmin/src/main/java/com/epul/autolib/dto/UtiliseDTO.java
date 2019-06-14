package com.epul.autolib.dto;

import com.epul.autolib.bo.Borne;
import com.epul.autolib.bo.Client;
import com.epul.autolib.bo.Utilise;
import com.epul.autolib.bo.Vehicule;
import com.epul.autolib.utilitaires.Utils;

import javax.persistence.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

public class UtiliseDTO {
    private int id;
    private Vehicule vehicule;
    private Timestamp date;
    private Client client;
    private Borne borneDepart;
    private Borne borneArrivee;

    public UtiliseDTO() {

    }

    public UtiliseDTO(Utilise utilise) {
        this.id = utilise.getId();
        this.vehicule = utilise.getVehicule();
        this.date = utilise.getDate();
        this.client = utilise.getClient();
        this.borneDepart = utilise.getBorneDepart();
        this.borneArrivee = utilise.getBorneArrivee();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Borne getBorneDepart() {
        return borneDepart;
    }

    public void setBorneDepart(Borne borneDepart) {
        this.borneDepart = borneDepart;
    }

    public Borne getBorneArrivee() {
        return borneArrivee;
    }

    public void setBorneArrivee(Borne borneArrivee) {
        this.borneArrivee = borneArrivee;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }


    public String printVehicule() {
        return vehicule.getTypeVehicule().getTypeVehicule() + " (" + vehicule.getTypeVehicule().getCategorie() + ")";
    }

    public String printFormattedDate() {
        return Utils.FORMATTER.format(new Date(date.getTime()));
    }

    public boolean aDeposer() {
        return this.borneArrivee == null;
    }
}
