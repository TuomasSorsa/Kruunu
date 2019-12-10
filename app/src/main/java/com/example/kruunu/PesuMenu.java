package com.example.kruunu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class  PesuMenu extends AppCompatActivity {
    MediaPlayer pesuplayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesu_menu);
        VideoView videoView = findViewById(R.id.videoPlayer);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.emotet;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
        videoView.start();
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Toast.makeText(PesuMenu.this, "Hampaat pesty!", Toast.LENGTH_LONG).show();
                suoritussiirto();
            }
        });
    }

    /*@Override
    protected void onPause() {
        super.onPause();
        Stop();
    }

    public void Play (View v) {
        if(pesuplayer == null) {
            pesuplayer = MediaPlayer.create(this, R.raw.pizza);
        }
        pesuplayer.start();
        pesuplayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Stop();
                Toast.makeText(PesuMenu.this, "Hampaat pesty!", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void Pause (View v) {
        if(pesuplayer != null) {
            pesuplayer.pause();
        }
    }

    public void Stop () {
        if(pesuplayer != null) {
            pesuplayer.release();
            pesuplayer = null;
        }
    }*/

    public void suoritussiirto () {
        Intent suoritus = new Intent(this, PesuSuoritus.class);
        startActivity(suoritus);
        finish();
    }
}
