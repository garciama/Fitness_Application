package com.example.logindemo;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Timer extends AppCompatActivity {

    private Button Back, Start, Reset;
    private int userMilliseconds;
    private String userInput;
    private TextView timerView;
    private EditText timerInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        //assign variables to XML ID's
        Back = (Button)findViewById(R.id.backButton);
        Start = (Button)findViewById(R.id.timerStart);
        Reset = (Button)findViewById(R.id.timerReset);
        timerView = (TextView)findViewById(R.id.timerView);
        timerInput = (EditText)findViewById(R.id.timerInput);


        Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userInput = timerInput.getText().toString();
                userMilliseconds = 1000 * (Integer.parseInt(userInput));
                CountDownTimer myTimer = new CountDownTimer(userMilliseconds, 1000){
                    public void onTick(long millisUntilFinished){
                        timerView.setText("" + millisUntilFinished/1000 );
                    }
                    @Override
                    public void onFinish() {
                        timerView.setText("TIMES UP");
                    }
                }.start();
            }
        });
        Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //just refreshing the activity
                finish();
                overridePendingTransition(0, 0);
                startActivity(getIntent());
            }
        });
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //intent basically used to go from one activity to another
                //source and destination parameters, .this for source and .class for destination
                Intent backIntent = new Intent(Timer.this, SecondActivity.class);
                startActivity(backIntent);
            }
        });
    }

}
