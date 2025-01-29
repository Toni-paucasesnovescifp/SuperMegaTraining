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
import covas.dataaccess.DataAccess;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Toni Covas
 */
public class VistaWorkouts extends javax.swing.JPanel {

    private Main main = null;
    private Usuari usuariSeleccionat = null;
    private DefaultTableModel model;
    private JTable jTableWorkOuts;
    private DefaultTableModel modelExercicis;
    private Workout workoutSeleccionat = null;
    private JTable jTableExercicis;

    public VistaWorkouts(Main mainJframe) {
        initComponents();
        main = mainJframe;
        //setLayout(new MigLayout("fill, insets 1", "[grow, fill][grow, fill]", "[]1[]"));
        setLayout(new MigLayout("fill, insets 1", "[grow, center]", "[]1[]"));

        ArrayList<Usuari> usuaris = DataAccess.getAllUsers();
        for (int i = 0; i < usuaris.size(); i++) {
            if (usuaris.get(i).getNom().equals(main.getUsuariSeleccionatTexte())) {
                usuariSeleccionat = usuaris.get(i);
            }
        }

        carregarFoto();

        carregarTaulaWorkouts();
        carregarTaulaExercicis();

    }

    public void carregarFoto() {
        JLabel jLabelFoto;

        byte[] fotoBytes = usuariSeleccionat.getFoto();

// Verificar si fotoBytes es null
        if (fotoBytes != null) {
            // Convertir el array de bytes en una imagen
            BufferedImage imagen = null;
            try {
                ByteArrayInputStream bais = new ByteArrayInputStream(fotoBytes);
                imagen = ImageIO.read(bais);
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Crear un JLabel para mostrar la imagen
            jLabelFoto = new JLabel();
            if (imagen != null) {

                int anchoDeseado = 75; // 3 cm (asumiendo 10 píxeles por mm)
                int anchoOriginal = imagen.getWidth();
                int altoOriginal = imagen.getHeight();
                int altoDeseado = (anchoDeseado * altoOriginal) / anchoOriginal;

                Image imagenRedimensionada = imagen.getScaledInstance(anchoDeseado, altoDeseado, Image.SCALE_SMOOTH);

                jLabelFoto.setIcon(new ImageIcon(imagenRedimensionada));
            } else {
                jLabelFoto.setText("No se pudo cargar la imagen");
            }
        } else {
            // Mostrar un mensaje si fotoBytes es null
            jLabelFoto = new JLabel("No hay foto disponible");
        }

        Color borderColor = new Color(255, 200, 0); // Color entre amarillo y naranja
        Border border = BorderFactory.createLineBorder(borderColor, 5);
        jLabelFoto.setBorder(border);

        add(jLabelFoto, "span, align center, wrap");

    }

    public void carregarTaulaWorkouts() {
        //jTableWorkOuts = new JTable();
        
        

        
        
     
        //th.setFont(new Font("Serif", Font.BOLD, 15));

        model = new DefaultTableModel();
        model.setColumnCount(3);
        
        
                         jTableWorkOuts = new JTable(model) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Todas las celdas no son editables
            }
        };

           JTableHeader th = jTableWorkOuts.getTableHeader();
        
        //jTableWorkOuts.setModel(model);
        model.setColumnIdentifiers(new Object[]{"ForDate", "Id", "Comments"});
        
                jTableWorkOuts.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    // Ejecutar el método al hacer doble clic
                    jButtonModificarWorkoutActionPerformed(null);
                }
            }
        });
        
        

        actualizarTablaWorkouts(main.getUsuariSeleccionatTexte());

        //TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        //jTableWorkOuts.setRowSorter(sorter);
        //sorter.setSortKeys(java.util.Collections.singletonList(new RowSorter.SortKey(1, SortOrder.ASCENDING)));
        jScrollPane3.getViewport().add(jTableWorkOuts);

        jLabelListaWorkouts.setText("Estos es el listado de Workouts del usuario: " + main.getUsuariSeleccionat().getNom());
        jLabelListaWorkouts.setVisible(true);

        jLabelIrAtras.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jLabelIrAtras.setVisible(true);

        jButtonAnadirWorkout.setText("Añadir Workout");
        //jButtonAnadirWorkout.setPreferredSize(new Dimension(30, jButtonAnadirWorkout.getPreferredSize().height));
        //jButtonAnadirWorkout.setMaximumSize(new Dimension(30, jButtonAnadirWorkout.getPreferredSize().height));
        jButtonBorrarWorkout.setText("Borrar Workout");
        //jButtonBorrarWorkout.setPreferredSize(new Dimension(30, jButtonBorrarWorkout.getPreferredSize().height));
        //jButtonBorrarWorkout.setMaximumSize(new Dimension(30, jButtonBorrarWorkout.getPreferredSize().height));
        jButtonModificarWorkout.setText("Modificar Workout");
        //jButtonModificarWorkout.setPreferredSize(new Dimension(30, jButtonModificarWorkout.getPreferredSize().height));
        //jButtonModificarWorkout.setMaximumSize(new Dimension(30, jButtonModificarWorkout.getPreferredSize().height));
        //jButtonVerEjercicios.setText("Actualizar datos ejercicios");
        //jButtonVerEjercicios.setPreferredSize(new Dimension(30, jButtonVerEjercicios.getPreferredSize().height));
        //jButtonVerEjercicios.setMaximumSize(new Dimension(30, jButtonVerEjercicios.getPreferredSize().height));

        JPanel jPanelWorkouts = new JPanel(new MigLayout("fill, insets 1", "[grow, fill]", "[]1[]"));
        jPanelWorkouts.add(jLabelListaWorkouts, "wrap");
        jPanelWorkouts.add(jScrollPane3, "wrap");
        jPanelWorkouts.add(jButtonAnadirWorkout, "split 3, sg btn");
        jPanelWorkouts.add(jButtonBorrarWorkout, "sg btn");
        jPanelWorkouts.add(jButtonModificarWorkout, "sg btn, wrap");

        JPanel jPanelExercicis = new JPanel(new MigLayout("fill, insets 1", "[grow, fill]", "[]1[]"));
        jPanelExercicis.add(jLabelListaExercicis, "wrap");
        jPanelExercicis.add(jScrollPane1, "wrap");

        add(jPanelWorkouts, "grow");
        add(jPanelExercicis, "grow, wrap");
        //add(jButtonVerEjercicios, "span, align center, wrap");
        add(jLabelIrAtras, "span, align center, wrap");

        // Ajustar la altura de la tabla según el número de filas
        //jTableWorkOuts.setPreferredScrollableViewportSize(new Dimension(jTableWorkOuts.getPreferredSize().width, jTableWorkOuts.getRowHeight() * jTableWorkOuts.getRowCount()));
        jTableWorkOuts.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    // Verificar si hay filas en la tabla y si hay una fila seleccionada
                    if (jTableWorkOuts.getRowCount() > 0 && jTableWorkOuts.getSelectedRow() != -1) {
                        // Limpiar la tabla de ejercicios
                        for (int i = modelExercicis.getRowCount() - 1; i >= 0; i--) {
                            modelExercicis.removeRow(i);
                        }
                        // Actualizar la tabla de ejercicios con la fila seleccionada
                        actualizarTablaEjercicios((int) jTableWorkOuts.getValueAt(jTableWorkOuts.getSelectedRow(), 1));
                    }
                }
            }
        });

        ajustarAnchoColumnas(jTableWorkOuts);

        repaint();

    }

    private void ajustarAnchoColumnas(JTable table) {
        TableModel model = table.getModel();
        for (int column = 0; column < table.getColumnCount(); column++) {
            TableColumn tableColumn = table.getColumnModel().getColumn(column);
            int preferredWidth = tableColumn.getMinWidth();
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer cellRenderer = table.getCellRenderer(row, column);
                Component c = table.prepareRenderer(cellRenderer, row, column);
                int width = c.getPreferredSize().width + table.getIntercellSpacing().width;
                preferredWidth = Math.max(preferredWidth, width);
            }
            tableColumn.setPreferredWidth(preferredWidth);
        }
    }

    public void carregarTaulaExercicis() {

        jTableExercicis = new JTable();
        JTableHeader thExercicis = jTableExercicis.getTableHeader();
        thExercicis.setFont(new Font("Serif", Font.BOLD, 15));

        modelExercicis = new DefaultTableModel();
        modelExercicis.setColumnCount(3);
        jTableExercicis.setModel(modelExercicis);
        modelExercicis.setColumnIdentifiers(new Object[]{"IdExercici", "Exercici", "Descripcio"});

        if (model.getRowCount() > 0) {
            actualizarTablaEjercicios((int) jTableWorkOuts.getValueAt(jTableWorkOuts.getSelectedRow(), 1));
        }

        jScrollPane1.setLocation(jScrollPane3.getLocation().x + 510, this.getLocation().y + 17);
        jScrollPane1.getViewport().removeAll();
        jScrollPane1.getViewport().add(jTableExercicis);

        //jLabelListaExercicis.setLocation(jScrollPane1.getLocation().x, jScrollPane1.getLocation().y-20);
        if (workoutSeleccionat != null) {
            jLabelListaExercicis.setText("Estos es el listado de Ejercicios del workout: " + workoutSeleccionat.getId());
        } else {
            jLabelListaExercicis.setText("");
        }

        jLabelListaExercicis.setVisible(true);

        //jTableExercicis.setPreferredScrollableViewportSize(new Dimension(jTableExercicis.getPreferredSize().width, jTableExercicis.getRowHeight() * jTableExercicis.getRowCount()));
        ajustarAnchoColumnas(jTableExercicis);
        repaint();

    }

    public void seleccionarFilaPorId(int workoutId) {
        for (int i = 0; i < jTableWorkOuts.getRowCount(); i++) {
            if ((int) jTableWorkOuts.getValueAt(i, 1) == workoutId) {
                jTableWorkOuts.setRowSelectionInterval(i, i);
                break;
            }
        }
    }

    public void actualizarTablaWorkouts(String usuarioIdTexto) {
        // Eliminar todas las filas de la tabla
        for (int i = model.getRowCount() - 1; i >= 0; i--) {
            model.removeRow(i);
        }

        // Obtener el usuario seleccionado
        ArrayList<Usuari> usuaris = DataAccess.getAllUsers();
        for (int i = 0; i < usuaris.size(); i++) {
            if (usuaris.get(i).getNom().equals(usuarioIdTexto)) {
                usuariSeleccionat = usuaris.get(i);
            }
        }

        main.setUsuariSeleccionatTexte(null);

        // Obtener los workouts del usuario seleccionado
        ArrayList<Workout> workouts = DataAccess.getWorkoutsPerUser(usuariSeleccionat);

// Ordenar los datos por la columna "ID" (índice 0)
        Collections.sort(workouts, new Comparator<Workout>() {
            @Override
            public int compare(Workout w1, Workout w2) {
                return Integer.compare(w1.getId(), w2.getId());
            }
        });

        for (Workout w : workouts) {
            
        SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat targetFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date = null;
        try {
            date = originalFormat.parse(w.getForDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String  dataFormatAjustat= targetFormat.format(date);
            
            
            
            
            model.addRow(new Object[]{dataFormatAjustat, w.getId(), w.getComments()});
        }

        // Verificar si la tabla tiene al menos una fila antes de seleccionar
        if (model.getRowCount() > 0) {
            jTableWorkOuts.changeSelection(0, 0, false, false);
        }

        main.setUsuariSeleccionat(usuariSeleccionat);
    }

    public void actualizarTablaEjercicios(int idWorkout) {
        ArrayList<Workout> workouts = DataAccess.getWorkoutsPerUser(usuariSeleccionat);

        for (int i = 0; i < workouts.size(); i++) {
            if (workouts.get(i).getId() == idWorkout) {
                workoutSeleccionat = workouts.get(i);
            }
        }

        ArrayList<Exercici> exercicis = DataAccess.getExercicisPerWorkout(workoutSeleccionat);

// Ordenar los datos por la columna "ID" (índice 0)
        Collections.sort(exercicis, new Comparator<Exercici>() {
            @Override
            public int compare(Exercici w1, Exercici w2) {
                return Integer.compare(w1.getId(), w2.getId());
            }
        });

        for (Exercici e : exercicis) {
            modelExercicis.addRow(new Object[]{e.getId(), e.getNomExercici(), e.getDescripcio()});
        }

        jLabelListaExercicis.setText("Estos es el listado de Ejercicios del workout: " + workoutSeleccionat.getId());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jLabelListaWorkouts = new javax.swing.JLabel();
        jLabelIrAtras = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLabelListaExercicis = new javax.swing.JLabel();
        jButtonAnadirWorkout = new javax.swing.JButton();
        jButtonBorrarWorkout = new javax.swing.JButton();
        jButtonModificarWorkout = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(900, 400));
        setLayout(null);

        jScrollPane3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane3MouseClicked(evt);
            }
        });
        add(jScrollPane3);
        jScrollPane3.setBounds(10, 50, 2, 2);

        jLabelListaWorkouts.setText("jLabel1");
        add(jLabelListaWorkouts);
        jLabelListaWorkouts.setBounds(50, 220, 330, 16);

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
        jScrollPane1.setBounds(330, 50, 2, 2);

        jLabelListaExercicis.setText("jLabel1");
        add(jLabelListaExercicis);
        jLabelListaExercicis.setBounds(10, 190, 710, 16);

        jButtonAnadirWorkout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/boton_anadir.png"))); // NOI18N
        jButtonAnadirWorkout.setMnemonic('A');
        jButtonAnadirWorkout.setText("jButton1");
        jButtonAnadirWorkout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnadirWorkoutActionPerformed(evt);
            }
        });
        add(jButtonAnadirWorkout);
        jButtonAnadirWorkout.setBounds(40, 320, 140, 39);

        jButtonBorrarWorkout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/boton_eliminar.png"))); // NOI18N
        jButtonBorrarWorkout.setMnemonic('B');
        jButtonBorrarWorkout.setText("jButton1");
        jButtonBorrarWorkout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarWorkoutActionPerformed(evt);
            }
        });
        add(jButtonBorrarWorkout);
        jButtonBorrarWorkout.setBounds(40, 360, 140, 39);

        jButtonModificarWorkout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/boton_modificar.png"))); // NOI18N
        jButtonModificarWorkout.setMnemonic('M');
        jButtonModificarWorkout.setText("jButton1");
        jButtonModificarWorkout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarWorkoutActionPerformed(evt);
            }
        });
        add(jButtonModificarWorkout);
        jButtonModificarWorkout.setBounds(40, 400, 140, 39);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelIrAtrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelIrAtrasMouseClicked

        //int numDatos = model.getRowCount();
        //for (int i = 0; i < numDatos; i++) {
        //    model.removeRow(0);
        //}
        main.getContentPane().remove(this);
        main.revalidate();
        main.repaint();

        main.carregarLlistaUsuarisInstructor();// TODO add your handling code here:
    }//GEN-LAST:event_jLabelIrAtrasMouseClicked

    private void jScrollPane3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane3MouseClicked

// TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane3MouseClicked

    private void jButtonAnadirWorkoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnadirWorkoutActionPerformed
        main.addChangeWorkouts("afegir", null);

        //try { 
        //  Workout workoutPerAfegir =new Workout();       
        //String nouForDate= JOptionPane.showInputDialog("Per al nou workout, introdueixi la data en format aaaaa-mm-dd  (per exemple, 2024-05-26");
        //workoutPerAfegir.setForDate(nouForDate);
        //workoutPerAfegir.setIdUsuari(main.getUsuariSeleccionat().getId());
        //String nouComments=JOptionPane.showInputDialog("Introdueixi els comentaris per aquest workout que vol crear");
        //workoutPerAfegir.setComments(nouComments);
        //DataAccess.insertToWorkoutTable(workoutPerAfegir) ;
        System.out.println("hem actualitzat per l'usuari: " + main.getUsuariSeleccionat().getNom());

        actualizarTablaWorkouts(main.getUsuariSeleccionat().getNom());

        for (int i = modelExercicis.getRowCount() - 1; i >= 0; i--) {
            modelExercicis.removeRow(i);
        }

        if (model.getRowCount() > 0) {
            actualizarTablaEjercicios((int) jTableWorkOuts.getValueAt(jTableWorkOuts.getSelectedRow(), 1));
        }

        //} catch  (Exception e) {
        //   JOptionPane.showMessageDialog(this, "Hi ha hagut errors i no s'ha pogut donar d'alta el workout. "   );              
        //}

    }//GEN-LAST:event_jButtonAnadirWorkoutActionPerformed

    private void jButtonBorrarWorkoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarWorkoutActionPerformed

    int result = JOptionPane.showConfirmDialog(null, "¿Seguro que desea borrar el workout seleccionado?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        // Verificar la selección del usuario
        if (result == JOptionPane.NO_OPTION) {
            // Si el usuario selecciona "No", ejecutar un return
            return;
        }









        int numeroWorkoutAEliminar=(int) jTableWorkOuts.getValueAt(jTableWorkOuts.getSelectedRow(), 1);
        try {
            DataAccess.deleteFromWorkoutTable(numeroWorkoutAEliminar );
            model.removeRow(jTableWorkOuts.getSelectedRow());
            actualizarTablaWorkouts(main.getUsuariSeleccionat().getNom());
        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, "Hi ha hagut errors i no s'ha pogut borrar el workout");
        }

        for (int i = modelExercicis.getRowCount() - 1; i >= 0; i--) {
            modelExercicis.removeRow(i);
        }

        if (model.getRowCount() > 0) {
            actualizarTablaEjercicios((int) jTableWorkOuts.getValueAt(jTableWorkOuts.getSelectedRow(), 1));
        } else {
            jLabelListaExercicis.setText("");
        }
        
        URL iconURL = Main.class.getResource("/images/checklist.png"); // Ruta a tu archivo de imagen
        ImageIcon icon = new ImageIcon(iconURL);
        JOptionPane.showMessageDialog(null, "El workout amb numero " + numeroWorkoutAEliminar          + " s'ha pogut el.liminar correctament.  " , "Eliminació de Workout", JOptionPane.INFORMATION_MESSAGE, icon);


    }//GEN-LAST:event_jButtonBorrarWorkoutActionPerformed

    private void jButtonModificarWorkoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarWorkoutActionPerformed
        Workout workoutModificar = new Workout();
        workoutModificar.setForDate((String) jTableWorkOuts.getValueAt(jTableWorkOuts.getSelectedRow(), 0));
        workoutModificar.setComments((String) jTableWorkOuts.getValueAt(jTableWorkOuts.getSelectedRow(), 2));
        workoutModificar.setId((int) jTableWorkOuts.getValueAt(jTableWorkOuts.getSelectedRow(), 1));
        workoutModificar.setIdUsuari(main.getUsuariSeleccionat().getId());

        main.addChangeWorkouts("modificar", workoutModificar);

        //if (7==8) {
        //    try {
        //      String nouForDate= (String) JOptionPane.showInputDialog(this, "Per modificar la data al workout, introdueixi la data en format aaaaa-mm-dd  (per exemple, 2024-05-26. Serà la nova data del workout número " + (int)jTableWorkOuts.getValueAt(jTableWorkOuts.getSelectedRow(), 1)        , "Modificar workout", JOptionPane.QUESTION_MESSAGE, null, null, jTableWorkOuts.getValueAt(jTableWorkOuts.getSelectedRow(), 0)        );
        //      String nouComments= (String) JOptionPane.showInputDialog(this, "Introdueixi aquí el texte que vol posar ara al workout número "+ (int)jTableWorkOuts.getValueAt(jTableWorkOuts.getSelectedRow(), 1)             , "Modificar workout", JOptionPane.QUESTION_MESSAGE, null, null, jTableWorkOuts.getValueAt(jTableWorkOuts.getSelectedRow(), 2)        );
        //       int workoutId= (int)jTableWorkOuts.getValueAt(jTableWorkOuts.getSelectedRow(), 1)         ;;
        //        DataAccess.updateFromWorkoutTable(nouForDate, nouComments, workoutId);
        actualizarTablaWorkouts(main.getUsuariSeleccionat().getNom());
        seleccionarFilaPorId(workoutModificar.getId());
        //    }
        //    catch (Exception e) {
        //        JOptionPane.showMessageDialog(this, "Hi ha hagut errors i no s'ha pogut modificar el workout");              
        // }


    }//GEN-LAST:event_jButtonModificarWorkoutActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnadirWorkout;
    private javax.swing.JButton jButtonBorrarWorkout;
    private javax.swing.JButton jButtonModificarWorkout;
    private javax.swing.JLabel jLabelIrAtras;
    private javax.swing.JLabel jLabelListaExercicis;
    private javax.swing.JLabel jLabelListaWorkouts;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
