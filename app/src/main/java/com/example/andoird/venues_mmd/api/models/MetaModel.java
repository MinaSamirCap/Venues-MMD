package com.example.andoird.venues_mmd.api.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by mina on 07/12/17.
 */

public class MetaModel implements Parcelable {

    @SerializedName("code")
    @Expose
    private int code;
    @SerializedName("requestId")
    @Expose
    private String requestId;

    public MetaModel() {
    }

    public MetaModel(int code, String requestId) {
        this.code = code;
        this.requestId = requestId;
    }

    MetaModel(Parcel in) {
        this.code = in.readInt();
        this.requestId = in.readString();
    }

    public final static Parcelable.Creator<MetaModel> CREATOR = new Creator<MetaModel>() {


        @Override
        public MetaModel createFromParcel(Parcel in) {
            return new MetaModel(in);
        }

        @Override
        public MetaModel[] newArray(int size) {
            return (new MetaModel[size]);
        }

    };

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }


    public int describeContents() {
        return 0;
    }


    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(code);
        dest.writeString(requestId);
    }



}