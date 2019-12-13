package com.example.kruunu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * PesuSuoritus congratulates the User for completing their brushing and confirms it.
 * Pressing the button will increase the brushing streak by 1.
 *
 * @author Tuomas Sihvo
 * @version 1.0
 * @since 9.12.2019
 */
public class PesuSuoritus extends AppCompatActivity {
    /** SharedPreferences tag. */
    static final String KEY = "com.Kruunu";
    /** SharedPreferences tag. */
    static final String STREAK = "com.Kruunu.USER.Streak";
    /** SharedPreferences tag. */
    static final String DAY = "Day";
    /** SharedPreferences tag. */
    static final String CYCLE = "Cycle";
    TextView pesuaika;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesu_suoritus);
        pesuAika();
    }

    /**
     * Prevents user from accidentally exiting the activity with back button.
     * Only way to exit the activity is to use 'public void vahvistus' (click the button).
     */
    @Override
    public void onBackPressed() {
        // does nothing :)
    }

    /**
     * Confirms the brushing and increases streak, also saves it to SharedPreferences.
     * After that it finishes the activity and returns to MainMenu activity.
     *
     * @param v Used for button onClick.
     */
    public void vahvistus (View v) {
        User.getInstance().streakUp();  // streak goes up by 1.
        Log.i("TAG", "Uusi streak:" + User.getInstance().getStreak());
        getSharedPreferences(KEY, Context.MODE_PRIVATE).edit().putInt(STREAK, User.getInstance().getStreak()).apply();  // new streak saved to SharedPreferences.
        markPesu(); // marks the brushing complete
        Intent returnMainMenu = new Intent(this, MainMenu.class);
        startActivity(returnMainMenu);
        finish();
    }

    /**
     * Used to find out which weekday & day/night cycle is it to save the brushing value as 1 (Brushed);
     * Activates after confirmation button has been pressed.
     * Checks boolean day/night cycle value and after that weekday number.
     * Saves brushing as complete for the current day & cycle.
     */
    public void markPesu () {
        int d = getSharedPreferences(KEY,Context.MODE_PRIVATE).getInt(DAY, 1);
        boolean c = getSharedPreferences(KEY, Context.MODE_PRIVATE).getBoolean(CYCLE, true);
        if (c == true) {
            if (d == 1) {
                getSharedPreferences(KEY,Context.MODE_PRIVATE).edit().putInt("Day1", 1).apply();
            } else if (d == 2) {
                getSharedPreferences(KEY,Context.MODE_PRIVATE).edit().putInt("Day2", 1).apply();
            } else if (d == 3) {
                getSharedPreferences(KEY,Context.MODE_PRIVATE).edit().putInt("Day3", 1).apply();
            } else if (d == 4) {
                getSharedPreferences(KEY,Context.MODE_PRIVATE).edit().putInt("Day4", 1).apply();
            } else if (d == 5) {
                getSharedPreferences(KEY,Context.MODE_PRIVATE).edit().putInt("Day5", 1).apply();
            } else if (d == 6) {
                getSharedPreferences(KEY,Context.MODE_PRIVATE).edit().putInt("Day6", 1).apply();
            } else if (d == 7) {
                getSharedPreferences(KEY,Context.MODE_PRIVATE).edit().putInt("Day7", 1).apply();
            }
        }
        else {
            if (d == 1) {
                getSharedPreferences(KEY,Context.MODE_PRIVATE).edit().putInt("Night1", 1).apply();
            } else if (d == 2) {
                getSharedPreferences(KEY,Context.MODE_PRIVATE).edit().putInt("Night2", 1).apply();
            } else if (d == 3) {
                getSharedPreferences(KEY,Context.MODE_PRIVATE).edit().putInt("Night3", 1).apply();
            } else if (d == 4) {
                getSharedPreferences(KEY,Context.MODE_PRIVATE).edit().putInt("Night4", 1).apply();
            } else if (d == 5) {
                getSharedPreferences(KEY,Context.MODE_PRIVATE).edit().putInt("Night5", 1).apply();
            } else if (d == 6) {
                getSharedPreferences(KEY,Context.MODE_PRIVATE).edit().putInt("Night6", 1).apply();
            } else if (d == 7) {
                getSharedPreferences(KEY,Context.MODE_PRIVATE).edit().putInt("Night7", 1).apply();
            }
        }
    }

    /**
     * Sets TextView show if it's day or night and displays correct String based off it.
     */
    public void pesuAika () {
        boolean b = getSharedPreferences(KEY, Context.MODE_PRIVATE).getBoolean(CYCLE, true);
        pesuaika = findViewById(R.id.textSuoritus2);
        if(b == true) { // checks day/night cycle.
            pesuaika.setText("Aamupesu tehty!\n Streak kasvaa!\n Merkkaa ylös:"); // day
        } else {
            pesuaika.setText("Iltapesu tehty!\n Streak kasvaa!\n Merkkaa ylös:"); // night
        }
    }
}
