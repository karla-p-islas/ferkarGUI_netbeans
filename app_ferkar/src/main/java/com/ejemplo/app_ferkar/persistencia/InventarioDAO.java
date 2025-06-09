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
        String sql1 = "SELECT * FROM existencia_aros ORDER BY codigo_aro ASC";
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
    
    public List ExistenciasAroClave(String clave){
        List<Inventario> Existencias = new ArrayList();
        String sql1 = "SELECT * FROM existencia_aros WHERE codigo_aro = ?";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql1);
            ps.setString(1, clave);
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
    
    public List ExistenciasAroM(String medida){
        List<Inventario> Existencias = new ArrayList();
        
        String sql1 = "SELECT existencia_aros.codigo_aro, existencia_aros.tratamiento_adicional, existencia_aros.aros,existencia_aros.atados FROM existencia_aros LEFT JOIN db_aros ON existencia_aros.codigo_aro = db_aros.codigo WHERE db_aros.medida = ?";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql1);
            ps.setString(1, medida);
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
    
    public List ExistenciasAroC(String calibre){
        List<Inventario> Existencias = new ArrayList();
        
        String sql1 = "SELECT existencia_aros.codigo_aro, existencia_aros.tratamiento_adicional, existencia_aros.aros,existencia_aros.atados FROM existencia_aros LEFT JOIN db_aros ON existencia_aros.codigo_aro = db_aros.codigo WHERE db_aros.calibre = ?";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql1);
            ps.setInt(1, Integer.parseInt(calibre));
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
    
    public List ExistenciasAroA(String ancho){
        List<Inventario> Existencias = new ArrayList();
        
        String sql1 = "SELECT existencia_aros.codigo_aro, existencia_aros.tratamiento_adicional, existencia_aros.aros,existencia_aros.atados FROM existencia_aros LEFT JOIN db_aros ON existencia_aros.codigo_aro = db_aros.codigo WHERE db_aros.ancho = ?";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql1);
            ps.setInt(1, Integer.parseInt(ancho));
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
    
    public List ExistenciasAroMC(String medida,String calibre){
        List<Inventario> Existencias = new ArrayList();
        
        String sql1 = "SELECT existencia_aros.codigo_aro, existencia_aros.tratamiento_adicional, existencia_aros.aros,existencia_aros.atados FROM existencia_aros LEFT JOIN db_aros ON existencia_aros.codigo_aro = db_aros.codigo WHERE db_aros.medida = ? AND db_aros.calibre = ?";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql1);
            ps.setString(1, medida);
            ps.setInt(2, Integer.parseInt(calibre));
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
    
    public List ExistenciasAroCA(String calibre, String ancho){
        List<Inventario> Existencias = new ArrayList();
        
        String sql1 = "SELECT existencia_aros.codigo_aro, existencia_aros.tratamiento_adicional, existencia_aros.aros,existencia_aros.atados FROM existencia_aros LEFT JOIN db_aros ON existencia_aros.codigo_aro = db_aros.codigo WHERE db_aros.calibre = ? AND db_aros.ancho = ?";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql1);
            ps.setInt(1, Integer.parseInt(calibre));
            ps.setInt(2, Integer.parseInt(ancho));
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
    
    public List ExistenciasAroMA(String medida, String ancho){
        List<Inventario> Existencias = new ArrayList();
        
        String sql1 = "SELECT existencia_aros.codigo_aro, existencia_aros.tratamiento_adicional, existencia_aros.aros,existencia_aros.atados FROM existencia_aros LEFT JOIN db_aros ON existencia_aros.codigo_aro = db_aros.codigo WHERE db_aros.medida = ? AND db_aros.ancho = ?";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql1);
            ps.setString(1, medida);
            ps.setInt(2, Integer.parseInt(ancho));
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
    
    public List ExistenciasAroMCA(String medida, String calibre, String ancho){
        List<Inventario> Existencias = new ArrayList();
        
        String sql1 = "SELECT existencia_aros.codigo_aro, existencia_aros.tratamiento_adicional, existencia_aros.aros,existencia_aros.atados FROM existencia_aros LEFT JOIN db_aros ON existencia_aros.codigo_aro = db_aros.codigo WHERE db_aros.medida = ? AND db_aros.calibre = ? AND db_aros.ancho = ?";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql1);
            ps.setString(1, medida);
            ps.setInt(2, Integer.parseInt(calibre));
            ps.setInt(3, Integer.parseInt(ancho));
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
