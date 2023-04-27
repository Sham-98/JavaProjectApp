package org.gpiste.javaprojectapp;

import android.view.LayoutInflater;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ListLutemonAdapter extends RecyclerView.Adapter<ListLutemonAdapter.LutemonViewHolder> {
    private final Context context;
    private final List<Lutemon> lutemonList;
    public ListLutemonAdapter(Context applicationContext, Object lutemonList) {
        this.context = context;
        this.lutemonList = lutemonList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return lutemonList.size();
    }
