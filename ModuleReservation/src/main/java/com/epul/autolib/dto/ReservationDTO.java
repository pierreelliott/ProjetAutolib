package com.epul.autolib.dto;

import com.epul.autolib.domains.Adherent;
import com.epul.autolib.domains.Oeuvrevente;
import com.epul.autolib.domains.Reservation;

import java.sql.Date;

public class ReservationDTO {

    private Integer id;
    private Integer idOeuvrevente;
    private Integer idAdherent;
    private Date dateReservation;
    private String statut;
    private Oeuvrevente oeuvre;
    private Adherent adherent;

    public ReservationDTO() {

    }

    public ReservationDTO(Reservation reservation) {
        this.id = reservation.getId();
        this.idAdherent = reservation.getAdherent().getId();
        this.idOeuvrevente = reservation.getOeuvre().getId();
        this.dateReservation = reservation.getDateReservation();
        this.statut = reservation.getStatut();
        this.adherent = reservation.getAdherent();
        this.oeuvre = reservation.getOeuvre();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdOeuvrevente() {
        return idOeuvrevente;
    }

    public void setIdOeuvrevente(Integer idOeuvrevente) {
        this.idOeuvrevente = idOeuvrevente;
    }

    public Integer getIdAdherent() {
        return idAdherent;
    }

    public void setIdAdherent(Integer idAdherent) {
        this.idAdherent = idAdherent;
    }

    public Date getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Oeuvrevente getOeuvre() {
        return oeuvre;
    }

    public void setOeuvre(Oeuvrevente oeuvre) {
        this.oeuvre = oeuvre;
    }

    public Adherent getAdherent() {
        return adherent;
    }

    public void setAdherent(Adherent adherent) {
        this.adherent = adherent;
    }
}
