package com.example.andoird.venues_mmd.api.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by mina on 07/12/17.
 */

public class HoursModel implements Parcelable {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("isOpen")
    @Expose
    private boolean isOpen;
    @SerializedName("isLocalHoliday")
    @Expose
    private boolean isLocalHoliday;


    HoursModel(Parcel in) {
        this.status = in.readString();
        this.isOpen = in.readByte() != 0;
        this.isLocalHoliday = in.readByte() != 0;
    }

    public final static Creator<HoursModel> CREATOR = new Creator<HoursModel>() {


        @Override
        public HoursModel createFromParcel(Parcel in) {
            return new HoursModel(in);
        }

        @Override
        public HoursModel[] newArray(int size) {
            return (new HoursModel[size]);
        }

    };

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public boolean isLocalHoliday() {
        return isLocalHoliday;
    }

    public void setLocalHoliday(boolean localHoliday) {
        isLocalHoliday = localHoliday;
    }

    public int describeContents() {
        return 0;
    }


    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(status);
        dest.writeByte((byte) (isOpen ? 1 : 0));
        dest.writeByte((byte) (isLocalHoliday ? 1 : 0));
    }


}