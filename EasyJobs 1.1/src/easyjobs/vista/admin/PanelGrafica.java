/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easyjobs.vista.admin;

import java.awt.Graphics;
import java.util.Calendar;
import java.util.Date;
import javafx.scene.paint.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class PanelGrafica extends JPanel {

    int[] cantidades;
    Date fechaHoy;

    public int[] getCantidades() {
        return cantidades;
    }

    public void setCantidades(int[] cantidades) {
        this.cantidades = cantidades;
    }

    public int hallarMaximo(int[] cantidades) {
        int maximo = 1;

        for (int i : cantidades) {
            if (i > maximo) {
                maximo = i;
            }
        }

        return maximo;
    }

    public PanelGrafica() {

        this.setSize(450, 150);        
        fechaHoy = new Date();
        repaint();

    }

    public void paint(Graphics g) {

        g.drawLine(25, 120, 375, 120);
        g.drawLine(25, 120, 25, 15);
        g.drawString("Cantidad de registrados por día", 5, 10);        
        int yInicial = 0, yFinal = 0, xInicial = 0, xFinal = 0;
        Calendar c = Calendar.getInstance();                        
        
        for (int i = 0; i < cantidades.length - 1; i++) {
            g.setColor(java.awt.Color.red);
            xInicial = 25 + (375 * i / 7);
            xFinal = 25 + (375 * (i+1) / 7);
            yInicial = 120 - (cantidades[i] * 105 / hallarMaximo(cantidades));
            yFinal = 120 - (cantidades[i+1] * 105 / hallarMaximo(cantidades));
            g.drawLine(xInicial, yInicial, xFinal, yFinal);
            g.setColor(java.awt.Color.black);            
            g.drawString(""+cantidades[i],5,yInicial+6);
            g.drawLine(20, yInicial, 30, yInicial);
            c = Calendar.getInstance();
            c.add(Calendar.DATE,-i);
            String fechaMostrar = c.get(Calendar.DAY_OF_MONTH) + "/" + (c.get(Calendar.MONTH) + 1);            
            g.drawString(fechaMostrar, xInicial, 135);
        }
        c = Calendar.getInstance();
        c.add(Calendar.DATE, -cantidades.length + 1);
        String fechaMostrar = c.get(Calendar.DAY_OF_MONTH) + "/" + (c.get(Calendar.MONTH) + 1);            
        g.drawString(fechaMostrar,xFinal,135);
    }

}
