package org.gpiste.javaprojectapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import org.gpiste.javaprojectapp.Lutemon;
import org.gpiste.javaprojectapp.R;
import org.gpiste.javaprojectapp.Storage;

import java.util.ArrayList;
public class BattleFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    public BattleFragment() {
        // Required empty public constructor
    }
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
        View view = inflater.inflate(R.layout.fragment_battle, container, false);

        LinearLayout homelayout = view.findViewById(R.id.battle_layout);

        ArrayList<Lutemon> lutemons = Storage.getInstance().getHome();

        for (Lutemon lutemon : lutemons) {
            CheckBox checkBox = new CheckBox(getContext());
            checkBox.setText(lutemon.getName() + " (" + lutemon.getColor() + ")");

            homelayout.addView(checkBox);
        }

        return view;
    }
}