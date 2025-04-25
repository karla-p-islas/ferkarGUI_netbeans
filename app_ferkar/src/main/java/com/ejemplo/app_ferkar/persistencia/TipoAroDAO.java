
package com.ejemplo.app_ferkar.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author kpaor
 */
public class TipoAroDAO {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public TipoAro BuscarPro (String clave) throws SQLException{
        TipoAro aro = new TipoAro();
        String sql = "SELECT * FROM db_aros WHERE codigo = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, clave);
            rs = ps.executeQuery();
            if (rs.next()){
                aro.setCodigo_aro(rs.getInt("codigo"));
                aro.setMedida(rs.getString("medida"));
                aro.setCalibre(rs.getInt("calibre"));
                aro.setAncho(rs.getInt("ancho"));
                aro.setDescripcion_esp(rs.getString("descripcion_esp"));
                aro.setDescripcion_gen(rs.getString("descripcion_gen"));
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return aro;
    }
}
