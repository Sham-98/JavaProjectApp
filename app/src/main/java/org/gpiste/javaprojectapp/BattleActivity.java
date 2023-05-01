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
    private ArrayList<Lutemon> lutemons;
    private ArrayList<CheckBox> checkBoxes;
    private Button fightButton;
    private TextView battleResultTextView;
    private Lutemon selectedLutemon1;
    private Lutemon selectedLutemon2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);

        checkBoxes = new ArrayList<>();
        lutemons = Storage.getInstance().getBattle();

        LinearLayout linearLayoutBattleActivity = findViewById(R.id.battleActivityLinearLayout1);
        for (Lutemon lutemon : lutemons) {
            CheckBox checkBox = new CheckBox((this));
            checkBox.setText(lutemon.getName() + "(" + lutemon.getColor() + ")");
            checkBox.setTag(lutemon);
            linearLayoutBattleActivity.addView(checkBox);
            checkBoxes.add(checkBox);
        }

        fightButton = findViewById(R.id.Fight);
        battleResultTextView = findViewById(R.id.battleResultView);
        fightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedLutemonCount = 0;
                for (CheckBox checkBox : checkBoxes) {
                    if (checkBox.isChecked()) {
                        if (selectedLutemonCount == 0) {
                            selectedLutemon1 = (Lutemon) checkBox.getTag();
                            selectedLutemonCount++;
                        } else if (selectedLutemonCount == 1) {
                            selectedLutemon2 = (Lutemon) checkBox.getTag();
                        } else {
                            break;
                        }
                    }
                }

                if (selectedLutemonCount == 2) {
                    battleResultTextView.setText("");
                    BattleField battleField = new BattleField(Storage.getInstance().getBattle(),
                            lutemons.indexOf((selectedLutemon1)),
                            lutemons.indexOf(selectedLutemon2));
                    String battleResult = battleField.startBattle();
                    battleResultTextView.setText(battleResult);
                }
            }
        });
    }
}