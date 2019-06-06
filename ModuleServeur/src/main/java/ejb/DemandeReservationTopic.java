package ejb;

import dto.ReservationDTO;
import meserreurs.MonException;
import metier.*;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.naming.NamingException;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import service.EnregistreReservation;

/**
 * Message-Driven Bean implementation class for: DemandeReservationTopic
 */
// On se connecte à la file d'attente InscriptionTopic
@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:jboss/exported/topic/DemandeReservationJmsTopic"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")}, mappedName = "DemandeReservationJmsTopic")
public class DemandeReservationTopic implements MessageListener {

    @Resource
    private MessageDrivenContext context;

    /*
     * Default constructor.
     */
    public DemandeReservationTopic() {
    }

    /**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) { // TODO Faire les vérifications sur la réservation ici aussi ?
        boolean ok = false;
        // On gère le message récupéré dans le topic
        try {
            // On transforme le message en demande de réservation
            if (message != null) {
                System.out.println("Message valide");
                ObjectMessage objectMessage = (ObjectMessage) message;

                ReservationDTO reservation = (ReservationDTO) objectMessage.getObject();
                // On insère cette demande d'inscription dans la base de données
                // on s'assure que l'écriture ne se fera qu'une fois.
                message = null;
                try {
                    // on construit un objet Entity
                    Reservation reservationEntity = new Reservation();

                    // on tansfère les données reçues dans l'objet Entity
                    reservationEntity.setClient(reservation.getClient());
                    reservationEntity.setVehicule(reservation.getIdVehicule());
                    reservationEntity.setDateEcheance(reservation.getDateEcheance());
                    reservationEntity.setDateReservation(reservation.getDateReservation());

                    EnregistreReservation uneE = new EnregistreReservation();
                    uneE.insertionReservation(reservationEntity);
                } catch (NamingException er) {
                    printError(er.getMessage());
                } catch (MonException e) {
                    printError(e.getMessage());
                } catch (Exception ex) {
                    printError(ex.getMessage());
                }
            }

        } catch (JMSException jmse) {
            System.out.println(jmse.getMessage());
            printError(jmse.getMessage());
            context.setRollbackOnly();
        }
    }

    /**
     * Permet d'enregistrer une erreur dans un fichier log
     *
     * @param message Le message d'erreur
     */
    public void printError(String message) {
        BufferedWriter wr;
        String nomf = "erreurs.log";
        Date madate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy hh:mm");
        try {
            // On écrit à la fin du fichier
            wr = new BufferedWriter(new FileWriter(nomf, true));
            wr.newLine();
            wr.write(sdf.format(madate));
            wr.newLine();
            wr.write(message);
            wr.close();
        } catch (FileNotFoundException ef) {
            ;
        } catch (IOException eio) {
            ;
        }
    }
}
