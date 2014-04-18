/**
 * @author Carlos 
 * # Creado 11-mar-2013
 * #Creado metodo para modificar las pistar 21-ene-2013
 * #Finalizado privemra version 15-mar-2013
 */
package pitstopmaker201;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import pitstopmaker201.Elementos.Tools;
import pitstopmaker201.Elementos.Track;

public class TrackEditor extends javax.swing.JDialog {

    private List<Track> tracks;
    private String temporada;

    //<editor-fold defaultstate="collapsed" desc="Constructores">
    public TrackEditor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    TrackEditor(java.awt.Frame parent, List<Track> inTracks, String inTemporada) {
        super(parent, true);
        this.tracks = inTracks;
        this.temporada = inTemporada;
        initComponents();
        fillTrackInfo(tracks);
        fillComboPistas(tracks);
    }
    //</editor-fold>

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        buttonActualizar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        comboPistas = new javax.swing.JComboBox();
        buttonSalir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtbTrackName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        spinnerVueltas = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtbTemporada = new javax.swing.JTextField();
        chkbAllSame = new javax.swing.JCheckBox();
        txtbEvento = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtbGpName = new javax.swing.JTextField();
        spinnerHora = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        spinnerQualTime = new javax.swing.JSpinner();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PitStop Maker - Track Mannagement");
        setIconImage(null);

        jLabel1.setFont(new java.awt.Font("Britannic Bold", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Track Editor");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ObjectProperty.create(), jLabel1, org.jdesktop.beansbinding.BeanProperty.create("labelFor"));
        bindingGroup.addBinding(binding);

        buttonActualizar.setText("Actualizar");
        buttonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActualizarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Pista:");

        comboPistas.setToolTipText("Elige la pista que quiera editar.");
        comboPistas.setPreferredSize(new java.awt.Dimension(225, 25));
        comboPistas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboPistasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboPistas, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboPistas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        buttonSalir.setText("Salir");
        buttonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSalirActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Propiedades de la pista"));

        jLabel3.setText("Nombre del circuito:");

        txtbTrackName.setToolTipText("El nombre del circuito ej: Buddh I.C.");
        txtbTrackName.setPreferredSize(new java.awt.Dimension(170, 25));

        jLabel4.setText("Vueltas:");

        spinnerVueltas.setModel(new javax.swing.SpinnerNumberModel(1, 1, 500, 1));
        spinnerVueltas.setToolTipText("Minimo 1 Maximo 500");
        spinnerVueltas.setPreferredSize(new java.awt.Dimension(55, 28));

        jLabel5.setText("<HTML><p>Hora</p><p> Inicio:</p></HTML>");
        jLabel5.setToolTipText("");

        jLabel6.setText("Temporada:");

        txtbTemporada.setToolTipText("Temporada en la que aparecera la pista.");
        txtbTemporada.setPreferredSize(new java.awt.Dimension(170, 25));

        chkbAllSame.setSelected(true);
        chkbAllSame.setText("Aplicar a Todas");
        chkbAllSame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkbAllSameActionPerformed(evt);
            }
        });

        txtbEvento.setToolTipText("<HTML>\n<p>Posicion en el calendario y el nombre del pais</p>\n<p> o simplemente el nombre del pais</p>\n</HTML>");
        txtbEvento.setPreferredSize(new java.awt.Dimension(170, 25));

        jLabel7.setText("Titulo del evento:");

        jLabel8.setText("Nombre del GP:");

        txtbGpName.setToolTipText("El nombre del Gran premio ej: GRAND PRIX OF USA.");
        txtbGpName.setPreferredSize(new java.awt.Dimension(170, 25));

        SpinnerDateModel model = new SpinnerDateModel();
        model.setCalendarField(Calendar.HOUR_OF_DAY);
        spinnerHora.setModel(model);
        spinnerHora.setEditor(new JSpinner.DateEditor(spinnerHora,"HH:mm"));
        spinnerHora.setToolTipText("La hora en que inicia la carrera.");
        spinnerHora.setPreferredSize(new java.awt.Dimension(65, 28));

        jLabel9.setText("<HTML>Hora<p> clasificación:</p></HTML>");

        SpinnerDateModel modelq = new SpinnerDateModel();
        modelq.setCalendarField(Calendar.HOUR_OF_DAY);
        spinnerQualTime.setModel(modelq);
        spinnerQualTime.setEditor(new JSpinner.DateEditor(spinnerQualTime,"HH:mm"));
        spinnerQualTime.setToolTipText("La hora en que inicia la clasificación.");
        spinnerQualTime.setPreferredSize(new java.awt.Dimension(65, 28));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtbTemporada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(chkbAllSame)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtbTrackName, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                                .addComponent(txtbEvento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(txtbGpName, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spinnerVueltas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(spinnerHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(spinnerQualTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtbEvento, txtbGpName, txtbTrackName});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtbTrackName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtbEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(txtbGpName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinnerVueltas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinnerHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(spinnerQualTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(48, 48, 48)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtbTemporada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkbAllSame))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(76, 76, 76))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(buttonActualizar)
                        .addGap(55, 55, 55)
                        .addComponent(buttonSalir))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jLabel1)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {buttonActualizar, buttonSalir});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(25, 25, 25)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonActualizar)
                    .addComponent(buttonSalir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {buttonActualizar, buttonSalir});

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSalirActionPerformed
        // TODO add your handling code here: el boton salir cierra la ventana
        this.dispose();
    }//GEN-LAST:event_buttonSalirActionPerformed

    private void comboPistasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboPistasActionPerformed
        // TODO add your handling code here:Carga los datos de la pista seleccionada
        loadTrack(comboPistas.getSelectedIndex());
    }//GEN-LAST:event_comboPistasActionPerformed

    private void buttonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActualizarActionPerformed
        // TODO add your handling code here: guarda los cambios realizados
        saveAll(comboPistas.getSelectedIndex());
    }//GEN-LAST:event_buttonActualizarActionPerformed

    private void chkbAllSameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkbAllSameActionPerformed
        // TODO add your handling code here: muestra u oculta la temporada.
        txtbTemporada.setText(changeTemporadaValue(comboPistas.getSelectedIndex()));
    }//GEN-LAST:event_chkbAllSameActionPerformed

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
            java.util.logging.Logger.getLogger(TrackEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                TrackEditor dialog = new TrackEditor(new javax.swing.JFrame(), true);
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
    //<editor-fold defaultstate="collapsed" desc="Declaracion de variables">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonActualizar;
    private javax.swing.JButton buttonSalir;
    private javax.swing.JCheckBox chkbAllSame;
    private javax.swing.JComboBox comboPistas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JSpinner spinnerHora;
    private javax.swing.JSpinner spinnerQualTime;
    private javax.swing.JSpinner spinnerVueltas;
    private javax.swing.JTextField txtbEvento;
    private javax.swing.JTextField txtbGpName;
    private javax.swing.JTextField txtbTemporada;
    private javax.swing.JTextField txtbTrackName;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodos Private">
    private void fillComboPistas(List<Track> inTracks) {
        //llena el comboBox @comboPistas con los nombres de las pistas en @inTracks.
        comboPistas.removeAllItems();
        for (Track pista : inTracks) {
            comboPistas.addItem(pista.getName());
        }
    }

    private void fillTrackInfo(List<Track> inTracks) {
        //selecciona una pistas de la lista @inTracks y la envia al metodo que
        //lee el archivo .gdb respectivo
        Iterator<Track> iterator = inTracks.iterator();
        while (iterator.hasNext()) {
            gdbReader(iterator.next());
        }
    }

    private void gdbReader(Track track) {
        //crea un arreglo con los valores a leer en el archivo .gdb y utiliza el
        //metodo readFile de la clase Tools y pasa los valores l metodo que llena la pista
        File archivo = new File(track.getFileLocation());

        String[] values = {"RaceLaps",
            "TrackName",
            "GrandPrixName",
            "EventName",
            "RaceStart",
            "QualifyStart",
            "VenueName"};

        String[] paramValues = Tools.readFile(values, archivo);

        if (!paramValues[0].contains("noFile")) {
            fillTrack(paramValues, track);
        } else {
            JOptionPane.showMessageDialog(null, "Los siguientes archivos contienen defectos y no se mostraran:" + '\n' + archivo.getName(), "PitStop Maker - Track Editor ", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void fillTrack(String[] values, Track track) {
        //el metodo recibe los valores de las propiedades de las pista y la pista
        //luego almacena los valores en la pista guarda el header y el foot de la misma.
        for (String texto : values) {
            String[] value = texto.split("=");

            switch (value[0].trim()) {
                case ("TrackName"):
                    track.setName(value[1].trim());
                    break;
                case ("GrandPrixName"):
                    track.setGpName(value[1].trim());
                    break;
                case ("EventName"):
                    track.setEvent(value[1].trim());
                    break;
                case ("VenueName"):
                    track.setSeason(value[1].trim());
                    break;
                case ("RaceStart"):
                    track.setTime(value[1].trim());
                    break;
                case ("QualifyStart"):
                    track.setQualTime(value[1].trim());
                    break;
                case ("RaceLaps"):
                    track.setLaps(value[1].trim());
                    break;
            }
        }

        track.setHeader(values[values.length - 2]);
        track.setFoot(values[values.length - 1]);
    }

    private void loadTrack(int index) {
        //carga los datos de la pista seleccionada @index es el indicie seleccionado
        //en el comboBox @comboPistas.
        Track pista = tracks.get(index);

        String gpName = cleanString(pista.getGpName());
        String eName = cleanString(pista.getEvent());
        String strTemporada = changeTemporadaValue(index);

        Date gpTime = stringToDate(pista.getTime());
        Date qTime = stringToDate(pista.getQualTime());

        txtbTrackName.setText(pista.getName());
        txtbEvento.setText(eName);
        txtbGpName.setText(gpName);
        spinnerVueltas.setValue(Integer.parseInt(pista.getLaps()));
        spinnerHora.setValue(gpTime);
        spinnerQualTime.setValue(qTime);
        txtbTemporada.setText(strTemporada);
    }

    private String cleanString(String cadena) {
        //elimina los comentarios de la cadena que recibe si no tiene comentarios
        //la regresa tal cual. Los comentarios estan identificados por "//".
        String[] cadenaSplit = cadena.split("//");

        if (cadenaSplit.length > 0) {
            String cleanedStr = cadenaSplit[0].trim();
            return cleanedStr;
        } else {
            return cadena;
        }
    }

    private String changeTemporadaValue(int index) {
        //cambia la cadena por el valor creado de la temporada o aplica el valor
        //que trae la pista por defecto.
        String strTemporada = null;
        Track pista = tracks.get(index);

        if (chkbAllSame.isSelected()) {
            strTemporada = temporada + " SEASON";
        } else {
            strTemporada = cleanString(pista.getSeason());
        }
        return strTemporada.toUpperCase();
    }

    private Date stringToDate(String time) {
        //cambia el valot de la cadena @time en formato de fecha.
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date date = new Date();

        try {
            date = dateFormat.parse(time);

        } catch (ParseException ex) {
            Logger.getLogger(TrackEditor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return date;
    }

    private void saveAll(int index) {
        //guarda todos los cambios realizados en el archivo .gdb utilizando el metodo
        //writeFile de la clase Tools.
        Track pista = tracks.get(index);

        String time = dateToString(spinnerHora.getValue());
        String qTime = dateToString(spinnerQualTime.getValue());

        pista.setName(txtbTrackName.getText());
        pista.setGpName(txtbGpName.getText());
        pista.setEvent(txtbEvento.getText());
        pista.setSeason(txtbTemporada.getText());
        pista.setTime(time);
        pista.setQualTime(qTime);
        pista.setLaps(spinnerVueltas.getValue().toString());
        pista.setBody(pista.makeBody());

        String[] saveValues = {pista.getHeader(), pista.getBody(), pista.getFoot()};
        boolean canWrite = Tools.writeFile(saveValues, pista.getFileLocation());

        if (canWrite) {
            ImageIcon icon = new ImageIcon(getClass().getResource("Elementos/Imagenes/PitStopDoneIcon.png"));
            JOptionPane.showMessageDialog(null, "Cambios Guardados Exitosamente", "PitStop Maker - Track Editor", JOptionPane.INFORMATION_MESSAGE, icon);
        } else {
            ImageIcon icon = new ImageIcon(getClass().getResource("Elementos/Imagenes/PitStopErrorIcon.png"));
            JOptionPane.showMessageDialog(null, "Error al Escribir", "PitStop Maker - Track Editor", JOptionPane.ERROR, icon);
        }
    }

    private String dateToString(Object date) {
        //cambia el formatod de @date a una cadena.
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        String time = null;

        time = dateFormat.format(date);

        return time;
    }
    //</editor-fold>
}
