package service;

import com.epul.autolib.bo.Client;
import com.epul.autolib.bo.Reservation;
import com.epul.autolib.dto.ReservationDTO;
import meserreurs.MonException;
import javax.persistence.*;

public class EnregistreReservation {

  // on décvlare un EntityManager
    private EntityManagerFactory factory;
    private  EntityManager entityManager;

    public  void insertionReservation(ReservationDTO reservation) throws Exception, MonException {

       // On instancie l'entity Manager
        factory = Persistence.createEntityManagerFactory("PReservation");
        entityManager  = factory.createEntityManager();

        try {
            // on construit un objet Entity
            Reservation reservationEntity = new Reservation();

            // on tansfère les données reçues dans l'objet Entity
            reservationEntity.setVehicule(reservation.getIdVehicule());
            reservationEntity.setDateEcheance(reservation.getDateEcheance());
            reservationEntity.setDateReservation(reservation.getDateReservation());

            Client client = new Client();
            client.setIdClient(reservation.getIdClient());
            client = entityManager.find(Client.class, client);
            reservationEntity.setClient(client);
            // FIXME EntityManager râle comme quoi il arrive pas à trouver le "persister" de Client
            // -> Idée : Passer en Springboot
            // -> Ou : Utiliser les Query d'Hibernate (mais ça pue la merde)

            if (!entityManager.contains(reservationEntity)) {
                // On démarre une transaction
                entityManager.getTransaction().begin();
                entityManager.persist(reservationEntity);
                entityManager.flush();
                // on valide la transaction
                entityManager.getTransaction().commit();
            }
            entityManager.close();

        } catch (EntityNotFoundException h) {
            new MonException("Erreur d'insertion", h.getMessage());
        } catch (Exception e) {
            new MonException("Erreur d'insertion", e.getMessage());
        }
    }
}

