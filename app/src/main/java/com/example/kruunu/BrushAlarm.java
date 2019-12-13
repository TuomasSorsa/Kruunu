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
    /**
     * MainMenu alarm BroadcastReceiver used check current day & cycle brushing.
     * First checks if cycle is day or night and after that checks through every weekday.
     * Day/Night cycle will be changed and if it's night the weekday will go up by one. (Monday becomes Tuesday).
     * If day is correct and that day/night brushing value is 0 (not brushed yet), it will
     * be marked as 2 (missed brushing) also user's misses value will rise and might reset streak.
     * If user has brushed in time (before the alarm 12am/12pm), only weekday & cycle will change. (Time will go forward).
     * At day 7 night; user misses are reset to zero, night7 brushing is checked and marked up if necessary,
     * and every weekday day/night values will reset to 0.  (not brushed yet) starting a brand new week.
     */
    public void onReceive(Context context, Intent intent) {
        SharedPreferences sharedPref = context.getSharedPreferences(KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        Log.d("TAG", "Alarm activated.");
        int day = sharedPref.getInt(DAY, 1);
        boolean time = sharedPref.getBoolean(CYCLE, true);
        if (time == true) {     // if cycle is day
                editor.putBoolean(CYCLE, false).apply();    // change cycle to night
                dayAlarm(sharedPref, day);      // check day brushes
            }
            else {              // if cycle is night
                editor.putBoolean(CYCLE, true).apply(); // change cycle to day
                nightAlarm(sharedPref, day);    // check night brushes
            }
        }

    /**
     * dayAlarm checks every weekdays morning brushings.
     * If user hasn't brushed their teeth in time, today's day value will become 2 (brushing missed).
     * If user has brushed in time; nothing will be marked.
     * Used as a checkup if user has brushed in time.
     * @param sharedPref Used to move Sharedprefs to the method.
     * @param day Current weekday value.
     */
    public void dayAlarm (SharedPreferences sharedPref, int day) {
        SharedPreferences.Editor editor = sharedPref.edit();    // get sharedprefs to method
        if(day == 1 && sharedPref.getInt("Day1", 0) == 0) { // hasn't brushed yet in Monday
            User.getInstance().streakMiss();    // User misses value goes up by 1.
            editor.putInt(STREAK, User.getInstance().getStreak()).apply();  // saves all the data in SharedPreferences
            editor.putInt(MISSES, User.getInstance().getMissed()).apply();
            editor.putInt("Day1", 2).apply();
            Log.d("TAG", "Current day: " + sharedPref.getInt(DAY, 1) + "Date: " + sharedPref.getInt("Day1", 0) + "  Cycle: " + sharedPref.getBoolean(CYCLE,true));
        } else if (day == 2 && sharedPref.getInt("Day2", 0) == 0) { // hasn't brushed yet in Tuesday
            User.getInstance().streakMiss();
            editor.putInt(STREAK, User.getInstance().getStreak()).apply();
            editor.putInt(MISSES, User.getInstance().getMissed()).apply();
            editor.putInt("Day2", 2).apply();
            Log.d("TAG", "Current day: " + sharedPref.getInt(DAY, 1) + "Date: " + sharedPref.getInt("Day2", 0) + "  Cycle: " + sharedPref.getBoolean(CYCLE,true));
        } else if (day == 3 && sharedPref.getInt("Day3", 0) == 0) { // hasn't brushed yet in Wednesday
            User.getInstance().streakMiss();
            editor.putInt(STREAK, User.getInstance().getStreak()).apply();
            editor.putInt(MISSES, User.getInstance().getMissed()).apply();
            editor.putInt("Day3", 2).apply();
            Log.d("TAG", "Current day: " + sharedPref.getInt(DAY, 1) + "Date: " + sharedPref.getInt("Day3", 0) + "  Cycle: " + sharedPref.getBoolean(CYCLE,true));
        } else if (day == 4 && sharedPref.getInt("Day4", 0) == 0) { // hasn't brushed yet in Thursday
            User.getInstance().streakMiss();
            editor.putInt(STREAK, User.getInstance().getStreak()).apply();
            editor.putInt(MISSES, User.getInstance().getMissed()).apply();
            editor.putInt("Day4", 2).apply();
            Log.d("TAG", "Current day: " + sharedPref.getInt(DAY, 1) + "Date: " + sharedPref.getInt("Day4", 0) + "  Cycle: " + sharedPref.getBoolean(CYCLE,true));
        } else if (day == 5 && sharedPref.getInt("Day5", 0) == 0) { // hasn't brushed yet in Friday
            User.getInstance().streakMiss();
            editor.putInt(STREAK, User.getInstance().getStreak()).apply();
            editor.putInt(MISSES, User.getInstance().getMissed()).apply();
            editor.putInt("Day5", 2).apply();
            Log.d("TAG", "Current day: " + sharedPref.getInt(DAY, 1) + "Date: " + sharedPref.getInt("Day5", 0) + "  Cycle: " + sharedPref.getBoolean(CYCLE,true));
        } else if (day == 6 && sharedPref.getInt("Day6", 0) == 0) { // hasn't brushed yet in Saturday
            User.getInstance().streakMiss();
            editor.putInt(STREAK, User.getInstance().getStreak()).apply();
            editor.putInt(MISSES, User.getInstance().getMissed()).apply();
            editor.putInt("Day6", 2).apply();
            Log.d("TAG", "Current day: " + sharedPref.getInt(DAY, 1) + "Date: " + sharedPref.getInt("Day6", 0) + "  Cycle: " + sharedPref.getBoolean(CYCLE,true));
        } else if (day == 7 && sharedPref.getInt("Day7", 0) == 0){  // hasn't brushed yet in Sunday
            User.getInstance().streakMiss();
            editor.putInt(STREAK, User.getInstance().getStreak()).apply();
            editor.putInt(MISSES, User.getInstance().getMissed()).apply();
            editor.putInt("Day7", 2).apply();
            Log.d("TAG", "Current day: " + sharedPref.getInt(DAY, 1) + "Date: " + sharedPref.getInt("Day7", 0) + "  Cycle: " + sharedPref.getBoolean(CYCLE,true));
        }   // if nothing happens; user has brushed in time =)
    }

    /**
     * nightAlarm checks every weekdays night brushings.
     * If user hasn't brushed their teeth in time, today's day value will become 2 (brushing missed).
     * If user has brushed in time; nothing will be marked.
     * @param sharedPref Used to move Sharedprefs to the method.
     * @param day Current weekday value.
     */
    public void nightAlarm (SharedPreferences sharedPref, int day) {
        SharedPreferences.Editor editor = sharedPref.edit();    // get sharedprefs to method
        if(day == 1 && sharedPref.getInt("Night1", 0) == 0) {   // hasn't brushed yet in Monday
            User.getInstance().streakMiss();    // User misses value goes up by 1.
            editor.putInt(STREAK, User.getInstance().getStreak()).apply();  // saves all the data in SharedPreferences
            editor.putInt(MISSES, User.getInstance().getMissed()).apply();
            editor.putInt("Night1", 2).apply();
            editor.putInt(DAY, 2).apply();
            Log.d("TAG", "Current day: " + sharedPref.getInt(DAY, 1) + "Date: " + sharedPref.getInt("Night1", 0) + "  Cycle: " + sharedPref.getBoolean(CYCLE,true));
        } else if (day == 2 && sharedPref.getInt("Night2",0) == 0) {    // hasn't brushed yet in Tuesday
            User.getInstance().streakMiss();
            editor.putInt(STREAK, User.getInstance().getStreak()).apply();
            editor.putInt(MISSES, User.getInstance().getMissed()).apply();
            editor.putInt("Night2", 2).apply();
            editor.putInt(DAY, 3).apply();
            Log.d("TAG", "Current day: " + sharedPref.getInt(DAY, 1) + "Date: " + sharedPref.getInt("Night2", 0) + "  Cycle: " + sharedPref.getBoolean(CYCLE,true));
        } else if (day == 3 && sharedPref.getInt("Night3", 0) == 0) {   // hasn't brushed yet in Wednesday
            User.getInstance().streakMiss();
            editor.putInt(STREAK, User.getInstance().getStreak()).apply();
            editor.putInt(MISSES, User.getInstance().getMissed()).apply();
            editor.putInt("Night3", 2).apply();
            editor.putInt(DAY, 4).apply();
            Log.d("TAG", "Current day: " + sharedPref.getInt(DAY, 1) + "Date: " + sharedPref.getInt("Night3", 0) + "  Cycle: " + sharedPref.getBoolean(CYCLE,true));
        } else if (day == 4 && sharedPref.getInt("Night4", 0) == 0) {   // hasn't brushed yet in Thursday
            User.getInstance().streakMiss();
            editor.putInt(STREAK, User.getInstance().getStreak()).apply();
            editor.putInt(MISSES, User.getInstance().getMissed()).apply();
            editor.putInt("Night4", 2).apply();
            editor.putInt(DAY, 5).apply();
            Log.d("TAG", "Current day: " + sharedPref.getInt(DAY, 1) + "Date: " + sharedPref.getInt("Night4", 0) + "  Cycle: " + sharedPref.getBoolean(CYCLE,true));
        } else if (day == 5 && sharedPref.getInt("Night5", 0) == 0) {   // hasn't brushed yet in Friday
            User.getInstance().streakMiss();
            editor.putInt(STREAK, User.getInstance().getStreak()).apply();
            editor.putInt(MISSES, User.getInstance().getMissed()).apply();
            editor.putInt("Night5", 2).apply();
            editor.putInt(DAY, 6).apply();
            Log.d("TAG", "Current day: " + sharedPref.getInt(DAY, 1) + "Date: " + sharedPref.getInt("Night5", 0) + "  Cycle: " + sharedPref.getBoolean(CYCLE,true));
        } else if (day == 6 && sharedPref.getInt("Night6", 0) == 0) {   // hasn't brushed yet in Saturday
            User.getInstance().streakMiss();
            editor.putInt(STREAK, User.getInstance().getStreak()).apply();
            editor.putInt(MISSES, User.getInstance().getMissed()).apply();
            editor.putInt("Night6", 2).apply();
            editor.putInt(DAY, 7).apply();
            Log.d("TAG", "Current day: " + sharedPref.getInt(DAY, 1) + "Date: " + sharedPref.getInt("Night6", 0) + "  Cycle: " + sharedPref.getBoolean(CYCLE,true));
        } else if(day == 7) {   // Night 7 == WEEKEND
            User.getInstance().missCheckUp();   // resets user misses value.
            if(sharedPref.getInt("Night7", 0) == 0) { // hasn't brushed yet in Sunday
                User.getInstance().streakMiss();
            }
            editor.putInt(STREAK, User.getInstance().getStreak()).apply();
            editor.putInt(MISSES, User.getInstance().getMissed()).apply();
            editor.putBoolean(CYCLE, true).apply(); // sets morning & day 1
            editor.putInt(DAY, 1).apply();
            Log.d("TAG", "Current day: " + sharedPref.getInt(DAY, 1) + "Date: " + sharedPref.getInt("Night2", 0) + "  Cycle: " + sharedPref.getBoolean(CYCLE,true));
            editor.putInt("Day1", 0).apply();   // resets every day & night value back to 0 (hasn't brushed yet).
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
        } else {    // has brushed tonight
            day++;
            editor.putInt(DAY, day).apply(); // change to next weekday
        }
    }
}
