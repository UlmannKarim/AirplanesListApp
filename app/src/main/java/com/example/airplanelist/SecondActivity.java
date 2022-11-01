package com.example.airplanelist;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

// fix this!

public class SecondActivity extends AppCompatActivity{
    private Button buttonNext;

    // create and add the objects
    ImageView airlineLogo;
    TextView textView2;
    String description = "";


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle b = getIntent().getExtras();
        Airline airline = (Airline) b.getSerializable("airline_name");

        buttonNext =findViewById(R.id.buttonInfo);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SecondActivity.this, ThirdActivity.class);
                intent.putExtra("airline_name", airline); // this needs to be fixed!
                startActivity(intent);
            }
        });

        airlineLogo = findViewById(R.id.airlineLogo);
        textView2 = findViewById(R.id.textView2);

        description += airline.getName() + "\n";
        description += airline.getRanking();
        description += airline.getOriginCountry();

        textView2.setText(description);
        Integer id = SecondActivity.this.getResources().getIdentifier(airline.getLogo(), "drawable", SecondActivity.this.getPackageName());
        airlineLogo.setImageResource(id);

    }
}