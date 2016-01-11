      /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;
import java.util.*;

/**
 *
 * @author julitosnchez
 */
public abstract class BadConsequence {
    static final int MAXTREASURES = 10;
    private String text;
    private int levels;
    private boolean death;

    //Constructor 1
    public BadConsequence(String text,int levels){
        this.text = text;
        this.levels = levels;
        death = false;
    }
    
    //Obtener la descripcion del monstruo
    public String getText(){
        return text;
    }
    
    //Obtener niveles perdidos en caso de DERROTA
    public int getLevels(){
        return levels;
    }
    
    //Métood que comprueba SI HAY MAL ROLLO POR CUMPLIR
    public boolean isEmpty(){
        return levels == 0 && death == false;
    }
    
    public boolean getDeath(){
        return death;
    }
    
    //Método que SUBSTRAE un TESORO VISIBLE para cumplir MAL ROLLO.
    public abstract void substractVisibleTreasure(Treasure t);
    
    //]Método que SUBSTRAE un TESORO OCULTO para cumplir MAL ROLLO.
    public abstract void substractHiddenTreasure(Treasure t);
    
    //Método que AJUSTA el mal rollo a cumplir por el jugador, en función de sus POSIBILIDADES
    public abstract BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v,ArrayList<Treasure> h);
 
    @Override
    public String toString(){
        return "\n" + text + "\nNiveles Perdidos: "+levels;
    }
}


