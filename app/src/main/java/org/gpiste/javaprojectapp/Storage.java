package org.gpiste.javaprojectapp;

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

    // public vai private??
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
    public void moveLutemon(Lutemon lutemon, ArrayList<Lutemon> fromList, ArrayList<Lutemon> toList) {
        if (fromList.remove(lutemon)) {
            toList.add(lutemon);
        }
    }
}
