package com.example.kruunu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainMenu extends AppCompatActivity {
    static final String KEY = "com.Kruunu";
    static final String NAME = "com.Kruunu.User.Name";
    static final String PIN = "com.Kruunu.User,PIN";
    static final String STREAK = "com.Kruunu.USER.Streak";
    static final String MISSES = "com.Kruunu.USER.Misses";
    boolean check; TextView testaako;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Log.d("TAG", "Luotiinko uusi objekti?");
        Intent intent = getIntent();
        check = intent.getExtras().getBoolean("FIRSTER");
        if(check == true) {
            testaako = findViewById(R.id.testiView);
            User mainuser = new User(intent.getStringExtra("USER.NAME"), intent.getStringExtra("USER_PIN"));
            getSharedPreferences(KEY, Context.MODE_PRIVATE).edit().putString(NAME, mainuser.getName()).apply();
            getSharedPreferences(KEY, Context.MODE_PRIVATE).edit().putInt(MISSES, mainuser.getMissed()).apply();
            getSharedPreferences(KEY, Context.MODE_PRIVATE).edit().putInt(STREAK, mainuser.getStreak()).apply();
            getSharedPreferences(KEY, Context.MODE_PRIVATE).edit().putString(PIN, mainuser.getPassword()).apply();
            testaako.setText(mainuser.getName() + "\n" + mainuser.getPassword() + "\n" + mainuser.getStreak() + "\n" + mainuser.getMissed());
        } else if (check == false) {
            User mainuser = new User(getSharedPreferences(KEY, Context.MODE_PRIVATE).getString(NAME,""),
                    getSharedPreferences(KEY, Context.MODE_PRIVATE).getString(PIN,"1234"));
            testaako = findViewById(R.id.testiView);
            getSharedPreferences(KEY, Context.MODE_PRIVATE).edit().putString(NAME, mainuser.getName()).apply();
            getSharedPreferences(KEY, Context.MODE_PRIVATE).edit().putInt(MISSES, mainuser.getMissed()).apply();
            getSharedPreferences(KEY, Context.MODE_PRIVATE).edit().putInt(STREAK, mainuser.getStreak()).apply();
            getSharedPreferences(KEY, Context.MODE_PRIVATE).edit().putString(PIN, mainuser.getPassword()).apply();
            testaako.setText(mainuser.getName() + "\n" + mainuser.getPassword() + "\n" + mainuser.getStreak() + "\n" + mainuser.getMissed());
        } else {
            throw new IllegalArgumentException("Ei mitään käyttäjä tietoja / skippasit first time setupin, hakkeri!");
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("TAG", "Luotiinko uusi objekti?");
    }

    public void KalenteriButton (View v) {
        Intent kalenteri = new Intent(this, KalenteriMenu.class);
        startActivity(kalenteri);
    }

    public void OptionsButton (View v) {
        Intent options = new Intent(this, OptionsMenu.class);
        startActivity(options);
    }

    public void PesuButton (View v) {
        Intent pesu = new Intent(this, PesuMenu.class);
        startActivity(pesu);
    }

    public void OhjeButton (View v) {
        Intent ohje = new Intent(this, InfoMenu.class);
        startActivity(ohje);
    }
}
