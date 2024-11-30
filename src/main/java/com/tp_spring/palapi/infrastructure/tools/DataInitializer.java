package com.tp_spring.palapi.infrastructure.tools;

import java.io.IOException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.tp_spring.palapi.application.service.DataInitializerService;

@Component
public class DataInitializer implements CommandLineRunner {

    private final DataInitializerService dataInitializerService;

    public DataInitializer(DataInitializerService _dataInitializerService) {
        this.dataInitializerService = _dataInitializerService;
    }

    @Override
    public void run(String... args) throws StreamReadException, DatabindException, IOException {
        dataInitializerService.loadData();
    }
}
