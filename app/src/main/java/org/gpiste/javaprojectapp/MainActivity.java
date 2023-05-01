package org.gpiste.javaprojectapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button fragment = findViewById(R.id.MoveLutemonsButton);

        fragment.setOnClickListener(listener);
    }

    public void switchToAddLutemon (View view) {
        Intent intent = new Intent(this, AddLutemonActivity.class);
        startActivity(intent);
    }

    public void switchToListLutemons(View view) {
        Intent intent = new Intent(this, ListLutemonActivity.class);
        startActivity(intent);
    }
    public void switchToFight(View view) {
        Intent intent = new Intent(this, BattleActivity.class);
        startActivity(intent);
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Fragment fragment;

            switch (view.getId()) {
                case R.id.MoveLutemonsButton:
                    Intent intent = new Intent(view.getContext(), FragmentActivity.class);
                    startActivity(intent);
                    return;
                default:
                    fragment = new Fragment();
                    break;
            }

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frame, fragment)
                    .commit();
        }
    };
}