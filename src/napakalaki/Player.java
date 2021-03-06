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
    private boolean dead;
    private boolean canISteal;
    protected Player enemy;
    private BadConsequence pendingBadConsequence;
    private ArrayList<Treasure> visibleTreasures;
    private ArrayList<Treasure> hiddenTreasures;
    
    
    public Player(String name){
        this.name = name;
        level = 1;
        dead = true;
        canISteal = true;
        visibleTreasures = new ArrayList();
        hiddenTreasures = new ArrayList();
    }
    
    public Player(Player p){
        this.name = p.name;
        this.level = p.level;
        this.dead = p.dead;
        this.canISteal = p.canISteal;
        this.enemy = p.enemy;
        this.pendingBadConsequence = p.pendingBadConsequence;
        this.visibleTreasures = p.visibleTreasures;
        this.hiddenTreasures = p.hiddenTreasures;
    }
    
    public BadConsequence getPendingBadConsequence() {
        return this.pendingBadConsequence;
    }
            
    
    protected int getOponentLevel(Monster m){
        return m.getCombatLevel();
    }
    
    protected Player Enemy(){
        return enemy;
    }
    
    protected boolean shouldConvert(){
        Dice dice = Dice.getInstance();
        return dice.nextNumber() == 1;
    }
    
    public String getName(){
        return name;
    }
    
    private void bringToLife(){
        dead = false;
    }
    
    protected int getCombatLevel(){
        int nivelCompleto = 0;
        for (int i = 0; i < visibleTreasures.size(); i++)
            nivelCompleto = nivelCompleto + visibleTreasures.get(i).getBonus();
        nivelCompleto = nivelCompleto + level;
        if(nivelCompleto > MAXLEVEL)
            return MAXLEVEL;
        else
            return nivelCompleto;
            
    }
    
    //INCREMENTEO nivel del jugador
    private void incrementLevels(int i){
        if(level+i < MAXLEVEL)
            level = level+i;
        else
            level = MAXLEVEL;
    }
    
    //DECREMENTO nivel del jugador
    private void decrementLevels(int l){
        if(level-l > 1)
            level = level-l;
        else
            level = 1;
    }
    //ASIGNA el mal rollo a cumplir por el jugador
    private void setPendingBadConsequence(BadConsequence b){
        pendingBadConsequence = b;
    }
    
    /*Esta operación es la encargada de aplicar el buen rollo del monstruo vencido al jugador,
      sumando los niveles correspondientes y pidiendo al CardDealer que le dé el número de
      tesoros indicado en el buen rollo del monstruo*/
    
    private void applyPrize(Monster m){
        int nLevels;
        int nTreasures;
        Treasure treasure;
        
        nLevels = m.getLevelsGained();
        this.incrementLevels(nLevels);
        nTreasures = m.getTreasuresGained();
        
        if(nTreasures > 0){
            CardDealer dealer = CardDealer.getInstance();
            for (int i = 0; i < nTreasures && hiddenTreasures.size()<4; i++) {
                treasure = dealer.nextTreasure();
                hiddenTreasures.add(treasure);
            }
        }
    }
    
    /*Cuando el jugador ha perdido el combate, hay que considerar el mal rollo que le impone el
      monstruo con el que combatió*/
    
    private void applyBadConsequence(Monster m){
        BadConsequence badConsequence,pendingBad;
        int nLevels;
        
        badConsequence = m.getBC();
        nLevels = badConsequence.getLevels();
        this.decrementLevels(nLevels);
        pendingBad = badConsequence.adjustToFitTreasureLists(visibleTreasures,hiddenTreasures);
        this.setPendingBadConsequence(pendingBad);
    }
    
    //MÉTODO QUE VERIFICA SI PODEMOS EQUIPARNOS UN TESORO ¡VISIBLE! DE LOS QUE TENEMOS OCULTOS
    private boolean canMakeTreasureVisible(Treasure t){
        if(t.getType() == TreasureKind.ONEHAND){
            return howManyVisibleTreasures(t.getType()) != 2 && howManyVisibleTreasures(TreasureKind.BOTHHANDS) == 0;
        }
        if(t.getType() == TreasureKind.BOTHHANDS){
            return howManyVisibleTreasures(TreasureKind.ONEHAND) == 0 && howManyVisibleTreasures(TreasureKind.BOTHHANDS) == 0;
            }
        return howManyVisibleTreasures(t.getType()) == 0;
    }
    
    //MÉTODO que cuenta NUMERO TESOROS VISIBLES DE un tipo TREASUREKIND
    private int howManyVisibleTreasures(TreasureKind tKind){
        int contador = 0;
        for (int i = 0; i < visibleTreasures.size(); i++)
            if(visibleTreasures.get(i).getType() == tKind)
                contador++;
        return contador;
    }
    
    //COMPRUEBA si el jugador ha MUERTO
    private void dielfNoTreasures(){
        if(visibleTreasures.isEmpty() && hiddenTreasures.isEmpty())
            dead = true;
    }
    
    //CONSULTOR
    public boolean isDead(){
        return dead;
    }
    
    public ArrayList<Treasure> getHiddenTreasures(){
        return hiddenTreasures;
    }
    
    public ArrayList<Treasure> getVisibleTreasures(){
        return visibleTreasures;
    }
    
    //Método para que el jugador COMBATA contra el monstruo M 
    public CombatResult combat(Monster m){
        int myLevel = this.getCombatLevel();
        int monsterLevel = this.getOponentLevel(m);
        CombatResult combatResult;
        
        if(myLevel > monsterLevel){
            this.applyPrize(m);
            if(this.level >= MAXLEVEL)
                combatResult = CombatResult.WINGNAME;
            else{
                 combatResult = CombatResult.WIN;
            }
        }
        else{
            this.applyBadConsequence(m);
            boolean sc = this.shouldConvert();
            if(sc)
                combatResult = CombatResult.LOSEANDCONVERT;
            else
                combatResult = CombatResult.LOSE;
        }
        return combatResult;
    }
    
    //Método para hacer un TESORO VISIBLE (en caso de que se pueda)
    public void makeTreasureVisible(Treasure t){
        boolean canI;
        
        canI = this.canMakeTreasureVisible(t);
        
        if(canI){
            visibleTreasures.add(t);
            hiddenTreasures.remove(t);
        }
    }
    
    public void discardVisibleTreasure(Treasure t){
        visibleTreasures.remove(t);
        if(pendingBadConsequence!= null)
            if(!pendingBadConsequence.isEmpty())
                pendingBadConsequence.substractVisibleTreasure(t);
        this.dielfNoTreasures();
    }
    
    
    public void discardHiddenTreasure(Treasure t){
        hiddenTreasures.remove(t);
        if(pendingBadConsequence!= null)
             if(!pendingBadConsequence.isEmpty())
                pendingBadConsequence.substractHiddenTreasure(t);
        this.dielfNoTreasures();
    }
    
    //MÉTODO QUE devuelve si estamos en ESTADO PARA CAMBIAR DE TURNO
    public boolean validState(){
        if(pendingBadConsequence == null || (pendingBadConsequence.isEmpty() &&  hiddenTreasures.size() <= 4))
          return true;
    return false;
    }
    
    /*Cuando un jugador está en su primer turno o se ha quedado sin tesoros, hay que
      proporcionarle nuevos tesoros para que pueda seguir jugando*/
    
    public void initTreasures(){
        CardDealer dealer;
        Dice dice;
        Treasure treasure;
        int number;
        
        dealer = CardDealer.getInstance();
        dice = Dice.getInstance();
        this.bringToLife();
        treasure = dealer.nextTreasure();
        hiddenTreasures.add(treasure);
        number = dice.nextNumber();
        
        if(number > 1){
            treasure = dealer.nextTreasure();
            hiddenTreasures.add(treasure);
        }
        
        if(number == 6){
            treasure = dealer.nextTreasure();
            hiddenTreasures.add(treasure);
        }
    }
    
    public int getLevels(){
        return level;
    }
    
    /*Cuando el jugador decide robar un tesoro a su enemigo, este método comprueba que
      puede hacerlo (sólo se puede robar un tesoro durante la partida) y que su enemigo tiene
      tesoros ocultos para ser robados (canYouGiveMeATreasure())*/
    
    public Treasure stealTreasure(){
        boolean canI,canYou;
        Treasure treasure = null;
        
        canI = this.canISteal();
        if(canI){
            canYou = enemy.canYouGiveMeATreasure();
            if(canYou){
                treasure = enemy.giveMeATreasure();
                hiddenTreasures.add(treasure);
                this.haveStolen();
            }
        }
    return treasure;
    }
    
    public void setEnemy(Player enemy){
        this.enemy = enemy;
    }
    
    //Devuelve un tesoro elegido al azar de entre los tesoros ocultos del jugador
    protected Treasure giveMeATreasure(){
        Random r = new Random();
        int x = r.nextInt(hiddenTreasures.size());
        Treasure t = hiddenTreasures.get(x);
        hiddenTreasures.remove(x);
        
        
        return t;
    }
    
    public boolean canISteal(){
        return canISteal;
    }
    protected boolean canYouGiveMeATreasure(){
        return hiddenTreasures.isEmpty() == false;
    }
    private void haveStolen(){
        canISteal = false;
    }
    
    //El jugador se descarta de todos sus tesoros ocultos y visibles.
    
    public void discardAllTreasures(){
        ArrayList<Treasure> vt = visibleTreasures;
        ArrayList<Treasure> ht = hiddenTreasures;
        
        int sizevt = vt.size();
        int sizeht = ht.size();
        
        for (int i = 0; i < sizevt; i++)
            this.discardVisibleTreasure(vt.get(0));
        for (int i = 0; i < sizeht; i++)
            this.discardHiddenTreasure(ht.get(0));
    }

    @Override
    public String toString(){
        return name + ", con nivel "+this.level;
    }
    
}
