package com.example.martian.quakereport;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class EarthQuakeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earth_quake);

        ArrayList<String> earthquakes=new ArrayList<String>();

        earthquakes.add("2.1");
        earthquakes.add("2.1");
        earthquakes.add("2.1");
        earthquakes.add("1.1");
        earthquakes.add("1.1");
        earthquakes.add("1.1");

        ArrayAdapter<String> itemAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,earthquakes);
        ListView listView =(ListView)findViewById(R.id.list);
        listView.setAdapter(itemAdapter);

       /* ArrayList<Earthquake> earthquakes=new ArrayList<Earthquake>();
        earthquakes.add(new Earthquake("1","Delhi","29 November"));
        earthquakes.add(new Earthquake("1","Delhi","29 November"));
        earthquakes.add(new Earthquake("1","Delhi","29 November"));
        earthquakes.add(new Earthquake("1","Delhi","29 November"));

        ArrayAdapter<Earthquake> itemsAdapter=new ArrayAdapter<Earthquake>(this, R.layout.activity_earth_quake,earthquakes);
        ListView listView=(ListView)findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);*/
    }
}
