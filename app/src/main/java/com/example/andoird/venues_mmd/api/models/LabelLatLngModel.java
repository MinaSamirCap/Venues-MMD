package com.example.andoird.venues_mmd.api.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by mina on 26/12/17.
 */

public class LabelLatLngModel implements Parcelable {

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("lat")
    @Expose
    private double lat;
    @SerializedName("lng")
    @Expose
    private double lng;

    public LabelLatLngModel() {
    }

    LabelLatLngModel(Parcel in) {
        this.label = in.readString();
        this.lat = in.readDouble();
        this.lng = in.readDouble();
    }

    public final static Parcelable.Creator<LabelLatLngModel> CREATOR = new Creator<LabelLatLngModel>() {

        @Override
        public LabelLatLngModel createFromParcel(Parcel in) {
            return new LabelLatLngModel(in);
        }

        @Override
        public LabelLatLngModel[] newArray(int size) {
            return (new LabelLatLngModel[size]);
        }

    };


    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(label);
        dest.writeDouble(lat);
        dest.writeDouble(lng);
    }

    public int describeContents() {
        return 0;
    }

}
