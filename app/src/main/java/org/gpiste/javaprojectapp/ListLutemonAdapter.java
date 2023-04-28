package org.gpiste.javaprojectapp;

import android.view.LayoutInflater;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListLutemonAdapter extends RecyclerView.Adapter<ViewHolder> {
    private Context context;
    private ArrayList<Lutemon> lutemons = new ArrayList<>();

    public ListLutemonAdapter(Context context, ArrayList<Lutemon> lutemons) {
        this.context = context;
        this.lutemons = lutemons;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.lutemonview, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    holder.Name.setText(lutemons.get(position).getName() + " (" + lutemons.get(position).getId()+ " (");
    //holder.Color.setText(lutemons.get(position).getColor() + " (" + lutemons.get(position).getId()+ " (");
    holder.Attack.setText(lutemons.get(position).getAttack() + " (" + lutemons.get(position).getId()+ " (");
    holder.Defense.setText(lutemons.get(position).getDefense() + " (" + lutemons.get(position).getId()+ " (");
    holder.Experience.setText(lutemons.get(position).getExperience() + " (" + lutemons.get(position).getId()+ " (");
    holder.Health.setText(lutemons.get(position).getHealth() + " (" + lutemons.get(position).getId()+ " (");
    //holder.Maxhealth.setText(lutemons.get(position).getName() + " (" + lutemons.get(position).getId()+ " (");holder.Name.setText(lutemons.get(position).getName() + " (" + lutemons.get(position).getId()+ " (");
    //holder..setText(lutemons.get(position).getName() + " (" + lutemons.get(position).getId()+ " (");holder.Name.setText(lutemons.get(position).getName() + " (" + lutemons.get(position).getId()+ " (");

    }

    @Override
    public int getItemCount() {
        return lutemons.size();
    }
}