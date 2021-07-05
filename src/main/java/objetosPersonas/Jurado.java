/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosPersonas;

/**
 *
 * @author gabri
 */
public class Jurado extends Participante {
    private String bio;
    
    public Jurado(){
        super();
        
    }
    public Jurado(String id, String nom, String bio){
        super(id,nom);
        this.bio = bio;
        
    }
    
    
}
