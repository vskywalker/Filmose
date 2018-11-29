package com.example.victoraugustoalves.filmose;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.net.URL;
import java.util.ArrayList;

public class FilmesAdapter extends ArrayAdapter<Filme> {
    public FilmesAdapter(Context context, ArrayList<Filme> filmes) {
        super(context, 0, filmes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Filme filme = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.filme_item, parent, false);
        }
        // Lookup view for data population
        TextView name = (TextView) convertView.findViewById(R.id.filmeTitleTextView);
        TextView rate = (TextView) convertView.findViewById(R.id.rateTextView);
        ImageView icon = (ImageView) convertView.findViewById(R.id.filmeIconImageView);
        String image_prefix = "https://image.tmdb.org/t/p/w500";
        // Populate the data into the template view using the data object
        name.setText(filme.title);
        rate.setText(Float.toString(filme.vote_average));
        String photo_url = image_prefix + filme.poster_path;
        Picasso.with(this.getContext()).
                load(photo_url).
                into(icon);
        // Return the completed view to render on screen
        return convertView;
    }


}