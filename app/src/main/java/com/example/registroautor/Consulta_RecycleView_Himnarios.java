package com.example.registroautor;

<<<<<<< HEAD
public class Consulta_RecycleView_Himnarios {

}
=======
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

public class Consulta_RecycleView_Himnarios extends AppCompatActivity {

    List<Himnarios> HimnariosList;
    RecyclerView recyclerView;

    AdaptadorHimnarios adapter;

    AlertDialog.Builder dialogo;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            new android.app.AlertDialog.Builder(this)
                    .setIcon(R.drawable.ic_close)
                    .setTitle("Advertencia")
                    .setMessage("¿Realmente desea salir?")
                    .setNegativeButton(android.R.string.cancel, null)
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {//un listener que al pulsar, cierre la aplicacion
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .show();
            return true;
        }
        //para las demas cosas, se reenvia el evento al listener habitual
        return super.onKeyDown(keyCode, event);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta__recycler_view);

        Toolbar toolbar = findViewById(R.id.toolbar1);
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_back));
        toolbar.setTitleTextColor(getResources().getColor(R.color.mycolor1));
        toolbar.setTitleMargin(0, 0, 0, 0);
        toolbar.setSubtitle("Consulta de Himnarios");
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogConfirmacion();
            }

            private void DialogConfirmacion() {
            }
        });

        ///y esto para pantalla completa (oculta incluso la barra de estado)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        HimnariosList = new ArrayList<>();



        //Toast.makeText(this, "Si", Toast.LENGTH_SHORT).show();

        loadHimnarios();

    }


    private void loadHimnarios() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        //Toast.makeText(Consulta_RecyclerView.this, ""+response, Toast.LENGTH_SHORT).show();

                        try {
                            JSONArray array = new JSONArray(response);
                            int totalEncontrados = array.length();


                            for (int i = 0; i < array.length(); i++) {

                                JSONObject articulosObject = array.getJSONObject(i);

                                HimnariosList.add(new Himnarios(
                                        articulosObject.getString("titulo"),
                                        articulosObject.getString("descripcion"),
                                        articulosObject.getString("categoria"),
                                        articulosObject.getString("fecha"),
                                        articulosObject.getString("img")));
                            }


                            adapter = new AdaptadorHimnarios(Consulta_RecycleView_Himnarios.this, HimnariosList);
                            recyclerView.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Consulta_RecycleView_Himnarios.this, "Error. Compruebe su acceso a Internet.", Toast.LENGTH_SHORT).show();
            }
        });

        //Volley.newRequestQueue(this).add(stringRequest);
        // MySingleton.getInstance(this).addToRequestQueue(stringRequest);
        MySingleton.getInstance(Consulta_RecycleView_Himnarios.this).addToRequestQueue(stringRequest);
    }

                    }




>>>>>>> de13357593c82fbbe4978899e69a7e8711d83d46
