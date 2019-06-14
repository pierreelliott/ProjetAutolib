package com.epul.autolib.domains;

import com.epul.autolib.dto.ReservationDTOOld;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "reservation", schema = "baseoeuvre", catalog = "")
//@IdClass(EntityReservationPK.class)
public class Reservation {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "date_reservation", nullable = false)
    private Date dateReservation;

    @Basic
    @Column(name = "statut", nullable = false, length = 20)
    private String statut;

    @ManyToOne
    @JoinColumn(name = "id_oeuvrevente", referencedColumnName = "id_oeuvrevente")
    private Oeuvrevente oeuvre;

    @ManyToOne
    @JoinColumn(name = "id_adherent", referencedColumnName = "id_adherent")
    private Adherent adherent;

    public Reservation() {

    }

    public Reservation(ReservationDTOOld reservationDTOOld) {
        this.id = reservationDTOOld.getId();
        this.dateReservation = reservationDTOOld.getDateReservation();
        this.statut = reservationDTOOld.getStatut();
        this.adherent = reservationDTOOld.getAdherent();
        this.oeuvre = reservationDTOOld.getOeuvre();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return Objects.equals(oeuvre, that.oeuvre) &&
                Objects.equals(adherent, that.adherent) &&
                Objects.equals(dateReservation, that.dateReservation) &&
                Objects.equals(statut, that.statut);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oeuvre, adherent,
                dateReservation, statut);
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

    public ReservationDTOOld toDTO() {
        return new ReservationDTOOld(this);
    }
}
