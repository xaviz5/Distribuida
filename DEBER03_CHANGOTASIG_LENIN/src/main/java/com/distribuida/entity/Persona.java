package com.distribuida.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "Persona")
public class Persona implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "direccion")
    private String direccion;


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Persona [id=" + id + ", nombre=" + nombre
                + ", direccion=" + direccion + "]";
    }
}