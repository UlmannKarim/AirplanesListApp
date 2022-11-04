package com.example.airplanelist;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

// fix this!

public class SecondActivity extends AppCompatActivity{

    ClassLoader classloader = Thread.currentThread().getContextClassLoader();

    private Button proceedButton;
    TextView nameTitle;
    ImageView airlineLogo;
    TextView textView2;
    String description;


    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle b = getIntent().getExtras();
        Airline airline = (Airline) b.getSerializable("airline_name");

        proceedButton =findViewById(R.id.proceedButton);
        proceedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SecondActivity.this, ThirdActivity.class);
                intent.putExtra("airline_name", airline); // this needs to be fixed!
                startActivity(intent);
            }
        });

        nameTitle = findViewById(R.id.nameTitle);
        airlineLogo = findViewById(R.id.airlineLogo);
        textView2 = findViewById(R.id.textView2);



        String descriptionTemplate = getTextFromRes(R.raw.descriptiontemplate);

        description = descriptionTemplate.replace("%RANKING%",airline.getRanking());
        description = description.replace("%CALLSIGN%", airline.getCallSign());
        description = description.replace("%ORIGIN%",airline.getOriginCountry());
        description = description.replace("%HOME%",airline.getHomeBaseAirport());


        nameTitle.setText(airline.getName());
        textView2.setText(description);
        proceedButton.setText("Read more on \n" + airline.getName());
        int id = SecondActivity.this.getResources().getIdentifier(airline.getIcon(), "drawable", SecondActivity.this.getPackageName());
        airlineLogo.setImageResource(id);

    }

    public String inputStreamToString(InputStream stream) {

        Scanner inputScanner = new Scanner(stream, StandardCharsets.UTF_8.name()).useDelimiter("\\A");
        String outString = inputScanner.hasNext() ? inputScanner.next() : "";
        inputScanner.close();

        return outString;
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