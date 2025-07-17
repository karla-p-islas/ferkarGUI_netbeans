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
        int offset = (pagina - 1) * 15;

        String sql = "SELECT * FROM produccion_diaria ORDER BY folio DESC LIMIT 15 OFFSET ?";

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = cn.getConnection();
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
    
    public List<IngresoInventario> InventarioConsulta(int opcion, String folio, String clave, String ubicacion, String fecha) throws ParseException {
        List<IngresoInventario> inventario = new ArrayList<>();
        String sql;

        switch (opcion) {
            case 1 -> sql = "SELECT * FROM produccion_diaria WHERE folio = ? ORDER BY folio DESC";
            case 2 -> sql = "SELECT * FROM produccion_diaria WHERE fecha = ? ORDER BY folio DESC";
            case 3 -> sql = "SELECT * FROM produccion_diaria WHERE ubicacion = ? ORDER BY folio DESC";
            case 4 -> sql = "SELECT * FROM produccion_diaria WHERE codigo_aro = ? ORDER BY folio DESC";
            case 5 -> sql = "SELECT * FROM produccion_diaria WHERE codigo_aro = ? AND ubicacion = ? ORDER BY folio DESC";
            case 6 -> sql = "SELECT * FROM produccion_diaria WHERE ubicacion = ? AND fecha = ? ORDER BY folio DESC";
            case 7 -> sql = "SELECT * FROM produccion_diaria WHERE codigo_aro = ? AND fecha = ? ORDER BY folio DESC";
            case 8 -> sql = "SELECT * FROM produccion_diaria WHERE codigo_aro = ? AND ubicacion = ? AND fecha = ? ORDER BY folio DESC";
            default -> {
                System.out.println("Opción no válida");
                return inventario;
            }
        }
        try (Connection con = cn.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {
            java.sql.Date sqlDate = null;
            if (fecha != null && !fecha.isEmpty() && opcion >= 2) {
                SimpleDateFormat sdfFecha = new SimpleDateFormat("dd/MM/yy");
                Date utilDate = sdfFecha.parse(fecha);
                sqlDate = new java.sql.Date(utilDate.getTime());
            }
            switch (opcion) {
                case 1 -> ps.setString(1, folio);
                case 2 -> ps.setDate(1, sqlDate);
                case 3 -> ps.setString(1, ubicacion);
                case 4 -> ps.setString(1, clave);
                case 5 -> {
                    ps.setString(1, clave);
                    ps.setString(2, ubicacion);
                }
                case 6 -> {
                    ps.setString(1, ubicacion);
                    ps.setDate(2, sqlDate);
                }
                case 7 -> {
                    ps.setString(1, clave);
                    ps.setDate(2, sqlDate);
                }
                case 8 -> {
                    ps.setString(1, clave);
                    ps.setString(2, ubicacion);
                    ps.setDate(3, sqlDate);
                }
            }

            try (ResultSet rs = ps.executeQuery()) {
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
                    inventario.add(inv);
                }
            }

        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
        }

        return inventario;
    }
    
    public IngresoInventario InfoFolio(String folio){
        String sql = "SELECT * FROM produccion_diaria WHERE folio = ?";
        IngresoInventario inv = null;
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, folio);
            rs = ps.executeQuery();
            if(rs.next()){
                inv = new IngresoInventario(
                    rs.getString("folio"),
                    rs.getString("fecha"),
                    rs.getInt("id_soldador"),
                    rs.getInt("caseta"),
                    rs.getString("hora_inicio"),
                    rs.getString("hora_fin"),
                    rs.getString("codigo_aro"),
                    rs.getString("tratamiento_adicional"),
                    rs.getInt("cantidad"),
                    rs.getInt("cantidad_atados"),
                    rs.getInt("cantidad_disp"),
                    rs.getString("ubicacion")
                );
            }else{
                JOptionPane.showMessageDialog(null, "No se encontró el folio solicitado");
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return inv;
    }
    
    public boolean ModificarFolio(String ubi, String folio){
        String sql = "UPDATE produccion_diaria SET ubicacion = ? WHERE folio = ?";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ubi);
            ps.setString(2, folio);
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
