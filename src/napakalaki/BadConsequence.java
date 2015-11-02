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
public class BadConsequence {
    private static final int MAXTREASURES = 10;
    private String text;
    private int levels;
    private int nVisibleTreasures;
    private int nHiddenTreasures;
    private boolean death;
    //Declaración de dos arrays que coleecionan objetos tipo 'TreasureKind'
    private ArrayList<TreasureKind>specificHiddenTreasures = new ArrayList();
    private ArrayList<TreasureKind>specificVisibleTreasures = new ArrayList();
    
    //Constructor 1
    public BadConsequence(String text,int levels,int nVisible,int nHidden){
        this.text = text;
        this.levels = levels;
        nVisibleTreasures = nVisible;
        nHiddenTreasures = nHidden;
    }
    //Constructor 2
    public BadConsequence(String text,boolean death){
        this.text = text;
        this.death = death;
    }
    //Constructor 3
    public BadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible, ArrayList<TreasureKind> tHidden){
        this.text = text;
        this.levels = levels;
        specificHiddenTreasures = tHidden;
        specificVisibleTreasures = tVisible;
    }
    
    public String getText(){
        return text;
    }
    
    public int getLevels(){
        return levels;
    }
    
    public int getNVisibleTreasures(){
        return nVisibleTreasures;
    }

    public int getNHiddenTreasures(){
        return nHiddenTreasures;
    }
    
    public ArrayList<TreasureKind> getSpecificHiddenTreasures(){
        return specificHiddenTreasures;
    }
    
    public ArrayList<TreasureKind> getSpecificVisibleTreasures(){
        return specificVisibleTreasures;
    }
    
    public boolean isEmpty(){
        if(levels == 0 && nVisibleTreasures == 0 && nHiddenTreasures == 0 && !death && specificHiddenTreasures.isEmpty() && specificVisibleTreasures.isEmpty())
            return true;
        return false;
    }
    
    public void substractVisibleTreasure(Treasure t){
        
    }
    
    public void substractHiddenTreasure(Treasure t){
        
    }
    
    public BadConsequence adjustToFitTreasureLists(Treasure v,ArrayList<Treasure> h)
    
    
    public boolean getDeath(){
        return death;
    }
    
    
    @Override
    public String toString(){
        return text + ", NivelesPerdidos = " + Integer.toString(levels) + ", TesorosVisibles = " + Integer.toString(nVisibleTreasures) + ", TesorosEscondidos = " + Integer.toString(nHiddenTreasures) + ", death = " + Boolean.toString(death) + ", Array de tesoros escondidos = " + specificHiddenTreasures.toString() + ", Array de tesoros visibles = " + specificVisibleTreasures.toString();
    }
}


