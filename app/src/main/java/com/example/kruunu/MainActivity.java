package com.example.kruunu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    static final String KEY_IS_FIRST_TIME = "com.Kruunu.first_time";
    static final String KEY = "com.Kruunu";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*if (firstTime()) {
            getSharedPreferences(KEY, Context.MODE_PRIVATE).edit().putBoolean(KEY_IS_FIRST_TIME, false).commit();
        }
        else {
            Intent intent = new Intent(this, mainMenu.class);
            startActivity(intent);
            finish();
        }*/
        
    }

    public void startUserCreation (View v) {
        Intent intent = new Intent(this, userCreation.class);
        startActivity(intent);
    }

    public boolean firstTime(){
        return getSharedPreferences(KEY, Context.MODE_PRIVATE).getBoolean(KEY_IS_FIRST_TIME, true);
    }
}
