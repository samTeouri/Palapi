package com.tp_spring.palapi.application.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.tp_spring.palapi.application.dto.PalDTO;
import com.tp_spring.palapi.domain.Pal;
import com.tp_spring.palapi.domain.Skill;
import com.tp_spring.palapi.infrastructure.repository.PalRepository;
import com.tp_spring.palapi.infrastructure.tools.DTOMapper;

@Service
public class PalService {

    private PalRepository palRepository;

    public PalService(PalRepository _palRepository) {
        this.palRepository = _palRepository;
    }

    public List<PalDTO> getAllPals() {
        return palRepository.findAll().stream()
                .map(pal -> DTOMapper.mapToDTO(pal))
                .collect(Collectors.toList());
    }

    public PalDTO getPalById(Long id) {
        Pal pal = palRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pal not found"));
        return DTOMapper.mapToDTO(pal);
    }

    public List<PalDTO> getPalByName(String name) {
        return palRepository.findByName(name).stream()
                .map(pal -> DTOMapper.mapToDTO(pal))
                .collect(Collectors.toList());
    }

    public List<PalDTO> getPalByTypes(List<String> types) {
        return palRepository.findByTypes(types).stream()
                .map(pal -> DTOMapper.mapToDTO(pal))
                .collect(Collectors.toList());
    }

    public Pal createPal(Pal pal) {
        return palRepository.save(pal);
    }

    public List<Skill> getPalSkills(Pal pal) {
        return pal.getSkills();
    }

    public void AddPalSkill(Pal pal, Skill skill){
        pal.getSkills().add(skill);
    }

    public void updatePalSkill(Pal pal, Skill oldSkill, Skill newSkill) {
        List<Skill> skills = pal.getSkills();
        int index = skills.indexOf(oldSkill);
    
        if (index != -1) {
            skills.set(index, newSkill);
        } else {
            throw new IllegalArgumentException("Skill not found in the Pal's skill list.");
        }
    }
    
    public void updatePalSkillAndSave(Pal pal, Skill oldSkill, Skill newSkill) {
        updatePalSkill(pal, oldSkill, newSkill);
        palRepository.save(pal);
    }
    

    public List<String> getPalTypes(Pal pal){
        return pal.getTypes();
    }

    public void AddPalType(Pal pal, String type){   
        pal.getTypes().add(type);
    }

    public void RemovePalType(Pal pal, String type){
            pal.getTypes().remove(type);
    }

    public List<Pal> getAllPalsSortedByPrice() {
        return palRepository.findAllSortedByPrice();
    }

    public List<Pal> getAllPalsSortedByRarity() {
        return palRepository.findAllSortedByRarity();
    }    
    
}
