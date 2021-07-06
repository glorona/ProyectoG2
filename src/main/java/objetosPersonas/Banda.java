package objetosPersonas;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gabri
 */

public class Banda extends Participante {//
    private static int contador = 1;//Atributo que ayudara para generar ID
    protected String cancion; //Atributo String cancion
    protected IntegranteBanda[] integrantes; // List de Integrastes de la Banda

    public Banda(String cancion, String nombre,IntegranteBanda[] integrantes) {//Constructor Banda
        Integer cod = new Integer(contador++);
        id =  Integer.toString(cod); //GENERA EL ID INMEDIATAMENTE
        this.nombre = nombre;
        this.cancion = cancion;
        this.integrantes = integrantes;
    }

    @Override
    public String toString() {
        return "ID: " + id + " Nombre:" + nombre; 
    }
//Setters
    public void setIntegrantes(IntegranteBanda[] integrantes) {
        this.integrantes = integrantes;
    }
    
    
    
    
    
}
