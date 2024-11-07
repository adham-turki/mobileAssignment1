package com.example.myapplication;

public class Workout {
    private String exercise;
    private String sets;
    private String reps;

    public Workout(String exercise, String sets, String reps) {
        this.exercise = exercise;
        this.sets = sets;
        this.reps = reps;
    }

    public String getExercise() {
        return exercise;
    }

    public String getSets() {
        return sets;
    }

    public String getReps() {
        return reps;
    }

    @Override
    public String toString() {
        return exercise + " - " + sets + ", " + reps;
    }
}