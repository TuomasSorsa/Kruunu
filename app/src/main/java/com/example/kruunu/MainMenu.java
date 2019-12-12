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

    public void setAlarm () {
        Calendar cal1 = Calendar.getInstance();
        cal1.set(Calendar.SECOND, 20);
        Intent alarm = new Intent(MainMenu.this, BrushAlarm.class);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(), 12345678, alarm, PendingIntent.FLAG_UPDATE_CURRENT);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, cal1.getTimeInMillis(), 1000 * 60, pendingIntent);
    }

    public boolean checkBrush () {
        int d = getSharedPreferences(KEY,Context.MODE_PRIVATE).getInt(DAY, 1);
        boolean c = getSharedPreferences(KEY, Context.MODE_PRIVATE).getBoolean(CYCLE, true);
        if (c == true) {
            if (d == 1) {
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
        } else {
            if (d == 1) {
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

    public void setStreak () {
        testaako = findViewById(R.id.testiView);
        testaako.setText("Streak: " + User.getInstance().getStreak());
    }

    public void setStreakImage () {
        ImageView streak = findViewById(R.id.imageView);
        int v = User.getInstance().getStreak();
        int m = User.getInstance().getMissed();
        if(m >= 2) {
            if(m > 4) {
                streak.setImageResource(R.drawable.missed5);
            } else if (m == 4) {
                streak.setImageResource(R.drawable.missed4);
            } else if (m == 3) {
                streak.setImageResource(R.drawable.missed3);
            } else if (m == 2) {
                streak.setImageResource(R.drawable.missed2);
            }
        } else {
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
