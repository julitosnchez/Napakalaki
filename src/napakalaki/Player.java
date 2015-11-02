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
public class Player {
    private static final int MAXLEVEL = 10;
    private String name;
    private int level;
    private boolean dead = true;
    private boolean canISteal = true;
    private Player enemy;
    private BadConsequence pendingBadConsequence;
    private ArrayList<Treasure> visibleTreasures;
    private ArrayList<Treasure> hiddenTreasures;
    
    
    public Player(String name){
        
    }
    public String getName(){
        
    }
    private void bringToLife(){
        
    }
    private int getCombatLevel(){
        
    }
    private void incrementLevels(int l){
        
    }
    private void decrementLevels(int l){
        
    }
    private void setPendingBadConsequence(BadConsequence b){
        
    }
    private void applyPrize(Monster m){
        
    }
    private void applyBadConsequence(Monster m){
        
    }
    private boolean canMakeTreasureVisible(Treasure t){
        
    }
    private int howManyVisibleTreasures(TreasureKind tKind){
        
    }
    private void dielfNoTreasures(){
        
    }
    public boolean isDead(){
        
    }
    public ArrayList<Treasure> getHiddenTreasures(){
        
    }
    public ArrayList<Treasure> getVisibleTreasures(){
        
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
        
    }
    public void initTreasures(){
        
    }
    public int getLevels(){
        
    }
    public Treasure stealTreasure(){
        
    }
    public void setEnemy(Player enemy){
        
    }
    private Treasure giveMeATreasure(){
        
    }
    public boolean canISteal(){
        
    }
    private boolean canYouGiveMeATreasure(){
        
    }
    private void haveStolen(){
        
    }
    public void discardAllTreasures(){
        
    }
}
