
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
public class DetallePedidoDAO {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
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
