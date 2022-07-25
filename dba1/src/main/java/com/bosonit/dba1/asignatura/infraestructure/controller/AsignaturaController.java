package com.bosonit.dba1.asignatura.infraestructure.controller;

import com.bosonit.dba1.asignatura.application.port.AddAsignaturaPort;
import com.bosonit.dba1.asignatura.application.port.DeleteAsignaturaPort;
import com.bosonit.dba1.asignatura.application.port.GetAsignaturaPort;
import com.bosonit.dba1.asignatura.application.port.UpdateAsignaturaPort;
import com.bosonit.dba1.asignatura.infraestructure.dto.input.AsignaturaInputDto;
import com.bosonit.dba1.asignatura.infraestructure.dto.output.AsignaturaOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/asignatura")
@RestController
public class AsignaturaController {
    @Autowired
    AddAsignaturaPort addAsignaturaPort;
    @Autowired
    DeleteAsignaturaPort deleteAsignaturaPort;
    @Autowired
    GetAsignaturaPort getAsignaturaPort;
    @Autowired
    UpdateAsignaturaPort updateAsignaturaPort;

    @PostMapping
    public AsignaturaOutputDto addAsignatura(@Valid @RequestBody AsignaturaInputDto asignaturaInputDto) {
        return addAsignaturaPort.addAsignatura(asignaturaInputDto);
    }

    @GetMapping("/{id}")
    public AsignaturaOutputDto getAsignatura(@PathVariable("id") String id) {
        return getAsignaturaPort.getAsignaturaById(id);
    }

    @GetMapping("/estudio/{id}")
    public List<AsignaturaOutputDto> getAsignaturaEstudianteById(@PathVariable("id") String idEstudiante) {
        return getAsignaturaPort.getAsignaturaEstudianteById(idEstudiante);
    }

    @PutMapping("/{id}")
    public AsignaturaOutputDto updateAsignatura(@PathVariable("id") String id, @RequestBody AsignaturaInputDto asignaturaInputDto) {
        return updateAsignaturaPort.updateAsignatura(id, asignaturaInputDto);
    }

    @DeleteMapping("/{id}")
    public void deleteAsignatura(@PathVariable("id") String id) {
        deleteAsignaturaPort.deleteAsignatura(id);
    }
}