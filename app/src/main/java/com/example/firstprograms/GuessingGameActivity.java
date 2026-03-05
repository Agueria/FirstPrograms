package com.example.firstprograms;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class GuessingGameActivity extends AppCompatActivity {

    private int targetNumber;
    private int attempts;
    private Random random = new Random();

    private EditText etGuess;
    private TextView tvMessage;
    private TextView tvAttempts;
    private Button btnCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guessing_game);

        etGuess = findViewById(R.id.etGuess);
        tvMessage = findViewById(R.id.tvMessage);
        tvAttempts = findViewById(R.id.tvAttempts);
        btnCheck = findViewById(R.id.btnCheck);

        resetGame();

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = etGuess.getText().toString().trim();

                if (input.isEmpty()) {
                    tvMessage.setText("Please enter an integer number.");
                    return;
                }

                int userGuess;
                try {
                    userGuess = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    tvMessage.setText("Please enter an integer number.");
                    return;
                }

                if (userGuess < 1 || userGuess > 10) {
                    tvMessage.setText("Number must be in range 1..10.");
                    return;
                }

                if (userGuess < targetNumber) {
                    tvMessage.setText("Value too small");
                    attempts++;
                } else if (userGuess > targetNumber) {
                    tvMessage.setText("Value too large");
                    attempts++;
                } else {
                    // Correct guess
                    if (attempts == 2) {
                        tvMessage.setText("Correct — achieved on the 2nd attempt");
                        btnCheck.setEnabled(false); // End game
                    } else {
                        tvMessage.setText("Correct, but not on the 2nd attempt. Try again.");
                        resetGame();
                        return; // return so we don't update attempts text with the old value
                    }
                }
                tvAttempts.setText("Attempts: " + attempts);
            }
        });
    }

    private void resetGame() {
        targetNumber = random.nextInt(10) + 1;
        attempts = 1;
        tvAttempts.setText("Attempts: " + attempts);
        etGuess.setText("");
    }
}