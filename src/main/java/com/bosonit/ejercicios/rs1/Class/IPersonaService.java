package com.bosonit.ejercicios.rs1.Class;

public interface IPersonaService {
    void addPersona(Persona persona);
    Persona buscarPersona(int id);
    Persona buscarPersona(String nombre);
    boolean eliminarPersona(int id);
}