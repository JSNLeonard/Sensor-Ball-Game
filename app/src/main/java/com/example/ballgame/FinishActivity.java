// Import necessary libraries.
package com.example.ballgame;

// Import classes from Android framework.
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

// Import classes from Android framework.
public class FinishActivity extends AppCompatActivity {

    // Private instance variables.
    private int score;
    private TextView scoreTextView;
    private TextView highScoreTextView;
    private Button homeButton;
    private Button helpButton;

    // This method is called when the activity is first created.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the layout for this activity.
        setContentView(R.layout.activity_finish);

        // These lines get the buttons for the home and help activities, and set click listeners for them.
        // When each button is clicked, an intent is created to start the corresponding activity.
        homeButton = findViewById(R.id.home_button);
        helpButton = findViewById(R.id.help_button);

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FinishActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
        helpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FinishActivity.this, HelpActivity.class);
                startActivity(intent);
            }
        });

        // Get the score from the Intent extras.
        score = getIntent().getIntExtra("SCORE", 0);

        // Find the TextViews in the layout.
        scoreTextView = findViewById(R.id.scoreTextView);
        highScoreTextView = findViewById(R.id.highScoreTextView);

        // Set the score TextView to show the current score.
        scoreTextView.setText("Final Score: " + score);

        // Load the previously saved high score from SharedPreferences.
        SharedPreferences prefs = getSharedPreferences("MY_PREFS_NAME", MODE_PRIVATE);
        int highScore = prefs.getInt("HIGH_SCORE", 0);

        // Update the high score TextView with the loaded value.
        highScoreTextView.setText("High Score: " + highScore);

        // Save the new high score if it's greater than the previous one.
        if (score > highScore) {
            highScoreTextView.setText("New High Score: " + score);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putInt("HIGH_SCORE", score);
            editor.apply();
        }
    }
}