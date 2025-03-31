package com.ejemplo.app_ferkar.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author kpaor
 */
public class Conexion {
    Connection con;
    
    public Connection getConnection(){
        try{
            String myBD = "jdbc:postgresql://localhost:5432/ferkar_V2?servertimezone=UTC";
            con = DriverManager.getConnection(myBD, "postgres", "ferkar");
            return con;
        }catch (SQLException e){
            System.out.println(e.toString());
        }
        return null;
    }
}
