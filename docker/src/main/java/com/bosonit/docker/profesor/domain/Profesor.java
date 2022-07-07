package com.bosonit.docker.profesor.domain;

import com.bosonit.docker.PersonaSequenceIdGenerator;
import com.bosonit.docker.asignatura.domain.Asignatura;
import com.bosonit.docker.estudiante.domain.Estudiante;
import com.bosonit.docker.persona.domain.Persona;
import com.bosonit.docker.profesor.infraestructure.dto.input.ProfesorInputDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "profesores")
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idPersona")
    @GenericGenerator(name = "idPersona",
            strategy = "com.bosonit.docker.PersonaSequenceIdGenerator",
            parameters = {
                    @Parameter(name = PersonaSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = PersonaSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "pro"),
                    @Parameter(name = PersonaSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")
            })
    private String idProfesor;
    @OneToOne
    @JoinColumn(name = "id_persona")
    private Persona persona;
    @Column
    private String comments;
    @Column
    private String branch;
    @OneToMany
    private List<Asignatura> asignaturas;
    @OneToMany
    private List<Estudiante> estudiantes;

    public Profesor(ProfesorInputDto profesorInputDto) {
        setComments(profesorInputDto.getComments());
        setBranch(profesorInputDto.getBranch());
    }

    public void update(ProfesorInputDto profesorInputDto) {
        if (profesorInputDto.getBranch() != null) {
            setBranch(profesorInputDto.getBranch());
        }
        if (profesorInputDto.getComments() != null) {
            setComments(profesorInputDto.getComments());
        }
    }
}