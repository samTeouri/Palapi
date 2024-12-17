package com.tp_spring.palapi.web;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tp_spring.palapi.application.dto.PalDTO;
import com.tp_spring.palapi.application.service.PalService;
import com.tp_spring.palapi.domain.Pal;
import com.tp_spring.palapi.domain.Skill;
import com.tp_spring.palapi.infrastructure.tools.DTOMapper;

@RestController
@RequestMapping("/api/pals")
public class PalController {

    private final PalService palService;

    public PalController(PalService palService) {
        this.palService = palService;
    }


    @GetMapping
    public ResponseEntity<List<PalDTO>> getAllPals() {
        return ResponseEntity.ok(palService.getAllPals());
    }

    //get pal par id
    @GetMapping("/{id}")
    public ResponseEntity<PalDTO> getPalById(@PathVariable Long id) {
        return ResponseEntity.ok(palService.getPalById(id));
    }

    //get pal par name
    @GetMapping("/name/{name}")
    public ResponseEntity<List<PalDTO>> getPalsByName(@PathVariable String name) {
        return ResponseEntity.ok(palService.getPalsByName(name));
    }

    //get pals par type (a coriger)
    @GetMapping("/type/{type}")
public ResponseEntity<List<PalDTO>> getPalsByType(@PathVariable String type) {
    List<PalDTO> palDTOs = palService.getPalsByType(type);  // Appel à la méthode du service
    return ResponseEntity.ok(palDTOs);
}

    //save new pal
    @PostMapping
    public ResponseEntity<PalDTO> createPal(@RequestBody PalDTO palDTO) {
        return ResponseEntity.ok(palService.createPal(palDTO));
    }

    //get skill pal
    @GetMapping("/{id}/skills")
    public ResponseEntity<List<Skill>> getPalSkills(@PathVariable Long id) {
    Pal pal = DTOMapper.mapToEntity(palService.getPalById(id));
    return ResponseEntity.ok(palService.getPalSkills(pal));
    }

    //a corriger
    @GetMapping("/sorted/price")
    public ResponseEntity<List<Pal>> getAllPalsSortedByPrice() {
        return ResponseEntity.ok(palService.getAllPalsSortedByPrice());
    }

    //a corriger
    @GetMapping("/sorted/rarity")
    public ResponseEntity<List<PalDTO>> getAllPalsSortedByRarity() {
    List<Pal> pals = palService.getAllPalsSortedByRarity();
    List<PalDTO> palDTOs = pals.stream()
                               .map(DTOMapper::mapToDTO)
                               .collect(Collectors.toList());
    return ResponseEntity.ok(palDTOs);
}

    
    //add skill a un pal
    @PostMapping("/{id}/skill")
    public ResponseEntity<Skill> addSkillToPal(@PathVariable Long id, @RequestBody Skill skill) {
        Skill addedSkill = palService.addSkillToPal(id, skill);
        return ResponseEntity.ok(addedSkill);
    }

    //add types d'un pal
    @PostMapping("/{id}/type")
    public ResponseEntity<PalDTO> addTypeToPal(@PathVariable Long id, @RequestBody String type) {
    Pal updatedPal = palService.addTypeToPal(id, type);
    return ResponseEntity.ok(DTOMapper.mapToDTO(updatedPal)); 
}
    //get types d'un pal
    @GetMapping("/{id}/types")
    public ResponseEntity<List<String>> getPalTypes(@PathVariable Long id) {
    List<String> types = palService.getPalTypes(id);
    return ResponseEntity.ok(types);
}

    @PutMapping("/{palId}/skills/{skillId}")
    public ResponseEntity<Skill> updateSkill(
            @PathVariable Long palId,
            @PathVariable Long skillId,
            @RequestBody Skill updatedSkill) {
        Skill skill = palService.updateSkillOfPal(palId, skillId, updatedSkill);
        return ResponseEntity.ok(skill);
    }
}

