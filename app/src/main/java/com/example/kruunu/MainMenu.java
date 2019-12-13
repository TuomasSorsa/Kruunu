package com.example.kruunu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
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
    /** SharedPreferences tag. */
    static final String DAY = "Day";
    /** SharedPreferences tag. */
    static final String CYCLE = "Cycle";
    /** TextView used to display streak value (previously used for testing hence the name). */
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
        setStreak();
        setStreakImage();
    }

    /**
     * onResume loads the Userdata from SharedPreferences and inputs it to User.Java singleton.
     */
    @Override
    public void onResume() {
        super.onResume();
        Log.d("TAG", "Palattiin aktiviteettiin.");
        loadTime();
        setStreak();
        setStreakImage();
    }

    /**
     * On back button press: moves the activity to background.
     * Making sure that alarm keeps running in background.
     */
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
     * Options didn't make it in time.
     * @param v Used for button onClick.
     */
    /*public void optionsButton (View v) {
        Intent options = new Intent(this, OptionsMenu.class);
        startActivity(options);
    }*/

    /**
     * Opens PesuMenu activity.
     * @param v Used for button onClick.
     */
    public void pesuButton (View v) {
        if(checkBrush() == true) {
            AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
            dlgAlert.setMessage("Pesit jo hampaasi! Odota seuraavaan hampaiden pesuun.");
            dlgAlert.setTitle("HUOM");
            dlgAlert.setPositiveButton("OK", null);
            dlgAlert.setCancelable(true);
            dlgAlert.create().show();
        } else {
            Intent pesu = new Intent(this, PesuMenu.class);
            startActivity(pesu);
        }
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

    /**
     * Used to set alarm for every 12 hours (12AM & 12PM)
     * Creates calendar that sets alarm time to 12:00:00, this alarm happens twice a day.
     * AlarmManager sets up that alarm, PendingIntent to BrushAlarm.java class.
     * setRepeating rings alarm twice a day, using the time set to the calendar (12:00 & 24:00).
     * RTC_WAKEUP uses phone's clock.
     */
    public void setAlarm () {
        Calendar cal1 = Calendar.getInstance(); // gets Calender object
        cal1.set(Calendar.HOUR,12);     // Sets alarm times
        cal1.set(Calendar.MINUTE, 0);
        cal1.set(Calendar.SECOND, 0);
        Intent alarm = new Intent(MainMenu.this, BrushAlarm.class);     // intent to BrushAlarm activity.
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(), 12345678, alarm, PendingIntent.FLAG_UPDATE_CURRENT); // pending intent to BrushAlarm activity.
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, cal1.getTimeInMillis(), AlarmManager.INTERVAL_HALF_DAY, pendingIntent); // alarm every 12 hours, compares phone clock and calendar time setted.
    }

    /**
     * Used to check if user brushed their teeth already today day/night.
     * Boolean c check the day/night cycle & Int d check weekday number.
     * If user has brushed their teeth (true), AlarmDialog prevents them from entering
     * PesuMenu until day or day/night cycle changes.
     * @return
     */
    public boolean checkBrush () {
        int d = getSharedPreferences(KEY,Context.MODE_PRIVATE).getInt(DAY, 1);  // day/night cycle as boolean
        boolean c = getSharedPreferences(KEY, Context.MODE_PRIVATE).getBoolean(CYCLE, true);    // weekday as number
        if (c == true) {    // if it's day/morning in the cycle
            if (d == 1) {   // checks every weekday in a row
                if(getSharedPreferences(KEY,Context.MODE_PRIVATE).getInt("Day1", 0) == 1) {
                    return true;
                } else {
                    return false;
                }
            } else if (d == 2) {
                if(getSharedPreferences(KEY,Context.MODE_PRIVATE).getInt("Day2", 0) == 1) {
                    return true;
                } else {
                    return false;
                }
            } else if (d == 3) {
                if(getSharedPreferences(KEY,Context.MODE_PRIVATE).getInt("Day3", 0) == 1) {
                    return true;
                } else {
                    return false;
                }
            } else if (d == 4) {
                if(getSharedPreferences(KEY,Context.MODE_PRIVATE).getInt("Day4", 0) == 1) {
                    return true;
                } else {
                    return false;
                }
            } else if (d == 5) {
                if(getSharedPreferences(KEY,Context.MODE_PRIVATE).getInt("Day5", 0) == 1) {
                    return true;
                } else {
                    return false;
                }
            } else if (d == 6) {
                if(getSharedPreferences(KEY,Context.MODE_PRIVATE).getInt("Day6", 0) == 1) {
                    return true;
                } else {
                    return false;
                }
            } else if (d == 7) {
                if(getSharedPreferences(KEY,Context.MODE_PRIVATE).getInt("Day7", 0) == 1) {
                    return true;
                } else {
                    return false;
                }
            }
        } else {                // if it's night/evening in the cycle
            if (d == 1) {       // checks every weekday in a row
                if(getSharedPreferences(KEY,Context.MODE_PRIVATE).getInt("Night1", 0) == 1) {
                    return true;
                } else {
                    return false;
                }
            } else if (d == 2) {
                if(getSharedPreferences(KEY,Context.MODE_PRIVATE).getInt("Night2", 0) == 1) {
                    return true;
                } else {
                    return false;
                }
            } else if (d == 3) {
                if(getSharedPreferences(KEY,Context.MODE_PRIVATE).getInt("Night3", 0) == 1) {
                    return true;
                } else {
                    return false;
                }
            } else if (d == 4) {
                if(getSharedPreferences(KEY,Context.MODE_PRIVATE).getInt("Night4", 0) == 1) {
                    return true;
                } else {
                    return false;
                }
            } else if (d == 5) {
                if(getSharedPreferences(KEY,Context.MODE_PRIVATE).getInt("Night5", 0) == 1) {
                    return true;
                } else {
                    return false;
                }
            } else if (d == 6) {
                if(getSharedPreferences(KEY,Context.MODE_PRIVATE).getInt("Night6", 0) == 1) {
                    return true;
                } else {
                    return false;
                }
            } else if (d == 7) {
                if(getSharedPreferences(KEY,Context.MODE_PRIVATE).getInt("Night7", 0) == 1) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    /**
     * Sets the current streak to TextView.
     * Used to display User's current streak.
     */
    public void setStreak () {
        testaako = findViewById(R.id.testiView);
        testaako.setText("Streak: " + User.getInstance().getStreak());
    }

    /**
     * Sets ImageView to display image based off User's streak.
     * If User has two or more misses in current week, ImageView displays negative pictures / badges.
     * Else ImageVIew displays positive images / badges based off User's streak value.
     */
    public void setStreakImage () {
        ImageView streak = findViewById(R.id.imageView);
        int v = User.getInstance().getStreak(); // User's this.streak
        int m = User.getInstance().getMissed(); // User's this.misses
        if(m >= 2) {    // if two or more misses, display image based off misses value.
            if(m > 4) {
                streak.setImageResource(R.drawable.missed5);
            } else if (m == 4) {
                streak.setImageResource(R.drawable.missed4);
            } else if (m == 3) {
                streak.setImageResource(R.drawable.missed3);
            } else if (m == 2) {
                streak.setImageResource(R.drawable.missed2);
            }
        } else {       // display image based off streak value.
            if(v > 4) {
                streak.setImageResource(R.drawable.streak5);
            } else if (v > 2) {
                streak.setImageResource(R.drawable.streak3);
            } else if (v == 2) {
                streak.setImageResource(R.drawable.streak2);
            } else if (v == 1) {
                streak.setImageResource(R.drawable.streak1);
            } else if (v == 0) {
                streak.setImageResource(R.drawable.streak0);
            }
        }
    }
}
