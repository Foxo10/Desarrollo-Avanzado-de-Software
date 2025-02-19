package com.example.tema4;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);
        // Crear lista de elementos
        ArrayList<String> elementos = new ArrayList<>();
        elementos.add("Elemento 1");
        elementos.add("Elemento 2");
        elementos.add("Elemento 3");
        elementos.add("Elemento 4");
        elementos.add("Elemento 5");

        ArrayAdapter eladaptador =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,elementos);
        ListView lalista = (ListView) findViewById(R.id.listView);
        lalista.setAdapter(eladaptador);

        lalista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("etiqueta", ((TextView)view).getText().toString()+", "+position+", "+id);

            }
        });



    }
}