package com.istiaq66.roadbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Lead_path extends AppCompatActivity {


    Button start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lead_path);

        start =findViewById(R.id.get_started);


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(Lead_path.this,Get_OTP.class);
                startActivity(intent);
                finish();
            }
        });


    }
}