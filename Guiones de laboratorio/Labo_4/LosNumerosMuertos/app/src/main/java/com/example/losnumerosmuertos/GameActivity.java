package com.example.losnumerosmuertos;

import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameActivity extends AppCompatActivity {
    private TextView difficultyTextView, attemptsTextView;
    private EditText guessInput;
    private Button guessButton;
    private ListView historyListView;
    private String secretNumber;
    private int attemptsLeft;
    private int attemptsDifficulty;
    private List<String> historyList;
    private ArrayAdapter<String> historyAdapter;

    @Override
     protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.POST_NOTIFICATIONS}, 1);
            }
        }

        difficultyTextView = findViewById(R.id.difficultyTextView);
        attemptsTextView = findViewById(R.id.attemptsTextView);
        guessInput = findViewById(R.id.guessInput);
        guessButton = findViewById(R.id.guessButton);
        historyListView = findViewById(R.id.historyListView);

        int difficulty = getIntent().getIntExtra("difficulty", 0);
        int numDigits = difficulty + 3;
        attemptsLeft = 10 - (difficulty*2);
        attemptsDifficulty = attemptsLeft;
        attemptsTextView.setText("Te quedan " + attemptsDifficulty + " intentos");
        secretNumber = generateSecretNumber(numDigits);

        difficultyTextView.setText("Dificultad: " + (difficulty == 0 ? "Fácil" : difficulty == 1 ? "Medio" : "Difícil"));
        historyList = new ArrayList<>();
        historyAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, historyList);
        historyListView.setAdapter(historyAdapter);

        guessButton.setOnClickListener(v -> checkearAdivinanza());
    }
    private String generateSecretNumber(int length){
        Random generador = new Random();
        StringBuilder secretNumber = new StringBuilder();
        for (int i = 0; i < length; i++){
            secretNumber.append(generador.nextInt(10));
        }
        Log.i("secreto", secretNumber.toString());
        return secretNumber.toString();
    }
    private void checkearAdivinanza(){
        String guess = guessInput.getText().toString();
        if (guess.length() != secretNumber.length()){
            Toast.makeText(this, "Debe tener "+ secretNumber.length() + " dígitos", Toast.LENGTH_SHORT).show();
            return;
        }
        int muertos = 0;
        int heridos = 0;
        for (int i = 0; i < secretNumber.length(); i++) {
            if (guess.charAt(i) == secretNumber.charAt(i)) {
                muertos++;
            } else if (secretNumber.contains(String.valueOf(guess.charAt(i)))) {
                heridos++;
            }

        }
        attemptsLeft--;
        attemptsTextView.setText("Te quedan " + attemptsLeft + " intentos");
        String attempt = guess +" | " + muertos + " muerto(s) y "+ heridos+ " herido(s)";


        if (muertos == secretNumber.length()) {
            int attemptsUsed = (attemptsDifficulty - attemptsLeft);
            NotificationHelper.createNotificationChannel(this);
            NotificationHelper.showWinNotification(this, attemptsUsed);
            finish();
        } else if (attemptsLeft == 0) {
            GameOverDialog gameOverDialog = new GameOverDialog(secretNumber);
            gameOverDialog.show(getSupportFragmentManager(), "gameOverDialog");
        } else {
            Toast.makeText(this, muertos + " muertos, " + heridos + " heridos", Toast.LENGTH_SHORT).show();
        }
        historyList.add(attempt);
        historyAdapter.notifyDataSetChanged();

    }

}
