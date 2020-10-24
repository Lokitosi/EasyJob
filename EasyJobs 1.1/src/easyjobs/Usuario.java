
package easyjobs;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author EasyJobs Team
 */
public class Usuario implements Serializable{
    
    String nombre;

    public void setTrabajos(ArrayList<String> trabajos) {
        this.trabajos = trabajos;
    }
    String correo;
    String contraseña;  
    ArrayList<String> trabajos;
    boolean admin = false;
    Date fechaRegistro;

    public boolean isAdmin() {
        return admin;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    boolean enviarNotificaciones;

    public ArrayList<String> getTrabajos() {
        return trabajos;
    }

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
