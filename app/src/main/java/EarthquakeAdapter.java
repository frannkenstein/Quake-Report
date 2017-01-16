import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.martian.quakereport.Earthquake;
import com.example.martian.quakereport.R;

import java.util.ArrayList;

/**
 * Created by martian on 16/1/17.
 */

public class EarthquakeAdapter extends ArrayAdapter {
    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> earthquakes){
        super(context,0,earthquakes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.layout_earthquake, parent, false);
        }

            Earthquake currentEarthquake = (Earthquake) getItem(position);

            TextView magView=(TextView)listItemView.findViewById(R.id.magnitude);
            magView.setText(currentEarthquake.getmMagnitude());

            TextView placeView=(TextView)listItemView.findViewById(R.id.place);
            placeView.setText(currentEarthquake.getmPlace());

            TextView dateView=(TextView)listItemView.findViewById(R.id.date);
            dateView.setText(currentEarthquake.getmDate());
            return listItemView;
        }

}
