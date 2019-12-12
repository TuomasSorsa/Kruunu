package com.example.kruunu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Calendar;

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
        loadTime();     // Load data method.
        setAlarm();
    }

    /**
     * onResume loads the Userdata from SharedPreferences and inputs it to User.Java singleton.
     */
    @Override
    public void onResume() {
        super.onResume();
        Log.d("TAG", "Palattiin aktiviteettiin.");
        loadTime();
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

    /**
     * Opens KalenteriMenu activity.
     * @param v Used for button onClick.
     */
    public void kalenteriButton (View v) {
        Intent kalenteri = new Intent(this, KalenteriMenu.class);
        startActivity(kalenteri);
    }

    /**
     * Opens OptionsMenu activity.
     * @param v Used for button onClick.
     */
    public void optionsButton (View v) {
        Intent options = new Intent(this, OptionsMenu.class);
        startActivity(options);
    }

    /**
     * Opens PesuMenu activity.
     * @param v Used for button onClick.
     */
    public void pesuButton (View v) {
        Intent pesu = new Intent(this, PesuMenu.class);
        startActivity(pesu);
    }

    /**
     * Opens OhjeMenu activity.
     * @param v Used for button onClick.
     */
    public void ohjeButton (View v) {
        Intent ohje = new Intent(this, InfoMenu.class);
        startActivity(ohje);
    }

    /**
     * Loads Userdata from SharedPreferences and inputs it to User singleton.
     * Used when the app has already completed the first time setup.
     * TextView testaako used for testing / debugging.
     */
    public void loadTime () {
        User.getInstance().inputUserDataLoad(getSharedPreferences(KEY, Context.MODE_PRIVATE).getString(NAME,""),    // load userdata from SharedPreferences to User singleton.
                getSharedPreferences(KEY, Context.MODE_PRIVATE).getString(PIN,"1234"),
                getSharedPreferences(KEY, Context.MODE_PRIVATE).getInt(STREAK,0),
                getSharedPreferences(KEY, Context.MODE_PRIVATE).getInt(MISSES,0));
    }

    public void setAlarm () {
        Calendar cal1 = Calendar.getInstance();
        cal1.set(Calendar.SECOND, 20);
        Intent alarm = new Intent(MainMenu.this, BrushAlarm.class);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(), 12345678, alarm, PendingIntent.FLAG_UPDATE_CURRENT);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, cal1.getTimeInMillis(), 1000 * 60, pendingIntent);
    }

    public void setStreak () {
        testaako = findViewById(R.id.testiView);
        testaako.setText("Streak: " + User.getInstance().getStreak());
    }
}
