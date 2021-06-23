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

public class Banda extends Participante {
    protected String cancion;
    protected IntegranteBanda integrantes;

    public Banda(String cancion, IntegranteBanda integrantes, String id, String nombre) {
        super(id, nombre);
        this.cancion = cancion;
        this.integrantes = integrantes;
    }
    
    
    
}
