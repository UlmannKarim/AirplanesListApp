package com.example.airplanelist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.net.MalformedURLException;


public class MainActivity extends AppCompatActivity implements InterfaceRecycleView {

    public RecyclerView recyclerView = null;
    public DataAdapter adapter = null;
    public AirlinesFromXML airlines = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // setup recyclerView
        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        try {
            airlines = new AirlinesFromXML(this);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        // make adapter for it
        Airline[] airlinesList = airlines.getAirlines();


        adapter = new DataAdapter(this, R.layout.row_layout, airlinesList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(int position) {
        Airline airline = airlines.getAirline(position);
        Bundle bundle = new Bundle();

        Toast.makeText(this,
                airline.getName(),
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}