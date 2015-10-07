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
    
    public void Monster(String name,int level,BadConsequence bc,Prize price){
        this.name = name;
        combatLevel= level;
        this.bc = bc;
        this.price = price;
    }
    
    public String getName(){
        return name;
    }
    
    public int getCombatLevel(){
        return combatLevel;
    }
    
    public String toString(){
        return "NombreMonstruo = " + name + "NivelCombate = " + Integer.toString(combatLevel) + "precio = " + price.toString() + bc.toString();
    }
}
