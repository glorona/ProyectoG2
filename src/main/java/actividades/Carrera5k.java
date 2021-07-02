package actividades;

import objetosPersonas.*;
import java.util.*;

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
    
    
    public Carrera5k(){
        super();
    }
    public Carrera5k(String fecha, String hora, String premio1, String premio2, String premio3){
        super(fecha,hora,premio1,premio2,premio3);
    }
    


    @Override
    public String toString() {
        return super.toString() + " Cantidad de participantes: " + listaParticipantes.size(); //To change body of generated methods, choose Tools | Templates.
    }

    public void verificarCarrera(ArrayList<Carrera5k> lista_ac,ArrayList<Estudiante> listaE ) {
        String usrid;
        Scanner sc = new Scanner(System.in);
        System.out.println("Registro de Participantes");
        System.out.println("Ingrese id de la carrera:");
        usrid = sc.nextLine();
        for(Actividad ac: lista_ac){
                if(ac.getId().equals(usrid)){
                    System.out.println("Registro de Participantes en la carrera del " + ac.getFecha());
                    ac.registrarParticipante(listaE);
                    break;
                }
            
        }
        
    }

    @Override
    public void registrarParticipante(ArrayList<Estudiante> listaE) {
        super.registrarParticipante(listaE); //To change body of generated methods, choose Tools | Templates.
        
    }
    
    
    

    
 

    


   
    }
        
    
    
    
    
    
    
    
    
