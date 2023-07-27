/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Serendipity.Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Lety
 */
public class ClienteDao {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public boolean RegistrarCliente(Cliente cl) {
        String sql = "INSERT INTO clientes (id_c, nombre, apellido, telefono, email) VALUES (?,?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cl.getId_c());
            ps.setString(2, cl.getNombre());
            ps.setString(3, cl.getApp());
            ps.setInt(4, cl.getTelefono());
            ps.setString(5, cl.getEmail());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());

            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }

    public List ListarCliente() {
        List<Cliente> ListaCl = new ArrayList();
        String sql = "SELECT * FROM clientes";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cl = new Cliente();
                cl.setId(rs.getInt("id"));
                cl.setNombre(rs.getString("nombre"));
                cl.setApp(rs.getString("apellido"));
                cl.setTelefono(rs.getInt("telefono"));
                cl.setEmail(rs.getString("email"));
                ListaCl.add(cl);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ListaCl;
    }

    public boolean EliminarCliente(int id) {
        String sql = "DELETE FROM clientes WHERE id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
    }

    public boolean ModificarCliente(Cliente cl) {
        String sql = "UPDATE clientes SET  id_c=?, nombre=?,apellido=?, telefono=?, email=? WHERE id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, cl.getId());
            ps.setString(2, cl.getNombre());
            ps.setString(3, cl.getApp());
            ps.setInt(4, cl.getTelefono());
            ps.setString(4, cl.getEmail());
            ps.setInt(5, cl.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }

    public Cliente Buscarcliente(int id_c) {
        Cliente cl = new Cliente();
        String sql = "SELECT * FROM clientes WHERE id_c = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id_c);
            rs = ps.executeQuery();
            if (rs.next()) {
                cl.setId(rs.getInt("id_c"));
                cl.setNombre(rs.getString("nombre"));
                cl.setApp(rs.getString("apellido"));
                cl.setTelefono(rs.getInt("telefono"));
                cl.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return cl;
    }

}
