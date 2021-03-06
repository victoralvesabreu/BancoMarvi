/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Victor Alves Abreu
 */
public class DatabasePostgresql  implements Database{
    
    private String usuario = "postgres";
    private String senha = "postgres";
    private String ipaddress = "127.0.0.1:5432";
    private String database = "ImobiliariaMarvi";
    private String url = "jdbc:postgresql://";
    
    @Override
    public Connection connect(){
        try{
            Connection conn;
            url += ipaddress+"/"+database;
            conn = DriverManager.getConnection(url, usuario, senha);
            return conn;
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public void disconnect(Connection conn) {
       try{
           conn.close();
       }catch(SQLException ex){
           System.err.println(ex.getMessage());
       }
    }
}
