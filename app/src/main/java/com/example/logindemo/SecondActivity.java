package com.example.logindemo;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    // Declaring variables.
    private Button Nutrition;
    private Button Workout;
    private Button Notes;
    private Button Timer;
    private Button Stopwatch;
    private FloatingActionButton Logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Assigning variables to ID's defined in XML layout
        Nutrition = (Button)findViewById(R.id.btnNutrition);
        Workout = (Button)findViewById(R.id.btnWorkout);
        Notes = (Button)findViewById(R.id.btnNotes);
        Timer = (Button)findViewById(R.id.btnTimer);
        Logout = (FloatingActionButton)findViewById(R.id.btnLogout);
        Stopwatch = (Button)findViewById(R.id.btnStopwatch);

        // Setting listeners for buttons:
        Nutrition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent basically used to go from one activity to another.
                // Source and destination parameters, .this for source and .class for destination.
                Intent nutritionIntent = new Intent(SecondActivity.this, Nutrition.class);
                startActivity(nutritionIntent);
            }
        });

        // Clicking workout button will redirect user to Workout activity.
        Workout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent workoutIntent = new Intent(SecondActivity.this, Workout.class);
                startActivity(workoutIntent);
            }
        });

        // Clicking Notes button will redirect user to Notes activity.
        Notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent notesIntent = new Intent(SecondActivity.this, Notes.class);
                startActivity(notesIntent);
            }
        });

        // Clicking Timer button will redirect user to Timer activity.
        Timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent timerIntent = new Intent(SecondActivity.this, Timer.class);
                startActivity(timerIntent);
            }
        });

        // Clicking Stopwatch button will redirect user to Stopwatch activity.
        Stopwatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent stopwatchIntent = new Intent(SecondActivity.this, Stopwatch.class);
                startActivity(stopwatchIntent);
            }
        });

        // Clicking the top right logout button brings user to Login screen.
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent logoutIntent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(logoutIntent);
            }
        });
    }
}
