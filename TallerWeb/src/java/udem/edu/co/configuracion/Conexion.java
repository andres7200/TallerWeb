/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udem.edu.co.configuracion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author andre
 */
public class Conexion {

    // Se realiza conexion con la base de datos
    Connection con;
    String url = "jdbc:mysql://localhost:3306/bd_pruebaventas?useSSL=false";
    String user = "root";
    String pass = "12345678";

    public Connection Conexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);

        } catch (Exception e) {
            System.out.println("El error es " + e);
        }
        return con;
    }
}
