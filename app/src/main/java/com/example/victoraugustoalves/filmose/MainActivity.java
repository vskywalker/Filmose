package com.example.victoraugustoalves.filmose;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private ListView generosListView;
    private Generos_adapter adapter;
    private ArrayList<Genero> lista_generos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generosListView = (ListView) findViewById(R.id.generosListView);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://api.themoviedb.org/3/genre/movie/list?api_key=592d158f0a6670f4842533eaae583553&language=en-US";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Generos generos = new GsonBuilder().create().fromJson(response, Generos.class);
                        lista_generos = generos.genres;
                        adapter = new Generos_adapter(MainActivity.this, lista_generos);
                        generosListView.setAdapter(adapter);
                }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(stringRequest);
        generosListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent k = new Intent(MainActivity.this, Filmes_activity.class);
                Bundle b = new Bundle();
                b.putInt("id",lista_generos.get(position).id);
                b.putString("name",lista_generos.get(position).name);
                k.putExtras(b);
                startActivity(k);


            }
        });
    }



}
