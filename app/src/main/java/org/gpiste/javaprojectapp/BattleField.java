package org.gpiste.javaprojectapp;

public class BattleField extends Storage {
    /*public void attack(Lutemon a, Lutemon b) {
        System.out.println("Taistelu alkaa!");
        System.out.println(a.getName() + " att: " + a.getAttack() + "; def: " + a.getDefense() + "; exp: " + a.getExperience() + "; health: " + a.getHealth() + "/" + a.getMaxHealth());
        System.out.println(b.getName() + " att: " + b.getAttack() + "; def: " + b.getDefense() + "; exp: " + b.getExperience() + "; health: " + b.getHealth() + "/" + b.getMaxHealth());

        while (a.getHealth() > 0 && b.getHealth() > 0) {
            b.defense(a.calculateDamage());
            if (b.getHealth() > 0) {
                System.out.println(b.getName() + " onnistui välttämään kuoleman.");
                Lutemon temp = a;
                a = b;
                b = temp;
            } else {
                System.out.println(b.getName() + " kuoli!");
                //a.addExperience(1);
                //storeLutemon(a);
                //removeLutemon(b.getId());
            }
        }

        System.out.println("Taistelu on ohi!");
    }*/
}