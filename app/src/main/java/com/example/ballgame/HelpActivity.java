// Import necessary libraries.
package com.example.ballgame;

// Import classes from Android framework.
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

// Define a HelpActivity class that extends AppCompatActivity.
public class HelpActivity extends AppCompatActivity {

    // Declare private fields for buttons.
    private Button homeButton;
    private Button startGameButton;

    // Override the onCreate() method of AppCompatActivity.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the layout for this activity.
        setContentView(R.layout.activity_help);

        // Get references to TextViews in the layout.
        TextView gameInfoTextView = findViewById(R.id.gameplay_info);
        TextView sensorInfoTextView = findViewById(R.id.sensor_info_title);
        TextView sensorInfoTextViewFeel = findViewById(R.id.sensor_info_title_feel);

        // Set up game information text.
        String gameInfo = "Sensor Ball is a physics/maths simulation/game where you tilt your phone left, right, up and down " +
                "to move a ball around the screen, the faster you move the ball, the higher your score will be. The goal of the game is to reach the highest " +
                "score you can possibly achieve in a limited timeframe which is displayed at the top of the screen.";
        gameInfoTextView.setText(gameInfo);

        // Set up sensor information text.
        String sensorInfo = "The physics/maths simulation/game uses three different sensors to detect the phone's " +
                "orientation and movement:\n\n" +
                "1. Accelerometer: Measures the phone's acceleration in three dimensions " +
                "(X, Y, Z). This sensor is used to detect the tilt of the phone left or right." +
                "It uses the metres per second squared (m/s2) unit. \n\n" +
                "2. Gyroscope: Measures the phone's angular velocity in three dimensions. " +
                "This sensor is used to detect the speed and direction of the phone's rotation. " +
                "It uses the radian per second (rad/s) unit.\n\n" +
                "3. Magnetometer: Measures the phone's magnetic field in three dimensions." +
                "This sensor is used to detect the phone's orientation relative to the Earth's " +
                "magnetic field. It uses the microtesla (μT) unit.";
        sensorInfoTextView.setText(sensorInfo);

        // Set up additional sensor information text.
        String sensorInfoFeel = "Feel ready to start? Click the START GAME button below to begin!";
        sensorInfoTextViewFeel.setText(sensorInfoFeel);

        // Get references to buttons in the layout.
        homeButton = findViewById(R.id.home_button);
        startGameButton = findViewById(R.id.start_game_button);

        // Add onClick listeners for the buttons.
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a new intent to start the HomeActivity.
                Intent intent = new Intent(HelpActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
        startGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a new intent to start the MainActivity.
                Intent intent = new Intent(HelpActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}