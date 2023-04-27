package org.gpiste.javaprojectapp;

import java.util.ArrayList;

public class Home extends Storage {
    private ArrayList<Lutemon> lutemons;

    public Home() {
        lutemons = new ArrayList<Lutemon>();
    }
    public void addLutemon(Lutemon lutemon) {
        lutemons.add(lutemon);
    }

    public ArrayList<Lutemon> getLutemons() {
        return lutemons;
    }
}
