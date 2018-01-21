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
}
