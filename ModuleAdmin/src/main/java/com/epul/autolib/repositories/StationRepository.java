package com.epul.autolib.repositories;

import com.epul.autolib.bo.Station;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepository extends JpaRepository<Station, Integer> {
}
