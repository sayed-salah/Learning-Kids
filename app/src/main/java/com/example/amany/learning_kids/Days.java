package com.example.amany.learning_kids;


import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Locale;

public class Days extends ActionBarActivity {
    String[]  day;
    int p []={R.drawable.sat,R.drawable.sun,R.drawable.mon,R.drawable.tues,
            R.drawable.wed,R.drawable.th,R.drawable.fri};
    int index=0;
    ImageView m;
    String text;
    TextToSpeech tot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_days);
        day = getResources().getStringArray(R.array.days);
        m = (ImageView) findViewById(R.id.imageView);
        m.setImageResource(p[index]);
        tot = new TextToSpeech(this , new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS){
                    tot.setLanguage(Locale.US);
                }else {
                    Toast.makeText(getApplication() , "Laangauge not supported." , Toast.LENGTH_LONG);
                }
            }
        });
    }

    public void Go(View view){

        switch (view.getId()){
            case R.id.button4:
                index++;
                if (index==p.length){
                    index=0;
                    m.setImageResource(p[index]);
                }else{
                    m.setImageResource(p[index]);
                }
                break;

            case R.id.button3:
                index--;
                if (index == -1){
                    index= p.length-1;
                    m.setImageResource(p[index]);
                }else {
                    m.setImageResource(p[index]);
                }
                break;
        }

    }

    public void speak(View view){

        switch (view.getId()){
            case R.id.button2:
                text=day[index];
                tot.speak(text , TextToSpeech.QUEUE_FLUSH , null);
                break;
        }

    }
    public void backToHome(View view) {
        Intent myIntent = new Intent(this,MainActivity.class);
        startActivity(myIntent);
    }

}
