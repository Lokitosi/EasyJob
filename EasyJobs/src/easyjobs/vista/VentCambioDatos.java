/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyjobs.vista;

import easyjobs.Usuario;
import easyjobs.controlador.Controlador;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

/**
 *
 * @author Alejandro
 */
public class VentCambioDatos extends javax.swing.JFrame {

    Controlador control;
    Usuario user;
    public VentCambioDatos(Controlador control) {
        this.control = control;
        initComponents();
        btnCancelar.addActionListener(control);
        btnEliminarCuenta.addActionListener(control);
        btnGuardarDatos.addActionListener(control);
    }

    public JCheckBox getCheckEnviarNotificaciones() {
        return checkEnviarNotificaciones;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public JButton getBtnEliminarCuenta() {
        return btnEliminarCuenta;
    }

    public JButton getBtnGuardarDatos() {
        return btnGuardarDatos;
    }

    public JTextField getTxtAntiguaContraseña() {
        return txtAntiguaContraseña;
    }

    public JTextField getTxtNuevaContraseña() {
        return txtNuevaContraseña;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCancelar = new javax.swing.JButton();
        btnEliminarCuenta = new javax.swing.JButton();
        btnGuardarDatos = new javax.swing.JButton();
        txtAntiguaContraseña = new javax.swing.JTextField();
        txtNuevaContraseña = new javax.swing.JTextField();
        lblAntiguaContraseña = new javax.swing.JLabel();
        lblNuevaContraseña = new javax.swing.JLabel();
        checkEnviarNotificaciones = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnCancelar.setText("Cancelar");

        btnEliminarCuenta.setText("Eliminar cuenta");

        btnGuardarDatos.setText("Guardar datos");

        lblAntiguaContraseña.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lblAntiguaContraseña.setText("Antigua contraseña");

        lblNuevaContraseña.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lblNuevaContraseña.setText("Nueva contraseña");

        checkEnviarNotificaciones.setText("Enviar notificaciones");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAntiguaContraseña)
                    .addComponent(lblNuevaContraseña))
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNuevaContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAntiguaContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60))
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(checkEnviarNotificaciones)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnEliminarCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(btnGuardarDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(92, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAntiguaContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAntiguaContraseña))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNuevaContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNuevaContraseña))
                .addGap(18, 18, 18)
                .addComponent(checkEnviarNotificaciones)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnEliminarCuenta)
                    .addComponent(btnGuardarDatos))
                .addGap(57, 57, 57))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminarCuenta;
    private javax.swing.JButton btnGuardarDatos;
    private javax.swing.JCheckBox checkEnviarNotificaciones;
    private javax.swing.JLabel lblAntiguaContraseña;
    private javax.swing.JLabel lblNuevaContraseña;
    private javax.swing.JTextField txtAntiguaContraseña;
    private javax.swing.JTextField txtNuevaContraseña;
    // End of variables declaration//GEN-END:variables
}
