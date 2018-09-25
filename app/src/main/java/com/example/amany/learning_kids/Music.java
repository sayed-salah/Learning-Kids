package com.example.amany.learning_kids;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.MediaController;
import android.widget.VideoView;

public class Music extends ActionBarActivity {
    VideoView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);


        view=(VideoView)findViewById(R.id.videoView);
        view.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.bingo);
        MediaController mediaController= new MediaController(this);
        mediaController.setAnchorView(view);
        view.setMediaController(mediaController);
        view.start();
    }


}
