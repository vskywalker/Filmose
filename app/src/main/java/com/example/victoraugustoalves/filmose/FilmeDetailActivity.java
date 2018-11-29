package com.example.victoraugustoalves.filmose;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.io.IOException;

public class FilmeDetailActivity extends AppCompatActivity {

    private LinearLayout layoutImageLinearLayout;
    private String img_path;
    private ImageView imgDeatilFilme;
    private TextView overviewTextView;
    private TextView titleDeatailTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filme_detail);

        layoutImageLinearLayout = (LinearLayout) findViewById(R.id.layoutImageLinearLayout);
        imgDeatilFilme = (ImageView) findViewById(R.id.imgDetailImageView);
        overviewTextView = (TextView) findViewById(R.id.overviewTextView);
        titleDeatailTextView = (TextView) findViewById(R.id.tituloDetailTextView);
        String img_prefix = "https://image.tmdb.org/t/p/w500";

        Bundle b = getIntent().getExtras();

        String title = b.getString("title");
        img_path = b.getString("img_path");
        String desc = b.getString("desc");
        String date = b.getString("date");

        img_path = img_prefix + img_path;

        overviewTextView.setText(desc);
        titleDeatailTextView.setText(title);

        Picasso.with(this.getApplicationContext()).
                load(img_path).
                into(imgDeatilFilme);

    }


}
