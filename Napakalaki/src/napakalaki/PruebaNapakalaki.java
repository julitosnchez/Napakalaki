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
       
       //EL REY ROSA
       bc =  new BadConsequence("Pierdes 5 niveles y 3 tesoros visibles",5, 3, 0);
       prize = new Prize(4,2);
       monstruos.add(new Monster("El rey rosa",13,bc,prize));
       
       //ÁNGELES DE LA NOCHE IBICENCA
       bc = new BadConsequence("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta",0,new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
       prize = new Prize(4,1);
       monstruos.add(new Monster("Ángeles de la noche ibicenca",14,bc,prize));
       
       //3 BYAKHEES DE BONANZA
       bc = new BadConsequence("Pierdes tu armadura visible y otra oculta",0,new ArrayList(Arrays.asList(TreasureKind.ARMOR)),new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
       prize = new Prize(2,1);
       monstruos.add(new Monster("3 Byakhees de bonanza",8,bc,prize));
       
       //CHIBITHULHU
       bc = new BadConsequence("Embobados con el lindo priminegio te descartas de tu casco visible",0,new ArrayList(Arrays.asList(TreasureKind.HELMET)),null);
       prize = new Prize(1,1);
       monstruos.add(new Monster("Chibithulhu",2,bc,prize));
       
       //EL SOPOR DE DUNWICH
       bc = new BadConsequence("El primordial bostezo contagioso.Pierdes el calzado visible",0,new ArrayList(Arrays.asList(TreasureKind.SHOES)),null);
       prize = new Prize(1,1);
       monstruos.add(new Monster("El sopor de Dunwich",2,bc,prize));
       
       //EL GORRÓN EN EL UMBRAL
       bc = new BadConsequence("Pierdes todos tus tesoros visibles",0,new ArrayList(Arrays.asList(TreasureKind.ARMOR,TreasureKind.BOTHHANDS,TreasureKind.HELMET,TreasureKind.ONEHAND,TreasureKind.SHOES)),null);
       prize = new Prize(3,1);
       monstruos.add(new Monster("El gorrón en el umbral",10,bc,prize));
       
       //H.P.Munchcraft
       bc = new BadConsequence("Pierdes la armadura visible",0,new ArrayList(Arrays.asList(TreasureKind.ARMOR)),null);
       prize = new Prize(2,1);
       monstruos.add(new Monster("H.P.Munchcraft",6,bc,prize));
       
       
       
    }
    
}
