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

    public Participante5k(float tiempo, String id, String nombre, String carrera, String genero) {
        super(id, nombre, carrera, genero);
        this.tiempo = tiempo;
    }

    public float getTiempo() {
        return tiempo;
    }

    public void setTiempo(float tiempo) {
        this.tiempo = tiempo;
    }
    
    
    
}
