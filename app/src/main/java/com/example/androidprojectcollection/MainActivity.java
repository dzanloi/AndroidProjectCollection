package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;

    Button passInt;

    Button menus;

    Button maps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn_instagram);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this, instagram.class);
                startActivity(intent1);
            }
        });

        btn2 = findViewById(R.id.btnExercise);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openBtnAct = new Intent(MainActivity.this, buttonActivity.class);
                startActivity(openBtnAct);
            }
        });

        btn3 = findViewById(R.id.btnCalculator);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openCalc = new Intent(MainActivity.this, calculator.class);
                startActivity(openCalc);
            }
        });

        btn4 = findViewById(R.id.btnMatch);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openCandyCrush = new Intent(MainActivity.this, Match.class);
                startActivity(openCandyCrush);
            }
        });

        passInt = findViewById(R.id.btnPassingIntent);
        passInt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openPassingIntents = new Intent(MainActivity.this, PassingIntentsExercise.class);
                startActivity(openPassingIntents);
            }
        });

        menus = findViewById(R.id.btnMenu);
        menus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, menusExercise.class);
                startActivity(intent);
            }
        });

        maps = findViewById(R.id.btnMaps);
        maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, mapsExercise.class);
                startActivity(intent);
            }
        });

    }
}