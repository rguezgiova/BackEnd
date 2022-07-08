package com.bosonit.jva2.classes;

import org.springframework.stereotype.Component;

@Component
public class PersonaServiceImpl implements PersonaService {
    private Persona persona;

    @Override
    public void addPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public Persona getPersona() {
        return persona;
    }
}