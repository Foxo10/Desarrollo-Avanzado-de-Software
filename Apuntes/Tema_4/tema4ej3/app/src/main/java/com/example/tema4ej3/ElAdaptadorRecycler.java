package com.example.tema4ej3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ElAdaptadorRecycler extends RecyclerView.Adapter<ElViewHolder> {
    private String[] losnombres;
    public ElAdaptadorRecycler (String[] nombres)
    {
        losnombres=nombres;
    }
    public ElViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vistaItem= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card,null);
        ElViewHolder evh = new ElViewHolder(vistaItem);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull ElViewHolder holder, int position) {
        holder.textoItem.setText(losnombres[position]);

    }

    @Override
    public int getItemCount() {
        return losnombres.length;
    }
}
