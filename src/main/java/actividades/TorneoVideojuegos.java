/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividades;

import objetosPersonas.*;
import java.util.*;
/**
 *
 * @author Usuario
 */
public class TorneoVideojuegos extends Actividad{
    
    private String videojuego;
    
    public TorneoVideojuegos(){
        super();
    }
    
    public TorneoVideojuegos(String fecha, String hora, String premio1, String premio2, String premio3, String v){
        super(fecha,hora,premio1,premio2,premio3);
        this.videojuego = v;
    }
    
    public String getVideojuego(){
        return videojuego;
    }
    
    
    @Override
    public String toString() {
        return super.toString() +" Videojuego: "+ videojuego + " Cantidad de participantes: " + listaParticipantes.size(); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void verificarTorneo(ArrayList<TorneoVideojuegos> lista,ArrayList<Estudiante> listaE ) {
        String usrid;
        Scanner sc = new Scanner(System.in);
        System.out.println("Registro de Participantes");
        System.out.println("Ingrese ID del torneo:");
        usrid = sc.nextLine();
        for(TorneoVideojuegos torneo: lista){
                if(torneo.getId().equals(usrid)){
                    System.out.println("Registro de participantes en el torneo de videojuego " + torneo.getVideojuego());
                    torneo.registrarParticipante(listaE);
                    break;
                }
            
        }
        
    }
    
    @Override
    public void registrarParticipante(ArrayList<Estudiante> listaE) {
        super.registrarParticipante(listaE); //To change body of generated methods, choose Tools | Templates.
        
    }
    
    
    @Override
    public void registrarGanadores(ArrayList<Participante> listaP){
        
        
        
        
        String iduser;
        int posicion;
        int contador =  1;
        //int i=0;
        Scanner sc = new Scanner(System.in);
        while(contador<4){
        posicion = -1;
        System.out.println("Ingreso del " + contador + " lugar");
        while(posicion==-1){
        System.out.println("Ingrese id del estudiante:");
        iduser = sc.nextLine();
        posicion = buscarParticipante(iduser, listaP);
        
        }
        
        System.out.println("Estudiante "+ listaP.get(posicion).getNombre()+" ganador");
        listaGanadores[contador-1] = listaP.get(posicion);
        contador++;
        } 

     
    } 
    
}
