/*
 * PitStopMaker.java
 *
 * Created on 07-dic-2011, 15:03:42
 * @author Carlos
 #Nueva capacidad para crear pitstops para una sola pista. 03-ene-2013
 #Merjardo el metodo de paradas aleatoreas. 14-ene-2013
 #creado editor de calendario  22-ene-2013
 #agregado  el metodo buscarPistas 24-ene-2013
 #agregado el metodo de creacion de listas para pistas y calendario 03-feb-2013
 #agregado el metodo de creacion de lista escenario, y JDialog CalendarEditor en pruebas 04-feb-2013
 */
package pitstopmaker201;

import pitstopmaker201.Elementos.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class PitStopMaker extends javax.swing.JFrame {
    //<editor-fold defaultstate="collapsed" desc="Propiedades">

    private LinkedList<Categoria> categorias;
    private String ruta;
    private RfTemporada temporadas;
    private List<Piloto> pilotos;
    private DefaultListModel listadrivers;
    private DefaultListModel listateams;
    private List<Track> tracksList;
    private String rutaCategoriaActual;
    private String temporadaActual;

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Constructor">
    public PitStopMaker() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("Elementos/Imagenes/PitStopIcon.png")).getImage());
        this.categorias = new LinkedList<>();
        this.temporadas = new RfTemporada();
        this.pilotos = new ArrayList();
        this.listadrivers = new DefaultListModel();
        this.listateams = new DefaultListModel();
        this.tracksList = new ArrayList();
        this.rutaCategoriaActual = null;
    }
    //</editor-fold>

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        temporadaList = new javax.swing.JComboBox();
        cargarTemporadajButton = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pilotosList = new javax.swing.JList();
        editarPilotos = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        teamList = new javax.swing.JList();
        editarEquipo = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        pistasList = new javax.swing.JList();
        jPanel5 = new javax.swing.JPanel();
        editarPistas = new javax.swing.JButton();
        editarCalendario = new javax.swing.JButton();
        editarPitstop = new javax.swing.JButton();
        allTracksCheckBox = new javax.swing.JCheckBox();
        crearPitstops = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        EditarRfactorMenuItem = new javax.swing.JMenuItem();
        salirMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PitStop Maker 2.7.1");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Temporada:");

        temporadaList.setToolTipText(gettoolTip());
        temporadaList.setEnabled(false);
        temporadaList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                temporadaListMouseEntered(evt);
            }
        });

        cargarTemporadajButton.setText("Cargar Temporada");
        cargarTemporadajButton.setEnabled(false);
        cargarTemporadajButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarTemporadajButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(temporadaList, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cargarTemporadajButton)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(temporadaList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cargarTemporadajButton))
                .addGap(41, 41, 41))
        );

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setEnabled(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Pilotos"));

        pilotosList.setToolTipText("Muestra una lista con los nombres de los pilotos.");
        jScrollPane1.setViewportView(pilotosList);

        editarPilotos.setText("Editar");
        editarPilotos.setToolTipText("En proximas versiones.");
        editarPilotos.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(editarPilotos)
                .addGap(53, 53, 53))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(editarPilotos)
                        .addGap(0, 226, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Lista dePilotos", jPanel2);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Equipos"));

        teamList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        teamList.setToolTipText("Muestra los Equipos Disponibles");
        teamList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                teamListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(teamList);

        editarEquipo.setText("Editar");
        editarEquipo.setToolTipText("Permite editar el equipo seleccionado.");
        editarEquipo.setEnabled(false);
        editarEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarEquipoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(editarEquipo)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(editarEquipo))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Lista de Equipos", jPanel3);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Pistas"));

        pistasList.setToolTipText("Muestra las pistas de esta temporada");
        jScrollPane3.setViewportView(pistasList);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Editar"));

        editarPistas.setText("Pista Info.");
        editarPistas.setToolTipText("<HTML>\nPermite modificar los datos de la pista\n<p> ej: el nombre, la hora, etc.</p>\n</HTML>");
        editarPistas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarPistasActionPerformed(evt);
            }
        });

        editarCalendario.setText("Calendario");
        editarCalendario.setToolTipText("Permite personalizar el calendario de la temporada.");
        editarCalendario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarCalendarioActionPerformed(evt);
            }
        });

        editarPitstop.setText("PitStops");
        editarPitstop.setToolTipText("<HTML>\n<p>Muestra el cuadro de dialogo para crear los pistops</p>\n<p> de las pstas seleccionadas.</p>\n</HTML>\n");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, allTracksCheckBox, org.jdesktop.beansbinding.ELProperty.create("${selected==false}"), editarPitstop, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        editarPitstop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarPitstopActionPerformed(evt);
            }
        });

        allTracksCheckBox.setSelected(true);
        allTracksCheckBox.setText("Todas las pistas");
        allTracksCheckBox.setToolTipText("Selecciona Todas las pistas de la lista.");
        allTracksCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allTracksCheckBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(editarPistas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editarCalendario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editarPitstop, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(allTracksCheckBox)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {editarCalendario, editarPistas});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(allTracksCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(editarPistas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editarCalendario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editarPitstop)
                .addGap(79, 79, 79))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {editarCalendario, editarPistas});

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 55, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Lista de Pistas", jPanel4);

        crearPitstops.setText("Crear Pistops");
        crearPitstops.setToolTipText("<HTML>\n<p>Abre PitStop Manager para crear pitStops de forma </p>\n<p>aleatoria o especifica para todas las pista de la lista. </p>\n</HTML>");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, allTracksCheckBox, org.jdesktop.beansbinding.ELProperty.create("${selected==true}"), crearPitstops, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        crearPitstops.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearPitstopsActionPerformed(evt);
            }
        });

        jMenu1.setText("Editar");
        jMenu1.setToolTipText("Todo empieza aqui.");

        EditarRfactorMenuItem.setText("Rfactor Seasons");
        EditarRfactorMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarRfactorMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(EditarRfactorMenuItem);

        salirMenuItem.setText("Salir");
        salirMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(salirMenuItem);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addComponent(crearPitstops))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(crearPitstops)
                .addGap(21, 21, 21))
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Lista de Pilotos");

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //<editor-fold defaultstate="collapsed" desc="Botones y elementos graficos">    
    private void EditarRfactorMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarRfactorMenuItemActionPerformed
        // Codigo para el menu rFactor
        JFileChooser ubicacion = new JFileChooser();
        ubicacion.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int seleccion = ubicacion.showOpenDialog(null);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivo = ubicacion.getSelectedFile();
            ruta = archivo.getAbsolutePath();

            if (archivo.getName().contains("rFactor")) {
                buscarDirectorio(ruta + "\\rFm\\", crearRegex("*.rfm"), false, true);
                temporadaList.removeAllItems();

                for (int i = 0; i < categorias.size(); i++) {
                    temporadaList.addItem(categorias.get(i).getName());
                }

                temporadaList.setEnabled(true);
                cargarTemporadajButton.setEnabled(true);
            } else {
                ImageIcon icon = new ImageIcon(getClass().getResource("Elementos/Imagenes/PitStopErrorIcon.png"));
                JOptionPane.showMessageDialog(null, "La ruta especificada no es valida." + '\n' + "Seleccione la ruta del directorio rFactor", "PitsStop Maker 2.7.0 - ERROR", JOptionPane.ERROR_MESSAGE, icon);
            }
        }
    }//GEN-LAST:event_EditarRfactorMenuItemActionPerformed

    private void cargarTemporadajButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarTemporadajButtonActionPerformed
        // Carga la temporada que se ha seleccionado.
        int tempIndex = temporadaList.getSelectedIndex();// se obtiene el indice en cual se encuentra la temporada
        rutaCategoriaActual = categorias.get(tempIndex).getRuta();
        temporadaActual = categorias.get(tempIndex).getName();

        listadrivers.removeAllElements();
        listateams.removeAllElements();
        pilotos.clear();
        pistasList.removeAll();
        temporadas.getScenes().clear();

        temporadas.setFullTrackList(new ArrayList());
        leerArchivoRfm(categorias.get(tempIndex).getRuta());
        buscarDirectorio(ruta.concat("\\" + temporadas.getVehDir()), crearRegex("*.veh"), true, false);

        teamList.setModel(listateams); // aplicar el Listmodel de equipos
        pilotosList.setModel(listadrivers); //aplicar el ListModel de pilotos
        pistasList.setModel(temporadas.getScenes());

        for (int i = 0; i < pilotos.size(); i++) {
            if (!listateams.contains(pilotos.get(i).getTeam())) {
                listateams.addElement(pilotos.get(i).getTeam());
            }
        }

        for (int i = 0; i < pilotos.size(); i++) {
            if (pilotos.get(i).getNumber() < 10) {
                listadrivers.addElement("0" + pilotos.get(i).getNumber() + " - " + pilotos.get(i).getName());
            } else {
                listadrivers.addElement(pilotos.get(i).getNumber() + " - " + pilotos.get(i).getName());
            }
        }

        jTabbedPane1.setEnabled(true);
        checkState();
    }//GEN-LAST:event_cargarTemporadajButtonActionPerformed

    private void editarEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarEquipoActionPerformed
        int count = 0;
        int index = 0;
        int index2 = -1;
        JDialog editEquipo;
        String nTeam = teamList.getSelectedValue().toString();

        for (int i = 0; i < pilotos.size(); i++) {
            if (pilotos.get(i).getTeam().equals(nTeam)) {
                count++;
                if (count == 1) {
                    index = i;
                }
                if (count == 2) {
                    index2 = i;
                }
            }
        }

        if (index2 == -1) {
            editEquipo = new EditarEquipo(this, true, pilotos.get(index));
        } else {
            editEquipo = new EditarEquipo(this, true, pilotos.get(index), pilotos.get(index2));
        }

        editEquipo.setLocationRelativeTo(this);
        editEquipo.setVisible(true);
    }//GEN-LAST:event_editarEquipoActionPerformed

    private void salirMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirMenuItemActionPerformed
        this.dispose();
    }//GEN-LAST:event_salirMenuItemActionPerformed

    private void teamListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_teamListMouseClicked
        editarEquipo.setEnabled(true);
    }//GEN-LAST:event_teamListMouseClicked

    private void crearPitstopsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearPitstopsActionPerformed
        crearPitStops();
    }//GEN-LAST:event_crearPitstopsActionPerformed

    private void editarPistasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarPistasActionPerformed
        //Crea lista en @trackList que contiene las pistas que solo contienen
        // los archivos .gdblu luego muestra el cuadro de dialogo trackEditor.
        
        trackListGenerator(pistasList.getSelectedValuesList().toArray());
        
        if (tracksList.isEmpty()) {
            String message ="Las pistas dentro del archivo .rfm no existen o no estan instaladas,"+'\n' + "edite el calendario primero.";
            JOptionPane.showMessageDialog(this, message,"PitsStop Maker 2.7.0 - ALERTA",JOptionPane.INFORMATION_MESSAGE); 
            }
        
        else{
            JDialog trackEditor = new TrackEditor(this, tracksList, temporadaActual);
            trackEditor.setLocationRelativeTo(this);
            trackEditor.setVisible(true);
        
        }
    }//GEN-LAST:event_editarPistasActionPerformed

    private void editarPitstopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarPitstopActionPerformed
        crearPitStops();
    }//GEN-LAST:event_editarPitstopActionPerformed

    private void editarCalendarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarCalendarioActionPerformed
        List<String> fullGdbList = RfTemporada.findGdb(ruta + "\\GameData\\Locations");
        List<String> esceneOrderList = splitList(fullGdbList);
        fullGdbList.removeAll(esceneOrderList);

        if (esceneOrderList.isEmpty()) {
            String message ="Las pistas dentro del archivo .rfm no existen o no estan instaladas,"+'\n' + "la lista de calendario se mostrará vacia.";
           JOptionPane.showMessageDialog(this, message,"PitsStop Maker 2.7.0 - ALERTA",JOptionPane.INFORMATION_MESSAGE); 
        } 
        JDialog editCalendar;
        editCalendar = new CalendarEditor(this, fullGdbList, esceneOrderList, rutaCategoriaActual);
        editCalendar.setLocationRelativeTo(this);
        editCalendar.setVisible(true);
        
    }//GEN-LAST:event_editarCalendarioActionPerformed

    private void allTracksCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allTracksCheckBoxActionPerformed
        //TODO add your handling code here: llama eal metodo que comprueba el estado de allTracksCheckBox
        checkState();
    }//GEN-LAST:event_allTracksCheckBoxActionPerformed

    private void temporadaListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_temporadaListMouseEntered
        // TODO add your handling code here: cambia el toolTip
        temporadaList.setToolTipText(gettoolTip());
    }//GEN-LAST:event_temporadaListMouseEntered
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodos de la clase">
    private void trackListGenerator(Object[] inpista) {
        //Recibe un arreglo y crea una lista de pistas vacias y su archivo .gdb
        tracksList.clear();
        String location = ruta + "\\GameData\\Locations";
        for (Object pista : inpista) {
            String fileMask = pista.toString();
            String fileLocation = Track.findFile(location, fileMask);
            if(fileLocation!=null) {
                Track track = new Track();
                track.setFileLocation(fileLocation);
                tracksList.add(track);
            }
        }
    }

    private void crearPitStops() {
        //Se crea una lista con los nombres de los pilotos, luego se crea una
        //lista con los nombres de las pistas y se envian al cuadro de dialogo
        //de PitStop Mannager.
        String locationsdir = ruta + "\\GameData\\Locations";
        ArrayList esena = new ArrayList();
        String listPilots = "";

        Iterator iter = pilotos.iterator();
        while (iter.hasNext()) {
            String p = iter.next().toString();
            listPilots = listPilots.concat(p + '\n');
        }

        if (pistasList.isEnabled()) {
            for (int indicePista : pistasList.getSelectedIndices()) {
                esena.add(temporadas.getScenes().get(indicePista));
            }
        } else {
            for (int i = 0; i < temporadas.getScenes().size(); i++) {
                esena.add(temporadas.getScenes().get(i));
            }
        }

        JDialog psm = new PitStopMan(this, true, esena, locationsdir, listPilots);
        psm.setLocationRelativeTo(this);
        psm.setVisible(true);
    }

    private List<String> splitList(List<String> inGdbList) {
        //separa de la lista @inGdbList las pistas del calendario que se 
        //obtienen de @temporadas, regresa una lista con los archvos.gdb del
        //calendario.
        List<String> innerScenes = temporadas.getFullTrackList();
        List<String> innerGdbList = new ArrayList();
        for (String gdb : inGdbList) {
            for (String escene : innerScenes) {
                if (!escene.isEmpty()) {
                    if (gdb.endsWith(escene + ".gdb")) {
                        innerGdbList.add(gdb);
                    }
                }
            }
        }
        return innerGdbList;
    }

    public static String crearRegex(String mascara) {
        mascara = mascara.replace(".", "\\.");
        mascara = mascara.replace("*", ".*");
        mascara = mascara.replace("?", ".");
        return mascara;
    }

    public void buscarDirectorio(String rutainicio, String mascara, boolean buscar, boolean pase) {
        File directorioroot = new File(rutainicio);
        File[] directorio = directorioroot.listFiles();
        for (int i = 0; i < directorio.length; i++) {
            if (directorio[i].isDirectory() && buscar == true) {
                buscarDirectorio(directorio[i].getAbsolutePath(), mascara, buscar, pase);
            } else {
                if (Pattern.matches(mascara, directorio[i].getName())) {
                    if (pase == true && buscar == false) {
                        leerArchivoRfm(directorio[i].getAbsoluteFile());
                    }
                    if (pase == false) {
                        leerArchivoTeam(directorio[i].getAbsoluteFile());
                    }
                }
            }
        }
    }

    public void leerArchivoRfm(String rutaarch) {
        int lectura = 0; //variable para evitar comprobaciones innecesarias en el switch.
        File f = new File(rutaarch);
        try {
            Scanner s;
            s = new Scanner(f);
            while (s.hasNextLine()) {
                String linea = s.nextLine();
                switch (lectura)//<editor-fold defaultstate="collapsed" desc="lectura de archivo">
                {
                    case 0:
                        if (linea.startsWith("Track Filter =")) {
                            String[] lineaf = linea.split("="); // se busca el filtro para la pista y deja solo el filtro.
                            if (lineaf.length == 2) {
                                temporadas.setTracksFilter(lineaf[1].trim());// filtro de pistas guardado
                                lectura++;
                            }
                        }
                        break;
                    case 1:
                        if (linea.trim().startsWith("VehiclesDir") || linea.trim().startsWith("//VehiclesDir")) {
                            String[] lineaf = linea.split("="); // se busca el filtro para la pista y deja solo el filtro.
                            if (lineaf.length == 2) {
                                temporadas.setVehiclesDir(lineaf[1].trim());// ruta de vehiculos guardado
                                lectura++;
                            }
                        }
                        break;
                    case 2:
                        if (linea.trim().contains("DriversDir") || linea.trim().startsWith("//DriversDir")) {
                            String[] lineaf = linea.split("="); // se busca el filtro para la pista y deja solo el filtro.
                            if (lineaf.length == 2) {
                                temporadas.setDriversDir(lineaf[1].trim());// ruta de vehiculos guardado
                                lectura++;
                            }
                        }
                        break;
                    case 3:
                        if (linea.trim().startsWith("Vehicle Filter")) {
                            String[] lineaf = linea.split("="); // se deja solo el filtro
                            if (lineaf[1].trim().contains("|")) {
                                linea = lineaf[1].substring(1);
                                temporadas.setVehFilter(lineaf[1].trim()); // filtro guardado
                            } else {
                                temporadas.setVehFilter(lineaf[1].trim());
                            } // filtro guardado
                            lectura++;
                        }
                        break;
                    case 4:
                        if (linea.trim().startsWith("SceneOrder")) {
                            lectura++;
                            s.nextLine();
                        }
                        break;
                    case 5:
                        while (!"}".equals(linea.trim())) {
                            temporadas.addScene(linea.trim());
                            break;
                        }
                        if ("}".equals(linea.trim())) {
                            lectura++;
                        }
                        break;
                    default:
                        break;
                }
                //</editor-fold>
            }
            s.close();
        } catch (FileNotFoundException e) {
            ImageIcon icon = new ImageIcon(getClass().getResource("Elementos/Imagenes/PitStopErrorIcon.png"));
            JOptionPane.showMessageDialog(this, "Error Archivo no encontrado", "PitStop Maker 2.7.0 - Error", JOptionPane.ERROR_MESSAGE, icon);
        }
    }

    public void leerArchivoRfm(File f) {
        try {
            Scanner s;
            s = new Scanner(f);
            while (s.hasNextLine()) {
                String linea = s.nextLine();
                if (linea.trim().startsWith("FullSeasonName")) {
                    Categoria cat = new Categoria();
                    cat.setRuta(f.toString());
                    String[] lineaf = linea.split("=");
                    if (lineaf.length == 2) {
                        cat.setName(lineaf[1].trim());
                        categorias.add(cat);
                    }
                }
            }
            s.close();
        } catch (FileNotFoundException e) {
            ImageIcon icon = new ImageIcon(getClass().getResource("Elementos/Imagenes/PitStopErrorIcon.png"));
            JOptionPane.showMessageDialog(null, "Error Archivo no encontrado", "PitStop Maker 2.7.0 - Error", JOptionPane.ERROR_MESSAGE, icon);
        }
    }

    public void leerArchivoTeam(File archivo) {
        int lectura = 0;
        Piloto p = new Piloto();
        File f = archivo.getAbsoluteFile();
        try {
            Scanner s;
            s = new Scanner(f);
            while (s.hasNextLine()) {
                String linea = s.nextLine(); // Lee el archivo para leer datos del piloto
                switch (lectura)//<editor-fold defaultstate="collapsed" desc="Lectura del archvio">
                {
                    case 0:
                        if (linea.startsWith("Number")) {
                            String[] lineaf = linea.split("=");
                            if (lineaf.length == 2) {
                                int i = Integer.parseInt(lineaf[1].trim());
                                p.setNumber(i);
                                if (p.getNumber() == 0) {
                                    lectura = -1;
                                } else {
                                    lectura++;
                                }
                            }
                        }
                        break;
                    case 1:
                        if (linea.startsWith("Team")) {
                            String[] lineaf = linea.split("=");
                            if (lineaf.length == 2) {
                                p.setTeam(lineaf[1].trim().replaceAll("\"", ""));// nobre de equipo
                                lectura++;
                            }
                        }
                        break;
                    case 2:
                        if (linea.startsWith("PitGroup")) {
                            String[] lineaf = linea.split("=");
                            if (lineaf.length == 2) {
                                p.setPitgroup(lineaf[1].trim().replaceAll("\"", ""));// numero del pitorder
                                lectura++;
                            }
                        }
                        break;
                    case 3:
                        if (linea.startsWith("Driver")) {
                            String[] lineaf = linea.split("=");
                            if (lineaf.length == 2) {
                                p.setName(lineaf[1].trim().replaceAll("\"", ""));// nombre del piloto.
                                lectura++;
                            }
                        }
                        break;
                    default:
                        break;
                }
                //</editor-fold>
            }
            s.close();
            if (lectura != -1 && lectura != 0) {
                p.setFile(f.getAbsoluteFile());
                pilotos.add(p);
                Collections.sort(pilotos);
            }
        } catch (FileNotFoundException e) {
            ImageIcon icon = new ImageIcon(getClass().getResource("Elementos/Imagenes/PitStopErrorIcon.png"));
            JOptionPane.showMessageDialog(null, "Error Archivo no encontrado", "PitStop Maker 2.7.0 - Error", JOptionPane.ERROR_MESSAGE, icon);
        }
    }
    //</editor-fold>

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
            java.util.logging.Logger.getLogger(PitStopMaker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new PitStopMaker().setVisible(true);
            }
        });
    }
    //<editor-fold defaultstate="collapsed" desc="Varieable declaration">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem EditarRfactorMenuItem;
    private javax.swing.JCheckBox allTracksCheckBox;
    private javax.swing.JButton cargarTemporadajButton;
    private javax.swing.JButton crearPitstops;
    private javax.swing.JButton editarCalendario;
    private javax.swing.JButton editarEquipo;
    private javax.swing.JButton editarPilotos;
    private javax.swing.JButton editarPistas;
    private javax.swing.JButton editarPitstop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JList pilotosList;
    private javax.swing.JList pistasList;
    private javax.swing.JMenuItem salirMenuItem;
    private javax.swing.JList teamList;
    private javax.swing.JComboBox temporadaList;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
//</editor-fold>   

    private void checkState() {
        //Si @allTracksCheckBox esta seleccionado todos los elementos de @pistasList 
        // son seleccionados y esta es deshablilidata, de lo contrario la lista 
        //de pistas queda libre para poder elegir cualquier elemento.
         if (allTracksCheckBox.isSelected()) {
             int minIndex=0;
             int maxIndex =pistasList.getModel().getSize()-1;
                          
            pistasList.setSelectionInterval(minIndex, maxIndex);
            pistasList.setEnabled(false);
            
        } else {
            pistasList.setEnabled(true);
            pistasList.setSelectedIndex(0);
        }
    }

    private String gettoolTip() {
        String toolTip= "<HTML><p><b>Selecciona una temporada.</b></p></HTML>";
        
        if(temporadaList.getModel().getSize()>0){
            int tempIndex = temporadaList.getSelectedIndex();// se obtiene el indice en cual se encuentra la temporada
            rutaCategoriaActual = categorias.get(tempIndex).getRuta();
            toolTip = categorias.get(tempIndex).getName();            
        }
        
        return toolTip;
    }
}
