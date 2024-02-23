package com.webApp.demo.dao;

import com.webApp.demo.entities.Excursion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExcursionRepository extends JpaRepository<Excursion, Long> {

}
