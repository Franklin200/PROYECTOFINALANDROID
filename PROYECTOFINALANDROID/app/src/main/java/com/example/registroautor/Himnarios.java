package com.example.registroautor;

import javax.xml.transform.sax.SAXResult;

public class Himnarios {
    private int id;
    private String titulo;
    private String descripcion;
    private String categoria;
    private int fecha;
    private String img;

    public Himnarios(int id, String titulo, String descripcion, String categoria, int fecha, String img) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.fecha = fecha;
        this.img = img;
    }

    //Getter

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getFecha() {
        return fecha;
    }

    public String getImg() {
        return img;
    }
}
