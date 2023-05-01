package org.gpiste.javaprojectapp;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.Scanner;

public class BattleField extends Storage {
    private Lutemon lutemonA;
    private Lutemon lutemonB;
    public BattleField(ArrayList<Lutemon> lutemons, int selectedLutemonA, int selectedLutemonB) {
        lutemonA = lutemons.get(selectedLutemonA);
        lutemonB = lutemons.get(selectedLutemonB);
    }
    public String startBattle() {
        String battleResult = "";
        while (lutemonA.getHealth() > 0 && lutemonB.getHealth() > 0) {

            /*battleResult += lutemonA.getName() + "(" + ") attack: " + lutemonA.getAttack() + "; def: "
                + lutemonA.getDefense() + "; exp: " + lutemonA.getExperience() + "; health: " + lutemonA.getHealth()
                + "/" + lutemonA.getMaxHealth() +"\n";*/

            System.out.println(lutemonA.getName() + "(" + ") attack: " + lutemonA.getAttack() + "; def: "
                    + lutemonA.getDefense() + "; exp: " + lutemonA.getExperience() + "; health: " + lutemonA.getHealth()
                    + "/" + lutemonA.getMaxHealth());

            System.out.println(lutemonB.getName() + "(" + ") attack: " + lutemonB.getAttack() + "; def: "
                    + lutemonB.getDefense() + "; exp: " + lutemonB.getExperience() + "; health: " + lutemonB.getHealth()
                    + "/" + lutemonB.getMaxHealth());

            int damage = lutemonA.getAttack() + lutemonA.getExperience();
            lutemonB.defende(damage);

            //battleResult += lutemonA.getName() + " attacked " + lutemonB.getName() + " and dealt " + damage + " damage.\n";
            System.out.println(lutemonA.getName() + " attacked " + lutemonB.getName() + " and dealt " + damage + " damage.");

            if (lutemonB.getHealth() <= 0) {
                battleResult += lutemonB.getName() + " died.\n";
                System.out.println(lutemonB.getName() + " died.");
                lutemonA.gainExperience(1);
                getBattle().remove(lutemonB);
                lutemonB = null;
                break;
            }
        }

        return battleResult;
    }
}