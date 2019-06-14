package com.epul.autolib.repositories;

import com.epul.autolib.bo.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Vehicule, Integer> {
}
