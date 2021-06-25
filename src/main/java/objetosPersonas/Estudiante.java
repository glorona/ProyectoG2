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
    protected String genero;

    public Estudiante(String id, String nombre, String carrera, String genero) {
        super(id, nombre);
        this.carrera = carrera;
        this.genero = genero;
        
    }

    public String getCarrera() {
        return carrera;
    }

    public String getGenero() {
        return genero;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    
    
}