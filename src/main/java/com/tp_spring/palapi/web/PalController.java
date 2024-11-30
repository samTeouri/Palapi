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

    @PostMapping
    public ResponseEntity<PalDTO> createPal(@RequestBody PalDTO palDTO) {
        return ResponseEntity.ok(palService.createPal(palDTO));
    }
}
