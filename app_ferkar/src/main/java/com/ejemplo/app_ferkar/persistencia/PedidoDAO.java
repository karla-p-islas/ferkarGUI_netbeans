
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
public class PedidoDAO {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    
    public boolean RegistrarPedido(Pedido pro) throws ParseException{
        String sql = "INSERT INTO pedido(num_pedido, fecha, id_cliente, estado) VALUES(?,?,?,?) ";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            
            ps.setString(1, pro.getNum_pedido());
            
            SimpleDateFormat sdfFecha = new SimpleDateFormat("dd/MM/yy");
            Date utilDate = sdfFecha.parse(pro.getFecha());
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            ps.setDate(2, sqlDate);
            
            ps.setInt(3, pro.getId_cliente());
            ps.setString(4, "Pedido");
            
            ResultSet executeQuery = ps.executeQuery();
            
        }catch(SQLException e){
            System.out.println(e);
        }finally{
            try{
             con.close();   
            } catch(SQLException e){
                System.out.println(e.toString());
            }
        }
        return false;
    }
    
    public int RegistroDetalle(DetallePedido DP){
        String sql = "INSERT INTO detalle_pedido(num_serial, num_pedido, clave_aro, tratamiento_adicional, cantidad) VALUES (?,?,?,?,?)";
        int rowsAffected = 0;
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, DP.getNum_serial());
            ps.setString(2, DP.getNum_pedido());
            ps.setInt(3, DP.getCodigo_aro());
            ps.setString(4, DP.getTratamiento_adicional());
            ps.setInt(5, DP.getCantidad());
            
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
    
}
