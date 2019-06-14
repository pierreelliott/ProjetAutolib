package com.epul.autolib.repositories;

import com.epul.autolib.bo.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    List<Reservation> findAllByClient_IdClient(int client_idClient);


}
