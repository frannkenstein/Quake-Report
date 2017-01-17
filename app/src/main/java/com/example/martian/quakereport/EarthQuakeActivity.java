package com.example.martian.quakereport;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class EarthQuakeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earth_quake);


        ArrayList<Earthquake> earthquakes = QueryUtils.extractEarthquakes();


        //Hidding the fake data and Entering the new JSONData

        /*ArrayList<Earthquake> earthquakes=new ArrayList<Earthquake>();
        earthquakes.add(new Earthquake("1.1","Delhi","29 November"));
        earthquakes.add(new Earthquake("1.1","Delhi","29 November"));
        earthquakes.add(new Earthquake("1.1","Delhi","29 November"));
        earthquakes.add(new Earthquake("1.1","Delhi","29 November"));*/

       final EarthQuakeAdapter earthquakeAdapter = new EarthQuakeAdapter(this, earthquakes);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(earthquakeAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Earthquake currentEarthquake=earthquakeAdapter.getItem(position);
                Uri earthquakeUri=Uri.parse(currentEarthquake.getMurl());
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, earthquakeUri);
                startActivity(websiteIntent);
            }
        });
    }
}
