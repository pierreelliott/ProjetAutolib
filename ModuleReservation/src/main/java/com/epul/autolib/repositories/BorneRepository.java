package com.epul.autolib.repositories;

import com.epul.autolib.bo.Borne;
import com.epul.autolib.bo.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorneRepository extends JpaRepository<Borne, Integer> {

    Borne findBorneByVehicule(Vehicule vehicule);
}
