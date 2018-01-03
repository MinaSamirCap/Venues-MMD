package com.example.andoird.venues_mmd.api.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by mina on 07/12/17.
 */

public class VenueModel implements Parcelable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("contact")
    @Expose
    private ContactModel contact;
    @SerializedName("location")
    @Expose
    private LocationModel location;

    @SerializedName("verified")
    @Expose
    private boolean verified;

    @SerializedName("stats")
    @Expose
    private StatsModel stats;

    @SerializedName("beenHere")
    @Expose
    private BeenHereModel beenHere;

    @SerializedName("venueRatingBlacklisted")
    @Expose
    private boolean venueRatingBlacklisted;

    @SerializedName("referralId")
    @Expose
    private String referralId;

    @SerializedName("hasPerk")
    @Expose
    private boolean hasPerk;


    public VenueModel() {
    }

    public VenueModel(ContactModel contact) {
        this.contact = contact;
    }

    protected VenueModel(Parcel in) {
        this.contact = in.readParcelable(ContactModel.class.getClassLoader());
        this.location = in.readParcelable(LocationModel.class.getClassLoader());
        this.verified = in.readByte() != 0;
        this.stats = in.readParcelable(StatsModel.class.getClassLoader());
        this.beenHere = in.readParcelable(BeenHereModel.class.getClassLoader());
        this.venueRatingBlacklisted = in.readByte() != 0;
        this.referralId = in.readString();
        this.hasPerk = in.readByte() != 0;
    }

    public static final Creator<VenueModel> CREATOR = new Creator<VenueModel>() {
        @Override
        public VenueModel createFromParcel(Parcel in) {
            return new VenueModel(in);
        }

        @Override
        public VenueModel[] newArray(int size) {
            return new VenueModel[size];
        }
    };

    public ContactModel getContact() {
        return contact;
    }

    public void setContact(ContactModel contact) {
        this.contact = contact;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocationModel getLocation() {
        return location;
    }

    public void setLocation(LocationModel location) {
        this.location = location;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public StatsModel getStats() {
        return stats;
    }

    public void setStats(StatsModel stats) {
        this.stats = stats;
    }

    public BeenHereModel getBeenHere() {
        return beenHere;
    }

    public void setBeenHere(BeenHereModel beenHere) {
        this.beenHere = beenHere;
    }

    public boolean isVenueRatingBlacklisted() {
        return venueRatingBlacklisted;
    }

    public void setVenueRatingBlacklisted(boolean venueRatingBlacklisted) {
        this.venueRatingBlacklisted = venueRatingBlacklisted;
    }

    public String getReferralId() {
        return referralId;
    }

    public void setReferralId(String referralId) {
        this.referralId = referralId;
    }

    public boolean isHasPerk() {
        return hasPerk;
    }

    public void setHasPerk(boolean hasPerk) {
        this.hasPerk = hasPerk;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(contact, flags);
        dest.writeParcelable(location, flags);
        dest.writeByte((byte) (verified ? 1 : 0));
        dest.writeParcelable(stats, flags);
        dest.writeParcelable(beenHere, flags);
        dest.writeByte((byte) (venueRatingBlacklisted ? 1 : 0));
        dest.writeString(referralId);
        dest.writeByte((byte) (hasPerk ? 1 : 0));
    }
}
