package com.webApp.demo.dao;

import com.webApp.demo.entities.Division;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DivisionRepository extends JpaRepository<Division, Long> {

}
