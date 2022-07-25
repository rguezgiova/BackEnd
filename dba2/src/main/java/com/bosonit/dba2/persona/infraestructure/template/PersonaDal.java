package com.bosonit.dba2.persona.infraestructure.template;

import com.bosonit.dba2.persona.domain.Persona;

import java.util.List;

public interface PersonaDal {
    Persona addPersona(Persona persona);
    Persona findById(String id);
    List<Persona> findByName(String name);
    List<Persona> getAll();
    void deletePersona(Persona persona);
    Persona updatePersona(String id, Persona persona);
}