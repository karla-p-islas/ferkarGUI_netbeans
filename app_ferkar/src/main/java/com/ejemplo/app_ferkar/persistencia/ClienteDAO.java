
package com.ejemplo.app_ferkar.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

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
    
    public List ListarClientes(){
        List<Cliente> Clientes = new ArrayList();
        String sql1 = "SELECT * FROM db_clientes";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql1);
            rs = ps.executeQuery();
            while(rs.next()){
                Cliente cl = new Cliente();
                cl.setId_cliente(rs.getInt("id_cliente"));
                cl.setNombre(rs.getString("nombre"));
                cl.setNombre_completo(rs.getString("nombre_completo"));
                Clientes.add(cl);
            }
        }catch(SQLException e2){
            System.out.println(e2.toString());
        }
        return Clientes;
    }
    
    public boolean RegistrarClientes(Cliente cl){
        String sql2 = "INSERT INTO db_clientes(id_cliente,nombre,nombre_completo) VALUES (?,?,?)";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql2);
            ps.setInt(1, cl.getId_cliente());
            ps.setString(2, cl.getNombre());
            ps.setString(3, cl.getNombre_completo());
            ps.execute();
            return true;
        }catch(SQLException e3){
            JOptionPane.showMessageDialog(null, e3.toString());
            return false;
        }finally{
            try{
                con.close();
            }catch(SQLException e4){
                System.out.println(e4.toString());
            }
        }
    }
    
    public boolean EliminarCliente(int id_cl){
        String sql3 = "DELETE FROM db_clientes WHERE id_cliente = ?";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql3);
            ps.setInt(1, id_cl);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Cliente eliminado de la base ");
            return true;
        }catch(SQLException e5){
            System.out.println(e5.toString());
            return false;
        }finally{
            try{
                con.close();
            }catch(SQLException e6){
                System.out.println(e6.toString());
            }
        }
    }
    
    public boolean EditarCliente(Cliente cl){
        String sql4 = "UPDATE db_clientes SET nombre = ?, nombre_completo=? WHERE id_cliente = ?";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql4);
            ps.setString(1, cl.getNombre());
            ps.setString(2, cl.getNombre_completo());
            ps.setInt(3, cl.getId_cliente());
            ps.execute();
            return true;
        }catch(SQLException e7){
            System.out.println(e7.toString());
            return false;
        }
    }
}
