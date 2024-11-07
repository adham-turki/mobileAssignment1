package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;

public class WorkoutPlannerActivity extends AppCompatActivity {

    private EditText exerciseInput;
    private Spinner setSpinner, repSpinner;
    private FloatingActionButton addButton;
    private RecyclerView exerciseList;
    private ArrayList<Workout> workouts;
    private WorkoutAdapter adapter;
    private Button viewRecordsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_planner);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        exerciseInput = findViewById(R.id.exerciseInput);
        setSpinner = findViewById(R.id.setSpinner);
        repSpinner = findViewById(R.id.repSpinner);
        addButton = findViewById(R.id.addButton);
        exerciseList = findViewById(R.id.exerciseList);
        viewRecordsButton = findViewById(R.id.viewRecordsButton);

        ArrayAdapter<CharSequence> setAdapter = ArrayAdapter.createFromResource(this,
                R.array.sets_array, android.R.layout.simple_spinner_item);
        setAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        setSpinner.setAdapter(setAdapter);

        ArrayAdapter<CharSequence> repAdapter = ArrayAdapter.createFromResource(this,
                R.array.reps_array, android.R.layout.simple_spinner_item);
        repAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        repSpinner.setAdapter(repAdapter);

        workouts = new ArrayList<>();
        adapter = new WorkoutAdapter(workouts);
        exerciseList.setLayoutManager(new LinearLayoutManager(this));
        exerciseList.setAdapter(adapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String exercise = exerciseInput.getText().toString();
                String sets = setSpinner.getSelectedItem().toString();
                String reps = repSpinner.getSelectedItem().toString();
                if (!exercise.isEmpty()) {
                    Workout workout = new Workout(exercise, sets, reps);
                    workouts.add(workout);
                    adapter.notifyDataSetChanged();
                    exerciseInput.setText("");
                }
            }
        });

        viewRecordsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WorkoutPlannerActivity.this, RecordsActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}