package org.gpiste.javaprojectapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import org.gpiste.javaprojectapp.Lutemon;
import org.gpiste.javaprojectapp.R;
import org.gpiste.javaprojectapp.Storage;

import java.util.ArrayList;
public class TrainingFragment extends Fragment {
    RadioGroup radioGroup;
    private Button moveButton;
    private ArrayList<Lutemon> selectedList = null;
    private ArrayList<Lutemon> lutemons;
    private ArrayList<CheckBox> checkBoxes;

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

        lutemons = Storage.getInstance().getHome();
        checkBoxes = new ArrayList<>();

        for (Lutemon lutemon : lutemons) {
            CheckBox checkBox = new CheckBox(getContext());
            checkBox.setText(lutemon.getName() + " (" + lutemon.getColor() + ")");
            checkBoxes.add(checkBox);
            linearLayoutHome1.addView(checkBox);

        }

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

        moveButton = view.findViewById(R.id.moveButtonHome);
        moveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Lutemon> selectedLutemons = new ArrayList<>();
                boolean radioButtonChecked = radioGroup.getCheckedRadioButtonId() != -1;

                if (!radioButtonChecked) {
                    return;
                }

                for (int i = 0; i < Math.min(checkBoxes.size(), lutemons.size()); i++) {
                    if (checkBoxes.get(i).isChecked()) {
                        selectedLutemons.add(lutemons.get(i));
                    }
                }
                if (!selectedLutemons.isEmpty()) {
                    moveSelectedLutemons(selectedLutemons);
                    radioGroup.clearCheck();
                }
            }

        });

        return view;
    }

    private void moveSelectedLutemons(ArrayList<Lutemon> lutemons) {
        for (Lutemon lutemon : lutemons) {
            Storage.getInstance().moveLutemon(lutemon, Storage.getInstance().getTraining(), selectedList);
        }
        updateView();
    }

    private void updateView() {
        LinearLayout linearLayoutHome1 = getView().findViewById(R.id.linearLayoutHome1);
        linearLayoutHome1.removeAllViews();
        lutemons = Storage.getInstance().getHome();
        checkBoxes.clear();

        for (Lutemon lutemon : lutemons) {
            CheckBox checkBox = new CheckBox(getContext());
            checkBox.setText(lutemon.getName() + " (" + lutemon.getColor() + ")");
            checkBoxes.add(checkBox);
            linearLayoutHome1.addView(checkBox);
        }
    }

}