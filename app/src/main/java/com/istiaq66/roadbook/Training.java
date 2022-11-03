package com.istiaq66.roadbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

public class Training extends AppCompatActivity {



    ImageSlider imageSlider;

    ImageView btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);


        imageSlider = findViewById(R.id.image_slider2);
        btn = findViewById(R.id.training_back);


        List<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.trainer1, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.trainer2, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.trainer3, ScaleTypes.FIT));

        imageSlider.setImageList(slideModels, ScaleTypes.FIT);





        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Training.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}