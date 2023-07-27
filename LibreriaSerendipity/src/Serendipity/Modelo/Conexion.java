/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Serendipity.Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author Lety
 */
public class Conexion {
    //Creamos nuestros datos de conexion
    private static Connection conn = null; //
    private static String login = "serendipity";
    private static String key = "velaris"; //Contraseña
    private static String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
    
    //Representacion conexion
    public  Connection getConnection(){
        try {
            
            conn = DriverManager.getConnection(url,login,key);
        } catch (SQLException e) {
            System.out.println("Conexion Erronea "+ e.getMessage());
        }
        return conn;
    } 
    
}
