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

    @Override
    public void onReceive(Context context, Intent intent) {
        SharedPreferences sharedPref = context.getSharedPreferences(KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        Log.d("TAG", "Alarm activated.");
        int day = sharedPref.getInt(DAY, 1);
        boolean time = sharedPref.getBoolean(CYCLE, true);
        if(day == 7 && time == false) { // week ends
            if(sharedPref.getInt("Night7", 0) == 0) {
                User.getInstance().streakMiss();
            }
            User.getInstance().missCheckUp();
            editor.putBoolean(CYCLE, true).apply();
            editor.putInt(DAY, 1).apply();
            editor.putInt("Day1", 0);
            editor.putInt("Night1", 0);
            editor.putInt("Day2", 0);
            editor.putInt("Night2", 0);
            editor.putInt("Day3", 0);
            editor.putInt("Night3", 0);
            editor.putInt("Day4", 0);
            editor.putInt("Night4", 0);
            editor.putInt("Day5", 0);
            editor.putInt("Night5", 0);
            editor.putInt("Day6", 0);
            editor.putInt("Night6", 0);
            editor.putInt("Day7", 0);
            editor.putInt("Night7", 0);
        } else {
            if (time == true) { // day
                editor.putBoolean(CYCLE, false).apply();
                if(day == 1 && sharedPref.getInt("Day1", 0) == 0) {
                    User.getInstance().streakMiss();
                    editor.putInt("Day1", 2).apply();
                } else if (day == 2 && sharedPref.getInt("Day2", 0) == 0) {
                    User.getInstance().streakMiss();
                    editor.putInt("Day2", 2).apply();
                } else if (day == 3 && sharedPref.getInt("Day3", 0) == 0) {
                    User.getInstance().streakMiss();
                    editor.putInt("Day3", 2).apply();
                } else if (day == 4 && sharedPref.getInt("Day4", 0) == 0) {
                    User.getInstance().streakMiss();
                    editor.putInt("Day4", 2).apply();
                } else if (day == 5 && sharedPref.getInt("Day5", 0) == 0) {
                    User.getInstance().streakMiss();
                    editor.putInt("Day5", 2).apply();
                } else if (day == 6 && sharedPref.getInt("Day6", 0) == 0) {
                    User.getInstance().streakMiss();
                    editor.putInt("Day6", 2).apply();
                } else {
                    User.getInstance().streakMiss();
                    editor.putInt("Day7", 2).apply();
                }
            }
            else { // night
                editor.putBoolean(CYCLE, true).apply();
                if(day == 1 && sharedPref.getInt("Day1", 0) == 0) {
                    User.getInstance().streakMiss();
                    editor.putInt("Night1", 2).apply();
                    editor.putInt(DAY, 2).apply();
                } else if (day == 2 && sharedPref.getInt("Day2",0) == 0) {
                    User.getInstance().streakMiss();
                    editor.putInt("Night2", 2).apply();
                    editor.putInt(DAY, 3).apply();
                } else if (day == 3 && sharedPref.getInt("Day3", 0) == 0) {
                    User.getInstance().streakMiss();
                    editor.putInt("Night3", 2).apply();
                    editor.putInt(DAY, 4).apply();
                } else if (day == 4 && sharedPref.getInt("Day4", 0) == 0) {
                    User.getInstance().streakMiss();
                    editor.putInt("Night4", 2).apply();
                    editor.putInt(DAY, 5).apply();
                } else if (day == 5 && sharedPref.getInt("Day5", 0) == 0) {
                    User.getInstance().streakMiss();
                    editor.putInt("Night5", 2).apply();
                    editor.putInt(DAY, 6).apply();
                } else if (day == 6 && sharedPref.getInt("Day6", 0) == 0) {
                    User.getInstance().streakMiss();
                    editor.putInt("Night6", 2).apply();
                    editor.putInt(DAY, 7).apply();
                }
            }
        }
    }
}
