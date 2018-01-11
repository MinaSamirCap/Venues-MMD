package com.example.andoird.venues_mmd.api.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by mina on 07/12/17.
 */

public class BeenHereModel implements Parcelable {

    @SerializedName("count")
    @Expose
    private int count;
    @SerializedName("unconfirmedCount")
    @Expose
    private int unconfirmedCount;
    @SerializedName("marked")
    @Expose
    private boolean marked;
    @SerializedName("lastCheckinExpiredAt")
    @Expose
    private int lastCheckinExpiredAt;


    public BeenHereModel() {
    }

    public BeenHereModel(int lastCheckinExpiredAt) {
        this.lastCheckinExpiredAt = lastCheckinExpiredAt;
    }

    BeenHereModel(Parcel in) {
        this.count = in.readInt();
        this.unconfirmedCount = in.readInt();
        this.marked = in.readByte() != 0;
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getUnconfirmedCount() {
        return unconfirmedCount;
    }

    public void setUnconfirmedCount(int unconfirmedCount) {
        this.unconfirmedCount = unconfirmedCount;
    }

    public boolean isMarked() {
        return marked;
    }

    public void setMarked(boolean marked) {
        this.marked = marked;
    }

    public int describeContents() {
        return 0;
    }


    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(count);
        dest.writeInt(unconfirmedCount);
        dest.writeByte((byte) (marked ? 1 : 0));
        dest.writeInt(lastCheckinExpiredAt);
    }


}