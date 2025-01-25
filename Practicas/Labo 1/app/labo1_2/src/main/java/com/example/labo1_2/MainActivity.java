package com.example.labo1_2;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private LinearLayout layout1, layout2;
    private String user = "";
    private TextView textoPersonalizado; // Hacerlo global para modificarlo después

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // ====== PRIMER LAYOUT ======
        layout1 = new LinearLayout(this);
        layout1.setOrientation(LinearLayout.VERTICAL);
        layout1.setBackgroundColor(Color.BLACK);

        // Texto en el primer layout
        TextView texto1 = new TextView(this);
        texto1.setText("Este es el Primer Layout");

        // Botón para cambiar al segundo layout
        Button botonCambio1 = new Button(this);
        botonCambio1.setText("Ir al segundo layout");

        // Campo EditText para el nombre
        EditText lacaja = new EditText(this);
        lacaja.setHint("Escriba su nombre"); // Usamos Hint en lugar de setText

        botonCambio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user = lacaja.getText().toString(); // Obtener el nombre ingresado

                // Actualizar el texto de bienvenida antes de cambiar de layout
                textoPersonalizado.setText("Bienvenido " + user);

                setContentView(layout2);
            }
        });

        layout1.addView(texto1);
        layout1.addView(lacaja);
        layout1.addView(botonCambio1);

        // ====== SEGUNDO LAYOUT ======
        layout2 = new LinearLayout(this);
        layout2.setOrientation(LinearLayout.VERTICAL);
        layout2.setBackgroundColor(Color.WHITE);

        // Texto en el segundo layout
        TextView texto2 = new TextView(this);
        texto2.setText("Este es el Segundo Layout");

        // Texto personalizado que se actualizará dinámicamente
        textoPersonalizado = new TextView(this);
        textoPersonalizado.setText("Bienvenido "); // Inicialmente vacío

        // Botón para regresar al primer layout
        Button botonCambio2 = new Button(this);
        botonCambio2.setText("Volver al primer layout");

        botonCambio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(layout1);
            }
        });

        layout2.addView(texto2);
        layout2.addView(textoPersonalizado);
        layout2.addView(botonCambio2);

        // Mostrar el primer layout inicialmente
        setContentView(layout1);
    }
}
