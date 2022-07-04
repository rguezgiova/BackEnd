package com.bosonit.ej3_1.persona.application;

import com.bosonit.ej3_1.persona.application.port.DeletePersonaPort;
import com.bosonit.ej3_1.persona.domain.Persona;
import com.bosonit.ej3_1.persona.infraestructure.repository.PersonaRepository;
import com.bosonit.ej3_1.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletePersonaUseCase implements DeletePersonaPort {
    @Autowired
    PersonaRepository personaRepository;

    @Override
    public void deletePersona(String id) {
        Persona persona = personaRepository.findById(id).orElseThrow(() -> new NotFoundException("No se ha encontrado ningún usuario con dicha ID"));
        personaRepository.delete(persona);
    }
}