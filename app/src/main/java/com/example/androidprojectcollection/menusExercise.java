package com.example.androidprojectcollection;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class menusExercise extends AppCompatActivity {
    Button btnChanger;
    int[] buttonColors = {Color.RED, Color.BLUE, Color.YELLOW, Color.GREEN, Color.argb(1, 0, 255, 128)};
    int[] textColors = {Color.BLACK, Color.WHITE};
    int[] textStyles = {Typeface.BOLD, Typeface.ITALIC, Typeface.BOLD_ITALIC};
    String[] textss = {"Hi JARVIS", "WAKANDAFOREVA", "OSAS", "Brix Biayot"};
    Random random;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menus_exercise);

        btnChanger = findViewById(R.id.btnTransformingButton);
        btnChanger.setTextColor(Color.BLACK);
        btnChanger.setBackgroundColor(Color.RED);
        random = new Random();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menus_exercise_r, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.mItemChange) {
            Toast.makeText(this, "Edit Object Item is clicked", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.mItemReset) {                                //RESETttttttttttttttttttttttttttttttt
            btnChanger.setBackgroundColor(Color.YELLOW);
            btnChanger.setTextColor(Color.BLACK);
            btnChanger.setTranslationX(0);
            btnChanger.setTranslationY(0);
            btnChanger.setText("GLOOO");
            btnChanger.setScaleX(1);
            btnChanger.setScaleY(1);
            btnChanger.setRotation(0);
            Toast.makeText(this, "Reset Object Item is clicked", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.mItemExit){
            finish();
        } else if (item.getItemId() == R.id.mItemSizeChange) {                         //CHANGE SIZEEEeeeeeeeeeeeeeeeeeeeeeeeeeeeeee
            btnChanger.setScaleX(random.nextInt(2000) / 1000.0f + 0.5f);
            btnChanger.setScaleY(random.nextInt(2000) / 1000.0f + 0.5f);
            Toast.makeText(this, "Object Size Item is clicked", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.mItemBGChange) {                            //CHANGE BACKGROUND AND TEXT COLORrrrrrrrrrrrrrrrrrrrrrr
            btnChanger.setTextColor(
                    textColors[random.nextInt(textColors.length)]
            );
            btnChanger.setBackgroundColor(
                    buttonColors[random.nextInt(buttonColors.length)]
            );
            Toast.makeText(this, "Background and Text Color Change Object Item is Clicked", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.mItemRotationChange) {                      //TUYOCCcccccccccccccccccccccccccccccccc
            btnChanger.setRotation((float) random.nextInt(360));
            Toast.makeText(this, "Rotation Change Object Item is clicked",Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.mItemTextChange) {                          //TEXT CHANGEEDsdddddddddddddddddddddddddddddd
            btnChanger.setText(
                    textss[random.nextInt(textss.length)]
            );
            Toast.makeText(this, "Text Change Object Item is clicked", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.mItemTextStyle) {                           //CHANGE TEXT STYLESSSSSSSSSSSssssssssssssssssssss
            btnChanger.setTypeface(
                    Typeface.defaultFromStyle(textStyles[random.nextInt(textStyles.length)]) //TITITITITITITITITITITTITI
            );
        } else if (item.getItemId() == R.id.mItemOrientation) {
            if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {

            }

        }
        return true;
    }
}

