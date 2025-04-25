
package com.ejemplo.app_ferkar.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author kpaor
 */
public class SoldadorDAO {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public Soldador BuscarPro (String id){
        Soldador sold = new Soldador();
        String sql = "SELECT * FROM db_soldadores WHERE id_soldador = ?";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(id));
            rs = ps.executeQuery();
            if (rs.next()){
                sold.setId_soldador(rs.getInt("id_soldador"));
                sold.setNombre(rs.getString("nombre"));
                sold.setNombre_completo(rs.getString("nombre_completo"));
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return sold;
    }
}
