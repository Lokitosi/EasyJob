/*
    Made by EasyJobs Team v.0.10.2
 */
package easyjobs.controlador;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import easyjobs.Usuario;
import easyjobs.vista.admin.VentAdmin;
//import easyjobs.vista.admin.VentEliminar;
import easyjobs.vista.usuario.PanelTrabajo;
import easyjobs.vista.usuario.VentCambioDatos;
import easyjobs.vista.usuario.VentLogin;
import easyjobs.vista.usuario.VentRegistrar;
import easyjobs.vista.usuario.VentPrincipal;
import easyjobs.vista.usuario.VentTrabajos;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.util.Date;
import javax.swing.BorderFactory;

public class Controlador implements ActionListener {
    
// Atributos
    
    private VentLogin vLog = new VentLogin(this);
    private VentRegistrar vReg = new VentRegistrar(this);
    private VentPrincipal vPrinc = new VentPrincipal(this);
    private VentCambioDatos vCamb = new VentCambioDatos(this);
    private VentTrabajos vTrab = new VentTrabajos(this);
    private VentAdmin vAdm = new VentAdmin(this);
    //private VentEliminar vElim = new VentEliminar(this);
    private JFrame ultVentana;
    int usuarioLogin;
    String ofertastxt = "";
    ArrayList<Usuario> usuarios;
    ArrayList<Usuario> elimusuario;
    int REGISTRAR = 1, LOGIN = 2;
    String tipoTrabajo;
    String[] trabajos = {"Asesoría en ventas", "Callcenter", "Transporte", "Logística", "Operario", "Informática", "Turismo", "Artes gráficas", "Docencia", "Ingeniería", "Otro"};
    int posicionActual;
    
// Constructor y metodos()
    
    public Controlador(ArrayList users) {
        usuarios = users;
        try {
            cargarUsuarios();
            vLog.setLocationRelativeTo(null);
            vReg.setLocationRelativeTo(null);
            vPrinc.setLocationRelativeTo(null);
            vCamb.setLocationRelativeTo(null);
            vTrab.setLocationRelativeTo(null);            
            ejecutarLogin();
        } catch (Exception e) {
        }
    }
    // obtiene las etiquetas para los trabajos
    public String[] getTrabajos() {

        return trabajos;
    }
    // obtener lista de usuarios
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
    // funcion para la grafica que muestra cuantos usuarios hay por dia
    public void mostrarCantidad(int[] cantidad) {
        for (int i = 0; i < 7; i++) {
            System.out.println("Hace " + i + " dias: " + cantidad[i]);
        }
    }
    // metodo que cuenta cuantas personas estan registradas en los ultimos 7 dias
    public int[] cantidadRegistrados(ArrayList<Usuario> usuarios) {
        int[] cantidades = new int[7];
        for (int i : cantidades) {
            i = 0;
        }

        Date fechaHoy = new Date();

        for (int i = 0; i < 7; i++) {
            for (Usuario user : usuarios) {
                if (fechaHoy.getDate() == user.getFechaRegistro().getDate() + i) {
                    cantidades[i]++;
                }
            }
        }

        return cantidades;
    }

    //Calcula la cantidad de trabajos seleccionados entre todos los usuarios
    public int[] calcularCantidades(ArrayList<Usuario> users) {
        int[] cantidad = new int[this.trabajos.length - 1];

        for (int i = 0; i < users.size(); i++) {
            for (String trabajoUser : users.get(i).getTrabajos()) {
                for (int j = 0; j < cantidad.length; j++) {
                    if (trabajoUser.equals(trabajos[j])) {
                        cantidad[j] += 1;
                    }
                }
            }
        }

        return cantidad;

    }

    //2.1Se hace la búsqueda del trabajo del String
    public Document hacerBusqueda(String trabajo) throws IOException {
        String concatenar = trabajo.replaceAll(" ", "%20");        
        for (int i = 0; i < trabajo.length(); i++) {
        }
        Document doc = (Document) Jsoup.connect("https://www.computrabajo.com.co/ofertas-de-trabajo/?q=" + concatenar).get();
        return doc;
    }

    // 2.2 Fin método búsqueda
    public Elements obtenerTarjetas(Document doc) {
        Elements tarjetas = doc.getElementsByClass("bRS bClick ");
        return tarjetas;
    }
    
    //2.3 genera las tarjetas con los trabajos
    public void llenarTrabajos(Elements tarjetas, int cantidad) {
        Elements titulos = new Elements();
        Elements descripciones = new Elements();
        Elements links = new Elements();
        Elements empresa = new Elements();
        String foto = tipoTrabajo;

        for (int i = 0; i < tarjetas.size(); i++) {
            titulos.add(tarjetas.get(i).getElementsByClass("js-o-link").get(0));
        }
        
        for (int i = 0; i < tarjetas.size(); i++) {
            empresa.add(tarjetas.get(i).getElementsByClass("it-blank").get(0));
        }

        for (int i = 0; i < tarjetas.size(); i++) {
            descripciones.add(tarjetas.get(i).getElementsByTag("p").get(0));
        }
        for (int i = 0; i < tarjetas.size(); i++) {
            links.add(tarjetas.get(i).select("a[href]").get(0));
        }

        for (int i = 0; i < cantidad; i++) {
            String title = (titulos.get(i).text());
            String desc = (descripciones.get(i).text());
            String link = (links.get(i).attr("abs:href"));
            String empre = (empresa.get(i).text());

            vPrinc.getOfertas()[i] = new PanelTrabajo(title, desc, link,empre,foto);
            vPrinc.getOfertas()[i].setBounds(20, 5 + (175 * posicionActual), vPrinc.getOfertas()[i].getWidth(), vPrinc.getOfertas()[i].getHeight());
            vPrinc.getPnlTrabajos().add(vPrinc.getOfertas()[i]);
            posicionActual++;
            ofertastxt += title + "\n" + "\n" + desc + "\n" + "\n" + "\n"+link+"\n\n\n";

        }

    }

    //2.4 envio de las ofertas al correo electronico
    public void enviarOfertas() throws AddressException, MessagingException {
        Properties propiedad = new Properties();
        propiedad.setProperty("mail.smtp.host", "smtp.gmail.com");
        propiedad.setProperty("mail.smtp.starttls.enable", "true");
        propiedad.setProperty("mail.smtp.port", "587");
        propiedad.setProperty("mail.smtp.auth", "true");

        Session sesion = Session.getDefaultInstance(propiedad);
        String correoEnvia = "EasyJobsNotif@gmail.com";
        String contrasena = "easyjobs123";
        String receptor = usuarios.get(usuarioLogin).getCorreo();
        String asunto = "Nueva oferta Laboral!";

        MimeMessage mail = new MimeMessage(sesion);
        try {
            mail.setFrom(new InternetAddress(correoEnvia));
            mail.addRecipient(Message.RecipientType.TO, new InternetAddress(receptor));
            mail.setSubject(asunto);
            mail.setText(ofertastxt);

            Transport transportar = sesion.getTransport("smtp");
            transportar.connect(correoEnvia, contrasena);
            transportar.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));
            transportar.close();

        } catch (AddressException ex) {
            System.out.println("error 1");

        }
    }

    //7.Crea el arreglo de trabajos seleccionados    
    public ArrayList<String> crearArreglo() {
        ArrayList<String> listaTrabajosSeleccionados = new ArrayList();
        for (int i = 0; i < vTrab.getChecks().length - 1; i++) {
            if (vTrab.getChecks()[i].isSelected()) {
                listaTrabajosSeleccionados.add(vTrab.getChecks()[i].getText());
            }
            if(vTrab.getChecks()[10].isSelected()){
                listaTrabajosSeleccionados.add(vTrab.getTxtOtro().getText());
            }
        }
        return listaTrabajosSeleccionados;
    }

    // 1. Añadir usuario al arreglo ok
    public void añadirUsuario() {
        String userTemp = vReg.getTxtUsuario().getText();
        String keyTemp = vReg.getTxtContraseña().getText();
        String mailTemp = vReg.getTxtCorreo().getText();
        boolean adminTemp = false;
        if (mailTemp.equals("easyjobsnotif@gmail.com")) {
            adminTemp = true;
        }
        ArrayList<String> arreglo = this.crearArreglo();
        Usuario temp = new Usuario(userTemp, mailTemp, keyTemp, arreglo);
        temp.setAdmin(adminTemp);
        temp.setFechaRegistro(new Date());
        usuarios.add(temp);
        guardarUsuarios(usuarios);
    }

    //4. Se valida si la contraseña tiene mínimo 8 caracteres ok
    public boolean validarContraseña(String contraseña) {
        if (contraseña.length() >= 8) {
            return true;
        } else {
            return false;
        }
    }

    // 5.Se valida si los datos ingresados de usuario y contraseña coinciden con algún usuario guardado ok
    public boolean validarUsuario(int tipoVentana) {

        boolean correcto = false;
        String userTemp = "", keyTemp = "";
        if (tipoVentana == REGISTRAR) {
            userTemp = vReg.getTxtUsuario().getText();
            keyTemp = vReg.getTxtContraseña().getText();
            for (int i = 0; i < usuarios.size(); i++) {
                if (userTemp.equals(usuarios.get(i).getNombre())) {
                    correcto = true;
                    usuarioLogin = i;
                }
            }
        }

        if (tipoVentana == LOGIN) {

            userTemp = vLog.getTxtUsuario().getText();
            keyTemp = vLog.getTxtContraseña().getText();
            for (int i = 0; i < usuarios.size(); i++) {
                if (userTemp.equals(usuarios.get(i).getNombre()) && keyTemp.equals(usuarios.get(i).getContraseña())) {
                    correcto = true;
                    usuarioLogin = i;
                }
            }
        }

        return correcto;
    }

    //2. Se visualiza una ventana de registrarse
    public void ejecutarRegistrarse() {
        vLog.setVisible(false);
        vReg.setVisible(true);
        vPrinc.setVisible(false);
        vTrab.setVisible(false);
        vCamb.setVisible(false);
        vReg.getTxtContraseña().setText("");
        vReg.getTxtCorreo().setText("");
        vReg.getTxtUsuario().setText("");
    }

    //3.Se visualiza una ventana de Login
    public void ejecutarLogin() {
        if (cargarUsuarios() == false) {
            guardarUsuarios(usuarios);
        } else {
            cargarUsuarios();
        }
        vReg.setVisible(false);
        vLog.setVisible(true);
        vPrinc.setVisible(false);
        vTrab.setVisible(false);
        vCamb.setVisible(false);
        vLog.getTxtContraseña().setText("");
        vLog.getTxtUsuario().setText("");
    }

    //8.Se visualiza la ventana principal
    public void ejecutarPrincipal() {
        vLog.setVisible(false);
        vReg.setVisible(false);
        vTrab.setVisible(false);
        vCamb.setVisible(false);
        vPrinc.setUser(usuarios.get(usuarioLogin));
        vPrinc.ponerDatos();
        vPrinc.setVisible(true);
        posicionActual = 0;
    }
    
    //6.Se visualiza la ventana de trabajos
    public void ejecutarVTrabajos() {
        vTrab.setVisible(true);
        vReg.setVisible(false);
        vLog.setVisible(false);
        vPrinc.setVisible(false);
        vCamb.setVisible(false);
    }

      //9.Se visualiza la ventana de cambio de datos
    public void ejecutarVCambio() {
        vTrab.setVisible(false);
        vReg.setVisible(false);
        vLog.setVisible(false);
        vPrinc.setVisible(false);
        vCamb.setUser(usuarios.get(usuarioLogin));
        vCamb.getCheckEnviarNotificaciones().setSelected(usuarios.get(usuarioLogin).isEnviarNotificaciones());
        vCamb.setVisible(true);
    }

    //10.Se hace la persistencia
    public boolean guardarUsuarios(ArrayList usuarios) {
        boolean guardado = true;
        try {
            FileOutputStream fout = new FileOutputStream("./data/usuarios.bin");
            ObjectOutputStream writer = new ObjectOutputStream(fout);
            writer.writeObject(usuarios);
            fout.close();
            writer.close();
        } catch (Exception e) {
            guardado = false;
        }
        return guardado;
    }

    //11.Se lee la persistencia
    public boolean cargarUsuarios() {
        boolean leido = true;
        try {
            FileInputStream fin = new FileInputStream("./data/usuarios.bin");
            ObjectInputStream reader = new ObjectInputStream(fin);
            usuarios = (ArrayList) reader.readObject();
            fin.close();
            reader.close();
        } catch (Exception e) {
            leido = false;
            JOptionPane.showMessageDialog(null, "Hubo un error en la lectura del archivo");
        }
        return leido;
    }

    //Action performeds(:
    @Override
    public void actionPerformed(ActionEvent ae) {

        // Métodos ventana Login
        if (ae.getSource().equals(vLog.getBtnLogin())) {
            if (validarUsuario(LOGIN)) {
                cargarUsuarios();
                vPrinc.getPnlTrabajos().removeAll();
                if (usuarios.get(usuarioLogin).getTrabajos().size() != 0) {
                    int cantidad = (int) 10 / (usuarios.get(usuarioLogin).getTrabajos().size());
                    for (int j = 0; j < usuarios.get(usuarioLogin).getTrabajos().size(); j++) {
                        try {
                            Document doc = hacerBusqueda(usuarios.get(usuarioLogin).getTrabajos().get(j));
                            tipoTrabajo = usuarios.get(usuarioLogin).getTrabajos().get(j);
                            llenarTrabajos(obtenerTarjetas(doc), cantidad);
                            doc.clearAttributes();
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "Hubo un error al hacer la búsqueda 1");
                        }
                    }
                    if (posicionActual < 10) {
                        do {
                            try {
                                Document doc = hacerBusqueda(usuarios.get(usuarioLogin).getTrabajos().get(usuarios.get(usuarioLogin).getTrabajos().size() - 1));
                                tipoTrabajo = usuarios.get(usuarioLogin).getTrabajos().get(usuarios.get(usuarioLogin).getTrabajos().size() - 1) ;
                                llenarTrabajos(obtenerTarjetas(doc), cantidad);
                                doc.clearAttributes();
                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(null, "Hubo un error al hacer la búsqueda 2");
                            }
                            posicionActual++;
                        } while (posicionActual < 10);

                    }
                }

                ejecutarPrincipal();
                if (usuarios.get(usuarioLogin).isEnviarNotificaciones()) {
                    try {
                        enviarOfertas();
                    } catch (MessagingException e) {
                        System.out.println("No se pudo enviar el correo");
                    }
                } 

            } else {
                JOptionPane.showMessageDialog(null, "Verifique los datos ingresados y vuelva a intentarlo");
            }
        }

        if (ae.getSource().equals(vLog.getBtnRegistrar())) {
            ultVentana = vLog;
            ejecutarRegistrarse();
        }
        // Fin métodos ventana Login

        // Metodos ventana Registrarse
        if (ae.getSource().equals(vReg.getBtnCancelar())) {
            ejecutarLogin();
        }

        if (ae.getSource().equals(vReg.getBtnSiguiente())) {
            if (!validarUsuario(REGISTRAR) && validarContraseña(vReg.getTxtContraseña().getText())) {
                vTrab = new VentTrabajos(this);
                ejecutarVTrabajos();
            } else {
                JOptionPane.showMessageDialog(null, "El nombre de usuario ya está registrado o la contraseña no tiene más de 7 caracteres, intente con otro");
            }

        }
        // Fin métodos ventana Login

        // Métodos ventana principal
        if (ae.getSource().equals(vPrinc.getBtnEditar())) {
            ejecutarVCambio();
        }

        if (ae.getSource().equals(vPrinc.getBtnCerrarSesion())) {
            ejecutarLogin();
        }

        if (ae.getSource().equals(vPrinc.getBtnEditarTrabajos())) {
            ultVentana = vPrinc;
            for (int i = 0; i < vTrab.getChecks().length; i++) {
                vTrab.getChecks()[i].setSelected(false);
            }
            for (int i = 0; i < vTrab.getChecks().length - 1; i++) {
                for (int j = 0; j < usuarios.get(usuarioLogin).getTrabajos().size(); j++) {
                    if (vTrab.getChecks()[i].getText().equals(usuarios.get(usuarioLogin).getTrabajos().get(j))) {
                        vTrab.getChecks()[i].setSelected(true);
                    }
                }
            }
            ejecutarVTrabajos();
        }

        if (ae.getSource().equals(vPrinc.getBtnEstadisticas())) {

            vAdm.setLocationRelativeTo(vLog);
            vAdm.getnUsuarios().setText(""+usuarios.size());
            vAdm.getPnlGrafica().setBorder(BorderFactory.createTitledBorder("Cantidad de personas registradas"));
            vAdm.getPnlTorta().setTrabajos(trabajos);
            vAdm.getPnlTorta().setCantidad(calcularCantidades(usuarios));
            vAdm.getPnlTorta().setCantPersonas(usuarios.size());
            vAdm.getPnlGrafica().setCantidades(cantidadRegistrados(usuarios));
            vAdm.setVisible(true);
            vAdm.repaint();

        }
        
        if(ae.getSource().equals(vPrinc.getBtnEnviarCorreo())){
            try{
                enviarOfertas();                
                JOptionPane.showMessageDialog(null, "Correo enviado");
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "No se ha podido enviar el correo");
            }
        }
        // Fin métodos ventana principal

        //Métodos ventana Cambio de datos
        if (ae.getSource().equals(vCamb.getBtnCancelar())) {
            ejecutarPrincipal();
        }

        if (ae.getSource().equals(vCamb.getBtnEliminarCuenta())) {
            try{                
                usuarios.remove(usuarioLogin);
                guardarUsuarios(usuarios);
                JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente el usuario");
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Hubo un error al intentar eliminar el usuario");
            }
            ejecutarLogin();
        }

        if (ae.getSource().equals(vCamb.getBtnGuardarDatos())) {
            if (vCamb.getTxtAntiguaContraseña().getText().equals(usuarios.get(usuarioLogin).getContraseña()) && validarContraseña(vCamb.getTxtNuevaContraseña().getText())) {
                vCamb.getTxtAntiguaContraseña().setForeground(Color.BLACK);
                usuarios.get(usuarioLogin).setContraseña(vCamb.getTxtNuevaContraseña().getText());
                JOptionPane.showMessageDialog(null, "Se han cambiado los datos con éxito");
                usuarios.get(usuarioLogin).setEnviarNotificaciones(vCamb.getCheckEnviarNotificaciones().isSelected());
                guardarUsuarios(usuarios);
                vCamb.getTxtAntiguaContraseña().setText("");
                vCamb.getTxtNuevaContraseña().setText("");
                ejecutarPrincipal();
            } else {
                JOptionPane.showMessageDialog(null, "La contraseña es incorrecta o la contraseña nueva no tiene más de 8 caracteres");
            }
        }
        //Fin Métodos ventana cambio de datos

        //Métodos ventana trabajos
        if (ae.getSource().equals(vTrab.getBtnAceptar())) {
            if (ultVentana.equals(vLog)) {
                añadirUsuario();
                guardarUsuarios(usuarios);
            }

            if (ultVentana.equals(vPrinc)) {
                vPrinc.getPnlTrabajos().removeAll();
                usuarios.get(usuarioLogin).setTrabajos(this.crearArreglo());
                if (usuarios.get(usuarioLogin).getTrabajos().size() != 0) {
                    int cantidad = (int) 10 / (usuarios.get(usuarioLogin).getTrabajos().size());
                    for (int j = 0; j < usuarios.get(usuarioLogin).getTrabajos().size(); j++) {
                        try {
                            Document doc = hacerBusqueda(usuarios.get(usuarioLogin).getTrabajos().get(j));
                            llenarTrabajos(obtenerTarjetas(doc), cantidad);
                            doc.clearAttributes();
                        } catch (Exception ex) {
                            
                        }
                    }
                    if (posicionActual < 10) {
                        do {
                            try {
                                Document doc = hacerBusqueda(usuarios.get(usuarioLogin).getTrabajos().get(usuarios.get(usuarioLogin).getTrabajos().size() - 1));
                                llenarTrabajos(obtenerTarjetas(doc), cantidad);
                                doc.clearAttributes();
                            } catch (Exception ex) {
                                
                            }
                            posicionActual++;
                        } while (posicionActual < 10);

                    }
                }
                ejecutarPrincipal();

                guardarUsuarios(usuarios);
            }

            JOptionPane.showMessageDialog(null, "Datos guardados con éxito");
            vReg.getTxtContraseña().setText("");
            vReg.getTxtCorreo().setText("");
            vReg.getTxtUsuario().setText("");
            vTrab.setVisible(false);
            ultVentana.setVisible(true);
            guardarUsuarios(usuarios);
        }

        if (ae.getSource().equals(vTrab.getBtnCancelar())) {
            if (ultVentana.equals(vPrinc)) {
                vTrab.setVisible(false);
                vPrinc.setVisible(true);
            } else {
                ejecutarLogin();
            }
        }

        //Fin métodos ventana trabajos
    }

}
