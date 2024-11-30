package com.tp_spring.palapi.application.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tp_spring.palapi.domain.Pal;
import com.tp_spring.palapi.infrastructure.repository.PalRepository;

@Service
public class DataInitializerService {

    private PalRepository palRepository;

    public DataInitializerService(PalRepository _palRepository) {
        this.palRepository = _palRepository;
    }

    public void loadData() throws StreamReadException, DatabindException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        InputStream inputStream = getClass().getResourceAsStream("pals.json");
        List<Pal> pals = mapper.readValue(inputStream, new TypeReference<>() {});
        palRepository.saveAll(pals);
    }

}
