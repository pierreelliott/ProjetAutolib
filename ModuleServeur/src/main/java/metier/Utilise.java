package metier;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "utilise", schema = "autolib", catalog = "")
@IdClass(UtilisePK.class)
public class Utilise {
    private int vehicule;
//    private int client;
    private Timestamp date;
    private Client client;
    private Borne borneDepart;
    private Borne borneArrivee;

    @Id
    @Column(name = "Vehicule")
    public int getVehicule() {
        return vehicule;
    }

    public void setVehicule(int vehicule) {
        this.vehicule = vehicule;
    }

//    @Id
//    @Column(name = "Client")
//    public int getIdClient() {
//        return client;
//    }
//
//    public void setIdClient(int client) {
//        this.client = client;
//    }

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
        Utilise that = (Utilise) o;
        return vehicule == that.vehicule &&
//                client == that.client &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicule, client, date);
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
}
