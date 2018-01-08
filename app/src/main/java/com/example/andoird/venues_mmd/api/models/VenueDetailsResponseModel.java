package com.example.andoird.venues_mmd.api.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mina on 07/12/17.
 */

public class VenueDetailsResponseModel implements Parcelable {

    @SerializedName("venue")
    @Expose
    private VenueModel venue;


    VenueDetailsResponseModel(Parcel in) {
        this.venue = in.readParcelable(VenueModel.class.getClassLoader());

    }

    public static final Creator<VenueDetailsResponseModel> CREATOR = new Creator<VenueDetailsResponseModel>() {

        @Override
        public VenueDetailsResponseModel createFromParcel(Parcel in) {
            return new VenueDetailsResponseModel(in);
        }

        @Override
        public VenueDetailsResponseModel[] newArray(int size) {
            return new VenueDetailsResponseModel[size];
        }
    };


    public VenueModel getVenue() {
        return venue;
    }

    public void setVenue(VenueModel venue) {
        this.venue = venue;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(venue, flags);
    }
}
