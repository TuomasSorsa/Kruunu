package com.example.kruunu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Mainactivity.java is Kruunu's startup & first time setup activity.
 * It checks from SharedPreferences (Boolean value) if the app has
 * been launched first time and does something based on that.
 * First time it waits for user input to start creating user for the app.
 * After first time it goes straight to MainMenu activity.
 *
 * @author Tuomas Sihvo
 * @version 1.0
 * @since 9.12.2019
 */
public class MainActivity extends AppCompatActivity {
    /** SharedPreferences tag. */
    static final String KEY_IS_FIRST_TIME = "com.Kruunu.first_time"; // used for SharedPreferences.
    /** SharedPreferences tag. */
    static final String KEY = "com.Kruunu";
    /** Used to finish MainActivity.java in other activities*/
    static Activity activityA; // used to finish this activity from different activity

    /**
     * onCreate checks if the app has been launched first time / completed first time setup.
     * If it has: it goes straight to MainMenu activity.
     * If not: it waits for user input to go to next phase of first time setup.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activityA = this;
        if (firstTime() == false) {     // Check if this is first time starting the app, if it's not go straight to MainMenu activity.
            Intent intent = new Intent(this, MainMenu.class);   // Start & goto MainMenu activity.
            startActivity(intent);
            finish();
        }
    }

    /**
     * Starts the UserCreation activity on button click.
     *
     * @param v Used for button onClick.
     */
    public void startUserCreation (View v) {
        Intent intent = new Intent(this, UserCreation.class);   // Start & goto UserCreation activity.
        startActivity(intent);
    }

    /**
     * Gets the value of boolean KEY_IS_FIRST_TIME.
     * Used to check if the app has been launched first time / completed first time setup.
     *
     * @return returns the
     */
    public boolean firstTime(){
        return getSharedPreferences(KEY, Context.MODE_PRIVATE).getBoolean(KEY_IS_FIRST_TIME, true); // Boolean value used to check first time setup.
    }

    /**
     * Gets the value of MainActivity.
     * Used to finish MainActivity from different activity.
     *
     * @return returns the value of MainActivity.java.
     */
    public static Activity getInstance(){ // Method says it's never used, but this let's you use MainActivity.activityA.finish in other activities();
        return activityA;
    }
}
