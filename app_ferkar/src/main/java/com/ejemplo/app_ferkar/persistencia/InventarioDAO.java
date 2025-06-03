package com.ejemplo.app_ferkar.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kpaor
 */
public class InventarioDAO {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public List ExistenciasGen(){
        List<Inventario> Existencias = new ArrayList();
        String sql1 = "SELECT * FROM existencia_aros";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql1);
            rs = ps.executeQuery();
            while(rs.next()){
                Inventario inv = new Inventario();
                inv.setCodigo_aros(rs.getString("codigo_aro"));
                inv.setTrato_adicional(rs.getString("tratamiento_adicional"));
                inv.setAros(rs.getInt("aros"));
                inv.setAtados(rs.getInt("atados"));
                Existencias.add(inv);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return Existencias;
    }
    
    public List ExistenciasAros(String clave){
        List<Inventario> Existencias = new ArrayList();
        String sql1 = "SELECT * FROM existencia_aros";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql1);
            rs = ps.executeQuery();
            while(rs.next()){
                Inventario inv = new Inventario();
                inv.setCodigo_aros(rs.getString("codigo_aro"));
                inv.setTrato_adicional(rs.getString("tratamiento_adicional"));
                inv.setAros(rs.getInt("aros"));
                inv.setAtados(rs.getInt("atados"));
                Existencias.add(inv);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return Existencias;
    }
}
