package com.example.kruunu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * MainMenu.java is Kruunu's MainMenu where all the app's functions & menus are accessible.
 * MainMenu has four buttons that open the specific activities: PesuMenu, OhjeMenu, OptionsMenu, KalenteriMenu(not working).
 * In the middle of the screen there is a image displayed. User streak decides what that picture is.
 *
 * @author Tuomas Sihvo
 * @version 1.01
 * @since 11.12.2019
 */
public class MainMenu extends AppCompatActivity {
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
    /** TextView testaako used for testing / debugging. */
    TextView testaako;

    /**
     * Userdata is loaded from SharedPreferences and inputted to User.java singleton.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Log.d("TAG", "Luotiinko uusi objekti?");
        LoadTime();     // Load data method.
    }

    /**
     * onResume loads the Userdata from SharedPreferences and inputs it to User.Java singleton.
     */
    @Override
    public void onResume() {
        super.onResume();
        Log.d("TAG", "Luotiinko uusi objekti?");
        LoadTime();
    }

    /**
     * Opens KalenteriMenu activity.
     * @param v Used for button onClick.
     */
    public void KalenteriButton (View v) {
        Intent kalenteri = new Intent(this, KalenteriMenu.class);
        startActivity(kalenteri);
    }

    /**
     * Opens OptionsMenu activity.
     * @param v Used for button onClick.
     */
    public void OptionsButton (View v) {
        Intent options = new Intent(this, OptionsMenu.class);
        startActivity(options);
    }

    /**
     * Opens PesuMenu activity.
     * @param v Used for button onClick.
     */
    public void PesuButton (View v) {
        Intent pesu = new Intent(this, PesuMenu.class);
        startActivity(pesu);
    }

    /**
     * Opens OhjeMenu activity.
     * @param v Used for button onClick.
     */
    public void OhjeButton (View v) {
        Intent ohje = new Intent(this, InfoMenu.class);
        startActivity(ohje);
    }

    /**
     * Stores the current Userdata from User singleton to SharedPreferences.
     * Stores KEY_IS_FIRST_TIME as false, to skip first time setup next time.
     * Used when using the app first time.
     * TextView testaako used for testing / debugging.
     */


    /**
     * Loads Userdata from SharedPreferences and inputs it to User singleton.
     * Used when the app has already completed the first time setup.
     * TextView testaako used for testing / debugging.
     */
    public void LoadTime () {
        User.getInstance().inputUserDataLoad(getSharedPreferences(KEY, Context.MODE_PRIVATE).getString(NAME,""),    // load userdata from SharedPreferences to User singleton.
                getSharedPreferences(KEY, Context.MODE_PRIVATE).getString(PIN,"1234"),
                getSharedPreferences(KEY, Context.MODE_PRIVATE).getInt(STREAK,0),
                getSharedPreferences(KEY, Context.MODE_PRIVATE).getInt(MISSES,0));
        testaako = findViewById(R.id.testiView);
        //testaako.setText(User.getInstance().getName() + "\n" + User.getInstance().getPassword() + "\n" +User.getInstance().getStreak() + "\n" + User.getInstance().getMissed());
    }
}
