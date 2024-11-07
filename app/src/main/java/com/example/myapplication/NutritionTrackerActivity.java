package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class NutritionTrackerActivity extends AppCompatActivity {

    private EditText caloriesInput, proteinInput, carbsInput, fatsInput;
    private Button saveButton;
    private TextView summaryText;
    private ProgressBar caloriesProgress, proteinProgress, carbsProgress, fatsProgress;
    private CheckBox veganCheckBox, ketoCheckBox;
    private RadioGroup fitnessGoalGroup;
    private RadioButton radioWeightLoss, radioMuscleGain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition_tracker);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        caloriesInput = findViewById(R.id.caloriesInput);
        proteinInput = findViewById(R.id.proteinInput);
        carbsInput = findViewById(R.id.carbsInput);
        fatsInput = findViewById(R.id.fatsInput);
        saveButton = findViewById(R.id.saveButton);
        summaryText = findViewById(R.id.summaryText);
        caloriesProgress = findViewById(R.id.caloriesProgress);
        proteinProgress = findViewById(R.id.proteinProgress);
        carbsProgress = findViewById(R.id.carbsProgress);
        fatsProgress = findViewById(R.id.fatsProgress);
        veganCheckBox = findViewById(R.id.veganCheckBox);
        ketoCheckBox = findViewById(R.id.ketoCheckBox);
        fitnessGoalGroup = findViewById(R.id.fitnessGoalGroup);
        radioWeightLoss = findViewById(R.id.radioWeightLoss);
        radioMuscleGain = findViewById(R.id.radioMuscleGain);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateNutrition();
            }
        });
    }

    private void updateNutrition() {
        int calories = Integer.parseInt(caloriesInput.getText().toString());
        int protein = Integer.parseInt(proteinInput.getText().toString());
        int carbs = Integer.parseInt(carbsInput.getText().toString());
        int fats = Integer.parseInt(fatsInput.getText().toString());

        // Assuming daily goals: 2000 calories, 150g protein, 225g carbs, 65g fats
        caloriesProgress.setProgress((calories * 100) / 2000);
        proteinProgress.setProgress((protein * 100) / 150);
        carbsProgress.setProgress((carbs * 100) / 225);
        fatsProgress.setProgress((fats * 100) / 65);

        String fitnessGoal = "";
        if (radioWeightLoss.isChecked()) {
            fitnessGoal = "Weight Loss";
        } else if (radioMuscleGain.isChecked()) {
            fitnessGoal = "Muscle Gain";
        }

        String dietTypes = "";
        if (veganCheckBox.isChecked()) {
            dietTypes += "Vegan Diet ";
        }
        if (ketoCheckBox.isChecked()) {
            dietTypes += "Keto Diet ";
        }

        String summary = String.format("Today's Intake:\nCalories: %d/2000\nProtein: %d/150g\nCarbs: %d/225g\nFats: %d/65g\n" +
                "Fitness Goal: %s\nDiet Type: %s", calories, protein, carbs, fats, fitnessGoal, dietTypes);
        summaryText.setText(summary);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
