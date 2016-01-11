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
public class Treasure {
    private String name;
    private int bonus;
    private TreasureKind type;
    
    public Treasure(String n,int bonus,TreasureKind t){
        name = n;
        this.bonus = bonus;
        type = t;
    }
    
    //NOMBRE DEL TESORO
    public String getName(){
        return name;
    }
    
    //BONUS que proporciona si lo tenemos VISIBLE
    public int getBonus(){
        return bonus;
    }
    
    //TIPO de tesoro
    public TreasureKind getType(){
        return type;
    }
    
    @Override
    public String toString(){
        return name+"["+type.toString()+"]"+"--bonus--> "+bonus;
    }
    
 }
