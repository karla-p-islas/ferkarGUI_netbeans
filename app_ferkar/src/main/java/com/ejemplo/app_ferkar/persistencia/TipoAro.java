
package com.ejemplo.app_ferkar.persistencia;

/**
 *
 * @author kpaor
 */
public class TipoAro {
    private String codigo_aro;
    private String medida;
    private int calibre;
    private int ancho;
    private String descripcion_esp;
    private String descripcion_gen;

    public TipoAro() {
    }

    public TipoAro(String codigo_aro, String medida, int calibre, int ancho, String descripcion_esp, String descripcion_gen) {
        this.codigo_aro = codigo_aro;
        this.medida = medida;
        this.calibre = calibre;
        this.ancho = ancho;
        this.descripcion_esp = descripcion_esp;
        this.descripcion_gen = descripcion_gen;
    }

    public String getCodigo_aro() {
        return codigo_aro;
    }

    public void setCodigo_aro(String codigo_aro) {
        this.codigo_aro = codigo_aro;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public int getCalibre() {
        return calibre;
    }

    public void setCalibre(int calibre) {
        this.calibre = calibre;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public String getDescripcion_esp() {
        return descripcion_esp;
    }

    public void setDescripcion_esp(String descripcion_esp) {
        this.descripcion_esp = descripcion_esp;
    }

    public String getDescripcion_gen() {
        return descripcion_gen;
    }

    public void setDescripcion_gen(String descripcion_gen) {
        this.descripcion_gen = descripcion_gen;
    }
    
    
}
