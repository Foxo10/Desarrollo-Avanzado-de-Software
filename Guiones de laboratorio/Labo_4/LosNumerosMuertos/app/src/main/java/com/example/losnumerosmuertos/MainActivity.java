package com.example.losnumerosmuertos;

import android.app.AlertDialog;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.DialogFragment;

public class MainActivity extends AppCompatActivity {
    private Button startGameButton, instructionsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Si el intent contiene el ID de la notificación, cancelarla
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int id = extras.getInt("id", -1);
            if (id != -1) {
                NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.cancel(id);
            }
        }
        setContentView(R.layout.activity_main);

        startGameButton = findViewById(R.id.startGameButton);
        instructionsButton = findViewById(R.id.instructionsButton);

        startGameButton.setOnClickListener(v -> {
            DialogFragment difficultyDialog = new DifficultyDialog();
            difficultyDialog.show(getSupportFragmentManager(), "difficultyDialog");
        });
        instructionsButton.setOnClickListener(v -> showInstructionsDialog());

    }

    private void showInstructionsDialog(){
        new AlertDialog.Builder(this)
                .setTitle("Instrucciones del juego")
                .setMessage("El juego consiste en adivinar un número secreto.  El jugador 1 (el móvil) piensa un número, el jugador\n" +
                        "2 tiene que intentar adivinarlo. Cada vez que el jugador 2 dice un número, el jugador 1 le dirá cuántos números muertos y cuántos\n" +
                        "heridos hay en la cifra que ha dado. Un número muerto es aquel dígito que está en la misma posición que\n" +
                        "en el número a adivinar. Un número herido es aquel dígito que aparece en el número a adivinar, pero está\n" +
                        "en una posición distinta. ")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();
    }
}