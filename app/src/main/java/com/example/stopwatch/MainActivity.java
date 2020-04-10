package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private int seconds = 0;
    private boolean running = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        runTimer();
    }
    public void start(View view){
        running = true;
    }
    public void stop(View view){
        running = false;
    }
    public void reset(View view){
        running = false;
        seconds = 0;
    }
    private void runTimer(){
        final TextView myText = (TextView)findViewById(R.id.myText);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds/3600;
                int minutes = (seconds%3600)/60;
                int secs = seconds%60;
                int msecs = secs%100;


                //DESIGNING THE FORMAT OF STOPWATCH
                String time = String.format("%d:%02d:%02d.%02d", hours, minutes, secs,msecs);
                myText.setText(time);
                if(running)
                {
                    seconds++;
                }
                handler.postDelayed(this,100);
            }
        });
    }
}
