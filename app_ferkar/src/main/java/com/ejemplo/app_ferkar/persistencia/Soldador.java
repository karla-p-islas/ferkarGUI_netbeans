package com.ejemplo.app_ferkar.persistencia;

/**
 *
 * @author kpaor
 */
public class Soldador {
    private int id_soldador;
    private String nombre;
    private String nombre_completo;

    public Soldador() {
    }

    public Soldador(int id_soldador, String nombre, String nombre_completo) {
        this.id_soldador = id_soldador;
        this.nombre = nombre;
        this.nombre_completo = nombre_completo;
    }

    public int getId_soldador() {
        return id_soldador;
    }

    public void setId_soldador(int id_soldador) {
        this.id_soldador = id_soldador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }
    
}

