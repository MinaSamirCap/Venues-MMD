package com.example.andoird.venues_mmd.api.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by mina on 07/12/17.
 */

public class BaseModel implements Parcelable {

    @SerializedName("meta")
    @Expose
    private MetaModel meta;


    public BaseModel() {
    }

    public BaseModel(MetaModel meta) {
        super();
        this.meta = meta;
    }

    BaseModel(Parcel in) {
        this.meta = in.readParcelable(MetaModel.class.getClassLoader());
    }

    public final static Parcelable.Creator<BaseModel> CREATOR = new Creator<BaseModel>() {


        @Override
        public BaseModel createFromParcel(Parcel in) {
            return new BaseModel(in);
        }

        @Override
        public BaseModel[] newArray(int size) {
            return (new BaseModel[size]);
        }

    };




    public MetaModel getMeta() {
        return meta;
    }

    public void setMeta(MetaModel meta) {
        this.meta = meta;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(meta, flags);
    }

    public int describeContents() {
        return 0;
    }

}
