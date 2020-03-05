/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyjobs;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Alejandro
 */
public class Usuario implements Serializable{
    
    String nombre;
    String correo;
    String contraseña;  
    ArrayList<String> trabajos;
    boolean enviarNotificaciones;

    public boolean isEnviarNotificaciones() {
        return enviarNotificaciones;
    }

    public void setEnviarNotificaciones(boolean enviarNotificaciones) {
        this.enviarNotificaciones = enviarNotificaciones;
    }
    
    public Usuario(String nombre, String correo, String contraseña, ArrayList<String> trabajos){
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
        this.trabajos = (ArrayList<String>) trabajos.clone();
        this.enviarNotificaciones = true;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
}
