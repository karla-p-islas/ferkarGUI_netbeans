
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
    
    public List ListarEmpleados(){
        List<Soldador> ListaEmpleados = new ArrayList();
        String sql = "SELECT * FROM db_soldadores ORDER BY id_soldador ASC";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Soldador sold = new Soldador();
                sold.setId_soldador(rs.getInt("id_soldador"));
                sold.setNombre(rs.getString("nombre"));
                sold.setNombre_completo(rs.getString("nombre_completo"));
                ListaEmpleados.add(sold);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return ListaEmpleados;
    }
    
    public boolean RegistrarEmpleado(Soldador sold){
        String sql = "INSERT INTO db_soldadores(id_soldador,nombre,nombre_completo) VALUES (?,?,?)";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, sold.getId_soldador());
            ps.setString(2, sold.getNombre());
            ps.setString(3, sold.getNombre_completo());
            ps.execute();
            return true;
        }catch(SQLException e){
            System.out.println(e.toString());
            return false;
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.out.println(e.toString());
            }
        }
    }
    
    public boolean ModificarEmpleado(Soldador sold){
        String sql = "UPDATE db_soldadores SET nombre=?, nombre_completo=? WHERE id_soldador =?";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, sold.getNombre());
            ps.setString(2, sold.getNombre_completo());
            ps.setInt(3, sold.getId_soldador());
            ps.execute();
            return true;
        }catch(SQLException e){
            System.out.println(e.toString());
            return false;
        }finally{
            try{
                con.close();
            } catch (SQLException ex){
                System.out.println(ex.toString());
            }
        }
    }
    
    public boolean EliminarEmpleado(int id){
        String sql = "DELETE FROM db_soldadores WHERE id_soldador = ?";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        }catch(SQLException e){
            System.out.println(e);
            return false;
        }finally{
            try{
              con.close();  
            }catch(SQLException ex){
                System.out.println(ex.toString());
            }
        }
    }
    
}
