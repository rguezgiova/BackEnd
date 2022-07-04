package com.bosonit.ej3_1.asignatura.domain;

import com.bosonit.ej3_1.PersonaSequenceIdGenerator;
import com.bosonit.ej3_1.asignatura.infraestructure.dto.input.AsignaturaInputDto;
import com.bosonit.ej3_1.estudiante.domain.Estudiante;
import com.bosonit.ej3_1.profesor.domain.Profesor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "asignaturas")
public class Asignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idPersona")
    @GenericGenerator(name = "idPersona",
            strategy = "com.bosonit.ej3_1.PersonaSequenceIdGenerator",
            parameters = {
                    @Parameter(name = PersonaSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = PersonaSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "asig"),
                    @Parameter(name = PersonaSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")
            })
    private String idAsignatura;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profesor")
    private Profesor profesor;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "asignatura")
    private List<Estudiante> estudiantes = new ArrayList<>();
    @Column
    private String name;
    @Column
    private String comments;
    @Column
    private Date initialDate;
    @Column
    private Date finishDate;

    public Asignatura(AsignaturaInputDto estudioInputDto) {
        setName(estudioInputDto.getName());
        setComments(estudioInputDto.getComments());
        setInitialDate(estudioInputDto.getInitialDate());
        setFinishDate(estudioInputDto.getFinishDate());
    }

    public void update(AsignaturaInputDto asignaturaInputDto) {
        if (asignaturaInputDto.getName() != null) {
            setName(asignaturaInputDto.getName());
        }
        if (asignaturaInputDto.getInitialDate() != null) {
            setInitialDate(asignaturaInputDto.getInitialDate());
        }
        if (asignaturaInputDto.getFinishDate() != null) {
            setFinishDate(asignaturaInputDto.getFinishDate());
        }
    }

    public void addEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    public void deleteEstudiante(Estudiante estudiante) {
        estudiantes.remove(estudiante);
    }
}