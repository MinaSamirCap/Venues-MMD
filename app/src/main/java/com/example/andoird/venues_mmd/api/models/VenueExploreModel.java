package com.example.andoird.venues_mmd.api.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by mina on 07/12/17.
 */

public class VenueExploreModel implements Parcelable {

    // reasons object
    @SerializedName("venue")
    @Expose
    private VenueModel venue;
    // tips object
    @SerializedName("referralId")
    @Expose
    private String referralId;

    VenueExploreModel(Parcel in) {
        this.referralId = in.readString();
        this.venue = in.readParcelable(VenueModel.class.getClassLoader());
    }

    public final static Creator<VenueExploreModel> CREATOR = new Creator<VenueExploreModel>() {


        @Override
        public VenueExploreModel createFromParcel(Parcel in) {
            return new VenueExploreModel(in);
        }

        @Override
        public VenueExploreModel[] newArray(int size) {
            return (new VenueExploreModel[size]);
        }

    };

    public String getReferralId() {
        return referralId;
    }

    public void setReferralId(String referralId) {
        this.referralId = referralId;
    }

    public VenueModel getVenue() {
        return venue;
    }

    public void setVenue(VenueModel venue) {
        this.venue = venue;
    }

    public int describeContents() {
        return 0;
    }


    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(referralId);
        dest.writeParcelable(venue, flags);
    }


}