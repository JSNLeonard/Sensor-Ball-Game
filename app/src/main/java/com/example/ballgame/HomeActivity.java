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

// Define HomeActivity class that extends AppCompatActivity.
public class HomeActivity extends AppCompatActivity {

    // Declare two Button objects for starting the game and accessing the help page.
    private Button startGameButton;
    private Button helpButton;

    // Declare a TextView object for displaying the high score.
    private TextView highScoreTextView;

    // This method is called when the activity is created.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the layout for this activity to the activity_launcher.xml file.
        setContentView(R.layout.activity_launcher);

        // Assign the start game and help buttons to their respective objects.
        startGameButton = findViewById(R.id.start_game_button);
        helpButton = findViewById(R.id.help_button);

        // Find the TextViews in the layout.
        highScoreTextView = findViewById(R.id.high_score_text_view);

        // Load the previously saved high score from SharedPreferences.
        SharedPreferences prefs = getSharedPreferences("MY_PREFS_NAME", MODE_PRIVATE);
        int highScore = prefs.getInt("HIGH_SCORE", 0);

        // Update the high score TextView with the loaded value.
        highScoreTextView.setText("YOUR HIGHEST SCORE: " + highScore);

        // Set an onClickListener for the start game button to launch MainActivity.
        startGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // Set an onClickListener for the help button to launch HelpActivity.
        helpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, HelpActivity.class);
                startActivity(intent);
            }
        });
    }

    // This method gets the current high score from SharedPreferences.
    private int getHighScore() {
        // Get the high score from SharedPreferences.
        SharedPreferences prefs = getSharedPreferences("BallGamePrefs", MODE_PRIVATE);
        return prefs.getInt("high_score", 0);
    }
}