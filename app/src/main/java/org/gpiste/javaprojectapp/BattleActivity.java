package org.gpiste.javaprojectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class BattleActivity extends AppCompatActivity {
    Button Fight;
    TextView textView;

    RadioGroup radioGroup;
    private Button fightButton;
    private ArrayList<Lutemon> lutemons;
    private ArrayList<CheckBox> checkBoxes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);
        Fight = findViewById(R.id.Fight);
        textView = findViewById(R.id.textView);

        checkBoxes = new ArrayList<>();

        LinearLayout linearLayoutBattleActivity = findViewById(R.id.battleActivityLinearLayout1);
        for (Lutemon lutemon : lutemons) {
            CheckBox checkBox = new CheckBox((this));
            checkBox.setText(lutemon.getName() + "(" + lutemon.getColor() + ")");
            checkBox.setTag(lutemon);
            linearLayoutBattleActivity.addView(checkBox);
            checkBoxes.add(checkBox);
        }

        fightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}