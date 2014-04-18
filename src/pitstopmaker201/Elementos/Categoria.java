package pitstopmaker201.Elementos;

/**
 *
 * @author Carlos
 */

public class Categoria {
    private String nombre;
    private String ruta;
    
    public void Categoria(){
        nombre= "";
        ruta= "";
    }
    
    public void setName(String nombre){
        this.nombre=nombre;
    }
    
    public void setRuta(String ruta){
        this.ruta=ruta;
    }
    
    public String getName(){
        return nombre;
    }
    
    public String getRuta(){
        return ruta;
    }
    
}
