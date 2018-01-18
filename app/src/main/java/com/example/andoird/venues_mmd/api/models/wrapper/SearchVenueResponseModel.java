package com.example.andoird.venues_mmd.api.models.wrapper;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.andoird.venues_mmd.api.models.VenueModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mina on 07/12/17.
 */

public class SearchVenueResponseModel implements Parcelable {

    @SerializedName("confident")
    @Expose
    private boolean confident;

    @SerializedName("venues")
    @Expose
    private List<VenueModel> venuesList;


    public SearchVenueResponseModel() {
    }

    public SearchVenueResponseModel(boolean confident) {
        this.confident = confident;
    }

    SearchVenueResponseModel(Parcel in) {
        this.confident = in.readByte() != 0;
        this.venuesList = in.createTypedArrayList(VenueModel.CREATOR);

    }

    public static final Creator<SearchVenueResponseModel> CREATOR = new Creator<SearchVenueResponseModel>() {

        @Override
        public SearchVenueResponseModel createFromParcel(Parcel in) {
            return new SearchVenueResponseModel(in);
        }

        @Override
        public SearchVenueResponseModel[] newArray(int size) {
            return new SearchVenueResponseModel[size];
        }
    };

    public boolean isConfident() {
        return confident;
    }

    public void setConfident(boolean confident) {
        this.confident = confident;
    }

    public List<VenueModel> getVenuesList() {
        return venuesList;
    }

    public void setVenuesList(List<VenueModel> venuesList) {
        this.venuesList = venuesList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte((byte) (confident ? 1 : 0));
        dest.writeTypedList(venuesList);
    }
}
