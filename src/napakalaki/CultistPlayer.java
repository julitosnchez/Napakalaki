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
public class CultistPlayer extends Player {
    private static int totalCultistPlayers = 0;
    private Cultist myCultistCard;
    
    public CultistPlayer(Player p,Cultist c){
        super(p);
        myCultistCard = c;
        totalCultistPlayers++;
    }


    @Override
    protected Treasure giveMeATreasure(){
        Random r = new Random();
        ArrayList<Treasure> vt = super.getVisibleTreasures();
        int index = r.nextInt()*vt.size();
        return vt.get(index);
    }
    
    @Override
    protected boolean canYouGiveMeATreasure(){
        return !super.enemy.getVisibleTreasures().isEmpty();
    }
    
    public static int getTotatlCultistPlayers(){
        return totalCultistPlayers;
    }
    
    @Override
    protected int getOponentLevel(Monster m){
        return m.getCombatLevelAgainstCultistPlayer();
    }
    
    @Override
    protected int getCombatLevel(){
        return (int) (super.getCombatLevel()+0.2*super.getCombatLevel()+myCultistCard.getGainedLevels()*totalCultistPlayers);
    }
    
}
