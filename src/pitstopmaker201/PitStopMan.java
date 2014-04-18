/*
 * PitStopMan.java
 *
 * Created on 11-dic-2011, 9:50:05
 #Nueva capacidad para crear pitstops para una sola pista. 03-ene-2013
 #Merjardo el metodo de paradas aleatoreas. 14-ene-2013
 #Mejorado el algoritmo de creación de pitstop 22-feb-2013
 # Simplificado el metodo de creacion de archivos 4-mar-2013
 #Finalizada ver 4 4-mar-2013 
 * @author Carlos
 */

package pitstopmaker201;

import java.io.*;
import java.util.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import pitstopmaker201.Elementos.Tools;

public class PitStopMan extends javax.swing.JDialog {
    ArrayList escenes;
    String ruta;
    String lista;

    public PitStopMan(java.awt.Frame parent, boolean modal, ArrayList es, String r, String l) {
        super(parent, modal);
        initComponents();
        this.escenes = es;
        this.ruta = r;
        this.lista = l;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        opcionesRb = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        aleatorioRb = new javax.swing.JRadioButton();
        especificoRb = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        paradasJSlider = new javax.swing.JSlider();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        opcionesRb.add(aleatorioRb);
        opcionesRb.add(especificoRb);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PitStop Maker - Crear Pit Stops");

        jLabel1.setFont(new java.awt.Font("Britannic Bold", 0, 24)); // NOI18N
        jLabel1.setText("Crear Pits Stop");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Estrategia"));

        aleatorioRb.setText("Aleatorio");

        especificoRb.setSelected(true);
        especificoRb.setText("Especifico");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Numero de paradas"));

        paradasJSlider.setMaximum(3);
        paradasJSlider.setMinimum(1);
        paradasJSlider.setValue(2);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, especificoRb, org.jdesktop.beansbinding.ELProperty.create("${selected==true}"), paradasJSlider, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jLabel2.setText(" 1");

        jLabel3.setText("2");

        jLabel4.setText(" 3");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(paradasJSlider, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(paradasJSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(aleatorioRb)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(especificoRb))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(especificoRb)
                    .addComponent(aleatorioRb))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jButton1.setText("Aplicar");
        jButton1.setMaximumSize(new java.awt.Dimension(75, 23));
        jButton1.setMinimumSize(new java.awt.Dimension(75, 23));
        jButton1.setPreferredSize(new java.awt.Dimension(75, 23));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jLabel1)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton2});

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//verifica si hay mas de una pista.
// se recuperan todos los archivos .gdb y solo escribe los que estan en escenes.               
        int escritura = 0;
        if (escenes.size() > 1) {
            List<String> gdbList = Tools.findFile(ruta, new Tools.Filtro());
            Iterator iter = escenes.iterator();
            while (iter.hasNext()) {
                String archivo = iter.next().toString();
                for (String gdbFile : gdbList) {
                    if (gdbFile.contains(archivo)) {
                        escritura = editGdb(gdbFile);
                    }
                }
            }
        } else {
            String gdbFile = Tools.findSingleFile(ruta, new Tools.Filtro(), escenes.get(0).toString());
            escritura = editGdb(gdbFile);
        }
        if (escritura > 0) {
            ImageIcon icon = new ImageIcon(getClass().getResource("Elementos/Imagenes/PitStopDoneIcon.png"));
            JOptionPane.showMessageDialog(null, "Se crearon los pitstops para " + escritura + " pistas", "Pits Stop MAN - Escritura exitosa", JOptionPane.INFORMATION_MESSAGE, icon);
            this.dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PitStopMan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                PitStopMan dialog = new PitStopMan(new javax.swing.JFrame(), true, new ArrayList(), new String(), new String());
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
    private javax.swing.JRadioButton aleatorioRb;
    private javax.swing.JRadioButton especificoRb;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.ButtonGroup opcionesRb;
    private javax.swing.JSlider paradasJSlider;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    private int editGdb(String gdbFile) {
        int escritura = 0;
        try {
            File gdb = new File(gdbFile);
            escritura = escritura + editarGdb(gdb);
        } catch (Exception ex) {
            ImageIcon icon = new ImageIcon(getClass().getResource("Elementos/Imagenes/PitStopErrorIcon.png"));
            String msg = '\n' + ex.toString() + " En: \n " + gdbFile;
            JOptionPane.showMessageDialog(null, "Error: " + msg, "Pits Stop MAN", JOptionPane.ERROR_MESSAGE, icon);
        } finally {
            return escritura;
        }
    }

    private int editarGdb(File archivo) {
//tokeniza el archivo,crea la lista de pitStops y graba el nuevo archivo. 
        int escritura = 0;
        String[] delimitadores = {"PitStopStrategies", "}"};
        String[] cadenas = Tools.readFile(2, delimitadores, archivo);
        if (!cadenas[0].contains("noFile")) {
            int laps = findLaps(cadenas[0]);
            StringBuilder cadenamedio = new StringBuilder();
            cadenamedio.append("  PitStopStrategies").append('\r').append('\n').append("  {").append('\r').append(crearLista(laps, lista));
            String nuevoarchivo = archivo.getPath();
            boolean delete = archivo.delete();
            boolean writeFile = false;
            if (delete) {
                String[] values = {cadenas[0], cadenamedio.toString(), "  " + cadenas[1]};
                writeFile = Tools.writeFile(values, nuevoarchivo);
            }
            if (writeFile) {
                escritura = 1;
            }
        } else {
            escritura = -1;
        }
        return escritura;
    }

    private int findLaps(String cadenainicio) {
        int laps = 0;
        Scanner s = new Scanner(cadenainicio);
        s.useDelimiter("RaceLaps");
        while (s.hasNext()) {
            s.next();
            String linea = s.nextLine();
            String[] values = linea.split("=");
            laps = Integer.parseInt(values[1].trim());
            break;
        }
        return laps;
    }

    private String crearLista(int laps, String lista) {
        int pasada = 0;
        StringBuilder newlista = new StringBuilder();
        Scanner s = new Scanner(lista);
        s.useDelimiter("\\n");
        if (aleatorioRb.isSelected()) {
            //<editor-fold defaultstate="collapsed" desc="CREAR LOS PITSTOPS ALEATORIOS">
            int noMoreOnePitStopCtrl = 0;

            while (s.hasNext()) {
                Random r = new Random();
                int stops = r.nextInt(3) + 1;
                //La variable noMoreOnePitStopCtrl controla el numero maximo de pilotos que paran una vez.
                if (noMoreOnePitStopCtrl < 5 && stops == 1) {
                    noMoreOnePitStopCtrl++;
                } else {
                    while (stops < 2) {
                        stops = r.nextInt(3) + 1;
                    }
                }
                int[] pitstopLap = new int[stops];
                //Se rellena el array  pitstopLap con las vueltas en que parará el piloto.
                for (int i = 0; i < stops; i++) {
                    pitstopLap[i] = ((laps / (stops + 1)) * (i + 1));
                }
                String driverName = s.next();
                newlista.append(makeListString(driverName, pitstopLap, stops, pasada));
                if (pasada < 2) {
                    pasada++;
                } else {
                    pasada = 0;
                }

            }
            //</editor-fold>
        } else {
            //<editor-fold defaultstate="collapsed" desc="CREAR LOS PITSTOPS ESTATICOS">
            int stops = paradasJSlider.getValue();
            int[] pitstopLap = new int[stops];
            //Se rellena el array  pitstopLap con las vueltas en que parará el piloto.
            for (int i = 0; i < stops; i++) {
                pitstopLap[i] = ((laps / (stops + 1)) * (i + 1));
            }
            while (s.hasNext()) {
                String driverName = s.next();
                newlista.append(makeListString(driverName, pitstopLap, stops, pasada));
                if (pasada < 2) {
                    pasada++;
                } else {
                    pasada = 0;
                }
            }
        }
        //</editor-fold>
        return newlista.toString();
    }

    private String makeListString(String driverName, int[] pitstopLap, int stops, int pase) {
        StringBuilder pitString = new StringBuilder();
        int adLap = 0;
        //evaluamos la variable pase si esta no es 1 o 2 adLap vale 0.  
        adLap = pase == 1 ? 1 : pase == 2 ? -1 : 0;
        switch (stops) {
            case (1):
                pitString = pitString.append('\n').append("    ").append(driverName).append(" = ").append(stops).append(" - ").append(pitstopLap[0] + adLap).append('\r');
                break;
            case (2):
                pitString = pitString.append('\n').append("    ").append(driverName).append(" = ").append(stops).append(" - ").append(pitstopLap[0] + adLap).append(",").append(pitstopLap[1] - adLap).append('\r');
                break;
            case (3):
                pitString = pitString.append('\n').append("    ").append(driverName).append(" = ").append(stops).append(" - ").append(pitstopLap[0] + adLap).append(",").append(pitstopLap[1] - adLap).append(",").append(pitstopLap[2] + adLap).append('\r');
        }
        return pitString.toString();
    }
}
