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
public class DeathBadConsequence extends NumericBadConsequence {
     
    //Constructor
    public DeathBadConsequence(String text,boolean death){
        super(text,Player.MAXLEVEL,MAXTREASURES,MAXTREASURES);
        death = true;
    }

      @Override
    public String toString(){
        return super.toString()+Boolean.toString(super.getDeath());
    }
}