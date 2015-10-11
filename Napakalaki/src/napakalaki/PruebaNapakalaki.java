/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;
import java.util.*;

/**
 *
 * @author julitosnchez
 */
public class PruebaNapakalaki {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       ArrayList<Monster> monstruos = new ArrayList();
       
       BadConsequence bc;
       Prize prize;
       
       //Comenzamos a añadir monstruos
       //'EL REY ROSA'
       bc =  new BadConsequence("Pierdes 5 niveles y 3 tesoros visibles",5, 3, 0);
       prize = new Prize(4,2);
       
       monstruos.add(new Monster("El rey rosa",13,bc,prize));
       //ÁNGELES DE LA NOCHE IBICENCA
       bc = new BadConsequence("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta",0,new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
       prize = new Prize(4,1);
       
       monstruos.add(new Monster("Ángeles de la noche ibicenca",14,bc,prize));
       
       
    }
    
}
