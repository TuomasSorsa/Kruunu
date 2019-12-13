package com.example.kruunu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * UserCreation.java is Kruunu's activity used to create user for the app.
 * This app only uses one user, so we have created singleton User class and use the data
 * inputted in this activity to insert Name and PIN to Userdata. (this.name, this.password).
 * Current Userdata is stored to SharedPreferences.
 *
 * @author Tuomas Sihvo
 * @version 1.01
 * @since 11.12.2019
 */
public class UserCreation extends AppCompatActivity {
    /** SharedPreferences tag. */
    static final String KEY_IS_FIRST_TIME = "com.Kruunu.first_time";
    /** SharedPreferences tag. */
    static final String KEY = "com.Kruunu";
    /** SharedPreferences tag. */
    static final String NAME = "com.Kruunu.User.Name";
    /** SharedPreferences tag. */
    static final String PIN = "com.Kruunu.User,PIN";
    /** SharedPreferences tag. */
    static final String STREAK = "com.Kruunu.USER.Streak";
    /** SharedPreferences tag. */
    static final String MISSES = "com.Kruunu.USER.Misses";

    /**
     * onCreate hides the inputted data for PIN / password EditText.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_creation);
        EditText password = findViewById(R.id.editPassword);
        password.setTransformationMethod(new PasswordTransformationMethod()); // hides the inputted PIN / password.
    }

    /**
     * Checks the name and PIN user inputted to name & PIN EditText are valid.
     * If either Username or PIN are invalid; user gets a AlertDialog, describing what went wrong.
     * When both Username and PIN are valid; KEY_IS_FIRST_TIME is stored as 'false' to SharedPreferences.
     * All the Userdata, day/night data and  is also stored in SharedPreferences.
     *
     * Stores week calendar data & day/night cycle data. Also stores starting weekday.
     * Finishes MainActivity & UserCreation activities.
     * XML EditTexts have maxLength values and take only specific digits (name: letters, PIN: numbers).
     *
     * @param v Used for the button onClick.
     */
    public void inputUserData (View v) {
        EditText editName = findViewById(R.id.editName);
        int length = editName.length();     // inputted username length
        if (length < 3) {                   // if username is less than 3 characters, it sends a AlertDialog.
            AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
            dlgAlert.setMessage("Nimessä vähintään 3 kirjainta (a-z, A-Z)");
            dlgAlert.setTitle("ERROR");
            dlgAlert.setPositiveButton("OK", null);
            dlgAlert.setCancelable(true);
            dlgAlert.create().show();
            return; // Returns to let user reinput the userdata.
        }

        EditText editPIN = findViewById(R.id.editPassword);
        length = editPIN.length();      // inputted PIN length
        if (!(length == 4)) {           // if PIN is not 4 numbers, it sends a AlertDialog.
            AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
            dlgAlert.setMessage("PIN pitää olla 4-numeroinen! (0-9)");
            dlgAlert.setTitle("ERROR");
            dlgAlert.setPositiveButton("OK", null);
            dlgAlert.setCancelable(true);
            dlgAlert.create().show();
            return; // Returns to let user reinput the userdata.
        }
        // If both username and PIN pass, the data is added to User and stored in SharedPreferences.
        String name = editName.getText().toString(); String pincode = editPIN.getText().toString();         // get the inserted data to String format.
        User.getInstance().inputUserDataFirst(name, pincode);   // Input name and PIN from Intent to User singleton (Streak and Misses are default value 0).
        FirstTime();    // First time method.
        calendarFirstTime(); // Calendar SharedPreferences first time setup method.
        Intent intent = new Intent(this, MainMenu.class);       // Intent to MainMenu.java activity, putExtra USER_NAME & USER_PIN.
        startActivity(intent);
        MainActivity.activityA.finish();    // finish MainActivity.java activity.
        finish();
    }

    /**
     * Used to store all Userdata and first time boolean to SharedPreferences.
     * KEY_IS_FIRST_TIME = false, prevents first time setup starting again.
     */
    public void FirstTime () {
        getSharedPreferences(KEY, Context.MODE_PRIVATE).edit().putString(NAME, User.getInstance().getName()).apply();
        getSharedPreferences(KEY, Context.MODE_PRIVATE).edit().putInt(MISSES, User.getInstance().getMissed()).apply();
        getSharedPreferences(KEY, Context.MODE_PRIVATE).edit().putInt(STREAK, User.getInstance().getStreak()).apply();
        getSharedPreferences(KEY, Context.MODE_PRIVATE).edit().putString(PIN, User.getInstance().getPassword()).apply();
        getSharedPreferences(KEY, Context.MODE_PRIVATE).edit().putBoolean(KEY_IS_FIRST_TIME, false).apply();
    }

    /**
     *  Used to store default values to Day & Night values also current weekday and morning/night cycle value to SharedPreferences.
     *  Calendar starts from current weekday and morning/night cycle value example. Night 5.
     *  So if you start using the app middle of the week, you don't get unnecessary misses to your Userdata.
     *  Cycle: true = day, false = night. Day/Night1-7: 0 = not brushed yet, 1 = brushed, 2 = missed brushing.
     */
    public void calendarFirstTime () {
        getSharedPreferences(KEY, Context.MODE_PRIVATE).edit().putInt("Day", getWeekDay()).apply(); // weekday as int (example. Tuesday = 2)
        getSharedPreferences(KEY, Context.MODE_PRIVATE).edit().putBoolean("Cycle", getDayNight()).apply(); // true = Day & false = Night
        getSharedPreferences(KEY, Context.MODE_PRIVATE).edit().putInt("Day1", 0).apply();   // Every day and night for each day has a SharedPreferences value.
        getSharedPreferences(KEY, Context.MODE_PRIVATE).edit().putInt("Night1", 0).apply();
        getSharedPreferences(KEY, Context.MODE_PRIVATE).edit().putInt("Day2", 0).apply();
        getSharedPreferences(KEY, Context.MODE_PRIVATE).edit().putInt("Night2", 0).apply();
        getSharedPreferences(KEY, Context.MODE_PRIVATE).edit().putInt("Day3", 0).apply();
        getSharedPreferences(KEY, Context.MODE_PRIVATE).edit().putInt("Night3", 0).apply();
        getSharedPreferences(KEY, Context.MODE_PRIVATE).edit().putInt("Day4", 0).apply();
        getSharedPreferences(KEY, Context.MODE_PRIVATE).edit().putInt("Night4", 0).apply();
        getSharedPreferences(KEY, Context.MODE_PRIVATE).edit().putInt("Day5", 0).apply();
        getSharedPreferences(KEY, Context.MODE_PRIVATE).edit().putInt("Night5", 0).apply();
        getSharedPreferences(KEY, Context.MODE_PRIVATE).edit().putInt("Day6", 0).apply();
        getSharedPreferences(KEY, Context.MODE_PRIVATE).edit().putInt("Night6", 0).apply();
        getSharedPreferences(KEY, Context.MODE_PRIVATE).edit().putInt("Day7", 0).apply();
        getSharedPreferences(KEY, Context.MODE_PRIVATE).edit().putInt("Night7", 0).apply();
    }

    /**
     * Gets the current weekday as String and converts it to int value between 1-7.
     * @return Returns current weekday as 1 (should never happen).
     */
    public int getWeekDay () {
        String weekday = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(System.currentTimeMillis());
        if(weekday.equals("Monday")) {  // change string to int
            return 1;
        } else if (weekday.equals("Tuesday")) {
            return 2;
        } else if (weekday.equals("Wednesday")) {
            return 3;
        } else if (weekday.equals("Thursday")) {
            return 4;
        } else if (weekday.equals("Friday")) {
            return 5;
        } else if (weekday.equals("Saturday")) {
            return 6;
        } else if (weekday.equals("Sunday")) {
            return 7;
        }
        return 1;
    }

    /**
     * Gets the current day/night cycle value as boolean.
     * If clock is between 0-12 = day or 12-24 = night.
     * @return Returns false (should never happen).
     */
    public boolean getDayNight () {
        Calendar rightNow = Calendar.getInstance();
        int currentHour = rightNow.get(Calendar.HOUR_OF_DAY); // get current hour as int.
        if (currentHour < 24 && currentHour >= 12) {
            return false;    // true = morning / day.
        } else if (currentHour < 12 && currentHour > 0) {
            return true;  // false = night / evening.
        }
        return false;
    }
}
