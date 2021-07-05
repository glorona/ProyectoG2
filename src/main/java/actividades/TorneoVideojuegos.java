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
    
   
    public int verificarTorneo(ArrayList<TorneoVideojuegos> listator, ArrayList<Estudiante> listaE, String idusr){
        int posicion = -1;
        int i = 0;
        while(i<listator.size() && posicion == -1){
            if(listator.get(i).getId().equals(idusr)){
                posicion = i;
                i++;
            }
            else{
                i++;
            }
            
            
        }
        return posicion;
    }
    
    @Override
    public void registrarParticipante(ArrayList<Estudiante> listaE) {
        super.registrarParticipante(listaE); //To change body of generated methods, choose Tools | Templates.
        
    }
    
    
    
    public void registrarGanadores(ArrayList<Participante> listaP){
        String iduser;
        int posicion;
        int contador =  1;
        Scanner sc = new Scanner(System.in);
        while(contador<4){
        posicion = -1;
        System.out.println("Ingreso del " + contador + " lugar");
        while(posicion==-1){
        System.out.println("Ingrese id del estudiante:");
        iduser = sc.nextLine();
        posicion = buscarParticipante(iduser, listaP);
        if(verificarGanador(iduser,listaGanadores) || posicion ==-1){
                System.out.println("Ganador ya esta en la lista o no existe en el torneo.");
        }
        else{
            
            listaGanadores[contador-1] = listaP.get(posicion);
            contador++;
            System.out.println("Estudiante " + listaP.get(posicion).getNombre() + " ganador");
            
        }
      
        } 
            
        }
    }
    
    public boolean verificarGanador(String id,Participante[] listaG){
        for(int z=0;z<listaG.length;z++){
            if(listaG[z] != null && listaG[z].getId().equals(id)){
                return true;
                
            }
        }
        return false;
        
    }
    
}
