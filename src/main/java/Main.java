/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gabri
 */
import actividades.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import objetosPersonas.*;

public class Main {
     private ArrayList<Estudiante> listaEstudiantes;
     private ArrayList<Banda> listaBandas;
     private ArrayList<Carrera5k> listaCarreras;
     private Carrera5k carrera;
     private ArrayList<TorneoVideojuegos> listatorneos;
     private TorneoVideojuegos torneo;
     private ArrayList<BatallaBandas> listaBatallaB;
     private BatallaBandas batalla;
     
     
    public Main() {//crea la lista
        listaEstudiantes = new ArrayList<>();
        listaCarreras = new ArrayList<>();
        listaBatallaB = new ArrayList<>();
        listatorneos = new ArrayList<>();
        carrera = new Carrera5k();
        torneo = new TorneoVideojuegos();
        batalla = new BatallaBandas();
    }

    public void cargarEstudiantes() {
        //se crea inputstream con el metodo getresourceastream para que funcione con el jar
        InputStream input = getClass().getClassLoader().getResourceAsStream("archivos/ESTUDIANTES.csv");

        
        BufferedReader br = null;
        try {
            String linea = null;
            br = new BufferedReader(new InputStreamReader(input));
            linea = br.readLine();//saltar la primera linea
            while ((linea = br.readLine()) != null) //iterar mientras haya lineas
            {
                String[] info = linea.split(",");//separar los datos por coma
                //crear objeto y agregar a la lista
                listaEstudiantes.add(new Estudiante(info[0],info[1],info[2].charAt(0),info[3]));
                        
            }
        } catch (FileNotFoundException ex) {
            System.out.println("No se encuentra el archivo");
        } catch (IOException ex) {
            System.out.println("Error al leer el archivo");
        } finally {
            try {
                if (br!=null)
                br.close();
            } catch (IOException ex) {
                System.out.println("Error al cerrar el archivo");
            }
        }
   
    }
    
    
    public void cargarActividades(){
        listaCarreras.add(new Carrera5k("21-06-2021", "5pm", "$30", "$15", "$10"));
        listaCarreras.add(new Carrera5k("21-05-2020", "5pm", "$40", "$25", "$5"));
        listatorneos.add(new TorneoVideojuegos("22-06-2020", "4pm", "$50", "$30", "$15", "LOL"));
        listatorneos.add(new TorneoVideojuegos("22-06-2021", "4pm", "$55", "35", "20", "FreeFire"));
    }
    
    public int menu(){
        int ingreso;
        Scanner sc = new Scanner(System.in);
        System.out.println("\nBienvenido, Seleccione una opcion");
        System.out.println("1. Carrera5k");
        System.out.println("2. Competencia de bandas musicales");
        System.out.println("3. Torneo de videojuegos. ");
        System.out.println("4. Salir");
        ingreso = sc.nextInt();
        return ingreso;
        
    }
    
    public void menu5k(){
        int ingreso;
        Scanner sc = new Scanner(System.in);
        do{
        System.out.println("\nCarreras disponibles: \n");
        for(Carrera5k ac: listaCarreras){
          
                System.out.println(ac);
            }
 
        System.out.println("\n Bienvenido, Seleccione una opcion");
        System.out.println("1. Crear nueva carrera");
        System.out.println("2. Registrar participantes");
        System.out.println("3. Registrar Ganadores");
        System.out.println("4. Salir");
        
        ingreso = sc.nextInt();
        sc.nextLine();
            switch(ingreso){
                case 1:
                    System.out.println("Solo esta para mantener integridad del programa, dado que esto no se hace en grupos de 3.");
                    break;
                case 2:
                    String usrid;
                    int verificacionC;
                    System.out.println("Ingrese ID de la competencia:");
                    usrid = sc.nextLine();
                    verificacionC = carrera.verificarCarrera(listaCarreras, listaEstudiantes,usrid);
                    if(verificacionC>=0){
                        listaCarreras.get(verificacionC).registrarParticipante(listaEstudiantes);
                    }
                    break;
                case 3:
                    String usrid2;
                    int verificacionCarr;
                    System.out.println("Ingrese ID de la competencia:");
                    usrid2 = sc.nextLine();
                    verificacionCarr = carrera.verificarCarrera(listaCarreras, listaEstudiantes,usrid2);
                    if(verificacionCarr>=0){
                        listaCarreras.get(verificacionCarr).registrarGanadores(listaCarreras.get(verificacionCarr).getListaParticipantes());
                    }
            }
        
    }while(!(ingreso==4));
        }
   
    
    public void menutorneo(){
        int ingreso;
        Scanner sc = new Scanner(System.in);
        do{
        System.out.println("\nTorneos disponibles: \n");
        for(TorneoVideojuegos tor: listatorneos){
                System.out.println(tor);
            }
 
        System.out.println("\n Bienvenido, Seleccione una opcion");
        System.out.println("1. Crear nuevo torneo");
        System.out.println("2. Registrar participantes");
        System.out.println("3. Registrar Ganadores");
        System.out.println("4. Volver al menu principal");
        
        ingreso = sc.nextInt();
        sc.nextLine();
            switch(ingreso){
                case 1:
                    System.out.println("Solo esta para mantener integridad del programa, dado que esto no se hace en grupos de 3.");
                    break;
                case 2:
                    String id;
                    int verificacion;
                    System.out.println("Ingrese ID del torneo:");
                    id = sc.nextLine();
                    
                    verificacion = torneo.verificarTorneo(listatorneos, listaEstudiantes, id);
                    System.out.println("Registro de Participantes en torneo de videojuego " + listatorneos.get(verificacion).getVideojuego());
             
                    if (verificacion>=0){
                        listatorneos.get(verificacion).registrarParticipante(listaEstudiantes);
                        
                    }
                    break;
                    

                case 3:
                
                    String usrid2;
                    int verificaciontor;
                    System.out.println("Ingrese ID del torneo:");
                    usrid2 = sc.nextLine();
                    verificaciontor = torneo.verificarTorneo(listatorneos, listaEstudiantes,usrid2);
                    if(verificaciontor>=0){
                        listatorneos.get(verificaciontor).registrarGanadores(listatorneos.get(verificaciontor).getListaParticipantes());
                    }
                    
                    
            
            }
        
    }while(!(ingreso==4));
        }
    
    

    public void menuBandas(){
        int ingreso;
        Scanner sc = new Scanner(System.in);
        do{
        System.out.println("\nBatallas de bandas disponibles: \n");
        for(BatallaBandas b: listaBatallaB){
                System.out.println(b);
            }
 
        System.out.println("\n Bienvenido, Seleccione una opcion");
        System.out.println("1. Crear nueva competencia de Batalla de Bandas");
        System.out.println("2. Registrar participantes");
        System.out.println("3. Registrar Ganadores");
        System.out.println("4. Volver al menu principal");
        
        ingreso = sc.nextInt();
        sc.nextLine();
            switch(ingreso){
                case 1:
                   System.out.println("Fecha (dd/mm/yyyy):");
                   String fecha = sc.nextLine();
                   System.out.println("Hora(hh:mm):");
                   String hora =sc.nextLine();
                   System.out.println("Premio primer lugar:");
                   String premio1 =sc.nextLine();
                   System.out.println("Premio segundo lugar:");
                   String premio2 =sc.nextLine();
                   System.out.println("Premio tercer lugar:");
                   String premio3 =sc.nextLine();
                   System.out.println("Jurado");
                   Jurado[] listaJ = batalla.registrarJurado();
                   BatallaBandas b = new BatallaBandas(fecha,hora,premio1,premio2,premio3,listaJ);
                   listaBatallaB.add(b);
                   break;

                case 2:
                    String usrid;
                    int verificacionB;
                    System.out.println("Ingrese ID de la competencia:");
                    usrid = sc.nextLine();
                    verificacionB = batalla.verificarComp(listaBatallaB, listaEstudiantes,usrid);
                    if(verificacionB>=0){
                        listaBatallaB.get(verificacionB).registrarBanda(listaEstudiantes);
                    }
                    break;
                case 3:
                    System.out.println("Solo esta para mantener integridad del programa, dado que esto no se hace en grupos de 3.");
                    break;
            }
        
    }while(!(ingreso==4));
        }
    
    
    public static void main(String[] args) {
        int usring;
        System.out.println("Hola, esta es la prueba del proyecto correspondiente al grupo dos.");
   
        Main m1 = new Main();
        m1.cargarEstudiantes();
        m1.cargarActividades();
        do{
        usring = m1.menu();
            switch(usring){
                case 1:
                    m1.menu5k();
                    break;
                case 2:
                    m1.menuBandas();
                    break;
                 
                case 3:
                    m1.menutorneo();
                    break;
                
            }
        }while(!(usring==4));
    }
    
}