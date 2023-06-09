package org.gpiste.javaprojectapp;

import java.io.Serializable;
import java.util.Date;
import java.util.Random;

public class Lutemon implements Serializable {
    private String name;
    private String color;
    private int attack;
    private int defense;
    private int experience;
    private int health;
    private int maxHealth;
    protected int image;
    public Lutemon(String name, String color, int attack, int defense, int experience, int health, int maxHealth) {
        this.name = name;
        this.color = color;
        this.attack = attack;
        this.defense = defense;
        this.experience = experience;
        this.health = health;
        this.maxHealth = maxHealth;
    }
    public String getName() {
        return name;
    }
    public String getColor() {
        return color;
    }
    public int getAttack() {
        return attack;
    }
    public int getDefense() {
        return defense;
    }
    public int getExperience() {
        return experience;
    }
    public int getHealth() {
        return health;
    }
    public int getMaxHealth() {
        return maxHealth;
    }
    public int getImage(){
        return image;
    }
    public void gainExperience(int experiencePoints) {
        this.experience += experiencePoints;
    }
    public void defende(int damage, int def) {
        int random = damage + new Random().nextInt(3);
        int totalDamage = random - def;
        if (totalDamage > 0) {
            this.health -= totalDamage;
        }
    }
}
