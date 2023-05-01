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

            battleResult += "1. " + lutemonA.getName() + "(" + lutemonA.getColor() + ") attack: " + lutemonA.getAttack() + "; def: "
                + lutemonA.getDefense() + "; exp: " + lutemonA.getExperience() + "; health: " + lutemonA.getHealth()
                + "/" + lutemonA.getMaxHealth() +"\n";

            battleResult += "2. " + lutemonB.getName() + "(" + lutemonB.getColor() + ") attack: " + lutemonB.getAttack() + "; def: "
                    + lutemonB.getDefense() + "; exp: " + lutemonB.getExperience() + "; health: " + lutemonB.getHealth()
                    + "/" + lutemonB.getMaxHealth() + "\n";

            int damage = lutemonA.getAttack() + lutemonA.getExperience();
            lutemonB.defende(damage);

            battleResult += lutemonA.getName() + " attacked " + lutemonB.getName() + " and dealt " + damage + " damage.\n\n";

            Lutemon temp = lutemonA;
            lutemonA = lutemonB;
            lutemonB = temp;

            if (lutemonB.getHealth() <= 0) {
                battleResult += lutemonB.getName() + " died.\n";
                lutemonA.gainExperience(1);
                removeDeadLutemon(lutemonB);
                lutemonB = null;
                break;
            }

            if (lutemonA.getHealth() <= 0) {
                battleResult += lutemonA.getName() + " died.\n";
                lutemonA.gainExperience(1);
                removeDeadLutemon(lutemonA);
                lutemonA = null;
                break;
            }
        }

        return battleResult;
    }
}