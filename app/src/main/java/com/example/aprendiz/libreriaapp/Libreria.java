package com.example.aprendiz.libreriaapp;

/**
 * Created by APRENDIZ on 16/06/2016.
 */
public class Libreria {
    private int id;
    private String nombre;
    private String autor;
    private String editorial;
    private String tipoLiteratura;

    public Libreria(int id, String nombre, String autor, String editorial, String tipoLiteratura) {
        this.setId(id);
        this.setNombre(nombre);
        this.setAutor(autor);
        this.setEditorial(editorial);
        this.setTipoLiteratura(tipoLiteratura);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getTipoLiteratura() {
        return tipoLiteratura;
    }

    public void setTipoLiteratura(String tipoLiteratura) {
        this.tipoLiteratura = tipoLiteratura;
    }
}
