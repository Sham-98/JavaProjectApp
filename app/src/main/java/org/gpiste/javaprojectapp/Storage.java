package org.gpiste.javaprojectapp;

import android.widget.CheckBox;

import java.util.ArrayList;
public class Storage {

    private static Storage storage = null;
    private ArrayList<Lutemon> home;
    private ArrayList<Lutemon> training;
    private ArrayList<Lutemon> battle;

    public static synchronized Storage getInstance() {
        if (storage ==null) {
            storage = new Storage();
        }
        return storage;
    }
    public Storage() {
        home = new ArrayList<>();
        training = new ArrayList<>();
        battle = new ArrayList<>();
    }

    public void addLutemon(Lutemon lutemon) {
        home.add(lutemon);
    }

    public ArrayList<Lutemon> getHome() {
        return home;
    }

    public ArrayList<Lutemon> getTraining() {
        return training;
    }

    public ArrayList<Lutemon> getBattle() {
        return battle;
    }

    public void removeDeadLutemon(Lutemon lutemon) {
        battle.remove(lutemon);
    }
    public void moveLutemon(Lutemon lutemon, ArrayList<Lutemon> List1, ArrayList<Lutemon> List2) {
        if (List1 != null && List2 != null && List1.remove(lutemon)) {
            List2.add(lutemon);
        }
    }}
