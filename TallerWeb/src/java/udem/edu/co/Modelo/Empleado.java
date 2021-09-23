/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udem.edu.co.Modelo;

/*
Captura de datos de empleados para realizar login 
 */
public class Empleado {
    
    int id;
    String telefono;
    String nombre;
    String estado;
    String dni;
    String user;

    public Empleado() {
    }

    public Empleado(int id, String telefono, String nombre, String estado, String dni, String user) {
        this.id = id;
        this.telefono = telefono;
        this.nombre = nombre;
        this.estado = estado;
        this.dni = dni;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
    
 
}
