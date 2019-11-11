package com.example.registroautor;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MantenimientoMySQL {



    public void guardarautor(final Context context, final String dui, final String nombre, final String edad, final String descripcion){
        String url = Config.urlGuardar;
        //String url = "localhost/democrudsis21a/guardar.php";
        StringRequest request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //En este método se recibe la respuesta en json desde el web service o API.

                        try{
                            JSONObject requestJSON = new JSONObject(response.toString());
                            String estado = requestJSON.getString("estado");
                            String mensaje = requestJSON.getString("mensaje");

                            if(estado.equals("1")){
                                Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show();
                                //Toast.makeText(context, "Registro almacenado en MySQL.", Toast.LENGTH_SHORT).show();
                            }else if(estado.equals("2")){
                                Toast.makeText(context, ""+mensaje, Toast.LENGTH_SHORT).show();
                            }

                        }catch (JSONException e){
                            e.printStackTrace();
                            //Toast.makeText(context, "Se encontrarón problemas...", Toast.LENGTH_SHORT).show();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //En este método se notifica al usuario acerca de un posible error al tratar de
                //realizar una acción cualquier en la base de datos remota.
                Toast.makeText(context, "No se puedo guardar. \n" +
                        "Verifique su acceso a internet.", Toast.LENGTH_SHORT).show();
            }
        }){
            protected Map<String, String> getParams() throws AuthFailureError {
                //En este método se colocan o se setean los valores a recibir por el fichero *.php
                Map<String, String> map = new HashMap<>();
                map.put("Content-Type", "application/json; charset=utf-8");
                map.put("Accept", "application/json");
                map.put("dui", dui);
                map.put("nombre", nombre);
                map.put("edad", edad);
                map.put("descripcion", descripcion);
                return map;
            }
        };

        MySingleton.getInstance(context).addToRequestQueue(request);

    }
}
