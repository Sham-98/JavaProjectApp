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
import android.widget.Toast;

import org.gpiste.javaprojectapp.Lutemon;
import org.gpiste.javaprojectapp.R;
import org.gpiste.javaprojectapp.Storage;

import java.util.ArrayList;
public class BattleFragment extends Fragment {
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
    public void onResume() {
        super.onResume();
        updateView();
    }

    @Override
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_battle, container, false);

        LinearLayout linearLayoutBattle1 = view.findViewById(R.id.linearLayoutBattle1);

        lutemons = Storage.getInstance().getBattle();
        checkBoxes = new ArrayList<>();

        for (Lutemon lutemon : lutemons) {
            CheckBox checkBox = new CheckBox(getContext());
            checkBox.setText(lutemon.getName() + " (" + lutemon.getColor() + ")");
            checkBoxes.add(checkBox);
            linearLayoutBattle1.addView(checkBox);

        }

        radioGroup = view.findViewById(R.id.rgGroupBattle);
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

        moveButton = view.findViewById(R.id.moveButtonBattle);
        moveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Lutemon> selectedLutemons = new ArrayList<>();

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
            Storage.getInstance().moveLutemon(lutemon, Storage.getInstance().getBattle(), selectedList);
        }
        updateView();
    }

    private void updateView() {
        LinearLayout linearLayoutBattle1 = getView().findViewById(R.id.linearLayoutBattle1);
        linearLayoutBattle1.removeAllViews();
        lutemons = Storage.getInstance().getBattle();
        checkBoxes.clear();

        for (Lutemon lutemon : lutemons) {
            CheckBox checkBox = new CheckBox(getContext());
            checkBox.setText(lutemon.getName() + " (" + lutemon.getColor() + ")");
            checkBoxes.add(checkBox);
            linearLayoutBattle1.addView(checkBox);
        }
    }

}