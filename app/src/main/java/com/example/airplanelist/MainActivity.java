
//https://codeshare.io/dwgyVM

package com.example.airplanelist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;



//public class MainActivity extends AppCompatActivity implements InterfaceRecycleView {
public class MainActivity extends AppCompatActivity {

    public RecyclerView recyclerView = null;
    public DataAdapter adapter = null;
    public AirlinesFromXML airlines = null;

   //public People [] names = {"Sabin T", "Sabin Tab", "Sabin Tabir", "Sabin Tabirca", "Sabin Ttt", "Sabin Tttttt"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // setup recyclerView
        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        airlines = new AirlinesFromXML(this);
        // make adapter for it
        Airline[] airlinesList = airlines.getAirlines();


        adapter = new DataAdapter(this, R.layout.row_layout, airlinesList);
        recyclerView.setAdapter(adapter);
    }

//    @Override
//    public void onItemClick(int position) {
//        // what to do when click a list item?
//
//        // get data associate with pos
//
//        Airline airline = airlines.getAirline(position);
//        Bundle bundle = new Bundle();
//        // make an intent + place the bundle on it + start activity
//
//        Toast.makeText(this,
//                airline.getName(),
//                Toast.LENGTH_LONG).show();
//
//    }
}

// for marks
// have menus
// layout menu file, describe what we have in it
// inflate and deal with clicking in the menu

// simple info about about the assignment

// break linear storyboard,
// from list land to second activity, button more info -> web info, text detail activity,
// web activity

// method to extract from the webpage to expose only some information (API call)
// eg find stats of the players and integrate within app