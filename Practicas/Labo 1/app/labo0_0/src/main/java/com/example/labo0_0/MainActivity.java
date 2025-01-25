package com.example.labo0_0;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Crear un TextView dinámicamente
        // TextView etiqueta = new TextView(this);
        // etiqueta.setText("¡Hola, esta es mi primera app en Android!");

        // Establecer el TextView como la vista principal
        // setContentView(etiqueta);

        // Crear un LinearLayout
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        // Agregar los TextView al LinearLayout
        TextView texto1 = new TextView(this);
        texto1.setText("Primer texto");

        TextView texto2 = new TextView(this);
        texto2.setText("Segundo mensaje.");

        TextView texto3 = new TextView(this);
        texto3.setText("El tercero.");

        // Agregar los TextView al LinearLayout
        layout.addView(texto1);
        layout.addView(texto2);
        layout.addView(texto3);

        // Establecer el LinearLayout como la vista principal
        setContentView(layout);


        // EdgeToEdge.enable(this);
        // setContentView(R.layout.activity_main);

        }
    }