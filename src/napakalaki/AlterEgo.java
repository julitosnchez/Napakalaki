/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.*;

public class AlterEgo {

    public int nivelDeBondad;
    private ArrayList<Monster> monstruosAmigos = new ArrayList();
    private static final String descripcion = "Un alter ego es una personalidad alternativa y los monstruos tambien pueden tener amigos";
    
    AlterEgo(int bondad,ArrayList<Monster> amigos){
        nivelDeBondad = bondad;
        monstruosAmigos = amigos;
    }
    
    AlterEgo(int bondad){
        nivelDeBondad = bondad;
    }
    
    
    public int getNivelBondad(){
        return nivelDeBondad;
    }
    
    public String toString(){
        return "El nivel de bondad es " + Integer.toString(nivelDeBondad) + " y su numero de amigos es " + Integer.toString(monstruosAmigos.size());
    }
    
    
}
