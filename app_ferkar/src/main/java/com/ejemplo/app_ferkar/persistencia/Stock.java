
package com.ejemplo.app_ferkar.persistencia;

/**
 *
 * @author kpaor
 */
public class Stock {
    public String folio;
    public int cantidad;

    public Stock() {
    }

    public Stock(String folio, int cantidad) {
        this.folio = folio;
        this.cantidad = cantidad;
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
    
}
