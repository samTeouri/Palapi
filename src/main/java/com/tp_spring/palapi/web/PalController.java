package com.tp_spring.palapi.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tp_spring.palapi.application.service.PalService;

@RestController
@RequestMapping("/api/pals")
public class PalController {

    private final PalService palService;

    public PalController(PalService palService) {
        this.palService = palService;
    }
    
}
