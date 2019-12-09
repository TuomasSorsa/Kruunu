package com.example.kruunu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class PesuSuoritus extends AppCompatActivity {
    static final String KEY = "com.Kruunu";
    static final String STREAK = "com.Kruunu.USER.Streak";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesu_suoritus);

    }

    @Override
    public void onBackPressed() {
        // does nothing :)
    }

    public void vahvistus (View v) {
        User.getInstance().streakUp();
        Log.i("TAG", "Uusi streak:" + User.getInstance().getStreak());
        getSharedPreferences(KEY, Context.MODE_PRIVATE).edit().putInt(STREAK, User.getInstance().getStreak()).apply();
        Intent returnMainMenu = new Intent(this, MainMenu.class);
        startActivity(returnMainMenu);
        finish();
    }
}
