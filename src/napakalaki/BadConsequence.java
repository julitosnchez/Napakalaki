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
    static final int MAXTREASURES = 10;
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
        levels = Player.MAXLEVEL;
        nVisibleTreasures = MAXTREASURES;
        nHiddenTreasures = MAXTREASURES;
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
        return levels == 0 && nVisibleTreasures == 0 && nHiddenTreasures == 0 && !death && specificHiddenTreasures.isEmpty() && specificVisibleTreasures.isEmpty();
    }
    
    public void substractVisibleTreasure(Treasure t){
        if(nVisibleTreasures > 0)
            nVisibleTreasures--;
        else{
            if(specificVisibleTreasures.contains(t.getType()))
                specificVisibleTreasures.remove(t.getType());
        }
    }
    
    public void substractHiddenTreasure(Treasure t){
        if(nHiddenTreasures > 0)
            nHiddenTreasures--;
        else{
            if(specificHiddenTreasures.contains(t.getType()))
                specificHiddenTreasures.remove(t.getType());
        }
    }
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v,ArrayList<Treasure> h)
    {
        BadConsequence bc;
        ArrayList<TreasureKind> tkv = new ArrayList();
        ArrayList<TreasureKind> tkh = new ArrayList();
        
        for (int i = 0; i < v.size(); i++)
            tkv.add(v.get(i).getType());
        for (int i = 0; i < h.size(); i++)
            tkh.add(h.get(i).getType());
        
        if(this.nHiddenTreasures != 0 || this.nVisibleTreasures != 0){
            int nvisible = 0;
            int nhidden = 0;
            if(this.nVisibleTreasures > 0){
                if(this.nVisibleTreasures > tkv.size())
                    nvisible = this.nVisibleTreasures;
                else
                    nvisible = tkv.size();
            }
            if(this.nHiddenTreasures > 0){
                if(this.nHiddenTreasures > tkh.size())
                    nhidden = this.nHiddenTreasures;
                else
                     nhidden = tkh.size();
            }
            bc = new BadConsequence(this.text,this.levels,nvisible,nhidden);
        }
        else{
            ArrayList<TreasureKind> visibleTreasures = new ArrayList();
            ArrayList<TreasureKind> hiddenTreasures = new ArrayList();
            
            if(!this.specificVisibleTreasures.isEmpty()){
                for (TreasureKind specificVisibleTreasure : specificVisibleTreasures) {
                    if (v.contains(specificVisibleTreasure)) {
                        visibleTreasures.add(specificVisibleTreasure);
                    }
                }
                    
            }
            if(!this.specificHiddenTreasures.isEmpty()){
                for (TreasureKind specificHiddenTreasure : specificHiddenTreasures) {
                    if (h.contains(specificHiddenTreasure)) {
                        hiddenTreasures.add(specificHiddenTreasure);
                    }
                }
                    
            }
            bc = new BadConsequence(this.text,this.levels,visibleTreasures,hiddenTreasures);
        }
        
        return bc;
        }
    
    
    public boolean getDeath(){
        return death;
    }
    
    
    @Override
    public String toString(){
        return text + ", NivelesPerdidos = " + Integer.toString(levels) + ", TesorosVisibles = " + Integer.toString(nVisibleTreasures) + ", TesorosEscondidos = " + Integer.toString(nHiddenTreasures) + ", death = " + Boolean.toString(death) + ", Array de tesoros escondidos = " + specificHiddenTreasures.toString() + ", Array de tesoros visibles = " + specificVisibleTreasures.toString();
    }
}


