/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author julitosnchez
 */
public class Player {
    static final int MAXLEVEL = 10;
    private String name;
    private int level;
    private boolean dead = true;
    private boolean canISteal = true;
    //EXAM-INICIO
    //private Player enemy;
    private Dice dice;
    private BadConsequence pendingBadConsequence;
    private ArrayList<Treasure> visibleTreasures;
    private ArrayList<Treasure> hiddenTreasures;
    
    
    public Player(String name){
        
    }
    
    public int rollDice(){
        Random r = new Random();
        int n = r.nextInt(5)+1;
        return n;
    }
    public String getName(){
        return name;
    }
    private void bringToLife(){
        dead = false;
    }
    private int getCombatLevel(){
        int nivelCompleto = 0;
        for (int i = 0; i < visibleTreasures.size(); i++)
            nivelCompleto = nivelCompleto + visibleTreasures.get(i).getBonus();
        nivelCompleto = nivelCompleto + level;
        if(nivelCompleto > MAXLEVEL)
            return MAXLEVEL;
        else
            return nivelCompleto;
            
    }
    private void incrementLevels(int i){
        if(level+i < MAXLEVEL)
            level = level+i;
    }
    private void decrementLevels(int l){
        if(level-l > 1)
            level = level-l;
    }
    private void setPendingBadConsequence(BadConsequence b){
        pendingBadConsequence = b;
    }
    private void applyPrize(Monster m){
        
    }
    private void applyBadConsequence(Monster m){
        
    }
    private boolean canMakeTreasureVisible(Treasure t){
        
    }
    private int howManyVisibleTreasures(TreasureKind tKind){
        int contador = 0;
        for (int i = 0; i < visibleTreasures.size(); i++)
            if(visibleTreasures.get(i).getType() == tKind)
                contador++;
        return contador;
    }
    private void dielfNoTreasures(){
        if(visibleTreasures.isEmpty() && hiddenTreasures.isEmpty())
            dead = true;
    }
    public boolean isDead(){
        return dead;
    }
    public ArrayList<Treasure> getHiddenTreasures(){
        return hiddenTreasures;
    }
    public ArrayList<Treasure> getVisibleTreasures(){
        return visibleTreasures;
    }
    public CombatResult combat(Monster m){
        
    }
    public void makeTreasureVisible(Treasure t){
        
    }
    public void discardVisibleTreasure(Treasure t){
        
    }
    public void discardHiddenTreasure(Treasure t){
        
    }
    public boolean validState(){
        if(pendingBadConsequence.isEmpty() && hiddenTreasures.size() <= 4)
          return true;
    return false;
    }
        
    public void initTreasures(){
        
    }
    public int getLevels(){
        return level;
    }
    public Treasure stealTreasure(){
        
    }
  
    private Treasure giveMeATreasure(){
        
    }
    public boolean canISteal(){
        return canISteal;
    }
    private boolean canYouGiveMeATreasure(){
        return hiddenTreasures.isEmpty();
    }
    private void haveStolen(){
        canISteal = false;
    }
    public void discardAllTreasures(){
        
    }
}
