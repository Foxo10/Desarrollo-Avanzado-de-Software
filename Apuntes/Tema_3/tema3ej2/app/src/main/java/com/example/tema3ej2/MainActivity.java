package com.example.tema3ej2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText urlEditText;
    private Button openBrowserButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        urlEditText = findViewById(R.id.urlEditText);
        openBrowserButton = findViewById(R.id.openBrowserButton);

        openBrowserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = urlEditText.getText().toString().trim();
                if (!url.isEmpty()) {
                    if (!url.startsWith("http://") && !url.startsWith("https://")) {
                        url = "http://" + url;
                    }
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(intent);

                }else{
                        Toast.makeText(MainActivity.this, "Por favor, introduce una URL", Toast.LENGTH_SHORT).show();
                    }


                }

        });
    }
}