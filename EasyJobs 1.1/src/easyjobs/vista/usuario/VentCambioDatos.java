/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyjobs.vista.usuario;

import easyjobs.Usuario;
import easyjobs.controlador.Controlador;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
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
        ImageIcon foto2 = new ImageIcon("./img/fondoprueba.jpg");
        Icon logo2 = new ImageIcon(foto2.getImage().getScaledInstance(fondo.getWidth(),fondo.getHeight(), Image.SCALE_SMOOTH));
        fondo.setIcon(logo2);
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

        jPanel1 = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        btnEliminarCuenta = new javax.swing.JButton();
        btnGuardarDatos = new javax.swing.JButton();
        txtAntiguaContraseña = new javax.swing.JTextField();
        lblAntiguaContraseña = new javax.swing.JLabel();
        checkEnviarNotificaciones = new javax.swing.JCheckBox();
        lblNuevaContraseña = new javax.swing.JLabel();
        txtNuevaContraseña = new javax.swing.JTextField();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EasyJobs/ Cambio de datos");
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCancelar.setText("Cancelar");
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, 265, 120, -1));

        btnEliminarCuenta.setText("Eliminar cuenta");
        jPanel1.add(btnEliminarCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 265, 120, -1));

        btnGuardarDatos.setText("Guardar datos");
        jPanel1.add(btnGuardarDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(448, 265, 120, -1));
        jPanel1.add(txtAntiguaContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(289, 105, 200, -1));

        lblAntiguaContraseña.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lblAntiguaContraseña.setText("Antigua contraseña");
        jPanel1.add(lblAntiguaContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 108, -1, -1));

        checkEnviarNotificaciones.setText("Enviar notificaciones");
        checkEnviarNotificaciones.setOpaque(false);
        checkEnviarNotificaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkEnviarNotificacionesActionPerformed(evt);
            }
        });
        jPanel1.add(checkEnviarNotificaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(404, 206, 160, -1));

        lblNuevaContraseña.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lblNuevaContraseña.setText("Nueva contraseña");
        jPanel1.add(lblNuevaContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 147, -1, -1));
        jPanel1.add(txtNuevaContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(289, 147, 200, -1));
        jPanel1.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, -4, 610, 350));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkEnviarNotificacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkEnviarNotificacionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkEnviarNotificacionesActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminarCuenta;
    private javax.swing.JButton btnGuardarDatos;
    private javax.swing.JCheckBox checkEnviarNotificaciones;
    private javax.swing.JLabel fondo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAntiguaContraseña;
    private javax.swing.JLabel lblNuevaContraseña;
    private javax.swing.JTextField txtAntiguaContraseña;
    private javax.swing.JTextField txtNuevaContraseña;
    // End of variables declaration//GEN-END:variables
}
