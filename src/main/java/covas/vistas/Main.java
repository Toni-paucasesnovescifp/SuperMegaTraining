/**
 * Contiene las clases que definen la interfaz gráfica de usuario (GUI) de la aplicación.
 * Estas clases gestionan las pantallas y cuadros de diálogo que los usuarios
 * utilizan para interactuar con las funcionalidades de la aplicación,
 * como agregar, modificar y visualizar usuarios, entrenamientos y ejercicios.
 */
package covas.vistas;

import com.jtattoo.plaf.bernstein.BernsteinLookAndFeel;
import covas.model.Usuari;
import covas.dataaccess.DataAccess;
import covas.model.Workout;
import covas.utils.Utilitats;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.io.File;
import java.util.ArrayList;
import java.util.Properties;
import javax.swing.JOptionPane;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import net.miginfocom.swing.MigLayout;

/**
 * Clase principal de la aplicación que gestiona la interfaz gráfica y las
 * interacciones entre los diferentes paneles y componentes. Extiende
 * javax.swing.JFrame y sirve como ventana principal del programa.
 *
 *
 * Funcionalidades principales: - Gestión del usuario activo y del usuario
 * seleccionado. <br>
 * - Integración de múltiples paneles como Login, Vista de usuarios, Workouts,
 * <br>
 * y panel principal. <br>
 * - Configuración y personalización de la interfaz gráfica, incluyendo layouts
 * y propiedades del JFrame. <br>
 *
 *
 *
 * @author Toni Covas
 * @version 02/04/2025
 */
public class Main extends javax.swing.JFrame {

    /**
     * Usuario actualmente autenticado.
     */
    private Usuari usuariActiu = null;

    /**
     * Acceso a la base de datos.
     */
    private DataAccess da = new DataAccess();

    /**
     * Usuario seleccionado en la interfaz.
     */
    private Usuari usuariSeleccionat = null;

    /**
     * Nombre del usuario seleccionado.
     */
    private String usuariSeleccionatTexte = "";

    /**
     * Panel principal de la aplicación.
     */
    private MainJPanel pnlMain;

    /**
     * Panel para visualizar usuarios.
     */
    private VistaUsuaris pnlVistaUsuaris;

    /**
     * Panel para visualizar entrenamientos.
     */
    private VistaWorkouts pnlVistaWorkouts;

    /**
     * Panel de inicio de sesión.
     */
    private LogIn pnlLogIn;

    /**
     * Panel para añadir o modificar entrenamientos.
     */
    private AddChangeWorkouts pnlAddChangeWorkouts;

    /**
     * Identificador del último entrenamiento agregado.
     */
    private int darrerWorkoutAfegit;

    /**
     * Constructor de la clase Main. Inicializa los componentes gráficos,
     * configura la interfaz gráfica y define el diseño general de la
     * aplicación.
     *
     * Funcionalidades principales: <br>
     * - Inicializa y actualiza los componentes del JFrame principal.<br>
     * - Configura la disposición gráfica utilizando MigLayout.<br>
     * - Define el logo de la aplicación como icono del JFrame principal.<br>
     * - Configura el panel de login (jPanelLogin) y su visibilidad inicial.<br>
     * - Añade y organiza los paneles principales en el JFrame.<br>
     * - Centra el JFrame en la pantalla y ajusta su tamaño automáticamente.<br>
     */
    public Main() {

        initComponents();

        SwingUtilities.updateComponentTreeUI(this);

        // definim el logo pel frame principal
        this.setIconImage(Utilitats.obtenirImage("logocompany.jpg"));

        // panell amb el nom d'usuari actiu visible y botó de Log Out
        jPanelLogin.setVisible(false);

        setResizable(true);

        // Definim MigLayout pel frame principal
        setLayout(new MigLayout("fill"));

        // Definim MigLayout pel panell de Login
        jPanelLogin.setLayout(new MigLayout("fill"));
        getContentPane().add(jPanelLogin, "pos (100%-250px) 5px, wrap 5");

        pnlMain = new MainJPanel(this);
        getContentPane().add(pnlMain, "span, grow, align center, gap top 20px, wrap");

        setLocationRelativeTo(null); // Centrar el JFrame en la pantalla       
        pack();
        repaint();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelLogin = new javax.swing.JPanel();
        jButtonLogOut = new javax.swing.JButton();
        jLabelUsuariRegistrat = new javax.swing.JLabel();
        jTableWorkOutsperborrar = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(200, 200));
        setPreferredSize(new java.awt.Dimension(900, 625));
        setResizable(false);
        setSize(new java.awt.Dimension(900, 625));
        getContentPane().setLayout(null);

        jPanelLogin.setVisible(false);
        jPanelLogin.setLayout(null);

        jButtonLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cerrar-sesion.png"))); // NOI18N
        jButtonLogOut.setText("Log Out");
        jButtonLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogOutActionPerformed(evt);
            }
        });
        jPanelLogin.add(jButtonLogOut);
        jButtonLogOut.setBounds(155, 15, 90, 23);

        jLabelUsuariRegistrat.setText("Usuari:");
        jLabelUsuariRegistrat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelLogin.add(jLabelUsuariRegistrat);
        jLabelUsuariRegistrat.setBounds(6, 14, 143, 18);

        getContentPane().add(jPanelLogin);
        jPanelLogin.setBounds(20, 0, 270, 50);

        jTableWorkOutsperborrar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "blanc", "ForDate", "IdWorkout"
            }
        ));
        getContentPane().add(jTableWorkOutsperborrar);
        jTableWorkOutsperborrar.setBounds(0, 0, 150, 0);
        if (jTableWorkOutsperborrar.getColumnModel().getColumnCount() > 0) {
            jTableWorkOutsperborrar.getColumnModel().getColumn(0).setMinWidth(0);
            jTableWorkOutsperborrar.getColumnModel().getColumn(0).setPreferredWidth(0);
            jTableWorkOutsperborrar.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        jMenu1.setMnemonic('F');
        jMenu1.setText("File");
        jMenu1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jMenu1KeyPressed(evt);
            }
        });

        jMenuItem3.setMnemonic('V');
        jMenuItem3.setText("Veure per Consola usuaris");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem2.setMnemonic('A');
        jMenuItem2.setText("Acerca de...");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenu2.setText("Help");
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        jMenuItem5.setText("API Docs");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem6.setText("User Manual");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenu1.add(jMenu2);

        jMenuItem1.setMnemonic('S');
        jMenuItem1.setText("Sortir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Establece el usuario activo.
     */
    public void setUsuariActiu(Usuari usuariActiu) {
        this.usuariActiu = usuariActiu;
    }

    /**
     * Obtiene el usuario activo.
     */
    public Usuari getUsuariActiu() {
        return usuariActiu;
    }

    /**
     * Obtiene el usuario seleccionado.
     */
    public Usuari getUsuariSeleccionat() {
        return usuariSeleccionat;
    }

    /**
     * Obtiene el texto del usuario seleccionado.
     */
    public String getUsuariSeleccionatTexte() {
        return usuariSeleccionatTexte;
    }

    /**
     * Establece el texto del usuario seleccionado.
     */
    public void setUsuariSeleccionatTexte(String usuariSeleccionatTexte) {
        this.usuariSeleccionatTexte = usuariSeleccionatTexte;
    }

    /**
     * Establece el usuario seleccionado.
     */
    public void setUsuariSeleccionat(Usuari usuari) {
        this.usuariSeleccionat = usuari;
    }

    /**
     * Abre un cuadro de diálogo (JDialog) para realizar el inicio de sesión. El
     * cuadro de diálogo se centra automáticamente respecto a la ventana
     * principal y se hace visible al usuario.
     */
    public void abrirLogin() {
        pnlLogIn = new LogIn(this, true);
        pnlLogIn.setLocationRelativeTo(this);
        pnlLogIn.setVisible(true);
    }

    /**
     * Abre un cuadro de diálogo (JDialog) para añadir o modificar un
     * entrenamiento (Workout). Este método inicializa y muestra el panel
     * correspondiente para realizar las acciones de agregar o modificar según
     * el modo indicado.
     *
     * @param modo Especifica el modo de operación: "añadir" o "modificar".
     * @param workoutModificar El objeto Workout que se debe modificar, o null
     * si se va a añadir uno nuevo.
     */
    public void addChangeWorkouts(String modo, Workout workoutModificar) {
        //obrim el jDialog per afegir/ modificar workouts
        pnlAddChangeWorkouts = new AddChangeWorkouts(this, true, modo, workoutModificar);
        pnlAddChangeWorkouts.setLocationRelativeTo(this); // Centrar el JDialog respecte el JFrame principal
        pnlAddChangeWorkouts.setVisible(true);
    }

    /**
     * Acción asociada al botón de cierre de sesión (Log Out). Muestra un
     * mensaje de despedida, oculta el panel de login y elimina los paneles
     * asociados al usuario activo. Además, restablece la interfaz principal.
     *
     * @param evt Evento generado al hacer clic en el botón de Log Out.
     */
    private void jButtonLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogOutActionPerformed

        JOptionPane.showMessageDialog(this, "Hasta Luego " + jLabelUsuariRegistrat.getText() + " !.  Su sesión ha sido desconectada", "Logout", JOptionPane.INFORMATION_MESSAGE, Utilitats.obtenirIcon("adios.png"));

        jLabelUsuariRegistrat.setText("");
        jPanelLogin.setVisible(false);        // TODO add your handling code here:
        setUsuariActiu(null);
        getContentPane().remove(getPnlVistaUsuaris());
        if (getPnlVistaWorkouts() != null) {
            getContentPane().remove(getPnlVistaWorkouts());
        }
        pnlMain.getJLabelSignIn().setVisible(true);
        repaint();


    }//GEN-LAST:event_jButtonLogOutActionPerformed

    /**
     * Acción asociada al elemento del menú para salir de la aplicación.
     * Finaliza la ejecución del programa.
     *
     * @param evt Evento generado al seleccionar la opción "Salir" en el menú.
     */
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
     * Acción asociada al elemento del menú "Acerca de". Muestra un cuadro de
     * diálogo con información sobre la aplicación.
     *
     * @param evt Evento generado al seleccionar la opción "Acerca de" en el
     * menú.
     */
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // botó del menú about
        final JOptionPane pane = new JOptionPane("Aplicació creada per Toni Covas Nicolau\nVersión 1.0\n\nGrau Superior DAM - Desenvolupament aplicaciones multiplataforma\nMòdul: Desenvolupament d'interfícies \nCIFP Pau Casesnoves");
        final JDialog d = pane.createDialog((JFrame) null, "About...");
        d.setLocation(jMenuItem2.getLocation().x + 5, jMenuItem2.getLocation().y + 2);
        d.setLocationRelativeTo(this);
        d.setVisible(true);

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenu1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMenu1KeyPressed

    }//GEN-LAST:event_jMenu1KeyPressed

    /**
     * Acción asociada al elemento del menú para mostrar la lista de usuarios.
     * Recupera la lista de usuarios del sistema y la imprime en la consola.
     *
     * @param evt Evento generado al seleccionar la opción correspondiente en el
     * menú.
     */
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // enseñar lista de usuarios por consola
        ArrayList<Usuari> usuaris = DataAccess.getAllUsers();

        for (Usuari u : usuaris) {
            System.out.println(u.getId() + " " + u.getNom() + "\n");

        }

    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed

        try {
            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR)); // Cambia a "espera"
            // definim ruta que està en c://users//<nomusuari>\ etc.  ,... se defineix amb "user.home" perquè és una carpeta variable, distina  segons l'ordinador on ho instal.lem.
            String filePath = System.getProperty("user.home") + "\\AppData\\Local\\supermegatraining\\userManual\\user manual.pdf";
            File file = new File(filePath);

            // Verificar si l'arxiu existeix abans d'obrirlo
            if (file.exists()) {
                Desktop.getDesktop().open(file);
            } else {
                JOptionPane.showMessageDialog(null, "El manual de usuario no se encuentra en la ubicación especificada.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se pudo abrir el manual de usuario.", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            setCursor(Cursor.getDefaultCursor());
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed

        try {
            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR)); // posam el ratolí en cursor d'espera
            // definim la ruta, que és variable segons el nom d'usuari de l'ordinador on instal.lem l'aplicació
            String filePath = System.getProperty("user.home") + "\\AppData\\Local\\supermegatraining\\apidocs\\index.html";
            File file = new File(filePath);

            // Verificam si l'arxiu existeix abans d'obrirlo
            if (file.exists()) {
                Desktop.getDesktop().open(file);
            } else {
                JOptionPane.showMessageDialog(null, "No se encuentra el fichero index.html de API Docs en ubicación especificada.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se pudo abrir el fichero index html de API Docs.", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            setCursor(Cursor.getDefaultCursor());
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    /**
     * Registra al usuario activo en la aplicación. Actualiza el panel principal
     * y muestra el panel de login con el nombre del usuario activo.
     *
     * @param usuari El objeto Usuari que se registrará como usuario activo.
     */
    public void registrarUsuariActiu(Usuari usuari) {
        pnlMain.getJLabelSignIn().setVisible(false);
        this.usuariActiu = usuari;
        jLabelUsuariRegistrat.setText("Usuari: " + this.usuariActiu.getNom());
        jLabelUsuariRegistrat.setVisible(true);
        jPanelLogin.setVisible(true);
    }

    /**
     * Carga y muestra la lista de usuarios del instructor en el panel
     * correspondiente. Si ya existen paneles previos, estos son eliminados
     * antes de añadir el nuevo panel.
     */
    public void carregarLlistaUsuarisInstructor() {
        if (pnlVistaWorkouts != null) {
            getContentPane().remove(getPnlVistaWorkouts());
        }

        if (pnlVistaUsuaris != null) {
            getContentPane().remove(getPnlVistaUsuaris());
        }

        setPnlVistaUsuaris(new VistaUsuaris(this));
        getContentPane().add(pnlVistaUsuaris, "span, grow, align center, wrap");
        revalidate();
        repaint();
    }

    /**
     * Carga y muestra la lista de entrenamientos (Workouts) para el usuario
     * seleccionado. Elimina paneles anteriores y centra el nuevo panel en la
     * interfaz gráfica.
     *
     * @param nomUsuari El nombre del usuario seleccionado para cargar los
     * entrenamientos.
     */
    public void carregarLlistaWorkOutsUsuari(String nomUsuari) {
        getContentPane().remove(getPnlVistaUsuaris());
        setUsuariSeleccionatTexte(nomUsuari);
        setPnlVistaWorkouts(new VistaWorkouts(this));

        getContentPane().remove(getPnlVistaUsuaris());
        getContentPane().add(getPnlVistaWorkouts(), "span, grow, align center, wrap");

        pack();
        repaint();
    }

    /**
     * Método principal que inicia la ejecución de la aplicación. Configura el
     * tema gráfico (look-and-feel) personalizado y lanza la interfaz principal.
     *
     * @param args Argumentos de línea de comandos (no utilizados en esta
     * aplicación).
     * @throws UnsupportedLookAndFeelException Se lanza si la configuración del
     * look-and-feel no es compatible.
     *
     * Este método se encarga de establecer las propiedades del tema Bernstein y
     * de inicializar los componentes gráficos necesarios para la interfaz.
     */
    public static void main(String args[]) throws UnsupportedLookAndFeelException {
        try {
            // Crear propiedades para personalizar el look and feel
            Properties props = new Properties();
            props.put("logoString", ""); // Eliminar el texto del logo

            //establim les propietats al lookAndFeel Bernstein    
            BernsteinLookAndFeel.setCurrentTheme(props);

            //establim fonts a distints objectes visuals. Jugam amb dues fonts distintes
            Font customFont1 = new Font("Open Sans Semibold", Font.PLAIN, 14);
            Font customFont2 = new Font("Consolas", Font.PLAIN, 14);
            UIManager.put("Label.font", customFont1);
            UIManager.put("TableHeader.font", customFont1);
            UIManager.put("Table.font", customFont2);
            UIManager.put("List.font", customFont2);
            UIManager.put("Button.font", customFont1);
            UIManager.put("TextField.font", customFont1);
            UIManager.put("Spinner.font", customFont1);
            UIManager.put("Datepicker.font", customFont1);
            UIManager.put("TextArea.font", customFont1);
            UIManager.put("ComboBox.font", customFont1);
            UIManager.put("Menu.font", customFont1);
            UIManager.put("MenuItem.font", customFont1);
            UIManager.put("TitledBorder.font", customFont1);
            UIManager.put("ToolTip.font", customFont1);

            //establim un color blau molt dèbil a distints elements
            UIManager.put("Button.background", new Color(230, 240, 255));
            UIManager.put("Label.background", new Color(230, 240, 255));
            UIManager.put("TextField.background", new Color(230, 240, 255));
            UIManager.put("TextArea.background", new Color(230, 240, 255));
            UIManager.put("ComboBox.background", new Color(230, 240, 255));
            UIManager.put("Menu.background", new Color(230, 240, 255));
            UIManager.put("MenuItem.background", new Color(230, 240, 255));
            UIManager.put("TitledBorder.background", new Color(230, 240, 255));
            UIManager.put("ToolTip.background", new Color(230, 240, 255));

            // Establecer el "look and fiel jTatoo bernstein"
            UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");

            UIManager.put("logoString", ""); // Eliminar el texto del logo que ve per defecte amb el jTatoo
            UIManager.put("logo", ""); // Eliminar el logo que ve per defecte amb el jTatoo
            UIManager.put("backgroundColor", "230 240 255"); // Color azul muy débil

            Main mainInstance = new Main();

            //definim el logo de l'aplicació 
            UIManager.put("logo", Utilitats.obtenirImage("logocompany.jpg"));

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });

    }

    /**
     * Obtiene el panel de usuarios.
     */
    public VistaUsuaris getPnlVistaUsuaris() {
        return pnlVistaUsuaris;
    }

    /**
     * Establece el panel que muestra la lista de usuarios en la interfaz
     * gráfica. Este método actualiza el panel de usuarios utilizado en la
     * aplicación.
     *
     * @param pnlVistaUsuaris El objeto VistaUsuaris que será asignado como el
     * nuevo panel de usuarios.
     */
    public void setPnlVistaUsuaris(VistaUsuaris pnlVistaUsuaris) {
        this.pnlVistaUsuaris = pnlVistaUsuaris;
    }

    /**
     * Obtiene el panel de entrenamientos.
     */
    public VistaWorkouts getPnlVistaWorkouts() {
        return pnlVistaWorkouts;
    }

    /**
     * Establece el panel que muestra los entrenamientos (Workouts) en la
     * interfaz gráfica.
     *
     * @param pnlVistaWorkouts El objeto VistaWorkouts que se utilizará como el
     * nuevo panel de entrenamientos.
     */
    public void setPnlVistaWorkouts(VistaWorkouts pnlVistaWorkouts) {
        this.pnlVistaWorkouts = pnlVistaWorkouts;
    }

    /**
     * Obtiene el último entrenamiento añadido.
     */
    public int getDarrerWorkoutAfegit() {
        return darrerWorkoutAfegit;
    }

    /**
     * Establece el identificador del último entrenamiento añadido.
     *
     * @param darrerWorkoutAfegit Un entero que representa el nuevo
     * identificador del último entrenamiento.
     */
    public void setDarrerWorkoutAfegit(int darrerWorkoutAfegit) {
        this.darrerWorkoutAfegit = darrerWorkoutAfegit;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLogOut;
    private javax.swing.JLabel jLabelUsuariRegistrat;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanelLogin;
    private javax.swing.JTable jTableWorkOutsperborrar;
    // End of variables declaration//GEN-END:variables
}
