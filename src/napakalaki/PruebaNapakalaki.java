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
       bc = new BadConsequence("Embobados con el lindo priminegio te descartas de tu casco visible",0,new ArrayList(Arrays.asList(TreasureKind.HELMET)),new ArrayList());
       prize = new Prize(1,1);
       monstruos.add(new Monster("Chibithulhu",2,bc,prize));
       
       //EL SOPOR DE DUNWICH
       bc = new BadConsequence("El primordial bostezo contagioso.Pierdes el calzado visible",0,new ArrayList(Arrays.asList(TreasureKind.SHOES)),new ArrayList());
       prize = new Prize(1,1);
       monstruos.add(new Monster("El sopor de Dunwich",2,bc,prize));
       
       //EL GORRÓN EN EL UMBRAL
       bc = new BadConsequence("Pierdes todos tus tesoros visibles",0,5,0);
       prize = new Prize(3,1);
       monstruos.add(new Monster("El gorrón en el umbral",10,bc,prize));
       
       //H.P.Munchcraft
       bc = new BadConsequence("Pierdes la armadura visible",0,new ArrayList(Arrays.asList(TreasureKind.ARMOR)),new ArrayList());
       prize = new Prize(2,1);
       monstruos.add(new Monster("H.P.Munchcraft",6,bc,prize));
       
       //BICHGOOTH
       bc = new BadConsequence("Sientes bichos bajo la ropa.Descarta la armadura visible",0,new ArrayList(Arrays.asList(TreasureKind.ARMOR)),new ArrayList());
       prize = new Prize(1,1);
       monstruos.add(new Monster("Bichgooth",2,bc,prize));
       
       //LA QUE REDACTA EN LAS TINIEBLAS
       bc = new BadConsequence("Toses los pulmones y pierdes 2 niveles",2,new ArrayList(),new ArrayList());
       prize = new Prize(1,1);
       monstruos.add(new Monster("La que redacata en las tinieblas", 2, bc, prize));
       
       //LOS HONDOS
       bc = new BadConsequence("Estos monstruos resultan bastante superficiales y te aburren mortalmente.Estas muerto",true);
       prize = new Prize(2,1);
       monstruos.add(new Monster("Los hondos",8, bc, prize));
       
       //SEMILLAS CTHULHU
       bc = new BadConsequence("Pierdes 2 niveles y 2 tesoros ocultos",2,0,2);
       prize = new Prize(2,1);
       monstruos.add(new Monster("Semillas Cthulhu",4,bc, prize));
       
       //DAMEARGO
       bc = new BadConsequence("Te intentas escaquear.Pierdes una mano visible",0,new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList());
       prize = new Prize(2,1);
       monstruos.add(new Monster("Dameargo",1,bc,prize));
       
       //POLLIPÓLIPO VOLANTE
       bc = new BadConsequence("Da mucho asquito.Pierdes 3 niveles",3, new ArrayList(), new ArrayList());
       prize = new Prize(1,1);
       monstruos.add(new Monster("Pollipólipo volante",2, bc, prize));
       
       //YSKHTIHYSSG-GOTH
       bc = new BadConsequence("No le hace gracia que pronuncien mal su nombre.Estas muerto", true);
       prize = new Prize(3,1);
       monstruos.add(new Monster("Yskhtihyssg-Goth",12, bc, prize));
       
       //FAMILIA FELIZ
       bc = new BadConsequence("La familia te atrapa.Estas muerto", true);
       prize = new Prize(4,1);
       monstruos.add(new Monster("Familia feliz",1, bc, prize));
       
       //ROBOGGOTH
       bc = new BadConsequence("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro de 2 manos visibles",2,new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)), new ArrayList());
       prize = new Prize(2,1);
       monstruos.add(new Monster("Roboggoth",8, bc, prize));
       
       //EL ESPIA
       bc = new BadConsequence("Te asusta en la noche.Pierdes un casco visible",0,new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList());
       prize = new Prize(1,1);
       monstruos.add(new Monster("El espia",5, bc, prize));
       
       //EL LENGUAS
       bc = new BadConsequence("Menudo susto te llevas.Pierdes 2 niveles y 5 tesoros visibles",2,5,0);
       prize = new Prize(1,1);
       monstruos.add(new Monster("El lenguas",20, bc, prize));
       
       //BICÉFALO
       bc = new BadConsequence("Te faltan manos para tanta cabeza.Pierdes 3 niveles y tus tesoros visibles de las manos",3,new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)), new ArrayList());
       prize = new Prize(1,1);
       monstruos.add(new Monster("Bicéfalo",20, bc, prize));
       
       
       //Muestra los monstruos con un nivel de combate > 10
       for (int i=0; i<monstruos.size(); i++) {
           if (monstruos.get(i).getCombatLevel() > 10){
               System.out.println(monstruos.get(i) + "\n" );
           }
           
       }

       //Mostramos monstruos que sólo tengan pérdida de niveles
       for (int i=0; i<monstruos.size(); i++){
           if(monstruos.get(i).getBC().getLevels()!=0 && monstruos.get(i).getBC().getDeath()==false && monstruos.get(i).getBC().getNHiddenTreasures() == 0 && monstruos.get(i).getBC().getNVisibleTreasures() == 0 && monstruos.get(i).getBC().getSpecificHiddenTreasures().isEmpty() && monstruos.get(i).getBC().getSpecificVisibleTreasures().isEmpty())
           {
               System.out.println(monstruos.get(i) + "\n");
           }
        }
       //Monstramos los monstruos cuyo mal rollo indique una ganancia de niveles superior a 1
       for (int i = 0; i < monstruos.size(); i++){
           if(monstruos.get(i).getPrize().getLevel() > 1)
               System.out.println(monstruos.get(i) + "\n");
                
        }
       //Monstramos monstruos cuyo mal rollo suponga la pérdida de un determinado tipo de tesoros ya sea visibles y/o ocultos
        for (int i = 0; i < monstruos.size(); i++){
           if(!monstruos.get(i).getBC().getSpecificHiddenTreasures().isEmpty() || !monstruos.get(i).getBC().getSpecificVisibleTreasures().isEmpty())
               System.out.println(monstruos.get(i) + "\n");
        }
      
   
    }
    
}