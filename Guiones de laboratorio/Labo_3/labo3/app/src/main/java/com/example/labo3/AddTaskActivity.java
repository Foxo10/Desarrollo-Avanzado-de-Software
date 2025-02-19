package com.example.labo3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddTaskActivity extends AppCompatActivity {
    private EditText taskEditText;
    private Button saveTaskButton;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        taskEditText = findViewById(R.id.taskEditText);
        saveTaskButton = findViewById(R.id.saveTaskButton);

        saveTaskButton.setOnClickListener(v -> {
            String textTaskEdit = taskEditText.getText().toString();

            Intent resultIntent = new Intent();
            if(!textTaskEdit.isEmpty()){
                resultIntent.putExtra("task", textTaskEdit);
                setResult(Activity.RESULT_OK, resultIntent);
            }
            else {
                setResult(Activity.RESULT_CANCELED);
            }
            finish();
        });



    }
}
