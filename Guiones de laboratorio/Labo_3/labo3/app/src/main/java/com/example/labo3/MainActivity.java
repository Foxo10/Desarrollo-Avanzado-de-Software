package com.example.labo3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button addTaskbutton;
    private ListView taskListView;
    private ArrayList<String> taskList;
    private ArrayAdapter<String> adapter;

    private final ActivityResultLauncher<Intent> getText = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    Intent data = result.getData();
                    if (data != null) {
                        String taskText = data.getStringExtra("task");
                        if (taskText != null) {
                            taskList.add(taskText);
                            adapter.notifyDataSetChanged();
                        }

                    }
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addTaskbutton = findViewById(R.id.addTaskButton);
        taskListView = findViewById(R.id.taskListView);

        if (savedInstanceState != null) {
            taskList = savedInstanceState.getStringArrayList("taskList");
        } else {
            taskList = new ArrayList<>();
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, taskList);
        taskListView.setAdapter(adapter);

        addTaskbutton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddTaskActivity.class);
            getText.launch(intent);
        });

        taskListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                String task = taskList.get(i);
                taskList.remove(i);
                adapter.notifyDataSetChanged();

                Toast.makeText(getApplicationContext(),"Task '"+task+"' deleted", Toast.LENGTH_SHORT).show();

                return true;
            }
        });


    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList("taskList", taskList);
    }


}