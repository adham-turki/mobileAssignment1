package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;

public class RecordsActivity extends AppCompatActivity {

    private TextView workoutRecordsText;
    private TextView nutritionRecordsText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        workoutRecordsText = findViewById(R.id.workoutRecordsText);
        nutritionRecordsText = findViewById(R.id.nutritionRecordsText);

        // For demonstration purposes, we'll create some sample data
        ArrayList<Workout> workouts = new ArrayList<>();
        workouts.add(new Workout("Push-ups", "3 sets", "15 reps"));
        workouts.add(new Workout("Squats", "4 sets", "12 reps"));
        workouts.add(new Workout("Pull-ups", "3 sets", "8 reps"));

        ArrayList<Nutrition> nutritionEntries = new ArrayList<>();
        nutritionEntries.add(new Nutrition(2000, 150, 200, 65));
        nutritionEntries.add(new Nutrition(1800, 140, 180, 60));

        displayWorkoutRecords(workouts);
        displayNutritionRecords(nutritionEntries);
    }

    private void displayWorkoutRecords(ArrayList<Workout> workouts) {
        StringBuilder sb = new StringBuilder();
        for (Workout workout : workouts) {
            sb.append(workout.toString()).append("\n");
        }
        workoutRecordsText.setText(sb.toString());
    }

    private void displayNutritionRecords(ArrayList<Nutrition> nutritionEntries) {
        StringBuilder sb = new StringBuilder();
        for (Nutrition nutrition : nutritionEntries) {
            sb.append(nutrition.toString()).append("\n");
        }
        nutritionRecordsText.setText(sb.toString());
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}