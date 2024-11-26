package com.tp_spring.palapi.infrastructure.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tp_spring.palapi.domain.Pal;

@Repository
public interface PalRepository extends JpaRepository<Pal, Long> {
    List<Pal> findByName(String name);
    List<Pal> findByType(String type);
}
