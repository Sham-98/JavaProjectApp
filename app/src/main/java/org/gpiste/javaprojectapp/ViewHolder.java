package org.gpiste.javaprojectapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewHolder extends RecyclerView.ViewHolder {
    public ViewHolder(@NonNull View itemView) {
        super(itemView);
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
        return 0;
    }

    @Override
    public int getLutemonCount() {
        return lutemons.size();
    }

    public class ListLutemonViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView;

        public ListLutemonViewHolder(@NonNull View lutemonView) {
            super(lutemonView);
            nameTextView = lutemonView.findViewById(R.id.nameTextView);
        }
    }*/
}
