
package com.ejemplo.app_ferkar.persistencia;

/**
 *
 * @author kpaor
 */
public class Pedido {
    private String num_pedido;
    private String fecha ;
    private String cliente ;
    private String estado;
    private String solicitante;

    public Pedido() {
    }

    public Pedido(String num_pedido, String fecha, String cliente, String estado, String solicitante) {
        this.num_pedido = num_pedido;
        this.fecha = fecha;
        this.cliente = cliente;
        this.estado = estado;
        this.solicitante = solicitante;
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

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }
    
}
