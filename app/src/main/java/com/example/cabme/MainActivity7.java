package com.example.cabme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.tasks.OnCompleteListener;

public class MainActivity7 extends AppCompatActivity {

    Button mGpsBtn;
    Button mGpsBtn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        mGpsBtn = findViewById(R.id.gpsBtn);
        mGpsBtn2 = findViewById(R.id.gpsBtn2);

        mGpsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
                mGpsBtn.setVisibility(View.GONE);
                mGpsBtn2.setVisibility(View.VISIBLE);
            }
        });
        mGpsBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity8.class));
            }
        });
    }
}