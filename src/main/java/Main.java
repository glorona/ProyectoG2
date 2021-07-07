/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gabri
 */
import actividades.*; //importo todas las actividades
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import objetosPersonas.*; //importo todas las clases con las personas

public class Main {
     private ArrayList<Estudiante> listaEstudiantes; //atributos 
     private ArrayList<Banda> listaBandas;
     private ArrayList<Carrera5k> listaCarreras;
     private Carrera5k carrera; //atributo para poder utilizar los metodos de la clase
     private ArrayList<TorneoVideojuegos> listatorneos;
     private TorneoVideojuegos torneo; //atributo para poder utilizar los metodos de la clase
     private ArrayList<BatallaBandas> listaBatallaB;
     private BatallaBandas batalla;
     
     
    public Main() {//crea las listas y los atributos para usar los metodos de las clases
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
    
    
    public void cargarActividades(){ //se agregan las instancias de cada clase 
        listaCarreras.add(new Carrera5k("21-06-2021", "5pm", "$30", "$15", "$10",true)); //carrera disponible (true)
        listaCarreras.add(new Carrera5k("21-05-2020", "5pm", "$40", "$25", "$5")); //carrera finalizada
        listatorneos.add(new TorneoVideojuegos("22-06-2020", "4pm", "$50", "$30", "$15", "LOL")); //torneo finalizado
        listatorneos.add(new TorneoVideojuegos("22-06-2021", "4pm", "$55", "35", "20", "FreeFire",true)); //torneo disponible
        listaBatallaB.add(new BatallaBandas("21-07-2020", "5pm", "$100","$50","$25")); //carrera finalizada
        listaBatallaB.add(new BatallaBandas("15-08-2021", "6pm", "$100","$50","$25",true)); //batalla disponible
    }
    
    public int menu(){
        int ingreso;
        Scanner sc = new Scanner(System.in); 
        System.out.println("\nBienvenido, Seleccione una opcion"); //menu principal
        System.out.println("1. Carrera5k");
        System.out.println("2. Competencia de bandas musicales");
        System.out.println("3. Torneo de videojuegos. ");
        System.out.println("4. Salir");
        ingreso = sc.nextInt(); //se almacena el numero de la opcion elegida
        return ingreso; //se retorna el numero de la opcion elegida
        
    }
    
    public void menu5k(){ //menu a presentar en la opcion de carrera5k
        int ingreso;
        Scanner sc = new Scanner(System.in);
        do{
        System.out.println("\nCarreras disponibles: \n");
        for(Carrera5k ac: listaCarreras){ //itero en las carreras de la lista
          
                System.out.println(ac); //muestro las carreras que ya han sido creadas para que visualicen el id y sigan con el menu
            }
 
        System.out.println("\n Bienvenido, Seleccione una opcion"); //menu de las opciones 
        System.out.println("1. Crear nueva carrera");
        System.out.println("2. Registrar participantes");
        System.out.println("3. Registrar Ganadores");
        System.out.println("4. Salir");
        
        ingreso = sc.nextInt(); //almaceno la opcion escogida por el usuario
        sc.nextLine(); //limpio el buffer
            switch(ingreso){ //uso switch para saber que opcion escogio y agrego casos para las opciones
                case 1:
                    System.out.println("Solo esta para mantener integridad del programa, dado que esto no se hace en grupos de 3.");
                    break; //salgo de la opcion y regreso al menu5k
                case 2:
                    String usrid;
                    int verificacionC; //almacenara la posicion de la carrera si es que existe
                    System.out.println("Ingrese ID de la competencia:");
                    usrid = sc.nextLine(); //almaceno el id escogido de la carrera
                    verificacionC = carrera.verificarCarrera(listaCarreras, listaEstudiantes,usrid); //verifico que la carrera exista y esté en la lista de carreras para almacenar su posicion
                    if(verificacionC>=0){ //ingreso si la posicion de la carrera es mayor que cero por lo que efectivamente existe en la lista
                        if(listaCarreras.get(verificacionC).getVerificacion()){ //obtengo la carrera de la lista y si su atributo verificacion es TRUE ingreso para guardar el participante ya que esta disponible
                        listaCarreras.get(verificacionC).registrarParticipante(listaEstudiantes); //al obtener la carrera, utilizo el metodo para registrar participantes
                        }
                        else{
                            System.out.println("Carrera ya finalizada"); //ya que su atributo verificacion es false, la carrera ya no esta disponible
                        }
                    }
                    break; //regreso al menu5k
                case 3:
                    String usrid2;
                    int verificacionCarr; //almacenara la posicion de la carrera luego de verificar que exista
                    System.out.println("Ingrese ID de la competencia:");
                    usrid2 = sc.nextLine(); //almaceno el id de la carrera
                    verificacionCarr = carrera.verificarCarrera(listaCarreras, listaEstudiantes,usrid2); //verifico que la carrera exista y almaceno su posicion 
                    if(verificacionCarr>=0 && listaCarreras.get(verificacionCarr).getVerificacion()){ //ingreso si la posicion fue encontrada, sino sera -1 y que su verificacion sea true pues debe estar disponible
                        listaCarreras.get(verificacionCarr).registrarGanadores(listaCarreras.get(verificacionCarr).getListaParticipantes()); //aplico el metodo en la carrera para registrar ganadores
                    } else {
                        System.out.println("La carrera ya fue finalizada o no existe"); //ya que su atributo verificacion es false, la carrera ya no esta disponible
                    }
            }
        
    }while(!(ingreso==4)); //salgo del menu en el caso de quiera regresar al principal
        }
   
    
    public void menutorneo(){ //menu a presentar en la opcion de torneo de videojuegos
        int ingreso;
        Scanner sc = new Scanner(System.in);
        do{
        System.out.println("\nTorneos disponibles: \n");
        for(TorneoVideojuegos tor: listatorneos){ //itero en los torneos de la lista
                System.out.println(tor); //muestro las carreras que ya han sido creadas para que visualicen el id y sigan con el menu
            }
 
        System.out.println("\n Bienvenido, Seleccione una opcion"); //menu de las opciones 
        System.out.println("1. Crear nuevo torneo");
        System.out.println("2. Registrar participantes");
        System.out.println("3. Registrar Ganadores");
        System.out.println("4. Volver al menu principal");
        
        ingreso = sc.nextInt(); //almaceno la opcion escogida por el usuario
        sc.nextLine(); //limpio el buffer
            switch(ingreso){ //uso switch para saber que opcion escogio y agrego casos para las opciones
                case 1:
                    System.out.println("Solo esta para mantener integridad del programa, dado que esto no se hace en grupos de 3.");
                    break; //salgo de la opcion y regreso al menutorneo
                case 2:
                    String id;
                    int verificacion; //almacenara la posicion del torneo si es que existe
                    System.out.println("Ingrese ID del torneo:");
                    id = sc.nextLine(); //almaceno el id escogido del torneo
                    
                    verificacion = torneo.verificarTorneo(listatorneos, listaEstudiantes, id); //verifico que el torneo exista y esté en la lista de torneos para almacenar su posicion
                    //System.out.println("Registro de Participantes en torneo de videojuego " + listatorneos.get(verificacion).getVideojuego());
             
                    if (verificacion>=0){ //ingreso si la posicion del torneo es mayor que cero por lo que efectivamente existe en la lista
                        if(listatorneos.get(verificacion).getVerificacion()){ //obtengo el torneo de la lista y si su atributo verificacion es TRUE ingreso para guardar el participante ya que esta disponible
                        System.out.println("Registro de Participantes en torneo de videojuego " + listatorneos.get(verificacion).getVideojuego());
                            listatorneos.get(verificacion).registrarParticipante(listaEstudiantes);//al obtener el torneo, utilizo el metodo para registrar participantes
                        }
                        else{
                            System.out.println("Torneo ya finalizado."); //ya que su atributo verificacion es false, la carrera ya no esta disponible
                        }
                    }
                    break; //regreso al menutorneo
                    

                case 3:
                
                    String usridtor;
                    int verificaciontor; //almacenara la posicion del torneo luego de verificar que exista
                    System.out.println("Ingrese ID del torneo:");
                    usridtor = sc.nextLine();//almaceno el id del torneo
                    verificaciontor = torneo.verificarTorneo(listatorneos, listaEstudiantes,usridtor); //verifico que el torneo exista y almaceno su posicion 
                    if (verificaciontor>=0 && listatorneos.get(verificaciontor).getVerificacion()){ //ingreso si la posicion fue encontrada, sino sera -1 y que su verificacion sea true pues debe estar disponible
                        listatorneos.get(verificaciontor).registrarGanadores(listatorneos.get(verificaciontor).getListaParticipantes()); //aplico el metodo en el torneo para registrar ganadores
                    } else {
                        System.out.println("El torneo ya fue finalizado o no existe"); //ya que su atributo verificacion es false, la carrera ya no esta disponible
                    }
                    
                    
            
            }
        
    }while(!(ingreso==4));
        }
    
    
//Menu de Batallas de Banda
    public void menuBandas(){
        int ingreso;
        Scanner sc = new Scanner(System.in);
        do{
        System.out.println("\nBatallas de bandas disponibles: \n");
        for(BatallaBandas b: listaBatallaB){//Imprimo la lista de Batallas de Bandas que se han registrado
                System.out.println(b);
            }
 
        System.out.println("\n Bienvenido, Seleccione una opcion");
        System.out.println("1. Crear nueva competencia de Batalla de Bandas");
        System.out.println("2. Registrar participantes");
        System.out.println("3. Registrar Ganadores");
        System.out.println("4. Volver al menu principal");
        //Le doy al usuario su menu y sus opciones con los numeros
        ingreso = sc.nextInt();//Almaceno su respuesta para usar el switch
        sc.nextLine();
            switch(ingreso){
                case 1://Si desea crear una competencia de batalla de bandas
                   System.out.println("Fecha (dd/mm/yyyy):");
                   String fecha = sc.nextLine();//Pido la fecha
                   System.out.println("Hora(hh:mm):");
                   String hora =sc.nextLine();//Pido la banda
                   System.out.println("Premio primer lugar:");
                   String premio1 =sc.nextLine();//el premio de los lugares 1 2 3
                   System.out.println("Premio segundo lugar:");
                   String premio2 =sc.nextLine();
                   System.out.println("Premio tercer lugar:");
                   String premio3 =sc.nextLine();
                   System.out.println("Jurado");
                   Jurado[] listaJ = batalla.registrarJurado();//llamo el metodo de registrar jurados
                   BatallaBandas b = new BatallaBandas(fecha,hora,premio1,premio2,premio3,listaJ);//creo la batalla de bandas
                   listaBatallaB.add(b);//la agrego a la lista de las batallas de bandas disponibles
                   break;

                case 2:
                    String usrid;
                    int verificacionB;
                    System.out.println("Ingrese ID de la competencia:");//Pido el ID de la competencia que desea ingresar
                    usrid = sc.nextLine();
                    verificacionB = batalla.verificarComp(listaBatallaB, listaEstudiantes,usrid);//uso el metodo de verificarComp
                    if(verificacionB>=0){
                        if(listaBatallaB.get(verificacionB).getVerificacion()){ //si esta true significa que se puede registrar
                            listaBatallaB.get(verificacionB).registrarBanda(listaEstudiantes);                     
                        }
                        else{
                            System.out.println("Batalla de bandas finalizada.");
                        }
                        
                    }
                    break;
                case 3:
                    System.out.println("Solo esta para mantener integridad del programa, dado que esto no se hace en grupos de 3.");
                    break;
            }
        
    }while(!(ingreso==4)); //salgo del menu
        }
    
    
    public static void main(String[] args) {
        int usring;
        System.out.println("Hola, esta es la prueba del proyecto correspondiente al grupo dos.");
   
        Main m1 = new Main(); //accedo a los metodos del Main y a sus atributos
        m1.cargarEstudiantes(); //cargo los estudiantes 
        m1.cargarActividades(); //cargo las actividades creadas
        do{
        usring = m1.menu(); //se guarda la opcion escogida por el usuario
            switch(usring){ //uso switch para saber que opcion quiere realizar el usuario
                case 1:
                    m1.menu5k(); //ingreso al menu5k y sus opciones
                    break; //salgo de la opcion para ver el menu nuevamente
                case 2:
                    m1.menuBandas(); //ingreso al menu de bandas y sus opciones
                    break; //salgo de la opcion para ver el menu nuevamente
                 
                case 3:
                    m1.menutorneo(); //ingreso al menu de torneo de videojuegos y sus opciones
                    break; //salgo de la opcion para ver el menu nuevamente
                
            }
        }while(!(usring==4)); //salgo del menu principal 
    }
    
}