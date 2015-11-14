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
public class Napakalaki {
    private static Napakalaki instance = null;
    private Monster currentMonster;
    private CardDealer dealer;
    private Player currentPlayer;
    private ArrayList<Player> players;
    
    private Napakalaki(){ }
    
    private void initPlayers(ArrayList<String> names){
        
        //Creamos array de jugadores
        players = new ArrayList();
        
        //Vamos añadiendo jugadores con un determinado nombre
        Player p;
        for (String name : names) {
            p = new Player(name);
            players.add(p);
        }
    }
    
    //Decide qué jugador es el siguiente en jugar.
    private Player nextPlayer(){
        if(players.get(0) == currentPlayer){
            Random r = new Random();
            return players.get(r.nextInt(players.size()));
        }
        else{
            boolean found = false;
            int index = 0;
            
            //Indice que devuelve la posicion en el array de la primera ocurrencia
            index = players.indexOf(currentPlayer);
     
            if(index == (players.size()-1))
                return players.get(0);
            else
                return players.get(index+1);
        }
            
    }
    private boolean nextTurnIsAllowed(){
        return currentPlayer.validState();
    }
    private void setEnemies(){
        //Random para asignar enemigos de manera aleatoria
        Random r = new Random();

        int index;

        for (int i = 0; i < players.size();) {
            index = r.nextInt(players.size());
            if(i != index){
                players.get(i).setEnemy(players.get(index));
                i++;
            }
            
        }
    }
    
    public static Napakalaki getInstance(){
        if(instance == null)
            instance = new Napakalaki();
    return instance;
    }
    public CombatResult developCombat(){
        
    }
    public void discardVisibleTreasures(ArrayList<Treasure> treasures){
        
    }
    public void discardHiddenTreasures(ArrayList<Treasure> treasures){
        
    }
    public void makeTreasuresVisible(ArrayList<Treasure> treasures){
        
    }
    public void initGame(ArrayList<String> players){
        
    }
    public Player getCurrentPlayer(){
        return currentPlayer;
    }
    public Monster getCurrentMonster(){
        return currentMonster;
    }
    public boolean nextTurn(){
        
    }
    public boolean endOfGame(CombatResult result){
        return result == CombatResult.WINGNAME;
    }
    
}
