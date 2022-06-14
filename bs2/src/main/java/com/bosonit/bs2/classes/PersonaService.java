package com.bosonit.bs2.classes;

import org.springframework.stereotype.Service;

@Service
public interface PersonaService {
    void setPersona(Persona persona);
    Persona getPersona();
}