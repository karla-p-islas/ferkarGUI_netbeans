package com.ejemplo.app_ferkar.persistencia;

/**
 *
 * @author kpaor
 */
public class Inventario {
    private String codigo_aros;
    private String trato_adicional;
    private int aros;
    private int atados;

    public Inventario() {
    }

    public Inventario(String codigo_aros, String trato_adicional, int aros, int atados) {
        this.codigo_aros = codigo_aros;
        this.trato_adicional = trato_adicional;
        this.aros = aros;
        this.atados = atados;
    }

    public String getCodigo_aros() {
        return codigo_aros;
    }

    public void setCodigo_aros(String codigo_aros) {
        this.codigo_aros = codigo_aros;
    }

    public String getTrato_adicional() {
        return trato_adicional;
    }

    public void setTrato_adicional(String trato_adicional) {
        this.trato_adicional = trato_adicional;
    }

    public int getAros() {
        return aros;
    }

    public void setAros(int aros) {
        this.aros = aros;
    }

    public int getAtados() {
        return atados;
    }

    public void setAtados(int atados) {
        this.atados = atados;
    }
    
}
