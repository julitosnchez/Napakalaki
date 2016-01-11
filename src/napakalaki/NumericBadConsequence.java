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
public class NumericBadConsequence extends BadConsequence {
    private int nVisibleTreasures;
    private int nHiddenTreasures;
    
       public NumericBadConsequence(String text,int levels,int nVisible,int nHidden){
        super(text,levels);
        nVisibleTreasures = nVisible;
        nHiddenTreasures = nHidden;
        }
       
    //Tesoros visibles a perder en caso de DERROTA
    public int getNVisibleTreasures(){
        return nVisibleTreasures;
    }
    
    //ARRIBA
    public int getNHiddenTreasures(){
        return nHiddenTreasures;
    }
    
    @Override
    public boolean isEmpty(){
        return nVisibleTreasures == 0 && nHiddenTreasures == 0 && super.isEmpty();
    }
    
    //Método que SUBSTRAE un TESORO VISIBLE para cumplir MAL ROLLO.

    @Override
    public void substractVisibleTreasure(Treasure t){
        if(nVisibleTreasures > 0)
            nVisibleTreasures--;
    }
    
    @Override
    public void substractHiddenTreasure(Treasure t){
        if(nHiddenTreasures > 0)
            nHiddenTreasures--;
    }
    
    @Override
    //Método que AJUSTA el mal rollo a cumplir por el jugador, en función de sus POSIBILIDADES
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v,ArrayList<Treasure> h)
    {
        BadConsequence bc = new NumericBadConsequence("",0,0,0);
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
                    nvisible = tkv.size();
                else
                    nvisible = this.nVisibleTreasures;
            }
            if(this.nHiddenTreasures > 0){
                if(this.nHiddenTreasures > tkh.size())
                    nhidden = tkh.size();
                else
                     nhidden = this.nHiddenTreasures;
            }
            bc = new NumericBadConsequence(super.getText(),0,nvisible,nhidden);
        }
        return bc;
    }
    
    @Override
    public String toString(){
        return super.toString()+"\nTesorosVisibles = " + Integer.toString(nVisibleTreasures) + "\nTesorosEscondidos = " + Integer.toString(nHiddenTreasures);
    }
}
