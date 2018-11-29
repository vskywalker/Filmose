package com.example.victoraugustoalves.filmose;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;

import java.io.IOException;

public class FilmeDetailActivity extends AppCompatActivity {

    private LinearLayout layoutImageLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filme_detail);

        layoutImageLinearLayout = (LinearLayout) findViewById(R.id.layoutImageLinearLayout);
        String img_prefix = "https://image.tmdb.org/t/p/w500";

        Bundle b = getIntent().getExtras();

        String title = b.getString("title");
        String img_path = b.getString("img_path");
        String desc = b.getString("desc");
        String date = b.getString("date");

        String img_url = img_prefix + img_path;

            Bitmap bitmap = null;
            try {
                bitmap = Picasso.with(this).
                load(img_url).
                error(R.drawable.ic_dashboard_black_24dp).
                get();
            } catch (IOException e) {
                e.printStackTrace();
            }


        //BitmapDrawable ob = new BitmapDrawable(getResources(), bitmap);

        //layoutImageLinearLayout.setBackground(ob);


    }

}
