package com.example.tema4ej3;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView lalista = findViewById(R.id.elRecyclerView);
        /*int[] personajes= {R.drawable.bart, R.drawable.edna, R.drawable.homer, R.drawable.lisa,
                R.drawable.skinner};*/
        String[] nombres={"Bart Simpson","Edna Krabappel", "Homer Simpson", "Lisa Simpson",
                "Seymour Skinner"};
        ElAdaptadorRecycler eladaptador = new ElAdaptadorRecycler(nombres);
        lalista.setLayoutManager(new LinearLayoutManager(this));
        lalista.setAdapter(eladaptador);



    }
}