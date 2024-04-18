package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class PassingIntentsExercise extends AppCompatActivity {
    private Button btnRegister;
    private EditText firstName;
    private EditText lastName;
    private EditText birthDate;
    private EditText homeAddress;
    private EditText phoneNumber;
    private EditText emailAddress;
    private EditText studentID;
    private Spinner dropdownProgram;

    private String[] programs = {"Select Program", "BS in Computer Science", "BS in Data Science", "BS in Information Systems", "BS in Information Technology", "BS in Nursing", "BS in Psychology",
                                    "BS in Civil Engineering", "BS in Medical Technology", "BS in Mechanical Engineering",};
    private RadioButton rMale;
    private RadioButton rFemale;
    private RadioButton rOthers;

    private ArrayAdapter programAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_intents_exercise);

        setupView();
    }

    private void setupFields() {
        btnRegister = (Button) findViewById(R.id.registrationBtn);
//        btnClearFields = (Button) findViewById(R.id.btnClearFields);

        dropdownProgram = (Spinner) findViewById(R.id.dropdownProgram);

        firstName = (EditText) findViewById(R.id.txtFname);
        lastName = (EditText) findViewById(R.id.txtLname);
        birthDate = (EditText) findViewById(R.id.txtBdate);
        homeAddress = (EditText) findViewById(R.id.txtAddress);
        phoneNumber = (EditText) findViewById(R.id.txtPhone);
        emailAddress = (EditText) findViewById(R.id.txtEmail);
        studentID = (EditText) findViewById(R.id.txtSid);
        rMale = (RadioButton) findViewById(R.id.radMale);
        rFemale = (RadioButton) findViewById(R.id.radFemale);
        rOthers = (RadioButton) findViewById(R.id.radOthers);

        programAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, programs);
        dropdownProgram.setAdapter(programAdapter);
    }

    private void setupView() {
        setupFields();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fname = firstName.getText().toString();
                String lname = lastName.getText().toString();
                String bDate = birthDate.getText().toString();
                String pNumber = phoneNumber.getText().toString();
                String emailAdd = emailAddress.getText().toString();
                String homeAdd = homeAddress.getText().toString();
                String studid = studentID.getText().toString();
                String program = dropdownProgram.getSelectedItem().toString();
                String gender;

                if (rMale.isChecked())
                    gender = "Male";
                else if (rFemale.isChecked())
                    gender = "Female";
                else if (rOthers.isChecked())
                    gender = "Others";
                else
                    gender = "Unknown";

//          String yearLevel = dropdownYearLvl.getSelectedItem().toString();
//          String maritalStatus = dropdownMaritalStatus.getSelectedItem().toString();

                if (bDate.isEmpty() || pNumber.isEmpty() || emailAdd.isEmpty() || homeAdd.isEmpty() ||  program.isEmpty() || /*yearLevel.isEmpty() || maritalStatus.isEmpty() || */ studid.isEmpty()) {
                    Toast.makeText(PassingIntentsExercise.this, "Please input the required areas.", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(PassingIntentsExercise.this, PassingIntentsExercise2.class);

                    intent.putExtra("fname_key", fname);
                    intent.putExtra("gender_key", gender);
                    intent.putExtra("pnum_key", pNumber);
                    intent.putExtra("lname_key", lname);
                    intent.putExtra("bdate_key", bDate);
                    intent.putExtra("email_add_key", emailAdd);
                    intent.putExtra("home_add_key", homeAdd);
                    intent.putExtra("program_key", program);
//                    intent.putExtra("yearlvl_key", yearLevel);
                    intent.putExtra("studid_key", studid);
//                    intent.putExtra("status_key", maritalStatus);

                    startActivity(intent);
                    Toast.makeText(PassingIntentsExercise.this, "Form Submitted Successfully", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }
}