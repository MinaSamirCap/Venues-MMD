package com.example.andoird.venues_mmd.api.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by mina on 07/12/17.
 */

public class BeenHereModel implements Parcelable {

    @SerializedName("lastCheckinExpiredAt")
    @Expose
    private int lastCheckinExpiredAt;

    public BeenHereModel() {
    }

    public BeenHereModel(int lastCheckinExpiredAt) {
        this.lastCheckinExpiredAt = lastCheckinExpiredAt;
    }

    BeenHereModel(Parcel in) {
        this.lastCheckinExpiredAt = in.readInt();
    }

    public final static Creator<BeenHereModel> CREATOR = new Creator<BeenHereModel>() {


        @Override
        public BeenHereModel createFromParcel(Parcel in) {
            return new BeenHereModel(in);
        }

        @Override
        public BeenHereModel[] newArray(int size) {
            return (new BeenHereModel[size]);
        }

    };

    public int getLastCheckinExpiredAt() {
        return lastCheckinExpiredAt;
    }

    public void setLastCheckinExpiredAt(int lastCheckinExpiredAt) {
        this.lastCheckinExpiredAt = lastCheckinExpiredAt;
    }

    public int describeContents() {
        return 0;
    }


    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(lastCheckinExpiredAt);
    }



}