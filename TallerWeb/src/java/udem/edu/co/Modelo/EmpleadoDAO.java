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

/*


*/
public class EmpleadoDAO {
    
    // Se instancia conexion con base de datos
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public Empleado validar(String user, String dni) {

        Empleado em = new Empleado();
        String sql = "select * from empleado where User=? and Dni=?";

        try {

            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, dni);
            rs = ps.executeQuery();

            while (rs.next()) {
                em.setId(rs.getInt("IdEmpleado"));
                em.setUser(rs.getString("User"));
                em.setDni(rs.getString("Dni"));
                em.setNombre(rs.getString("Nombres"));

            }

        } catch (Exception e) {
            System.out.println("ERROR VALIDAR" + e);

        }
        return em;
        
        //Retorna datos de empleado Validado

    }

    // Creamos operaciones para el crud de empleado
    public List listar() {
        String sql = "select * from empleado";
        List<Empleado> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Empleado em = new Empleado();
                em.setId(rs.getInt(1));
                em.setDni(rs.getString(2));
                em.setNombre(rs.getString(3));
                em.setTelefono(rs.getString(4));
                em.setEstado(rs.getString(5));
                em.setUser(rs.getString(6));
                lista.add(em);

            }

        } catch (Exception e) {
            System.out.println("ERROR LISTAR" + e);
        }
        return lista;
    }

    public int agregar(Empleado em) {
        String sql = "insert into empleado(Dni , Nombres, Telefono, Estado,User)values(?,?,?,?,?)";

        try {

            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, em.getDni());
            ps.setString(2, em.getNombre());
            ps.setString(3, em.getTelefono());
            ps.setString(4, em.getEstado());
            ps.setString(5, em.getUser());
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("ERROR AGREGAR" + e);

        }
        return r;

    }

    public Empleado listarId(int id) {

        Empleado emp = new Empleado();
        String sql = "select * from empleado where IdEmpleado=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                emp.setDni(rs.getString(2));
                emp.setNombre(rs.getString(3));
                emp.setTelefono(rs.getString(4));
                emp.setEstado(rs.getString(5));
                emp.setUser(rs.getString(6));

            }

        } catch (Exception e) {
            System.out.println("ERROR LISTARID" + e);
        }
        return emp;

    }

    public void delete(int id) {
        String sql = "delete from empleado where IdEmpleado=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("ERROR DELETE" + e);
        }
       
    }

    public int Actualizar(Empleado em) {
        String sql = "update empleado set Dni=?, Nombres=?, Telefono=?, Estado=? , User=? where IdEmpleado=?";
        try {

            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, em.getDni());
            ps.setString(2, em.getNombre());
            ps.setString(3, em.getTelefono());
            ps.setString(4, em.getEstado());
            ps.setString(5, em.getUser());
            ps.setInt(6, em.getId());
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("ERROR ACTUALIZAR" + e);

        }
        return r;

    }

}
