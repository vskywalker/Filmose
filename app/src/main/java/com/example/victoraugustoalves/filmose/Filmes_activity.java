package com.example.victoraugustoalves.filmose;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class Filmes_activity extends AppCompatActivity {

    private ArrayList<Filme> filmes;
    private FilmesAdapter adapter;
    private ListView filmesListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filmes_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle b = getIntent().getExtras();
        int id_genero = b.getInt("id");
        String nome_genero = b.getString("name");

        filmesListView = (ListView) findViewById(R.id.filmesListView);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://api.themoviedb.org/3/discover/movie?api_key=592d158f0a6670f4842533eaae583553&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1&with_genres=" + id_genero;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new com.android.volley.Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Resposta resposta = new GsonBuilder().create().fromJson(response, Resposta.class);
                        filmes = resposta.results;
                        adapter = new FilmesAdapter(Filmes_activity.this, filmes);
                        filmesListView.setAdapter(adapter);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(stringRequest);

        filmesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent in = new Intent(Filmes_activity.this, FilmeDetailActivity.class);
                Bundle bn = new Bundle();
                Filme filme = filmes.get(position);
                bn.putString("title", filme.title);
                bn.putString("img_path", filme.backdrop_path);
                bn.putString("desc", filme.overview);
                bn.putString("date", filme.release_date.toString());
                in.putExtras(bn);
                startActivity(in);
            }
        });
    }

}
