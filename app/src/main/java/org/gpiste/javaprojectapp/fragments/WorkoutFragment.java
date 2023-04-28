package org.gpiste.javaprojectapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.gpiste.javaprojectapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WorkoutFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WorkoutFragment extends Fragment {

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
        View view = inflater.inflate(R.layout.fragment_workout, container, false);

        return view;
    }
}