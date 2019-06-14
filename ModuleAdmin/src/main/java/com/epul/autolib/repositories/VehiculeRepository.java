package com.epul.autolib.repositories;

import com.epul.autolib.bo.TypeVehicule;
import com.epul.autolib.bo.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculeRepository extends JpaRepository<Vehicule, Integer> {

    int countVehiculesByTypeVehiculeAndDisponibilite(TypeVehicule typeVehicule, String disponibilite);
}
