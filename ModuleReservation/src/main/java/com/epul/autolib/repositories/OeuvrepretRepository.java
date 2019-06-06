package com.epul.autolib.repositories;

import com.epul.autolib.domains.Oeuvrepret;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OeuvrepretRepository extends JpaRepository<Oeuvrepret, Integer> {

}
