/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udem.edu.co.Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import udem.edu.co.configuracion.Conexion;

/**
 *
 * @author andre
 */
public class ClienteDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public Cliente validar(String user, String dni) {

        Cliente cli = new Cliente();
        String sql = "select * from cliente where User=? and Dni=?";

        try {

            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, dni);
            rs = ps.executeQuery();

            while (rs.next()) {
                cli.setId(rs.getInt("IdCliente"));
                cli.setUser(rs.getString("User"));
                cli.setDni(rs.getString("Dni"));
                cli.setNombres(rs.getString("Nombres"));
            }

        } catch (Exception e) {
            System.out.println("ERROR VALIDAR" + e);

        }
        return cli;

    }

    // Creamos operaciones para el crud
    public List listar() {
        String sql = "select * from cliente";
        List <Cliente> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Cliente cli = new Cliente();
                
                cli.setId(rs.getInt(1));
                cli.setDni(rs.getString(2));
                cli.setNombres(rs.getString(3));
                cli.setDireccion(rs.getString(4));
                cli.setEstado(rs.getString(5));
                cli.setUser(rs.getString(6));
                lista.add(cli);

            }

        } catch (Exception e) {
            System.out.println("ERROR LISTAR" + e);
        }
        return lista;
    }

    public int agregar(Cliente cli) {
        String sql = "insert into cliente (Dni , Nombres, Direccion, Estado,User)values(?,?,?,?,?)";

        try {

            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cli.getDni());
            ps.setString(2, cli.getNombres());
            ps.setString(3, cli.getDireccion());
            ps.setString(4, cli.getEstado());
            ps.setString(5, cli.getUser());
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("ERROR AGREGAR" + e);

        }
        return r;

    }

    public Cliente listarId(int id) {

        Cliente clie = new Cliente();
        String sql = "select * from cliente where IdCliente=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                clie.setDni(rs.getString(2));
                clie.setNombres(rs.getString(3));
                clie.setDireccion(rs.getString(4));
                clie.setEstado(rs.getString(5));
                clie.setUser(rs.getString(6));

            }

        } catch (Exception e) {
            System.out.println("ERROR LISTARID" + e);
        }
        return clie;

    }

    public void delete(int id) {
        String sql = "delete from cliente where IdCliente=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("ERROR DELETE" + e);
        }
    }

    public int actualizar(Cliente cli) {
        String sql = "UPDATE cliente  SET Dni=?,Nombres=?, Direccion=?, Estado=?, User=? WHERE IdCliente=?";

        try {

            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cli.getDni());
            ps.setString(2, cli.getNombres());
            ps.setString(3, cli.getDireccion());
            ps.setString(4, cli.getEstado());
            ps.setString(5, cli.getUser());
            ps.setInt(6, cli.getId());
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("ERROR ACTUALIZAR" + e);

        }
        return r;

    }

}
