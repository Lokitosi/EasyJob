/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyjobs.controlador;

import easyjobs.Usuario;
import easyjobs.vista.VentCambioDatos;
import easyjobs.vista.VentLogin;
import easyjobs.vista.VentRegistrar;
import easyjobs.vista.VentPrincipal;
import easyjobs.vista.VentTrabajos;
import java.awt.Color;
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
    VentPrincipal vPrinc;
    VentCambioDatos vCamb;
    VentTrabajos vTrab;

    int usuarioLogin;
    ArrayList<Usuario> usuarios;
    int REGISTRAR = 1, LOGIN = 2;

    public Controlador(ArrayList users) {
        usuarios = users;
        try {
            cargarArchivo();
            crearLogin();
            crearVCambioDatos();
            crearVTrabajos();
            crearRegistrar();
            crearPrincipal();
            ejecutarLogin();
        } catch (Exception e) {

        }

    }

    //Crea el arreglo de trabajos seleccionados    
    public ArrayList<String> crearArreglo() {
        ArrayList<String> listaTrabajosSeleccionados = new ArrayList();
        if (vTrab.getCheck1().isSelected()) {
            listaTrabajosSeleccionados.add(vTrab.getCheck1().getText());
        }
        if (vTrab.getCheck2().isSelected()) {
            listaTrabajosSeleccionados.add(vTrab.getCheck2().getText());
        }
        if (vTrab.getCheck3().isSelected()) {
            listaTrabajosSeleccionados.add(vTrab.getCheck3().getText());
        }
        if (vTrab.getCheck4().isSelected()) {
            listaTrabajosSeleccionados.add(vTrab.getCheck4().getText());
        }
        if (vTrab.getCheck5().isSelected()) {
            listaTrabajosSeleccionados.add(vTrab.getCheck5().getText());
        }
        if (vTrab.getCheck6().isSelected()) {
            listaTrabajosSeleccionados.add(vTrab.getCheck6().getText());
        }
        if (vTrab.getCheck7().isSelected()) {
            listaTrabajosSeleccionados.add(vTrab.getCheck7().getText());
        }
        if (vTrab.getCheck8().isSelected()) {
            listaTrabajosSeleccionados.add(vTrab.getCheck8().getText());
        }
        if (vTrab.getCheck9().isSelected()) {
            listaTrabajosSeleccionados.add(vTrab.getCheck9().getText());
        }
        if (vTrab.getCheck10().isSelected()) {
            listaTrabajosSeleccionados.add(vTrab.getCheck10().getText());
        }
        if (vTrab.getCheckOtro().isSelected()) {
            listaTrabajosSeleccionados.add(vTrab.getTxtOtro().getText());
        }
        return listaTrabajosSeleccionados;
    }

    // Añadir usuario al arreglo
    public void añadirUsuario() {
        String userTemp = vReg.getTxtUsuario().getText();
        String keyTemp = vReg.getTxtContraseña().getText();
        String mailTemp = vReg.getTxtCorreo().getText();
        ArrayList<String> arreglo = this.crearArreglo();
        for (int i = 0; i < arreglo.size(); i++) {
            System.out.println(arreglo.get(i));
        }
        Usuario temp = new Usuario(userTemp, mailTemp, keyTemp, arreglo);
        usuarios.add(temp);
        guardarArchivo(usuarios);
    }

    // Se valida si la contraseña tiene mínimo 8 caracteres
    public boolean validarContraseña(String contraseña){
        if(contraseña.length()>=8){
            return true;
        }else{
            return false;
        }
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
        vPrinc = new VentPrincipal(this);
    }

    public void crearVTrabajos() {
        vTrab = new VentTrabajos(this);
    }

    public void crearVCambioDatos() {
        vCamb = new VentCambioDatos(this);
    }         

    //Se visualiza una ventana de registrarse
    public void ejecutarRegistrarse() {
        vLog.setVisible(false);
        vReg.setVisible(true);
        vPrinc.setVisible(false);
        vTrab.setVisible(false);
        vCamb.setVisible(false);
        vReg.getTxtContraseña().setText("");
        vReg.getTxtCorreo().setText("");
        vReg.getTxtUsuario().setText("");
    }

    //Se visualiza una ventana de Login
    public void ejecutarLogin() {
        if (cargarArchivo() == false) {
            guardarArchivo(usuarios);
        }
        vReg.setVisible(false);
        vLog.setVisible(true);
        vPrinc.setVisible(false);
        vTrab.setVisible(false);
        vCamb.setVisible(false);
        vLog.getTxtContraseña().setText("");
        vLog.getTxtUsuario().setText("");
    }

    //Se visualiza la ventana principal
    public void ejecutarPrincipal() {
        vLog.setVisible(false);
        vReg.setVisible(false);
        vTrab.setVisible(false);
        vCamb.setVisible(false);
        vPrinc.setUser(usuarios.get(usuarioLogin));
        vPrinc.ponerDatos();
        vPrinc.setVisible(true);
    }

    public void ejecutarVTrabajos() {
        vTrab.setVisible(true);
        vReg.setVisible(false);
        vLog.setVisible(false);
        vPrinc.setVisible(false);
        vCamb.setVisible(false);
    }

    public void ejecutarVCambio(){        
        vTrab.setVisible(false);
        vReg.setVisible(false);
        vLog.setVisible(false);
        vPrinc.setVisible(false);
        vCamb.setUser(usuarios.get(usuarioLogin));
        vCamb.getCheckEnviarNotificaciones().setSelected(usuarios.get(usuarioLogin).isEnviarNotificaciones());
        vCamb.setVisible(true);
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
            if (!validarUsuario(REGISTRAR) && validarContraseña(vReg.getTxtContraseña().getText())) {
                ejecutarVTrabajos();
            } else {
                JOptionPane.showMessageDialog(null, "El nombre de usuario ya está registrado o la contraseña no tiene más de 7 caracteres, intente con otro");
            }

        }
        // Fin métodos ventana Login

        // Métodos ventana principal
        if (ae.getSource().equals(vPrinc.getBtnEditar())) {            
            ejecutarVCambio();            
        }

        if (ae.getSource().equals(vPrinc.getBtnCerrarSesion())) {
            ejecutarLogin();
        }
        // Fin métodos ventana principal

        //Métodos ventana Cambio de datos
        if (ae.getSource().equals(vCamb.getBtnCancelar())) {
            ejecutarPrincipal();
        }

        if (ae.getSource().equals(vCamb.getBtnEliminarCuenta())) {
            try{
                usuarios.remove(usuarioLogin);
            }catch(Exception e){
                
            }
            guardarArchivo(usuarios);
            ejecutarLogin();
        }

        if (ae.getSource().equals(vCamb.getBtnGuardarDatos())) {
            if(vCamb.getTxtAntiguaContraseña().getText().equals(usuarios.get(usuarioLogin).getContraseña()) && validarContraseña(vCamb.getTxtNuevaContraseña().getText())){
                vCamb.getTxtAntiguaContraseña().setForeground(Color.BLACK);
                usuarios.get(usuarioLogin).setContraseña(vCamb.getTxtNuevaContraseña().getText());
                JOptionPane.showMessageDialog(null, "Se han cambiado los datos con éxito");
                usuarios.get(usuarioLogin).setEnviarNotificaciones(vCamb.getCheckEnviarNotificaciones().isSelected());
                guardarArchivo(usuarios);
                vCamb.getTxtAntiguaContraseña().setText("");
                vCamb.getTxtNuevaContraseña().setText("");
                ejecutarPrincipal();
            }else{
                JOptionPane.showMessageDialog(null, "La contraseña es incorrecta o la contraseña nueva no tiene más de 8 caracteres");
            }
        }
        //Fin Métodos ventana cambio de datos

        //Métodos ventana trabajos
        if (ae.getSource().equals(vTrab.getBtnAceptar())) {
            añadirUsuario();
            guardarArchivo(usuarios);
            JOptionPane.showMessageDialog(null, "Usuario registrado con éxito");
            vReg.getTxtContraseña().setText("");
            vReg.getTxtCorreo().setText("");
            vReg.getTxtUsuario().setText("");
        }
        
        if(ae.getSource().equals(vTrab.getBtnAceptar())){
            ejecutarLogin();
        }

        //Fin métodos ventana trabajos
    }
}
