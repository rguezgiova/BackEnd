package com.bosonit.bs12.estudiante.domain;

import com.bosonit.bs12.PersonaSequenceIdGenerator;
import com.bosonit.bs12.asignatura.domain.Asignatura;
import com.bosonit.bs12.estudiante.infraestructure.dto.input.EstudianteInputDto;
import com.bosonit.bs12.persona.domain.Persona;
import com.bosonit.bs12.profesor.domain.Profesor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "estudiantes")
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idPersona")
    @GenericGenerator(name = "idPersona",
            strategy = "com.bosonit.bs12.PersonaSequenceIdGenerator",
            parameters = {
                    @Parameter(name = PersonaSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = PersonaSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "alu"),
                    @Parameter(name = PersonaSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")
            })
    private String idEstudiante;
    @OneToOne
    @JoinColumn(name = "id_persona")
    private Persona persona;
    @Column
    private int numHoursWeek;
    @Column
    private String comments;
    @ManyToOne
    @JoinColumn(name = "idProfesor")
    Profesor profesor;
    @Column
    String branch;
    @OneToMany
    private List<Asignatura> asignaturas;

    public Estudiante(EstudianteInputDto estudianteInputDto) {
        setNumHoursWeek(estudianteInputDto.getNumHoursWeek());
        setComments(estudianteInputDto.getComments());
        setBranch(estudianteInputDto.getBranch());
    }

    public void update(EstudianteInputDto estudianteInputDto) {
        setNumHoursWeek(estudianteInputDto.getNumHoursWeek());
        setComments(estudianteInputDto.getComments());
        setBranch(estudianteInputDto.getBranch());
    }
}