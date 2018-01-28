package com.example.andoird.venues_mmd.viewmodels.binding;

import android.databinding.BindingAdapter;
import android.widget.TextView;
import com.example.andoird.venues_mmd.R;

/**
 * Created by mina on 21/01/18.
 */

public class DistanceBinding {

    @BindingAdapter("distance")
    public static void bindDistance(TextView textView, double distance) {
        String distanceWithUnit;
        if(distance<999){
            distanceWithUnit = distance + " " + textView.getContext().getString(R.string.meter);
        }else {
            distanceWithUnit = (distance/1000)+ " " + textView.getContext().getString(R.string.km);
        }
        textView.setText(distanceWithUnit);
    }

    /*@BindingAdapter("android:onClick")
    public static void venueClicked(View view, String venueId) {
        Intent intent = VenueDetailsActivity.openVenueDetailsActivity(view.getContext(), venueId);
        view.getContext().startActivity(intent);
    }*/

    // it was a try to know if could I add more than one data binding in the same class.
    /*@BindingAdapter("distance2")
    public static void bindDistance2(TextView textView, double distance) {
        String distanceWithUnit;
        if(distance<999){
            distanceWithUnit = distance + " " + textView.getContext().getString(R.string.meter);
        }else {
            distanceWithUnit = (distance/1000)+ " " + textView.getContext().getString(R.string.km);
        }
        textView.setText(distanceWithUnit);
    }*/
}
