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
    
    public int ConsultarStock(String folio){
        String sql = "SELECT cantidad_disp FROM produccion_diaria WHERE folio = ?";
        int cantidad = 0;
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, folio);
            rs = ps.executeQuery();
            if (rs.next()){
                cantidad = rs.getInt("cantidad_disp");
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return cantidad;
    }
      
    public boolean Existencias(Inventario inv){
        
        String sql = "INSERT INTO existencia_aros(codigo_aro, tratamiento_adicional, aros, atados) VALUES(?,?,?,?) "
                + "ON CONFLICT (codigo_aro,tratamiento_adicional) DO UPDATE SET "
                + "aros = existencia_aros.aros + EXCLUDED.aros, "
                + "atados = existencia_aros.atados + EXCLUDED.atados ";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, inv.getCodigo_aros());
            ps.setString(2, inv.getTrato_adicional());
            ps.setInt(3, inv.getAros());
            ps.setInt(4, inv.getAtados());
            
            ps.executeUpdate();
            return true;
        }catch(SQLException e){
            System.out.println(e.toString());
            return false;
        }
    }
    
    public boolean ReducirExistencias(Inventario inv){
        String consultar = "SELECT aros, atados FROM existencia_aros WHERE codigo_aro = ? AND tratamiento_adicional = ?";
        String actualizar = "UPDATE existencia_aros SET aros = ?, atados = ? WHERE codigo_aro = ? AND  tratamiento_adicional = ?";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(consultar);

            ps.setString(1, inv.getCodigo_aros());
            ps.setString(2, inv.getTrato_adicional());
            
            rs  = ps.executeQuery();
            
            if(rs.next()){
                int stockAros = rs.getInt("aros");
                int stockAtados = rs.getInt("atados");
                
                int nuevosAros = stockAros - inv.getAros();
                int nuevosAtados = stockAtados - inv.getAtados();
                
                if (nuevosAros < 0 || nuevosAtados < 0){
                    JOptionPane.showMessageDialog(null, "No hay suficiente stock. Favor de revisar las existencias");
                    return false;
                }else{
                    //JOptionPane.showMessageDialog(null, "Si hay existencias");
                    ps = con.prepareStatement(actualizar);
                    ps.setInt(1, nuevosAros);
                    ps.setInt(2, nuevosAtados);
                    ps.setString(3, inv.getCodigo_aros());
                    ps.setString(4, inv.getTrato_adicional());
                    
                    ps.executeUpdate();
                    return true;
                }
            }else{
                JOptionPane.showMessageDialog(null, "No se encontró el producto en la base de datos");
                return false;
            }
        }catch(SQLException e){
            System.out.println(e.toString());
            return false;
        }
    }
    
   public boolean ReducirStock(String folio, int cantidad) throws SQLException {
        String consult = "SELECT cantidad_disp FROM produccion_diaria WHERE folio = ?";
        String update = "UPDATE produccion_diaria SET cantidad_disp = ? WHERE folio = ?";

        try (Connection con = cn.getConnection();
             PreparedStatement psConsulta = con.prepareStatement(consult)) {

            psConsulta.setString(1, folio);
            try (ResultSet rs = psConsulta.executeQuery()) {

                if (rs.next()) {
                    int aros_disp = rs.getInt("cantidad_disp");
                    int nueva_cant = aros_disp - cantidad;

                    //System.out.println("Tab: inventarioDAO");
                    //System.out.println("Folio: " + folio + ", aros disponibles: " + aros_disp + ", nueva cantidad: " + nueva_cant);

                    if (nueva_cant < 0) {
                        JOptionPane.showMessageDialog(null, "No hay atados disponibles del folio " + folio);
                        return false;
                    } else {
                        try (PreparedStatement psUpdate = con.prepareStatement(update)) {
                            psUpdate.setInt(1, nueva_cant);
                            psUpdate.setString(2, folio);
                            psUpdate.executeUpdate();
                            return true;
                        }
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró el producto en la base de datos");
                    return false;
                }
            }

        } catch (SQLException e) {
            System.out.println("Error en ReducirStock: " + e.getMessage());
            return false;
        }
    }

}
