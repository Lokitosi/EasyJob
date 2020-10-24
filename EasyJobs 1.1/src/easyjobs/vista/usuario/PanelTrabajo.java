package easyjobs.vista.usuario;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelTrabajo extends JPanel implements MouseListener {

    private JLabel lblDescripcion;
    private JLabel lblTitulo;
    private String link;
    private JLabel lblVinculo;
    private JLabel foto;
    private JLabel lblEmpresa;

    public PanelTrabajo(String titulo, String descripcion, String link, String empresa, String img) {
        String source;
        this.link = link;
        switch (img) {
            case "Asesoría en ventas":
                source = "./img/aseso.png";
                break;
            case "Callcenter":
                source = "./img/call.png";
                break;
            case "Transporte":
                source = "./img/trans.png";
                break;
            case "Logística":
                source = "./img/logi.png";
                break;
            case "Operario":
                source = "./img/opera.png";
                break;
            case "Informática":
                source = "./img/info.png";
                break;
            case "Turismo":
                source = "./img/turis.png";
                break;
            case "ingenieria":
                source = "./img/inge.png";
                break;
            case "Artes gráficas":
                source = "./img/arte.png";
                break;
            case "Docencia":
                source = "./img/doce.png";
                break;
            default:
                source = "./img/otros";

        }
        this.setLayout(null);
        this.link = link;
        this.setBorder(BorderFactory.createRaisedBevelBorder());
        this.setSize(600, 170);

        lblTitulo = new JLabel();
        lblTitulo.setFont(new Font(Font.SANS_SERIF, Font.BOLD,25));
        this.lblTitulo.setText("<html><body>" + titulo + "</body></html>");
        lblTitulo.setBounds(120, 10, 420,55);
        this.add(lblTitulo);

        lblEmpresa = new JLabel();
        this.lblEmpresa.setText("<html><body>" + "Empresa : " + empresa + "</body></html>");
        lblTitulo.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        lblEmpresa.setBounds(120,60, 420, 20);
        this.add(lblEmpresa);

        lblDescripcion = new JLabel();
        this.lblDescripcion.setText("<html><body>" + descripcion + "</body></html>");
        lblDescripcion.setBounds(120,80, 420,40);
        this.add(lblDescripcion);

        lblVinculo = new JLabel();
        this.lblVinculo.setText("<HTML><a>"+ link+"</a></HTML>" );
        System.out.println(link);
        lblVinculo.setForeground(Color.blue);
        lblVinculo.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,15));
        lblVinculo.addMouseListener(this);
        lblVinculo.setBounds(120,120, 420,40);
        
        this.add(lblVinculo);

        ImageIcon foto1 = new ImageIcon(source);
        foto = new JLabel();
        foto.setBounds(10, 20, 100, 100);
        foto.setIcon(new ImageIcon(foto1.getImage().getScaledInstance(foto.getWidth(), foto.getHeight(), Image.SCALE_SMOOTH)));
        this.add(foto);

   
     }

    @Override
    public void mouseClicked(MouseEvent e) {
        JOptionPane.showMessageDialog(null,"Por favor espere \n a que su navegador abra la oferta");
                 if(Desktop.isDesktopSupported()){
                Desktop desktop = Desktop.getDesktop();
                if(desktop.isSupported(Desktop.Action.BROWSE)){
                    try {
                        desktop.browse(new URI(link));
                    } catch (IOException ex) {
                       
                    } catch (URISyntaxException ex) {
                        
                    }
                }
            }
        }
    

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    }

