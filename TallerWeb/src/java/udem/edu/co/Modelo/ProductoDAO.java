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
public class ProductoDAO {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    

    // Creamos operaciones para el crud
    public List listar() {
        String sql = "select * from producto";
        List<Producto> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Producto pro = new Producto();
                pro.setId(rs.getInt(1));
                pro.setNombre(rs.getString(2));
                pro.setPrecio(rs.getString(3));
                pro.setStock(rs.getString(4));
                pro.setEstado(rs.getString(5));
                lista.add(pro);

            }

        } catch (Exception e) {
            System.out.println("ERROR LISTAR"+e);
        }
        return lista;
    }

    public int agregar(Producto pro) {
        String sql = "insert into producto(Nombres , Precio, Stock, Estado)values(?,?,?,?)";

        try {

            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getNombre());
            ps.setString(2, pro.getPrecio());
            ps.setString(3, pro.getStock());
            ps.setString(4, pro.getEstado());
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("ERROR AGREGAR"+e);

        }
        return r;

    }

    public Producto listarId(int id) {

        Producto prod = new Producto();
        String sql = "select * from producto where IdProducto=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                prod.setNombre(rs.getString(2));
                prod.setPrecio(rs.getString(3));
                prod.setStock(rs.getString(4));
                prod.setEstado(rs.getString(5));
            }

        } catch (Exception e) {
            System.out.println("ERROR LISTARID"+e);
        }
        return prod;

    }

    public void  delete(int id) {
        String sql = "delete from producto where IdProducto=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("ERROR DELETE"+e);
        }
       

    }

    public int actualizar(Producto pro) {
        String sql = "update producto set Nombres=?, Precio=?, Stock=? , Estado=? where IdProducto=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getNombre());
            ps.setString(2, pro.getPrecio());
            ps.setString(3, pro.getStock());
            ps.setString(4, pro.getEstado());
            ps.setInt(5, pro.getId());
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("ERROR ACTUALIZAR"+e);

        }
        return r;

    }


    
    
}
