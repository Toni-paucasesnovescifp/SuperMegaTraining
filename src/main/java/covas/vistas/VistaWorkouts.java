package covas.vistas;

import covas.model.Workout;
import covas.model.Usuari;
import covas.model.Exercici;
import java.awt.Cursor;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import covas.controlador.DataAccess;

import javax.swing.JOptionPane;


/**
 *
 * @author Toni Covas
 */
public class VistaWorkouts extends javax.swing.JPanel {
    private Main main=null;
    private Usuari usuariSeleccionat=null;
    private DefaultTableModel model;
    private JTable jTableWorkOuts;
    private DefaultTableModel modelExercicis;
    private Workout workoutSeleccionat =null;
    private JTable jTableExercicis;
 
    public VistaWorkouts(Main mainJframe) {
        initComponents();
        main=mainJframe;
        carregarTaulaWorkouts();
        
        
        carregarTaulaExercicis();

    }

    
    public void carregarTaulaWorkouts() { 
        jTableWorkOuts = new JTable();
        JTableHeader th = jTableWorkOuts.getTableHeader();
        th.setFont(new Font("Serif", Font.BOLD, 15));
        
        model =new DefaultTableModel();
        model.setColumnCount(3);
        jTableWorkOuts.setModel(model);
        model.setColumnIdentifiers(new Object[]{"ForDate", "Id", "Comments" });

        actualizarTablaWorkouts(main.getUsuariSeleccionatTexte());
        
        
        jScrollPane3.setLocation(15, this.getLocation().y+17);         
        jScrollPane3.getViewport().add(jTableWorkOuts);
                
        jLabelListaWorkouts.setLocation(jScrollPane3.getLocation().x-5, jScrollPane3.getLocation().y-20);
        jLabelListaWorkouts.setText("Estos es el listado de Workouts del usuario: " + main.getUsuariSeleccionat().getNom()  );        
        jLabelListaWorkouts.setVisible(true);
    
        jLabelIrAtras.setLocation(jLabelListaWorkouts.getLocation().x+300, jScrollPane3.getLocation().y+jScrollPane3.getHeight()+10);
        jLabelIrAtras.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jLabelIrAtras.setVisible(true);
 

        jButtonAnadirWorkout.setLocation(jScrollPane3.getLocation().x,  jLabelIrAtras.getLocation().y);
        jButtonAnadirWorkout.setText("Añadir Workout");
        
        jButtonBorrarWorkout.setLocation(jScrollPane3.getLocation().x,  jLabelIrAtras.getLocation().y+23);
        jButtonBorrarWorkout.setText("Borrar Workout");
        
        
        jButtonModificarWorkout.setLocation(jScrollPane3.getLocation().x,  jLabelIrAtras.getLocation().y+46);
        jButtonModificarWorkout.setText("Modificar Workout");

        jButtonVerEjercicios.setLocation(jLabelListaWorkouts.getLocation().x+290, jLabelListaWorkouts.getLocation().y+50);
        jButtonVerEjercicios.setText("Actualizar datos ejercicios");
        
    }
    

    
    
    public void carregarTaulaExercicis() {        
       
        jTableExercicis = new JTable();
        JTableHeader thExercicis = jTableExercicis.getTableHeader();
        thExercicis.setFont(new Font("Serif", Font.BOLD, 15));
        
        modelExercicis =new DefaultTableModel();
        modelExercicis.setColumnCount(3);
        jTableExercicis.setModel(modelExercicis);
        modelExercicis.setColumnIdentifiers(new Object[]{"IdExercici", "Exercici", "Descripcio" });
      
        if (model.getRowCount()>0) {
        actualizarTablaEjercicios((int)jTableWorkOuts.getValueAt(jTableWorkOuts.getSelectedRow(), 1));
        }
 
        jScrollPane1.setLocation(jScrollPane3.getLocation().x+510, this.getLocation().y+17);   
        jScrollPane1.getViewport().removeAll();
        jScrollPane1.getViewport().add(jTableExercicis);
                    
        jLabelListaExercicis.setLocation(jScrollPane1.getLocation().x, jScrollPane1.getLocation().y-20);
        
        if (workoutSeleccionat!=null) {
            jLabelListaExercicis.setText("Estos es el listado de Ejercicios del workout: " + workoutSeleccionat.getId()  );        
        } else {
            jLabelListaExercicis.setText("" );                    
        }
            
        
        jLabelListaExercicis.setVisible(true);
  
    
        
 
        repaint();



        
    } 
   
   

   
    public void actualizarTablaWorkouts(String usuarioIdTexto) {
        for (int i = model.getRowCount()-1; i >=0 ; i--) {
            model.removeRow(i);
        }
       
        ArrayList<Usuari> usuaris = DataAccess.getAllUsers();
            for(int i=0; i<usuaris.size(); i++) {
                if (usuaris.get(i).getNom().equals(usuarioIdTexto)) {
                     usuariSeleccionat=usuaris.get(i);
                }
           }
         
        main.setUsuariSeleccionatTexte(null);
    
        ArrayList<Workout> workouts = DataAccess.getWorkoutsPerUser( usuariSeleccionat );
        for(Workout w: workouts) {
             model.addRow(new Object[]{w.getForDate(), w.getId(), w.getComments() });
        }
            
        jTableWorkOuts.changeSelection(0, 0, false, false);
        main.setUsuariSeleccionat(usuariSeleccionat);
        

   }
   
   
   
   
   

    public void actualizarTablaEjercicios(int idWorkout) {
        ArrayList<Workout> workouts = DataAccess.getWorkoutsPerUser( usuariSeleccionat );
    
        for(int i=0; i<workouts.size(); i++) {
            if (workouts.get(i).getId()==idWorkout) {
                workoutSeleccionat=workouts.get(i);
            }
        }
        
        
        ArrayList<Exercici> exercicis = DataAccess.getExercicisPerWorkout( workoutSeleccionat);
        for(Exercici e: exercicis) {
             modelExercicis.addRow(new Object[]{e.getId(), e.getNomExercici()  , e.getDescripcio() });
        }

         jLabelListaExercicis.setText("Estos es el listado de Ejercicios del workout: " + workoutSeleccionat.getId()  );    
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jLabelListaWorkouts = new javax.swing.JLabel();
        jLabelIrAtras = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLabelListaExercicis = new javax.swing.JLabel();
        jButtonVerEjercicios = new javax.swing.JButton();
        jButtonAnadirWorkout = new javax.swing.JButton();
        jButtonBorrarWorkout = new javax.swing.JButton();
        jButtonModificarWorkout = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(900, 700));
        setPreferredSize(new java.awt.Dimension(900, 700));
        setLayout(null);

        jScrollPane3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane3MouseClicked(evt);
            }
        });
        add(jScrollPane3);
        jScrollPane3.setBounds(10, 50, 280, 130);

        jLabelListaWorkouts.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelListaWorkouts.setText("jLabel1");
        add(jLabelListaWorkouts);
        jLabelListaWorkouts.setBounds(50, 220, 710, 20);

        jLabelIrAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/flecha_atras.png"))); // NOI18N
        jLabelIrAtras.setText("Volver");
        jLabelIrAtras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelIrAtrasMouseClicked(evt);
            }
        });
        add(jLabelIrAtras);
        jLabelIrAtras.setBounds(260, 250, 118, 60);
        add(jScrollPane1);
        jScrollPane1.setBounds(330, 50, 330, 130);

        jLabelListaExercicis.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelListaExercicis.setText("jLabel1");
        add(jLabelListaExercicis);
        jLabelListaExercicis.setBounds(10, 190, 710, 20);

        jButtonVerEjercicios.setText("jButton1");
        jButtonVerEjercicios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonVerEjerciciosMouseClicked(evt);
            }
        });
        jButtonVerEjercicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerEjerciciosActionPerformed(evt);
            }
        });
        add(jButtonVerEjercicios);
        jButtonVerEjercicios.setBounds(90, 0, 210, 40);

        jButtonAnadirWorkout.setText("jButton1");
        jButtonAnadirWorkout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnadirWorkoutActionPerformed(evt);
            }
        });
        add(jButtonAnadirWorkout);
        jButtonAnadirWorkout.setBounds(40, 320, 140, 23);

        jButtonBorrarWorkout.setText("jButton1");
        jButtonBorrarWorkout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarWorkoutActionPerformed(evt);
            }
        });
        add(jButtonBorrarWorkout);
        jButtonBorrarWorkout.setBounds(40, 360, 140, 23);

        jButtonModificarWorkout.setText("jButton1");
        jButtonModificarWorkout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarWorkoutActionPerformed(evt);
            }
        });
        add(jButtonModificarWorkout);
        jButtonModificarWorkout.setBounds(40, 400, 140, 23);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelIrAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelIrAtrasMouseClicked

        int numDatos = model.getRowCount();
        for (int i = 0; i < numDatos; i++) {
            model.removeRow(0);
        }
        
        main.getContentPane().remove(this);
        main.revalidate();
        main.repaint();

        main.carregarLlistaUsuarisInstructor();// TODO add your handling code here:
    }//GEN-LAST:event_jLabelIrAtrasMouseClicked

    private void jScrollPane3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane3MouseClicked
        
        



// TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane3MouseClicked

    private void jButtonVerEjerciciosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonVerEjerciciosMouseClicked
 
    }//GEN-LAST:event_jButtonVerEjerciciosMouseClicked

    private void jButtonVerEjerciciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerEjerciciosActionPerformed
        for (int i = modelExercicis.getRowCount()-1; i >=0 ; i--) {
            modelExercicis.removeRow(i);
        }
        actualizarTablaEjercicios( (int)jTableWorkOuts.getValueAt(jTableWorkOuts.getSelectedRow(), 1));
        
        
        
    }//GEN-LAST:event_jButtonVerEjerciciosActionPerformed

    private void jButtonAnadirWorkoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnadirWorkoutActionPerformed

       try { 
            Workout workoutPerAfegir =new Workout();       
            
            String nouForDate= JOptionPane.showInputDialog("Per al nou workout, introdueixi la data en format aaaaa-mm-dd  (per exemple, 2024-05-26");
            workoutPerAfegir.setForDate(nouForDate);
            
            workoutPerAfegir.setIdUsuari(main.getUsuariSeleccionat().getId());
            
            String nouComments=JOptionPane.showInputDialog("Introdueixi els comentaris per aquest workout que vol crear");
            workoutPerAfegir.setComments(nouComments);
            
            DataAccess.insertToWorkoutTable(workoutPerAfegir) ;
            actualizarTablaWorkouts(main.getUsuariSeleccionat().getNom());
            
            for (int i = modelExercicis.getRowCount()-1; i >=0 ; i--) {
                modelExercicis.removeRow(i);
            }
            
            if (model.getRowCount()>0) {
            actualizarTablaEjercicios( (int)jTableWorkOuts.getValueAt(jTableWorkOuts.getSelectedRow(), 1));
            }
            
            
            
            
         } catch  (Exception e) {
            JOptionPane.showMessageDialog(this, "Hi ha hagut errors i no s'ha pogut donar d'alta el workout. "   );              
           
       }
       
       
       
       
    }//GEN-LAST:event_jButtonAnadirWorkoutActionPerformed

    private void jButtonBorrarWorkoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarWorkoutActionPerformed
        try {        
            DataAccess.deleteFromWorkoutTable( (int)jTableWorkOuts.getValueAt(jTableWorkOuts.getSelectedRow(), 1)           );
            model.removeRow(jTableWorkOuts.getSelectedRow());
            actualizarTablaWorkouts(main.getUsuariSeleccionat().getNom());
        } catch (Exception e) {
    
           JOptionPane.showMessageDialog(this, "Hi ha hagut errors i no s'ha pogut borrar el workout");              
    }
        
        for (int i = modelExercicis.getRowCount()-1; i >=0 ; i--) {
            modelExercicis.removeRow(i);
        }
        
        if (model.getRowCount()>0) {
            actualizarTablaEjercicios( (    int)jTableWorkOuts.getValueAt(jTableWorkOuts.getSelectedRow(), 1));
        } else {
            jLabelListaExercicis.setText("");
        }
        
    
        
        
        
        
        
        
    }//GEN-LAST:event_jButtonBorrarWorkoutActionPerformed

    private void jButtonModificarWorkoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarWorkoutActionPerformed
        try {
        
            String nouForDate= (String) JOptionPane.showInputDialog(this, "Per modificar la data al workout, introdueixi la data en format aaaaa-mm-dd  (per exemple, 2024-05-26. Serà la nova data del workout número " + (int)jTableWorkOuts.getValueAt(jTableWorkOuts.getSelectedRow(), 1)        , "Modificar workout", JOptionPane.QUESTION_MESSAGE, null, null, jTableWorkOuts.getValueAt(jTableWorkOuts.getSelectedRow(), 0)        );
            String nouComments= (String) JOptionPane.showInputDialog(this, "Introdueixi aquí el texte que vol posar ara al workout número "+ (int)jTableWorkOuts.getValueAt(jTableWorkOuts.getSelectedRow(), 1)             , "Modificar workout", JOptionPane.QUESTION_MESSAGE, null, null, jTableWorkOuts.getValueAt(jTableWorkOuts.getSelectedRow(), 2)        );
    
            int workoutId= (int)jTableWorkOuts.getValueAt(jTableWorkOuts.getSelectedRow(), 1)         ;;

            DataAccess.updateFromWorkoutTable(nouForDate, nouComments, workoutId);
            actualizarTablaWorkouts(main.getUsuariSeleccionat().getNom());
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Hi ha hagut errors i no s'ha pogut modificar el workout");              
    }


    
    }//GEN-LAST:event_jButtonModificarWorkoutActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnadirWorkout;
    private javax.swing.JButton jButtonBorrarWorkout;
    private javax.swing.JButton jButtonModificarWorkout;
    private javax.swing.JButton jButtonVerEjercicios;
    private javax.swing.JLabel jLabelIrAtras;
    private javax.swing.JLabel jLabelListaExercicis;
    private javax.swing.JLabel jLabelListaWorkouts;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
