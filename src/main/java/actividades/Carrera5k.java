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
/**
    public boolean verificarCarrera(ArrayList<Carrera5k> lista_ac,ArrayList<Estudiante> listaE ) {
        String usrid;
        Scanner sc = new Scanner(System.in);
        System.out.println("Registro de Participantes");
        System.out.println("Ingrese id de la carrera:");
        usrid = sc.nextLine();
        for(Actividad ac: lista_ac){
                if(ac.getId().equals(usrid)){
                    return true;
                    System.out.println("Registro de Participantes en la carrera del " + ac.getFecha());
                    ac.registrarParticipante(listaE);
                    break;
                }
            
        }
        
    }
    * */
    
    public int verificarCarrera(ArrayList<Carrera5k> listaC, ArrayList<Estudiante> listaE, String idusr){
        int posicion = -1;
        int i = 0;
        while(i<listaC.size() && posicion == -1){
            if(listaC.get(i).getId().equals(idusr)){
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
    
    
    //@Override
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
                System.out.println("Ganador ya esta en la lista o no existe en la carrera.");
        }
        else{
            System.out.println("Ingrese tiempo ");
            float time;
            time = sc.nextFloat();
            sc.nextLine();
            listaGanadores[contador-1] = new Participante5k((Estudiante) listaP.get(posicion), time);
            contador++;
            
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
    
    
    
    
