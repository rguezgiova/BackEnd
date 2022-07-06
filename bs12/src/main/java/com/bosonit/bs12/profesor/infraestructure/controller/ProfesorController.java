package com.bosonit.bs12.profesor.infraestructure.controller;

import com.bosonit.bs12.profesor.application.port.AddProfesorPort;
import com.bosonit.bs12.profesor.application.port.DeleteProfesorPort;
import com.bosonit.bs12.profesor.application.port.GetProfesorPort;
import com.bosonit.bs12.profesor.application.port.UpdateProfesorPort;
import com.bosonit.bs12.profesor.infraestructure.dto.input.ProfesorInputDto;
import com.bosonit.bs12.profesor.infraestructure.dto.output.ProfesorOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/profesor")
@RestController
public class ProfesorController {
    @Autowired
    AddProfesorPort addProfesorPort;
    @Autowired
    DeleteProfesorPort deleteProfesorPort;
    @Autowired
    GetProfesorPort getProfesorPort;
    @Autowired
    UpdateProfesorPort updateProfesorPort;

    @PostMapping
    public ProfesorOutputDto addProfesor(@Valid @RequestBody ProfesorInputDto profesorInputDto) {
        return addProfesorPort.addProfesor(profesorInputDto);
    }

    @GetMapping("/{id}")
    public ProfesorOutputDto getProfesorId(@PathVariable("id") String id) {
        return getProfesorPort.getProfesorId(id);
    }

    @PutMapping("/{id}")
    public ProfesorOutputDto updateProfesor(@PathVariable("id") String id, ProfesorInputDto profesorInputDto) {
        return updateProfesorPort.updateProfesor(id, profesorInputDto);
    }

    @DeleteMapping("/{id}")
    public void deleteProfesor(@PathVariable("id") String id) {
        deleteProfesorPort.deleteProfesor(id);
    }
}