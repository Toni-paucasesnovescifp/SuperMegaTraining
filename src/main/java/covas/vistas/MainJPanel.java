package covas.vistas;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.JLabel;

/**
 *
 * @author Toni Covas
 */
public class MainJPanel extends javax.swing.JPanel {
    private Main main=null;


    public MainJPanel(Main mainJframe) {
        initComponents();
        main=mainJframe;        

        int X = (main.getWidth() ) / 2;
        int Y = 80;
        jLabelLogo.setLocation(X - jLabelLogo.getWidth()/2, Y);
        
        
        jLabelLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jLabelLink.setForeground(Color.BLUE.darker());
        jLabelLink.setLocation(  jLabelLogo.getLocation().x+ jLabelLogo.getWidth()+10, Y+jLabelLogo.getHeight()/2);
        jLabelLink.setText("<html><a href=''>http://www.supermegatraining.com</a></html>");
        
        jLabelSignIn.setLocation(jLabelLogo.getLocation().x+ jLabelLogo.getWidth()/3, Y+jLabelLogo.getHeight() + 20        );
        jLabelSignIn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    @SuppressWarnings("unchecked")
    
    
    public JLabel getJLabelSignIn() {
        return this.jLabelSignIn;
        
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelLink = new javax.swing.JLabel();
        jLabelLogo = new javax.swing.JLabel();
        jLabelSignIn = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(900, 700));
        setPreferredSize(new java.awt.Dimension(900, 700));
        setLayout(null);

        jLabelLink.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelLink.setText("companyname");
        jLabelLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelLinkMouseClicked(evt);
            }
        });
        add(jLabelLink);
        jLabelLink.setBounds(150, 80, 300, 20);

        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logocompany.jpg"))); // NOI18N
        add(jLabelLogo);
        jLabelLogo.setBounds(20, 50, 100, 90);

        jLabelSignIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconologin.png"))); // NOI18N
        jLabelSignIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSignInMouseClicked(evt);
            }
        });
        add(jLabelSignIn);
        jLabelSignIn.setBounds(30, 160, 80, 70);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelLinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLinkMouseClicked
        try {
            Desktop.getDesktop().browse(new URI("https://paucasesnovescifp.cat/"));
        } catch (IOException | URISyntaxException e1) {
            e1.printStackTrace();
        }
    }//GEN-LAST:event_jLabelLinkMouseClicked

    private void jLabelSignInMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSignInMouseClicked
        
        main.abrirLogin();
        
    }//GEN-LAST:event_jLabelSignInMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelLink;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelSignIn;
    // End of variables declaration//GEN-END:variables
}
