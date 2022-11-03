package com.istiaq66.roadbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Avail_rides extends AppCompatActivity  {


    ImageView ride1, ride2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avail_rides);

        ride1 = findViewById(R.id.ride1);
        ride2 = findViewById(R.id.ride2);

        ride1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ride1.setSelected(true);
                ride2.setSelected(false);
            }
        });


        ride2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ride2.setSelected(true);
                ride1.setSelected(false);
            }
        });

    }



}