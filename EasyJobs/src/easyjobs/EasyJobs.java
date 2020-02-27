/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyjobs;

import easyjobs.controlador.Controlador;
import java.util.ArrayList;

/**
 *
 * @author Alejandro
 */
public class EasyJobs {

    
    public static void main(String[] args) {
        ArrayList<Usuario> usuarios = new ArrayList();
        Controlador controlador = new Controlador(usuarios);
    }
    
}
