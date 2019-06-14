package com.epul.autolib.bo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "utilise", schema = "autolib", catalog = "")
public class Utilise {
    private int id;
    private Vehicule vehicule;
    private Timestamp date;
    private Client client;
    private Borne borneDepart;
    private Borne borneArrivee;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "date")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utilise utilise = (Utilise) o;
        return id == utilise.id &&
                Objects.equals(vehicule, utilise.vehicule) &&
                Objects.equals(date, utilise.date) &&
                Objects.equals(client, utilise.client) &&
                Objects.equals(borneDepart, utilise.borneDepart) &&
                Objects.equals(borneArrivee, utilise.borneArrivee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, vehicule, date, client, borneDepart, borneArrivee);
    }

    @ManyToOne
    @JoinColumn(name = "Client", referencedColumnName = "idClient", nullable = false)
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @ManyToOne
    @JoinColumn(name = "borne_depart", referencedColumnName = "idBorne", nullable = false)
    public Borne getBorneDepart() {
        return borneDepart;
    }

    public void setBorneDepart(Borne borneDepart) {
        this.borneDepart = borneDepart;
    }

    @ManyToOne
    @JoinColumn(name = "borne_arrivee", referencedColumnName = "idBorne")
    public Borne getBorneArrivee() {
        return borneArrivee;
    }

    public void setBorneArrivee(Borne borneArrivee) {
        this.borneArrivee = borneArrivee;
    }

    @ManyToOne
    @JoinColumn(name = "Vehicule", referencedColumnName = "idVehicule", nullable = false)
    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }
}
