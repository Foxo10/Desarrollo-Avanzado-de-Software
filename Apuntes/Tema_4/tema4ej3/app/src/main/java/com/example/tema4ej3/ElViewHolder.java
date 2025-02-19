package com.example.tema4ej3;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class ElViewHolder extends RecyclerView.ViewHolder {
    public TextView textoItem;
    public CardView cardView;
    public boolean seleccionado = false;
    public ElViewHolder (@NonNull View itemView){
        super(itemView);
        textoItem=itemView.findViewById(R.id.textoItem);
        cardView= (CardView) itemView;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionado = !seleccionado;
                cardView.setCardBackgroundColor(seleccionado ? Color.BLUE : Color.WHITE);
            }
        });
    }
}
