package com.example.registroautor;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;


public class RegistrarHimnario extends AppCompatActivity {

    private EditText ettitulo, etdescripcion, etcategoria,etfecha;

    boolean inputT, inputD, inputC, inputF, inputDui = false;
    private Spinner spinner;
    ArrayList<String> autores;

    private Button btnguardarhimnario;

    MantenimientoMySQL manto = new MantenimientoMySQL();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_himnario);

        btnguardarhimnario = (Button)findViewById(R.id.btnguardarhimnario);
        ettitulo = (EditText)findViewById(R.id.et_titulo);
        etdescripcion = (EditText)findViewById(R.id.et_descripcion);
        etcategoria = (EditText)findViewById(R.id.et_categoria);
        etfecha = (EditText)findViewById(R.id.et_fecha);

        autores =new ArrayList<>();
        spinner = (Spinner) findViewById(R.id.sppAutores);
        listar();

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String autor=   spinner.getItemAtPosition(spinner.getSelectedItemPosition()).toString();
                Toast.makeText(getApplicationContext(),autor, Toast.LENGTH_LONG).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // DO Nothing here
            }
        });

        btnguardarhimnario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ettitulo.getText().toString().length() == 0) {
                    ettitulo.setError("Campo obligatorio");
                    inputT = false;
                } else {
                    inputT = true;
                }

                if (etdescripcion.getText().toString().length() == 0) {
                    etdescripcion.setError("Campo obligatorio");
                    inputD = false;
                } else {
                    inputD = true;
                }

                if (etcategoria.getText().toString().length() == 0) {
                    etcategoria.setError("Campo obligatorio");
                    inputC = false;
                } else {
                    inputC = true;
                }

                if (etfecha.getText().toString().length() == 0) {
                    etfecha.setError("Campo obligatorio");
                    inputF = false;
                } else {
                    inputF = true;
                }

                if (etdescripcion.getText().toString().length() == 0) {
                    etdescripcion.setError("Campo obligatorio");
                    inputD = false;
                } else {
                    inputD = true;
                }

                if (inputT && inputD && inputC && inputF && inputD){

                    String titulo = ettitulo.getText().toString();
                    String descripcion = etdescripcion.getText().toString();
                    String categoria = etcategoria.getText().toString();
                    String fecha = etfecha.getText().toString();
                    String dui = spinner.getSelectedItem().toString();

                    manto.guardarhimnario(RegistrarHimnario.this, titulo, descripcion, categoria, fecha, dui);
                    //Limpiar();
                    ettitulo.requestFocus();
                }else {
                    Toast.makeText(RegistrarHimnario.this, "ERROR... \n Verifique los datos", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void Limpiar(){
        ettitulo.setText(null);
        etdescripcion.setText(null);
        etcategoria.setText(null);
        etfecha.setText(null);
    }


    public void listar(){
        RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest=new StringRequest(Request.Method.POST, Config.URL_WEB_SERVICES+"listarspinner.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonObject=new JSONObject(response);
                            JSONArray jsonArray=jsonObject.getJSONArray("usuario");
                            for(int i=0;i<jsonArray.length();i++){
                                JSONObject jsonObject1=jsonArray.getJSONObject(i);
                                String country=jsonObject1.getString("nombre");
                                autores.add(country);
                            }
                            spinner.setAdapter(new ArrayAdapter<String>(RegistrarHimnario.this, android.R.layout.simple_spinner_dropdown_item, autores));
                        }catch (JSONException e){e.printStackTrace();}
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        int socketTimeout = 30000;
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequest.setRetryPolicy(policy);
        requestQueue.add(stringRequest);
    }

}
