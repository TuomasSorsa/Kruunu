package com.example.kruunu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.VoiceInteractor;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DelUserInfoActivity extends AppCompatActivity {
    static final String KEY = "com.Kruunu";
    static final String NAME = "com.Kruunu.User.Name";
    static final String PIN = "com.Kruunu.User,PIN";
    static final String STREAK = "com.Kruunu.USER.Streak";
    static final String MISSES = "com.Kruunu.USER.Misses";
    static final String KEY_IS_FIRST_TIME = "com.Kruunu.first_time";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_del_user_info);

        Button mShowDialog = (Button) findViewById(R.id.btnDelUser);
        mShowDialog.setOnClickListener(new View.OnClickListener() {
            public void enHalua(View view){

                Intent previousActivity = new Intent(DelUserInfoActivity.this, OptionsMenu.class);
                startActivity(previousActivity);
            }
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(DelUserInfoActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.dialog_question, null);
                Button mYes = (Button) mView.findViewById(R.id.btnYes);



        mBuilder.setView(mView);
            final AlertDialog dialog = mBuilder.create();
            dialog.show();
            mYes.setOnClickListener (new View.OnClickListener(){
            @Override
                public void onClick(View v){
                getSharedPreferences(KEY, Context.MODE_PRIVATE).edit().putString(NAME, User.getInstance().getName()).clear().apply();
                getSharedPreferences(KEY, Context.MODE_PRIVATE).edit().putInt(MISSES, User.getInstance().getMissed()).clear().apply();
                getSharedPreferences(KEY, Context.MODE_PRIVATE).edit().putInt(STREAK, User.getInstance().getStreak()).clear().apply();
                getSharedPreferences(KEY, Context.MODE_PRIVATE).edit().putString(PIN, User.getInstance().getPassword()).clear().apply();
                getSharedPreferences(KEY, Context.MODE_PRIVATE).edit().putBoolean(KEY_IS_FIRST_TIME, false).clear().apply();
             //  SharedPreferences.Editor.clear();
                dialog.hide();
                Intent userCreation = new Intent(DelUserInfoActivity.this, UserCreation.class);
                startActivity(userCreation);
            }

            });

            }
    });




    /*public void resetPrefs(View view) {
        SharedPreferences prefGet = getSharedPreferences("sharedPref" , MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = prefGet.edit();
        prefEditor.clear();
        prefEditor.apply();

    }*/
    /*

    /*public void testiNappi(View view){
        new AlertDialog.Builder(this)
                .setTitle("Exit")
                .setMessage("Are you sure you want to exit?")
                .setNegativeButton("No",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) { }})
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferences settings = getSharedPreferences("Shared P", 0)

                    }
                })
        Intent previousActivity = new Intent(DelUserInfoActivity.this, OptionsMenu.class);
        startActivity(previousActivity);

    }*/
    }
    public void enHalua(View view){
        Intent previousActivity = new Intent(DelUserInfoActivity.this, OptionsMenu.class);
        startActivity(previousActivity);
    }
}
