/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reservacion.vista;

import com.reservacion.archivos.Archivo;
import static com.reservacion.archivos.Archivo.LeerReservaciones;
import com.reservacion.componentes.Fecha;
import com.reservacion.pojo.Estudiante;
import com.reservacion.pojo.Reservacion;
import java.math.BigInteger;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author mayra
 */
public class Reservaciones extends javax.swing.JDialog {
    
    Estudiante objeto1 = null;
    String fecha_reservacion;
    int dia, mes, anio, diasemana, total_horas = 0;
    ArrayList<Reservacion> lista = LeerReservaciones("Reservaciones.obj");
    Reservacion objeto3;

    /**
     * Creates new form Reservaciones
     */
    public Reservaciones(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        fecha_hoy.setText(Fecha.Fecha());
        patio.setEnabled(false);
        b2.setEnabled(false);
        b3.setEnabled(false);
     
        guardar.setEnabled(false);
        fecha_calendario.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        fecha_hoy = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        estudiante = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        patio = new javax.swing.JComboBox();
        b2 = new javax.swing.JButton();
        fecha_calendario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        guardar = new javax.swing.JButton();
        b3 = new javax.swing.JButton();

        jButton4.setText("jButton4");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(new java.awt.Rectangle(300, 180, 0, 0));

        fecha_hoy.setEditable(false);
        fecha_hoy.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        fecha_hoy.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Estudiante");

        estudiante.setEditable(false);
        estudiante.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        estudiante.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Reservación de:");

        patio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        patio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Elija una Opción", "PISCINA", "CANCHA DE FUTBOL", "CANCHA DE BASKET","AREA SOCIAL" }));
        patio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patioActionPerformed(evt);
            }
        });

        b2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        b2.setText("Buscar");
        b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2ActionPerformed(evt);
            }
        });

        fecha_calendario.setEditable(false);
        fecha_calendario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fecha_calendario.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Calendario");

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        guardar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        guardar.setText("Guardar");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        b3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        b3.setText("Disponibilidad");
        b3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fecha_hoy, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(estudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fecha_calendario, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(b2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(patio, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(b3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(203, 203, 203)))
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(fecha_hoy, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(estudiante)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 3, Short.MAX_VALUE))
                                    .addComponent(fecha_calendario)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(b2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(b3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(patio, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
     
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Consulta_Estudiantes_1 objeto = new Consulta_Estudiantes_1(new javax.swing.JFrame(), true);
        objeto.setVisible(true);
        objeto1 = objeto.getObjeto();
        if (objeto1 != null) {
            
            estudiante.setText(objeto1.getNombre() + " " + objeto1.getApellido());
            patio.setEnabled(true);
            b2.setEnabled(true);
        } else {
            patio.setEnabled(false);
            b2.setEnabled(false);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2ActionPerformed
        Calendario objeto = new Calendario(new javax.swing.JFrame(), true);
        objeto.setVisible(true);
        dia = objeto.getDia();
        mes = objeto.getMes();
        anio = objeto.getAnio();
        System.out.println(" año "+anio);
        if (Fecha.Anio() <= anio) {
            if (Fecha.Mes() <= mes) {
                if (Fecha.Dia() <= dia) {
                    diasemana = objeto.getDiasemana();
                    fecha_reservacion = Fecha.FechaString(dia, mes, anio);
                    fecha_calendario.setText(objeto.getDia_string() + " " + fecha_reservacion);
                    Habilitar(true);
                    fecha_calendario.setEnabled(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Fecha Inválida!!");
                    Habilitar(false); fecha_calendario.setText("");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Fecha Inválida!!");
                Habilitar(false);
                 fecha_calendario.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Fecha Inválida!!");
            Habilitar(false); fecha_calendario.setText("");
        }

    }//GEN-LAST:event_b2ActionPerformed
    public void Habilitar(boolean v) {            
        b3.setEnabled(v);
        guardar.setEnabled(v);
    }
    private void patioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patioActionPerformed
        
       
        if (patio.getSelectedIndex() > 0) {
            fecha_calendario.setEnabled(true);
            b2.setEnabled(true);
        } else {
            fecha_calendario.setEnabled(false);
            b2.setEnabled(false);
        }
    }//GEN-LAST:event_patioActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        
        if (objeto3 != null) {
            Grabar();
        } else {
            JOptionPane.showMessageDialog(null, "Datos u Horario Inválido!!");
        }
    }//GEN-LAST:event_guardarActionPerformed

    private void b3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b3ActionPerformed
        Reservacion obj1 = new Reservacion(
                BigInteger.valueOf((lista.size() + 1)), objeto1.getCedula(),
                (String) patio.getSelectedItem(), fecha_reservacion,
                0, 0, 0, dia, mes, anio);
        
        Disponibilidad objeto = new Disponibilidad(new javax.swing.JFrame(), true, obj1, estudiante.getText());
        objeto.setVisible(true);
        objeto3 = objeto.getObj2();
    }//GEN-LAST:event_b3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

 
    private void Grabar() {
        if (patio.getSelectedIndex() > 0 && fecha_calendario.getText() != null) {
            Reservacion objeto21 = new Reservacion(
             BigInteger.valueOf((lista.size() + 1)) , objeto3.getCedula() ,
                     objeto3.getEscenario() , objeto3.getFecha(),objeto3.getHora_inicio()
                    , objeto3.getHora_final(), objeto3.getTotal_hora(),dia ,mes , anio);
            lista.add(objeto3);
            Archivo.guardarReservaciones("Reservaciones.obj", lista);
            lista.clear();
            setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Faltan datos!!");
        }
    }

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
            java.util.logging.Logger.getLogger(Reservaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reservaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reservaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reservaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Reservaciones dialog = new Reservaciones(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton b2;
    private javax.swing.JButton b3;
    private javax.swing.JTextField estudiante;
    private javax.swing.JTextField fecha_calendario;
    private javax.swing.JTextField fecha_hoy;
    private javax.swing.JButton guardar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JComboBox patio;
    // End of variables declaration//GEN-END:variables
}
