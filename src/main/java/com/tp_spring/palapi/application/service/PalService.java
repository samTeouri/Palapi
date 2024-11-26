package com.tp_spring.palapi.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tp_spring.palapi.domain.Pal;
import com.tp_spring.palapi.domain.Skill;
import com.tp_spring.palapi.infrastructure.repository.PalRepository;

@Service
public class PalService {

    private PalRepository palRepository;

    @Autowired
    public PalService(PalRepository _palRepository) {
        this.palRepository = _palRepository;
    }

    public List<Pal> getAllPals() {
        return palRepository.findAll();
    }

    public Optional<Pal> getPalById(Long id) {
        return palRepository.findById(id);
    }

    public List<Pal> getPalByName(String name) {
        return palRepository.findByName(name);
    }

    public List<Pal> getPalByTypes(List<String> types) {
        return palRepository.findByTypes(types);
    }

    public Pal createPal(Pal pal) {
        return palRepository.save(pal);
    }

    public List<Skill> getPalSkills(Pal pal) {
        return pal.getSkills();
    }

}
