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
    
    //El jugador actual entra en combate con el monstruo que le ha tocado
    
    public CombatResult developCombat(){
        CombatResult result;
        result = currentPlayer.combat(currentMonster);
        dealer.giveMonsterBack(currentMonster);
        
        return result;
    }
    
    /*Operación encargada de eliminar los tesoros visibles indicados de la lista de tesoros   visibles del jugador. Al eliminar esos tesoros, si el jugador tiene un mal rollo pendiente, se
    indica a éste dicho descarte para su posible actualización. Finalmente, se invoca a
    dieIfNoTreasure() para comprobar si se ha quedado sin tesoros y en ese caso pasar a
    estado de muerto. Los tesoros descartados se devuelven al CardDealer*/
    public void discardVisibleTreasures(ArrayList<Treasure> treasures){
        Treasure treasure;
        for (int i = 0; i < treasures.size(); i++) {
            treasure = treasures.get(i);
            currentPlayer.discardVisibleTreasure(treasure);
            dealer.giveTreasureBack(treasure);
        }
    }
    //SIMILAR AL ANTERIOR
    public void discardHiddenTreasures(ArrayList<Treasure> treasures){
        Treasure treasure;
        for (int i = 0; i < treasures.size(); i++) {
            treasure = treasures.get(i);
            currentPlayer.discardHiddenTreasure(treasure);
            dealer.giveTreasureBack(treasure);
        }
    }
    /*Operación en la que se pide al jugador actual que pase tesoros ocultos a visibles, siempre
que pueda hacerlo según las reglas del juego*/
    
    public void makeTreasuresVisible(ArrayList<Treasure> treasures){
        Treasure t;
        for (int i = 0; i < treasures.size(); i++) {
            t = treasures.get(i);
            currentPlayer.makeTreasureVisible(t);
            
        }
    }
    
    /*Se encarga de solicitar a CardDealer la inicialización de los mazos de cartas de Tesoros
     y de Monstruos, de inicializar los jugadores proporcionándoles un nombre, asignarle a cada
     jugador su enemigo y de iniciar el juego con la llamada a nextTurn() para pasar al
     siguiente turno (que en este caso será el primero)*/
    
    public void initGame(ArrayList<String> players){
        this.initPlayers(players);
        this.setEnemies();
        dealer.initCards();
    }
    public Player getCurrentPlayer(){
        return currentPlayer;
    }
    public Monster getCurrentMonster(){
        return currentMonster;
    }
    
    //Verifica si el jugador activo cumple con las reglas del juego para terminar su turno
    
    public boolean nextTurn(){
        boolean stateOK;
        boolean dead;
        
        stateOK = this.nextTurnIsAllowed();
        
        if(stateOK){
            currentMonster = dealer.nextMonster();
            currentPlayer = this.nextPlayer();
            dead = currentPlayer.isDead();
            if(dead)
                currentPlayer.initTreasures();
        }
        
        return stateOK;
    }
    public boolean endOfGame(CombatResult result){
        return result == CombatResult.WINGNAME;
    }
    
}
