package org.gpiste.javaprojectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class BattleActivity extends AppCompatActivity {
    CheckBox box1, box2, box3, box4;
    Button Fight;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);
        box1 = findViewById(R.id.box1);
        box2 = findViewById(R.id.box2);
        box3 = findViewById(R.id.box3);
        box4 = findViewById(R.id.box4);
        Fight = findViewById(R.id.Fight);
        textView = findViewById(R.id.textView);

        Fight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Box1 = box1.getText().toString();
                String Box2 = box2.getText().toString();
                String Box3 = box3.getText().toString();
                String Box4 = box4.getText().toString();
            }
        });
        Fight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

    }
}