package com.example.airplanelist;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    private Button nextButton;

    // create and add the objects
    TextView textView3, textView4, textView5;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_activity);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        nextButton =findViewById(R.id.buttonLink);

        Bundle b = getIntent().getExtras();
        Airline airline = (Airline) b.getSerializable("airline_name");

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ThirdActivity.this, FourthActivity.class);
                intent.putExtra("airline_name", (CharSequence) airline);
                startActivity(intent);
            }
        });

        // add get home base airport

        textView3 = findViewById(R.id.textView3);
        textView3.setText(airline.getRanking());

        textView4 = findViewById(R.id.textView4);
        textView4.setText(airline.getCallSign());

        textView5 = findViewById(R.id.textView5);
        textView5.setText(airline.getOriginCountry());

    }
}
