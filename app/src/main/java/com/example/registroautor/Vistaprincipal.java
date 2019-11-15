package com.example.registroautor;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

public class Vistaprincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vistaprincipal);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    public void pasarAregistrarAutor(View view) {
        Intent intent = new Intent(Vistaprincipal.this, MainActivity.class);
        startActivity(intent);
    }

    public void pasarAdemo(View view) {
        Intent intent = new Intent(Vistaprincipal.this, demo.class);
        startActivity(intent);
    }

    public void pasarAregistrarHimnario(View view) {
        Intent intent = new Intent(Vistaprincipal.this, RegistrarHimnario.class);
        startActivity(intent);
    }
}
