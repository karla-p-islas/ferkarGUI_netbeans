
package com.ejemplo.app_ferkar.persistencia;

/**
 *
 * @author kpaor
 */
public class DetallePedido {
    private String num_serial;
    private String num_pedido;
    private int codigo_aro;
    private String tratamiento_adicional;
    private int cantidad;

    public DetallePedido() {
    }

    public DetallePedido(String num_serial, String num_pedido, int codigo_aro, String tratamiento_adicional, int cantidad) {
        this.num_serial = num_serial;
        this.num_pedido = num_pedido;
        this.codigo_aro = codigo_aro;
        this.tratamiento_adicional = tratamiento_adicional;
        this.cantidad = cantidad;
    }

    public String getNum_serial() {
        return num_serial;
    }

    public void setNum_serial(String num_serial) {
        this.num_serial = num_serial;
    }

    public String getNum_pedido() {
        return num_pedido;
    }

    public void setNum_pedido(String num_pedido) {
        this.num_pedido = num_pedido;
    }

    public int getCodigo_aro() {
        return codigo_aro;
    }

    public void setCodigo_aro(int codigo_aro) {
        this.codigo_aro = codigo_aro;
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
