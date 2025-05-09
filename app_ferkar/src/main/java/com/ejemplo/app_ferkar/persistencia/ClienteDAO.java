
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
        String sql = "SELECT nombre FROM db_clientes";
        try{
           con = cn.getConnection();
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           while(rs.next()){
               cliente.addItem(rs.getString("nombre"));
           }
        }catch(SQLException e){
           System.out.println(e.toString());
        }
    }
    
    public int ConsultarID(String cliente) {
        int id = 0;
        String sql = "SELECT id_cliente FROM db_clientes WHERE nombre_completo = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cliente);
            rs = ps.executeQuery();

            if (rs.next()) {
                id = rs.getInt("id_cliente");
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return id;
    }
    
    public String ConsultarNombre(int id){
        String nombre = "";
        String sql = "SELECT nombre_completo FROM db_clientes WHERE id_cliente = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                nombre = rs.getString("nombre_completo");
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return nombre;
    }

}
