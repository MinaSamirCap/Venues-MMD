package com.example.andoird.venues_mmd.api.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mina on 07/12/17.
 */

public class ResponseModel implements Parcelable {

    @SerializedName("confident")
    @Expose
    private boolean confident;

    @SerializedName("venues")
    @Expose
    private List<VenueModel> venuesList;


    public ResponseModel() {
    }

    public ResponseModel(boolean confident) {
        this.confident = confident;
    }

    ResponseModel(Parcel in) {
        this.confident = in.readByte() != 0;
        this.venuesList = in.createTypedArrayList(VenueModel.CREATOR);

    }

    public static final Creator<ResponseModel> CREATOR = new Creator<ResponseModel>() {

        @Override
        public ResponseModel createFromParcel(Parcel in) {
            return new ResponseModel(in);
        }

        @Override
        public ResponseModel[] newArray(int size) {
            return new ResponseModel[size];
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
