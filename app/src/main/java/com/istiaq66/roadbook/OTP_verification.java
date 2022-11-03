package com.istiaq66.roadbook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class OTP_verification extends AppCompatActivity {

    private EditText input_code1, input_code2, input_code3, input_code4, input_code5, input_code6;
    TextView user_mb;
    ProgressBar progressBar;
    Button btn_verify;
    String verificationId, phone;
    FirebaseAuth mAuth;
    String vcode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_verification);

        input_code1 = findViewById(R.id.input_code1);
        input_code2 = findViewById(R.id.input_code2);
        input_code3 = findViewById(R.id.input_code3);
        input_code4 = findViewById(R.id.input_code4);
        input_code5 = findViewById(R.id.input_code5);
        input_code6 = findViewById(R.id.input_code6);
        user_mb = findViewById(R.id.user_mb_no);
        btn_verify = findViewById(R.id.verify_btn);
        progressBar = findViewById(R.id.progress2);
        progressBar.setVisibility(View.INVISIBLE);
        mAuth = FirebaseAuth.getInstance();
        user_mb.setText(String.format("+88-%s", getIntent().getStringExtra("mobile")));
        phone = (String.format("+88-%s", getIntent().getStringExtra("mobile")));

        //---------OTP box----------//
        setupOTPInputs();
        //---------OTP box----------//

    //    initiateotp();





        //--------------Verify----------------//

        btn_verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                progressBar.setVisibility(View.VISIBLE);
                btn_verify.setVisibility(View.INVISIBLE);

                vcode = input_code1.getText().toString() +
                        input_code2.getText().toString() +
                        input_code3.getText().toString() +
                        input_code4.getText().toString() +
                        input_code5.getText().toString() +
                        input_code5.getText().toString();

                if (input_code1.getText().toString().trim().isEmpty()
                        || input_code2.getText().toString().trim().isEmpty()
                        || input_code3.getText().toString().trim().isEmpty()
                        || input_code4.getText().toString().trim().isEmpty()
                        || input_code5.getText().toString().trim().isEmpty()
                        || input_code6.getText().toString().trim().isEmpty()) {


                    Toast.makeText(OTP_verification.this, "Please enter valid code", Toast.LENGTH_SHORT).show();
                    return;
                } else {

                    progressBar.setVisibility(View.GONE);
                    startActivity(new Intent(OTP_verification.this, MainActivity.class));

                    finish();
//                 PhoneAuthCredential credential=PhoneAuthProvider.getCredential(verificationId,vcode);
//                  signInWithPhoneAuthCredential(credential);

                }

            }
        });


    }


    private void initiateotp() {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phone,        // Phone number to verify
                60,                 // Timeout duration
                TimeUnit.SECONDS,   // Unit of timeout
                this,               // Activity (for callback binding)
                new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                    @Override
                    public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                        verificationId = s;
                    }

                    @Override
                    public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
                        signInWithPhoneAuthCredential(phoneAuthCredential);
                    }

                    @Override
                    public void onVerificationFailed(FirebaseException e) {
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });        // OnVerificationStateChangedCallbacks

    }


    private void setupOTPInputs() {
        input_code1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (!charSequence.toString().trim().isEmpty()) {
                    input_code2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        input_code2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (!charSequence.toString().trim().isEmpty()) {
                    input_code3.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        input_code3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (!charSequence.toString().trim().isEmpty()) {
                    input_code4.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        input_code4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (!charSequence.toString().trim().isEmpty()) {
                    input_code5.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        input_code5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (!charSequence.toString().trim().isEmpty()) {
                    input_code6.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }


    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            progressBar.setVisibility(View.GONE);
                            startActivity(new Intent(OTP_verification.this, MainActivity.class));

                            finish();
                        } else {
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(getApplicationContext(), "SignIn Code error", Toast.LENGTH_LONG).show();

                        }
                    }
                });

    }
}
