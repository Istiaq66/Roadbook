package com.istiaq66.roadbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Ride extends AppCompatActivity {


    RadioButton radioButton1, radioButton2;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ride);

        radioButton1 = findViewById(R.id.rdo_btn_place1);
        radioButton2 = findViewById(R.id.rdo_btn_place2);
        btn = findViewById(R.id.where_to_go);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Ride.this,Set_destination.class);
                startActivity(intent);
            }
        });
    }
}