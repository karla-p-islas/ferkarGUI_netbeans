package com.ejemplo.app_ferkar.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author kpaor
 */
public class IngresoInventarioDAO {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    
    public boolean RegistrarInventario(IngresoInventario pro){
        String sql = "INSERT INTO produccion_diaria (folio,fecha,id_soldador,caseta,hora_inicio,hora_fin,"
                + "codigo_aro,tratamiento_adicional,cantidad,cantidad_atados VALUES(?,?,?,?,?,?,?,?,?,?))";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            
            ps.setString(1, pro.getFolio());
            ps.setString(2, pro.getFecha());
            ps.setInt(3, pro.getId_soldador());
            ps.setInt(4, pro.getCaseta());
            ps.setString(5, pro.getHora_inicio());
            ps.setString(6, pro.getHora_fin());
            ps.setInt(7, pro.getCodigo_aro());
            ps.setString(8,pro.getTratamiento_adicional());
            ps.setInt(9, pro.getCantidad());
            ps.setInt(10, pro.getCantidad_atados());
            ps.execute();
            return true;
        }catch (Exception e){
            System.out.println(e.toString());
            return false;
        }
    }
}
