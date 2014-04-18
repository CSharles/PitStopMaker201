package pitstopmaker201.Elementos;

import java.io.File;

/**
 *
 * @author Carlos
 */
public class Piloto implements Comparable {
    //<editor-fold defaultstate="collapsed" desc="Propiedades">
    private File archivo; //alamcena las ruta del archivo del piloto
    private String team; // almacena los nombres de las temporadas
    private Integer number; // almacena el numero de del piloto
    private String driver; // almacena el nombre del piloto
    private String pitgroup; // almacena el grupo de pits
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructores">
    public Piloto() {
        archivo = null;
        team = "nombredelequipo";
        number = 0;
        driver = "piloto";
        pitgroup = "pitpos";
    }

    public Piloto(File archivo, String team, int number, String driver, String pitgroup) {
        this.archivo = archivo;
        this.team = team;
        this.number = number;
        this.driver = driver;
        this.pitgroup = pitgroup;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Setters">
    public void setFile(File archivo) {
        this.archivo = archivo;
    }
    public void setTeam(String team) {
        this.team = team;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public void setName(String driver) {
        this.driver = driver;
    }
    public void setPitgroup(String pitgroup) {
        this.pitgroup = pitgroup;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters">
    public File getFile() {
        return archivo;
    }
    public String getTeam() {
        return team;
    }
    public int getNumber() {
        return number;
    }
    public String getName() {
        return driver;
    }
    public String getPitgroup() {
        return pitgroup;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodos">
    @Override
    public int compareTo(Object obj) {
        Piloto piloto = (Piloto) obj;
        
        if (this.number.compareTo(piloto.number) == -1) {
            return this.number.compareTo(piloto.number);
        } else {
            return this.number.compareTo(piloto.number);
        }
    }

    @Override
    public String toString() {
        return driver;
    }
    //</editor-fold>
}
