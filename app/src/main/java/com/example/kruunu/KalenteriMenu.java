package com.example.kruunu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;

public class KalenteriMenu extends AppCompatActivity {
    /** SharedPreferences tag. */
    static final String KEY = "com.Kruunu";
    ImageView day, night;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalenteri_menu);
        aamuKuvat();
        iltaKuvat();
    }

    @Override
    public void onResume() {
        super.onResume();
        aamuKuvat();
        iltaKuvat();
    }

    public void aamuKuvat() {
        day = findViewById(R.id.imageMaAamu);
        if(getSharedPreferences(KEY, Context.MODE_PRIVATE).getInt("Day1", 0) == 1) {
            day.setImageResource(R.drawable.checkok);
        } else if (getSharedPreferences(KEY, Context.MODE_PRIVATE).getInt("Day1", 0) == 2) {
            day.setImageResource(R.drawable.checkfail);
        } else {
            day.setImageResource(R.drawable.thinking);
        }
        day = findViewById(R.id.imageTiAamu);
        if(getSharedPreferences(KEY, Context.MODE_PRIVATE).getInt("Day2", 0) == 1) {
            day.setImageResource(R.drawable.checkok);
        } else if (getSharedPreferences(KEY, Context.MODE_PRIVATE).getInt("Day2", 0) == 2) {
            day.setImageResource(R.drawable.checkfail);
        } else {
            day.setImageResource(R.drawable.thinking);
        }
        day = findViewById(R.id.imageKeAamu);
        if(getSharedPreferences(KEY, Context.MODE_PRIVATE).getInt("Day3", 0) == 1) {
            day.setImageResource(R.drawable.checkok);
        } else if (getSharedPreferences(KEY, Context.MODE_PRIVATE).getInt("Day3", 0) == 2) {
            day.setImageResource(R.drawable.checkfail);
        } else {
            day.setImageResource(R.drawable.thinking);
        }
        day = findViewById(R.id.imageToAamu);
        if(getSharedPreferences(KEY, Context.MODE_PRIVATE).getInt("Day4", 0) == 1) {
            day.setImageResource(R.drawable.checkok);
        } else if (getSharedPreferences(KEY, Context.MODE_PRIVATE).getInt("Day4", 0) == 2) {
            day.setImageResource(R.drawable.checkfail);
        } else {
            day.setImageResource(R.drawable.thinking);
        }
        day = findViewById(R.id.imagePeAamu);
        if(getSharedPreferences(KEY, Context.MODE_PRIVATE).getInt("Day5", 0) == 1) {
            day.setImageResource(R.drawable.checkok);
        } else if (getSharedPreferences(KEY, Context.MODE_PRIVATE).getInt("Day5", 0) == 2) {
            day.setImageResource(R.drawable.checkfail);
        } else {
            day.setImageResource(R.drawable.thinking);
        }
        day = findViewById(R.id.imageLaAamu);
        if(getSharedPreferences(KEY, Context.MODE_PRIVATE).getInt("Day6", 0) == 1) {
            day.setImageResource(R.drawable.checkok);
        } else if (getSharedPreferences(KEY, Context.MODE_PRIVATE).getInt("Day6", 0) == 2) {
            day.setImageResource(R.drawable.checkfail);
        } else {
            day.setImageResource(R.drawable.thinking);
        }
        day = findViewById(R.id.imageSuAamu);
        if(getSharedPreferences(KEY, Context.MODE_PRIVATE).getInt("Day7", 0) == 1) {
            day.setImageResource(R.drawable.checkok);
        } else if (getSharedPreferences(KEY, Context.MODE_PRIVATE).getInt("Day7", 0) == 2) {
            day.setImageResource(R.drawable.checkfail);
        } else {
            day.setImageResource(R.drawable.thinking);
        }
    }

    public void iltaKuvat() {
        day = findViewById(R.id.imageMaIlta);
        if(getSharedPreferences(KEY, Context.MODE_PRIVATE).getInt("Night1", 0) == 1) {
            day.setImageResource(R.drawable.checkok);
        } else if (getSharedPreferences(KEY, Context.MODE_PRIVATE).getInt("Night1", 0) == 2) {
            day.setImageResource(R.drawable.checkfail);
        } else {
            day.setImageResource(R.drawable.thinking);
        }
        day = findViewById(R.id.imageTiIlta);
        if(getSharedPreferences(KEY, Context.MODE_PRIVATE).getInt("Night2", 0) == 1) {
            day.setImageResource(R.drawable.checkok);
        } else if (getSharedPreferences(KEY, Context.MODE_PRIVATE).getInt("Night2", 0) == 2) {
            day.setImageResource(R.drawable.checkfail);
        } else {
            day.setImageResource(R.drawable.thinking);
        }
        day = findViewById(R.id.imageKeIlta);
        if(getSharedPreferences(KEY, Context.MODE_PRIVATE).getInt("Night3", 0) == 1) {
            day.setImageResource(R.drawable.checkok);
        } else if (getSharedPreferences(KEY, Context.MODE_PRIVATE).getInt("Night3", 0) == 2) {
            day.setImageResource(R.drawable.checkfail);
        } else {
            day.setImageResource(R.drawable.thinking);
        }
        day = findViewById(R.id.imageToIlta);
        if(getSharedPreferences(KEY, Context.MODE_PRIVATE).getInt("Night4", 0) == 1) {
            day.setImageResource(R.drawable.checkok);
        } else if (getSharedPreferences(KEY, Context.MODE_PRIVATE).getInt("Night4", 0) == 2) {
            day.setImageResource(R.drawable.checkfail);
        } else {
            day.setImageResource(R.drawable.thinking);
        }
        day = findViewById(R.id.imagePeIlta);
        if(getSharedPreferences(KEY, Context.MODE_PRIVATE).getInt("Night5", 0) == 1) {
            day.setImageResource(R.drawable.checkok);
        } else if (getSharedPreferences(KEY, Context.MODE_PRIVATE).getInt("Night5", 0) == 2) {
            day.setImageResource(R.drawable.checkfail);
        } else {
            day.setImageResource(R.drawable.thinking);
        }
        day = findViewById(R.id.imageLaIlta);
        if(getSharedPreferences(KEY, Context.MODE_PRIVATE).getInt("Night6", 0) == 1) {
            day.setImageResource(R.drawable.checkok);
        } else if (getSharedPreferences(KEY, Context.MODE_PRIVATE).getInt("Night6", 0) == 2) {
            day.setImageResource(R.drawable.checkfail);
        } else {
            day.setImageResource(R.drawable.thinking);
        }
        day = findViewById(R.id.imageSuIlta);
        if(getSharedPreferences(KEY, Context.MODE_PRIVATE).getInt("Night7", 0) == 1) {
            day.setImageResource(R.drawable.checkok);
        } else if (getSharedPreferences(KEY, Context.MODE_PRIVATE).getInt("Night7", 0) == 2) {
            day.setImageResource(R.drawable.checkfail);
        } else {
            day.setImageResource(R.drawable.thinking);
        }
    }
}
