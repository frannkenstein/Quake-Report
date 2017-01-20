package com.example.martian.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.Calendar;
import java.util.List;

/**
 * Created by martian on 20/1/17.
 */

public class EarthqaukeLoader extends AsyncTaskLoader<List<Earthquake>> {
    private static final String LOG_TAG = EarthqaukeLoader.class.getName();
    private String murl;

    public EarthqaukeLoader(Context context, String url) {
        super(context);
        murl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<Earthquake> loadInBackground() {
        if (murl == null) {
            return null;
        }
        List<Earthquake> earthquakes = QueryUtils.fetchEarthquakeData(murl);
        return earthquakes;

    }
}