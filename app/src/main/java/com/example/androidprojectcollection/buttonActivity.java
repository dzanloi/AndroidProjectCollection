package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class buttonActivity extends AppCompatActivity {
    Button close;
    Button toast;
    Button background;
    Button btnbackground;
    Button disappear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        close = findViewById(R.id.btnClose);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(buttonActivity.this, returnBtnAct.class);
                startActivity(intent);
            }
        });

        toast = findViewById(R.id.btnToast);
        toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int dur = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(buttonActivity.this, "TOASTED", dur);
                toast.show();
            }
        });

        background = findViewById(R.id.btnChangeBG);
        background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getWindow().getDecorView().setBackgroundColor(Color.CYAN);
            }
        });

        btnbackground = findViewById(R.id.btnChangeBtnBG);
        btnbackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnbackground.setBackgroundColor(Color.DKGRAY);
            }
        });

        disappear = findViewById(R.id.btnDisappear);
        disappear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                disappear.setVisibility(View.INVISIBLE);
                disappear.setClickable(false);
            }
        });
    }
}