package com.example.amany.learning_kids;

import android.content.Intent;
        import android.media.MediaPlayer;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


      b = (Button) findViewById(R.id.mm);
         b.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent i = new Intent(MainActivity.this,Sound.class);
                 startActivity(i);
             }
         });
    }

    public void alpha(View view) {

        Intent myIntent = new Intent(this,alpha.class);
        startActivity(myIntent);
    }

    public void GoToNumbers(View view) {
        Intent myIntent = new Intent(this,numbers.class);
        startActivity(myIntent);

    }

    public void GoToMonth(View view) {
        Intent myIntent = new Intent(this,Month.class);
        startActivity(myIntent);

    }

    public void GoToDays(View view) {
        Intent myIntent = new Intent(this,Days.class);
        startActivity(myIntent);

    }
}



