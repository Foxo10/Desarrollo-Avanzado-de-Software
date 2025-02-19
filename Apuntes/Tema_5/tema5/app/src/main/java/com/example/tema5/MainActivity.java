package com.example.tema5;

import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.DialogFragment;

public class MainActivity extends AppCompatActivity implements  DatePickerFragment.ListenerFechaDialog, ExitDialogFragment.ListenerExitDialog{
    private TextView selectedDateTextView;
    private Button selectDateButton, exitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NotificationHelper.createNotificationChannel(this);

        selectedDateTextView = findViewById(R.id.selectedDateTextView);
        selectDateButton = findViewById(R.id.selectDateButton);
        exitButton = findViewById(R.id.exitButton);

        selectDateButton.setOnClickListener(v -> {
            DialogFragment datePicker = new DatePickerFragment();
            datePicker.show(getSupportFragmentManager(), "datePicker");
        });

        exitButton.setOnClickListener(v -> {
            DialogFragment exitDialog = new ExitDialogFragment();
            exitDialog.show(getSupportFragmentManager(), "exitDialog");
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) { // Solo en Android 13+
            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS)
                    != PackageManager.PERMISSION_GRANTED) {
                // PEDIR EL PERMISO
                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.POST_NOTIFICATIONS}, 11);
            }
        }



    }
    @Override
    public void onDateSelected(String date) {
        selectedDateTextView.setText("Fecha seleccionada: " + date);
        NotificationHelper.showNotification(this, date);
    }
    @Override
    public void onExitConfirmed() {
        finish();
    }
}