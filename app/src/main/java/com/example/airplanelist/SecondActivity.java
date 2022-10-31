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
    ImageView imageView2;
    TextView textView2;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle b = getIntent().getExtras();
        Airline t = (Airline) b.getSerializable("airline_name");

        buttonNext =findViewById(R.id.buttonInfo);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SecondActivity.this, Activity3.class);
                intent.putExtra("team_name", t);
                startActivity(intent);
            }
        });

        imageView2 = findViewById(R.id.imageView2);
        textView2 = findViewById(R.id.textView2);

        textView2.setText(t.getName());
        Integer id = SecondActivity.this.getResources().getIdentifier(t.getLogo(), "drawable", SecondActivity.this.getPackageName());
        imageView2.setImageResource(id);

    }
}
//this is a test