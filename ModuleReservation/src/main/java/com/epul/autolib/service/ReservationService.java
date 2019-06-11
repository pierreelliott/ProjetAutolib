package com.epul.autolib.service;

import com.epul.autolib.dto.ReservationDTO;
import com.epul.autolib.meserreurs.MonException;
import org.springframework.stereotype.Service;
import javax.jms.*;
import javax.annotation.Resource;

@Service
public class ReservationService {

    @Resource(lookup = "java:jboss/exported/topic/DemandeReservationJmsTopic")
    private Topic topic;
    // On accède à l'EJB
    @Resource(mappedName = "java:/ConnectionFactory")
    private TopicConnectionFactory cf;

    /**
     * Envoi d'un `ReservationDTO` au Topic JMS
     * @param reservationDTO
     * @return
     */
    public boolean publier(ReservationDTO reservationDTO) {
        boolean ok = true;
        TopicConnection connection = null;

        // TODO Méthode pour nettoyer le DTO des objets non sérialisables
        reservationDTO.setVehicule(null);
        reservationDTO.setClient(null);
        reservationDTO.setStation(null);

        try {

            // On crée la connexion JMS , session, producteur et message;
            /*
             * connection = connectionFactory.createConnection(
             * System.getProperty("username", DEFAULT_USERNAME),
             * System.getProperty("password", DEFAULT_PASSWORD));
             */


            // Création Connection et Session JMS
            connection = cf.createTopicConnection();
            TopicSession session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
            // On crée le producteur utilisé pour envoyer un message
            TopicPublisher producer = session.createPublisher(topic);
            // On lance la connection
            connection.start();
            ObjectMessage message = session.createObjectMessage();
            message.setObject(reservationDTO);
            // On publie le message
            producer.publish(message);
            producer.close();
            session.close();
            connection.close();
        } catch (JMSException j) { // FIXME Les exceptions ne sont pas lancées pour le moment
            new Exception(j.getMessage());
            ok = false;
        } catch (Exception e) {
            new Exception(e.getMessage());
            ok = false;
        }
        return ok;
    }
}
