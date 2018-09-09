package com.example.logindemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assigning variables defined in XML layout
        Name = (EditText)findViewById(R.id.etName);
        Password = (EditText)findViewById(R.id.etPassword);
        Info = (TextView)findViewById(R.id.tvInfo);
        Login = (Button)findViewById(R.id.btnLogin);

        //initialize Info section
        Info.setText("# of attempts remaining: 5");

        //set listener for button
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(), Password.getText().toString());
            }
        });

    }

    //Function to validate the users username and password.
    private void validate(String userName, String userPassword){
        if((userName.equals("Admin")) && (userPassword.equals("1234"))){
            //intent basically used to go from one activity to another
            //source and destination parameters, .this for source and .class for destination
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            //startActivity function starts the activity described in above intent
            startActivity(intent);
        }
        else{
            //if incorrect password, take down counter for number of attempts left
            counter--;

            //update user on # of attempts left
            Info.setText("# of attempts remaining: " + String.valueOf(counter));

            if(counter == 0){
                Login.setEnabled(false); //disables button
            }
        }
    }
}
