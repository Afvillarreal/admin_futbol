package com.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Jugador {
    @Id
    private Long id;
    private String nombre;
    private String posicion;
    private int numero;

    public Jugador(){

    }

    public Jugador(String nombre, String posicion, int numero) {
        this.nombre = nombre;
        this.posicion = posicion;
        this.numero = numero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

}
