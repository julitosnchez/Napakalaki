/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;
import java.util.ArrayList;

/**
 *
 * @author JULIO
 */
public class CardDealer {
    private static CardDealer instance = null;
    private ArrayList<Monster> unusedMonsters;
    private ArrayList<Monster> usedMonsters;
    private ArrayList<Treasure> unusedTreasures;
    private ArrayList<Treasure> usedTreasures;
    
    private CardDealer(){
        unusedMonsters = new ArrayList();
        usedMonsters = new ArrayList();
        unusedTreasures = new ArrayList();
        usedTreasures = new ArrayList();
        
    }
    
    private void initTreasureCardDeck(){
        
    }
    
    private void initMonsterCardDeck(){
        
    }
    
    private void shuffleTreasures(){
        
    }
    
    private void shuffleMonsters(){
        
    }
    
    
    public static CardDealer getInstance(){
        if(instance == null)
            instance = new CardDealer();
        return instance;
    }
    
    public Treasure nextTreasure(){
        
    }
    
    public Monster nextMonster(){
        
    }
    
    public void giveTreasureBack(Treasure t){
        
    }
    
    public void giveMonsterBack(Monster m){
        
    }
    
    public void initCards(){
        
    }
    
}
