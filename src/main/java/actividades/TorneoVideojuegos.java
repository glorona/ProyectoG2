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
    
    public TorneoVideojuegos(){ // creacion de constructor vacio para poder acceder a los metodos
        super();
    }
    
    public TorneoVideojuegos(String fecha, String hora, String premio1, String premio2, String premio3, String v){ //Constructor sin verificacion para que sea false y esté inactivo el torneo
        super(fecha,hora,premio1,premio2,premio3);
        this.videojuego = v;
    }
    
    public TorneoVideojuegos(String fecha, String hora, String premio1, String premio2, String premio3, String v, boolean ver){ //Constructor con verficacion para cuando esté activa (true)
        super(fecha,hora,premio1,premio2,premio3,ver);
        this.videojuego = v;
    }
    
    public String getVideojuego(){ //getter
        return videojuego;
    }
    
    
    @Override //override del método toString para agregar el videojuego y la cantidad de participantes
    public String toString() {
        return super.toString() +" Videojuego: "+ videojuego + " Cantidad de participantes: " + listaParticipantes.size(); //To change body of generated methods, choose Tools | Templates.
    }
    
   
    public int verificarTorneo(ArrayList<TorneoVideojuegos> listator, ArrayList<Estudiante> listaE, String idusr){ // metodo para validar que el torneo este en la lista de torneos
        int posicion = -1; //se define variable para asegurar que entre al while
        int i = 0; //se define iterador
        while(i<listator.size() && posicion == -1){ //se asegura para que el while termine el iterador tiene que ser menor a la cantidad de carreras que hayan en la lista y que el programa no haya encontrado la posicion
            if(listator.get(i).getId().equals(idusr)){ // ingresa si encuentra el id de la carrera ingresado por el usuario
                posicion = i; //almaceno la posicion del torneo en la lista
                i++;
            }
            else{
                i++;
            }
            
            
        }
        return posicion;
    }
    
    
    
    public void registrarGanadores(ArrayList<Participante> listaP){
        String iduser;
        int posicion;
        int contador =  1;
        Scanner sc = new Scanner(System.in);
        while(contador<4){ //mientras la cantidad de iteraciones no sea 4
        posicion = -1; //se redefine la posicion para que busque cada vez que se itera
        System.out.println("Ingreso del " + contador + " lugar");
        while(posicion==-1){ //mientras la posicion sea -1 (no encontrada) seguira tratando de encontrar un participante
        System.out.println("Ingrese id del estudiante:");
        iduser = sc.nextLine(); //almaceno el id ingresado y se permite el ingreso
        posicion = buscarParticipante(iduser, listaP); //se verifica el ingreso del usuario si esta en la lista de participantes de esa carrera
        if(verificarGanador(iduser,listaGanadores) || posicion ==-1){ //ingreso si el ganador ya esta en la lista o aun no encuentra posicion
                System.out.println("Ganador ya esta en la lista o no existe en el torneo.");
        }
        else{ //si no se encuentra ya agregado y se encuentra posicion se procede a registrar
            
            listaGanadores[contador-1] = listaP.get(posicion); //se busca el objeto y se almacena en la lista de ganadores
            contador++;
            System.out.println("Estudiante " + listaP.get(posicion).getNombre() + " ganador"); //muestro el nombre del ganador
            
        }
      
        } 
            
        }
    }

    
    
}
