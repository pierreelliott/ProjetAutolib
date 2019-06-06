package com.epul.autolib.repositories;

import com.epul.autolib.domains.Oeuvrevente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OeuvreventeRepository extends JpaRepository<Oeuvrevente, Integer> {
    Oeuvrevente findById(int id);
}
