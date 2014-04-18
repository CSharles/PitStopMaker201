package pitstopmaker201.Elementos;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.*;

/**
 *
 * @author Carlos
 */
public class Tools {

    public static List<String> findFile(String inFilepath, Filtro isFiltro) {
        List<String> fileFound = new ArrayList();
        File directorioInicial = new File(inFilepath);
        File[] gdbArray = directorioInicial.listFiles(isFiltro);
        
        for (File archivo : gdbArray) {
            
            if (archivo.isDirectory()) {
                fileFound.addAll(findFile(archivo.getAbsolutePath().toString(), isFiltro));
            } else {
                fileFound.add(archivo.getAbsolutePath().toString());
            }
        }
        return fileFound;
    }

    public static String findSingleFile(String inFilepath, Filtro isFiltro, String file) {
        File fileFound = null;
        List<String> gdbList = findFile(inFilepath, isFiltro);
        
        for (String gdbFile : gdbList) {
            
            if (gdbFile.contains(file)) {
                fileFound = new File(gdbFile);
                break;
            }
        }
        return fileFound.getPath();
    }

    private static String compareFields(String texto, String[] fields) {
        String fieldFound = "null";
        for (String field : fields) {
            if (texto.contains(field)) {
                String linea = texto;
                fieldFound = linea;
            }
        }
        return fieldFound;
    }

    public static String[] readFile(String[] fields, File inFile) {
        String[] fieldsRead = new String[fields.length];
        String field = "";
        StringBuilder head = new StringBuilder();
        StringBuilder body = new StringBuilder();
        int lectura = 0;
        int fieldIndex = 0;
        boolean fileRead = false;
       
        try (Scanner texto = new Scanner(inFile)) {
           
            while (texto.hasNext()) {
                String linea = texto.nextLine();
                fileRead = true;
                field = compareFields(linea, fields);
               
                if (!field.contains("null") && fieldIndex < fields.length) {
                    fieldsRead[fieldIndex] = field;
                    fieldIndex++;
                    lectura = 1;
                } else if (lectura != 1 || fieldIndex < fields.length) {
                    head.append(linea).append('\r').append('\n');
                } else if (fieldIndex == fields.length) {
                    body.append(linea).append('\r').append('\n');
                }
            }
           
            if (!fileRead) {
                fieldsRead[0] = "noFile";
                texto.close();
            } else {
                fieldsRead = Arrays.copyOf(fieldsRead, fieldIndex + 2);//agrega 2 nuevos espacios al arreglo.
                fieldsRead[fieldIndex] = head.toString();
                fieldIndex++;
                fieldsRead[fieldIndex] = body.toString();
                texto.close();
            }
        } catch (Exception e) {
            fieldsRead[0] = "noFile";
        } finally {
            return fieldsRead;
        }
    }

    public static String[] readFile(int index, String[] delimiters, File inFile) {
        String[] atributesRead = new String[index + 1];
        try (Scanner texto = new Scanner(inFile)) {
            int lectura = 0;
            int fieldIndex = 0;
            boolean fileRead = false;
            while (texto.hasNext()) {
                texto.useDelimiter(delimiters[0]);
                String linea = texto.next();
                if (lectura != 1) {
                    String head = linea;
                    texto.useDelimiter(delimiters[1]);
                    String dump = texto.next();
                    atributesRead[fieldIndex] = head;
                    fieldIndex++;
                    lectura = 1;
                } else if (fieldIndex == 1) {
                    String body = linea;
                    atributesRead[fieldIndex] = body;
                    texto.useDelimiter(delimiters[1]);
                    if (texto.hasNext()) {
                        fieldIndex++;
                        String dump = texto.next();
                    } else {
                        fileRead = true;
                    }

                } else if (fieldIndex == index) {
                    String foot = linea;
                    atributesRead[fieldIndex] = foot;
                    fileRead = true;
                }
            }
            if (!fileRead) {
                atributesRead[0] = "noFile";
                texto.close();
            }
        } catch (Exception e) {
            atributesRead[0] = "noFile".concat(e.toString());
            atributesRead[1] = inFile.getName().toString();
        } finally {
            return atributesRead;
        }
    }

    public static boolean writeFile(String[] values, String archivo) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        
        try {
            boolean isDeleted = deleteFile(archivo);
            
            if (isDeleted) {
                fichero = new FileWriter(archivo, false);
                pw = new PrintWriter(fichero);
                for (String cadena : values) {
                    pw.println(cadena);
                }
                fichero.close();
                return true;
            }
            return false;
        } catch (IOException ex) {
            return false;
        }
    }

    private static boolean deleteFile(String archivo) {
        File f = new File(archivo);
        if (f.exists()) {
            f.delete();
            return true;
        } else {
            return true;
        }
    }

    //<editor-fold defaultstate="collapsed" desc="Static Class Filtro">
    public static class Filtro implements FileFilter {

        private String extencion = "gdb";

        public void setFilterAs(String newExtencion) {
            this.extencion = newExtencion;
        }

        @Override
        public boolean accept(File pathname) {
            if (pathname.isDirectory()) {
                return true;
            }
            String nombrearchivo = pathname.getName().toLowerCase();
            if (nombrearchivo.endsWith(extencion)) {
                return true;
            }
            return false;
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Static Class JlistTrasferHandler">
    public static class JlistTransferHandler extends TransferHandler {

        private int indiceInicial = 0;
        private int indiceFinal = 0;

        @Override
        public boolean canImport(TransferHandler.TransferSupport transferInfo) {
            if (!transferInfo.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                return false;
            }
            JList.DropLocation dropLocation = (JList.DropLocation) transferInfo.getDropLocation();
            if (dropLocation.getIndex() == -1) {
                return false;
            }
            return true;
        }

        @Override
        public boolean importData(TransferHandler.TransferSupport dataInfo) {
            if (!dataInfo.isDrop()) {
                return false;
            }
            if (!dataInfo.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                return false;
            }
            JList list = (JList) dataInfo.getComponent();
            DefaultListModel listModel = (DefaultListModel) list.getModel();
            JList.DropLocation dropLocation = (JList.DropLocation) dataInfo.getDropLocation();
            int index = dropLocation.getIndex();
            indiceFinal = index;
            boolean insert = dropLocation.isInsert();
            Transferable transfer = dataInfo.getTransferable();
            String datos;
            try {
                datos = (String) transfer.getTransferData(DataFlavor.stringFlavor);
            } catch (UnsupportedFlavorException | IOException e) {
                return false;
            }
            if (insert) {
                listModel.add(index, datos);
            } else {
                listModel.set(index, datos);
            }
            return true;
        }

        @Override
        public int getSourceActions(JComponent c) {
            return TransferHandler.MOVE;
        }

        @Override
        protected Transferable createTransferable(JComponent c) {
            JList list = (JList) c;
            indiceInicial = list.getSelectedIndex();
            Object valor = list.getSelectedValue();
            StringBuilder buff = new StringBuilder();
            buff.append(valor == null ? "" : valor.toString());
            return new StringSelection(buff.toString());
        }

        @Override
        protected void exportDone(JComponent c, Transferable data, int action) {
            JList source = (JList) c;
            DefaultListModel listModel = (DefaultListModel) source.getModel();
            if (indiceInicial > indiceFinal) {
                listModel.remove(indiceInicial + 1);
            } else {
                listModel.remove(indiceInicial);
            }
            indiceInicial = 0;
        }
    }
    //</editor-fold>
}
