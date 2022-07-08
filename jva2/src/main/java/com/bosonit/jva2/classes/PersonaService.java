package com.bosonit.jva2.classes;

import org.springframework.stereotype.Service;

@Service
public interface PersonaService {
    void addPersona(Persona persona);
    Persona getPersona();
}