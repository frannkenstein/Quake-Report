package com.example.martian.quakereport;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class EarthQuakeActivity extends AppCompatActivity {
    private static final String USGS_REQUEST_URL = "http://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&orderby=time&minmag=6&limit=10";

    private EarthQuakeAdapter earthquakeAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earth_quake);



        earthquakeAdapter = new EarthQuakeAdapter(this, new ArrayList<Earthquake>());
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(earthquakeAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Earthquake currentEarthquake = earthquakeAdapter.getItem(position);
                Uri earthquakeUri = Uri.parse(currentEarthquake.getMurl());
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, earthquakeUri);
                startActivity(websiteIntent);
            }
        });
        EarthquakeAsyncTask task = new EarthquakeAsyncTask();
        task.execute(USGS_REQUEST_URL);
    }
        private class EarthquakeAsyncTask extends AsyncTask<String, Void, List<Earthquake>> {
            @Override
            protected List<Earthquake> doInBackground(String... urls) {

                if (urls.length <= 0 || urls[0] == null) {
                    return null;
                }
                List<Earthquake> result =  QueryUtils.fetchEarthquakeData(urls[0]);
                return result;
            }
            @Override
            protected void onPostExecute(List<Earthquake> data){
                earthquakeAdapter.clear();
                if(data!=null && !data.isEmpty()){
                    earthquakeAdapter.addAll(data);
                }
            }


        }

}


