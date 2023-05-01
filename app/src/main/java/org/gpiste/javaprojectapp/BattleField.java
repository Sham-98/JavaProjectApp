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
            int damage = lutemonA.getAttack() + lutemonA.getExperience();
            int defense = lutemonB.getDefense();

            battleResult += lutemonA.getName() + "(" + lutemonA.getColor() + ") attack: " + lutemonA.getAttack() + "; def: "
                    + lutemonA.getDefense() + "; exp: " + lutemonA.getExperience() + "; health: " + lutemonA.getHealth()
                    + "/" + lutemonA.getMaxHealth() +"\n";

            battleResult += lutemonB.getName() + "(" + lutemonB.getColor() + ") attack: " + lutemonB.getAttack() + "; def: "
                    + lutemonB.getDefense() + "; exp: " + lutemonB.getExperience() + "; health: " + lutemonB.getHealth()
                    + "/" + lutemonB.getMaxHealth() + "\n";

            lutemonB.defende(damage, defense);
            battleResult += lutemonA.getName() + " attacked " + lutemonB.getName() + " and dealt " + damage + " damage.\n\n";

            Lutemon temp = lutemonA;
            lutemonA = lutemonB;
            lutemonB = temp;

            if (lutemonB.getHealth() <= 0) {
                battleResult += lutemonB.getName() + " died.\n";
                lutemonA.gainExperience(1);
                getInstance().removeDeadLutemon(lutemonB);
                getInstance().moveLutemon(lutemonA, getInstance().getBattle(), getInstance().getHome());
                lutemonB = null;
                break;
            }

            if (lutemonA.getHealth() <= 0) {
                battleResult += lutemonA.getName() + " died.\n";
                lutemonB.gainExperience(1);
                getInstance().removeDeadLutemon(lutemonA);
                getInstance().moveLutemon(lutemonB, getInstance().getBattle(), getInstance().getHome());
                lutemonA = null;
                break;
            }
        }

        return battleResult;
    }
}
