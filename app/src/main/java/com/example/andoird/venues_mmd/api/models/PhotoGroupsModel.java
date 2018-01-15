package com.example.andoird.venues_mmd.api.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mina on 07/12/17.
 */

public class PhotoGroupsModel implements Parcelable {

    @SerializedName("count")
    @Expose
    private int count;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("items")
    @Expose
    private List<PhotoSingleModel> items;


    PhotoGroupsModel(Parcel in) {
        this.count = in.readInt();
        this.name = in.readString();
        this.type = in.readString();
        this.items = in.createTypedArrayList(PhotoSingleModel.CREATOR);
    }

    public final static Creator<PhotoGroupsModel> CREATOR = new Creator<PhotoGroupsModel>() {


        @Override
        public PhotoGroupsModel createFromParcel(Parcel in) {
            return new PhotoGroupsModel(in);
        }

        @Override
        public PhotoGroupsModel[] newArray(int size) {
            return (new PhotoGroupsModel[size]);
        }

    };

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

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

    public List<PhotoSingleModel> getItems() {
        return items;
    }

    public void setItems(List<PhotoSingleModel> items) {
        this.items = items;
    }

    public int describeContents() {
        return 0;
    }


    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(count);
        dest.writeString(type);
        dest.writeString(name);
        dest.writeTypedList(items);
    }


}