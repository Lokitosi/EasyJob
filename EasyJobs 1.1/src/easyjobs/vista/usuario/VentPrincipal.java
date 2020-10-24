/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyjobs.vista.usuario;

import easyjobs.Usuario;
import easyjobs.controlador.Controlador;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneLayout;


public class VentPrincipal extends javax.swing.JFrame {
    
    Controlador control;
    Usuario user;
    PanelTrabajo[] ofertas;    
    
    public PanelTrabajo[] getOfertas() {
        return ofertas;
    }
    
    public Usuario getUser() {
        return user;
    }
    
    public void setUser(Usuario user) {
        this.user = user;
    }

    public JButton getBtnEstadisticas() {
        return btnEstadisticas;
    }         
    
    public void ponerDatos() {
        this.lblUsuario.setText(user.getNombre());
        if(this.user.isAdmin()){
            btnEstadisticas.setVisible(true);            
        }else{
            btnEstadisticas.setVisible(false);            
        }
        
        if(!(this.user.isEnviarNotificaciones())){
            btnEnviarCorreo.setVisible(true);
        }else{
            btnEnviarCorreo.setVisible(false);
        }
    }

    public JButton getBtnEnviarCorreo() {
        return btnEnviarCorreo;
    }
    
    public VentPrincipal(Controlador ctrl) {
        ofertas = new PanelTrabajo[10];
        pnlTrabajos = new JPanel();        
        this.setResizable(false);        
        control = ctrl;
        initComponents();        
        ImageIcon foto2 = new ImageIcon("./img/fondoprueba.jpg");
        Icon logo2 = new ImageIcon(foto2.getImage().getScaledInstance(fondo.getWidth(),fondo.getHeight(), Image.SCALE_SMOOTH));
        fondo.setIcon(logo2);
        btnCerrarSesion.addActionListener(control);
        btnEditar.addActionListener(control);
        btnEditarTrabajos.addActionListener(control);
        btnEstadisticas.addActionListener(control);           
        btnEnviarCorreo.addActionListener(control);
    }    
    
    public JPanel getPnlTrabajos() {
        return pnlTrabajos;
    }    
    
    public JButton getBtnEditarTrabajos() {
        return btnEditarTrabajos;
    }
    
    public JButton getBtnCerrarSesion() {
        return btnCerrarSesion;
    }
    
    public JButton getBtnEditar() {
        return btnEditar;
    }
    
    public JLabel getLblTrabajo() {
        return lblTrabajo;
    }
    
    public JLabel getLblUsuario() {
        return lblUsuario;
    }
    
    public JPanel getPnlInformacion() {
        return pnlInformacion;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblMayorDemanda = new javax.swing.JLabel();
        pnlInformacion = new javax.swing.JPanel();
        lblInfo = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblTrabajo = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        btnCerrarSesion = new javax.swing.JButton();
        btnEditarTrabajos = new javax.swing.JButton();
        btnEstadisticas = new javax.swing.JButton();
        btnEnviarCorreo = new javax.swing.JButton();
        scroll = new javax.swing.JScrollPane();
        pnlTrabajos = new javax.swing.JPanel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblMayorDemanda.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        lblMayorDemanda.setText("Ofertas Laborales");
        jPanel1.add(lblMayorDemanda, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 223, 40));

        pnlInformacion.setBackground(new java.awt.Color(0, 153, 204));
        pnlInformacion.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblInfo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblInfo.setForeground(new java.awt.Color(255, 255, 255));
        lblInfo.setText("Información");

        lblUsuario.setBackground(new java.awt.Color(255, 255, 255));
        lblUsuario.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(255, 255, 255));

        lblTrabajo.setBackground(new java.awt.Color(255, 255, 255));

        btnEditar.setText("Editar perfil");

        btnCerrarSesion.setText("Cerrar sesión");

        btnEditarTrabajos.setText("Editar trabajos");

        btnEstadisticas.setText("Ver estadísticas");

        btnEnviarCorreo.setText("Enviar Correo");

        javax.swing.GroupLayout pnlInformacionLayout = new javax.swing.GroupLayout(pnlInformacion);
        pnlInformacion.setLayout(pnlInformacionLayout);
        pnlInformacionLayout.setHorizontalGroup(
            pnlInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInformacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCerrarSesion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditarTrabajos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEstadisticas, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                    .addGroup(pnlInformacionLayout.createSequentialGroup()
                        .addGroup(pnlInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lblTrabajo, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                .addComponent(lblUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(lblInfo))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnEnviarCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlInformacionLayout.setVerticalGroup(
            pnlInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInformacionLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditarTrabajos)
                .addGap(2, 2, 2)
                .addComponent(btnEnviarCorreo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEstadisticas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                .addComponent(btnCerrarSesion)
                .addContainerGap())
        );

        jPanel1.add(pnlInformacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(676, 52, 180, -1));

        scroll.setOpaque(false);

        pnlTrabajos.setBackground(new java.awt.Color(0, 153, 255));
        pnlTrabajos.setForeground(new java.awt.Color(60, 63, 65));
        pnlTrabajos.setPreferredSize(new java.awt.Dimension(551, 1800));

        javax.swing.GroupLayout pnlTrabajosLayout = new javax.swing.GroupLayout(pnlTrabajos);
        pnlTrabajos.setLayout(pnlTrabajosLayout);
        pnlTrabajosLayout.setHorizontalGroup(
            pnlTrabajosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlTrabajosLayout.setVerticalGroup(
            pnlTrabajosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1800, Short.MAX_VALUE)
        );

        scroll.setViewportView(pnlTrabajos);

        jPanel1.add(scroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 52, 660, 432));

        fondo.setToolTipText("");
        jPanel1.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 0, 870, 490));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEditarTrabajos;
    private javax.swing.JButton btnEnviarCorreo;
    private javax.swing.JButton btnEstadisticas;
    private javax.swing.JLabel fondo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblMayorDemanda;
    private javax.swing.JLabel lblTrabajo;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel pnlInformacion;
    private javax.swing.JPanel pnlTrabajos;
    private javax.swing.JScrollPane scroll;
    // End of variables declaration//GEN-END:variables

}
