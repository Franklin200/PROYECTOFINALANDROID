package com.example.registroautor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class demo extends AppCompatActivity implements View.OnClickListener{

    private Button play , stop;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        play = (Button)findViewById(R.id.btnplay);
        stop = (Button)findViewById(R.id.btnstop);
        mp = MediaPlayer.create(this, R.raw.tusojos);
        play.setOnClickListener(this);
        stop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnplay:
                mp.start();
            break;
            case R.id.btnstop:
                mp.stop();
                break;
        }
    }
}
