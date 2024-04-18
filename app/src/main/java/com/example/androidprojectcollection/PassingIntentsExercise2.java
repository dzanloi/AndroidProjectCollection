package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PassingIntentsExercise2 extends AppCompatActivity {
    private TextView dFirstName;
    private TextView dLastName;
    private TextView dGender;
    private TextView dBirthDate;
    private TextView dHomeAddress;
    private TextView dPhoneNumber;
    private TextView dEmailAddress;
    private TextView dProgram;
    private TextView dYearLevel;
    private TextView dStudentID;
    private Button btnReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_intents_exercise2);

        setView();
    }

    private void setUpFields(){
        dFirstName = (TextView) findViewById(R.id.dFirstName);
        dLastName = (TextView) findViewById(R.id.dLastName);
        dGender = (TextView) findViewById(R.id.dGender);
        dBirthDate = (TextView) findViewById(R.id.dBirthDate);
        dHomeAddress = (TextView) findViewById(R.id.dHomeAddress);
        dPhoneNumber = (TextView) findViewById(R.id.dPhoneNumber);
        dEmailAddress = (TextView) findViewById(R.id.dEmailAddress);
        dProgram = (TextView) findViewById(R.id.dProgram);
        dYearLevel = (TextView) findViewById(R.id.dYearLevel);
        dStudentID = (TextView) findViewById(R.id.dStudentID);
        btnReturn = (Button) findViewById(R.id.btnReturn);
    }

    private void setView(){
        setUpFields();
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Intent intent = getIntent();
        dFirstName.setText(intent.getStringExtra("fname_key"));
        dLastName.setText(intent.getStringExtra("lname_key"));
        dGender.setText(intent.getStringExtra("gender_key"));
        dBirthDate.setText(intent.getStringExtra("bdate_key"));
        dHomeAddress.setText(intent.getStringExtra("home_add_key"));
        dPhoneNumber.setText(intent.getStringExtra("pnum_key"));
        dEmailAddress.setText(intent.getStringExtra("email_add_key"));
        dProgram.setText(intent.getStringExtra("program_key"));
        dYearLevel.setText(intent.getStringExtra("yearlvl_key"));
        dStudentID.setText(intent.getStringExtra("studid_key"));
    }
}