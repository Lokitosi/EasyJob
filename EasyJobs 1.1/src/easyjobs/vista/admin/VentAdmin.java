package easyjobs.vista.admin;

import easyjobs.Usuario;
import easyjobs.controlador.Controlador;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentAdmin extends JFrame {

    PanelTorta pnlTorta = new PanelTorta();
    int cantPersonas;
    PanelGrafica pnlGrafica = new PanelGrafica();
    JLabel nUsuarios;

    public void setPnlTorta(PanelTorta pnlTorta) {
        this.pnlTorta = pnlTorta;
    }

    public void setCantPersonas(int cantPersonas) {
        this.cantPersonas = cantPersonas;
    }

    public PanelGrafica getPnlGrafica() {
        return pnlGrafica;
    }
    Controlador control;

    public VentAdmin(Controlador control) {
        
        this.setBounds(10, 10, 900, 500);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        JLabel fondo = new JLabel();
        fondo.setBounds(0, 0, 900, 500);
        ImageIcon foto2 = new ImageIcon("./img/fondoprueba.jpg");
        Icon logo2 = new ImageIcon(foto2.getImage().getScaledInstance(fondo.getWidth(),fondo.getHeight(), Image.SCALE_SMOOTH));
        fondo.setIcon(logo2);
        
        JLabel titulo = new JLabel("Estadisticas de EasyJobs");
        titulo.setBounds(200, 5, 800, 45);
        titulo.setFont(new Font("Tommy", Font.BOLD, 40));

        JLabel usuarios = new JLabel("Numero de usuarios registrados:");
        usuarios.setFont(new Font("arial", Font.BOLD, 20));
        usuarios.setBounds(10, 90, 400, 25);
        
        nUsuarios = new JLabel();
        nUsuarios.setFont(new Font("arial", Font.BOLD, 30));
        nUsuarios.setBounds(10, 115, 200, 30);

        this.control = control;
        this.setLayout(null);
        this.getPnlTorta().setBounds(10, 200, pnlTorta.getWidth(), pnlTorta.getHeight());
        this.getPnlGrafica().setBounds(pnlTorta.getWidth() + 30, 250, pnlGrafica.getWidth(), pnlGrafica.getHeight());

        this.add(usuarios);
        this.add(nUsuarios);
        this.add(titulo);
        this.add(pnlTorta);
        this.add(pnlGrafica);
        this.add(fondo);
    }

    public JLabel getnUsuarios() {
        return nUsuarios;
    }

    public PanelTorta getPnlTorta() {
        return pnlTorta;
    }

}
