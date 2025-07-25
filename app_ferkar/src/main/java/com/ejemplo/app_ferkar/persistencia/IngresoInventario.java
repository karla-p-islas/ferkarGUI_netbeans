package com.ejemplo.app_ferkar.persistencia;
/**
 * @author kpaor
 * Objetivo: obtener la información que provenga del statement creado como "ingreso inventario" y dejarlo listo para el query
 */
public class IngresoInventario {
    private String folio;
    private String fecha;
    private int id_soldador;
    private int caseta;
    private String hora_inicio;
    private String hora_fin;
    private String codigo_aro;
    private String tratamiento_adicional;
    private int cantidad;
    private int cantidad_atados;
    private int cantidad_exs;
    private String ubicacion;
    
    public IngresoInventario(){ 
    }

    public IngresoInventario(String folio, String fecha, int id_soldador, int caseta, String hora_inicio, String hora_fin, String codigo_aro, String tratamiento_adicional, int cantidad, int cantidad_atados, int cantidad_exs, String ubicacion) {
        this.folio = folio;
        this.fecha = fecha;
        this.id_soldador = id_soldador;
        this.caseta = caseta;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
        this.codigo_aro = codigo_aro;
        this.tratamiento_adicional = tratamiento_adicional;
        this.cantidad = cantidad;
        this.cantidad_atados = cantidad_atados;
        this.cantidad_exs = cantidad_exs;
        this.ubicacion = ubicacion;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getId_soldador() {
        return id_soldador;
    }

    public void setId_soldador(int id_soldador) {
        this.id_soldador = id_soldador;
    }

    public int getCaseta() {
        return caseta;
    }

    public void setCaseta(int caseta) {
        this.caseta = caseta;
    }

    public String getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(String hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public String getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(String hora_fin) {
        this.hora_fin = hora_fin;
    }

    public String getCodigo_aro() {
        return codigo_aro;
    }

    public void setCodigo_aro(String codigo_aro) {
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

    public int getCantidad_atados() {
        return cantidad_atados;
    }

    public void setCantidad_atados(int cantidad_atados) {
        this.cantidad_atados = cantidad_atados;
    }

    public int getCantidad_exs() {
        return cantidad_exs;
    }

    public void setCantidad_exs(int cantidad_exs) {
        this.cantidad_exs = cantidad_exs;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    
}
