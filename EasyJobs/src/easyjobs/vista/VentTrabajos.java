/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyjobs.vista;

import easyjobs.controlador.Controlador;
import java.util.ArrayList;
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

    public VentTrabajos(Controlador control) {
        this.control = control;
        initComponents();
        btnAceptar.addActionListener(control);
    }

    public JButton getBtnAceptar() {
        return btnAceptar;
    }

    public JCheckBox getCheck1() {
        return check1;
    }

    public JCheckBox getCheck10() {
        return check10;
    }

    public JCheckBox getCheck2() {
        return check2;
    }

    public JCheckBox getCheck3() {
        return check3;
    }

    public JCheckBox getCheck4() {
        return check4;
    }

    public JCheckBox getCheck5() {
        return check5;
    }

    public JCheckBox getCheck6() {
        return check6;
    }

    public JCheckBox getCheck7() {
        return check7;
    }

    public JCheckBox getCheck8() {
        return check8;
    }

    public JCheckBox getCheck9() {
        return check9;
    }

    public JCheckBox getCheckOtro() {
        return checkOtro;
    }

    public JTextField getTxtOtro() {
        return txtOtro;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlSelectorTrabajos = new javax.swing.JPanel();
        check1 = new javax.swing.JCheckBox();
        check2 = new javax.swing.JCheckBox();
        check3 = new javax.swing.JCheckBox();
        check4 = new javax.swing.JCheckBox();
        check5 = new javax.swing.JCheckBox();
        check6 = new javax.swing.JCheckBox();
        check7 = new javax.swing.JCheckBox();
        check8 = new javax.swing.JCheckBox();
        check9 = new javax.swing.JCheckBox();
        check10 = new javax.swing.JCheckBox();
        checkOtro = new javax.swing.JCheckBox();
        txtOtro = new javax.swing.JTextField();
        lblMayorDemanda = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlSelectorTrabajos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Trabajos con mayor demanda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        check1.setText("Trabajo1");

        check2.setText("Trabajo2");

        check3.setText("Trabajo3");

        check4.setText("Trabajo4");

        check5.setText("Trabajo5");

        check6.setText("Trabajo6");

        check7.setText("Trabajo7");

        check8.setText("Trabajo8");

        check9.setText("Trabajo9");

        check10.setText("Trabajo10");

        checkOtro.setText("Otro ¿Cuál?");

        javax.swing.GroupLayout pnlSelectorTrabajosLayout = new javax.swing.GroupLayout(pnlSelectorTrabajos);
        pnlSelectorTrabajos.setLayout(pnlSelectorTrabajosLayout);
        pnlSelectorTrabajosLayout.setHorizontalGroup(
            pnlSelectorTrabajosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSelectorTrabajosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSelectorTrabajosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(check5)
                    .addComponent(check1)
                    .addComponent(check2)
                    .addComponent(check3)
                    .addComponent(check4)
                    .addComponent(check6))
                .addGap(160, 160, 160)
                .addGroup(pnlSelectorTrabajosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSelectorTrabajosLayout.createSequentialGroup()
                        .addComponent(checkOtro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtOtro, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(check10)
                    .addComponent(check9)
                    .addComponent(check8)
                    .addComponent(check7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlSelectorTrabajosLayout.setVerticalGroup(
            pnlSelectorTrabajosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSelectorTrabajosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSelectorTrabajosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSelectorTrabajosLayout.createSequentialGroup()
                        .addComponent(check1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(check2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(check3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(check4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(check5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(check6))
                    .addGroup(pnlSelectorTrabajosLayout.createSequentialGroup()
                        .addComponent(check7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(check8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(check9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(check10)
                        .addGap(29, 29, 29)
                        .addGroup(pnlSelectorTrabajosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(checkOtro)
                            .addComponent(txtOtro, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        lblMayorDemanda.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        lblMayorDemanda.setText("Mayor demanda");

        btnAceptar.setText("Aceptar");

        btnCancelar.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlSelectorTrabajos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblMayorDemanda, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(300, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAceptar)
                .addGap(61, 61, 61))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblMayorDemanda, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlSelectorTrabajos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JCheckBox check1;
    private javax.swing.JCheckBox check10;
    private javax.swing.JCheckBox check2;
    private javax.swing.JCheckBox check3;
    private javax.swing.JCheckBox check4;
    private javax.swing.JCheckBox check5;
    private javax.swing.JCheckBox check6;
    private javax.swing.JCheckBox check7;
    private javax.swing.JCheckBox check8;
    private javax.swing.JCheckBox check9;
    private javax.swing.JCheckBox checkOtro;
    private javax.swing.JLabel lblMayorDemanda;
    private javax.swing.JPanel pnlSelectorTrabajos;
    private javax.swing.JTextField txtOtro;
    // End of variables declaration//GEN-END:variables
}
