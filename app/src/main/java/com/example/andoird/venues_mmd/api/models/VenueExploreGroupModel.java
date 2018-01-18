package com.example.andoird.venues_mmd.api.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mina on 07/12/17.
 */

public class VenueExploreGroupModel implements Parcelable {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("items")
    @Expose
    private List<VenueExploreModel> items;


    VenueExploreGroupModel(Parcel in) {
        this.name = in.readString();
        this.type = in.readString();
        this.items = in.createTypedArrayList(VenueExploreModel.CREATOR);
    }

    public final static Creator<VenueExploreGroupModel> CREATOR = new Creator<VenueExploreGroupModel>() {


        @Override
        public VenueExploreGroupModel createFromParcel(Parcel in) {
            return new VenueExploreGroupModel(in);
        }

        @Override
        public VenueExploreGroupModel[] newArray(int size) {
            return (new VenueExploreGroupModel[size]);
        }

    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<VenueExploreModel> getItems() {
        return items;
    }

    public void setItems(List<VenueExploreModel> items) {
        this.items = items;
    }

    public int describeContents() {
        return 0;
    }


    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(type);
        dest.writeString(name);
        dest.writeTypedList(items);
    }


}