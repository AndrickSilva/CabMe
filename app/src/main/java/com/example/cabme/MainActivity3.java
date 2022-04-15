package com.example.cabme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

public class MainActivity3 extends AppCompatActivity {

    FirebaseAuth fAuth;
    EditText codeEnter;
    Button verifyBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        fAuth = FirebaseAuth.getInstance();
        codeEnter = findViewById(R.id.codeEnter);
        verifyBtn = findViewById(R.id.verifyBtn);

        verifyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

          String userOTP = codeEnter.getText().toString();
        if (userOTP.length() == 6){
            PhoneAuthCredential credential = PhoneAuthProvider.getCredential(getIntent().getStringExtra("verificationId"), userOTP);
            verifyAuth(credential);
        }else{
            codeEnter.setError("valid OTP is required");
        }
            }
        });
    }

    private void verifyAuth(PhoneAuthCredential credential) {
        fAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(MainActivity3.this, "Authentication is successful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(),MainActivity4.class));
                }else {
                    Toast.makeText(MainActivity3.this, "Authentication is failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}