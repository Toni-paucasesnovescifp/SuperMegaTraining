package covas.vistas;

import covas.model.Usuari;
import at.favre.lib.crypto.bcrypt.BCrypt;
import covas.controlador.DataAccess;

import javax.swing.JOptionPane;

/**
 *
 * @author Toni Covas
 */
public class LogIn extends javax.swing.JDialog {
    private Main main=null;
    
    /**
     * Creates new form LogIn
     */
    public LogIn(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        main=   (Main) parent;
        repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        txtEmailLogin = new javax.swing.JTextField();
        txtPasswordLogin = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        jLabelEmail = new javax.swing.JLabel();
        jLabelPassword = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Intrudueixi el seu usuari i contrasenya");
        setMinimumSize(new java.awt.Dimension(350, 300));
        getContentPane().setLayout(null);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Login"));
        jPanel2.setLayout(null);

        txtEmailLogin.setText("a@b.c");
        jPanel2.add(txtEmailLogin);
        txtEmailLogin.setBounds(120, 30, 143, 22);

        txtPasswordLogin.setText("string");
        jPanel2.add(txtPasswordLogin);
        txtPasswordLogin.setBounds(120, 60, 143, 22);

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        jPanel2.add(btnLogin);
        btnLogin.setBounds(80, 102, 72, 23);

        jLabelEmail.setText("Email");
        jPanel2.add(jLabelEmail);
        jLabelEmail.setBounds(18, 37, 50, 16);

        jLabelPassword.setText("Password");
        jPanel2.add(jLabelPassword);
        jLabelPassword.setBounds(18, 65, 90, 16);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(30, 30, 270, 150);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed

        Usuari usuari = DataAccess.getUser(txtEmailLogin.getText());
        if (usuari !=null) {
            char[] passwordToVerify = txtPasswordLogin.getPassword();
            String userPasswordHashInDatabase=usuari.getPasswordHash();
            var result = BCrypt.verifyer().verify(passwordToVerify,  userPasswordHashInDatabase);

            if (result.verified) {
                main.setUsuariActiu(usuari);                
                JOptionPane.showMessageDialog(this, "Login correcte. Benvingut " + usuari.getNom() +  "!");


            } else {
                JOptionPane.showMessageDialog(this,"Invalid Password !");
            }

        } else {
            JOptionPane.showMessageDialog(this, "Error. Email " + txtEmailLogin.getText() +  " not found!");
        }

        if (main.getUsuariActiu()!=null)    {            
            dispose();
            main.registrarUsuariActiu(main.getUsuariActiu());
            main.carregarLlistaUsuarisInstructor();
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LogIn dialog = new LogIn(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtEmailLogin;
    private javax.swing.JPasswordField txtPasswordLogin;
    // End of variables declaration//GEN-END:variables
}
