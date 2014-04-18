/**
 * @author Carlos #creado 22-ene-2013 agregada las configuracion de boton salir
 * y agregadas propiedades de la clase 23-ene-2013 #agregado el metodo
 * buscarPistas 24-ene-2013 #agregado el metodo de creacion de listas para
 * pistas y calendario 03-feb-2013 #agregado la funcionalidad de los botones
 * agregar, restar y limpiar 12-feb-2013 #completada la funcion de Drag and Drop
 * para ordenar lista de calendario 16-feb-2013 # pruebas de creacion de archivo
 * 08-mar-2013 #Lanzada la version 1.0 10-mar-2013
 */

package pitstopmaker201;

import java.io.File;
import java.util.*;
import javax.swing.*;
import pitstopmaker201.Elementos.Tools;
import pitstopmaker201.Elementos.Tools.JlistTransferHandler;
import pitstopmaker201.Elementos.Track;

public class CalendarEditor extends javax.swing.JDialog {
    //<editor-fold defaultstate="collapsed" desc="Propiedades">
    private DefaultListModel allTracksListModel;
    private DefaultListModel calendarTracksListModel;
    private List<Track> allTracks;
    private List<Track> calendarTracks;
    private List<String> gdbList;
    private List<String> calendarGdbList;
    private String rutaCategoria;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructores">
    public CalendarEditor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    CalendarEditor(java.awt.Frame parent, List<String> inGdbList, List<String> inCalendarList, String ruta) {
        super(parent, true);
        this.gdbList = inGdbList;
        this.calendarGdbList = inCalendarList;
        this.allTracks = crearTrackList(gdbList);
        this.calendarTracks = crearTrackList(calendarGdbList);
        this.allTracksListModel = fillListModels(allTracks);
        this.calendarTracksListModel = fillListModels(calendarTracks);
        this.rutaCategoria = ruta;
        initComponents();
        updatePanelTitles();
    }
    //</editor-fold>
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        aplyButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        addTrackButton = new javax.swing.JButton();
        substracTrackButton = new javax.swing.JButton();
        limpiarButton = new javax.swing.JButton();
        jPanelTracks = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        allTracksjList = new javax.swing.JList();
        jPanelCalendar = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        calendarjList = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PitStop Maker - Calendar Editor");

        jLabel1.setFont(new java.awt.Font("Britannic Bold", 0, 24)); // NOI18N
        jLabel1.setText("Editor de Calendario");

        aplyButton.setText("Aplicar");
        aplyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aplyButtonActionPerformed(evt);
            }
        });

        closeButton.setText("Salir");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        addTrackButton.setText(">>");
        addTrackButton.setToolTipText("Agrega la pista seleccionada.");
        addTrackButton.setPreferredSize(new java.awt.Dimension(67, 23));
        addTrackButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addTrackButtonMouseClicked(evt);
            }
        });

        substracTrackButton.setText("<<");
        substracTrackButton.setToolTipText("Remueve la pista seleccionada.");
        substracTrackButton.setPreferredSize(new java.awt.Dimension(67, 23));
        substracTrackButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                substracTrackButtonMouseClicked(evt);
            }
        });

        limpiarButton.setText("Limpiar");
        limpiarButton.setToolTipText("Deja  el calendario en blanco.");
        limpiarButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                limpiarButtonMouseClicked(evt);
            }
        });

        jPanelTracks.setBorder(javax.swing.BorderFactory.createTitledBorder("Disponibles"));
        jPanelTracks.setPreferredSize(new java.awt.Dimension(241, 259));

        allTracksjList.setModel(allTracksListModel);
        allTracksjList.setToolTipText("<HTML>\n<p><b>Las pistas disponibles.</b></p>\n<p>Son el resto de pistas instaladas</p>\n<p>elija una para agregarla al calendario.</p>\n</HTML>");
        allTracksjList.setSelectedIndex(0);
        jScrollPane1.setViewportView(allTracksjList);

        javax.swing.GroupLayout jPanelTracksLayout = new javax.swing.GroupLayout(jPanelTracks);
        jPanelTracks.setLayout(jPanelTracksLayout);
        jPanelTracksLayout.setHorizontalGroup(
            jPanelTracksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTracksLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelTracksLayout.setVerticalGroup(
            jPanelTracksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTracksLayout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        jPanelCalendar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Calendario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, java.awt.Color.black));

        calendarjList.setModel(calendarTracksListModel);
        calendarjList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        calendarjList.setToolTipText("<HTML>\n<p><b>Las pistas del calendario actual</b></p>\n<p>puede arrastrar para ordenar.</p>\n</HTML>");
        calendarjList.setDragEnabled(true);
        calendarjList.setDropMode(javax.swing.DropMode.INSERT);
        calendarjList.setTransferHandler(new JlistTransferHandler());
        jScrollPane2.setViewportView(calendarjList);

        javax.swing.GroupLayout jPanelCalendarLayout = new javax.swing.GroupLayout(jPanelCalendar);
        jPanelCalendar.setLayout(jPanelCalendarLayout);
        jPanelCalendarLayout.setHorizontalGroup(
            jPanelCalendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCalendarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelCalendarLayout.setVerticalGroup(
            jPanelCalendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCalendarLayout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelTracks, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(substracTrackButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(limpiarButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addTrackButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {addTrackButton, limpiarButton, substracTrackButton});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanelTracks, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                            .addComponent(jPanelCalendar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(addTrackButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(substracTrackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(limpiarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 151, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {addTrackButton, limpiarButton, substracTrackButton});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addComponent(aplyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 210, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(192, 192, 192)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {aplyButton, closeButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(closeButton)
                    .addComponent(aplyButton))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {aplyButton, closeButton});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_closeButtonActionPerformed

    private void aplyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aplyButtonActionPerformed
        // TODO add your handling code here: Genera el nuevo SceneOrder en el archivo rfm.
        orderTrackList();
        createNewrfmFile();
        this.dispose();
    }//GEN-LAST:event_aplyButtonActionPerformed

    private void substracTrackButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_substracTrackButtonMouseClicked
        // TODO add your handling code here: Resta una pista del calendario.
        //Habilita o deshabilita el boton substract(<<)si el calendario esta vacio.
        if (substracTrackButton.isEnabled()) {
            changeTracks(calendarjList, calendarTracks, allTracks, calendarTracksListModel, allTracksListModel);
            checkButtonState(calendarTracksListModel, substracTrackButton, addTrackButton);
            
            if (calendarTracksListModel.isEmpty()) {
                limpiarButton.setEnabled(false);
                aplyButton.setEnabled(false);
            }
        }
    }//GEN-LAST:event_substracTrackButtonMouseClicked

    private void addTrackButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addTrackButtonMouseClicked
        // TODO add your handling code here: Agrega una pista al calendario.
        //Deshablilita el boton Add(>>) si la lista de pistas esta vacia.
        if (addTrackButton.isEnabled()) {
            changeTracks(allTracksjList, allTracks, calendarTracks, allTracksListModel, calendarTracksListModel);
            checkButtonState(allTracksListModel, addTrackButton, substracTrackButton);
            
            if (!limpiarButton.isEnabled()) {
                limpiarButton.setEnabled(true);
                aplyButton.setEnabled(true);
            }
        }
    }//GEN-LAST:event_addTrackButtonMouseClicked

    private void limpiarButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_limpiarButtonMouseClicked
        // TODO add your handling code here: El boton Limpiar deja en Blanco el Calendario.
        if (!calendarTracks.isEmpty() && limpiarButton.isEnabled()) {
            boolean canAdd = allTracks.addAll(calendarTracks);
            
            if (canAdd) {
                calendarTracksListModel.clear();
                calendarTracks.clear();
                allTracksListModel = fillListModels(allTracks);
                allTracksjList.setModel(allTracksListModel);
                allTracksjList.setSelectedIndex(0);
                addTrackButton.setEnabled(true);
                substracTrackButton.setEnabled(false);
                limpiarButton.setEnabled(false);
                aplyButton.setEnabled(false);
                updatePanelTitles();
            }
        }
    }//GEN-LAST:event_limpiarButtonMouseClicked

    public static void main(String args[]) {

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
            java.util.logging.Logger.getLogger(CalendarEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                CalendarEditor dialog = new CalendarEditor(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton addTrackButton;
    private javax.swing.JList allTracksjList;
    private javax.swing.JButton aplyButton;
    private javax.swing.JList calendarjList;
    private javax.swing.JButton closeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelCalendar;
    private javax.swing.JPanel jPanelTracks;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton limpiarButton;
    private javax.swing.JButton substracTrackButton;
    // End of variables declaration//GEN-END:variables

    //<editor-fold defaultstate="collapsed" desc="Metodos Private">
    private void changeTracks(JList jListSource, List<Track> trackSource, List<Track> trackTarget, DefaultListModel listSource, DefaultListModel listTarget) {
        //Intercambia las pistas entre las listas de pistas  mantenidendo
        //la posicion de la seleccion y actualiza los titulos de las mismas.
        int indexSelected = jListSource.getSelectedIndex();
        trackTarget.add(0, trackSource.get(indexSelected));
        trackSource.remove(indexSelected);
        listTarget.add(0, listSource.remove(indexSelected));
        
        if (indexSelected == jListSource.getMaxSelectionIndex() || indexSelected - 1 > -1) {
            jListSource.setSelectedIndex(indexSelected - 1);
        } else {
            jListSource.setSelectedIndex(indexSelected);
        }
        updatePanelTitles();
    }
    
    private void checkButtonState(DefaultListModel listModel, JButton botonAdd, JButton botonRemove) {
        //Habilita o deshabilita el boton ADD o Remove
        if (listModel.isEmpty()) {
            botonAdd.setEnabled(false);
            botonRemove.setEnabled(true);
        } else if (!botonRemove.isEnabled()) {
            botonRemove.setEnabled(true);
        }
    }
    
    private List<Track> crearTrackList(List<String> inGdbList) {
        List<Track> innerTrackList = new LinkedList();
        
        for (String archivoGdb : inGdbList) {
            Track pista = fillTrack(archivoGdb);
            
            if (pista.isFilled()) {
                innerTrackList.add(pista);
            }
        }
        return innerTrackList;
    }
    
    private Track fillTrack(String inArchivoGdb) {
        File gdbFile = new File(inArchivoGdb);
        Track pista = new Track();
        pista.fill(gdbFile);
        return pista;
    }
    
    private DefaultListModel fillListModels(List<Track> inListTracks) {
        DefaultListModel innerModel = new DefaultListModel();
        for (Track pista : inListTracks) {
            innerModel.addElement(pista);
        }
        return innerModel;
    }
    
    private void createNewrfmFile() {
        String rfmRoute = rutaCategoria;
        File rfmFile = new File(rfmRoute);
        String listData = composeGdbList();
        String[] sceneOrderDelimeter = {"SceneOrder", "\\}"};
        String[] rfmFileFields = Tools.readFile(2, sceneOrderDelimeter, rfmFile);
        
        rfmFileFields[1] = "  ".concat(rfmFileFields[1]);
        String[] frmData = createFileString(listData, rfmFileFields);
        boolean canwriteFile = Tools.writeFile(frmData, rfmRoute);
        
        if (!canwriteFile) {
            ImageIcon icon = new ImageIcon(getClass().getResource("Elementos/Imagenes/PitStopErrorIcon.png"));
            JOptionPane.showMessageDialog(null, "Error al escribir." + '\n' + "El archivo no se encotró", "PitsStop Maker 2.7.1 - ERROR", JOptionPane.ERROR_MESSAGE, icon);
        } else {
            ImageIcon icon = new ImageIcon(getClass().getResource("Elementos/Imagenes/PitStopDoneIcon.png"));
            JOptionPane.showMessageDialog(null, "Se ha creado el nuevo calendario exitosamente", "PitsStop Maker 2.7.1 - Editor de Calendario", JOptionPane.ERROR_MESSAGE, icon);
        }
    }
    
    private String composeGdbList() {
        //Contruye una lista de SceneOrder con los nuevos nombres
        StringBuilder sceneOrder = new StringBuilder();
        sceneOrder.append("SceneOrder").append('\r').append('\n').append("{").append('\r');
        
        for (Iterator<Track> it = calendarTracks.iterator(); it.hasNext();) {
            Track pista = it.next();
            String gdbName = pista.getGdbName();
            sceneOrder.append('\n').append("  ").append(gdbName).append('\r');
        }
        return sceneOrder.toString();
    }
    
    private String[] createFileString(String listData, String[] rfmFileFields) {
        //Crea el arreglo con los datos que se escribiran en el archivo .frm
        String[] data = new String[rfmFileFields.length + 2];
        int index = 0;
        
        for (String string : rfmFileFields) {
            if (index == 1) {
                data[index] = scanString(listData);
                index++;
            }
            if (index == 3) {
                data[index] = listData;
                index++;
            }
            if (index == 0 || index == 2 || index == 4) {
                data[index] = string;
                index++;
            }
        }
        return data;
    }
    
    private void orderTrackList() {
        for (int i = 0; i < calendarTracksListModel.getSize(); i++) {
            String pistaname = calendarTracksListModel.get(i).toString();
            
            for (Iterator<Track> it = calendarTracks.iterator(); it.hasNext();) {
                Track pista = it.next();
                
                if (pista.toString().contains(pistaname)) {
                    boolean remove = calendarTracks.remove(pista);
                    
                    if (remove) {
                        calendarTracks.add(i, pista);
                    }
                    break;
                }
            }
        }
    }
    
    private String scanString(String listData) {
        StringBuilder cadenafinal = new StringBuilder();
        Scanner innerScan = new Scanner(listData);
        boolean firstPass = true;
        
        while (innerScan.hasNext()) {
            
            if (firstPass) {
                cadenafinal.append("  ").append(innerScan.nextLine()).append('\r');
                firstPass = false;
            } else {
                cadenafinal.append('\n').append("  ").append(innerScan.nextLine()).append('\r');
            }
        }
        return cadenafinal.toString();
    }
    
    private void updatePanelTitles() {
        jPanelCalendar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Calendario (" + calendarjList.getModel().getSize() + ")"));
        jPanelTracks.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Disponibles (" + allTracksjList.getModel().getSize() + ")"));
    }
    //</editor-fold>
}
