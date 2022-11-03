package com.istiaq66.roadbook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class Get_OTP extends AppCompatActivity {

    RadioButton radioButton;
    Button fb, google, get_otp;
    private long backPressedTime;
    EditText mobile_no;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_otp);
        radioButton = findViewById(R.id.rdo_btn);
        fb = findViewById(R.id.fb_btn);
        google = findViewById(R.id.google_btn);
        get_otp = findViewById(R.id.get_otp);
        mobile_no = findViewById(R.id.mobile_no);
        progressBar = findViewById(R.id.progress);
        progressBar.setVisibility(View.INVISIBLE);
        get_otp.setEnabled(false);


        radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                get_otp.setEnabled(true);
            }
        });

        radioButton.setMovementMethod(LinkMovementMethod.getInstance());


        get_otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Get_OTP.this,OTP_verification.class);
                intent.putExtra("mobile",mobile_no.getText().toString());
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