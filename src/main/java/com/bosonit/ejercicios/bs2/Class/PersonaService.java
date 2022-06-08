package com.bosonit.ejercicios.bs2.Class;

import org.springframework.stereotype.Service;

@Service
public interface PersonaService {
    void setPersona(Persona persona);
    Persona getPersona();
}