package com.example.kruunu;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class  PesuMenu extends AppCompatActivity {
    MediaPlayer pesuplayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesu_menu);
    }

    public void Play (View v) {
        if(pesuplayer == null) {
            pesuplayer = MediaPlayer.create(this, R.raw.cinderella)
        }
    }

    public void Pause (View v) {

    }
}
