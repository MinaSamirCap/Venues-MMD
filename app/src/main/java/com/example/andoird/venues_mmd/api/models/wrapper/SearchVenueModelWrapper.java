package com.example.andoird.venues_mmd.api.models.wrapper;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.andoird.venues_mmd.api.models.MetaModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by mina on 07/12/17.
 */

public class SearchVenueModelWrapper implements Parcelable {

    @SerializedName("meta")
    @Expose
    private MetaModel meta;

    @SerializedName("response")
    @Expose
    private SearchVenueResponseModel response;


    public SearchVenueModelWrapper() {
    }

    public SearchVenueModelWrapper(MetaModel meta, SearchVenueResponseModel response) {
        super();
        this.meta = meta;
        this.response = response;
    }

    SearchVenueModelWrapper(Parcel in) {
        this.meta = in.readParcelable(MetaModel.class.getClassLoader());
        this.response = in.readParcelable(SearchVenueResponseModel.class.getClassLoader());
    }

    public final static Parcelable.Creator<SearchVenueModelWrapper> CREATOR = new Creator<SearchVenueModelWrapper>() {


        @Override
        public SearchVenueModelWrapper createFromParcel(Parcel in) {
            return new SearchVenueModelWrapper(in);
        }

        @Override
        public SearchVenueModelWrapper[] newArray(int size) {
            return (new SearchVenueModelWrapper[size]);
        }

    };




    public MetaModel getMeta() {
        return meta;
    }

    public void setMeta(MetaModel meta) {
        this.meta = meta;
    }

    public SearchVenueResponseModel getResponse() {
        return response;
    }

    public void setResponse(SearchVenueResponseModel response) {
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
