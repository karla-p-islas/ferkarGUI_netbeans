
package com.ejemplo.app_ferkar.persistencia;

/**
 *
 * @author kpaor
 */
public class Reduccion {
    private String folio;
    private int cantidad;
    Inventario inv;

    public Reduccion() {
    }

    public Reduccion(String folio, int cantidad, Inventario inv) {
        this.folio = folio;
        this.cantidad = cantidad;
        this.inv = inv;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Inventario getInv() {
        return inv;
    }

    public void setInv(Inventario inv) {
        this.inv = inv;
    }
    
    
}
