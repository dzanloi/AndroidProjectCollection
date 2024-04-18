package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Match extends AppCompatActivity {
    private static final int[] COLORS = {
            android.R.color.holo_blue_light,
            android.R.color.holo_green_light,
            android.R.color.holo_orange_light,
            android.R.color.holo_purple,
            android.R.color.holo_red_light
    };
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);

        Button[] buttons = new Button[]{
                findViewById(R.id.button1), findViewById(R.id.button2), findViewById(R.id.button3), findViewById(R.id.button4), findViewById(R.id.button5),
                findViewById(R.id.button6), findViewById(R.id.button7), findViewById(R.id.button8), findViewById(R.id.button9), findViewById(R.id.button10),
                findViewById(R.id.button11), findViewById(R.id.button12), findViewById(R.id.button13), findViewById(R.id.button14), findViewById(R.id.button15),
                findViewById(R.id.button16), findViewById(R.id.button17), findViewById(R.id.button18), findViewById(R.id.button19), findViewById(R.id.button20),
                findViewById(R.id.button21), findViewById(R.id.button22), findViewById(R.id.button23), findViewById(R.id.button24), findViewById(R.id.button25)
        };

        for (Button btn : buttons) {
            int randomColor = getResources().getColor(COLORS[(int) (Math.random() * COLORS.length)]);
            btn.setBackgroundColor(randomColor);
        }


    }

    public void swapColors(Button button1, Button button2) {
        int color1 = ((ColorDrawable) button1.getBackground()).getColor();
        int color2 = ((ColorDrawable) button2.getBackground()).getColor();

        button1.setBackgroundColor(color2);
        button2.setBackgroundColor(color1);
    }

    public void updateScore() {
        TextView scoreText = findViewById(R.id.scoreText);
        scoreText.setText("Score: " + score);
    }


}