package com.istiaq66.roadbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Set_destination extends AppCompatActivity {



    Button btn;
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_destination);


        btn = findViewById(R.id.confirm_btn);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(Set_destination.this, Avail_rides.class);
                startActivity(intent);
            }
        });



    }
}