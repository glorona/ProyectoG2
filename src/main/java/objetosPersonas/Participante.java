package objetosPersonas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gabri
 */
public class Participante {
    protected String id; //atributos 
    protected String nombre;
    
    //GETTERS
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
    
    //SETTERS
    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    //Constructor para agregar los atributos de participante y super() para los atributos heredados
    public Participante(String id, String nombre) {
        super();
        this.id = id;
        this.nombre = nombre;
    }
    
    
    public Participante(){ //se define constructor vacio para usar metodos de la clase
        
    }
    
    
    
}
