package com.example.cabme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.rilixtech.widget.countrycodepicker.CountryCodePicker;

import java.util.concurrent.TimeUnit;

public class MainActivity2 extends AppCompatActivity {

    FirebaseAuth fAuth;
    EditText phoneNumber;
    Button nextBtn;
    CountryCodePicker codePicker;
    String verificationId;
    ProgressBar progressBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        fAuth = FirebaseAuth.getInstance();
        phoneNumber = findViewById(R.id.phone);
        nextBtn = findViewById(R.id.nextBtn);
        codePicker = findViewById(R.id.ccp);
        progressBar = findViewById(R.id.progressBar2);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              if (!phoneNumber.getText().toString().isEmpty() && phoneNumber.getText().toString().length() == 10){
                    String phoneNum = "+" + codePicker.getSelectedCountryCode()+phoneNumber.getText().toString();
                    requestOTP(phoneNum);
                    progressBar.setVisibility(View.VISIBLE);

                }else {
                    phoneNumber.setError("Phone Number is not valid");
                    progressBar.setVisibility(View.GONE);
                }
            }

        });
}
    private void requestOTP(String phoneNum) {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(phoneNum, 60L, TimeUnit.SECONDS, this, new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            @Override
            public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(s, forceResendingToken);
                nextBtn.setText("Verifying");
                verificationId = s;
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                intent.putExtra("verificationId", verificationId);
                startActivity(intent);
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onCodeAutoRetrievalTimeOut(@NonNull String s) {
                super.onCodeAutoRetrievalTimeOut(s);
            }

            @Override
            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

            }

            @Override
            public void onVerificationFailed(@NonNull FirebaseException e) {
                Toast.makeText(MainActivity2.this, "cannot create account" + e.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}