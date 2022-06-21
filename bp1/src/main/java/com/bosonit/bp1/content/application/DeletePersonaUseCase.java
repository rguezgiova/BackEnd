package com.bosonit.bp1.content.application;

import com.bosonit.bp1.content.application.port.DeletePersonaPort;
import com.bosonit.bp1.content.domain.Persona;
import com.bosonit.bp1.content.infraestructure.repository.IPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.HttpMediaTypeNotAcceptableException;

@Service
public class DeletePersonaUseCase implements DeletePersonaPort {
    @Autowired
    IPersonaRepository personaRepository;

    @Override
    public void deletePersona(int id) throws Exception {
        Persona persona = personaRepository.findById(id).orElseThrow(() -> new HttpMediaTypeNotAcceptableException("No se ha encontrado usuario con dicha ID"));
        personaRepository.delete(persona);
    }
}