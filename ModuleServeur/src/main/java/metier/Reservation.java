package metier;

import dto.ReservationDTO;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "reservation", schema = "autolib")
@IdClass(ReservationPK.class)
public class Reservation {
    private int vehicule;
//    private int client;
    private Timestamp dateReservation;
    private Timestamp dateEcheance;
    private Client client;

    public Reservation() {

    }

    public Reservation(ReservationDTO reservationDTO) {
        this.vehicule = reservationDTO.getIdVehicule();
        this.dateReservation = reservationDTO.getDateReservation();
        this.dateEcheance = reservationDTO.getDateEcheance();
        this.client = reservationDTO.getClient();
    }

    @Id
    @Column(name = "vehicule")
    public int getVehicule() {
        return vehicule;
    }

    public void setVehicule(int vehicule) {
        this.vehicule = vehicule;
    }

//    @Id
//    @Column(name = "client", insertable = false, updatable = false)
//    public int getIdClient() {
//        return client;
//    }
//
//    public void setIdClient(int client) {
//        this.client = client;
//    }

    @Id
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
        return vehicule == that.vehicule &&
//                client == that.client &&
                Objects.equals(dateReservation, that.dateReservation) &&
                Objects.equals(dateEcheance, that.dateEcheance);
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
}
