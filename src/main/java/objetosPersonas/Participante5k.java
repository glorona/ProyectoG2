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
public class Participante5k extends Estudiante { //se define la clase participante5k que hereda de estudiante
    private float tiempo; //se define el tiempo como campo local

    public Participante5k(float tiempo, String id, String nombre, char genero, String carrera) { //se define constructor
        super(id, nombre, genero, carrera); //se llama al constructor padre (Estudiante)
        this.tiempo = tiempo; //se construye el campo local tiempo como parte de constructor
    }
    
    public Participante5k(Estudiante e, float tiempo){ //otro constructor con objeto ya creado de estudiante
        super(e.getId(),e.getNombre(),e.getGenero(),e.getCarrera()); //String id, String nombre, char genero, String carrera
        this.tiempo = tiempo; //construccion tiempo
        
    }
    public Participante5k(){ //se define constructor vacio para usar metodos de participante
        
    }

    public float getTiempo() { //getter y setter
        return tiempo;
    }

    public void setTiempo(float tiempo) {
        this.tiempo = tiempo;
    }
    
    
    
}
