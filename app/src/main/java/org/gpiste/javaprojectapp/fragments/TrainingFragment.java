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
        View view = inflater.inflate(R.layout.fragment_training, container, false);

        LinearLayout linearLayoutWorkout1 = view.findViewById(R.id.linearLayoutWorkout1);

        lutemons = Storage.getInstance().getTraining();
        checkBoxes = new ArrayList<>();

        for (Lutemon lutemon : lutemons) {
            CheckBox checkBox = new CheckBox(getContext());
            checkBox.setText(lutemon.getName() + " (" + lutemon.getColor() + ")");
            checkBoxes.add(checkBox);
            linearLayoutWorkout1.addView(checkBox);

        }

        radioGroup = view.findViewById(R.id.rgGroupWorkout);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButtonWorkout1:
                        selectedList = Storage.getInstance().getHome();
                        break;
                    case R.id.radioButtonWorkout2:
                        selectedList = Storage.getInstance().getTraining();
                        break;
                    case R.id.radioButtonWorkout3:
                        selectedList = Storage.getInstance().getBattle();
                        break;
                    default:
                        selectedList = null;
                        break;
                }
            }
        });

        moveButton = view.findViewById(R.id.moveButtonTraining);
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
        LinearLayout linearLayoutWorkout1 = getView().findViewById(R.id.linearLayoutWorkout1);
        linearLayoutWorkout1.removeAllViews();
        lutemons = Storage.getInstance().getTraining();
        checkBoxes.clear();

        for (Lutemon lutemon : lutemons) {
            CheckBox checkBox = new CheckBox(getContext());
            checkBox.setText(lutemon.getName() + " (" + lutemon.getColor() + ")");
            checkBoxes.add(checkBox);
            linearLayoutWorkout1.addView(checkBox);
        }
    }

}