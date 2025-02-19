package com.example.tema4ej2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class AdaptadorListView extends BaseAdapter {
    private Context contexto;
    private LayoutInflater inflater;
    private String[] datos;
    private int[] imagenes;
    public AdaptadorListView(Context pcontext, String[] pdatos, int[] pimagenes)
    {
        contexto = pcontext;
        datos = pdatos;
        imagenes=pimagenes;
        inflater = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return datos.length;
    }

    @Override
    public Object getItem(int i) {
        return datos[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view=inflater.inflate(R.layout.list_item,null);
        TextView nombre= (TextView) view.findViewById(R.id.itemTexto);
        ImageView img=(ImageView) view.findViewById(R.id.itemImagen);
        Button btn= (Button) view.findViewById(R.id.itemBoton);

        nombre.setText(datos[i]);
        img.setImageResource(imagenes[i]);

        btn.setOnClickListener(v -> {

        });


        return view;
    }
}
