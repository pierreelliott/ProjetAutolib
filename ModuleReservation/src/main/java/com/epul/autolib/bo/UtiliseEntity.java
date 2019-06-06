package com.epul.autolib.bo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "utilise", schema = "autolib", catalog = "")
@IdClass(UtiliseEntityPK.class)
public class UtiliseEntity {
    private int vehicule;
    private int client;
    private Timestamp date;
    private ClientEntity clientByClient;
    private BorneEntity borneByBorneDepart;
    private BorneEntity borneByBorneArrivee;

    @Id
    @Column(name = "Vehicule")
    public int getVehicule() {
        return vehicule;
    }

    public void setVehicule(int vehicule) {
        this.vehicule = vehicule;
    }

    @Id
    @Column(name = "Client")
    public int getClient() {
        return client;
    }

    public void setClient(int client) {
        this.client = client;
    }

    @Id
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
        UtiliseEntity that = (UtiliseEntity) o;
        return vehicule == that.vehicule &&
                client == that.client &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicule, client, date);
    }

    @ManyToOne
    @JoinColumn(name = "Client", referencedColumnName = "idClient", nullable = false)
    public ClientEntity getClientByClient() {
        return clientByClient;
    }

    public void setClientByClient(ClientEntity clientByClient) {
        this.clientByClient = clientByClient;
    }

    @ManyToOne
    @JoinColumn(name = "borne_depart", referencedColumnName = "idBorne", nullable = false)
    public BorneEntity getBorneByBorneDepart() {
        return borneByBorneDepart;
    }

    public void setBorneByBorneDepart(BorneEntity borneByBorneDepart) {
        this.borneByBorneDepart = borneByBorneDepart;
    }

    @ManyToOne
    @JoinColumn(name = "borne_arrivee", referencedColumnName = "idBorne")
    public BorneEntity getBorneByBorneArrivee() {
        return borneByBorneArrivee;
    }

    public void setBorneByBorneArrivee(BorneEntity borneByBorneArrivee) {
        this.borneByBorneArrivee = borneByBorneArrivee;
    }
}
