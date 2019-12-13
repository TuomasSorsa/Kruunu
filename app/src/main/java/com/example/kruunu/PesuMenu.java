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

/**
 * PesuMenu plays a tooth brushing video that shows proper "technique".
 * After the video ends, PesuSuoritus activity is opened, where
 * user confirms their brushing.
 *
 * @author Tuomas Sihvo
 * @version 1.0
 * @since 9.12.2019
 */
public class  PesuMenu extends AppCompatActivity {
    MediaPlayer pesuplayer;

    /**
     * onCreate creates MediaController & Uri for VideoView to play the video.
     * The video starts automatically after the player is setup. The will last about
     * 2 minutes and after it finishes; PesuSuoritus activity will be opened.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesu_menu);
        VideoView videoView = findViewById(R.id.videoPlayer);   // Setting up the VideoPlayer / VideoView
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.toothbrush;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
        videoView.start();  // Starts the video automatically.
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {  // Listener for when the video finishes / ends.
            @Override
            public void onCompletion(MediaPlayer mp) {
                Toast.makeText(PesuMenu.this, "Hampaat pesty!", Toast.LENGTH_LONG).show();  // Shows a popup message.
                suoritussiirto();   // starts PesuSuoritus activity.
            }
        });
    }
    // all below is unused MediaPlayer code for scrapped mp3.player (replaced by video).
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

    /**
     * Starts PesuSuoritus.java activity.
     */
    public void suoritussiirto () {
        Intent suoritus = new Intent(this, PesuSuoritus.class);
        startActivity(suoritus);
        finish();
    }
}
