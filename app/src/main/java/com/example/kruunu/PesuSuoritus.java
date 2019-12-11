package com.example.kruunu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesu_suoritus);

    }

    /**
     * Prevents user from accidentally exiting the activity with back button.
     * Only way to exit the activity is to use 'public void vahvistus'.
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
        Intent returnMainMenu = new Intent(this, MainMenu.class);
        startActivity(returnMainMenu);
        finish();
    }
}
