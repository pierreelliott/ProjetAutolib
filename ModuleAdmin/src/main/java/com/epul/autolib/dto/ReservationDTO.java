package com.epul.autolib.dto;

import com.epul.autolib.bo.Client;
import com.epul.autolib.bo.Station;
import com.epul.autolib.bo.Vehicule;

import java.io.Serializable;
import java.sql.Timestamp;

public class ReservationDTO implements Serializable {
    private Integer idVehicule;
    private Integer idClient;
    private Timestamp dateReservation;
    private Timestamp dateEcheance;

    private Vehicule vehicule;
    private Station station;
    private Client client;

    public Integer getIdVehicule() {
        return idVehicule;
    }

    public void setIdVehicule(Integer idVehicule) {
        this.idVehicule = idVehicule;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public Timestamp getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(Timestamp dateReservation) {
        this.dateReservation = dateReservation;
    }

    public Timestamp getDateEcheance() {
        return dateEcheance;
    }

    public void setDateEcheance(Timestamp dateEcheance) {
        this.dateEcheance = dateEcheance;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
