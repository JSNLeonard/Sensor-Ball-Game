// Import necessary libraries.
package com.example.ballgame;

// Import classes from Android framework.
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.Surface;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.CountDownTimer;
import androidx.appcompat.app.AppCompatActivity;

// Import classes from Android framework.
public class MainActivity extends AppCompatActivity implements SensorEventListener {

    // Declare variables for the SensorManager, ImageView, position of the ball, and score.
    private SensorManager sensorManager;
    private ImageView ballImage;
    private float zPosition;
    private float xPosition;
    private float prevZPosition;
    private float prevXPosition;
    private int score = 0;
    private TextView scoreTextView;
    private TextView accelerometerTextView;
    private TextView magnetometerTextView;
    private TextView gyroscopeTextView;
    private Button homeButton;
    private Button helpButton;
    private TextView timerTextView;

    // Called when the activity is first created.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content view of the app to activity_main.xml.
        setContentView(R.layout.activity_main);

        // Set the orientation of the screen to portrait mode.
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // Find the ball image view and the score text view in the layout.
        ballImage = findViewById(R.id.ball_image);
        scoreTextView = findViewById(R.id.score_text_view);

        // Set the score to 0 and display it.
        scoreTextView.setText(String.valueOf(score));

        // Get a reference to the sensor manager system service.
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        // Find the timer text view in the layout and set its initial value.
        timerTextView = findViewById(R.id.timer_text_view);
        timerTextView.setText("TIME LEFT: 60");

        // Set initial position of the ball to the center of the screen.
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int screenWidth = displayMetrics.widthPixels;
        int screenHeight = displayMetrics.heightPixels;
        float xInitialPosition = (screenWidth - ballImage.getWidth()) / 1.2f;
        float zInitialPosition = (screenHeight - ballImage.getHeight()) / 4.5f;
        ballImage.setX(xInitialPosition);
        ballImage.setZ(zInitialPosition);
        xPosition = xInitialPosition;
        zPosition = zInitialPosition;

        // Find the accelerometer text view in the layout.
        accelerometerTextView = findViewById(R.id.accelerometer_text);

        // Get a reference to the accelerometer sensor and register this activity as a listener.
        Sensor accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if (accelerometer != null) {
            sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_GAME);
        }

        // Find the magnetometer text view in the layout.
        magnetometerTextView = findViewById(R.id.magnetometer_text);

        // Get a reference to the magnetometer sensor and register this activity as a listener.
        Sensor magnetometer = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        if (magnetometer != null) {
            sensorManager.registerListener(this, magnetometer, SensorManager.SENSOR_DELAY_GAME);
        }

        // Find the magnetometer text view in the layout.
        gyroscopeTextView = findViewById(R.id.gyroscope_text);

        // Get a reference to the gyroscope sensor and register this activity as a listener.
        Sensor gyroscope = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        if (gyroscope != null) {
            sensorManager.registerListener(this, gyroscope, SensorManager.SENSOR_DELAY_GAME);
        }

        // These lines get the buttons for the home and help activities, and set click listeners for them.
        // When each button is clicked, an intent is created to start the corresponding activity.
        homeButton = findViewById(R.id.home_button);
        helpButton = findViewById(R.id.help_button);

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
        helpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HelpActivity.class);
                startActivity(intent);
            }
        });

        // This code creates a CountDownTimer that counts down from 60 seconds, updating the timer TextView every second.
        // When the timer finishes, an intent is created to start the FinishActivity with the score passed as an extra, and the MainActivity is finished.
        new CountDownTimer(60000, 1000) {
            public void onTick(long millisUntilFinished) {
                // Update timer TextView every second
                timerTextView.setText("TIME LEFT: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                Intent intent = new Intent(MainActivity.this, FinishActivity.class);
                intent.putExtra("SCORE", score);
                startActivity(intent);
                finish();
            }
        }.start();

        // This code initializes the score to 0, and creates a new thread that runs a loop to continuously update the score based on changes in the ball's position.
        // The thread sleeps for 2 milliseconds in each iteration, then checks if the ball's x and z positions have changed, and updates the score accordingly.
        // The scoreTextView is then updated with the new score value.
        score = 0;
        Thread scoreThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        Thread.sleep(2);
                        if (zPosition > prevZPosition) {
                            score += Math.abs(zPosition - prevZPosition);
                        }
                        if (zPosition < prevZPosition) {
                            score += Math.abs(zPosition - prevZPosition);
                        }
                        if (xPosition > prevXPosition) {
                            score += Math.abs(xPosition - prevXPosition);
                        }
                        if (xPosition < prevXPosition) {
                            score += Math.abs(xPosition - prevXPosition);
                        }
                        prevZPosition = zPosition;
                        prevXPosition = xPosition;
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                scoreTextView.setGravity(Gravity.CENTER_HORIZONTAL);
                                scoreTextView.post(() -> scoreTextView.setText("SCORE\n" + String.valueOf(score)));
                            }
                        });
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        scoreThread.start();
    }

    // The onSensorChanged() method is called whenever a sensor reading changes.
    // In this implementation, it checks if the sensor type is TYPE_ACCELEROMETER and retrieves the values of the x, y, and z components of the acceleration.
    // It then updates the text views to display the readings of the accelerometer, magnetometer, and gyroscope sensors.
    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float xAcceleration = event.values[0];
            float yAcceleration = event.values[1];
            float zAcceleration = event.values[2];

            // Update accelerometer text view.
            accelerometerTextView.setText("Accelerometer (m/s2)" + "\n" + String.format("X: %.2f", xAcceleration) + ", " + String.format("Y: %.2f", yAcceleration) + ", " + String.format("Z: %.2f", zAcceleration));

            int rotation = getWindowManager().getDefaultDisplay().getRotation();

            if (rotation == Surface.ROTATION_0) {
                // Portrait orientation.
                if (zAcceleration < 9.5f) {
                    // Phone is not in its normal orientation.
                    float newXPosition = xPosition + (zAcceleration * 7);

                    // Make sure the ball stays within the screen boundaries.
                    int screenHeight = getWindowManager().getDefaultDisplay().getHeight();
                    if (newXPosition < 315) newXPosition = 315;
                    if (newXPosition > screenHeight - ballImage.getHeight() - 670) newXPosition = screenHeight - ballImage.getHeight() - 670;

                    ballImage.setY(newXPosition);

                    xPosition = newXPosition;
                }
                // Portrait orientation.
                if (xAcceleration < 9.5f) {
                    // Phone is not in its normal orientation.
                    float newZPosition = zPosition - (xAcceleration * 7);

                    // Make sure the ball stays within the screen boundaries.
                    int screenWidth = getWindowManager().getDefaultDisplay().getWidth();
                    if (newZPosition < 0) newZPosition = 0;
                    if (newZPosition > screenWidth - ballImage.getWidth()) newZPosition = screenWidth - ballImage.getWidth();

                    ballImage.setX(newZPosition);

                    zPosition = newZPosition;
                }
            }
        } else if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {
            float xMag = event.values[0];
            float yMag = event.values[1];
            float zMag = event.values[2];

            // Update magnetometer text view.
            magnetometerTextView.setText("Magnetometer (μT)" + "\n" + String.format("X: %.2f", xMag) + ", " + String.format("Y: %.2f", yMag) + ", " + String.format("Z: %.2f", zMag));
        } else if (event.sensor.getType() == Sensor.TYPE_GYROSCOPE) {
            float xGyro = event.values[0];
            float yGyro = event.values[1];
            float zGyro = event.values[2];

            // Update gyroscope text view.
            gyroscopeTextView.setText("Gyroscope (rad/s)" + "\n" + String.format("X: %.2f", xGyro) + ", " + String.format("Y: %.2f", yGyro) + ", " + String.format("Z: %.2f", zGyro));
        }
    }

    // The onAccuracyChanged method is called when the accuracy of the sensor changes, but it is not used in this implementation.
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    // The onPause() method is called when the activity is paused, and it unregisters the listener to conserve battery life.
    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    // The onResume() method is called when the activity is resumed, and it registers the listener to start receiving sensor updates.
    // It checks if the accelerometer sensor is available before registering the listener.
    @Override
    protected void onResume() {
        super.onResume();
        Sensor accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        if (accelerometer != null) {
            sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_GAME);
        }
    }
}