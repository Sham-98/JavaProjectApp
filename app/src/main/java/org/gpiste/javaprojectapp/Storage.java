package org.gpiste.javaprojectapp;

import android.content.Context;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Storage {

}
/*public class Storage {
    private static Storage storage = null;
    private ArrayList<Lutemon> Home;
    private ArrayList<Lutemon> Training;
    private ArrayList<Lutemon> Battle;
    public static synchronized Storage getInstance() {
        if (storage == null) {
            storage = new Storage();
        }
        return storage;
    }

    private Storage() {
        Home = new ArrayList<>();
        Training = new ArrayList<>();
        Battle = new ArrayList<>();
    }

    public void addLutemon(Lutemon lutemon) {
        Home.add(lutemon);
    }

    public void moveLutemon(Lutemon lutemon, ArrayList<Lutemon> fromList, ArrayList<Lutemon> toList) {
        if (fromList.remove(lutemon)) {
            toList.add(lutemon);
        }
    }

}*/
