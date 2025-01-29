/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package covas.vistas;

import com.jtattoo.plaf.bernstein.BernsteinLookAndFeel;
import covas.model.Usuari;
import covas.dataaccess.DataAccess;
import covas.model.Workout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.net.URL;
import java.util.ArrayList;
import java.util.Properties;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import net.miginfocom.swing.MigLayout;



/**
 *
 * @author Toni Covas
 */
public class Main extends javax.swing.JFrame {




    private Usuari usuariActiu=null;
    private DataAccess da= new DataAccess();
    private Usuari usuariSeleccionat=null;
    private String usuariSeleccionatTexte="";
    private DefaultTableModel model;
    private MainJPanel pnlMain;
    private VistaUsuaris pnlVistaUsuaris;
    private VistaWorkouts pnlVistaWorkouts;
    private LogIn pnlLogIn;
    private AddChangeWorkouts pnlAddChangeWorkouts;



    public String getUsuariSeleccionatTexte() {
        return usuariSeleccionatTexte;
    }

    public void setUsuariSeleccionatTexte(String usuariSeleccionatTexte) {
        this.usuariSeleccionatTexte = usuariSeleccionatTexte;
    }




    public Main() {
        
        initComponents();
        
        
        SwingUtilities.updateComponentTreeUI(this);
        
                        URL iconURL = Main.class.getResource("/images/logocompany.jpg"); // Ruta a tu archivo de imagen
                ImageIcon icon = new ImageIcon(iconURL);
                this.setIconImage(icon.getImage());

        
        
        //ponemos al principio en invislbe el panel3 que contiene los datos del usuario activo y botón de logout
        jPanelLogin.setVisible(false);
        //jPanelLogin.setLocation(getWidth()-300, 20);   // panell amb el nom d'usuari actiu visible y botó de Log Out
        
        
        
         setResizable(true);

        // Usar MigLayout para el contenido
        
                //setLayout(new MigLayout("fill, insets 1", "[grow][right]", "[]1[]"));
                        //setLayout(new MigLayout("fill, insets 5", "[grow][right]", "[]5[]"));
                        setLayout(new MigLayout("fill"));
                        
                        
                        //setLayout(new MigLayout("fill, insets 5", "[grow][right]", "[]5[]"));
        
        pnlMain=new MainJPanel(this);
        //pnlMain.setBounds(1,35,getContentPane().getWidth(),280);
        //pnlMain.setSize(getContentPane().getWidth(),280);
        
        
           
        //jPanelLogin.setLayout(new MigLayout( "fill"));
        
                        //jPanelLogin.setLayout(new MigLayout("fill, insets 10", "[grow, center]", "[]10[]"));
        
                     //getContentPane().add(jPanelLogin, "align right, wrap 10");
                     
                     
                     
                     jPanelLogin.setLayout(new MigLayout("fill"));
                        //getContentPane().add(jPanelLogin, "pos 0px 10px, align right, wrap 10");
                                getContentPane().add(jPanelLogin, "pos (100%-250px) 5px, wrap 5");

                     
                     
                     
        //getContentPane().add(pnlMain, "span, grow");
                //getContentPane().add(pnlMain, "span, grow");
        //getContentPane().add(pnlMain, "span, wrap");
                //getContentPane().add(pnlMain, "span, grow, pos 0px 50px");

                //getContentPane().add(pnlMain, "span, grow, align center,  wrap");
                  getContentPane().add(pnlMain, "span, grow, align center, gap top 20px, wrap");
                
        pack();
        setLocationRelativeTo(null); // Centrar el JFrame en la pantalla       
        
        
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

    public void setUsuariActiu(Usuari usuariActiu) {
        this.usuariActiu = usuariActiu;
    }


    public Usuari getUsuariActiu() {
        return usuariActiu;
    }
    
    public Usuari getUsuariSeleccionat() {
        return usuariSeleccionat;
    }
    

    public void  setUsuariSeleccionat(Usuari usuari) {
        this.usuariSeleccionat=usuari;
    }

    
    
    public void abrirLogin() {
        pnlLogIn=new LogIn(this, true);
        pnlLogIn.setLocationRelativeTo(this);
        pnlLogIn.setVisible(true);
        
    }
    
public void addChangeWorkouts(String modo, Workout workoutModificar) {
    pnlAddChangeWorkouts = new AddChangeWorkouts(this, true, modo, workoutModificar);
    pnlAddChangeWorkouts.setLocationRelativeTo(this); // Centrar el JDialog respecto al JFrame principal
    pnlAddChangeWorkouts.setVisible(true);
}
    
    
    
    
    
    private void jButtonLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogOutActionPerformed
                
        
            URL iconURL = Main.class.getResource("/images/adios.png"); // Ruta a tu archivo de imagen
            ImageIcon icon = new ImageIcon(iconURL);
            JOptionPane.showMessageDialog(this, "Hasta Luego " + jLabelUsuariRegistrat.getText() +  " !.  Su sesión ha sido desconectada", "Logout", JOptionPane.INFORMATION_MESSAGE, icon);

        
        
        
        
        //JOptionPane.showMessageDialog(this, "Hasta Luego " + jLabelUsuariRegistrat.getText() +  " !.  Su sesión ha sido desconectada");              
       
        
        
        
        jLabelUsuariRegistrat.setText("");
        jPanelLogin.setVisible(false);        // TODO add your handling code here:
        setUsuariActiu(null);
        getContentPane().remove(getPnlVistaUsuaris());
        if (getPnlVistaWorkouts()!=null) {getContentPane().remove(getPnlVistaWorkouts());}
        pnlMain.getJLabelSignIn().setVisible(true);
        repaint();
                
                
                
    }//GEN-LAST:event_jButtonLogOutActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(0)   ;     // TODO add your handling code here:;
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // botón del menú about
        final JOptionPane pane = new JOptionPane("Aplicació creada per Toni Covas Nicolau\nVersión 1.0\n\nGrau Superior DAM - Desenvolupament aplicaciones multiplataforma\nMòdul: Desenvolupament d'interfícies \nCIFP Pau Casesnoves" );
        final JDialog d = pane.createDialog((JFrame)null, "About...");
        d.setLocation(jMenuItem2.getLocation().x+5, jMenuItem2.getLocation().y+2    );
        d.setLocationRelativeTo(this);
        d.setVisible(true);
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenu1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMenu1KeyPressed
    
    }//GEN-LAST:event_jMenu1KeyPressed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // enseñar lista de usuarios por consola
        ArrayList<Usuari> usuaris = DataAccess.getAllUsers( );
        
        for(Usuari u: usuaris)  {
            System.out.println(u.getId() + " " + u.getNom()  + "\n");

        }
        
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    /**
     * @param args the command line arguments
     */
    
    public void registrarUsuariActiu(Usuari usuari) {
        pnlMain.getJLabelSignIn().setVisible(false);
        this.usuariActiu=usuari;
        jLabelUsuariRegistrat.setText("Usuari: " + this.usuariActiu.getNom());                 
        jLabelUsuariRegistrat.setVisible(true);
        jPanelLogin.setVisible(true);
    }
    
    public  void carregarLlistaUsuarisInstructor() {
        
        if (pnlVistaWorkouts!=null ) {
        getContentPane().remove(getPnlVistaWorkouts());
        }
       
 
        if (pnlVistaUsuaris!=null ) {
        getContentPane().remove(getPnlVistaUsuaris());
        }
        
       // DefaultListModel llistaBase = new DefaultListModel();
        //ArrayList<Usuari> usuaris = DataAccess.getAllUsersByInstructor(getUsuariActiu().getId() );
        //System.out.println("l'usuari es: "+getUsuariActiu().getId());
        //System.out.println("\n"+ usuaris.size());
//            for(int i=0; i<usuaris.size(); i++) {
  //              llistaBase.add(i, usuaris.get(i).getNom());
                
    //    }

    
        
        setPnlVistaUsuaris(new VistaUsuaris(this));
        //getPnlVistaUsuaris().setBounds(1,320,getContentPane().getWidth(),500);
        //getPnlVistaUsuaris().setSize(getContentPane().getWidth(),300);
      //  getPnlVistaUsuaris().getListUsuarisInstructor().setModel(llistaBase);
        
        //getContentPane().add(pnlVistaUsuaris, "grow");
        
                        getContentPane().add(pnlVistaUsuaris, "span, grow, align center, wrap");
        
        
        
        //getContentPane().add(getPnlVistaUsuaris(), "grow");
        revalidate();
        repaint();

        
    }
    
    
    public  void carregarLlistaWorkOutsUsuari(String nomUsuari) {
        getContentPane().remove(getPnlVistaUsuaris());        
        setUsuariSeleccionatTexte(nomUsuari)        ;
        setPnlVistaWorkouts(new VistaWorkouts(this));
        //getPnlVistaWorkouts().setBounds(1,320,getContentPane().getWidth(),500);
        //getPnlVistaWorkouts().setSize(getContentPane().getWidth(),300);
            
        
        getContentPane().remove(getPnlVistaUsuaris());
        //getContentPane().add(getPnlVistaWorkouts());
        getContentPane().add(getPnlVistaWorkouts(), "span, grow, align center, wrap");
        pack();
        repaint();

            
        
            
    }
    
    
    
    
    
    public static void main(String args[]) throws UnsupportedLookAndFeelException {
try {
            // Establecer el look and feel del sistema operativo
            //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            //UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");


            
            // Alternativamente, puedes usar otros looks and feels
            //UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            // UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
             //UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
             // UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
            // UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

            
            // Crear propiedades para personalizar el look and feel
            Properties props = new Properties();
            props.put("logoString", ""); // Eliminar el texto del logo
            //props.put("logo", ""); // Eliminar el logo

            // Cambiar el color de fondo a un azul muy débil
            //props.put("backgroundColor", "255 255 255"); // Color azul muy débil
            //props.put("controlColorLight", "230 240 255"); // Color claro de los controles
            //props.put("controlColorDark", "200 220 240"); // Color oscuro de los controles
            //props.put("menuBackgroundColor", "230 240 255"); // Color de fondo del menú
            //props.put("menuSelectionBackgroundColor", "200 220 240"); // Color de selección del menú
            //props.put("windowTitleBackgroundColor", "230 240 255"); // Color de fondo del título de la ventana
            //props.put("windowTitleColorLight", "230 240 255"); // Color claro del título de la ventana
            //props.put("windowTitleColorDark", "200 220 240"); // Color oscuro del título de la ventana
            //props.put("windowBorderColor", "200 220 240"); // Color del borde de la ventana
            
            BernsteinLookAndFeel.setCurrentTheme(props);

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
        
        
       //         UIManager.put("Panel.background", new Color(230, 240, 255)); // Color azul muy débil
        UIManager.put("Button.background", new Color(230, 240, 255));
        UIManager.put("Label.background", new Color(230, 240, 255));
        UIManager.put("TextField.background", new Color(230, 240, 255));
        UIManager.put("TextArea.background", new Color(230, 240, 255));
        UIManager.put("ComboBox.background", new Color(230, 240, 255));
        UIManager.put("Menu.background", new Color(230, 240, 255));
        UIManager.put("MenuItem.background", new Color(230, 240, 255));
        UIManager.put("TitledBorder.background", new Color(230, 240, 255));
        UIManager.put("ToolTip.background", new Color(230, 240, 255));


            
            
            // Establecer las propiedades personalizadas
            

            
            
            
            
            
            
        UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
        // UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

                    UIManager.put("logoString", ""); // Eliminar el texto del logo
                    UIManager.put("logo", ""); // Eliminar el texto del logo
                    UIManager.put("backgroundColor", "230 240 255"); // Color azul muy débil
                    
                    
                    
                    Main mainInstance=new Main();
             UIManager.put("logo", new ImageIcon(mainInstance.getClass().getResource("/images/logocompany.jpg"))); // Ruta a tu archivo JPG

        
            
            
            
            
            
            
            
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }





        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
       });
               
    }

    public VistaUsuaris getPnlVistaUsuaris() {
        return pnlVistaUsuaris;
    }

    public void setPnlVistaUsuaris(VistaUsuaris pnlVistaUsuaris) {
        this.pnlVistaUsuaris = pnlVistaUsuaris;
    }

    public VistaWorkouts getPnlVistaWorkouts() {
        return pnlVistaWorkouts;
    }

    public void setPnlVistaWorkouts(VistaWorkouts pnlVistaWorkouts) {
        this.pnlVistaWorkouts = pnlVistaWorkouts;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLogOut;
    private javax.swing.JLabel jLabelUsuariRegistrat;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanelLogin;
    private javax.swing.JTable jTableWorkOutsperborrar;
    // End of variables declaration//GEN-END:variables
}
