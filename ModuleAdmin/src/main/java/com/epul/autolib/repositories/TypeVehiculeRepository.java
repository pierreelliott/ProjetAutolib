package com.epul.autolib.repositories;

import com.epul.autolib.bo.TypeVehicule;
import com.epul.autolib.bo.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Map;

public interface TypeVehiculeRepository extends JpaRepository<TypeVehicule, Integer> {

    int countVehiculesByTypeVehicule(TypeVehicule typeVehicule);
}
