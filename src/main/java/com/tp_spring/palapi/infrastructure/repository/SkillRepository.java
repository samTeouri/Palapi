package com.tp_spring.palapi.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tp_spring.palapi.domain.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
}
