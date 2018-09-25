package com.example.amany.learning_kids;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Locale;

public class Month extends ActionBarActivity {

    String[] Names;
    int mon[]={R.drawable.jan,R.drawable.feb , R.drawable.mar , R.drawable.apr
            , R.drawable.may , R.drawable.jun ,
            R.drawable.july , R.drawable.aug , R.drawable.sep , R.drawable.oct
            , R.drawable.nov , R.drawable.dec };
    int index = 0;
    ImageView img;
    String text1;
    TextToSpeech tot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_month);
        Names = getResources().getStringArray(R.array.months);
        img = (ImageView)findViewById(R.id.monthImage);
        img.setImageResource(mon[index]);
        tot = new TextToSpeech(this , new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    tot.setLanguage(Locale.US);
                } else {
                    Toast.makeText(getApplication(), "Language not supported", Toast.LENGTH_SHORT);
                }
            }
        });
    }
    public void Go (View v){
        switch (v.getId()){
            case R.id.button:
                index++;
                if(index==mon.length){
                    index=0;
                    img.setImageResource(mon[index]);
                }
                else {
                    img.setImageResource(mon[index]);
                }
                break;
            case R.id.button3:
                index--;
                if(index==-1){
                    index=mon.length-1;
                    img.setImageResource(mon[index]);
                }
                else
                    img.setImageResource(mon[index]);
                break;
        }
    }
    public void speak(View w)
    {
        switch(w.getId()){
            case R.id.button5:
                text1 = Names[index];
                tot.speak(text1 , TextToSpeech.QUEUE_FLUSH ,null );
                break;
        }
    }
    public void backToHome(View view){
        Intent intent1 = new Intent(this ,MainActivity.class );
        startActivity(intent1);
    }

}

