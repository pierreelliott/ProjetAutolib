package com.epul.autolib.bo;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "reservation", schema = "autolib", catalog = "")
public class Reservation implements Serializable {
    private int id;
    private Timestamp dateReservation;
    private Timestamp dateEcheance;
    private Client client;
    private Vehicule vehicule;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "date_reservation")
    public Timestamp getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(Timestamp dateReservation) {
        this.dateReservation = dateReservation;
    }

    @Basic
    @Column(name = "date_echeance")
    public Timestamp getDateEcheance() {
        return dateEcheance;
    }

    public void setDateEcheance(Timestamp dateEcheance) {
        this.dateEcheance = dateEcheance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return id == that.id &&
                Objects.equals(dateReservation, that.dateReservation) &&
                Objects.equals(dateEcheance, that.dateEcheance) &&
                Objects.equals(client, that.client) &&
                Objects.equals(vehicule, that.vehicule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicule, client, dateReservation, dateEcheance);
    }

    @ManyToOne
    @JoinColumn(name = "client", referencedColumnName = "idClient", nullable = false)
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @ManyToOne
    @JoinColumn(name = "vehicule", referencedColumnName = "idVehicule", nullable = false)
    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehiculeObject) {
        this.vehicule = vehiculeObject;
    }
}
