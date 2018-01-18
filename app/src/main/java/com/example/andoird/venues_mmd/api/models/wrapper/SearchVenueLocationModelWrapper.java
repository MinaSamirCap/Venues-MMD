package com.example.andoird.venues_mmd.api.models.wrapper;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.andoird.venues_mmd.api.models.MetaModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by mina on 07/12/17.
 */

public class SearchVenueLocationModelWrapper implements Parcelable {

    @SerializedName("meta")
    @Expose
    private MetaModel meta;

    @SerializedName("response")
    @Expose
    private SearchVenueLocationResponseModel response;


    public SearchVenueLocationModelWrapper() {
    }

    public SearchVenueLocationModelWrapper(MetaModel meta, SearchVenueLocationResponseModel response) {
        super();
        this.meta = meta;
        this.response = response;
    }

    SearchVenueLocationModelWrapper(Parcel in) {
        this.meta = in.readParcelable(MetaModel.class.getClassLoader());
        this.response = in.readParcelable(SearchVenueLocationResponseModel.class.getClassLoader());
    }

    public final static Creator<SearchVenueLocationModelWrapper> CREATOR = new Creator<SearchVenueLocationModelWrapper>() {


        @Override
        public SearchVenueLocationModelWrapper createFromParcel(Parcel in) {
            return new SearchVenueLocationModelWrapper(in);
        }

        @Override
        public SearchVenueLocationModelWrapper[] newArray(int size) {
            return (new SearchVenueLocationModelWrapper[size]);
        }

    };




    public MetaModel getMeta() {
        return meta;
    }

    public void setMeta(MetaModel meta) {
        this.meta = meta;
    }

    public SearchVenueLocationResponseModel getResponse() {
        return response;
    }

    public void setResponse(SearchVenueLocationResponseModel response) {
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
