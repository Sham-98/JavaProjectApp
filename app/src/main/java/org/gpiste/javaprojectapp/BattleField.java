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

            battleResult += lutemonA.getName() + "(" + lutemonA.getColor() + ") hyökkäys: " + lutemonA.getAttack() + "; puolustus: "
                    + lutemonA.getDefense() + "; kokemus: " + lutemonA.getExperience() + "; elämä: " + lutemonA.getHealth()
                    + "/" + lutemonA.getMaxHealth() +"\n";

            battleResult += lutemonB.getName() + "(" + lutemonB.getColor() + ") hyökkäys: " + lutemonB.getAttack() + "; puolustus: "
                    + lutemonB.getDefense() + "; kokemus: " + lutemonB.getExperience() + "; elämä: " + lutemonB.getHealth()
                    + "/" + lutemonB.getMaxHealth() + "\n";

            lutemonB.defende(damage, defense);
            battleResult += lutemonA.getName() + " hyökkää " + lutemonB.getName() + ":n kimppuun ja aiheuttaa " + damage + " pistettä vahinkoa.\n";

            battleResult += lutemonB.getName() + " onnistui pakenemaan kuolemaa:\n\n";

            Lutemon temp = lutemonA;
            lutemonA = lutemonB;
            lutemonB = temp;

            if (lutemonB.getHealth() <= 0) {
                battleResult += lutemonB.getName() + " kuoli.\n";
                lutemonA.gainExperience(1);
                getInstance().removeDeadLutemon(lutemonB);
                getInstance().moveLutemon(lutemonA, getInstance().getBattle(), getInstance().getHome());
                lutemonB = null;
                break;
            }

            if (lutemonA.getHealth() <= 0) {
                battleResult += lutemonA.getName() + " kuoli.\n";
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
