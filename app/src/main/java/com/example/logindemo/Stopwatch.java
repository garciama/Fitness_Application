package com.example.logindemo;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;
import android.widget.Toast;

public class Stopwatch extends AppCompatActivity {
    private Chronometer chrono;
    //indicate if chronomoter is running
    private boolean running;
    private long pauseOffset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);

        chrono = findViewById(R.id.chrono);
        // %s will be replaced by actual clocktime
        //chrono.setFormat("Time: %s");
        // to update string when we start the activity.
        chrono.setBase(SystemClock.elapsedRealtime());

        /* You can do something special for every tick that passes.
        chrono.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                //for example we can reset the chronometer once it gets to 10 seconds
                if ((SystemClock.elapsedRealtime() - chronometer.getBase()) >= 10000) {
                    chronometer.setBase(SystemClock.elapsedRealtime());
                    Toast.makeText(Stopwatch.this,"Bing!", Toast.LENGTH_SHORT);
                }
            }
        }); */
    }

    public void startChronometer(View v){
        if ( !running ) {
            //from default, the chrono starts from time the activity opened
            //so we use this setBase function to make the timer start when we click button
            chrono.setBase(SystemClock.elapsedRealtime() - pauseOffset);
            chrono.start();
            running = true;
        }
    }

    public void pauseChronometer(View v){
        if (running) {
            //by default, chrono.stop only stops the text, not the chronometer
            //so we have to set it ourself with our variable called pauseOffest.
            chrono.stop();
            //takes current elapsed real time minus system clock elapsed real time
            pauseOffset = SystemClock.elapsedRealtime() - chrono.getBase();
            running = false;
        }
    }

    public void resetChronometer(View v){
        //both of these commands reset the chronometer
        chrono.setBase(SystemClock.elapsedRealtime());
        pauseOffset = 0;
    }

    public void goBack(View v){
        Intent backIntent = new Intent(Stopwatch.this, SecondActivity.class);
        startActivity(backIntent);
    }
}
