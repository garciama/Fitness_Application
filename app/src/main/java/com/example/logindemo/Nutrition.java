package com.example.logindemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Nutrition extends AppCompatActivity {

    private Button Back;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition);


        //assign button to XML ID
        Back = (Button)findViewById(R.id.backButton);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //intent basically used to go from one activity to another
                //source and destination parameters, .this for source and .class for destination
                Intent backIntent = new Intent(Nutrition.this, SecondActivity.class);
                startActivity(backIntent);
            }
        });

    }
}
