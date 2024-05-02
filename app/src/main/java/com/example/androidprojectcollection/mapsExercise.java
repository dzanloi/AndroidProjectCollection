package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class mapsExercise extends AppCompatActivity {
    ImageButton btnTops;
    ImageButton btnPeak;
    ImageButton btnKyoto;
    ImageButton btnDam;
    ImageButton btnSeaside;

    static boolean trigger = false;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_exercise);

        btnTops = findViewById(R.id.cebuTops);
        btnTops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo: 10.370595, 123.870866"));
                startActivity(intent);

                getWindow().setBackgroundDrawableResource(R.drawable.tops_streetview);

                btnTops.setScaleX(1.5F);
                btnTops.setScaleY(1.5F);

                btnDam.setScaleX(1);
                btnDam.setScaleY(1);

                btnPeak.setScaleY(1);
                btnPeak.setScaleX(1);

                btnKyoto.setScaleX(1);
                btnKyoto.setScaleY(1);

                btnSeaside.setScaleX(1);
                btnSeaside.setScaleY(1);
            }
        });

        btnPeak = findViewById(R.id.osmenaPeak);
        btnPeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo: 9.8225, 123.448333"));
                startActivity(intent);

                getWindow().setBackgroundDrawableResource(R.drawable.peak_streetview);

                btnPeak.setScaleX(1.5F);
                btnPeak.setScaleY(1.5F);

                btnDam.setScaleX(1);
                btnDam.setScaleY(1);

                btnTops.setScaleY(1);
                btnTops.setScaleX(1);

                btnKyoto.setScaleX(1);
                btnKyoto.setScaleY(1);

                btnSeaside.setScaleX(1);
                btnSeaside.setScaleY(1);
            }
        });

        btnKyoto = findViewById(R.id.littleKyoto);
        btnKyoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo: 10.371310, 123.855289"));
                startActivity(intent);

                getWindow().setBackgroundDrawableResource(R.drawable.kyoto_streetview);

                btnTops.setScaleX(1);
                btnTops.setScaleY(1);

                btnDam.setScaleX(1);
                btnDam.setScaleY(1);

                btnPeak.setScaleY(1);
                btnPeak.setScaleX(1);

                btnKyoto.setScaleX(1.5F);
                btnKyoto.setScaleY(1.5F);

                btnSeaside.setScaleX(1);
                btnSeaside.setScaleY(1);

            }
        });

        btnDam = findViewById(R.id.buhisanDam);
        btnDam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo: 10.314965, 123.847599"));
                startActivity(intent);

                getWindow().setBackgroundDrawableResource(R.drawable.dam_streetview);

                btnTops.setScaleX(1);
                btnTops.setScaleY(1);

                btnDam.setScaleX(1.5F);
                btnDam.setScaleY(1.5F);

                btnPeak.setScaleY(1);
                btnPeak.setScaleX(1);

                btnKyoto.setScaleX(1);
                btnKyoto.setScaleY(1);

                btnSeaside.setScaleX(1);
                btnSeaside.setScaleY(1);
            }
        });

        btnSeaside = findViewById(R.id.smSeaside);
        btnSeaside.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo: 10.281947, 123.882908"));
                startActivity(intent);

                getWindow().setBackgroundDrawableResource(R.drawable.seaside_streetview);

                btnTops.setScaleX(1);
                btnTops.setScaleY(1);

                btnDam.setScaleX(1);
                btnDam.setScaleY(1);

                btnPeak.setScaleY(1);
                btnPeak.setScaleX(1);

                btnKyoto.setScaleX(1);
                btnKyoto.setScaleY(1);

                btnSeaside.setScaleX(1.5F);
                btnSeaside.setScaleY(1.5F);
            }
        });
    }
}