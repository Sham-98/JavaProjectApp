package org.gpiste.javaprojectapp;

import java.util.ArrayList;

public class TraningArea extends Storage {
    private ArrayList<Lutemon> lutemons;

    public TraningArea() {
        lutemons = new ArrayList<Lutemon>();
    }

    public void addLutemon(Lutemon lutemon) {
        lutemons.add(lutemon);
    }

    public void removeLutemon(Lutemon lutemon) {
        lutemons.remove(lutemon);
    }

    public ArrayList<Lutemon> getLutemons() {
        return lutemons;
    }
}
