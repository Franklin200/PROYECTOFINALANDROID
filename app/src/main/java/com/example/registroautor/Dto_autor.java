package com.example.registroautor;

import java.io.Serializable;

public class Dto_autor implements Serializable {

    int dui ;
    String nombre;
    int edad;
    String descripcion;

    public Dto_autor() {
    }

    public Dto_autor(int dui, String nombre, int edad, String descripcion) {
        this.dui = dui;
        this.nombre = nombre;
        this.edad = edad;
        this.descripcion = descripcion;
    }

    public int getDui() {
        return dui;
    }

    public void setDui(int dui) {
        this.dui = dui;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString(){
        return nombre;
    }
}
