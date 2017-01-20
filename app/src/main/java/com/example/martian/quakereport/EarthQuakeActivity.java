package com.example.martian.quakereport;

import android.content.Intent;
import android.content.Loader;
import android.net.Uri;
import android.app.LoaderManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import android.app.LoaderManager.LoaderCallbacks;
import android.widget.TextView;

import static com.example.martian.quakereport.QueryUtils.LOG_TAG;


public class EarthQuakeActivity extends AppCompatActivity  implements LoaderCallbacks<List<Earthquake>> {
    private static final String USGS_REQUEST_URL = "http://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&orderby=time&minmag=7&limit=10";
    private static final int EARTHQUAKE_LOADER_ID = 1;
    private TextView mEmptyStateTextView;
    private EarthQuakeAdapter earthquakeAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(LOG_TAG,"ONCreate is called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earth_quake);


        earthquakeAdapter = new EarthQuakeAdapter(this, new ArrayList<Earthquake>());
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(earthquakeAdapter);

        mEmptyStateTextView = (TextView) findViewById(R.id.empty_view);
        listView.setEmptyView(mEmptyStateTextView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Earthquake currentEarthquake = earthquakeAdapter.getItem(position);
                Uri earthquakeUri = Uri.parse(currentEarthquake.getMurl());
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, earthquakeUri);
                startActivity(websiteIntent);
            }
        });
        LoaderManager loaderManager=getLoaderManager();
        Log.i(LOG_TAG,"calling initloader");
        loaderManager.initLoader(EARTHQUAKE_LOADER_ID,null,this);
    }
        @Override
    public Loader<List<Earthquake>> onCreateLoader(int i,Bundle bundle){
            Log.i(LOG_TAG,"calling oncreateLoader called");
            return new EarthqaukeLoader(this,USGS_REQUEST_URL);
        }
    @Override
       public void onLoadFinished(Loader<List<Earthquake>> loader, List<Earthquake> earthquakes) {
        mEmptyStateTextView.setText(R.string.no_earthquakes);
        earthquakeAdapter.clear();
        Log.i(LOG_TAG,"calling onloadfinished");
        if (earthquakes != null && !earthquakes.isEmpty()) {
            earthquakeAdapter.addAll(earthquakes);
        }
    }

    @Override
        public void onLoaderReset(Loader<List<Earthquake>> loader) {
        Log.i(LOG_TAG,"calling onLoadreset");
        // Loader reset, so we can clear out our existing data.
                       earthquakeAdapter.clear();
    }
}



