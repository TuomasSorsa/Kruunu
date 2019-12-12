package com.example.kruunu;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class BrushAlarm extends BroadcastReceiver {
    /** SharedPreferences tag. */
    static final String KEY = "com.Kruunu";
    /** SharedPreferences tag. */
    static final String DAY = "Day";
    /** SharedPreferences tag. */
    static final String CYCLE = "Cycle";
    /** SharedPreferences tag. */
    static final String STREAK = "com.Kruunu.USER.Streak";
    /** SharedPreferences tag. */
    static final String MISSES = "com.Kruunu.USER.Misses";

    @Override
    public void onReceive(Context context, Intent intent) {
        SharedPreferences sharedPref = context.getSharedPreferences(KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        Log.d("TAG", "Alarm activated.");
        int day = sharedPref.getInt(DAY, 1);
        boolean time = sharedPref.getBoolean(CYCLE, true);
        if (time == true) { // day
                editor.putBoolean(CYCLE, false).apply();
                dayAlarm(sharedPref, day);
            }
            else { // night
                editor.putBoolean(CYCLE, true).apply();
                nightAlarm(sharedPref, day);
            }
        }

    public void dayAlarm (SharedPreferences sharedPref, int day) {
        SharedPreferences.Editor editor = sharedPref.edit();
        if(day == 1 && sharedPref.getInt("Day1", 0) == 0) {
            User.getInstance().streakMiss();
            editor.putInt(STREAK, User.getInstance().getStreak()).apply();
            editor.putInt(MISSES, User.getInstance().getMissed()).apply();
            editor.putInt("Day1", 2).apply();
            Log.d("TAG", "Current day: " + sharedPref.getInt(DAY, 1) + "Date: " + sharedPref.getInt("Day1", 0) + "  Cycle: " + sharedPref.getBoolean(CYCLE,true));
        } else if (day == 2 && sharedPref.getInt("Day2", 0) == 0) {
            User.getInstance().streakMiss();
            editor.putInt(STREAK, User.getInstance().getStreak()).apply();
            editor.putInt(MISSES, User.getInstance().getMissed()).apply();
            editor.putInt("Day2", 2).apply();
            Log.d("TAG", "Current day: " + sharedPref.getInt(DAY, 1) + "Date: " + sharedPref.getInt("Day2", 0) + "  Cycle: " + sharedPref.getBoolean(CYCLE,true));
        } else if (day == 3 && sharedPref.getInt("Day3", 0) == 0) {
            User.getInstance().streakMiss();
            editor.putInt(STREAK, User.getInstance().getStreak()).apply();
            editor.putInt(MISSES, User.getInstance().getMissed()).apply();
            editor.putInt("Day3", 2).apply();
            Log.d("TAG", "Current day: " + sharedPref.getInt(DAY, 1) + "Date: " + sharedPref.getInt("Day3", 0) + "  Cycle: " + sharedPref.getBoolean(CYCLE,true));
        } else if (day == 4 && sharedPref.getInt("Day4", 0) == 0) {
            User.getInstance().streakMiss();
            editor.putInt(STREAK, User.getInstance().getStreak()).apply();
            editor.putInt(MISSES, User.getInstance().getMissed()).apply();
            editor.putInt("Day4", 2).apply();
            Log.d("TAG", "Current day: " + sharedPref.getInt(DAY, 1) + "Date: " + sharedPref.getInt("Day4", 0) + "  Cycle: " + sharedPref.getBoolean(CYCLE,true));
        } else if (day == 5 && sharedPref.getInt("Day5", 0) == 0) {
            User.getInstance().streakMiss();
            editor.putInt(STREAK, User.getInstance().getStreak()).apply();
            editor.putInt(MISSES, User.getInstance().getMissed()).apply();
            editor.putInt("Day5", 2).apply();
            Log.d("TAG", "Current day: " + sharedPref.getInt(DAY, 1) + "Date: " + sharedPref.getInt("Day5", 0) + "  Cycle: " + sharedPref.getBoolean(CYCLE,true));
        } else if (day == 6 && sharedPref.getInt("Day6", 0) == 0) {
            User.getInstance().streakMiss();
            editor.putInt(STREAK, User.getInstance().getStreak()).apply();
            editor.putInt(MISSES, User.getInstance().getMissed()).apply();
            editor.putInt("Day6", 2).apply();
            Log.d("TAG", "Current day: " + sharedPref.getInt(DAY, 1) + "Date: " + sharedPref.getInt("Day6", 0) + "  Cycle: " + sharedPref.getBoolean(CYCLE,true));
        } else if (day == 7 && sharedPref.getInt("Day7", 0) == 0){
            User.getInstance().streakMiss();
            editor.putInt(STREAK, User.getInstance().getStreak()).apply();
            editor.putInt(MISSES, User.getInstance().getMissed()).apply();
            editor.putInt("Day7", 2).apply();
            Log.d("TAG", "Current day: " + sharedPref.getInt(DAY, 1) + "Date: " + sharedPref.getInt("Day7", 0) + "  Cycle: " + sharedPref.getBoolean(CYCLE,true));
        }
    }

    public void nightAlarm (SharedPreferences sharedPref, int day) {
        SharedPreferences.Editor editor = sharedPref.edit();
        if(day == 1 && sharedPref.getInt("Night1", 0) == 0) {
            User.getInstance().streakMiss();
            editor.putInt(STREAK, User.getInstance().getStreak()).apply();
            editor.putInt(MISSES, User.getInstance().getMissed()).apply();
            editor.putInt("Night1", 2).apply();
            editor.putInt(DAY, 2).apply();
            Log.d("TAG", "Current day: " + sharedPref.getInt(DAY, 1) + "Date: " + sharedPref.getInt("Night1", 0) + "  Cycle: " + sharedPref.getBoolean(CYCLE,true));
        } else if (day == 2 && sharedPref.getInt("Night2",0) == 0) {
            User.getInstance().streakMiss();
            editor.putInt(STREAK, User.getInstance().getStreak()).apply();
            editor.putInt(MISSES, User.getInstance().getMissed()).apply();
            editor.putInt("Night2", 2).apply();
            editor.putInt(DAY, 3).apply();
            Log.d("TAG", "Current day: " + sharedPref.getInt(DAY, 1) + "Date: " + sharedPref.getInt("Night2", 0) + "  Cycle: " + sharedPref.getBoolean(CYCLE,true));
        } else if (day == 3 && sharedPref.getInt("Night3", 0) == 0) {
            User.getInstance().streakMiss();
            editor.putInt(STREAK, User.getInstance().getStreak()).apply();
            editor.putInt(MISSES, User.getInstance().getMissed()).apply();
            editor.putInt("Night3", 2).apply();
            editor.putInt(DAY, 4).apply();
            Log.d("TAG", "Current day: " + sharedPref.getInt(DAY, 1) + "Date: " + sharedPref.getInt("Night3", 0) + "  Cycle: " + sharedPref.getBoolean(CYCLE,true));
        } else if (day == 4 && sharedPref.getInt("Night4", 0) == 0) {
            User.getInstance().streakMiss();
            editor.putInt(STREAK, User.getInstance().getStreak()).apply();
            editor.putInt(MISSES, User.getInstance().getMissed()).apply();
            editor.putInt("Night4", 2).apply();
            editor.putInt(DAY, 5).apply();
            Log.d("TAG", "Current day: " + sharedPref.getInt(DAY, 1) + "Date: " + sharedPref.getInt("Night4", 0) + "  Cycle: " + sharedPref.getBoolean(CYCLE,true));
        } else if (day == 5 && sharedPref.getInt("Night5", 0) == 0) {
            User.getInstance().streakMiss();
            editor.putInt(STREAK, User.getInstance().getStreak()).apply();
            editor.putInt(MISSES, User.getInstance().getMissed()).apply();
            editor.putInt("Night5", 2).apply();
            editor.putInt(DAY, 6).apply();
            Log.d("TAG", "Current day: " + sharedPref.getInt(DAY, 1) + "Date: " + sharedPref.getInt("Night5", 0) + "  Cycle: " + sharedPref.getBoolean(CYCLE,true));
        } else if (day == 6 && sharedPref.getInt("Night6", 0) == 0) {
            User.getInstance().streakMiss();
            editor.putInt(STREAK, User.getInstance().getStreak()).apply();
            editor.putInt(MISSES, User.getInstance().getMissed()).apply();
            editor.putInt("Night6", 2).apply();
            editor.putInt(DAY, 7).apply();
            Log.d("TAG", "Current day: " + sharedPref.getInt(DAY, 1) + "Date: " + sharedPref.getInt("Night6", 0) + "  Cycle: " + sharedPref.getBoolean(CYCLE,true));
        } else if(day == 7) {
            User.getInstance().missCheckUp();
            if(sharedPref.getInt("Night7", 0) == 0) {
                User.getInstance().streakMiss();
            }
            editor.putInt(STREAK, User.getInstance().getStreak()).apply();
            editor.putInt(MISSES, User.getInstance().getMissed()).apply();
            editor.putBoolean(CYCLE, true).apply();
            editor.putInt(DAY, 1).apply();
            Log.d("TAG", "Current day: " + sharedPref.getInt(DAY, 1) + "Date: " + sharedPref.getInt("Night2", 0) + "  Cycle: " + sharedPref.getBoolean(CYCLE,true));
            editor.putInt("Day1", 0).apply();
            editor.putInt("Night1", 0).apply();
            editor.putInt("Day2", 0).apply();
            editor.putInt("Night2", 0).apply();
            editor.putInt("Day3", 0).apply();
            editor.putInt("Night3", 0).apply();
            editor.putInt("Day4", 0).apply();
            editor.putInt("Night4", 0).apply();
            editor.putInt("Day5", 0).apply();
            editor.putInt("Night5", 0).apply();
            editor.putInt("Day6", 0).apply();
            editor.putInt("Night6", 0).apply();
            editor.putInt("Day7", 0).apply();
            editor.putInt("Night7", 0).apply();
        } else {
            day++;
            editor.putInt(DAY, day).apply();
        }
    }
}
