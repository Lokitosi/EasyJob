package easyjobs.vista.admin;

import easyjobs.Usuario;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class PanelTorta extends JPanel {

    String[] trabajos;
    int[] cantidad;
    int cantTotal = 0;
    int angInicial, angFinal, cantPersonas;

    public void setCantPersonas(int cantPersonas) {
        this.cantPersonas = cantPersonas;
    }

    public PanelTorta() {
        this.setSize(450, 200);
        this.setBorder(BorderFactory.createTitledBorder("Trabajos más buscados"));
        this.setOpaque(false);
        repaint();
    }

    public int getCantPersonas() {
        return cantPersonas;
    }

    public void setTrabajos(String[] trabajos) {
        this.trabajos = trabajos;
    }

    public void setCantidad(int[] cantidad) {
        this.cantidad = cantidad;
        angInicial = 0;
        angFinal = 0;
    }

    public void paint(Graphics g) {

        super.paint(g);
        cantTotal = 0;
        Color[] color = new Color[10];
        color[0] = new Color(159, 1, 1);
        color[1] = new Color(223, 236, 18);
        color[2] = new Color(74, 214, 13);
        color[3] = new Color(12, 200, 197);
        color[4] = new Color(43, 98, 200);
        color[5] = new Color(141, 47, 224);
        color[6] = new Color(202, 23, 189);
        color[7] = new Color(189, 21, 100);
        color[8] = new Color(220, 20, 20);
        color[9] = new Color(129, 244, 149);

        for (int i = 0; i < this.cantidad.length; i++) {
            cantTotal += this.cantidad[i];
        }       
        
        for (int i = 0; i < this.cantidad.length; i++) {
            g.setColor(color[i]);
            angFinal =(cantidad[i]*360/cantTotal);            
            g.fillArc(5, 20, 170, 170, angInicial, angFinal);
            angInicial += angFinal;
            g.fillRect(200, 5+(this.getHeight()*(i+1)/12), 10, 10);
            g.setColor(Color.black);
            float porcentaje;
            porcentaje = cantidad[i]*100/cantTotal;
            g.drawString("("+porcentaje+"%)"+trabajos[i], 260, 15+(this.getHeight()*(i+1)/12));
        }        
    }
}
