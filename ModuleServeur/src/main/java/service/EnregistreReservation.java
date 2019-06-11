package service;

import com.epul.autolib.bo.Reservation;
import meserreurs.MonException;
import javax.persistence.*;

public class EnregistreReservation {

  // on décvlare un EntityManager
    private EntityManagerFactory factory;
    private  EntityManager entityManager;

    public  void insertionReservation(Reservation reservation) throws Exception, MonException {

       // On instancie l'entity Manager
        factory = Persistence.createEntityManagerFactory("PReservation");
        entityManager  = factory.createEntityManager();

        try {

            if (!entityManager.contains(reservation))
            {
                // On démarre une transaction
                entityManager.getTransaction().begin();
                entityManager.persist(reservation);
                entityManager.flush();
                // on valide la transacition
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

