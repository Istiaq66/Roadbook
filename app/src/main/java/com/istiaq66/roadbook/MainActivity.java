package com.istiaq66.roadbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    ImageSlider imageSlider;
    private long backPressedTime;
    ImageButton menu_btn,noti_btn;
    CardView guide_btn,ride_btn,train_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageSlider = findViewById(R.id.image_slider);
        menu_btn = findViewById(R.id.menu_btn);
        guide_btn = findViewById(R.id.guidance_btn);
        ride_btn = findViewById(R.id.ride_btn);
        noti_btn = findViewById(R.id.notification_btn);
        train_btn = findViewById(R.id.training_btn);



        List<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.offer1, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.offer2, ScaleTypes.FIT));
        imageSlider.setImageList(slideModels, ScaleTypes.FIT);


        menu_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,Menu.class);
                startActivity(intent);
                overridePendingTransition(R.anim.left_slide_in,R.anim.right_slide_out);

            }
        });

        noti_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, Notifcation.class);
                startActivity(intent);
            }
        });



        guide_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,Guidance.class);
                startActivity(intent);

            }
        });


        train_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,Training.class);
                startActivity(intent);

            }
        });

        ride_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,Ride.class);
                startActivity(intent);

            }
        });

    }



    //----Exit app----//
    @Override
    public void onBackPressed() {

        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            super.onBackPressed();
            this.finishAffinity();
            return;
        } else {
            Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT).show();
        }
        backPressedTime = System.currentTimeMillis();

    }
}