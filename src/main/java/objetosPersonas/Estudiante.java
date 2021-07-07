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
public class Estudiante extends Participante {
    protected String carrera;
    protected char genero;

    public Estudiante(String id, String nombre, char genero, String carrera ) {
        super(id, nombre);
        this.carrera = carrera;
        this.genero = genero;
        
    }
    
    public Estudiante(){ //se define constructor vacio para usar metodos de la clase
        
    }
    
    
    //GETTERS
    public String getCarrera() {
        return carrera;
    }

    public char getGenero() {
        return genero;
    }
    
    //SETTERS
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }
    
    //metodo toString para mostrar los datos del estudiante
    @Override
    public String toString() {
        return "Estudiante{" + "id=" + id + ", nombre=" + nombre + '}';
    }
    
    
    
}
