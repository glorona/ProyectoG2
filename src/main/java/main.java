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

public class main {
     private ArrayList<Estudiante> listaEstudiantes;
     private ArrayList<Carrera5k> listaCarreras;
     private Carrera5k carrera;
    public main() {//crea la lista
        listaEstudiantes = new ArrayList<>();
        listaCarreras = new ArrayList<>();
        carrera = new Carrera5k();
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
        listaCarreras.add(new Carrera5k("21-06-2021", "5pm", "$30", "$15", "$10",0));
        listaCarreras.add(new Carrera5k("21-05-2020", "5pm", "$40", "$25", "$5",0));
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
                    System.out.println("Registro de Participantes");
                    System.out.println("Ingrese id de la carrera:");
                    usrid = sc.nextLine();
                    for(Carrera5k car: listaCarreras){
                        if(car.getId().equals(usrid)){
                            System.out.println("Registro de Participantes en la carrera del " + car.getFecha());
                                car.registrarParticipante(listaEstudiantes);
                } } break;
                case 3:
                    String carrid;
                    System.out.println("Registro de Ganadores");
                    System.out.println("Ingrese id de la carrera:");
                    carrid = sc.nextLine();
                    for(Carrera5k car: listaCarreras){
                        if(car.getId().equals(carrid)){
                            car.registrarGanadores(car.getListaParticipantes());
                        }
            }
            }
        
    }while(!(ingreso==4));
        }
   
    
    public static void main(String[] args) {
        int usring;
        System.out.println("Hola, esta es la prueba del proyecto correspondiente al grupo dos.");
   
        main m1 = new main();
        m1.cargarEstudiantes();
        m1.cargarActividades();
        do{
        usring = m1.menu();
            switch(usring){
                case 1:
                    m1.menu5k();
                    break;
                    
            }
        }while(!(usring==4));
    }
    
}
