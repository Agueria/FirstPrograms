package com.example.firstprograms;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class IntroduceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduce);

        final EditText etName = findViewById(R.id.etName);
        final Button btnGreet = findViewById(R.id.btnGreet);
        final TextView tvGreeting = findViewById(R.id.tvGreeting);

        btnGreet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = etName.getText().toString().trim();
                if (input.isEmpty()) {
                    tvGreeting.setText("Przedstaw się.");
                } else {
                    tvGreeting.setText("Witaj " + input);
                }
            }
        });
    }
}