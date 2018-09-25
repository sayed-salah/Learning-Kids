package com.example.amany.learning_kids;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Locale;

public class numbers extends AppCompatActivity {
    String []num ;
    int p[]={R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four,R.drawable.five
            ,R.drawable.six,R.drawable.seven,R.drawable.eight,R.drawable.nine,R.drawable.ten};
    int index =0;
    ImageView m;
    String text ;
    TextToSpeech tot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        num =getResources().getStringArray(R.array.number);
        m =(ImageView)findViewById(R.id.number);
        m.setImageResource(p[index]);
        tot=new TextToSpeech(this,new TextToSpeech.OnInitListener(){
            @Override
            public void onInit(int status) {
                if(status==TextToSpeech.SUCCESS)
                {
                    tot.setLanguage(Locale.US);
                }
                else
                {
                    Toast.makeText(getApplication(),"Language not supported",Toast.LENGTH_SHORT);
                }
            }
        });
    }
    public void Speak(View w) {
        switch (w.getId())
        {
            case R.id.button5:
                text=num[index];
                tot.speak(text,TextToSpeech.QUEUE_FLUSH,null);
                break;
        }
    }
    public void Go(View v) {
        switch (v.getId()){
            case R.id.button:
                index++;
                if(index==p.length&&index==p.length){
                    index=0;
                    m.setImageResource(p[index]);
                }
                else
                {
                    m.setImageResource(p[index]);
                }
                break;
            case R.id.button3:
                index--;
                if(index==-1)
                {
                    index=p.length-1;
                    m.setImageResource(p[index]);
                }
                else
                {
                    m.setImageResource(p[index]);
                }
                break;
        }
    }

    public void backToHome(View view) {
        Intent myIntent = new Intent(this,MainActivity.class);
        startActivity(myIntent);
    }
}
