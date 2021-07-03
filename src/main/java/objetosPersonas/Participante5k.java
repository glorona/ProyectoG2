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
public class Participante5k extends Estudiante {
    private float tiempo;

    public Participante5k(float tiempo, String id, String nombre, char genero, String carrera) {
        super(id, nombre, genero, carrera);
        this.tiempo = tiempo;
    }
    
    public Participante5k(Estudiante e, float tiempo){
        super(e.getId(),e.getNombre(),e.getGenero(),e.getCarrera()); //String id, String nombre, char genero, String carrera
        this.tiempo = tiempo;
        
    }
    public Participante5k(){
        
    }

    public float getTiempo() {
        return tiempo;
    }

    public void setTiempo(float tiempo) {
        this.tiempo = tiempo;
    }
    
    
    
}
