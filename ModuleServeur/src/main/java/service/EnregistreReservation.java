package service;

import com.epul.autolib.bo.Client;
import com.epul.autolib.bo.Reservation;
import com.epul.autolib.bo.Vehicule;
import com.epul.autolib.dto.ReservationDTO;
import meserreurs.MonException;
import utils.EtatVehiculeEnum;

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
            Reservation reservationEntity = createEntityFromDTO(reservation);

            doInsert(reservationEntity);
            updateVehicule(reservationEntity);

            entityManager.close();

        } catch (EntityNotFoundException h) {
            throw new MonException("Erreur d'insertion", h.getMessage());
        } catch (Exception e) {
            throw new MonException("Erreur d'insertion", e.getMessage());
        }
    }

    private Reservation createEntityFromDTO(ReservationDTO reservationDTO) {
        Reservation reservationEntity = new Reservation();

        // on tansfère les données reçues dans l'objet Entity
        reservationEntity.setDateEcheance(reservationDTO.getDateEcheance());
        reservationEntity.setDateReservation(reservationDTO.getDateReservation());

        Client client = entityManager.find(Client.class, reservationDTO.getIdClient());
        reservationEntity.setClient(client);

        Vehicule vehicule = entityManager.find(Vehicule.class, reservationDTO.getIdVehicule());
        reservationEntity.setVehicule(vehicule);

        return reservationEntity;
    }

    private void doInsert(Reservation reservation) {
        if (!entityManager.contains(reservation)) {
            // On démarre une transaction
            entityManager.getTransaction().begin();
            entityManager.persist(reservation);
            entityManager.flush();
            // on valide la transaction
            entityManager.getTransaction().commit();
        }
    }

    private void updateVehicule(Reservation reservation) {
        // Update disponibilité du véhicule
        Vehicule vehicule = reservation.getVehicule();
        vehicule.setDisponibilite(EtatVehiculeEnum.RESERVE.name());

        entityManager.getTransaction().begin();
        entityManager.persist(vehicule);
        entityManager.flush();
        // on valide la transaction
        entityManager.getTransaction().commit();
    }
}

