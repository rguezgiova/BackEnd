package com.bosonit.ejercicios.rs1.Class;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaServiceImpl implements IPersonaService {
    private List<Persona> personaList;

    PersonaServiceImpl() {
        this.personaList = new ArrayList<>();
    }

    @Override
    public void addPersona(Persona persona) {
        persona.setId(personaList.size());
        personaList.add(persona);
    }


    @Override
    public Persona buscarPersona(int id) {
        return personaList.stream().filter(persona -> persona.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Persona buscarPersona(String nombre) {
        return personaList.stream().filter(persona -> persona.getNombre().equals(nombre)).findFirst().orElse(null);
    }

    @Override
    public boolean eliminarPersona(int id) {
        Persona personaEncontrada = buscarPersona(id);
        return personaList.remove(personaEncontrada);
    }
}