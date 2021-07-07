package actividades; //definicion de paquete e imports

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
public class Carrera5k extends Actividad{ //definicion de carrera5k que hereda de actividad
    
    
    public Carrera5k(){ // creacion de constructor vacio para poder acceder a los metodos
        super();
    }
    public Carrera5k(String fecha, String hora, String premio1, String premio2, String premio3){ //creacion de constructor carrera5k, en este mismo se inicializan los arrays
        super(fecha,hora,premio1,premio2,premio3); //por defecto esta carrera esta finalizada
    }
    public Carrera5k(String fecha, String hora, String premio1, String premio2, String premio3,boolean v){ //creacion de constructor carrera5k
        super(fecha,hora,premio1,premio2,premio3,v); //se agrega con verificacion si esta disponible para registrar o no
    }
    


    @Override
    public String toString() { //se sobreescribe el metodo tostring para agregar la cantidad de participantes en la carrera, como parte del requerimiento
        return super.toString() + " Cantidad de participantes: " + listaParticipantes.size(); 
        
        
    }

    
    public int verificarCarrera(ArrayList<Carrera5k> listaC, ArrayList<Estudiante> listaE, String idusr){ // se define el metodo verificar carrera para validar que la carrera este en la lista de carreras
        int posicion = -1; //se define variable para asegurar que entre al while
        int i = 0; //se define iterador
        while(i<listaC.size() && posicion == -1){ //se asegura para que el while termine el iterador tiene que ser menor a la cantidad de carreras que hayan en la lista y que el programa no haya encontrado la posicion
            if(listaC.get(i).getId().equals(idusr)){ // si encuentra el id de la carrera ingresado por el usuario
                posicion = i; //se guarda la posicion en la carrera
                i++; //se itera
            }
            else{
                i++; //se itera
            }
            
            
        }
        return posicion; //se retorna posicion
    }


    
    //@Override
   public void registrarGanadores(ArrayList<Participante> listaP){ //meotodo para registrar ganadores
        String iduser; // se inicializan campos locales a usar, idusuario,posicion y contador
        int posicion; 
        int contador =  1;
        Scanner sc = new Scanner(System.in); // se abre nuevo scanner
        while(contador<4){ //mientras la cantidad de iteraciones no sea 4
        posicion = -1; //se redefine la posicion para que busque cada vez que se itera
        System.out.println("Ingreso del " + contador + " lugar"); //se registra lugar dependiendo del contador
        while(posicion==-1){ //mientras la posicion sea -1 (no encontrada) seguira tratando de encontrar un participante
        System.out.println("Ingrese id del estudiante:"); //se solicita ingreso
        iduser = sc.nextLine(); //se permite ingreso 
        posicion = buscarParticipante(iduser, listaP); //se verifica el ingreso del usuario si esta en la lista de participantes de esa carrera
        if(verificarGanador(iduser,listaGanadores) || posicion ==-1){ //si el ganador ya eta en la lista o aun no encuentra posicion
                System.out.println("Ganador ya esta en la lista o no existe en la carrera."); //se muestra este mensaje
        }
        else{ //si no se encuentra ya agregado y se encuentra posicion se procede a registrar
            System.out.println("Ingrese tiempo "); //se ingresa el tiempo
            float time;
            time = sc.nextFloat();
            sc.nextLine(); //limpiar buffer
            listaGanadores[contador-1] = new Participante5k((Estudiante) listaP.get(posicion), time); //se agrega a la lista
            contador++; //se itera, se agrega el contador
            
        }
      
        } 
            
        }
    } //fin de carrera5k
   

    
    


   
}
    
    
    
    
