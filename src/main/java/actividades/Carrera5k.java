/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
public class Carrera5k extends Actividad{

    private String id;
    
    private static int contador = 1;
    
    public Carrera5k(String fecha, String hora, String premio1, String premio2, String premio3){
        super(fecha,hora,premio1,premio2,premio3);
        Integer cod = new Integer(contador++);
        id =  Integer.toString(cod); //GENERA EL ID INMEDIATAMENTE
    }
    
    
    
    
    
    
    
}
