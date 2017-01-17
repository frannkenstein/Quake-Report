package com.example.martian.quakereport;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import java.text.DecimalFormat;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by martian on 16/1/17.
 */

public class EarthQuakeAdapter extends ArrayAdapter {

    private static final String LOCATION_SEPARATOR = " of ";
    public EarthQuakeAdapter(Activity context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.layout_earthquake, parent, false);
        }

        Earthquake currentEarthquake= (Earthquake) getItem(position);

        TextView magView=(TextView)listItemView.findViewById(R.id.magnitude);
        String formatmagnitude=formatMagnitude(currentEarthquake.getmMagnitude());
        magView.setText(formatmagnitude);

        String originalLocation=currentEarthquake.getmPlace();
        String primaryLocation,locationOffset;

        if (originalLocation.contains(LOCATION_SEPARATOR)) {
            String[] parts = originalLocation.split(LOCATION_SEPARATOR);
            locationOffset = parts[0] + LOCATION_SEPARATOR;
            primaryLocation = parts[1];
        } else {
            locationOffset = getContext().getString(R.string.near_the);
            primaryLocation = originalLocation;
        }

        TextView primaryLocationView=(TextView)listItemView.findViewById(R.id.primary_location);
        primaryLocationView.setText(primaryLocation);

        TextView locationOffsetView=(TextView)listItemView.findViewById(R.id.location_offset);
        locationOffsetView.setText(locationOffset);

        //Creating Formatted Date
        /*TextView dateView=(TextView)listItemView.findViewById(R.id.date);
        dateView.setText(currentEarthquake.getmDate());
        */

        Date dateObject = new Date(currentEarthquake.getTimeInMilliseconds());
        TextView dateView=(TextView)listItemView.findViewById(R.id.date);
        String formattedDate = formatDate(dateObject);
        dateView.setText(formattedDate);

        TextView timeTextView=(TextView)listItemView.findViewById(R.id.time);
        String formattedTime=formatTime(dateObject);
        timeTextView.setText(formattedTime);


        return  listItemView;
    }
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }
    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }
}