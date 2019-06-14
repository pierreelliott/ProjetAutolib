package com.epul.autolib.repositories;


import com.epul.autolib.domains.Adherent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdherentRepository extends JpaRepository<Adherent, Integer> {

}

