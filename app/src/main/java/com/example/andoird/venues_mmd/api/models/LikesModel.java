package com.example.andoird.venues_mmd.api.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by mina on 07/12/17.
 */

public class LikesModel implements Parcelable {

    @SerializedName("count")
    @Expose
    private int count;
    @SerializedName("summary")
    @Expose
    private String summary;

    LikesModel(Parcel in) {
        this.count = in.readInt();
        this.summary = in.readString();
    }

    public final static Creator<LikesModel> CREATOR = new Creator<LikesModel>() {


        @Override
        public LikesModel createFromParcel(Parcel in) {
            return new LikesModel(in);
        }

        @Override
        public LikesModel[] newArray(int size) {
            return (new LikesModel[size]);
        }

    };

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int describeContents() {
        return 0;
    }


    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(count);
        dest.writeString(summary);
    }


}