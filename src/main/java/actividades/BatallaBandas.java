/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividades;
import objetosPersonas.*;
import java.util.*;
import objetosPersonas.RolBanda;
/**
 *
 * @author gabri
 */
public class BatallaBandas extends Actividad {//Uso extends para obtener los atributos y metodos de la clase padre Actividad
    private Jurado[] listaJurado;//Creo los atributos: la lista Jurado y el ArrayList de Objetos de Clase Banda
    protected ArrayList<Banda> listaBandas;
    
    public BatallaBandas(String f, String h, String p1, String p2, String p3, Jurado[] listaJurado){//Se llama al constructor y se addiere Jurado[] para registrar lista de jurados
        super(f,h,p1,p2,p3);//Se hace un super para llamar el constructor de la clase main
        this.listaBandas = new ArrayList<>();
        this.listaJurado = listaJurado;
    }
    
    public BatallaBandas(String f, String h, String p1, String p2, String p3){//Se llama al constructor sin jurado para que se pueda crear una carrera en el main
        super(f,h,p1,p2,p3);//Se hace un super para llamar el constructor de la clase main
        this.listaBandas = new ArrayList<>();
        this.listaJurado = listaJurado;
    }
    
    public BatallaBandas(String f, String h, String p1, String p2, String p3, boolean v){//con verificacion de si esta abierta o no
        super(f,h,p1,p2,p3,v);//Se hace un super para llamar el constructor de la clase main
        this.listaBandas = new ArrayList<>();
        this.listaJurado = listaJurado;
    }
    
    public BatallaBandas(){
        super();//Llama a constructor de la clase main
    }
//Getters y Setters
    public Jurado[] getListaJurado() {
        return listaJurado;
    }

    public void setListaJurado(Jurado[] listaJurado) {
        this.listaJurado = listaJurado;
    }
    
    
    
    //Creo el metodo registrarJurado() que devuelve o la lista Jurado[]
    public Jurado[] registrarJurado(){
        Jurado[] listaJuradoT = new Jurado[3]; //crear una nueva lista para asignar los jueces, si se inicializa desde el constructor me da valores null
        Scanner sc = new Scanner(System.in);//Creo el Scanner
        int cuenta = 1;//Creo un contador
        while(cuenta<4){//Menor a 4 puesto que voy a registrar 3 jurados
            System.out.println("Ingrese informacion Jurado "+cuenta);
            System.out.println("Id: ");
            String idusr = sc.nextLine();
            if(verificarJurado(idusr,listaJuradoT)){//verifico si el jurado ya existe
                System.out.println("Jurado ya esta en la lista.");
            }
            else{//Si no esta lo registro
                System.out.println("Nombre: ");
                String name = sc.nextLine();
                System.out.println("Biografia :");
                String bio = sc.nextLine();
                listaJuradoT[cuenta - 1] = new Jurado(idusr,name,bio);//constructor de Objeto Jurado
                cuenta++;
            }
        }
        
        
        

    return listaJuradoT;    //Retorno la lista de jurados que se han verificado
    }
    //Metodo registrarIntegrantes que devuelve una lista de los Integrantes de la banda
    //Esta tiene como parametros un ArrayList de Clase Estudiante
    public IntegranteBanda[] registrarIntegrantes(ArrayList<Estudiante> listaE){
        RolBanda rol =  null; // Creo un objeto RolBanda que sera null, estoy para mas adelante asignarle un valor
        Scanner sc = new Scanner(System.in);
        System.out.println("Cuantos Integrantes?");//pregunto cuantos integrantes tndra la banda
        int cantint = sc.nextInt();
        sc.nextLine();
        IntegranteBanda[] listaInt = new IntegranteBanda[cantint];//A partir de lo que me responda creo una lista con esa extencion
        int contador = 0;
        while(contador<cantint){//hago un while que registrara tantos integrantes como el usuario indico
            System.out.println("ID Integrante " + (contador+1));
            String idusr = sc.nextLine();//Almaceno el ID del estudiante que sea desea Registrar
            for(Estudiante e: listaE){//Recorro la lista de Estudiantes y verifico que el ID existe
            if(e.getId().equals(idusr)){
                System.out.println("Estudiante" + e.getNombre() + " Registrado");//Anuncio que lo registro
                do{
                    System.out.println("Rol(CANTANTE(c), GUITARRISTA(g), BAJISTA(baj), BATERISTA(bat), OTRO(o))");
                    String rolusr = sc.nextLine();
                    switch(rolusr){//Le asigno un roll al estudiante que se quiere registrar en una banda
                        case "c":
                            rol = RolBanda.CANTANTE;
                            break;
                        case "g":
                            rol = RolBanda.GUITARRISTA;
                            break;
                        case "baj":
                            rol = RolBanda.BAJISTA;
                            break;
                        case "bat":
                            rol = RolBanda.BATERISTA;
                            break;
                        case "o":
                            rol = RolBanda.OTRO;
                            break;
                            
                    }
                }while(rol == null);
                IntegranteBanda inte = new IntegranteBanda(rol,e.getId(), e.getNombre(), e.getGenero(), e.getCarrera());//Obtengo los atributos y creo un objeto de clase Integrante de banda
                listaInt[contador] = inte;
                contador++;
                    
                }
                
                
            }
            
        }
        return listaInt;
        
        
    }

    @Override
    public String toString() {
        return super.toString() + " Cantidad de bandas registradas: " + listaBandas.size(); //To change body of generated methods, choose Tools | Templates.
    }

    //Con este metodo que devuelve un booleano verficare el Jurado
    public boolean verificarJurado(String id,Jurado[] listaJurado){
        for(int z=0;z<listaJurado.length;z++){
            if(listaJurado[z] != null && listaJurado[z].getId().equals(id)){
                return true;
                
            }
        }
        return false;
        
    }
    
    //Verificador de Competencia 
    public int verificarComp(ArrayList<BatallaBandas> listaB, ArrayList<Estudiante> listaE, String idusr ){
        int posicion = -1;
        int i = 0;
        while(i<listaB.size() && posicion == -1){
            if(listaB.get(i).getId().equals(idusr)){//de la Lista Bandas recolecto el id y lo comparo 
                posicion = i;//y si esta posicion igual a 1
                i++;
            }
            else{
                i++;
            }
            
            
        }
        return posicion;//retorno posicion
    }

    //Con estoy voy a registrar la banda
    public void registrarBanda(ArrayList<Estudiante> ListaE) {
        Scanner sc = new Scanner(System.in);
        boolean confirmacion = true;
        for(Banda b: listaBandas){//Hago for each de la listaBanda
            System.out.println(b);//Imprimo las bandas
        }
        System.out.println("\n Registro de bandas \n");//Rgistro las bandas
        while(confirmacion){
            String usrinput="";
            System.out.println("Nombre de la banda:");
            String nombrebanda = sc.nextLine();//Pido el nombre de la Banda
            System.out.println("Cancion a interpretar: ");
            String cancion = sc.nextLine();//Pido la cancion que van a tocar
            IntegranteBanda[] integrantes = registrarIntegrantes(ListaE);//Uso el metodo de registrar Integrantes
            Banda b1 = new Banda(cancion, nombrebanda,integrantes);//creo un objeto banda de la clase Banda 
            listaBandas.add(b1);//anado la banda a la lista
            while(!(usrinput.equals("N") || usrinput.equals("S"))){
                System.out.println("Desea registrar otra Banda? S/N");
                usrinput = sc.nextLine();//Pregunto si desea registrar otra banda
                
            }
            if (usrinput.equals("N")){
                confirmacion = false;
                //Si no quiere paro de registrar
            }

            
        }
    }
    
    
    
    
    
    
}
