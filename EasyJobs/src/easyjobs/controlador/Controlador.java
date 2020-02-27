/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyjobs.controlador;

import easyjobs.Usuario;
import easyjobs.vista.VentLogin;
import easyjobs.vista.VentRegistrar;
import easyjobs.vista.VentTrabajos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Controlador implements ActionListener {

    VentLogin vLog;
    VentRegistrar vReg;
    VentTrabajos vPrinc;
    int usuarioLogin;
    ArrayList<Usuario> usuarios;
    int REGISTRAR = 1, LOGIN = 2;

    public Controlador(ArrayList users) {
        usuarios = users;
        try {
            cargarArchivo();
            crearLogin();
            crearRegistrar();
            crearPrincipal();
            ejecutarLogin();
        } catch (Exception e) {

        }

    }

    // Añadir usuario al arreglo
    public void añadirUsuario() {
        String userTemp = vReg.getTxtUsuario().getText();
        String keyTemp = vReg.getTxtContraseña().getText();
        String mailTemp = vReg.getTxtCorreo().getText();
        Usuario temp = new Usuario(userTemp, mailTemp, keyTemp);
        usuarios.add(temp);
        guardarArchivo(usuarios);
    }

    // Se valida si los datos ingresados de usuario y contraseña coinciden con algún usuario guardado
    public boolean validarUsuario(int tipoVentana) {

        boolean correcto = false;
        String userTemp = "", keyTemp = "";
        if (tipoVentana == REGISTRAR) {
            userTemp = vReg.getTxtUsuario().getText();
            keyTemp = vReg.getTxtContraseña().getText();
            for (int i = 0; i < usuarios.size(); i++) {
                if (userTemp.equals(usuarios.get(i).getNombre())) {
                    correcto = true;
                    usuarioLogin = i;
                }
            }
        }

        if (tipoVentana == LOGIN) {
            userTemp = vLog.getTxtUsuario().getText();
            keyTemp = vLog.getTxtContraseña().getText();
            for (int i = 0; i < usuarios.size(); i++) {
                if (userTemp.equals(usuarios.get(i).getNombre()) && keyTemp.equals(usuarios.get(i).getContraseña())) {
                    correcto = true;
                    usuarioLogin = i;
                }
            }
        }

        return correcto;
    }

    // Se crea una ventana de Login
    public void crearLogin() {
        vLog = new VentLogin(this);
        vLog.setVisible(true);
    }

    // Se crea una ventana de Registrar
    public void crearRegistrar() {
        vReg = new VentRegistrar(this);
    }

    // Se crea la ventana principal
    public void crearPrincipal() {
        vPrinc = new VentTrabajos(this);
    }

    //Se visualiza una ventana de registrarse
    public void ejecutarRegistrarse() {
        vLog.setVisible(false);
        vReg.setVisible(true);
        vPrinc.setVisible(false);
        vReg.getTxtContraseña().setText("");
        vReg.getTxtCorreo().setText("");
        vReg.getTxtUsuario().setText("");
    }

    //Se visualiza una ventana de Login
    public void ejecutarLogin() {
        cargarArchivo();
        vReg.setVisible(false);
        vLog.setVisible(true);
        vPrinc.setVisible(false);
        vLog.getTxtContraseña().setText("");
        vLog.getTxtUsuario().setText("");        
    }

    //Se visualiza la ventana principal
    public void ejecutarPrincipal() {
        vLog.setVisible(false);
        vReg.setVisible(false);
        vPrinc.setUser(usuarios.get(usuarioLogin));
        vPrinc.ponerDatos();
        vPrinc.setVisible(true);
    }

    //Se hace la persistencia
    public boolean guardarArchivo(ArrayList usuarios) {
        boolean guardado = true;
        try {
            FileOutputStream fout = new FileOutputStream("./data/usuarios.bin");
            ObjectOutputStream writer = new ObjectOutputStream(fout);
            writer.writeObject(usuarios);
            fout.close();
            writer.close();
        } catch (Exception e) {
            guardado = false;
        }
        return guardado;
    }

    //Se lee la persistencia
    public boolean cargarArchivo() {
        boolean leido = true;
        try {
            FileInputStream fin = new FileInputStream("./data/usuarios.bin");
            ObjectInputStream reader = new ObjectInputStream(fin);
            usuarios = (ArrayList) reader.readObject();
            fin.close();
            reader.close();
        } catch (Exception e) {
            leido = false;
            JOptionPane.showMessageDialog(null, "Hubo un error en la lectura del archivo");
        }
        return leido;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        // Métodos ventana Login
        if (ae.getSource().equals(vLog.getBtnLogin())) {            
            if (validarUsuario(LOGIN)) {
                crearPrincipal();
                ejecutarPrincipal();
            } else {
                JOptionPane.showMessageDialog(null, "Verifique los datos ingresados y vuelva a intentarlo");
            }
        }

        if (ae.getSource().equals(vLog.getBtnRegistrar())) {
            ejecutarRegistrarse();
        }
        // Fin métodos ventana Login

        // Metodos ventana Registrarse
        if (ae.getSource().equals(vReg.getBtnCancelar())) {            
            ejecutarLogin();
        }

        if (ae.getSource().equals(vReg.getBtnSiguiente())) {            
            if(!validarUsuario(REGISTRAR)){
                añadirUsuario();
                guardarArchivo(usuarios);
                JOptionPane.showMessageDialog(null, "Usuario registrado con éxito");
                vReg.getTxtContraseña().setText("");
                vReg.getTxtCorreo().setText("");
                vReg.getTxtUsuario().setText("");
            }else{
                JOptionPane.showMessageDialog(null, "El nombre de usuario ya está registrado, intente con otro");
            }
            
            
        }
        // Fin métodos ventana Login

        // Métodos ventana principal
        if (ae.getSource().equals(vPrinc.getBtnEditar())) {
            System.out.println("btnEditar");
        }

        if (ae.getSource().equals(vPrinc.getBtnCerrarSesion())) {            
            ejecutarLogin();
        }
        // Fin métodos ventana principal
    }
}
