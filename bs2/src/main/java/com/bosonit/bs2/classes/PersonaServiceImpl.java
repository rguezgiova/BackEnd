package com.bosonit.bs2.classes;

import org.springframework.stereotype.Component;

@Component
public class PersonaServiceImpl implements PersonaService {
    private Persona persona;

    @Override
    public void setPersona(Persona persona) {
        this.persona = Persona.builder()
                              .nombre(persona.getNombre())
                              .edad(persona.getEdad())
                              .poblacion(persona.getPoblacion())
                              .build();
    }

    @Override
    public Persona getPersona() {
        return persona;
    }
}