/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;

/**
 *
 * @author julitosnchez
 */
public class SpecificBadConsequence extends BadConsequence {
    //Declaración de dos arrays que coleecionan objetos tipo 'TreasureKind'
    private ArrayList<TreasureKind>specificHiddenTreasures = new ArrayList();
    private ArrayList<TreasureKind>specificVisibleTreasures = new ArrayList();

    //Constructor 3
    public SpecificBadConsequence(String text,int levels,ArrayList<TreasureKind> tVisible, ArrayList<TreasureKind> tHidden){
        super(text,levels);
        specificHiddenTreasures = tHidden;
        specificVisibleTreasures = tVisible;
    }
    
    //ARRIBA
    public ArrayList<TreasureKind> getSpecificHiddenTreasures(){
        return specificHiddenTreasures;
    }
    //ARRIBA
    public ArrayList<TreasureKind> getSpecificVisibleTreasures(){
        return specificVisibleTreasures;
    }
    
    @Override
    public boolean isEmpty(){
        return specificHiddenTreasures.isEmpty() && specificVisibleTreasures.isEmpty() && super.isEmpty();
    }
    
    //Método que SUBSTRAE un TESORO VISIBLE para cumplir MAL ROLLO.
    @Override
    public void substractVisibleTreasure(Treasure t){
            if(specificVisibleTreasures.contains(t.getType()))
                specificVisibleTreasures.remove(t.getType());
    }
    
    @Override
    public void substractHiddenTreasure(Treasure t){
            if(specificHiddenTreasures.contains(t.getType()))
                specificHiddenTreasures.remove(t.getType());
    }
    
    @Override
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v,ArrayList<Treasure> h)
    {
        BadConsequence bc = new SpecificBadConsequence(null,0, new ArrayList(), new ArrayList());
        ArrayList<TreasureKind> tkv = new ArrayList();
        ArrayList<TreasureKind> tkh = new ArrayList();
        
        for (int i = 0; i < v.size(); i++)
            tkv.add(v.get(i).getType());
        for (int i = 0; i < h.size(); i++)
            tkh.add(h.get(i).getType());
        
        ArrayList<TreasureKind> visibleTreasures = new ArrayList();
        ArrayList<TreasureKind> hiddenTreasures = new ArrayList();
            
            if(!this.specificVisibleTreasures.isEmpty()){
                for (TreasureKind specificVisibleTreasure : specificVisibleTreasures) {
                    if (tkv.contains(specificVisibleTreasure)) {
                        visibleTreasures.add(specificVisibleTreasure);
                    }
                }
                    
            }
            if(!this.specificHiddenTreasures.isEmpty()){
                for (TreasureKind specificHiddenTreasure : specificHiddenTreasures) {
                    if (tkh.contains(specificHiddenTreasure)) {
                        hiddenTreasures.add(specificHiddenTreasure);
                    }
                }
                    
            }
            bc = new SpecificBadConsequence(super.getText(),0,visibleTreasures,hiddenTreasures);
        
        return bc;
    }
    
    @Override
    public String toString(){
        return super.toString()+"\nArray de tesoros escondidos = " + specificHiddenTreasures.toString() + "\nArray de tesoros visibles = " + specificVisibleTreasures.toString();
    }


}
