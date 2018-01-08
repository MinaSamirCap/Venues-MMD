package com.example.andoird.venues_mmd.api.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by mina on 26/12/17.
 */
public class LocationModel implements Parcelable {

    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("crossStreet")
    @Expose
    private String crossStreet;
    @SerializedName("lat")
    @Expose
    private double lat;
    @SerializedName("lng")
    @Expose
    private double lng;
    @SerializedName("distance")
    @Expose
    private double distance;
    @SerializedName("cc")
    @Expose
    private String cc;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("country")
    @Expose
    private String country;


    @SerializedName("formattedAddress")
    @Expose
    private ArrayList<String> formattedAddress;
    @SerializedName("labeledLatLngs")
    @Expose
    private ArrayList<LabelLatLngModel> labeledLatLngs;


    public LocationModel() {
    }

    LocationModel(Parcel in) {
        this.address = in.readString();
        this.crossStreet = in.readString();
        this.lat = in.readDouble();
        this.lng = in.readDouble();
        this.cc = in.readString();
        this.city = in.readString();
        this.state = in.readString();
        this.country = in.readString();
        this.formattedAddress = in.createStringArrayList();
        this.labeledLatLngs = in.createTypedArrayList(LabelLatLngModel.CREATOR);
    }

    public final static Parcelable.Creator<LocationModel> CREATOR = new Creator<LocationModel>() {

        @Override
        public LocationModel createFromParcel(Parcel in) {
            return new LocationModel(in);
        }

        @Override
        public LocationModel[] newArray(int size) {
            return (new LocationModel[size]);
        }

    };


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCrossStreet() {
        return crossStreet;
    }

    public void setCrossStreet(String crossStreet) {
        this.crossStreet = crossStreet;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getDistance() {
        return distance;
    }

    public boolean getBooleanDistance(){
        if(distance == 0){
            return false;
        }else {
            return true;
        }
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public ArrayList<String> getFormattedAddress() {
        return formattedAddress;
    }

    public void setFormattedAddress(ArrayList<String> formattedAddress) {
        this.formattedAddress = formattedAddress;
    }

    public ArrayList<LabelLatLngModel> getLabeledLatLngs() {
        return labeledLatLngs;
    }

    public void setLabeledLatLngs(ArrayList<LabelLatLngModel> labeledLatLngs) {
        this.labeledLatLngs = labeledLatLngs;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(address);
        dest.writeString(crossStreet);
        dest.writeDouble(lat);
        dest.writeDouble(lng);
        dest.writeString(cc);
        dest.writeString(city);
        dest.writeString(state);
        dest.writeString(country);
        dest.writeStringList(formattedAddress);
        dest.writeTypedList(labeledLatLngs);
    }

    public int describeContents() {
        return 0;
    }

}
