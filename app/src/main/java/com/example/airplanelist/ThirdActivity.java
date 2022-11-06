package com.example.airplanelist;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    private Button toWebButton;
    String baseURL = "https://en.wikipedia.org/wiki/";
    String fullURL;

    TextView parsedDetailsView;
    ImageView airlineLogo;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_activity);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toWebButton =findViewById(R.id.buttonLink);

        Bundle b = getIntent().getExtras();
        Airline airline = (Airline) b.getSerializable("airline_name");

        toWebButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ThirdActivity.this, FourthActivity.class);
                intent.putExtra("airline_name", airline);
                startActivity(intent);
            }
        });

        airlineLogo = findViewById(R.id.airlineLogo);

        parsedDetailsView = findViewById(R.id.parsedDetailsView);
        fullURL = baseURL+=airline.getWikiSubject();

        int id = ThirdActivity.this.getResources().getIdentifier(airline.getIcon(), "drawable", ThirdActivity.this.getPackageName());
        airlineLogo.setImageResource(id);

        new WikiParser(ThirdActivity.this,fullURL,parsedDetailsView).execute();



    }

}
