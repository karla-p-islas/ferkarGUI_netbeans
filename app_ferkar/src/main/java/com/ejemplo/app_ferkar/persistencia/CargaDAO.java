
package com.ejemplo.app_ferkar.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author kpaor
 */
public class CargaDAO {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean InfoCarga(Carga cg) throws ParseException{
        String sql = "INSERT INTO orden_carga(folio_orden, num_pedido, fecha_entrega, modo_pago, num_factura, id_conductor, transporte) VALUES (?,?,?,?,?,?,?)";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            
            ps.setString(1, cg.getFolio_orden());
            ps.setString(2, cg.getNum_pedido());
            
            SimpleDateFormat sdfFecha = new SimpleDateFormat("dd/MM/yy");
            Date utilDate = sdfFecha.parse(cg.getFecha_en());
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            ps.setDate(3, sqlDate);
            
            ps.setString(4, cg.getModo_pago());
            ps.setString(5, cg.getNum_factura());
            ps.setInt(6, cg.getId_conductor());
            ps.setString(7, cg.getTransporte());
            ps.executeQuery();
            
            return true;
        }catch(SQLException e){
            System.out.println(e.toString());
            return false;
        }
    }
    
    public int ArosCargados(DetalleCarga dc){
        String sql ="INSERT INTO detalle_carga (num_serial, folio_orden, folio_aro, clave, tratamiento_adicional, cantidad) VALUES (?,?,?,?,?,?)";
        int rowsAffected = 0;
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, dc.getNum_serial());
            ps.setString(2, dc.getFolio_orden());
            ps.setString(3, dc.getFolio_aro());
            ps.setString(4,String.format("%04d",dc.getClave()));
            ps.setString(5, dc.getTratamiento_adicional());
            ps.setInt(6, dc.getCantidad());
                
            rowsAffected = ps.executeUpdate();
        } catch(SQLException e){
            System.out.println(e.toString());
        }finally{
            try{
             con.close();   
            } catch(SQLException e){
                System.out.println(e.toString());
            }
        }
        return rowsAffected;
    }
    
    //public 
    
}
