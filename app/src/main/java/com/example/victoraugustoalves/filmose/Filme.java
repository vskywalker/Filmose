package com.example.victoraugustoalves.filmose;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;

public class Filme {
    int vote_count;
    int id;
    boolean video;
    float vote_average;
    String title;
    float popularity;
    String poster_path;
    String original_language;
    String original_title;
    ArrayList<Integer> genre_ids;
    String backdrop_path;
    boolean adult;
    String overview;
    Date release_date;
}