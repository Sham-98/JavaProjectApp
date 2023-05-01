package org.gpiste.javaprojectapp;

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

            battleResult += lutemonA.getName() + "(" + ") attack: " + lutemonA.getAttack() + "; def: "
            + lutemonA.getDefense() + "; exp: " + lutemonA.getExperience() + "; health: " + lutemonA.getHealth()
            + "/" + lutemonA.getMaxHealth() +"\n";

            System.out.println(lutemonA.getName() + "(" + ") attack: " + lutemonA.getAttack() + "; def: "
            + lutemonA.getDefense() + "; exp: " + lutemonA.getExperience() + "; health: " + lutemonA.getHealth()
            + "/" + lutemonA.getMaxHealth());


            if (lutemonB.getHealth() > 0) {

                battleResult += lutemonB.getName() + " manages to escape death.\n";

                System.out.println(lutemonB.getName() + " manages to escape death.");

                Lutemon temp = lutemonA;
                lutemonA = lutemonB;
                lutemonB = temp;
            } else {

                battleResult += lutemonB.getName() + " died.\n";

                System.out.println(lutemonB.getName() + " died.");

                lutemonA.gainExperience(1);
                getBattle().remove(lutemonB);
                lutemonB = null;
            }
        }
        if (lutemonA.getHealth() > 0) {

            battleResult += lutemonB.getName() + " wom the battle\n";

            System.out.println(lutemonA.getName() + " wom the battle");
        } else {

            battleResult += lutemonA.getName() + " lost the battle.\n";

            System.out.println(lutemonA.getName() + " lost the battle.");

            getBattle().remove(lutemonA);
            lutemonA = null;
        }
        return battleResult;
    }

}