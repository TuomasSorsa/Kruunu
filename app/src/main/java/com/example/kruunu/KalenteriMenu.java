package com.example.kruunu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;

/**
 * KalenteriMenu displays every weekday's morning and night brushings values as images.
 * If user has brushed their teeth in time; the specific image will change to a "OK" image.
 * If user missed brushing; image will change to a "DENIED" image.
 * Every image before morning & night alarm is displayed as "THINKING EMOJI" image.
 * Example. If user brushed teeth in time in Monday morning; the monday morning image is
 * displayed as "OK" image.
 */
public class KalenteriMenu extends AppCompatActivity {
    /** SharedPreferences tag. */
    static final String KEY = "com.Kruunu";
    ImageView day, night; // Used to set images

    @Override
    /**
     * onCreate sets all the images based on day/night values.
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalenteri_menu);
        aamuKuvat();    // sets all morning images
        iltaKuvat();    // sets all night images
    }

    @Override
    /**
     * onResume resets all the images based on day/night values.
     * If something somehow refreshes the activity, images will also change.
     */
    public void onResume() {
        super.onResume();
        aamuKuvat();
        iltaKuvat();
    }

    /**'
     * aamuKuvat goes through all the ImageViews used to display morning brushings.
     * If user has brushed specific morning, image is confirmation. If user has not brushed
     * image is failure. Brushings that haven't occured yet will be displayed as Thinking Emoji image.
     */
    public void aamuKuvat() {
        day = findViewById(R.id.imageMaAamu); // find Monday morning ImageView      // checks every night value and sets image based off that value
        if(getSharedPreferences(KEY, Context.MODE_PRIVATE).getInt("Day1", 0) == 1) {    // has brushed in time
            day.setImageResource(R.drawable.checkok);
        } else if (getSharedPreferences(KEY, Context.MODE_PRIVATE).getInt("Day1", 0) == 2) {    // didn't brush in time
            day.setImageResource(R.drawable.checkfail);
        } else {    // brushing alarm hasn't triggered yet
            day.setImageResource(R.drawable.thinking);
        }
        day = findViewById(R.id.imageTiAamu); // find Tuesday morning ImageView
        if(getSharedPreferences(KEY, Context.MODE_PRIVATE).getInt("Day2", 0) == 1) {
            day.setImageResource(R.drawable.checkok);
        } else if (getSharedPreferences(KEY, Context.MODE_PRIVATE).getInt("Day2", 0) == 2) {
            day.setImageResource(R.drawable.checkfail);
        } else {
            day.setImageResource(R.drawable.thinking);
        }
        day = findViewById(R.id.imageKeAamu); // find Wednesday morning ImageView
        if(getSharedPreferences(KEY, Context.MODE_PRIVATE).getInt("Day3", 0) == 1) {
            day.setImageResource(R.drawable.checkok);
        } else if (getSharedPreferences(KEY, Context.MODE_PRIVATE).getInt("Day3", 0) == 2) {
            day.setImageResource(R.drawable.checkfail);
        } else {
            day.setImageResource(R.drawable.thinking);
        }
        day = findViewById(R.id.imageToAamu); // find Thursday morning ImageView
        if(getSharedPreferences(KEY, Context.MODE_PRIVATE).getInt("Day4", 0) == 1) {
            day.setImageResource(R.drawable.checkok);
        } else if (getSharedPreferences(KEY, Context.MODE_PRIVATE).getInt("Day4", 0) == 2) {
            day.setImageResource(R.drawable.checkfail);
        } else {
            day.setImageResource(R.drawable.thinking);
        }
        day = findViewById(R.id.imagePeAamu); // find Friday morning ImageView
        if(getSharedPreferences(KEY, Context.MODE_PRIVATE).getInt("Day5", 0) == 1) {
            day.setImageResource(R.drawable.checkok);
        } else if (getSharedPreferences(KEY, Context.MODE_PRIVATE).getInt("Day5", 0) == 2) {
            day.setImageResource(R.drawable.checkfail);
        } else {
            day.setImageResource(R.drawable.thinking);
        }
        day = findViewById(R.id.imageLaAamu); // find Saturday morning ImageView
        if(getSharedPreferences(KEY, Context.MODE_PRIVATE).getInt("Day6", 0) == 1) {
            day.setImageResource(R.drawable.checkok);
        } else if (getSharedPreferences(KEY, Context.MODE_PRIVATE).getInt("Day6", 0) == 2) {
            day.setImageResource(R.drawable.checkfail);
        } else {
            day.setImageResource(R.drawable.thinking);
        }
        day = findViewById(R.id.imageSuAamu); // find Sunday morning ImageView
        if(getSharedPreferences(KEY, Context.MODE_PRIVATE).getInt("Day7", 0) == 1) {
            day.setImageResource(R.drawable.checkok);
        } else if (getSharedPreferences(KEY, Context.MODE_PRIVATE).getInt("Day7", 0) == 2) {
            day.setImageResource(R.drawable.checkfail);
        } else {
            day.setImageResource(R.drawable.thinking);
        }
    }

    /**
     * iltaKuvat goes through all the ImageViews used to display morning brushings.
     * If user has brushed specific morning, image is confirmation. If user has not brushed
     * image is failure. Brushings that haven't occured yet will be displayed as Thinking Emoji image.
     */
    public void iltaKuvat() {
        day = findViewById(R.id.imageMaIlta);   // find Monday night ImageView  // checks every night value and sets image based off that value
        if(getSharedPreferences(KEY, Context.MODE_PRIVATE).getInt("Night1", 0) == 1) {  // has brushed in time
            day.setImageResource(R.drawable.checkok);
        } else if (getSharedPreferences(KEY, Context.MODE_PRIVATE).getInt("Night1", 0) == 2) {  // didn't brush in time
            day.setImageResource(R.drawable.checkfail);
        } else {    // brushing alarm hasn't triggered yet
            day.setImageResource(R.drawable.thinking);
        }
        day = findViewById(R.id.imageTiIlta);   // find Tuesday night ImageView
        if(getSharedPreferences(KEY, Context.MODE_PRIVATE).getInt("Night2", 0) == 1) {
            day.setImageResource(R.drawable.checkok);
        } else if (getSharedPreferences(KEY, Context.MODE_PRIVATE).getInt("Night2", 0) == 2) {
            day.setImageResource(R.drawable.checkfail);
        } else {
            day.setImageResource(R.drawable.thinking);
        }
        day = findViewById(R.id.imageKeIlta);   // find Wednesday night ImageView
        if(getSharedPreferences(KEY, Context.MODE_PRIVATE).getInt("Night3", 0) == 1) {
            day.setImageResource(R.drawable.checkok);
        } else if (getSharedPreferences(KEY, Context.MODE_PRIVATE).getInt("Night3", 0) == 2) {
            day.setImageResource(R.drawable.checkfail);
        } else {
            day.setImageResource(R.drawable.thinking);
        }
        day = findViewById(R.id.imageToIlta);   // find Thursday night ImageView
        if(getSharedPreferences(KEY, Context.MODE_PRIVATE).getInt("Night4", 0) == 1) {
            day.setImageResource(R.drawable.checkok);
        } else if (getSharedPreferences(KEY, Context.MODE_PRIVATE).getInt("Night4", 0) == 2) {
            day.setImageResource(R.drawable.checkfail);
        } else {
            day.setImageResource(R.drawable.thinking);
        }
        day = findViewById(R.id.imagePeIlta);   // find Friday night ImageView
        if(getSharedPreferences(KEY, Context.MODE_PRIVATE).getInt("Night5", 0) == 1) {
            day.setImageResource(R.drawable.checkok);
        } else if (getSharedPreferences(KEY, Context.MODE_PRIVATE).getInt("Night5", 0) == 2) {
            day.setImageResource(R.drawable.checkfail);
        } else {
            day.setImageResource(R.drawable.thinking);
        }
        day = findViewById(R.id.imageLaIlta);   // find Saturday night ImageView
        if(getSharedPreferences(KEY, Context.MODE_PRIVATE).getInt("Night6", 0) == 1) {
            day.setImageResource(R.drawable.checkok);
        } else if (getSharedPreferences(KEY, Context.MODE_PRIVATE).getInt("Night6", 0) == 2) {
            day.setImageResource(R.drawable.checkfail);
        } else {
            day.setImageResource(R.drawable.thinking);
        }
        day = findViewById(R.id.imageSuIlta);   // find Sunday night ImageView
        if(getSharedPreferences(KEY, Context.MODE_PRIVATE).getInt("Night7", 0) == 1) {
            day.setImageResource(R.drawable.checkok);
        } else if (getSharedPreferences(KEY, Context.MODE_PRIVATE).getInt("Night7", 0) == 2) {
            day.setImageResource(R.drawable.checkfail);
        } else {
            day.setImageResource(R.drawable.thinking);
        }
    }
}
