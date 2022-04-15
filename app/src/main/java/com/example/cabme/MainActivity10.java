package com.example.cabme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity10 extends AppCompatActivity {

    Button mContinueBtn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);

        mContinueBtn3=findViewById(R.id.ContinueBtn3);

        mContinueBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity10.this, "Authentication Successful", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),MainActivity8.class));
            }
        });
    }
}