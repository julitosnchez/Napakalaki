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
        Treasure t;
    
        t = new Treasure("¡Si mi amo",4,TreasureKind.HELMET);
        unusedTreasures.add(t);
        
        t = new Treasure("Botas de investigacion",2,TreasureKind.SHOES);
        unusedTreasures.add(t);
        
        t = new Treasure("Capucha de Cthulhu",3,TreasureKind.HELMET);
        unusedTreasures.add(t);
        
        t = new Treasure("A prueba de babas",2,TreasureKind.ARMOR);
        unusedTreasures.add(t);
        
        t = new Treasure("Botas de lluvia acida",1,TreasureKind.BOTHHANDS);
        unusedTreasures.add(t);
        
        t = new Treasure("Casco minero",2,TreasureKind.HELMET);
        unusedTreasures.add(t);
        
        t = new Treasure("Ametralladora Thompson",4,TreasureKind.BOTHHANDS);
        unusedTreasures.add(t);
        
        t = new Treasure("Camiseta de la UGR",1,TreasureKind.ARMOR);
        unusedTreasures.add(t);
        
        t = new Treasure("Clavo de rail ferroviario",3,TreasureKind.ONEHAND);
        unusedTreasures.add(t);
        
        t = new Treasure("Cuchi de sushi arcano",2,TreasureKind.ONEHAND);
        unusedTreasures.add(t);
        
        t = new Treasure("Fez alopodo",3,TreasureKind.HELMET);
        unusedTreasures.add(t);
        
        t = new Treasure("Hacha prehistorica",2,TreasureKind.ONEHAND);
        unusedTreasures.add(t);
        
        t = new Treasure("El aparato del Pr. Tesla",4,TreasureKind.ARMOR);
        unusedTreasures.add(t);
        
        t = new Treasure("Gaita",4,TreasureKind.BOTHHANDS);
        unusedTreasures.add(t);
        
        t = new Treasure("Insecticida",2,TreasureKind.ONEHAND);
        unusedTreasures.add(t);
        
        t = new Treasure("Escopeta de 3 cañones",4,TreasureKind.BOTHHANDS);
        unusedTreasures.add(t);
        
        t = new Treasure("Garabato mistico",2,TreasureKind.ONEHAND);
        unusedTreasures.add(t);
        
        t = new Treasure("La rebeca metalica",2,TreasureKind.ARMOR);
        unusedTreasures.add(t);
        
        t = new Treasure("Lanzallamas",4,TreasureKind.BOTHHANDS);
        unusedTreasures.add(t);
        
        t = new Treasure("Necro-comicon",1,TreasureKind.ONEHAND);
        unusedTreasures.add(t);
        
        t = new Treasure("Necronomicon",5,TreasureKind.BOTHHANDS);
        unusedTreasures.add(t);
        
        t = new Treasure("Linterna a dos manos",3,TreasureKind.BOTHHANDS);
        unusedTreasures.add(t);
        
        t = new Treasure("Necro-gnmicon",2,TreasureKind.ONEHAND);
        unusedTreasures.add(t);
        
        t = new Treasure("Necrotelecom",2,TreasureKind.HELMET);
        unusedTreasures.add(t);
        
        t = new Treasure("Mazo de los antiguos",3,TreasureKind.ONEHAND);
        unusedTreasures.add(t);
        
        t = new Treasure("Necro-playboycon",3,TreasureKind.ONEHAND);
        unusedTreasures.add(t);
        
        t = new Treasure("Porra preternatural",2,TreasureKind.ONEHAND);
        unusedTreasures.add(t);
        
        t = new Treasure("Shogulador",1,TreasureKind.BOTHHANDS);
        unusedTreasures.add(t);
        
        t = new Treasure("Varita de atizamiento",3,TreasureKind.ONEHAND);
        unusedTreasures.add(t);
        
        t = new Treasure("Tentaculo de pega",2,TreasureKind.HELMET);
        unusedTreasures.add(t);
        
        t = new Treasure("Zapato deja-amigos",1,TreasureKind.SHOES);
        unusedTreasures.add(t);
        
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
