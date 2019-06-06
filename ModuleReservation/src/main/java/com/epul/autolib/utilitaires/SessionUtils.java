package com.epul.autolib.utilitaires;

import com.epul.autolib.bo.Client;
import com.epul.autolib.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class SessionUtils {

    public static final String ID_CLIENT = "id_client";

    private static Integer idClient;
    private static Client client;

    @Autowired
    private static ClientRepository clientRepository;

    /**
     * Retourne l'id client enregistré dans la session ou -1 s'il n'y en a pas
     * @param request
     * @return
     */
    public static int getIdClient(HttpServletRequest request) {
        if(idClient == null) {
            // Récupère ID depuis la session
            Object id = request.getSession().getAttribute(ID_CLIENT);
            try {
                idClient = Integer.parseInt((String) id);
            } catch (Exception e) {
                return -1;
            }
        }
        return idClient;
    }

    public static Client getClient(HttpServletRequest request) {
        if(client == null) {
            int id = getIdClient(request);
            clientRepository.findById(id).ifPresent(clientBD -> client = clientBD);
        }
        return client;
    }
}
