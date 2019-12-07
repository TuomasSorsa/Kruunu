package com.example.kruunu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    static final String KEY_IS_FIRST_TIME = "com.Kruunu.first_time";
    static final String KEY = "com.Kruunu";
    static Activity activityA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activityA = this;
        if (firstTime() == false) {
            boolean firstSetup = false;
            Intent intent = new Intent(this, MainMenu.class);
            intent.putExtra("FIRSTER", firstSetup);
            startActivity(intent);
            finish();
        }
    }

    public void startUserCreation (View v) {
        Intent intent = new Intent(this, UserCreation.class);
        startActivity(intent);
    }

    public boolean firstTime(){
        return getSharedPreferences(KEY, Context.MODE_PRIVATE).getBoolean(KEY_IS_FIRST_TIME, true);
    }

    public static Activity getInstance(){
        return activityA;
    }
}
