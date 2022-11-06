package com.example.airplanelist;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;



public class SecondActivity extends AppCompatActivity{

    ClassLoader classloader = Thread.currentThread().getContextClassLoader();

    private Button proceedButton;
    TextView nameTitle;
    ImageView airlineLogo;
    TextView detailsView;
    String description;



    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle b = getIntent().getExtras();
        Airline airline = (Airline) b.getSerializable("airline_name");

        proceedButton =findViewById(R.id.readMoreButton);
        proceedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SecondActivity.this, ThirdActivity.class);
                intent.putExtra("airline_name", airline);
                startActivity(intent);
            }
        });

        nameTitle = findViewById(R.id.nameTitle);
        airlineLogo = findViewById(R.id.airlineLogo);
        detailsView = findViewById(R.id.detailsView);

        String foundingYear = airline.getFoundDate().substring(airline.getFoundDate().length() -4);
        int foundingYearInt = Integer.parseInt(foundingYear);
        int yearsAgo = 2022 - foundingYearInt;


        String descriptionTemplate = getTextFromRes(R.raw.descriptiontemplate);

        description = descriptionTemplate.replace("%RANKING%",airline.getRanking());
        description = description.replace("%FOUNDDATE%",airline.getFoundDate());
        description = description.replace("%YEARS%", Integer.toString(yearsAgo));
        description = description.replace("%ALLIANCE%",airline.getAlliance());
        description = description.replace("%CALLSIGN%", airline.getCallSign());
        description = description.replace("%ORIGIN%",airline.getOriginCountry());
        description = description.replace("%HOME%",airline.getHomeBaseAirport());



        nameTitle.setText(airline.getName());
        detailsView.setText(description);
        proceedButton.setText("Read more on \n" + airline.getName());
        int id = SecondActivity.this.getResources().getIdentifier(airline.getIcon(), "drawable", SecondActivity.this.getPackageName());
        airlineLogo.setImageResource(id);


    }


    public String getTextFromRes(int resFileID) {
        InputStream inputStream = this.getResources().openRawResource(resFileID);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String currentLine;
        StringBuilder outString = new StringBuilder();

        try {
            while ((currentLine = bufferedReader.readLine()) != null) {
                outString.append(currentLine).append("\n");
            }

            inputStream.close();
            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return outString.toString();
    }
}