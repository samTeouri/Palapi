package com.tp_spring.palapi.web;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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


    // Get all pals
    @GetMapping
    public ResponseEntity<List<PalDTO>> getAllPals() {
        return ResponseEntity.ok(palService.getAllPals());
    }

    //get pal by id
    @GetMapping("/{id}")
    public ResponseEntity<PalDTO> getPalById(@PathVariable Long id) {
        return ResponseEntity.ok(palService.getPalById(id));
    }

    //get pal by name
    @GetMapping("/name/{name}")
    public ResponseEntity<List<PalDTO>> getPalsByName(@PathVariable String name) {
        return ResponseEntity.ok(palService.getPalsByName(name));
    }

    //get pals by type
    @GetMapping("/type/{type}")
    public ResponseEntity<List<PalDTO>> getPalsByType(@PathVariable String type) {
        return ResponseEntity.ok(palService.getPalsByType(type));
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

    // Get all pals sorted by price
    @GetMapping("/sorted/price")
    public ResponseEntity<List<PalDTO>> getAllPalsSortedByPrice() {
        List<Pal> pals = palService.getAllPalsSortedByPrice();
        List<PalDTO> palDTOs = pals.stream()
                                .map(DTOMapper::mapToDTO)
                                .collect(Collectors.toList());
        return ResponseEntity.ok(palDTOs);
    }

    // Get all pals sorted by rarity
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

    //remove type d'un pal
    @PostMapping("/{id}/types")
    public ResponseEntity<PalDTO> removePalType(@PathVariable Long id, @RequestBody String type) {
        Pal pal = palService.removeTypeFromPal(id, type);
        return ResponseEntity.ok(DTOMapper.mapToDTO(pal));
    }

    @PutMapping("/{palId}/skills/{skillId}")
    public ResponseEntity<Skill> updateSkill(
            @PathVariable Long palId,
            @PathVariable Long skillId,
            @RequestBody Skill updatedSkill) {
        Skill skill = palService.updateSkillOfPal(palId, skillId, updatedSkill);
        return ResponseEntity.ok(skill);
    }
    /*@GetMapping("/type/{type}")
    public ResponseEntity<List<PalDTO>> getPalsByType(@PathVariable String type) {
        return ResponseEntity.ok(palService.getPalsByType(type));
    }*/

}

