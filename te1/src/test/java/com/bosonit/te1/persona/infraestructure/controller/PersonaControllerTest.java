package com.bosonit.te1.persona.infraestructure.controller;

import com.bosonit.te1.persona.domain.Persona;
import com.bosonit.te1.persona.infraestructure.dto.PersonaDto;
import com.bosonit.te1.persona.infraestructure.repository.PersonaRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.HttpStatus.OK;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Slf4j
class PersonaControllerTest {
    @Autowired
    PersonaRepository personaRepository;
    @Autowired
    private TestRestTemplate restTemplate;
    @LocalServerPort
    int port;

    @BeforeEach
    void setUp() {
        Persona persona = new Persona(new PersonaDto(1, "user", "password", "User", "User"));
        personaRepository.save(persona);
    }

    @Test
    void addPersonaTest() {
        PersonaDto personaDtoTest = new PersonaDto(2, "userTest", "password", "Test", "Test");
        ResponseEntity<PersonaDto> responseEntity = new RestTemplate().postForEntity("http://localhost:" + port + "/persona", personaDtoTest, PersonaDto.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(OK);
    }

    @Test
    void getPersonaNameTest() throws URISyntaxException {
        RequestEntity<Void> requestEntity = RequestEntity.get(new URI("http://localhost:" + port + "/persona/name/User")).accept(MediaType.APPLICATION_JSON).build();
        ParameterizedTypeReference<List<PersonaDto>> list = new ParameterizedTypeReference<List<PersonaDto>>() {};
        ResponseEntity<List<PersonaDto>> responseEntity = restTemplate.exchange(requestEntity, list);
        assertThat(responseEntity.getStatusCode()).isEqualTo(OK);
        assertThat(responseEntity.getBody().size()).isEqualTo(1);
    }

    @Test
    void getAllTest() throws URISyntaxException {
        RequestEntity<Void> requestEntity = RequestEntity.get(new URI("http://localhost:" + port + "/persona/getall")).accept(MediaType.APPLICATION_JSON).build();
        ParameterizedTypeReference<List<PersonaDto>> list = new ParameterizedTypeReference<List<PersonaDto>>() {};
        ResponseEntity<List<PersonaDto>> responseEntity = restTemplate.exchange(requestEntity, list);
        assertThat(responseEntity.getStatusCode()).isEqualTo(OK);
        assertThat(responseEntity.getBody().size()).isEqualTo(1);
    }

    @Test
    void updatePersonaTest() {
        PersonaDto personaDtoTest = new PersonaDto(null, "user", "password", "User", "User");
        RequestEntity<PersonaDto> requestEntity = RequestEntity.put("http://localhost:" + port + "/persona/" + 1).body(personaDtoTest);
        ParameterizedTypeReference<String> message = new ParameterizedTypeReference<String>() {};
        ResponseEntity<String> responseEntity = restTemplate.exchange(requestEntity, message);
        assertThat(responseEntity.getStatusCode()).isEqualTo(OK);
    }

    @Test
    void deletePersonaTest() {
        RequestEntity<Void> requestEntity = RequestEntity.delete("http://localhost:" + port + "/persona/" + 1).accept(MediaType.ALL).build();
        ParameterizedTypeReference<String> message = new ParameterizedTypeReference<String>() {};
        ResponseEntity<String> responseEntity = restTemplate.exchange(requestEntity, message);
        assertThat(responseEntity.getStatusCode()).isEqualTo(OK);
    }
}