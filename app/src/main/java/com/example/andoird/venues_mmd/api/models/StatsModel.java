package com.example.andoird.venues_mmd.api.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by mina on 26/12/17.
 */
public class StatsModel implements Parcelable {

    @SerializedName("checkinsCount")
    @Expose
    private int checkinsCount;
    @SerializedName("usersCount")
    @Expose
    private int usersCount;
    @SerializedName("tipCount")
    @Expose
    private int tipCount;
    @SerializedName("visitsCount")
    @Expose
    private int visitsCount;

    public StatsModel() {
    }

    StatsModel(Parcel in) {
        this.checkinsCount = in.readInt();
        this.usersCount = in.readInt();
        this.tipCount = in.readInt();
        this.visitsCount = in.readInt();
    }

    public final static Parcelable.Creator<StatsModel> CREATOR = new Creator<StatsModel>() {

        @Override
        public StatsModel createFromParcel(Parcel in) {
            return new StatsModel(in);
        }

        @Override
        public StatsModel[] newArray(int size) {
            return (new StatsModel[size]);
        }

    };


    public int getCheckinsCount() {
        return checkinsCount;
    }

    public void setCheckinsCount(int checkinsCount) {
        this.checkinsCount = checkinsCount;
    }

    public int getUsersCount() {
        return usersCount;
    }

    public void setUsersCount(int usersCount) {
        this.usersCount = usersCount;
    }

    public int getTipCount() {
        return tipCount;
    }

    public void setTipCount(int tipCount) {
        this.tipCount = tipCount;
    }

    public int getVisitsCount() {
        return visitsCount;
    }

    public void setVisitsCount(int visitsCount) {
        this.visitsCount = visitsCount;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(checkinsCount);
        dest.writeInt(usersCount);
        dest.writeInt(tipCount);
        dest.writeInt(visitsCount);
    }

    public int describeContents() {
        return 0;
    }

}