package com.example.firstprograms;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

// Student: Cem Cakir, Student ID: 44463, Lab Task 1
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnHelloWorld = findViewById(R.id.btnHelloWorld);
        Button btnIntroduce = findViewById(R.id.btnIntroduce);
        Button btnGuessingGame = findViewById(R.id.btnGuessingGame);

        btnHelloWorld.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, HelloWorldActivity.class));
            }
        });

        btnIntroduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, IntroduceActivity.class));
            }
        });

        btnGuessingGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, GuessingGameActivity.class));
            }
        });
    }
}
