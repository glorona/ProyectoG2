package actividades;
import objetosPersonas.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Actividad {
    private static int contador = 1;
    private String id;
    private String fecha;
    private String hora;
    private String premio_1;
    private String premio_2;
    private String premio_3;
    protected ArrayList<Estudiante> listaParticipantes;
    protected Participante[] listaGanadores;
    
    
    public Actividad(){
        super();
        
    }
    

    public Actividad(String fecha, String hora, String premio_1, String premio_2, String premio_3) {
        super();
        Integer cod = new Integer(contador++);
        id =  Integer.toString(cod); //GENERA EL ID INMEDIATAMENTE
        this.fecha = fecha;
        this.hora = hora;
        this.premio_1 = premio_1;
        this.premio_2 = premio_2;
        this.premio_3 = premio_3;

        this.listaParticipantes = new ArrayList<>();
        this.listaGanadores = new Participante[3];
        
        
    }

    public String getId() {
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

    public ArrayList<Estudiante> getListaParticipantes() {
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

    @Override
    public String toString() {
        return  "Id=" + id + "  Fecha=" + fecha + "  Hora=" + hora;
    }
    
    
    
    public void menu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido, digite el numero de la opcion que desea");
        System.out.println("1. Carrera 5k");
        System.out.println("2. Competencia de bandas musciales");
        System.out.println("3. Torneo de Videojuegos");
        System.out.println("4. Salir");
        int seleccionUsuario = sc.nextInt();
        sc.nextLine();
        
    }
    
    public void registrarParticipante(ArrayList<Estudiante> listaE){
        String iduser;
        Scanner sc = new Scanner(System.in);
        do{
        System.out.println("Ingrese id del estudiante:");
        iduser = sc.nextLine();
        for(Estudiante e: listaE){
            if(e.getId().equals(iduser)){
                listaParticipantes.add(e);
                System.out.println("Estudiante" + e.getNombre() + " Registrado");
            }
        }
        } while(!(iduser.equals("0")));
        
        
        
    }
    
    public void registrarGanadores(ArrayList<Estudiante> listaE){
        String iduser;
        String lugar = "";
        int contador;
        contador = 1;
        Scanner sc = new Scanner(System.in);
        do{
        
        switch(contador){
            case 1:
                lugar = "Primer";
                break;
            case 2:
                lugar = "Segundo";
                break;
            case 3:
                lugar = "Tercer";
                
        }
        System.out.println("Ingreso de "+ lugar + " lugar");
        System.out.println("Ingrese id del estudiante:");
        iduser = sc.nextLine();
        for(Estudiante e: listaE){
            if(e.getId().equals(iduser)){
                float time;
                System.out.println("Ingrese tiempo ");
                time = sc.nextFloat();
                sc.nextLine();
                listaGanadores[contador-1] = new Participante5k(time,e.getId(),e.getNombre(),e.getGenero(),e.getCarrera());
                
            }
            else{
                System.out.println("Numero no valido.");
                registrarGanadores(listaE);
            }
                
            }
        contador++;
        } while(contador<4);
        
        
    }
    
}
