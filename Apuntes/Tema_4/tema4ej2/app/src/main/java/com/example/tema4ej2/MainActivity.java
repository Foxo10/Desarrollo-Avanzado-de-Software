package com.example.tema4ej2;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] personajes={R.drawable.bart,R.drawable.edna,R.drawable.homer,R.drawable.lisa,R.drawable.skinner};
        String[] nombres={"Bart Simpson","Edna Krabappel","Homer Simpson","Lisa Simpson","Seymour Skinner"};

        ListView simpsons= (ListView) findViewById(R.id.listView);
        AdaptadorListView eladap= new AdaptadorListView(getApplicationContext(),nombres,personajes);
        simpsons.setAdapter(eladap);
    }
}