
package com.ejemplo.app_ferkar.persistencia;

/**
 *
 * @author kpaor
 */
public class Carga {
    private String folio_orden;
    private String num_pedido;
    private String fecha_en;
    private String modo_pago;
    private String num_factura;
    private int id_conductor;
    private String transporte;

    public Carga() {
    }

    public Carga(String folio_orden, String num_pedido, String fecha_en, String modo_pago, String num_factura, int id_conductor, String transporte) {
        this.folio_orden = folio_orden;
        this.num_pedido = num_pedido;
        this.fecha_en = fecha_en;
        this.modo_pago = modo_pago;
        this.num_factura = num_factura;
        this.id_conductor = id_conductor;
        this.transporte = transporte;
    }

    public String getFolio_orden() {
        return folio_orden;
    }

    public void setFolio_orden(String folio_orden) {
        this.folio_orden = folio_orden;
    }

    public String getNum_pedido() {
        return num_pedido;
    }

    public void setNum_pedido(String num_pedido) {
        this.num_pedido = num_pedido;
    }

    public String getFecha_en() {
        return fecha_en;
    }

    public void setFecha_en(String fecha_en) {
        this.fecha_en = fecha_en;
    }

    public String getModo_pago() {
        return modo_pago;
    }

    public void setModo_pago(String modo_pago) {
        this.modo_pago = modo_pago;
    }

    public String getNum_factura() {
        return num_factura;
    }

    public void setNum_factura(String num_factura) {
        this.num_factura = num_factura;
    }

    public int getId_conductor() {
        return id_conductor;
    }

    public void setId_conductor(int id_conductor) {
        this.id_conductor = id_conductor;
    }

    public String getTransporte() {
        return transporte;
    }

    public void setTransporte(String transporte) {
        this.transporte = transporte;
    }
    
}
