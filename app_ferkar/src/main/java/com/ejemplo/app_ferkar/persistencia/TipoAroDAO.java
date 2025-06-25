
package com.ejemplo.app_ferkar.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author kpaor
 */
public class TipoAroDAO {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public TipoAro BuscarPro(String clave) {
        TipoAro aro = new TipoAro();
        String sql = "SELECT * FROM db_aros WHERE codigo = ?";

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = cn.getConnection();
            if (con == null) {
                System.out.println("No se pudo obtener conexión en BuscarPro. Demasiadas conexiones abiertas.");
                return aro;
            }
            ps = con.prepareStatement(sql);
            ps.setString(1, clave);
            rs = ps.executeQuery();
            if (rs.next()) {
                aro.setCodigo_aro(rs.getInt("codigo"));
                aro.setMedida(rs.getString("medida"));
                aro.setCalibre(rs.getInt("calibre"));
                aro.setAncho(rs.getInt("ancho"));
                aro.setDescripcion_esp(rs.getString("descripcion_esp"));
                aro.setDescripcion_gen(rs.getString("descripcion_gen"));
            }
        } catch (SQLException e) {
            System.out.println("Error en BuscarPro: " + e.toString());
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar ResultSet: " + ex.toString());
            }
            try {
                if (ps != null) ps.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar PreparedStatement: " + ex.toString());
            }
            try {
                if (con != null) con.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar Connection: " + ex.toString());
            }
        }
        return aro;
    }

    
    public boolean RegistrarAro(TipoAro aro){
        String sql = "INSERT INTO db_aros (codigo,medida,calibre,ancho,descripcion_esp,descripcion_gen) VALUES (?,?,?,?,?,?)";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1,String.format("%04d",aro.getCodigo_aro()));
            ps.setString(2, aro.getMedida());
            ps.setInt(3, aro.getCalibre());
            ps.setInt(4, aro.getAncho());
            ps.setString(5, aro.getDescripcion_esp());
            ps.setString(6, aro.getDescripcion_gen());
            ps.execute();
            return true;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.out.println(e.toString());
            }
        }
    }
    
    public List ListarAros(){
        List<TipoAro> ListaAros = new ArrayList();
        String sql = "SELECT * FROM db_aros ORDER BY codigo ASC";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                TipoAro aro = new TipoAro();
                aro.setCodigo_aro(rs.getInt("codigo"));
                aro.setMedida(rs.getString("medida"));
                aro.setCalibre(rs.getInt("calibre"));
                aro.setAncho(rs.getInt("ancho"));
                aro.setDescripcion_esp(rs.getString("descripcion_esp"));
                aro.setDescripcion_gen(rs.getString("descripcion_gen"));
                ListaAros.add(aro);
            }
        } catch (SQLException e){
            System.out.println(e.toString());
        }
        return ListaAros;
    }
    
    public boolean EliminarAro(int id){
        String sql = "DELETE FROM db_aros WHERE codigo = ?";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, String.format("%04d", id));
            ps.execute();
            return true;
        }catch (SQLException e){
            System.out.println(e.toString());
            return false;
        }finally{
            try{
              con.close();  
            }catch(SQLException ex){
                System.out.println(ex.toString());
            }
        }
    }
    
    public boolean ModificarAro(TipoAro aro){
        String sql = "UPDATE db_aros SET medida = ?,calibre = ?, ancho = ?, descripcion_esp = ?, descripcion_gen = ? WHERE codigo = ?";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            
            ps.setString(1, aro.getMedida());
            ps.setInt(2, aro.getCalibre());
            ps.setInt(3, aro.getAncho());
            ps.setString(4,aro.getDescripcion_esp());
            ps.setString(5, aro.getDescripcion_gen());
            ps.setString(6, String.format("%04d",aro.getCodigo_aro()));
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
}
