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
enum rolBanda{
        CANTANTE,GUITARRISTA,BAJISTA,BATERISTA,OTRO;
    }
public class IntegranteBanda extends Estudiante {
    private rolBanda rol;

    public IntegranteBanda(rolBanda rol, String id, String nombre, String carrera, String genero) {
        super(id, nombre, carrera, genero);
        this.rol = rol;
    }

    public rolBanda getRol() {
        return rol;
    }

    public void setRol(rolBanda rol) {
        this.rol = rol;
    }
    
    
}
