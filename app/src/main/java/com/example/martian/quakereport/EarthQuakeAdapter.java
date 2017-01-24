package com.example.martian.quakereport;

import android.app.Activity;

import android.os.Message;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import java.text.DecimalFormat;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import java.util.Date;
import java.util.List;

/**
 * Created by martian on 16/1/17.
 */

   class EarthQuakeAdapter extends ArrayAdapter<Earthquake> {

    private static final String LOCATION_SEPARATOR = " of ";
    private String primaryLocation,locationOffset;
    private static final String LOG_TAG = EarthQuakeAdapter.class.getSimpleName();
    public EarthQuakeAdapter(Activity context, ArrayList<Earthquake> earthquakes) {
        super(context, 0,(List<Earthquake>) earthquakes);
    }


    public View getView(int position, View counterView, ViewGroup parent) {
        Log.d("Message 3","Entered getView");

        View listItemView = counterView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.layout_earthquake, parent, false);
        }

        Earthquake curentEarthquake=getItem(position);


        TextView magView=(TextView)listItemView.findViewById(R.id.magnitude);
        String formattgnitude=formatMagnitude(curentEarthquake.getmMagnitude());
        magView.setText(formattgnitude);

        GradientDrawable magnitudeCircle = (GradientDrawable) magView.getBackground();
        int magnitudeColor=getMagnitudeColor(curentEarthquake.getmMagnitude());
        magnitudeCircle.setColor(magnitudeColor);


        String originalLocation=curentEarthquake.getmPlace();


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



        Date dateObject = new Date(curentEarthquake.getTimeInMilliseconds());
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
    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }

}