package org.gpiste.javaprojectapp;

import android.widget.CheckBox;

import java.util.ArrayList;
public class Storage {

    private static Storage storage = null;
    private ArrayList<Lutemon> homeList;
    private ArrayList<Lutemon> trainingList;
    private ArrayList<Lutemon> battleList;

    public static synchronized Storage getInstance() {
        if (storage ==null) {
            storage = new Storage();
        }
        return storage;
    }
    public Storage() {
        homeList = new ArrayList<>();
        trainingList = new ArrayList<>();
        battleList = new ArrayList<>();
    }

    public void addLutemon(Lutemon lutemon) {
        homeList.add(lutemon);
    }

    public ArrayList<Lutemon> getHome() {
        return homeList;
    }

    public ArrayList<Lutemon> getTraining() {
        return trainingList;
    }

    public ArrayList<Lutemon> getBattle() {
        return battleList;
    }

    public void removeDeadLutemon(Lutemon lutemon) {
        battleList.remove(lutemon);
    }
    public void moveLutemon(Lutemon lutemon, ArrayList<Lutemon> List1, ArrayList<Lutemon> List2) {
        if (List1 != null && List2 != null && List1.remove(lutemon)) {
            List2.add(lutemon);
        }
    }}
