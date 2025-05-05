
package com.ejemplo.app_ferkar.persistencia;

/**
 *
 * @author kpaor
 */
public class Pedido {
    private String num_pedido;
    private String fecha ;
    private int id_cliente ;
    private String estado;

    public Pedido() {
    }

    public Pedido(String num_pedido, String fecha, int id_cliente, String estado) {
        this.num_pedido = num_pedido;
        this.fecha = fecha;
        this.id_cliente = id_cliente;
        this.estado = estado;
    }

    public String getNum_pedido() {
        return num_pedido;
    }

    public void setNum_pedido(String num_pedido) {
        this.num_pedido = num_pedido;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
