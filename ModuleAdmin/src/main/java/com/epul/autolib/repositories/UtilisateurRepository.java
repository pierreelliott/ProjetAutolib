package com.epul.autolib.repositories;

import com.epul.autolib.domains.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer>  {

    Utilisateur findById(int id);

    Utilisateur getEntityUtilisateurByNomUtil(String login);

}

