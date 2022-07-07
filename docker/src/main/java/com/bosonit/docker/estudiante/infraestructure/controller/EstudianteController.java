package com.bosonit.docker.estudiante.infraestructure.controller;

import com.bosonit.docker.estudiante.application.port.AddEstudiantePort;
import com.bosonit.docker.estudiante.application.port.DeleteEstudiantePort;
import com.bosonit.docker.estudiante.application.port.GetEstudiantePort;
import com.bosonit.docker.estudiante.application.port.UpdateEstudiantePort;
import com.bosonit.docker.estudiante.infraestructure.dto.input.EstudianteInputDto;
import com.bosonit.docker.estudiante.infraestructure.dto.output.EstudianteFullOutputDto;
import com.bosonit.docker.estudiante.infraestructure.dto.output.EstudianteOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/estudiante")
@RestController
public class EstudianteController {
    @Autowired
    AddEstudiantePort addEstudiantePort;
    @Autowired
    DeleteEstudiantePort deleteEstudiantePort;
    @Autowired
    GetEstudiantePort getEstudiantePort;
    @Autowired
    UpdateEstudiantePort updateEstudiantePort;

    @PostMapping
    public EstudianteOutputDto addEstudiante(@Valid @RequestBody EstudianteInputDto estudianteInputDto) {
        return addEstudiantePort.addEstudiante(estudianteInputDto);
    }

    @PutMapping("/asignaturaAdd/{id}")
    public EstudianteOutputDto addAsignatura(@PathVariable("id") String idEstudiante, @RequestBody List<String> asignaturas) {
        return addEstudiantePort.addAsignaturas(idEstudiante, asignaturas);
    }

    @GetMapping("/{id}")
    public EstudianteOutputDto getEstudianteId(@PathVariable(name = "id") String id, @RequestParam(name = "outputType", defaultValue = "simple") String outputType) {
        if (outputType.equals("full")) {
            return new EstudianteFullOutputDto(getEstudiantePort.getEstudianteId(id));
        } else {
            return new EstudianteOutputDto(getEstudiantePort.getEstudianteId(id));
        }
    }

    @PutMapping("/{id}")
    public EstudianteOutputDto updateEstudiante(@PathVariable("id") String id, @Valid @RequestBody EstudianteInputDto estudianteInputDto) {
        return updateEstudiantePort.updateEstudiante(id, estudianteInputDto);
    }

    @DeleteMapping("/{id}")
    public void deleteEstudiante(@PathVariable("id") String id) {
        deleteEstudiantePort.deleteEstudiante(id);
    }

    @PutMapping("/asignaturaDelete/{id}")
    public EstudianteOutputDto deleteAsignatura(@PathVariable("id") String idEstudiante, @RequestBody List<String> asignaturas) {
        return deleteEstudiantePort.deleteAsignaturas(idEstudiante, asignaturas);
    }
}