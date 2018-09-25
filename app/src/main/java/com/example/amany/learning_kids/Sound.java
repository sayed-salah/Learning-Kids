package com.example.amany.learning_kids;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;


public class Sound extends ActionBarActivity {
    MediaPlayer m1;
    ImageView p1,pu1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound);

        p1=(ImageView)findViewById(R.id.play);
        pu1=(ImageView)findViewById(R.id.pause);

        m1=MediaPlayer.create(this,R.raw.ddddd);

        p1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                m1.start();
            }
        });
        pu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                m1.pause();
            }
        });

    }

    public void Video(View view)
    {
        Intent i = new Intent(Sound.this,Music.class);
        startActivity(i);
    }


}
