package pitstopmaker201.Elementos;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import pitstopmaker201.Elementos.Tools.Filtro;

/**
 * @author Carlos
 */
public class RfTemporada {
    //<editor-fold defaultstate="collapsed" desc="Propiedades">

    private String vehDir; // almacena el numero de mods dentro de un archivo
    private String driverDir;
    private String trackFilter; // almacena los nombres de las temporadas
    private String vehFilter;
    private DefaultListModel sceneOrder;// los nombres de las pistas segun el archivo rfm
    private List<String> fullTrackList;

    //</editor-fold>
    public RfTemporada() {
        trackFilter = "pista";
        vehDir = "";
        driverDir = "pilotos";
        vehFilter = "vehiculos";
        sceneOrder = new DefaultListModel();
        fullTrackList = new ArrayList();
    }

    //<editor-fold defaultstate="collapsed" desc="Setters">
    public void setVehiclesDir(String vehDir) {
        this.vehDir = vehDir;
    }
    public void setDriversDir(String driverDir) {
        this.driverDir = driverDir;
    }
    public void setTracksFilter(String trackFilter) {
        this.trackFilter = trackFilter;
    }
    public void setVehFilter(String vehFilter) {
        this.vehFilter = vehFilter;
    }
    public void setFullTrackList(List<String> fullTrackList) {
        this.fullTrackList = fullTrackList;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters">
    public String getVehDir() {
        return vehDir;
    }
    public String getDriverDir() {
        return driverDir;
    }
    public List<String> getFullTrackList() {
        return fullTrackList;
    }
    public DefaultListModel getScenes() {
        return sceneOrder;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodos de la clase">
    public void addScene(String scene) {
        if (!scene.isEmpty()) {
            this.sceneOrder.addElement(scene);
            this.fullTrackList.add(scene);
        }
    }

    public static List<String> findGdb(String inLocation) {
        List<String> allGdbList = Tools.findFile(inLocation, new Filtro());
        return allGdbList;
    }
//    </editor-fold>
}
