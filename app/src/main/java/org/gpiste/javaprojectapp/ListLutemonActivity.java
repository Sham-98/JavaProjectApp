package org.gpiste.javaprojectapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ListView;
// Was edited by Sham 26.4.2023
public class ListLutemonActivity extends AppCompatActivity {
    private Storage storage;
    private RecyclerView recyclerView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_lutemon);

        storage = Storage.getInstance();
        recyclerView = findViewById(R.id.lista1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(new ListLutemonAdapter(getApplicationContext(), Storage.getInstance().getLutemonList()));

    }
}