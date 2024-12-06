package com.tp_spring.palapi.web;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tp_spring.palapi.application.dto.PalDTO;
import com.tp_spring.palapi.application.service.PalService;

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

    @GetMapping("/{id}")
    public ResponseEntity<PalDTO> getPalById(@PathVariable Long id) {
        return ResponseEntity.ok(palService.getPalById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<PalDTO>> getPalsByName(@PathVariable String name) {
        return ResponseEntity.ok(palService.getPalsByName(name));
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<PalDTO>> getPalsByTypes(@PathVariable List<String> types) {
        return ResponseEntity.ok(palService.getPalsByTypes(types));
    }

    @PostMapping
    public ResponseEntity<PalDTO> createPal(@RequestBody PalDTO palDTO) {
        return ResponseEntity.ok(palService.createPal(palDTO));
    }


   /*  @GetMapping("/{id}/skills")
    public ResponseEntity<List<Skill>> getPalSkills(@PathVariable Long id) {
    Pal pal = DTOMapper.mapToEntity(palService.getPalById(id));
    return ResponseEntity.ok(palService.getPalSkills(pal));
    }

     @GetMapping("/sorted/price")
    public ResponseEntity<List<Pal>> getAllPalsSortedByPrice() {
        return ResponseEntity.ok(palService.getAllPalsSortedByPrice());
    }

    @GetMapping("/sorted/rarity")
    public ResponseEntity<List<Pal>> getAllPalsSortedByRarity() {
        return ResponseEntity.ok(palService.getAllPalsSortedByRarity());
    }
    */
}
