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
    private String text;
    private int levels;
    private int nVisibleTreasures;
    private int nHiddenTreasures;
    private boolean death;
    //Declaración de dos arrays que coleecionan objetos tipo 'TreasureKind'
    private ArrayList<TreasureKind>specificHiddenTreasures = new ArrayList();
    private ArrayList<TreasureKind>specificVisibleTreasures = new ArrayList();
    
    //Constructor 1
    public void BadConsequence(String text,int levels,int nVisible,int nHidden){
        this.text = text;
        this.levels = levels;
        nVisibleTreasures = nVisible;
        nHiddenTreasures = nHidden;
    }
    //Constructor 2
    public void BadConsequence(String text,boolean death){
        this.text = text;
        this.death = death;
    }
    //Constructor 3
    public void BadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible, ArrayList<TreasureKind> tHidden){
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
    
    public boolean getDeath(){
        return death;
    }
    
    public String toString(){
        return "text =" + text + ", levels =" + levels + ", nVisibleTreasures =" + nVisibleTreasures + ", nHiddenTreasures =" + nHiddenTreasures + ", death =" + death + ", specificHiddenTreasures =" + specificHiddenTreasures + ", specificVisibleTreasures =" + specificVisibleTreasures;
    }

}
