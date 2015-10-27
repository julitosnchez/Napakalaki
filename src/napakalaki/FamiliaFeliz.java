/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;
import java.util.ArrayList;

/**
 *
 * @author julitosnchez
 */
public class FamiliaFeliz {
    private final int N_MAX_FAMILIARES = 5;
    private ArrayList<Monster> familia = new ArrayList();
    
    FamiliaFeliz(ArrayList<Monster> fam)
    {
      if(fam.size() < N_MAX_FAMILIARES)
          for (Monster fam1 : fam) {
              familia.add(fam1);
      }
      else
          for (int i = 0; i < N_MAX_FAMILIARES; i++)
              familia.add(fam.get(i));
    }
    
    void AniadeMonstruo(Monster m){
        if(familia.size() < N_MAX_FAMILIARES)
            familia.add(m);
    }
    
    double Media(){
        double suma = 0;
        for (int i = 0; i < familia.size(); i++)
            suma += familia.get(i).getCombatLevel();
    
    return suma/familia.size();
    }
}
