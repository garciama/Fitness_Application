package com.example.logindemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Declaring variables.
    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Assigning variables defined in XML layout
        Name = (EditText)findViewById(R.id.etName);
        Password = (EditText)findViewById(R.id.etPassword);
        Info = (TextView)findViewById(R.id.tvInfo);
        Login = (Button)findViewById(R.id.btnLogin);

        // Initialize Info section
        Info.setText("# of attempts remaining: 5");

        // Set listener for login button to check username and password.
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(), Password.getText().toString());
            }
        });

    }

    // Function to validate the users username and password.
    private void validate(String userName, String userPassword){
        if((userName.equals("Admin")) && (userPassword.equals("1234"))){
            // Intent basically used to go from one activity to another
            // source and destination parameters, .this for source and .class for destination
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            // startActivity function starts the activity described in above intent
            startActivity(intent);
        }
        else{
            // If incorrect password, take down counter for number of attempts left
            counter--;

            // Update user on # of attempts left
            Info.setText("# of attempts remaining: " + String.valueOf(counter));

            // Once no more attempts left, don't let user log in.
            if(counter == 0){
                Login.setEnabled(false); //disables button
            }
        }
    }
}
