package com.tp_spring.palapi.application.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.tp_spring.palapi.application.dto.PalDTO;
import com.tp_spring.palapi.domain.Pal;
import com.tp_spring.palapi.domain.Skill;
import com.tp_spring.palapi.infrastructure.repository.PalRepository;
import com.tp_spring.palapi.infrastructure.repository.SkillRepository;
import com.tp_spring.palapi.infrastructure.tools.DTOMapper;

@Service
public class PalService {

    private PalRepository palRepository;
    private SkillRepository skillRepository;

    public PalService(PalRepository _palRepository,SkillRepository _skillRepository) {
        this.palRepository = _palRepository;
        this.skillRepository = _skillRepository;
    }

    public List<PalDTO> getAllPals() {
        return palRepository.findAll().stream()
                .map(pal -> DTOMapper.mapToDTO(pal))
                .collect(Collectors.toList());
    }

    public PalDTO getPalById(int id) {
        Pal pal = palRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pal not found"));
        return DTOMapper.mapToDTO(pal);
    }

    public List<PalDTO> getPalsByName(String name) {
        return palRepository.findByName(name).stream()
                .map(pal -> DTOMapper.mapToDTO(pal))
                .collect(Collectors.toList());
    }

    public List<PalDTO> getPalsByType(String type) {
        return palRepository.findByType(type).stream()
                .map(pal -> DTOMapper.mapToDTO(pal))
                .collect(Collectors.toList());
    }

    public PalDTO createPal(PalDTO palDTO) {
        Pal pal = DTOMapper.mapToEntity(palDTO);
        palRepository.save(pal);
        return palDTO;
    }

    public List<Skill> getPalSkills(Pal pal) {
        return pal.getSkills();
    }

    public Skill addSkillToPal(int palId, Skill skill) {
        Pal pal = palRepository.findById(palId)
                .orElseThrow(() -> new RuntimeException("Pal not found with ID: " + palId));

        skillRepository.save(skill); // Sauvegarde initiale pour générer un ID

        pal.getSkills().add(skill);
        palRepository.save(pal);

        return skill;
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
    

    public List<String> getPalTypes(Pal pal){
        return pal.getTypes();
    }

    public Pal addTypeToPal(int palId, String type) {
        Pal pal = palRepository.findById(palId)
                .orElseThrow(() -> new RuntimeException("Pal not found with ID: " + palId));
    
        if (!pal.getTypes().contains(type)) {
            pal.getTypes().add(type);
            palRepository.save(pal);
        }
    
        return pal;
    }

    public Pal removeTypeFromPal(int palId, String type) {
        Pal pal = palRepository.findById(palId).orElseThrow(() -> new RuntimeException("Pal not found with ID: " + palId));
    
        
        int typeIndex = pal.getTypes().indexOf(type);
        pal.getTypes().remove(typeIndex);
        palRepository.save(pal);
    
        return pal;
    }

    public List<Pal> getAllPalsSortedByPrice() {
        return palRepository.findAllSortedByPrice();
    }

    public List<Pal> getAllPalsSortedByRarity() {
        return palRepository.findAllSortedByRarity();
    }

    public List<String> getPalTypes(int palId) {
        Pal pal = palRepository.findById(palId)
                .orElseThrow(() -> new RuntimeException("Pal not found with ID: " + palId));
        return pal.getTypes();
    }
    
    public Skill updateSkillOfPal(int palId, int skillId, Skill updatedSkill) {
        Pal pal = palRepository.findById(palId)
                .orElseThrow(() -> new RuntimeException("Pal not found with ID: " + palId));
        
        Skill existingSkill = pal.getSkills().stream()
            .filter(skill -> skill.getId() == skillId)
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Skill not found with ID: " + skillId));
    
        // Mise à jour des propriétés
        existingSkill.setName(updatedSkill.getName());
        existingSkill.setLevel(updatedSkill.getLevel());
        existingSkill.setType(updatedSkill.getType());
        existingSkill.setCooldown(updatedSkill.getCooldown());
        existingSkill.setPower(updatedSkill.getPower());
        existingSkill.setDescription(updatedSkill.getDescription());
    
        // Sauvegarde dans le repository
        skillRepository.save(existingSkill);
        return existingSkill;
    }
    
}
