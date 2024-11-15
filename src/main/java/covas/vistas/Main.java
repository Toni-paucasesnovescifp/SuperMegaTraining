/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package covas.vistas;

import covas.model.Usuari;
import covas.controlador.DataAccess;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JDialog;
import javax.swing.JFrame;


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



    public String getUsuariSeleccionatTexte() {
        return usuariSeleccionatTexte;
    }

    public void setUsuariSeleccionatTexte(String usuariSeleccionatTexte) {
        this.usuariSeleccionatTexte = usuariSeleccionatTexte;
    }




    public Main() {
        initComponents();
        
        //ponemos al principio en invislbe el panel3 que contiene los datos del usuario activo y botón de logout
        jPanel3.setVisible(false);
        jPanel3.setLocation(getWidth()-300, 20);   // panell amb el nom d'usuari actiu visible y botó de Log Out
        
        pnlMain=new MainJPanel(this);
        pnlMain.setBounds(1,35,getContentPane().getWidth(),280);
        pnlMain.setSize(getContentPane().getWidth(),280);
        getContentPane().add(pnlMain);
        repaint();
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jButtonLogOut = new javax.swing.JButton();
        jLabelUsuariRegistrat = new javax.swing.JLabel();
        jTableWorkOutsperborrar = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 700));
        setResizable(false);
        setSize(new java.awt.Dimension(900, 700));
        getContentPane().setLayout(null);

        jPanel3.setVisible(false);
        jPanel3.setLayout(null);

        jButtonLogOut.setText("Log Out");
        jButtonLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogOutActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonLogOut);
        jButtonLogOut.setBounds(155, 15, 90, 23);

        jLabelUsuariRegistrat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelUsuariRegistrat.setText("Usuari:");
        jLabelUsuariRegistrat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(jLabelUsuariRegistrat);
        jLabelUsuariRegistrat.setBounds(6, 14, 143, 22);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(382, 0, 270, 50);

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

        jMenu1.setText("File");
        jMenu1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jMenu1KeyPressed(evt);
            }
        });

        jMenuItem3.setText("Veure per Consola usuaris");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem2.setText("Acerca de...");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

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
        pnlLogIn.setVisible(true);
        
    }
    
    
    
    private void jButtonLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogOutActionPerformed
                
        
            
        JOptionPane.showMessageDialog(this, "Hasta Luego " + jLabelUsuariRegistrat.getText() +  " !.  Su sesión ha sido desconectada");              
        jLabelUsuariRegistrat.setText("");
        jPanel3.setVisible(false);        // TODO add your handling code here:
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
        jPanel3.setVisible(true);
    }
    
    public  void carregarLlistaUsuarisInstructor() {
        
        if (pnlVistaWorkouts!=null ) {
        getContentPane().remove(getPnlVistaWorkouts());
        }
       
 
        if (pnlVistaUsuaris!=null ) {
        getContentPane().remove(getPnlVistaUsuaris());
        }
        
        DefaultListModel llistaBase = new DefaultListModel();
        ArrayList<Usuari> usuaris = DataAccess.getAllUsersByInstructor(getUsuariActiu().getId() );
        System.out.println("l'usuari es: "+getUsuariActiu().getId());
        System.out.println("\n"+ usuaris.size());
            for(int i=0; i<usuaris.size(); i++) {
                llistaBase.add(i, usuaris.get(i).getNom());
                
        }

    
        
        setPnlVistaUsuaris(new VistaUsuaris(this));
        getPnlVistaUsuaris().setBounds(1,320,getContentPane().getWidth(),500);
        getPnlVistaUsuaris().setSize(getContentPane().getWidth(),300);
        getPnlVistaUsuaris().getListUsuarisInstructor().setModel(llistaBase);
        
        
        getContentPane().add(getPnlVistaUsuaris());
        revalidate();
        repaint();

        
    }
    
    
    public  void carregarLlistaWorkOutsUsuari(String nomUsuari) {
        getContentPane().remove(getPnlVistaUsuaris());        
        setUsuariSeleccionatTexte(nomUsuari)        ;
        setPnlVistaWorkouts(new VistaWorkouts(this));
        getPnlVistaWorkouts().setBounds(1,320,getContentPane().getWidth(),500);
        getPnlVistaWorkouts().setSize(getContentPane().getWidth(),300);
            
        
        getContentPane().remove(getPnlVistaUsuaris());
        getContentPane().add(getPnlVistaWorkouts());
        repaint();

            
        
            
    }
    
    
    
    
    
    public static void main(String args[]) {
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTable jTableWorkOutsperborrar;
    // End of variables declaration//GEN-END:variables
}
