package pitstopmaker201.Elementos;

import java.io.File;
import javax.swing.JOptionPane;
import pitstopmaker201.Elementos.Tools.Filtro;

/**
 *
 * @author Carlos
 */

public class Track {
    //<editor-fold defaultstate="collapsed" desc="Propiedades">

    private String name;
    private String gpName;
    private String event;
    private String season;
    private String time;
    private String laps;
    private String qualTime;
    private String header;
    private String body;
    private String foot;
    private String fileLocation;
    private String gdbName;
    protected boolean filled;
    //</editor-fold>

    public Track() {
        name = null;
        event = null;
        laps = null;
        season = null;
        gpName = null;
        qualTime = null;
        header = null;
        body = null;
        time = null;
        fileLocation = null;
        gdbName = null;
        filled = false;
    }

    //<editor-fold defaultstate="collapsed" desc="Setters">
    private void setFilled(boolean inBool) {
        this.filled = inBool;
    }
    public void setName(String inName) {
        this.name = inName;
    }
    public void setEvent(String inEvent) {
        this.event = inEvent;
    }
    public void setLaps(String inLaps) {
        this.laps = inLaps;
    }
    public void setSeason(String inSeason) {
        this.season = inSeason;
    }
    public void setHeader(String inHeader) {
        this.header = inHeader;
    }
    public void setBody(String inBody) {
        this.body = inBody;
    }
    public void setFoot(String foot) {
        this.foot = foot;
    }
    public void setTime(String inTime) {
        this.time = inTime;
    }
    public void setFileLocation(String inLocation) {
        this.fileLocation = inLocation;
    }
    public void setGdbName(String inGdbName) {
        this.gdbName = inGdbName;
    }
    public void setGpName(String gpName) {
        this.gpName = gpName;
    }
    public void setQualTime(String qualTime) {
        this.qualTime = qualTime;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters">
    public String getName() {
        return name;
    }
    public String getEvent() {
        return event;
    }
    public String getLaps() {
        return laps;
    }
    public String getTime() {
        return time;
    }
    public String getSeason() {
        return season;
    }
    public String getFileLocation() {
        return fileLocation;
    }
    public String getGdbName() {
        return gdbName;
    }
    public String getHeader() {
        return header;
    }
    public String getGpName() {
        return gpName;
    }
    public String getQualTime() {
        return qualTime;
    }
    public String getBody() {
        return body;
    }
    public String getFoot() {
        return foot;
    }
    public boolean isFilled() {
        return filled;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodos de la clase">
    public static String findFile(String inLocation, String archivo) {
        String route = Tools.findSingleFile(inLocation, new Filtro(), archivo);

        return route;
    }

    public void fill(File gdbFile) {
        int countNoFile = 0;
        String fileNofoundName = "";
        String gdbFileName = gdbFile.getName();
        String[] fields = {"RaceLaps", "TrackName", "GrandPrixName", "VenueName"};

        gdbName = gdbFileName.substring(0, gdbFileName.length() - 4);
        String[] trackPropertiesValues = Tools.readFile(fields, gdbFile);

        if (!trackPropertiesValues[0].contains("noFile")) {
            splitAndFill(trackPropertiesValues);
        } else {
            countNoFile++;
            fileNofoundName = fileNofoundName.concat(gdbFile.getName().toString() + '\n');
        }

        if (countNoFile > 0) {
            JOptionPane.showMessageDialog(null, "Los siguientes archivos contienen defectos y no se mostraran:" + '\n' + fileNofoundName, "Calendar Editor - ERROR AL LEER ", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void splitAndFill(String[] trackPropertiesValues) {

        int valuesRead = 0;

        for (String propertyValue : trackPropertiesValues) {
            String[] trackValue = propertyValue.split("=");

            switch (trackValue[0].trim()) {
                case ("RaceLaps"):
                    this.laps = trackValue[1].trim();
                    valuesRead++;
                    break;
                case ("TrackName"):
                    this.name = trackValue[1].trim();
                    valuesRead++;
                    break;
                case ("GrandPrixName"):
                    this.setGpName(trackValue[1].trim());
                    valuesRead++;
                    break;
                case ("VenueName"):
                    this.season = trackValue[1].trim();
                    valuesRead++;
                    break;
            }

            if (valuesRead == 4) {
                this.setHeader(trackPropertiesValues[valuesRead]);
                this.body = trackPropertiesValues[valuesRead + 1];
                this.setFilled(true);
            }
        }
    }

    public String makeBody() {
        StringBuilder bodyStr = new StringBuilder();

        bodyStr.append("  TrackName = ").append(name).append('\r').append('\n').append("  GrandPrixName = ").append(gpName).append('\r').append('\n').append("  EventName =  ").append(event).append('\r').append('\n').append("  VenueName = ").append(season).append('\r').append('\n').append("  QualifyStart = ").append(qualTime).append('\r').append('\n').append("  RaceStart = ").append(time).append('\r').append('\n').append("  RaceLaps = ").append(laps).append('\r').append('\n');

        return bodyStr.toString();
    }

    @Override
    public String toString() {
        return this.name;
    }
    //</editor-fold>
}
