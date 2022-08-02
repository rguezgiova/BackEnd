package com.bosonit.te1.persona.application;

import com.bosonit.te1.application.PersonaServiceImpl;
import com.bosonit.te1.persona.domain.Persona;
import com.bosonit.te1.persona.infraestructure.dto.PersonaDto;
import com.bosonit.te1.persona.infraestructure.repository.PersonaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PersonaServiceTest {
    private Persona persona = new Persona(new PersonaDto(1, "user01", "password", "Primera", "Persona"));
    private List<Persona> personas = List.of(persona);
    @Mock
    PersonaRepository personaRepository;
    @InjectMocks
    PersonaServiceImpl personaService;

    @BeforeEach
    void setUp() {
        personaRepository.save(persona);
    }

    @Test
    void addPersonaTest() {
        PersonaDto personaTestDto = new PersonaDto(10, "useradd", "password", "New", "Persona");
        Persona personaTest = new Persona(new PersonaDto(10, "useradd", "password", "New", "Persona"));
        when(personaRepository.save(Mockito.any(Persona.class))).thenReturn(personaTest);
        assertEquals(personaTest, personaService.addPersona(personaTestDto));
    }

    @Test
    void getAllPersonasTest() {
        when(personaRepository.findAll()).thenReturn(personas);
        assertEquals(personas, personaService.getPersonas());
    }

    @Test
    void getPersonaByNameTest() {
        when(personaRepository.findByName(Mockito.any(String.class))).thenReturn(personas);
        assertEquals(personas, personaService.getPersonaName("New"));
    }

    @Test
    void deletePersonaByIdTest() {
        lenient().when(personaRepository.findById(Mockito.any(Integer.class))).thenReturn(Optional.of(new Persona()));
        personaService.deletePersona(10);
        verify(personaRepository).deleteById(Mockito.any(Integer.class));
    }

    @Test
    void updatePersonaTest() {
        when(personaRepository.findById(Mockito.any(Integer.class))).thenReturn(Optional.of(persona));
        when(personaRepository.save(Mockito.any(Persona.class))).thenReturn(persona);
        assertEquals(persona, personaService.updatePersona(1, persona));
    }

    @Test
    void updatePersonaNullUsernameTest() {
        Persona personaTest = new Persona(new PersonaDto(2, null, "password", "User", "User"));
        personaRepository.save(personaTest);
        when(personaRepository.findById(Mockito.any(Integer.class))).thenReturn(Optional.of(persona));
        when(personaRepository.save(Mockito.any(Persona.class))).thenReturn(persona);
        assertEquals(persona, personaService.updatePersona(2, personaTest));
    }

    @Test
    void updatePersonaNullPasswordTest() {
        Persona personaTest = new Persona(new PersonaDto(2, "user", null, "User", "User"));
        personaRepository.save(personaTest);
        when(personaRepository.findById(Mockito.any(Integer.class))).thenReturn(Optional.of(persona));
        when(personaRepository.save(Mockito.any(Persona.class))).thenReturn(persona);
        assertEquals(persona, personaService.updatePersona(2, personaTest));
    }

    @Test
    void updatePersonaNullNameTest() {
        Persona personaTest = new Persona(new PersonaDto(2, "User", "password", null, "User"));
        personaRepository.save(personaTest);
        when(personaRepository.findById(Mockito.any(Integer.class))).thenReturn(Optional.of(persona));
        when(personaRepository.save(Mockito.any(Persona.class))).thenReturn(persona);
        assertEquals(persona, personaService.updatePersona(2, personaTest));
    }

    @Test
    void updatePersonaNullSurnameTest() {
        Persona personaTest = new Persona(new PersonaDto(2, "User", "password", "User", null));
        personaRepository.save(personaTest);
        when(personaRepository.findById(Mockito.any(Integer.class))).thenReturn(Optional.of(persona));
        when(personaRepository.save(Mockito.any(Persona.class))).thenReturn(persona);
        assertEquals(persona, personaService.updatePersona(2, personaTest));
    }
}