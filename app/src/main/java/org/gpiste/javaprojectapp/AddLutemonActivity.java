package org.gpiste.javaprojectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class AddLutemonActivity extends AppCompatActivity {

    private EditText EditTextName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lutemon);

        EditTextName = findViewById(R.id.editTextName);
    }

    Toast toast;
    private void makeToast(String string) {
        if (toast != null) toast.cancel();
        toast = Toast.makeText(getApplicationContext(), string, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void addLutemon(View view) {

        String name = EditTextName.getText().toString();

        RadioGroup rgColor = findViewById(R.id.rgColor);

        Lutemon newLutemon = null;
        switch (rgColor.getCheckedRadioButtonId()) {
            case R.id.rbWhite:
                newLutemon = new White(name);
                break;
            case R.id.rbGreen:
                newLutemon = new Green(name);
                break;
            case R.id.rbPink:
                newLutemon = new Pink(name);
                break;
            case R.id.rbOrange:
                newLutemon = new Orange(name);
                break;
            case R.id.rbBlack:
                newLutemon = new Black(name);
                break;
        }
        //Storage.getInstance().addLutemon(newLutemon);

        Home home = new Home();
        home.addLutemon(newLutemon);

        makeToast("Lisätty");
    }
}