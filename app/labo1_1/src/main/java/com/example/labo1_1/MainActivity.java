package com.example.labo1_1;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private int contador = 0;
    private int colorIndex = 0;
    private int[] colores = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.MAGENTA, Color.CYAN} ;
    private boolean textoVisible = true;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Crear un LinearLayout
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        // Crear un TextView para el contador
        TextView contadorTexto = new TextView(this);
        contadorTexto.setText("Contador: " + contador);

        // Crear un botón para incrementar el contador y cambiar el color
        Button botonIncrementar = new Button(this);
        botonIncrementar.setText("Incrementar contador y cambiar color");

        // Crear un botón para mostrar/ocultar el contador
        Button botonMostrarOcultar = new Button(this);
        botonMostrarOcultar.setText("Mostrar/Ocultar Contador");

        // Agregar acción al botón
        botonIncrementar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contador++; // Incrementar el contador
                contadorTexto.setText("Contador: " + contador); // Actualizar el texto

                // Cambiar el color de fondo de manera cíclica
                layout.setBackgroundColor(colores[colorIndex]);
                colorIndex = (colorIndex + 1) % colores.length;

            }
        });

        // Acción del botón para mostrar/ocultar el contador
        botonMostrarOcultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textoVisible){
                    // View.INVISIBLE == 4
                    contadorTexto.setVisibility(View.INVISIBLE);
                }
                else {
                    // View.VISIBLE == 0
                    contadorTexto.setVisibility(View.VISIBLE);

                }
                textoVisible = !textoVisible;

            }
        });

        // Agregar los elementos al layout
        layout.addView(contadorTexto);
        layout.addView(botonIncrementar);
        layout.addView(botonMostrarOcultar);

        // Establecer el LinearLayout como la vista principal
        setContentView(layout);

    }

}