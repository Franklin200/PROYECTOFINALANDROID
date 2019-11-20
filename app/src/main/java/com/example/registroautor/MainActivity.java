package com.example.registroautor;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etdui, etnombre, etedad, etdescripcion;
    private Button btnguardarautor, btnlimpiar, btnconsultardui;

    String frank;
    boolean inputDui, inputN, inputE, inputD = false;


    MantenimientoMySQL manto = new MantenimientoMySQL();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnguardarautor = (Button)findViewById(R.id.btn_guardarautor);
        btnlimpiar = (Button)findViewById(R.id.btn_nuevo);
        btnconsultardui = (Button)findViewById(R.id.btn_consultarAutordui);



        etdui = (EditText)findViewById(R.id.et_dui);
        etnombre = (EditText)findViewById(R.id.et_nombre);
        etedad = (EditText)findViewById(R.id.et_edad);
        etdescripcion = (EditText)findViewById(R.id.et_descripcionautor);


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


        btnguardarautor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (etdui.getText().toString().length() == 0) {
                    etdui.setError("Campo obligatorio");
                    inputDui = false;
                } else {
                    inputDui = true;
                }

                if (etnombre.getText().toString().length() == 0) {
                    etnombre.setError("Campo obligatorio");
                    inputN = false;
                } else {
                    inputN = true;
                }

                if (etedad.getText().toString().length() == 0) {
                    etedad.setError("Campo obligatorio");
                    inputE = false;
                } else {
                    inputE = true;
                }

                if (etdescripcion.getText().toString().length() == 0) {
                    etdescripcion.setError("Campo obligatorio");
                    inputD = false;
                } else {
                    inputD = true;
                }

                if (inputDui && inputN && inputE && inputD){

                    String dui = etdui.getText().toString();
                    String nombre = etnombre.getText().toString();
                    String edad = etedad.getText().toString();
                     String descripcion = etdescripcion.getText().toString();

                      manto.guardarautor(MainActivity.this, dui, nombre, edad, descripcion);
                    Limpiar();
                    etdui.requestFocus();
            }else {
                    Toast.makeText(MainActivity.this, "ERROR... \n Verifique los datos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnconsultardui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(etdui.getText().toString().length()==0){
                    etdui.setError("campo obligatorio");
                    inputDui = false;
                }else {
                    inputDui=true;
                }

                if(inputDui) {
                    String dui = etdui.getText().toString();
                    manto.consultarDui(MainActivity.this, dui);
                    etdui.requestFocus();
                }
            }
        });

        btnlimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Limpiar();
            }
        });


    }

    public void Limpiar(){
        etdui.setText(null);
        etnombre.setText(null);
        etedad.setText(null);
        etdescripcion.setText(null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
