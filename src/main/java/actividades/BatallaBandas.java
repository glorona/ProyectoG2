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
public class BatallaBandas extends Actividad {
    private Jurado[] listaJurado;
    protected ArrayList<Banda> listaBandas;
    
    public BatallaBandas(String f, String h, String p1, String p2, String p3, Jurado[] listaJurado){
        super(f,h,p1,p2,p3);
        this.listaBandas = new ArrayList<>();
        this.listaJurado = listaJurado;
    }
    
    public BatallaBandas(){
        super();
    }

    public Jurado[] getListaJurado() {
        return listaJurado;
    }

    public void setListaJurado(Jurado[] listaJurado) {
        this.listaJurado = listaJurado;
    }
    
    
    
    
    public Jurado[] registrarJurado(){
        Jurado[] listaJuradoT = new Jurado[3]; //crear una nueva lista para asignar los jueces, si se inicializa desde el constructor me da valores null
        Scanner sc = new Scanner(System.in);
        int cuenta = 1;
        while(cuenta<4){
            System.out.println("Ingrese informacion Jurado "+cuenta);
            System.out.println("Id: ");
            String idusr = sc.nextLine();
            if(verificarJurado(idusr,listaJuradoT)){
                System.out.println("Jurado ya esta en la lista.");
            }
            else{
                System.out.println("Nombre: ");
                String name = sc.nextLine();
                System.out.println("Biografia :");
                String bio = sc.nextLine();
                listaJuradoT[cuenta - 1] = new Jurado(idusr,name,bio);
                cuenta++;
            }
        }
        
        
        

    return listaJuradoT;    
    }
    
    public IntegranteBanda[] registrarIntegrantes(ArrayList<Estudiante> listaE){
        RolBanda rol =  null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Cuantos Integrantes?");
        int cantint = sc.nextInt();
        sc.nextLine();
        IntegranteBanda[] listaInt = new IntegranteBanda[cantint];
        int contador = 0;
        while(contador<cantint){
            System.out.println("ID Integrante " + (contador+1));
            String idusr = sc.nextLine();
            for(Estudiante e: listaE){
            if(e.getId().equals(idusr)){
                System.out.println("Estudiante" + e.getNombre() + " Registrado");
                do{
                    System.out.println("Rol(CANTANTE(c), GUITARRISTA(g), BAJISTA(baj), BATERISTA(bat), OTRO(o))");
                    String rolusr = sc.nextLine();
                    switch(rolusr){
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
                IntegranteBanda inte = new IntegranteBanda(rol,e.getId(), e.getNombre(), e.getGenero(), e.getCarrera());
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

    
    public boolean verificarJurado(String id,Jurado[] listaJurado){
        for(int z=0;z<listaJurado.length;z++){
            if(listaJurado[z] != null && listaJurado[z].getId().equals(id)){
                return true;
                
            }
        }
        return false;
        
    }
    
    
    public int verificarComp(ArrayList<BatallaBandas> listaB, ArrayList<Estudiante> listaE, String idusr ){
        int posicion = -1;
        int i = 0;
        while(i<listaB.size() && posicion == -1){
            if(listaB.get(i).getId().equals(idusr)){
                posicion = i;
                i++;
            }
            else{
                i++;
            }
            
            
        }
        return posicion;
    }

    
    public void registrarBanda(ArrayList<Estudiante> ListaE) {
        Scanner sc = new Scanner(System.in);
        boolean confirmacion = true;
        for(Banda b: listaBandas){
            System.out.println(b);
        }
        System.out.println("\n Registro de bandas \n");
        while(confirmacion){
            String usrinput="";
            System.out.println("Nombre de la banda:");
            String nombrebanda = sc.nextLine();
            System.out.println("Cancion a interpretar: ");
            String cancion = sc.nextLine();
            IntegranteBanda[] integrantes = registrarIntegrantes(ListaE);
            Banda b1 = new Banda(cancion, nombrebanda,integrantes);
            listaBandas.add(b1);
            while(!(usrinput.equals("N") || usrinput.equals("S"))){
                System.out.println("Desea registrar otra Banda? S/N");
                usrinput = sc.nextLine();
                
            }
            if (usrinput.equals("N")){
                confirmacion = false;
                
            }

            
        }
    }
    
    
    
    
    
    
}
