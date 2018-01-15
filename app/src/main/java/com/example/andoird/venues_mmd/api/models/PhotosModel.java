package com.example.andoird.venues_mmd.api.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by mina on 07/12/17.
 */

public class PhotosModel implements Parcelable {

    @SerializedName("count")
    @Expose
    private int count;

    @SerializedName("groups")
    @Expose
    private List<PhotoGroupsModel> groups;


    PhotosModel(Parcel in) {
        this.count = in.readInt();
        this.groups = in.createTypedArrayList(PhotoGroupsModel.CREATOR);
    }

    public final static Creator<PhotosModel> CREATOR = new Creator<PhotosModel>() {


        @Override
        public PhotosModel createFromParcel(Parcel in) {
            return new PhotosModel(in);
        }

        @Override
        public PhotosModel[] newArray(int size) {
            return (new PhotosModel[size]);
        }

    };

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<PhotoGroupsModel> getGroups() {
        return groups;
    }

    public void setGroups(List<PhotoGroupsModel> groups) {
        this.groups = groups;
    }

    public int describeContents() {
        return 0;
    }


    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(count);
        dest.writeTypedList(groups);
    }


}