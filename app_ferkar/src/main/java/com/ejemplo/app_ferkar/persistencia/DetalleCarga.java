
package com.ejemplo.app_ferkar.persistencia;

/**
 *
 * @author kpaor
 */
public class DetalleCarga {
    private String num_serial;
    private String folio_orden;
    private String folio_aro;
    private int clave;
    private String tratamiento_adicional;
    private int cantidad;

    public DetalleCarga() {
    }

    public DetalleCarga(String num_serial, String folio_orden, String folio_aro, int clave, String tratamiento_adicional, int cantidad) {
        this.num_serial = num_serial;
        this.folio_orden = folio_orden;
        this.folio_aro = folio_aro;
        this.clave = clave;
        this.tratamiento_adicional = tratamiento_adicional;
        this.cantidad = cantidad;
    }

    public String getNum_serial() {
        return num_serial;
    }

    public void setNum_serial(String num_serial) {
        this.num_serial = num_serial;
    }

    public String getFolio_orden() {
        return folio_orden;
    }

    public void setFolio_orden(String folio_orden) {
        this.folio_orden = folio_orden;
    }

    public String getFolio_aro() {
        return folio_aro;
    }

    public void setFolio_aro(String folio_aro) {
        this.folio_aro = folio_aro;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public String getTratamiento_adicional() {
        return tratamiento_adicional;
    }

    public void setTratamiento_adicional(String tratamiento_adicional) {
        this.tratamiento_adicional = tratamiento_adicional;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
}
