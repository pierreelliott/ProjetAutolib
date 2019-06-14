package com.epul.autolib.dto;

import com.epul.autolib.bo.Client;
import com.epul.autolib.bo.Reservation;
import com.epul.autolib.bo.Station;
import com.epul.autolib.bo.Vehicule;
import utils.Utils;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class ReservationDTO implements Serializable {
    private int id;

    private Integer idVehicule;
    private Integer idClient;
    private Timestamp dateReservation;
    private Timestamp dateEcheance;

    private Vehicule vehicule;
    private Station station;
    private Client client;

    public ReservationDTO() {

    }

    public ReservationDTO(Reservation reservation) {
        this.id = reservation.getId();
        this.vehicule = reservation.getVehicule();
        this.client = reservation.getClient();
        this.dateReservation = reservation.getDateReservation();
        this.dateEcheance = reservation.getDateEcheance();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String printVehicule() {
        return vehicule.getTypeVehicule().getTypeVehicule() + " (" + vehicule.getTypeVehicule().getCategorie() + ")";
    }

    public String printFormattedDateReservation() {
        return Utils.FORMATTER.format(new Date(dateReservation.getTime()));
    }

    public boolean echeanceDepassee() {
        return new Date(dateEcheance.getTime()).before(new Date());
    }
}
