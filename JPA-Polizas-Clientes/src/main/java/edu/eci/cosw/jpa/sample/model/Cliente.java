package edu.eci.cosw.jpa.sample.model;
// Generated Mar 9, 2016 7:01:57 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Clientes generated by hbm2java
 */
public class Cliente  implements java.io.Serializable {


     private ClienteId id;
     private String nombre;
     private String direccion;
     private String telefono;     

    public Cliente() {
    }

	
    public Cliente(ClienteId id, String nombre, String direccion, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }
   
    public ClienteId getId() {
        return this.id;
    }
    
    public void setId(ClienteId id) {
        this.id = id;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}


