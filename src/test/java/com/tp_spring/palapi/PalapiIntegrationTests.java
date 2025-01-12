package com.tp_spring.palapi;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tp_spring.palapi.application.dto.PalDTO;
import com.tp_spring.palapi.application.service.DataInitializerService;
import com.tp_spring.palapi.application.service.TestDataInitializerService;
import com.tp_spring.palapi.domain.Skill;
import com.tp_spring.palapi.infrastructure.repository.PalRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RestClientTest
public class PalapiIntegrationTests {

    @Autowired
    private PalRepository palRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

    private RestTemplate restTemplate = new RestTemplate();
    private String baseUrl = "http://localhost:8080" + "/api/pals";

    public PalapiIntegrationTests() {

    }

    // public PalapiIntegrationTests(int _port, PalRepository _palRepository, ObjectMapper _objectMapper, RestTemplate _restTemplate, String _baseUrl) {
    //     this.port = _port;
    //     this.palRepository = _palRepository;
    //     this.objectMapper = _objectMapper;
    //     this.restTemplate = _restTemplate;
    //     this.baseUrl = _baseUrl;
    // }

    @BeforeEach
    void setUp() throws StreamReadException, DatabindException, IOException {
        TestDataInitializerService testDataInitializerService = new TestDataInitializerService(palRepository);

        // Création des Pals pour les tests
        testDataInitializerService.loadData();
    }

    @AfterEach
    void getDown() throws StreamReadException, DatabindException, IOException {
        DataInitializerService dataInitializerService = new DataInitializerService(palRepository);
        dataInitializerService.loadData();
    }

    @Test
    public void testGetAllPals() {
        PalDTO[] response = restTemplate.getForObject(baseUrl, PalDTO[].class);

        assertTrue(response.length > 0, "La réponse ne contient aucun Pal");
        assertEquals("Le nom du premier Pal ne correspond pas", "Lamball", response[0].getName());
    }

    @Test
    public void testGetPalById() {
        PalDTO response = restTemplate.getForObject(baseUrl + "/1", PalDTO.class);

        assertTrue(response != null, "La réponse ne contient aucun Pal");
        assertEquals("Le nom du Pal ne correspond pas", "Lamball",response.getName());
    }

    @Test
    public void testCreatePal() throws Exception {
        PalDTO newPal = new PalDTO(998, "New Pal", List.of("Type3", "Type4"), 5, 3500.0, "xs", null);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(objectMapper.writeValueAsString(newPal), headers);

        PalDTO response = restTemplate.postForObject(baseUrl, request, PalDTO.class);

        assertTrue(response != null, "La réponse ne contient aucun Pal");
        assertEquals("Le nom du Pal ne correspond pas", "New Pal", response.getName());
        assertEquals("Les types du Pal ne correspondent pas", List.of("Type3", "Type4"), response.getTypes());
    }

    @Test
    public void testGetPalsByType() {
        PalDTO[] response = restTemplate.getForObject(baseUrl + "/type/neutral", PalDTO[].class);

        assertTrue(response != null, "La réponse ne contient aucun Pal");
        assertEquals("Le premier type du premier Pal ne correspond pas", "neutral", response[0].getTypes().get(0));
    }

    @Test
    public void testGetPalByName() {
        PalDTO[] response = restTemplate.getForObject(baseUrl + "/name/Lamball", PalDTO[].class);

        assertTrue(response != null, "La réponse ne contient aucun Pal");
        assertEquals("Le nom du premier Pal ne correspond pas", "Lamball", response[0].getName());
    }

    @Test
    public void testGetPalTypes() {
        String[] response = restTemplate.getForObject(baseUrl + "/2/types", String[].class);

        assertTrue(response != null, "La réponse ne contient aucun type");
        assertEquals("Le nom du Type ne correspond pas", "neutral", response[0]);
    }

    @Test
    public void testGetPalSkills() {
        Skill[] response = restTemplate.getForObject(baseUrl + "/2/skills", Skill[].class);

        assertTrue(response != null, "La réponse ne contient aucun skill");
        assertEquals("Le nom du Skill ne correspond pas", "punch_flurry", response[0].getName());
    }

    @Test
    public void testAddSkillToPal() throws Exception {
        Skill newSkill = new Skill(1, "Skill1", "Type1", 10, 100, "Description");
        newSkill.setId(999);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(objectMapper.writeValueAsString(newSkill), headers);

        Skill response = restTemplate.postForObject(baseUrl + "/1" + "/skill", request, Skill.class);

        assertTrue(response != null, "La réponse ne contient aucun Skill");
        assertEquals("Le nom du Skill ne correspond pas", "Skill1", response.getName());
    }

    @Test
    public void testAddTypeToPal() throws Exception {
        String newType = "Type3";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(newType, headers);

        PalDTO response = restTemplate.postForObject(baseUrl + "/1" + "/type", request, PalDTO.class);

        assertTrue(response != null, "La réponse ne contient aucun Pal");
        assertTrue(response.getTypes().contains("Type3"));
    }

    @Test
    public void testGetAllPalsSortedByPrice() {
        PalDTO[] response = restTemplate.getForObject(baseUrl + "/sorted/price", PalDTO[].class);

        assertTrue(response != null, "La réponse ne contient aucun Pal");
        assertTrue(response[0].getPrice() == 1000, "Le prix du premier pal ne correspond pas");
    }

    @Test
    public void testGetAllPalsSortedByRarity() {
        PalDTO[] response = restTemplate.getForObject(baseUrl + "/sorted/rarity", PalDTO[].class);

        assertTrue(response != null, "La réponse ne contient aucun Pal");
        assertTrue(response[0].getRarity() == 1, "Le rareté du premier pal ne correspond pas");
    }

    @Test
    public void testUpdateSkill() throws Exception {
        Skill newSkill = new Skill(1, "Updated Skill", "Type1", 10, 100, "Description");
        newSkill.setId(996);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(objectMapper.writeValueAsString(newSkill), headers);

        Skill response = restTemplate.postForObject(baseUrl + "/1" + "/skills/1", request, Skill.class);

        assertTrue(response != null, "La réponse ne contient aucun Skill");
        assertEquals("Le skill n'a pas été mis à jour correctement", newSkill.getName(), response.getName());
    }


    @Test
    public void testRemovePalType() throws Exception {
        String typeToRemove = "ground";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(typeToRemove, headers);

        PalDTO response = restTemplate.postForObject(baseUrl + "/120" + "/types", request, PalDTO.class);

        assertTrue(response != null, "La réponse ne contient aucun Pal");
        assertFalse(response.getTypes().contains(typeToRemove), "Le type n'a pas été supprimé correctement"
        );
    }
}
