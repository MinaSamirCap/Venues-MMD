package com.example.andoird.venues_mmd.api.models.wrapper;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.andoird.venues_mmd.api.models.MetaModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by mina on 07/12/17.
 */

public class VenueDetailsModelWrapper implements Parcelable {

    @SerializedName("meta")
    @Expose
    private MetaModel meta;

    @SerializedName("response")
    @Expose
    private VenueDetailsResponseModel response;


    public VenueDetailsModelWrapper() {
    }

    public VenueDetailsModelWrapper(MetaModel meta, VenueDetailsResponseModel response) {
        super();
        this.meta = meta;
        this.response = response;
    }

    VenueDetailsModelWrapper(Parcel in) {
        this.meta = in.readParcelable(MetaModel.class.getClassLoader());
        this.response = in.readParcelable(SearchVenueResponseModel.class.getClassLoader());
    }

    public final static Creator<VenueDetailsModelWrapper> CREATOR = new Creator<VenueDetailsModelWrapper>() {


        @Override
        public VenueDetailsModelWrapper createFromParcel(Parcel in) {
            return new VenueDetailsModelWrapper(in);
        }

        @Override
        public VenueDetailsModelWrapper[] newArray(int size) {
            return (new VenueDetailsModelWrapper[size]);
        }

    };


    public MetaModel getMeta() {
        return meta;
    }

    public void setMeta(MetaModel meta) {
        this.meta = meta;
    }

    public VenueDetailsResponseModel getResponse() {
        return response;
    }

    public void setResponse(VenueDetailsResponseModel response) {
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
