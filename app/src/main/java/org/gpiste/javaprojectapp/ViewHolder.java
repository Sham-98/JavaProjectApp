package org.gpiste.javaprojectapp;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {

    public TextView itemName;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        itemName = itemView.findViewById(R.id.Name);
    }

}
