
package com.ejemplo.app_ferkar.persistencia;

/**
 *
 * @author kpaor
 */
public class Cliente {
    private int id_cliente;
    private String nombre;
    private String nombre_completo;

    public Cliente() {
    }

    public Cliente(int id_cliente, String nombre, String nombre_completo) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.nombre_completo = nombre_completo;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
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
