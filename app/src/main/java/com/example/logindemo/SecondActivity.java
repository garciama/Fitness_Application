package com.example.logindemo;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private Button Nutrition;
    private Button Workout;
    private Button Notes;
    private Button Timer;
    private Button Stopwatch;
    private FloatingActionButton Logout;

    //add calendar for meal plans
    //health tips area, suggested workouts based on user info (such as weight loss, strength, gender
    //weight and height
    //goals section (possibly have a reminder/progression on login)


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //assigning variables to ID's defined in XML layout
        Nutrition = (Button)findViewById(R.id.btnNutrition);
        Workout = (Button)findViewById(R.id.btnWorkout);
        Notes = (Button)findViewById(R.id.btnNotes);
        Timer = (Button)findViewById(R.id.btnTimer);
        Logout = (FloatingActionButton)findViewById(R.id.btnLogout);
        Stopwatch = (Button)findViewById(R.id.btnStopwatch);

        //set listeners for buttons
        Nutrition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //intent basically used to go from one activity to another
                //source and destination parameters, .this for source and .class for destination
                Intent nutritionIntent = new Intent(SecondActivity.this, Nutrition.class);
                startActivity(nutritionIntent);
            }
        });

        Workout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //intent basically used to go from one activity to another
                //source and destination parameters, .this for source and .class for destination
                Intent workoutIntent = new Intent(SecondActivity.this, Workout.class);
                startActivity(workoutIntent);
            }
        });

        Notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //intent basically used to go from one activity to another
                //source and destination parameters, .this for source and .class for destination
                Intent notesIntent = new Intent(SecondActivity.this, Notes.class);
                startActivity(notesIntent);
            }
        });

        Timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //intent basically used to go from one activity to another
                //source and destination parameters, .this for source and .class for destination
                Intent timerIntent = new Intent(SecondActivity.this, Timer.class);
                startActivity(timerIntent);
            }
        });

        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //intent basically used to go from one activity to another
                //source and destination parameters, .this for source and .class for destination
                Intent logoutIntent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(logoutIntent);
            }
        });

        Stopwatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //intent basically used to go from one activity to another
                //source and destination parameters, .this for source and .class for destination
                Intent stopwatchIntent = new Intent(SecondActivity.this, Stopwatch.class);
                startActivity(stopwatchIntent);
            }
        });


    }
}
