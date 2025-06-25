package com.ejemplo.app_ferkar.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * @author kpaor
 * Objetivo: crear el query con la información correspondiente para ser enviada a sql
 */
public class IngresoInventarioDAO {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean RegistrarInventario(IngresoInventario pro){
        String sql = "INSERT INTO produccion_diaria (folio,fecha,id_soldador,caseta,hora_inicio,hora_fin,codigo_aro,tratamiento_adicional,cantidad,cantidad_atados,cantidad_disp,ubicacion) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            
            ps.setString(1, pro.getFolio());
            
            SimpleDateFormat sdfFecha = new SimpleDateFormat("dd/MM/yy");
            Date utilDate = sdfFecha.parse(pro.getFecha());
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            ps.setDate(2, sqlDate);

            ps.setInt(3, pro.getId_soldador());
            ps.setInt(4, pro.getCaseta());
            
             SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm");

            Date utilHoraInicio = sdfHora.parse(pro.getHora_inicio());
            java.sql.Time sqlHoraInicio = new java.sql.Time(utilHoraInicio.getTime());
            ps.setTime(5, sqlHoraInicio);

            Date utilHoraFin = sdfHora.parse(pro.getHora_fin());
            java.sql.Time sqlHoraFin = new java.sql.Time(utilHoraFin.getTime());
            ps.setTime(6, sqlHoraFin);
            
            ps.setString(7, pro.getCodigo_aro());
            ps.setString(8,pro.getTratamiento_adicional());
            ps.setInt(9, pro.getCantidad());
            ps.setInt(10, pro.getCantidad_atados());
            ps.setInt(11, pro.getCantidad_exs());
            ps.setString(12, pro.getUbicacion());
            ps.execute();
            return true;
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        } catch (ParseException ex) {
            Logger.getLogger(IngresoInventarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.out.println(e.toString());
            }
        }
        return false;
    }
    
    public List<IngresoInventario> InventarioActual(int pagina) {
        List<IngresoInventario> Inv = new ArrayList<>();
        int offset = (pagina - 1) * 28;

        String sql = "SELECT * FROM produccion_diaria ORDER BY folio DESC LIMIT 28 OFFSET ?";

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = cn.getConnection(); // <-- esto podría regresar null si ya hay demasiadas conexiones
            if (con == null) {
                System.out.println("No se pudo establecer la conexión. Posiblemente hay demasiadas conexiones abiertas.");
                return Inv;
            }

            ps = con.prepareStatement(sql);
            ps.setInt(1, offset);
            rs = ps.executeQuery();

            while (rs.next()) {
                IngresoInventario inv = new IngresoInventario();
                inv.setFolio(rs.getString("folio"));
                inv.setFecha(rs.getString("fecha"));
                inv.setId_soldador(rs.getInt("id_soldador"));
                inv.setCaseta(rs.getInt("caseta"));
                inv.setHora_inicio(rs.getString("hora_inicio"));
                inv.setHora_fin(rs.getString("hora_fin"));
                inv.setCodigo_aro(rs.getString("codigo_aro"));
                inv.setTratamiento_adicional(rs.getString("tratamiento_adicional"));
                inv.setCantidad(rs.getInt("cantidad"));
                inv.setCantidad_atados(rs.getInt("cantidad_atados"));
                inv.setCantidad_exs(rs.getInt("cantidad_disp"));
                inv.setUbicacion(rs.getString("ubicacion"));
                Inv.add(inv);
            }
        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.toString());
        } finally {
            // Cerramos en orden inverso
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

        return Inv;
    }  
    
    public List InventarioF(String folio){
        List<IngresoInventario> Inv = new ArrayList();
        String sql = "SELECT * FROM produccion_diaria WHERE folio = ?";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, folio);
            rs = ps.executeQuery();
            while(rs.next()){
                IngresoInventario inv = new IngresoInventario();
                inv.setFolio(rs.getString("folio"));
                inv.setFecha(rs.getString("fecha"));
                inv.setId_soldador(rs.getInt("id_soldador"));
                inv.setCaseta(rs.getInt("caseta"));
                inv.setHora_inicio(rs.getString("hora_inicio"));
                inv.setHora_fin(rs.getString("hora_fin"));
                inv.setCodigo_aro(rs.getString("codigo_aro"));
                inv.setTratamiento_adicional(rs.getString("tratamiento_adicional"));
                inv.setCantidad(rs.getInt("cantidad"));
                inv.setCantidad_atados(rs.getInt("cantidad_atados"));
                inv.setCantidad_exs(rs.getInt("cantidad_disp"));
                inv.setUbicacion(rs.getString("ubicacion"));
                Inv.add(inv);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return Inv;
    }
    
    public List InventarioC(int pagina, String clave){
        List<IngresoInventario> Inv = new ArrayList<>();
        int offset = (pagina - 1) * 28;

        String sql = "SELECT * FROM produccion_diaria WHERE codigo_aro = ? ORDER BY folio DESC LIMIT 28 OFFSET ?";

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = cn.getConnection(); // <-- esto podría regresar null si ya hay demasiadas conexiones
            if (con == null) {
                System.out.println("No se pudo establecer la conexión. Posiblemente hay demasiadas conexiones abiertas.");
                return Inv;
            }
            ps = con.prepareStatement(sql);
            ps.setString(1, clave);
            ps.setInt(2, offset);
            rs = ps.executeQuery();
            while (rs.next()) {
                IngresoInventario inv = new IngresoInventario();
                inv.setFolio(rs.getString("folio"));
                inv.setFecha(rs.getString("fecha"));
                inv.setId_soldador(rs.getInt("id_soldador"));
                inv.setCaseta(rs.getInt("caseta"));
                inv.setHora_inicio(rs.getString("hora_inicio"));
                inv.setHora_fin(rs.getString("hora_fin"));
                inv.setCodigo_aro(rs.getString("codigo_aro"));
                inv.setTratamiento_adicional(rs.getString("tratamiento_adicional"));
                inv.setCantidad(rs.getInt("cantidad"));
                inv.setCantidad_atados(rs.getInt("cantidad_atados"));
                inv.setCantidad_exs(rs.getInt("cantidad_disp"));
                inv.setUbicacion(rs.getString("ubicacion"));
                Inv.add(inv);
            }
        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.toString());
        } finally {
            // Cerramos en orden inverso
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
        return Inv;
    }
              
}
