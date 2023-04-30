package org.gpiste.javaprojectapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import org.gpiste.javaprojectapp.Lutemon;
import org.gpiste.javaprojectapp.R;
import org.gpiste.javaprojectapp.Storage;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    RadioGroup radioGroup;
    private Button moveButton;
    private ArrayList<Lutemon> selectedList = null;
    ArrayList<CheckBox> checkBoxes;
    //ArrayList<Lutemon> selectedList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        LinearLayout linearLayoutHome1 = view.findViewById(R.id.linearLayoutHome1);

        ArrayList<Lutemon> lutemons = Storage.getInstance().getHome();

        radioGroup = view.findViewById(R.id.rgGroupHome);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButton:
                        selectedList = Storage.getInstance().getHome();
                        break;
                    case R.id.radioButton2:
                        selectedList = Storage.getInstance().getTraining();
                        break;
                    case R.id.radioButton3:
                        selectedList = Storage.getInstance().getBattle();
                        break;
                    default:
                        selectedList = null;
                        break;
                }
            }
        });

        checkBoxes = new ArrayList<>();

        for (Lutemon lutemon : lutemons) {
            CheckBox checkBox = new CheckBox(getContext());
            checkBox.setText(lutemon.getName() + " (" + lutemon.getColor() + ")");
            checkBoxes.add(checkBox);
            linearLayoutHome1.addView(checkBox);

        }

        moveButton = view.findViewById(R.id.moveButtonHome);

        moveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (CheckBox checkBox : checkBoxes) {
                    if (checkBox.isChecked()) {
                        Lutemon lutemon = lutemons.get(checkBoxes.indexOf(checkBox));
                        Storage.getInstance().moveLutemon(lutemon, Storage.getInstance().getHome(), selectedList);
                    }
                }
                //updateUI();
            }
        });

        return view;
    }

    /*private void updateUI() {
        linearLayoutHome1.removeAllViews();

        lutemons = Storage.getInstance().getHome();
        checkBoxes = new ArrayList<>();
        for (Lutemon lutemon : lutemons) {
            CheckBox checkBox = new CheckBox(getContext());
            checkBox.setText(lutemon.getName() + " (" + lutemon.getColor() + ")");
            checkBoxes.add(checkBox);
            linearLayoutHome1.addView(checkBox);
        }
    }*/
}