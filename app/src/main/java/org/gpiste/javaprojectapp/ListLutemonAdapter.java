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
        holder.Name.setText(lutemons.get(position).getName() + " (" + lutemons.get(position).getColor() + ")");
        holder.Attack.setText("Hyökkays: " + lutemons.get(position).getAttack());
        holder.Defense.setText("Puolustus: " + lutemons.get(position).getDefense());
        holder.MaxHealth.setText("Elämä: " + lutemons.get(position).getHealth() + "/" + lutemons.get(position).getMaxHealth());
        holder.Experience.setText("Komemus: " + lutemons.get(position).getExperience());
        holder.lutemonImage.setImageResource(lutemons.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return lutemons.size();
    }
}