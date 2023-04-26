package org.gpiste.javaprojectapp;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {

    public TextView Name;

    public ViewHolder(@NonNull View lutemonView) {
        super(lutemonView);
        View txtName = lutemonView.findViewById(R.id.txtName);
    }

}
