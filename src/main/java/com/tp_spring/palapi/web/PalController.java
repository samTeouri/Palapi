package com.tp_spring.palapi.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/{id}")
    public ResponseEntity<PalDTO> getPalById(@PathVariable Long id) {
        return ResponseEntity.ok(palService.getPalById(id));
    }
}
