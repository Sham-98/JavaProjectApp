package org.gpiste.javaprojectapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView Name, Attack, Defense, Health, Experience;


    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageView);
        Name = itemView.findViewById(R.id.txtName);
        Attack = itemView.findViewById(R.id.txtAttack);
        Defense = itemView.findViewById(R.id.txtDefense);
        Health = itemView.findViewById(R.id.txtHealth);
        Experience = itemView.findViewById(R.id.txtExperience);
    }



    /*public ListLutemonAdapter(Context context, ArrayList<Lutemon> lutemons) {
        this.context = context;
        this.lutemons = lutemons;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ListLutemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.lutemonview, parent, false);
        return new ListLutemonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListLutemonViewHolder holder, int position) {
        Lutemon lutemon = lutemons.get(position);
        holder.nameTextView.setText(lutemon.getName());
    }

    @Override
    public int getItemCount() {
        return lutemons.size();
    }


    public class ListLutemonViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView;

        public ListLutemonViewHolder(@NonNull View lutemonView) {
            super(lutemonView);
            nameTextView = lutemonView.findViewById(R.id.lista1);
        }
    }*/
}
