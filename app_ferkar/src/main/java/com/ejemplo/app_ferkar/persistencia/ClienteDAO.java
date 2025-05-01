
package com.ejemplo.app_ferkar.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;

/**
 *
 * @author kpaor
 */
public class ClienteDAO {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public void ConsultarCliente(JComboBox cliente){
        String sql = "SELECT nombre_completo FROM db_clientes";
        try{
           con = cn.getConnection();
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           while(rs.next()){
               cliente.addItem(rs.getString("nombre_completo"));
               
           }
        }catch(SQLException e){
           System.out.println(e.toString());
        }
    }
}
