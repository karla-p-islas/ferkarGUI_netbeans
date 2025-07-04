
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
public class DetalleCargaDAO {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public List ListarDetCarga(String folio_orden) throws SQLException{
        List<DetalleCarga> DetCarga = new ArrayList();
        String sql = "SELECT * FROM detalle_carga WHERE folio_orden = ? ORDER BY num_serial ASC";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, folio_orden);
            rs = ps.executeQuery();
            while(rs.next()){
                DetalleCarga dc = new DetalleCarga();
                dc.setNum_serial(rs.getString("num_serial"));
                dc.setFolio_orden(rs.getString("folio_orden"));
                dc.setFolio_aro(rs.getString("folio_aro"));
                dc.setClave(rs.getString("clave"));
                dc.setTratamiento_adicional(rs.getString("tratamiento_adicional"));
                dc.setCantidad(rs.getInt("cantidad"));
                DetCarga.add(dc);
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
        return DetCarga;
    }
}
