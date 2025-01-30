package covas.vistas;

import covas.dataaccess.DataAccess;
import covas.model.Usuari;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.Border;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Toni Covas
 */
public class VistaUsuaris extends javax.swing.JPanel {

    private Main main = null;

    public VistaUsuaris(Main mainJframe) {
        initComponents();
        main = mainJframe;

        // definim el layout per les instàncies de l'objecte VistaUsuaris
        setLayout(new MigLayout("fill, insets 1", "[grow, center]", "[grow, center]"));

        //definim un DefaultListModel que serà la base d'informació per el JList
        DefaultListModel llistaBase = new DefaultListModel();
        ArrayList<Usuari> usuaris = DataAccess.getAllUsersByInstructor(main.getUsuariActiu().getId());
        System.out.println("l'usuari es: " + main.getUsuariActiu().getId());
        System.out.println("\n" + usuaris.size());
        for (int i = 0; i < usuaris.size(); i++) {
            llistaBase.add(i, usuaris.get(i).getNom());

        }
        
        //definim el DefaultListModel al Jlist
        getListUsuarisInstructor().setModel(llistaBase);

        
        // cream un jPanel amb MigLayout que durà tant el Jlist i el jLabel que presenta el Jlist
        JPanel panellJListUsuaris = new JPanel();
        panellJListUsuaris.setLayout(new MigLayout("fill, insets 1", "[grow, center]", "[]1[]"));

        jLabelListaTitulo.setText("Estos son los usuarios a los que entrenas actualmente");
        

        panellJListUsuaris.add(jLabelListaTitulo, " align center,  wrap");
        panellJListUsuaris.add(jScrollPane2, "span,  align center, wrap");

        // definim un marco per el jList
        Color borderColor = new Color(255, 200, 0); // Color entre groc i taronja
        Border border = BorderFactory.createLineBorder(borderColor, 5);
        jListUsuarisInstructor.setBorder(border);

        //incorporam el jList dins el panell, definint les propietats de MigLayout
        add(panellJListUsuaris, "span,  align center, wrap");
    }

    public JList<String> getListUsuarisInstructor() {
        return this.jListUsuarisInstructor;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jListUsuarisInstructor = new javax.swing.JList<>();
        jLabelListaTitulo = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(900, 400));
        setLayout(null);

        jScrollPane2.setPreferredSize(new java.awt.Dimension(200, 300));

        jListUsuarisInstructor.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListUsuarisInstructor.setMaximumSize(new java.awt.Dimension(500, 500));
        jListUsuarisInstructor.setMinimumSize(new java.awt.Dimension(1, 1));
        jListUsuarisInstructor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListUsuarisInstructorMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jListUsuarisInstructor);

        add(jScrollPane2);
        jScrollPane2.setBounds(30, 10, 190, 210);

        jLabelListaTitulo.setText("TituloLista");
        add(jLabelListaTitulo);
        jLabelListaTitulo.setBounds(20, 230, 520, 16);
    }// </editor-fold>//GEN-END:initComponents

    // definim que en fer click al jList se mos obri la pantalla dels workouts
    private void jListUsuarisInstructorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListUsuarisInstructorMouseClicked
        main.getContentPane().remove(this);
        main.revalidate();
        main.repaint();
        main.carregarLlistaWorkOutsUsuari(jListUsuarisInstructor.getSelectedValue());    

    }//GEN-LAST:event_jListUsuarisInstructorMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelListaTitulo;
    private javax.swing.JList<String> jListUsuarisInstructor;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
