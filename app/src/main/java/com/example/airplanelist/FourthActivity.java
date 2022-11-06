package com.example.airplanelist;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class FourthActivity extends AppCompatActivity {
    WebView airlineWeb;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fourth_activity);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Airline airline = (Airline) getIntent().getExtras().getSerializable("airline_name");
        airline.getUrl(); // make call to view url of airline



        airlineWeb = findViewById(R.id.airlineWebSite);
        airlineWeb.loadUrl(airline.getUrl()); // display website

    }
}
