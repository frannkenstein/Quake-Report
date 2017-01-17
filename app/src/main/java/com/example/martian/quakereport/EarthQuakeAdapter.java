package com.example.martian.quakereport;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by martian on 16/1/17.
 */

public class EarthQuakeAdapter extends ArrayAdapter {

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
        magView.setText(currentEarthquake.getmMagnitude());

        TextView placeView=(TextView)listItemView.findViewById(R.id.place);
        placeView.setText(currentEarthquake.getmPlace());

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
}