package org.gpiste.javaprojectapp;

import java.util.Date;

public class Lutemon {
    private String name;
    private String color;
    private int attack;
    private int defense;
    private int experience;
    private int health;
    private int maxHealth;
    private int id;

    public Lutemon(String name, String color, int attack, int defense, int experience, int health, int maxHealth, int id) {
        this.name = name;
        this.color = color;
        this.attack = attack;
        this.defense = defense;
        this.experience = experience;
        this.health = health;
        this.maxHealth = maxHealth;
        this.id = id;
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
    public int getId() {
        return id;
    }

    public void attack(Lutemon target) {
        int damage = calculateDamage();
        target.defense(damage);
    }

    public int calculateDamage() {
        int minDamage = (int) (0.5 * attack);
        int maxDamage = (int) (1.5 * attack);
        int damage = (int) (Math.random()*(maxDamage - minDamage + 1)) + minDamage;
        return damage;
    }

    public void defense(int damage) {
        int actualDamage = Math.max(0, damage - defense);
        health = actualDamage;
    }

}
