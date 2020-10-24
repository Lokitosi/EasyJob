package easyjobs.vista.usuario;

import easyjobs.controlador.Controlador;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
/**
 *
 * @author Alejandro
 */
public class VentTrabajos extends javax.swing.JFrame {

    Controlador control;
    boolean[] trabajosSeleccionados = new boolean[11];
    ArrayList<String> listaTrabajosSeleccionados;
    JCheckBox[] checks = new JCheckBox[11];    
    String[] trabajos ={"Asesoría en ventas","Callcenter","Transporte","Logística","Operario","Informática","Turismo","Artes gráficas","Docencia","Ingeniería","Otro"}; 
   

    public VentTrabajos(Controlador control) {
        this.control = control;
        initComponents();
        ImageIcon foto2 = new ImageIcon("./img/fondoprueba.jpg");
        Icon logo2 = new ImageIcon(foto2.getImage().getScaledInstance(fondo.getWidth(),fondo.getHeight(), Image.SCALE_SMOOTH));
        fondo.setIcon(logo2);
        this.setLocationRelativeTo(null);
        for(int i = 0; i < checks.length; i++){
            checks[i] = new JCheckBox();
            checks[i].setOpaque(false);
            checks[i].setFont(new Font("arial",Font.BOLD,18));
        }
        for(int i = 0; i < 6; i++){
            checks[i].setBounds(20, 20+(25*i), 200, 20);
        }
        for(int i = 6; i < checks.length-1; i++){
            checks[i].setBounds(240, 20+(25*(i-6)), 180, 20);
        }
        checks[checks.length-1].setBounds(this.txtOtro.getX()-80, txtOtro.getY(), 80, 20);
        for(int i = 0; i < checks.length; i++){
            checks[i].setText(trabajos[i]);
        }
        
        for(int i = 0; i < checks.length; i++){
            pnlSelectorTrabajos.add(checks[i]);
        }
        btnAceptar.addActionListener(control);
        btnCancelar.addActionListener(control);
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public JButton getBtnAceptar() {
        return btnAceptar;
    }

    public JCheckBox[] getChecks() {
        return checks;
    }
   

    public JTextField getTxtOtro() {
        return txtOtro;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnlSelectorTrabajos = new javax.swing.JPanel();
        txtOtro = new javax.swing.JTextField();
        lblMayorDemanda = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EasyJobs : Seleccion de trabajo");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlSelectorTrabajos.setBackground(new java.awt.Color(105, 142, 184));
        pnlSelectorTrabajos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlSelectorTrabajos.setForeground(new java.awt.Color(105, 142, 184));

        txtOtro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOtroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSelectorTrabajosLayout = new javax.swing.GroupLayout(pnlSelectorTrabajos);
        pnlSelectorTrabajos.setLayout(pnlSelectorTrabajosLayout);
        pnlSelectorTrabajosLayout.setHorizontalGroup(
            pnlSelectorTrabajosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSelectorTrabajosLayout.createSequentialGroup()
                .addContainerGap(474, Short.MAX_VALUE)
                .addComponent(txtOtro, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103))
        );
        pnlSelectorTrabajosLayout.setVerticalGroup(
            pnlSelectorTrabajosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSelectorTrabajosLayout.createSequentialGroup()
                .addContainerGap(164, Short.MAX_VALUE)
                .addComponent(txtOtro, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        jPanel1.add(pnlSelectorTrabajos, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 58, 700, 230));

        lblMayorDemanda.setFont(new java.awt.Font("Microsoft YaHei", 0, 24)); // NOI18N
        lblMayorDemanda.setForeground(new java.awt.Color(255, 255, 255));
        lblMayorDemanda.setText("Mayor demanda");
        jPanel1.add(lblMayorDemanda, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 240, 34));

        btnAceptar.setText("Aceptar");
        jPanel1.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 320, 140, -1));

        btnCancelar.setText("Cancelar");
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 140, -1));
        jPanel1.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 730, 400));

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

    private void txtOtroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOtroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOtroActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel fondo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblMayorDemanda;
    private javax.swing.JPanel pnlSelectorTrabajos;
    private javax.swing.JTextField txtOtro;
    // End of variables declaration//GEN-END:variables
}
