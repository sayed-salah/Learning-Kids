package com.example.amany.learning_kids;
import android.content.Intent;
        import android.speech.tts.TextToSpeech;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.ImageView;
        import android.widget.Toast;

        import java.util.Locale;
public class alpha extends AppCompatActivity {

    String []names ,chr;
    int p[]={R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.f,R.drawable.g,R.drawable.h,
            R.drawable.i,R.drawable.j,R.drawable.k,R.drawable.l,R.drawable.m,R.drawable.n,R.drawable.o,
            R.drawable.p,R.drawable.q,R.drawable.r,R.drawable.s,R.drawable.t,R.drawable.u,R.drawable.v,
            R.drawable.w,R.drawable.x,R.drawable.y,R.drawable.z};  //this is for character
    int p2[]={R.drawable.aa,R.drawable.bb,R.drawable.cc,R.drawable.dd,R.drawable.ee,R.drawable.ff,
            R.drawable.gg,R.drawable.hh,R.drawable.ii,R.drawable.jj,R.drawable.kk,R.drawable.ll,
            R.drawable.mm,R.drawable.nn,R.drawable.oo,R.drawable.pp,R.drawable.qq,R.drawable.rr,R.drawable.ss,
            R.drawable.tt,R.drawable.uu,R.drawable.vv,R.drawable.ww,R.drawable.xx,R.drawable.yy,R.drawable.zz};
  // this is for symbol
    int index =0;
    ImageView m1,m2;
    String text ,text2;
    TextToSpeech tot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alpha);


        names =getResources().getStringArray(R.array.words);  //array words at strings
        chr =getResources().getStringArray(R.array.letters);  // array letters at strings
        m1 =(ImageView)findViewById(R.id.image1);
        m2 =(ImageView)findViewById(R.id.image2);
        m1.setImageResource(p[index]);
        m2.setImageResource(p2[index]);
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

    public void speak(View w) {
        switch (w.getId())
        {
            case R.id.B4:              // to spill word
                text=names[index];
                tot.speak(text,TextToSpeech.QUEUE_FLUSH,null);
                break;
            case R.id.B5:
                text2=chr[index];
                tot.speak(text2,TextToSpeech.QUEUE_FLUSH,null);
                break;

        }
    }
    public void Go(View v) {
        switch (v.getId()){
            case R.id.B3:
                index++;
                if(index==p.length&&index==p2.length){
                    index=0;
                    m1.setImageResource(p[index]);
                    m2.setImageResource(p2[index]);
                }
                else
                {
                    m2.setImageResource(p2[index]);
                    m1.setImageResource(p[index]);
                }
                break;
            case R.id.B2:
                index--;
                if(index==-1)
                {
                    index=p2.length-1;
                    index=p.length-1;
                    m2.setImageResource(p2[index]);
                    m1.setImageResource(p[index]);
                }
                else
                {
                    m2.setImageResource(p2[index]);
                    m1.setImageResource(p[index]);
                }
                break;
        }
    }

    public void backToHome(View view) {
        Intent myIntent = new Intent(this,MainActivity.class);
        startActivity(myIntent);
    }
}
