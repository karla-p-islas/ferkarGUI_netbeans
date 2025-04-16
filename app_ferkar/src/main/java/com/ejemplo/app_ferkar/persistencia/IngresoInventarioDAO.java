package com.ejemplo.app_ferkar.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    
    public boolean RegistrarInventario(IngresoInventario pro){
        String sql = "INSERT INTO produccion_diaria (folio,fecha,id_soldador,caseta,hora_inicio,hora_fin,codigo_aro,tratamiento_adicional,cantidad,cantidad_atados) VALUES(?,?,?,?,?,?,?,?,?,?)";
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
            
            ps.setInt(7, pro.getCodigo_aro());
            ps.setString(8,pro.getTratamiento_adicional());
            ps.setInt(9, pro.getCantidad());
            ps.setInt(10, pro.getCantidad_atados());
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
    
    /*public IngresoInventario Buscar(int codigo){
        
    }*/
    
    
}
