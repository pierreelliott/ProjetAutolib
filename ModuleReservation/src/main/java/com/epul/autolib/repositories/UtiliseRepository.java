package com.epul.autolib.repositories;

import com.epul.autolib.bo.Utilise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtiliseRepository extends JpaRepository<Utilise, Integer> {

    List<Utilise> findAllByClient_IdClient(int client_idClient);

    List<Utilise> findAllByClient_IdClientAndBorneArrivee_EtatBorne(int client_idClient, boolean borneArrivee_etatBorne);
}
