package com.example.victoraugustoalves.filmose;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Generos_adapter extends ArrayAdapter<Genero> {
    public Generos_adapter(Context context, ArrayList<Genero> generos) {
        super(context, 0, generos);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Genero genero = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.genero_item, parent, false);
        }
        // Lookup view for data population
        TextView name = (TextView) convertView.findViewById(R.id.nomeGeneroItemTextView);
        // Populate the data into the template view using the data object
        name.setText(genero.name);
        // Return the completed view to render on screen
        return convertView;
    }


}