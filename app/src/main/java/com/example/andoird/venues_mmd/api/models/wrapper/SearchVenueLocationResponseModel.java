package com.example.andoird.venues_mmd.api.models.wrapper;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.andoird.venues_mmd.api.models.VenueExploreGroupModel;
import com.example.andoird.venues_mmd.api.models.VenueModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mina on 07/12/17.
 */

public class SearchVenueLocationResponseModel implements Parcelable {

    // suggested filters .. object ..
    // suggested suggestedRadius ..
    // suggested headerLocation ..
    // suggested headerFullLocation ..
    // suggested headerLocationGranularity ..
    // suggested totalResults ..
    // suggested suggestedBounds .. object ..

    @SerializedName("groups")
    @Expose
    private List<VenueExploreGroupModel> groups;


    public SearchVenueLocationResponseModel() {
    }

    SearchVenueLocationResponseModel(Parcel in) {
        this.groups = in.createTypedArrayList(VenueExploreGroupModel.CREATOR);

    }

    public static final Creator<SearchVenueLocationResponseModel> CREATOR = new Creator<SearchVenueLocationResponseModel>() {

        @Override
        public SearchVenueLocationResponseModel createFromParcel(Parcel in) {
            return new SearchVenueLocationResponseModel(in);
        }

        @Override
        public SearchVenueLocationResponseModel[] newArray(int size) {
            return new SearchVenueLocationResponseModel[size];
        }
    };


    public List<VenueExploreGroupModel> getGroups() {
        return groups;
    }

    public void setGroups(List<VenueExploreGroupModel> groups) {
        this.groups = groups;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(groups);
    }
}
