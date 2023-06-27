# The Sensor Ball Game

## Introduction

The goal of this project was to create an Android app that would teach and illustrate a math or physics concept. The application developed for this project makes use of the accelerometer, gyroscope, and magnetometer sensors available on most modern smartphones to control a ball on the screen. The app allows users to manipulate the position and velocity of the ball by moving and tilting their phone. The project also includes a scoring system, where the score increases based on how fast the user moves or tilts their phone while controlling the ball. This app provides an interactive and engaging way to learn about the principles of motion and how it can be controlled.

Sensor Ball consists of four Java files: the Home Activity which serves as the home screen, the Main Activity which is where the game is played, the Finish Activity which is where the user is sent to when the game ends, and the Help Activity which provides information about the game and teaches the user about accelerometers, gyroscopes, and magnetometers.

## Description of Concept Covered & Sensor(s) Used

The concept covered in this project is the use of sensors in mobile devices, specifically the Accelerometer, Gyroscope, and Magnetometer sensors. These sensors are used to detect the motion and orientation of the device in real-time. The application uses these sensors to control the movement of a ball on the screen.
Below is a description of all three of these sensors (Accelerometer, Gyroscope, & Magnetometer):

    •	Accelerometer: An accelerometer measures acceleration, which is the rate of change of velocity over time. In the case of a phone or other mobile device, an accelerometer measures the acceleration of the device itself. This means that if you move your phone, the accelerometer can detect that movement and report it     as acceleration. Accelerometers typically measure acceleration in meters per second squared (m/s²).

    •	Gyroscope: A gyroscope measures the rate of rotation around three axes: pitch, yaw, and roll. In the case of a phone or other mobile device, a gyroscope can detect rotation of the device around these three axes. Gyroscopes typically measure rotation in degrees per second (rad/s).

    •	Magnetometer: A magnetometer measures the strength and direction of a magnetic field. In the case of a phone or other mobile device, a magnetometer can detect the Earth's magnetic field and report the direction of magnetic north. Magnetometers typically measure magnetic field strength in microteslas (µT).

By combining the data from these sensors, the app is able to accurately track the device's orientation and movement in real-time, allowing the user to control the ball on the screen by tilting and moving their device. The scoring system within the application is based on the user's ability to move the ball quickly, with points being awarded for faster movements. This encourages the user to explore the concept of motion and learn about the sensors involved in the process. Additionally, the Help Activity within the app provides information on the physics behind motion and how the sensors work together to detect it.

## High-Level Description of the System

A high-level description of a system is an overview of the system and its components, functions, and operations. It provides a bird's eye view of the system's architecture and functionality, without going into technical details. The purpose of a high-level description is to give a clear understanding of the system's purpose, goals, and functionality.

My Android application is designed to help users understand and learn about the concepts of physics and math. It is built to be interactive and engaging, providing users with a fun and challenging experience that they can enjoy while learning.

Sensor Ball consists of 4 main activities, namely Home Activity, Main Activity, Finish Activity, and Help Activity. The Home Activity serves as the starting point of the application, where the user is presented with the name of the application, their highest score achieved, and two buttons to navigate to the Help Page or to start the game. The user can click on the Start Game button to move on to the Main Activity, which is the game simulation screen. The Main Activity consists of a scoring system that is displayed at the top of the screen, which increases based on the tilt and movement of the phone. The user must control a ball on the screen by tilting and moving the phone. Additionally, the Main Activity has three text views at the bottom, showing the real-time values of the Accelerometer, Gyroscope, and Magnetometer sensors. The user has 60 seconds to achieve the highest score possible. There are also two buttons available, one to go back to the Home Page and one to go to the Help Page.

When the sixty seconds have elapsed, the user is taken to the Finish Activity Page, which shows the score they achieved in the simulation, their highest ever score achieved, and buttons to go back to the Home Page or to go to the Help Page. If the user clicks on the Help Page button, they will be taken to the Help Page where they can get instructions on what to do in the application and learn more about the sensors used in the application. The Help Activity also has two buttons to navigate back to the Home Page or to start the game.

The application uses the Accelerometer, Gyroscope, and Magnetometer sensors to control the ball on the screen. The Accelerometer measures the tilt and movement of the phone in three dimensions, while the Gyroscope measures the angular velocity of the phone in three dimensions. The Magnetometer measures the Earth's magnetic field in three dimensions. These sensors are used to determine the orientation of the phone in real-time and move the ball accordingly.

The application uses Shared Preferences to store the user's highest score achieved. Shared Preferences is a way of storing key-value pairs in the user's device, which persists even if the application is closed, or the device is restarted. This way, the user can keep track of their highest score and strive to beat it in future sessions.

The UML Class Diagram for the application includes the Home Activity, Main Activity, Finish Activity, and Help Activity classes, along with the SensorEventListener class, SensorManager class, and SharedPreferences class. The SensorEventListener class is responsible for listening to the sensor data and passing it to the Main Activity class. The SensorManager class is used to manage the sensor hardware and to register and unregister the sensor listeners. The SharedPreferences class is used to store the user's highest score achieved.

Overall, my Android application is designed to be an engaging and educational experience that combines the fun of a game with the learning opportunities of physics and math concepts. With its intuitive controls, comprehensive help section, and built-in scoring and storage features, it offers users a unique and valuable way to learn and have fun at the same time.

## Home Activity

![image](https://github.com/JSNLeonard/Sensor-Ball-Game/assets/48300764/d67b7177-b4e0-4b36-baa2-6a615017b699)

This class creates a main screen with buttons to start Sensor Ball and access the help page with the high score achieved by the user in previous games also being displayed on this screen. The onCreate() method is called when the activity is created, and it sets the layout for the activity to the activity_launcher.xml file. It also assigns the start game and help buttons to their respective objects, finds the TextView in the layout to display the high score, and loads the previously saved high score from SharedPreferences. The high score TextView is updated with the loaded value. Two onClickListeners are set for the start game button and help button respectively, to launch MainActivity and HelpActivity. The getHighScore() method is a helper method that gets the current high score from SharedPreferences. It is not used in the current code but can be used elsewhere if needed. Overall, this code creates a simple home screen with options to start the game, access the help page, and view the user's highest score achieved in previous games.

## Main Activity

![image](https://github.com/JSNLeonard/Sensor-Ball-Game/assets/48300764/dbd40b33-942a-4bf0-b98f-7f44356d664d)

This class if the main part of the program itself. It defines the Sensor Ball game, in which the player tilts their device to move a ball on the screen and collects points by moving the ball as fast as they can around the screen. The code imports necessary libraries and classes from the Android framework and sets up several UI elements such as image views, text views, and buttons. The code starts by setting the orientation of the screen to portrait mode, finding, and initializing several UI elements, and obtaining references to the sensors for the accelerometer, magnetometer, and gyroscope. It sets up listeners for these sensors and registers the activity to receive events when the sensors change. The code implements basic physics principles of motion to move the ball based on the device's sensors. The accelerometer, magnetometer, and gyroscope sensors are used to track the device's orientation and acceleration, and these values are used to move the ball on the screen. The x and z positions of the ball are updated based on the acceleration values measured by the accelerometer sensor, while the gyroscope sensor is used to detect the rotation of the device and adjust the orientation of the ball on the screen accordingly.

Next, the code sets up a timer that counts down from 60 seconds and updates a text view with the time remaining. When the timer finishes, it starts a new activity with the score passed as an extra and finishes the current activity. The main game loop runs on a separate thread and continuously updates the score based on the ball's position. The game loop sleeps for 2 milliseconds in each iteration to allow the UI thread to update and render the screen. The code also includes listeners for two buttons, the Home button and Help button, which start new activities when clicked.

## Finish Activity

![image](https://github.com/JSNLeonard/Sensor-Ball-Game/assets/48300764/7539d3c3-4d73-4344-9939-16d2a5e481b4)

The FinishActivity class is used to display the final score of Sensor Ball and allow the user to navigate to the home screen or a help screen. The onCreate() method is called when the activity is first created, it begins by setting the layout for the activity using the setContentView method. Next, it sets up the click listeners for the home and help buttons by finding the corresponding views in the layout using the findViewById method and then creating an intent to start the corresponding activity when the button is clicked. The code then gets the score from the intent extras using the getIntExtra method and finds the TextViews in the layout using findViewById. The score TextView is updated to show the current score, and the high score is loaded from SharedPreferences using getSharedPreferences. If the current score is higher than the previous high score, the high score TextView is updated to show the new high score and the new high score is saved in SharedPreferences using an Editor. Overall, this code is used to display the final score of a ball game and allows the user to navigate to other parts of the application itself.

## Help Activity

![image](https://github.com/JSNLeonard/Sensor-Ball-Game/assets/48300764/6eeff323-47c6-423c-99d8-0e0fd8c592a1)

The HelpActivity class is used to display helpful information for the user to read. It contains a method called onCreate() which is overridden. In the onCreate() method, the layout for the activity is set using setContentView(). The method then gets references to various TextViews and sets text to them. The first TextView, gameInfoTextView, contains information about the game's objective and how to play. The second TextView, sensorInfoTextView, explains how the game uses three different sensors to detect the orientation and movement of the phone. The third TextView, sensorInfoTextViewFeel, prompts the user to click the "START GAME" button to begin playing the game. Next, the method gets references to two buttons, homeButton and startGameButton, and sets up onClick listeners for them. When the buttons are clicked, the method creates new intents to start different activities within the application. Clicking the homeButton will start the HomeActivity, while clicking the startGameButton will start the MainActivity. Overall, this code sets up the HelpActivity and provides users with information about the game's objective and how to play, as well as the technical details of how the game works using sensors.

## UML Class Diagram of Program

![image](https://github.com/JSNLeonard/Sensor-Ball-Game/assets/48300764/13c986fe-0a55-4236-b722-977fb339780f)

A UML class diagram is a type of diagram in the Unified Modelling Language (UML) that depicts the structure of a system by showing the system's classes, their attributes, methods, and the relationships among objects. It is used to visually represent the various classes, interfaces, and their relationships in a program.

In the case of my program, the UML class diagram provides a high-level overview of the various components that make up the program, including the activities, sensors, and the various objects that they interact with. The diagram helps to ensure that the program is properly organized and designed, making it easier for users to understand the overall structure of the program, and identify potential issues or areas that need improvement. It can also be used as a reference for future development work, helping to ensure that changes and updates are made in a systematic and organized manner.

The Sensor Ball class contains the highestScore and preferences attributes, and the onCreate(), saveScore(score: int), and getHighestScore(): int methods.

The HomeActivity class contains the buttonStart, buttonHelp, and highScore attributes, and the onClickStart(), onClickHelp(), and onClickHome() methods.

The MainActivity class contains the scoreView, ball, and sensorData attributes, and the updateScore(), updateBall(), and updateSensorData() methods.

The FinishActivity class contains the scoreView and highScore attributes, and the showScore() method.

The HelpActivity class has no attributes and only contains the onClickHome() method.

All classes inherit from the Activity class provided by the Android SDK.

## Flow Chart of Program

![image](https://github.com/JSNLeonard/Sensor-Ball-Game/assets/48300764/1da29d7d-fd8d-480f-a782-d8abecee9d22)

A flowchart is a diagrammatic representation of a process that shows the sequence of steps involved in that process. It uses standard symbols and arrows to show the direction of the process flow. Flowcharts are commonly used in software development and other fields to represent the flow of control or data through a system.

In the case of the Sensor Ball application, the flowchart represents the sequence of steps involved in the user interacting with the app, from opening the app to playing the game and navigating between different screens. It shows how the user moves from one activity to another, what buttons and screens are available at each stage, and what happens when the user completes the game or presses different buttons. By visualizing the flow of the application in a flowchart, developers can better understand how the application works and identify any potential problems or inefficiencies in the design.

The flowchart for the Sensor Ball Application starts with the user opening the app. From here, the app will display the Home Activity Page, which shows the name of the application, the user's highest score achieved, and two buttons - one for starting the game and the other for accessing the Help Page.

If the user presses the START GAME button, the app will navigate to the Main Activity Page. This page displays a scoring system and a time limit of 60 seconds. Additionally, there is a ball on the screen that the user must control by tilting and moving their phone. There are also three text views at the bottom showing the real-time values of the Accelerometer, Gyroscope, and Magnetometer sensors. The user has the option of pressing two buttons - one to go back to the Home Activity Page and the other to access the Help Page.

If the user plays the simulation for 60 seconds, the app will navigate to the Finish Activity Page, which displays the user's score achieved and their highest-ever score. There are also two buttons on this page - one to go back to the Home Activity Page and the other to access the Help Page.

If the user presses the HELP PAGE button at any point in the app, the app will navigate to the Help Activity Page. This page provides useful information about the application, including instructions on how to play the game and information about the Accelerometer, Gyroscope, and Magnetometer sensors. There are also two buttons on this page - one to go back to the Home Activity Page and the other to start the game.

At any point during the app, the user can choose to press the Home Button to return to the Home Activity Page or the Help Button to access the Help Page.

## Description of Persistent Storage Used

Persistent storage is an essential part of any application that stores data or settings that need to be saved even after the application is closed or the device is rebooted. In this project, I used persistent storage in the form of Android's Shared Preferences to store the highest score achieved by the user in the game.

Shared Preferences is a mechanism provided by the Android framework for storing and retrieving key-value pairs of data. These key-value pairs are stored in an XML file in the app's internal storage and can be accessed by the app at any time. Shared Preferences provide a simple and efficient way of persistently storing small amounts of data, such as user preferences or application settings.

In my application, I used Shared Preferences to store the user's highest score. Whenever the user finishes a game and achieves a new high score, we store this value in the Shared Preferences. This value can then be accessed and displayed on the home screen of the app, so the user can see their progress and strive to beat their high score.

Using Shared Preferences for persistent storage is ideal for storing small amounts of data that do not require complex querying or searching. For more extensive data storage requirements, such as storing large amounts of data or searching for specific data values, other forms of persistent storage, such as a SQLite database, may be more appropriate.

## Conclusion

In conclusion, the Sensor Ball Android application is a fun and interactive way for users to learn about the three primary sensors used in mobile devices - the accelerometer, gyroscope, and magnetometer. The application allows users to control a ball on the screen by tilting and moving their phone, with the ball's movement being affected by changes in the device's orientation and movement. The application also features a scoring system to incentivize users to play the game and achieve their highest scores possible.

The use of Shared Preferences for persistent storage ensures that users can keep track of their highest scores achieved even after closing and reopening the application. The application also features a Help Activity page which provides users with useful information about the sensors used in the game and instructions on how to play the game.

Overall, the Sensor Ball application provides an entertaining and educational experience for users interested in learning about mobile device sensors and their applications. The application's intuitive controls and responsive gameplay make it a great way for users to explore the capabilities of their device's sensors while having fun at the same time.
