package com.example.cabme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity8 extends AppCompatActivity {

    ImageView mTick,mTick2,mTick3;
    Button mContinueBtn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        mTick=findViewById(R.id.tick);
        mTick2=findViewById(R.id.tick2);
        mTick3=findViewById(R.id.tick3);
        mContinueBtn2=findViewById(R.id.ContinueBtn2);
    }

    public void Card(View view) {
        startActivity(new Intent(getApplicationContext(),MainActivity9.class));
        mTick.setVisibility(View.VISIBLE);
    }

    public void upi(View view) {
        startActivity(new Intent(getApplicationContext(),MainActivity10.class));
        mTick2.setVisibility(View.VISIBLE);
    }

    public void Cash(View view) {
        Toast.makeText(MainActivity8.this, "Mode of payment:Cash", Toast.LENGTH_SHORT).show();
        mTick3.setVisibility(View.VISIBLE);
    }
}