/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author julitosnchez
 */
public class CardDealer {
    
    //Atributos
    private static  CardDealer instance = null;
    private ArrayList<Monster> unusedMonsters;
    private ArrayList<Monster> usedMonsters;
    private ArrayList<Treasure> unusedTreasures;
    private ArrayList<Treasure> usedTreasures;
    private ArrayList<Cultist> unusedCultists;
    
    //Constructor
    private CardDealer(){
        unusedMonsters = new ArrayList();
        usedMonsters = new ArrayList();
        unusedTreasures = new ArrayList();
        usedTreasures = new ArrayList();
        unusedCultists = new ArrayList();
        
    }
    
    public static CardDealer getInstance(){
        if(instance == null)
            instance = new CardDealer();
       return instance;
    }
    
    private void shuffleCultists(){
        
    }
    
    private void initCultistCardDeck(){
        Cultist c;
        
        //Inicializamos las cartas de Sectarios
        c = new Cultist("Sectario1",1);
        unusedCultists.add(c);
        
        c = new Cultist("Sectario2",1);
        unusedCultists.add(c);
        
        c = new Cultist("Sectario3",1);
        unusedCultists.add(c);
        
        c = new Cultist("Sectario4",1);
        unusedCultists.add(c);
        
        c = new Cultist("Sectario5",1);
        unusedCultists.add(c);
        
        c = new Cultist("Sectario6",1);
        unusedCultists.add(c);
    }
    
    public Cultist nextCultist(){
        
    }
    
    //Metodos
    private void initTreasureCardDeck(){
        Treasure t;
    
        t = new Treasure("¡Si mi amo",4,TreasureKind.HELMET);
        unusedTreasures.add(t);
        
        t = new Treasure("Botas de investigacion",2,TreasureKind.SHOES);
        unusedTreasures.add(t);
        
        t = new Treasure("Capucha de Cthulhu",3,TreasureKind.HELMET);
        unusedTreasures.add(t);
        
        t = new Treasure("A prueba de babas",2,TreasureKind.ARMOR);
        unusedTreasures.add(t);
        
        t = new Treasure("Botas de lluvia acida",1,TreasureKind.BOTHHANDS);
        unusedTreasures.add(t);
        
        t = new Treasure("Casco minero",2,TreasureKind.HELMET);
        unusedTreasures.add(t);
        
        t = new Treasure("Ametralladora Thompson",4,TreasureKind.BOTHHANDS);
        unusedTreasures.add(t);
        
        t = new Treasure("Camiseta de la UGR",1,TreasureKind.ARMOR);
        unusedTreasures.add(t);
        
        t = new Treasure("Clavo de rail ferroviario",3,TreasureKind.ONEHAND);
        unusedTreasures.add(t);
        
        t = new Treasure("Cuchi de sushi arcano",2,TreasureKind.ONEHAND);
        unusedTreasures.add(t);
        
        t = new Treasure("Fez alopodo",3,TreasureKind.HELMET);
        unusedTreasures.add(t);
        
        t = new Treasure("Hacha prehistorica",2,TreasureKind.ONEHAND);
        unusedTreasures.add(t);
        
        t = new Treasure("El aparato del Pr. Tesla",4,TreasureKind.ARMOR);
        unusedTreasures.add(t);
        
        t = new Treasure("Gaita",4,TreasureKind.BOTHHANDS);
        unusedTreasures.add(t);
        
        t = new Treasure("Insecticida",2,TreasureKind.ONEHAND);
        unusedTreasures.add(t);
        
        t = new Treasure("Escopeta de 3 cañones",4,TreasureKind.BOTHHANDS);
        unusedTreasures.add(t);
        
        t = new Treasure("Garabato mistico",2,TreasureKind.ONEHAND);
        unusedTreasures.add(t);
        
        t = new Treasure("La rebeca metalica",2,TreasureKind.ARMOR);
        unusedTreasures.add(t);
        
        t = new Treasure("Lanzallamas",4,TreasureKind.BOTHHANDS);
        unusedTreasures.add(t);
        
        t = new Treasure("Necro-comicon",1,TreasureKind.ONEHAND);
        unusedTreasures.add(t);
        
        t = new Treasure("Necronomicon",5,TreasureKind.BOTHHANDS);
        unusedTreasures.add(t);
        
        t = new Treasure("Linterna a dos manos",3,TreasureKind.BOTHHANDS);
        unusedTreasures.add(t);
        
        t = new Treasure("Necro-gnmicon",2,TreasureKind.ONEHAND);
        unusedTreasures.add(t);
        
        t = new Treasure("Necrotelecom",2,TreasureKind.HELMET);
        unusedTreasures.add(t);
        
        t = new Treasure("Mazo de los antiguos",3,TreasureKind.ONEHAND);
        unusedTreasures.add(t);
        
        t = new Treasure("Necro-playboycon",3,TreasureKind.ONEHAND);
        unusedTreasures.add(t);
        
        t = new Treasure("Porra preternatural",2,TreasureKind.ONEHAND);
        unusedTreasures.add(t);
        
        t = new Treasure("Shogulador",1,TreasureKind.BOTHHANDS);
        unusedTreasures.add(t);
        
        t = new Treasure("Varita de atizamiento",3,TreasureKind.ONEHAND);
        unusedTreasures.add(t);
        
        t = new Treasure("Tentaculo de pega",2,TreasureKind.HELMET);
        unusedTreasures.add(t);
        
        t = new Treasure("Zapato deja-amigos",1,TreasureKind.SHOES);
        unusedTreasures.add(t);
        
        shuffleTreasures();
        
}
    
    private void initMonsterCardDeck(){
        
        BadConsequence bc;
        Prize prize;
        
        //EL REY ROSA
       bc =  new BadConsequence("Pierdes 5 niveles y 3 tesoros visibles",5, 3, 0);
       prize = new Prize(4,2);
       unusedMonsters.add(new Monster("El rey rosa",13,bc,prize,0));
       
       //ÁNGELES DE LA NOCHE IBICENCA
       bc = new BadConsequence("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta",0,new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
       prize = new Prize(4,1);
       unusedMonsters.add(new Monster("Ángeles de la noche ibicenca",14,bc,prize,0));
       
      
       
       //3 BYAKHEES DE BONANZA
       bc = new BadConsequence("Pierdes tu armadura visible y otra oculta",0,new ArrayList(Arrays.asList(TreasureKind.ARMOR)),new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
       prize = new Prize(2,1);
       unusedMonsters.add(new Monster("3 Byakhees de bonanza",8,bc,prize,0));
       
       //CHIBITHULHU
       bc = new BadConsequence("Embobados con el lindo priminegio te descartas de tu casco visible",0,new ArrayList(Arrays.asList(TreasureKind.HELMET)),new ArrayList());
       prize = new Prize(1,1);
       unusedMonsters.add(new Monster("Chibithulhu",2,bc,prize,0));
       
       //EL SOPOR DE DUNWICH
       bc = new BadConsequence("El primordial bostezo contagioso.Pierdes el calzado visible",0,new ArrayList(Arrays.asList(TreasureKind.SHOES)),new ArrayList());
       prize = new Prize(1,1);
       unusedMonsters.add(new Monster("El sopor de Dunwich",2,bc,prize,0));
       
       //EL GORRÓN EN EL UMBRAL
       bc = new BadConsequence("Pierdes todos tus tesoros visibles",0,BadConsequence.MAXTREASURES,0);
       prize = new Prize(3,1);
       unusedMonsters.add(new Monster("El gorrón en el umbral",10,bc,prize,0));
       
       //H.P.Munchcraft
       bc = new BadConsequence("Pierdes la armadura visible",0,new ArrayList(Arrays.asList(TreasureKind.ARMOR)),new ArrayList());
       prize = new Prize(2,1);
       unusedMonsters.add(new Monster("H.P.Munchcraft",6,bc,prize,0));
       
       //BICHGOOTH
       bc = new BadConsequence("Sientes bichos bajo la ropa.Descarta la armadura visible",0,new ArrayList(Arrays.asList(TreasureKind.ARMOR)),new ArrayList());
       prize = new Prize(1,1);
       unusedMonsters.add(new Monster("Bichgooth",2,bc,prize,0));
       
       //LA QUE REDACTA EN LAS TINIEBLAS
       bc = new BadConsequence("Toses los pulmones y pierdes 2 niveles",2,new ArrayList(),new ArrayList());
       prize = new Prize(1,1);
       unusedMonsters.add(new Monster("La que redacata en las tinieblas", 2, bc, prize,0));
       
       //LOS HONDOS
       bc = new BadConsequence("Estos monstruos resultan bastante superficiales y te aburren mortalmente.Estas muerto",true);
       prize = new Prize(2,1);
       unusedMonsters.add(new Monster("Los hondos",8, bc, prize,0));
       
       //SEMILLAS CTHULHU
       bc = new BadConsequence("Pierdes 2 niveles y 2 tesoros ocultos",2,0,2);
       prize = new Prize(2,1);
       unusedMonsters.add(new Monster("Semillas Cthulhu",4,bc, prize,0));
       
       //DAMEARGO
       bc = new BadConsequence("Te intentas escaquear.Pierdes una mano visible",0,new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList());
       prize = new Prize(2,1);
       unusedMonsters.add(new Monster("Dameargo",1,bc,prize,0));
       
       //POLLIPÓLIPO VOLANTE
       bc = new BadConsequence("Da mucho asquito.Pierdes 3 niveles",3, new ArrayList(), new ArrayList());
       prize = new Prize(1,1);
       unusedMonsters.add(new Monster("Pollipólipo volante",2, bc, prize,0));
       
       //YSKHTIHYSSG-GOTH
       bc = new BadConsequence("No le hace gracia que pronuncien mal su nombre.Estas muerto", true);
       prize = new Prize(3,1);
       unusedMonsters.add(new Monster("Yskhtihyssg-Goth",12, bc, prize,0));
       
       //FAMILIA FELIZ
       bc = new BadConsequence("La familia te atrapa.Estas muerto", true);
       prize = new Prize(4,1);
       unusedMonsters.add(new Monster("Familia feliz",1, bc, prize,0));
       
       //ROBOGGOTH
       bc = new BadConsequence("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro de 2 manos visibles",2,new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)), new ArrayList());
       prize = new Prize(2,1);
       unusedMonsters.add(new Monster("Roboggoth",8, bc, prize,0));
       
       //EL ESPIA
       bc = new BadConsequence("Te asusta en la noche.Pierdes un casco visible",0,new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList());
       prize = new Prize(1,1);
       unusedMonsters.add(new Monster("El espia",5, bc, prize,0));
       
       //EL LENGUAS
       bc = new BadConsequence("Menudo susto te llevas.Pierdes 2 niveles y 5 tesoros visibles",2,5,0);
       prize = new Prize(1,1);
       unusedMonsters.add(new Monster("El lenguas",20, bc, prize,0));
       
       //BICÉFALO
       bc = new BadConsequence("Te faltan manos para tanta cabeza.Pierdes 3 niveles y tus tesoros visibles de las manos",3,new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)), new ArrayList());
       prize = new Prize(1,1);
       unusedMonsters.add(new Monster("Bicéfalo",20, bc, prize,0));
       
       shuffleMonsters();
    }
    
    private void shuffleTreasures(){
        
        //Generamos posicion aleatoria y hacemos intercambio, así conseguimos barajar
        Random rnd = new Random();
        int x;
        Treasure aux;
	for (int i = 0; i < unusedTreasures.size(); i++) {
        	x = (int)(rnd.nextDouble()*unusedTreasures.size());
                aux = new Treasure(unusedTreasures.get(i).getName(),unusedTreasures.get(i).getBonus(),unusedTreasures.get(i).getType());
                unusedTreasures.set(i, unusedTreasures.get(x));
                unusedTreasures.set(x, aux);
    	}
    }
    
    private void shuffleMonsters(){
        
        //Generamos posicion aleatoria y hacemos intercambio, así conseguimos barajar
        Random rnd = new Random();
        int x;
        Monster aux;
	for (int i = 0; i < unusedMonsters.size(); i++) {
        	x = (int)(rnd.nextDouble()*unusedMonsters.size());
                Prize p = new Prize(unusedMonsters.get(i).getTreasuresGained(),unusedMonsters.get(i).getLevelsGained());
                aux = new Monster(unusedMonsters.get(i).getName(),unusedMonsters.get(i).getCombatLevel(),unusedMonsters.get(i).getBC(),p,unusedMonsters.get(i).getCombatLevelAgainstCultistPlayer());
                unusedMonsters.set(i, unusedMonsters.get(x));
                unusedMonsters.set(x, aux);
    	}
    }
    
    public Treasure nextTreasure(){
     if(unusedTreasures.isEmpty()){
         for(Treasure treasures : usedTreasures){
             //Pasamos el mazo de descartes al mazo de tesoros
             unusedTreasures.add(treasures);
         }
         //Barajamos
         shuffleTreasures();
         
         //Limpiamos el mazo de descartes
         usedTreasures.clear();
     }
     
     //Obtenemos la primera carta del mazo
     Treasure t = unusedTreasures.get(0);
     
     //Los agregamos al mazo de descartes
     usedTreasures.add(t);
     
     //Lo eliminamos del mazo de tesoros
     unusedTreasures.remove(t);
     
     return t;
    }
    
    public Monster nextMonster(){
       if(unusedMonsters.isEmpty()){
         for(Monster monsters : usedMonsters){
             //Pasamos el mazo de descartes al mazo de monstruos
             unusedMonsters.add(monsters);
         }
         //Barajamos
         shuffleMonsters();
         
         //Limpiamos el mazo de descartes
         usedMonsters.clear();
     }
     
     //Obtenemos la primera carta del mazo
     Monster m = unusedMonsters.get(0);
     
     //Los agregamos al mazo de descartes
     usedMonsters.add(m);
     
     //Lo eliminamos del mazo de tesoros
     unusedMonsters.remove(m);
     
     return m;
    }
    
    public void giveTreasureBack(Treasure t){
        
        usedTreasures.add(t);
    }
    
    public void giveMonsterBack(Monster m){
        usedMonsters.add(m);
    }
    
    public void initCards(){
        this.initMonsterCardDeck();
        this.initTreasureCardDeck();
        this.initCultistCardDeck();
    }
    
}
