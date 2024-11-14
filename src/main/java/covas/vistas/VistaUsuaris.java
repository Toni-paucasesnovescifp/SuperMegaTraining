package covas.vistas;

import javax.swing.JList;

/**
 *
 * @author Toni Covas
 */
public class VistaUsuaris extends javax.swing.JPanel {
    private Main main=null;

    public VistaUsuaris(Main mainJframe) {
        initComponents();
        main=mainJframe;  
        
        jScrollPane2.setLocation(main.getLocation().x+main.getWidth()/2-40, this.getLocation().y+17);
        jScrollPane2.setVisible(true);
        
        jLabelListaTitulo.setLocation(main.getWidth()/2-jScrollPane2.getWidth()/2-5, this.getLocation().y);
        jLabelListaTitulo.setText("Estos son los usuarios a los que entrenas actualmente");        
        jLabelListaTitulo.setVisible(true);
        
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

        setMinimumSize(new java.awt.Dimension(900, 700));
        setPreferredSize(new java.awt.Dimension(900, 700));
        setLayout(null);

        jListUsuarisInstructor.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListUsuarisInstructor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListUsuarisInstructorMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jListUsuarisInstructor);

        add(jScrollPane2);
        jScrollPane2.setBounds(30, 10, 190, 210);

        jLabelListaTitulo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelListaTitulo.setText("TituloLista");
        add(jLabelListaTitulo);
        jLabelListaTitulo.setBounds(20, 230, 520, 20);
    }// </editor-fold>//GEN-END:initComponents

    private void jListUsuarisInstructorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListUsuarisInstructorMouseClicked
        jScrollPane2.setVisible(false);
        main.carregarLlistaWorkOutsUsuari( jListUsuarisInstructor.getSelectedValue() );    // TODO add your handling code here:
    }//GEN-LAST:event_jListUsuarisInstructorMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelListaTitulo;
    private javax.swing.JList<String> jListUsuarisInstructor;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
