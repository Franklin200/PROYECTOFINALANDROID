package com.example.registroautor;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

public class splas_activity extends AppCompatActivity {

    private final int duracion_splash = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splas_activity);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {//lanzar la activity depues del splast
                Intent intent = new Intent(splas_activity.this,Vistaprincipal.class);
                startActivity(intent);
                finish();
            };
        },duracion_splash);

    }
}
