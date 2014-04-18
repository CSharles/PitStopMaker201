/*
 * EditarEquipo.java
 * Created on 09-dic-2011, 15:08:55
 * @author Carlos
 */
package pitstopmaker201;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import pitstopmaker201.Elementos.Piloto;

public class EditarEquipo extends javax.swing.JDialog {

    private Piloto pilot1;
    private Piloto pilot2;
    private int metodo;

    public EditarEquipo(java.awt.Frame parent, boolean modal, Piloto p1, Piloto p2) {
        super(parent, modal);
        initComponents();
        this.escureriaName.setText(p1.getTeam());
        this.piloto1.setText(p1.getName());
        this.piloto2.setText(p2.getName());
        this.piloto1Num.setValue(p1.getNumber());
        this.piloto2Num.setValue(p2.getNumber());
        this.pitGroupNumber.setText(p1.getPitgroup());
        this.metodo = 2;
        this.pilot1 = p1;
        this.pilot2 = p2;
    }

    public EditarEquipo(java.awt.Frame parent, boolean modal, Piloto p1) {
        super(parent, modal);
        initComponents();
        this.escureriaName.setText(p1.getTeam());
        this.piloto1.setText(p1.getName());
        this.piloto1Num.setValue(p1.getNumber());
        this.pitGroupNumber.setText(p1.getPitgroup());
        this.pilot1 = p1;
        this.metodo = 1;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        escureriaName = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        piloto1 = new javax.swing.JTextField();
        piloto2 = new javax.swing.JTextField();
        piloto1Num = new javax.swing.JSpinner();
        piloto2Num = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        pitGroupNumber = new javax.swing.JTextField();
        AplicarjButton = new javax.swing.JButton();
        CanceljButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PitStop Maker  - Editar Equipo");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Equipo:");

        escureriaName.setFont(new java.awt.Font("Cambria", 3, 24)); // NOI18N
        escureriaName.setText("jLabel2");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Pilotos"));

        jLabel3.setText("Nombres");

        jLabel4.setText("Numero");

        jLabel5.setText("Piloto 1:");

        jLabel6.setText("Piloto 2:");

        piloto1.setEditable(false);
        piloto1.setText("jTextField1");
        piloto1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                piloto1MouseClicked(evt);
            }
        });

        piloto2.setEditable(false);
        piloto2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                piloto2MouseClicked(evt);
            }
        });

        piloto1Num.setEnabled(false);

        piloto2Num.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(piloto2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(piloto1)
                            .addComponent(jLabel3))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(piloto1Num, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(piloto2Num, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(piloto1Num, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(piloto2Num, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(piloto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(piloto2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jLabel7.setText("Pit Group:");

        pitGroupNumber.setEditable(false);
        pitGroupNumber.setText("jTextField3");
        pitGroupNumber.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pitGroupNumberMouseClicked(evt);
            }
        });

        AplicarjButton.setText("Aplicar");
        AplicarjButton.setEnabled(false);
        AplicarjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AplicarjButtonActionPerformed(evt);
            }
        });

        CanceljButton.setText("Cancelar");
        CanceljButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CanceljButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(AplicarjButton)
                                .addGap(18, 18, 18)
                                .addComponent(CanceljButton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(escureriaName))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pitGroupNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(escureriaName))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(pitGroupNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CanceljButton)
                    .addComponent(AplicarjButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AplicarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AplicarjButtonActionPerformed
        int option = 0;
        if (comparacion(piloto1, piloto1Num, pilot1)) {
            option = 1;
        }
        if (metodo == 2) {
            if (comparacion(piloto2, piloto2Num, pilot2)) {
                option = 1;
            }
        }
        if (option == 1) {
            if (metodo == 1) {
                pilot1.setName(piloto1.getText());
                pilot1.setNumber(Integer.parseInt(piloto1Num.getValue().toString()));
                pilot1.setPitgroup(pitGroupNumber.getText());
                escribirTeam(pilot1);
            } else {
                pilot1.setName(piloto1.getText());
                pilot1.setNumber(Integer.parseInt(piloto1Num.getValue().toString()));
                pilot1.setPitgroup(pitGroupNumber.getText());
                pilot2.setName(piloto2.getText());
                pilot2.setNumber(Integer.parseInt(piloto2Num.getValue().toString()));
                pilot2.setPitgroup(pitGroupNumber.getText());
                escribirTeam(pilot1);
                escribirTeam(pilot2);
                ImageIcon icon = new ImageIcon(getClass().getResource("Elementos/Imagenes/PitStopDoneIcon.png"));
                JOptionPane.showMessageDialog(null, "Equipo modificado Exitosamente", "Editar Equipo", JOptionPane.INFORMATION_MESSAGE, icon);
            }
            this.dispose();
        } else {
            ImageIcon icon = new ImageIcon(getClass().getResource("Elementos/Imagenes/PitStopErrorIcon.png"));
            JOptionPane.showMessageDialog(null, "El equipo no se ha modificado", "Editar Equipo", JOptionPane.ERROR_MESSAGE, icon);
        }
    }//GEN-LAST:event_AplicarjButtonActionPerformed

    private void CanceljButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CanceljButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_CanceljButtonActionPerformed

    private void piloto1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_piloto1MouseClicked
        piloto1.setEditable(true);
        piloto1Num.setEnabled(true);
        AplicarjButton.setEnabled(true);
    }//GEN-LAST:event_piloto1MouseClicked

    private void piloto2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_piloto2MouseClicked
        if (metodo == 2) {
            piloto2.setEditable(true);
            piloto2Num.setEnabled(true);
            AplicarjButton.setEnabled(true);
        }
    }//GEN-LAST:event_piloto2MouseClicked

    private void pitGroupNumberMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pitGroupNumberMouseClicked
        pitGroupNumber.setEditable(true);
        AplicarjButton.setEnabled(true);
    }//GEN-LAST:event_pitGroupNumberMouseClicked

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarEquipo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                EditarEquipo dialog = new EditarEquipo(new javax.swing.JFrame(), true, new Piloto(), new Piloto());
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
    private javax.swing.JButton AplicarjButton;
    private javax.swing.JButton CanceljButton;
    private javax.swing.JLabel escureriaName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField piloto1;
    private javax.swing.JSpinner piloto1Num;
    private javax.swing.JTextField piloto2;
    private javax.swing.JSpinner piloto2Num;
    private javax.swing.JTextField pitGroupNumber;
    // End of variables declaration//GEN-END:variables

    private void escribirTeam(Piloto pilot) {
        int lectura = 0;
        String cadenainicio = "";
        String cadenamedio = "";
        String cadenafinal = "";
        String nuevoarchivo = "";
        Scanner s;
        
        try {
            s = new Scanner(pilot.getFile());
            
            while (s.hasNext()) {
                String texto = s.nextLine();
                
                if (texto.contains("Number")) {
                    lectura = 1;
                } else {
                    if (lectura == 0) {
                        cadenainicio = cadenainicio.concat(texto + '\n');
                    }
                }
                
                if (texto.contains("Engine")) {
                    lectura = 2;
                }
                
                if (lectura == 2) {
                    cadenafinal = cadenafinal.concat(texto + '\n');
                }
            }
            
            s.close();
            
            cadenamedio = ("Number=" + pilot.getNumber() + '\n'
                    + "Team=" + "\"" + pilot.getTeam() + "\"" + '\n'
                    + "PitGroup=" + "\"" + pilot.getPitgroup() + "\"" + '\n'
                    + "Driver=" + "\"" + pilot.getName() + "\"" + '\n'
                    + "Description=" + "\"" + pilot.getNumber() + "-" + pilot.getName() + "\"" + '\n');
            
            nuevoarchivo = pilot.getFile().getPath();
            pilot.getFile().delete();
            Escribrlineas(cadenainicio, nuevoarchivo);
            Escribrlineas(cadenamedio, nuevoarchivo);
            Escribrlineas(cadenafinal, nuevoarchivo);
            
        } catch (Exception e) {
            ImageIcon icon = new ImageIcon(getClass().getResource("Elementos/Imagenes/PitStopErrorIcon.png"));
            JOptionPane.showMessageDialog(null, "Error Archivo no encontrado", "Editar Equipo - ERROR AL ESCRIBIR", JOptionPane.ERROR_MESSAGE, icon);
        }
    }

    private void Escribrlineas(String cadena, String nuevoarchivo) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(nuevoarchivo, true);
            pw = new PrintWriter(fichero);
            Scanner s = new Scanner(cadena);
            while (s.hasNextLine()) {
                pw.println(s.nextLine());
            }
            fichero.close();
        } catch (IOException ex) {
            Logger.getLogger(EditarEquipo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private boolean comparacion(JTextField piloto1, JSpinner piloto1Num, Piloto pilot1) {
        boolean bol = false;
        if (piloto1.getText().equalsIgnoreCase(pilot1.getName())) {
           
            if (Integer.parseInt(piloto1Num.getValue().toString()) == pilot1.getNumber()) {
                if (pitGroupNumber.getText().equalsIgnoreCase(pilot1.getPitgroup())) {
                } else {
                    bol = true;
                }
            } else {
                bol = true;
            }
            
        } else {
            bol = true;
        }
        return bol;
    }
}
