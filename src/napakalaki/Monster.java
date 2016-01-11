/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author julitosnchez
 */
public class Monster {
    private String name;
    private int combatLevel;
    private Prize price;
    private BadConsequence bc;
    private int levelChangeAgainstCultistPlayer;
    
    public Monster(String name,int level,BadConsequence bc,Prize price,int LC){
        this.name = name;
        combatLevel= level;
        this.bc = bc;
        this.price = price;
        this.levelChangeAgainstCultistPlayer = LC;
    }
    
    public String getName(){
        return name;
    }
    
    //NIVEL DE COMBATE DEL MONSTRUO
    public int getCombatLevel(){
        return combatLevel;
    }
    
    //MAL ROLLO A CUMPLIR DEL MONSTRUO EN CASO DE DERROTA
    public BadConsequence getBC(){
        return bc;
    }
    
    //NIVELES GANADOS SI DERROTAMOS AL MONSTRUO
    public int getLevelsGained(){
        return price.getLevel();
    }
    
    //TESOROS GANADOS SI DERROTAMOS AL MONSTRUO
    public int getTreasuresGained(){
        return price.getTreasures();
    }
    
    public int getCombatLevelAgainstCultistPlayer(){
        return combatLevel+levelChangeAgainstCultistPlayer;
    }
    
    
    @Override
    public String toString(){
        return "NombreMonstruo = " + name + "\nNivelCombate = " + Integer.toString(combatLevel) + "\nBUEN ROLLO" + price.toString() + "\nMAL ROLLO" + bc.toString();
    }
}
