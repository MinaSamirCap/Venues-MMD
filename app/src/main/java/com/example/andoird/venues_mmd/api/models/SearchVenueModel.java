package com.example.andoird.venues_mmd.api.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by mina on 07/12/17.
 */

public class SearchVenueModel implements Parcelable {

    @SerializedName("meta")
    @Expose
    private MetaModel meta;

    @SerializedName("response")
    @Expose
    private ResponseModel response;


    public SearchVenueModel() {
    }

    public SearchVenueModel(MetaModel meta, ResponseModel response) {
        super();
        this.meta = meta;
        this.response = response;
    }

    SearchVenueModel(Parcel in) {
        this.meta = in.readParcelable(MetaModel.class.getClassLoader());
        this.response = in.readParcelable(ResponseModel.class.getClassLoader());
    }

    public final static Parcelable.Creator<SearchVenueModel> CREATOR = new Creator<SearchVenueModel>() {


        @Override
        public SearchVenueModel createFromParcel(Parcel in) {
            return new SearchVenueModel(in);
        }

        @Override
        public SearchVenueModel[] newArray(int size) {
            return (new SearchVenueModel[size]);
        }

    };




    public MetaModel getMeta() {
        return meta;
    }

    public void setMeta(MetaModel meta) {
        this.meta = meta;
    }

    public ResponseModel getResponse() {
        return response;
    }

    public void setResponse(ResponseModel response) {
        this.response = response;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(meta, flags);
        dest.writeParcelable(response, flags);
    }

    public int describeContents() {
        return 0;
    }

}
