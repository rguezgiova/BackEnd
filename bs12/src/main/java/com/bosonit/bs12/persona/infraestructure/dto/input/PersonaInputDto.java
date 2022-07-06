package com.bosonit.bs12.persona.infraestructure.dto.input;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class PersonaInputDto {
    private String idPersona;
    @NotEmpty(message = "El campo usuario no puede estar vacío")
    @Size(min = 6, max = 10, message = "El usuario deber tener 6 caracteres como mínimo y 10 como máximo")
    private String usuario;
    @NotEmpty(message = "El campo contraseña no puede estar vacío")
    private String password;
    @NotEmpty(message = "El campo nombre no puede estar vacío")
    private String name;
    private String surname;
    @NotEmpty(message = "El campo email corporativo no puede estar vacío")
    @Email(message = "Email no válido")
    private String companyEmail;
    @NotEmpty(message = "El campo email personal no puede estar vacío")
    @Email(message = "Email no válido")
    private String personalEmail;
    @NotEmpty(message = "El campo ciudad no puede estar vacío")
    private String city;
    private boolean active;
    private Date createDate;
    private String imagenUrl;
    private Date terminationDate;
}