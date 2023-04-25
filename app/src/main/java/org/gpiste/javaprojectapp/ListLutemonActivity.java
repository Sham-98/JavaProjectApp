package org.gpiste.javaprojectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class ListLutemonActivity extends AppCompatActivity {
    private ListView mListView;
    private LutemonAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nlist_lutemon);

        mListView = findViewById(R.id.list_view);
        mAdapter = new LutemonAdapter(this);

        // Retrieve Lutemons from a SQLite database
        List<Lutemon> lutemons = LutemonDatabase.getInstance(this).getLutemons();

        // Add Lutemons to the adapter
        mAdapter.addAll(lutemons);

        // Set the adapter on the ListView
        mListView.setAdapter(mAdapter);
    }
}