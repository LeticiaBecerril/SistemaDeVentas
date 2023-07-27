/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Serendipity.Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Lety
 */
public class loginDAO {

    Connection con;
    PreparedStatement ps=null;
    ResultSet rs;
    Conexion cn= new Conexion();

    public login log(String cuenta, String pass) {
        login l = new login();
        String sql = "SELECT * FROM empleado WHERE cuenta = ? AND pass = ?";

        try {
            con = cn.getConnection();
            ps= con.prepareStatement(sql);
            ps.setString(1, cuenta);
            ps.setString(2, pass);
            rs =ps.executeQuery();
            if(rs.next()){
                l.setId(rs.getInt("id"));
                l.setNombre(rs.getString("nombre"));
                l.setApellido(rs.getString("apellido"));
                l.setTelefono(rs.getInt("telefono"));
                l.setCurp(rs.getString("curp"));
                l.setCuenta(rs.getString("cuenta"));
                l.setPass(rs.getString("pass"));
                
            }

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return l;
    }
}
