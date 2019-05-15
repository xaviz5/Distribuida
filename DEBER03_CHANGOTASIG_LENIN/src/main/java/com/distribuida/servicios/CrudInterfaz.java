package com.distribuida.servicios;

import com.distribuida.entity.Persona;

import java.util.List;

public interface CrudInterfaz {
    void Ingresar (Persona persona);
    void Editar (Persona persona);
    void Eliminar (int id);
    Persona Buscar (int id);
    List<Persona> Listar();
}
