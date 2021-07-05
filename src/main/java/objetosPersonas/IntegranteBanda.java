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

public class IntegranteBanda extends Estudiante {
    private RolBanda rol;

    public IntegranteBanda(RolBanda rol, String id, String nombre, char genero, String carrera) {
        super(id, nombre, genero,carrera);
        this.rol = rol;
    }

    
}
