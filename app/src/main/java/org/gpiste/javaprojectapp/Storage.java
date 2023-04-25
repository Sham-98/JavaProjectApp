package org.gpiste.javaprojectapp;

import android.content.Context;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Storage {
    // Lisätty 25.04 tästä ---
    private static Storage storage = null;
    private ArrayList<Lutemon> lutemon;

    private Storage() {
        lutemon = new ArrayList<>();
    }

    public static synchronized Storage getInstance() {
        if (storage == null) {
            storage = new Storage();
        }
        return storage;
    }

    /*public void addLutemon(Lutemon lutemon) {
        lutemon.add(lutemon);
    }*/

    public void saveLutemons(Context context) {
        try {
            ObjectOutputStream writer = new ObjectOutputStream(context.openFileOutput("user.data", Context.MODE_PRIVATE));
            writer.writeObject(lutemon);
            writer.close();
        } catch (IOException e) {
            System.out.println("Tallentaminen epäonnistui");
        }
    }

    public void loadUsers(Context context) {
        try {
            ObjectInputStream reader = new ObjectInputStream(context.openFileInput("user.data"));
            lutemon = (ArrayList<Lutemon>) reader.readObject();
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Lukeminen ei onnistunut");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Lukeminen ei onnistunut");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Lukeminen ei onnistunut");
            e.printStackTrace();
        }
    }
    // -- tähän asti 25.04 - Annika
}
