
package com.ejemplo.app_ferkar.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;

/**
 *
 * @author kpaor
 */
public class DetallePedidoDAO {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public void ListarOrdenes(String pedido, JComboBox ordenes){
        String sql = "SELECT folio_orden FROM orden_carga WHERE num_pedido = ? ORDER BY folio_orden ASC";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, pedido);
            rs = ps.executeQuery();
            while(rs.next()){
                ordenes.addItem(rs.getString("folio_orden"));
            }
        }catch(SQLException e){
            System.out.print(e.toString());
        }finally{
            try{
                con.close();
            }catch(SQLException e3){
                System.out.println(e3.toString());
            }
        }
    }
    
    public List ListarInfo(String folio){
        List<Carga> InfoCarga = new ArrayList();
        String sql = "SELECT * FROM orden_carga WHERE folio_orden = ?";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, folio);
            rs = ps.executeQuery();
            while(rs.next()){
                Carga info = new Carga();
                info.setFolio_orden(rs.getString("folio_orden"));
                info.setNum_pedido(rs.getString("num_pedido"));
                info.setFecha_en(rs.getString("fecha_entrega"));
                info.setModo_pago(rs.getString("modo_pago"));
                info.setNum_factura(rs.getString("num_factura"));
                info.setId_conductor(rs.getInt("id_conductor"));
                info.setTransporte(rs.getString("transporte"));
                InfoCarga.add(info);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return InfoCarga;
    }
    
    public List ListarDetalles(String pedido){
        List<DetallePedido> Detalles = new ArrayList();
        String sql ="SELECT * FROM detalle_pedido WHERE num_pedido = ? ORDER BY num_serial ASC";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, pedido);
            rs = ps.executeQuery();
            while(rs.next()){
                DetallePedido dp = new DetallePedido();
                dp.setNum_serial(rs.getString("num_serial"));
                dp.setNum_pedido(rs.getString("num_pedido"));
                dp.setCodigo_aro(rs.getString("clave_aro"));
                dp.setTratamiento_adicional(rs.getString("tratamiento_adicional"));
                dp.setCantidad(rs.getInt("cantidad"));
                Detalles.add(dp);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }finally{
            try{
                con.close();
            }catch(SQLException e3){
                System.out.println(e3.toString());
            }
        }
        return Detalles;
    }
}
