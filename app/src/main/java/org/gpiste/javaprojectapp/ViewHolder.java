package org.gpiste.javaprojectapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
public class ViewHolder extends RecyclerView.ViewHolder {
    ImageView lutemonImage;
    TextView Name, Attack, Defense, MaxHealth, Experience;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        lutemonImage = itemView.findViewById(R.id.ivLutemonImage);
        Name = itemView.findViewById(R.id.txtName);
        Attack = itemView.findViewById(R.id.txtAttack);
        Defense = itemView.findViewById(R.id.txtDefense);
        MaxHealth = itemView.findViewById(R.id.txtHealth);
        Experience = itemView.findViewById(R.id.txtExperience);
    }


}
