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
public class Jurado extends Participante {//Hago extends de la clase Padre Participante
    private String bio;//Agrego el atributo Biografia que describe la biografia de cada jurado
    
    public Jurado(){//Hago un super para usar el constructor de Participante
        super();
        
    }
    public Jurado(String id, String nom, String bio){//Uso el constructor del participante y agrego el atributo bio
        super(id,nom);
        this.bio = bio;
        
    }
    
    
}
