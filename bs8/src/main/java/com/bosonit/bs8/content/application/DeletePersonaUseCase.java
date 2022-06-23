package com.bosonit.bs8.content.application;

import com.bosonit.bs8.content.application.port.DeletePersonaPort;
import com.bosonit.bs8.content.domain.Persona;
import com.bosonit.bs8.content.infraestructure.repository.PersonaRepository;
import com.bosonit.bs8.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

@Service
public class DeletePersonaUseCase implements DeletePersonaPort {
    @Autowired
    PersonaRepository personaRepository;

    @Override
    public void deletePersona(int id) {
        Persona persona = personaRepository.findById(id).orElseThrow(() -> new NotFoundException("No se ha encontrado ningún usuario con dicha ID"));
        personaRepository.delete(persona);
    }
}