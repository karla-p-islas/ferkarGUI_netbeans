
package com.ejemplo.app_ferkar.persistencia;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

/**
 *
 * @author kpaor
 */
public class PedidoDAO {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean RegistrarPedido(Pedido pro) throws ParseException{
        String sql = "INSERT INTO pedido(num_pedido, fecha, cliente, estado) VALUES(?,?,?,?) ";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            
            ps.setString(1, pro.getNum_pedido());
            
            SimpleDateFormat sdfFecha = new SimpleDateFormat("dd/MM/yy");
            Date utilDate = sdfFecha.parse(pro.getFecha());
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            ps.setDate(2, sqlDate);
            
            ps.setString(3, pro.getCliente());
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
    
    public List ListarPedidos(){
        List<Pedido> ListaPed = new ArrayList();
        String sql = "SELECT * FROM pedido";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Pedido ped = new Pedido();
                ped.setNum_pedido(rs.getString("num_pedido"));
                ped.setCliente(rs.getString("cliente"));
                ped.setFecha(rs.getString("fecha"));
                ped.setEstado(rs.getString("estado"));
                ListaPed.add(ped);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return ListaPed;
    }
    
}
