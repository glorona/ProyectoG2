package actividades; //se elige el paquete donde se implementa la clase
import objetosPersonas.*; //se importan las clases a usar
import java.util.ArrayList;
import java.util.Scanner;
public class Actividad { // se define la clase actividad
    private static int contador = 1; //se definen los campos a usar el contador para el id, el id, la fecha, la hora, los premios y los arraylist a utilizar
    private String id;
    private String fecha;
    private String hora;
    private String premio_1;
    private String premio_2;
    private String premio_3;
    private boolean verificacion;
    protected ArrayList<Participante> listaParticipantes;
    protected Participante[] listaGanadores;
    
    
    public Actividad(){ //se crea constructor vacio para usar los metodos en tal caso de que se necestien
        super();
        
    }
    

    public Actividad(String fecha, String hora, String premio_1, String premio_2, String premio_3, boolean v) { //se define el constructor con los parametros solicitados
        super(); //se usa el super definiendo clase padre
        Integer cod = new Integer(contador++); //se hace boxing y uso de clase wrapper para generar id
        id =  Integer.toString(cod); //GENERA EL ID INMEDIATAMENTE
        this.fecha = fecha; //se definen los parametros al constructor
        this.hora = hora;
        this.premio_1 = premio_1;
        this.premio_2 = premio_2;
        this.premio_3 = premio_3;
        this.verificacion = v;  //se construye verificacion indicando que si esta activa
        this.listaParticipantes = new ArrayList<>(); //se inicializan las listas para evitar NPE (nullpointerexception)
        this.listaGanadores = new Participante[3]; 
        
        
        
    }
    public Actividad(String fecha, String hora, String premio_1, String premio_2, String premio_3) { //se define el constructor con los parametros solicitados
        super(); //se usa el super definiendo clase padre
        Integer cod = new Integer(contador++); //se hace boxing y uso de clase wrapper para generar id
        id =  Integer.toString(cod); //GENERA EL ID INMEDIATAMENTE
        this.fecha = fecha; //se definen los parametros al constructor
        this.hora = hora;
        this.premio_1 = premio_1;
        this.premio_2 = premio_2;
        this.premio_3 = premio_3;
        this.verificacion = false; //por defecto false, que significa que esta inactiva.
        this.listaParticipantes = new ArrayList<>(); //se inicializan las listas para evitar NPE (nullpointerexception)
        this.listaGanadores = new Participante[3]; 
        
        
        
    }
    

    public String getId() { //getters y setters
        return id;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public String getPremio_1() {
        return premio_1;
    }

    public String getPremio_2() {
        return premio_2;
    }

    public String getPremio_3() {
        return premio_3;
    }

    public ArrayList<Participante> getListaParticipantes() {
        return listaParticipantes;
    }

    public Participante[] getListaGanadores() {
        return listaGanadores;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setPremio_1(String premio_1) {
        this.premio_1 = premio_1;
    }

    public void setPremio_2(String premio_2) {
        this.premio_2 = premio_2;
    }

    public void setPremio_3(String premio_3) {
        this.premio_3 = premio_3;
    }

    public void setListaParticipantes(ArrayList listaParticipantes) {
        this.listaParticipantes = listaParticipantes;
    }

    public void setListaGanadores(Participante[] listaGanadores) {
        this.listaGanadores = listaGanadores;
    }

    public boolean getVerificacion() {
        return verificacion;
    }

    public void setVerificacion(boolean verificacion) {
        this.verificacion = verificacion;
    }
    
    

    
    


    
    

    @Override // sobreescribiendo metodo tostring para que muestre lo respectivo al imprimirlo, mostrando la actividad su fecha  y hora
    public String toString() {
        return  "Id=" + id + "  Fecha=" + fecha + "  Hora=" + hora;
    }
    
    

    
    public void registrarParticipante(ArrayList<Estudiante> listaE){ // registrar participante, recibe arraylist de estudiantes cargada
        String iduser; //se define campo iduser para compararlo
        Scanner sc = new Scanner(System.in); //se abre nuevo scanner para este metodo
        System.out.println("\nINGRESE 0 (CERO) CUANDO YA NO QUIERA SEGUIR REGISTRANDO PARTICIPANTES\n");
        do{ //inicio del do
        System.out.println("Ingrese id del estudiante:"); //solicita ingreso de datos del usuario  
        iduser = sc.nextLine(); //se permite ingreso
        for(Estudiante e: listaE){ //se recorre la lista de estudiantes
            if(e.getId().equals(iduser)){ //se compara si el id ingresado coincide con el id del usuario
                if(listaParticipantes.contains(e)){ //se verfiica que el participante ya no este registrado
                    System.out.println("Estudiante ya fue agregado.");
                }
                else{ //si no esta registrado se procede con el registro
                   
           
                listaParticipantes.add(e); //agg el objeto estudiante a la lista participantes
                System.out.println("Estudiante " + e.getNombre() + " Registrado"); //se muestra que fue registrado el usuario.
            }
        }
        }
        } while(!(iduser.equals("0"))); //el do while se recorrera hastra que el usuario ingrese 0.
        
        
        
    }
    
    
    
    public int buscarParticipante(String idu,ArrayList<Participante> listaP ){  //metodo para buscar participante en lista
        int posicion = -1; //se define una variable para asegurar la entrada al while
        int i = 0; // se inciializa variable a recorrer
        while(i<listaP.size() && posicion == -1){ //se verifica que el iterador no sea mayor que la lista y que la posicion sea -1 para seguir iterando, significando que aun no encuentra el objeto.
            if(listaP.get(i).getId().equals(idu)){ //si se encuentra el objeto con el mismo id que el ingresado por el usuario
                posicion = i; //se asigna la posicion como el iterador
                i++; //sigue al siguiente elemento
            }
            else{
                i++; //sigue al siguiente elemento.
            }
            
            
        }
        return posicion; //se retorna la posicion
    }
    
    public boolean verificarGanador(String id,Participante[] listaG){ // metodo para verificar si ganador esta en lista
        for(int z=0;z<listaG.length;z++){ // recorrer la lista por indices
            if(listaG[z] != null && listaG[z].getId().equals(id)){ //si el elemento (cuando se inicializa) es diferente de null y es igual a algun elemento en la lista significa que si esta en la lista
                return true; //se retorna true 
                
            }
        }
        return false; //se retorna false si no se cumple
        
    }
    
    
} //fin de actividad.java