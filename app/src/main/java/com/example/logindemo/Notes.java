package com.example.logindemo;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Notes extends AppCompatActivity {

    // Declaring variables
    private Button Back;
    private FloatingActionButton saveButton;
    private EditText EditText1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        // Assigning variable to button located on XML layout.
        saveButton = (FloatingActionButton) findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // When saveButton is clicked, "Save" function is called.
                Save("Note1.txt");
            }
        });

        // Assigning editText to notes section
        EditText1 = (EditText)findViewById(R.id.notesSection);
        // Calling "Open" method to fill notes section with previously saved notes.
        EditText1.setText(Open("Note1.txt"));

        // Assign button to XML ID
        Back = (Button)findViewById(R.id.backButton);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent basically used to go from one activity to another
                // source and destination parameters, .this for source and .class for destination
                Intent backIntent = new Intent(Notes.this, SecondActivity.class);
                startActivity(backIntent);
            }
        });
    }

    // Method to save the users notes internally, which basically means that
    // only this app can view the saved notes. Also, if the user deletes the app
    // then the saved notes will be lost.
    public void Save(String fileName) {
        try {
            OutputStreamWriter out =
                    new OutputStreamWriter(openFileOutput(fileName, 0));
            out.write(EditText1.getText().toString());
            out.close();
            // A toast is a view containing a quick little message for the user.
            Toast.makeText(this, "Note Saved!", Toast.LENGTH_SHORT).show();
        } catch (Throwable t) {
            Toast.makeText(this, "Exception: " + t.toString(), Toast.LENGTH_LONG).show();
        }
    }

    // Method to open previously saved notes
    public String Open(String fileName) {
        String content = "";
        if (FileExists(fileName)) {
            try {
                InputStream in = openFileInput(fileName);
                if ( in != null) {
                    InputStreamReader tmp = new InputStreamReader( in );
                    BufferedReader reader = new BufferedReader(tmp);
                    String str;
                    StringBuilder buf = new StringBuilder();
                    while ((str = reader.readLine()) != null) {
                        buf.append(str + "\n");
                    } in .close();
                    content = buf.toString();
                }
            } catch (java.io.FileNotFoundException e) {} catch (Throwable t) {
                Toast.makeText(this, "Exception: " + t.toString(), Toast.LENGTH_LONG).show();
            }
        }
        return content;
    }

    // Method to check if the file we are trying to load actually exists.
    public boolean FileExists(String fname){
        File file = getBaseContext().getFileStreamPath(fname);
        return file.exists();
    }
}
