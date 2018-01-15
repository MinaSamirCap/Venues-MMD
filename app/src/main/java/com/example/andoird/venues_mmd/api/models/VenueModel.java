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


    @SerializedName("canonicalUrl")
    @Expose
    private String canonicalUrl;
    /////////// categories object ..
    @SerializedName("verified")
    @Expose
    private boolean verified;


    @SerializedName("stats")
    @Expose
    private StatsModel stats;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("likes")
    @Expose
    private LikesModel likes;
    @SerializedName("dislike")
    @Expose
    private boolean dislike;
    @SerializedName("ok")
    @Expose
    private boolean ok;
    @SerializedName("rating")
    @Expose
    private int rating;
    @SerializedName("ratingColor")
    @Expose
    private String ratingColor;
    @SerializedName("ratingSignals")
    @Expose
    private int ratingSignals;
    @SerializedName("venueRatingBlacklisted")
    @Expose
    private boolean venueRatingBlacklisted;
    @SerializedName("allowMenuUrlEdit")
    @Expose
    private boolean allowMenuUrlEdit;
    @SerializedName("beenHere")
    @Expose
    private BeenHereModel beenHere;
    @SerializedName("hours")
    @Expose
    private HoursModel hours;
    /////////// special object ..

    @SerializedName("referralId")
    @Expose
    private String referralId;
    @SerializedName("hasPerk")
    @Expose
    private boolean hasPerk;
    @SerializedName("price")
    @Expose
    private PriceModel price;


    public VenueModel() {
    }

    public VenueModel(ContactModel contact) {
        this.contact = contact;
    }

    protected VenueModel(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.contact = in.readParcelable(ContactModel.class.getClassLoader());
        this.location = in.readParcelable(LocationModel.class.getClassLoader());
        this.canonicalUrl = in.readString();
        this.verified = in.readByte() != 0;
        this.stats = in.readParcelable(StatsModel.class.getClassLoader());
        this.url = in.readString();
        this.likes = in.readParcelable(LikesModel.class.getClassLoader());
        this.dislike = in.readByte() != 0;
        this.ok = in.readByte() != 0;
        this.rating = in.readInt();
        this.ratingColor = in.readString();
        this.ratingSignals = in.readInt();
        this.venueRatingBlacklisted = in.readByte() != 0;
        this.allowMenuUrlEdit = in.readByte() != 0;
        this.beenHere = in.readParcelable(BeenHereModel.class.getClassLoader());
        this.hours = in.readParcelable(HoursModel.class.getClassLoader());
        this.referralId = in.readString();
        this.hasPerk = in.readByte() != 0;
        this.price = in.readParcelable(PriceModel.class.getClassLoader());
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

    public String getCanonicalUrl() {
        return canonicalUrl;
    }

    public void setCanonicalUrl(String canonicalUrl) {
        this.canonicalUrl = canonicalUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LikesModel getLikes() {
        return likes;
    }

    public void setLikes(LikesModel likes) {
        this.likes = likes;
    }

    public boolean isDislike() {
        return dislike;
    }

    public void setDislike(boolean dislike) {
        this.dislike = dislike;
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getRatingColor() {
        return ratingColor;
    }

    public void setRatingColor(String ratingColor) {
        this.ratingColor = ratingColor;
    }

    public int getRatingSignals() {
        return ratingSignals;
    }

    public void setRatingSignals(int ratingSignals) {
        this.ratingSignals = ratingSignals;
    }

    public boolean isAllowMenuUrlEdit() {
        return allowMenuUrlEdit;
    }

    public void setAllowMenuUrlEdit(boolean allowMenuUrlEdit) {
        this.allowMenuUrlEdit = allowMenuUrlEdit;
    }

    public HoursModel getHours() {
        return hours;
    }

    public void setHours(HoursModel hours) {
        this.hours = hours;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeParcelable(contact, flags);
        dest.writeParcelable(location, flags);
        dest.writeString(canonicalUrl);
        dest.writeByte((byte) (verified ? 1 : 0));
        dest.writeParcelable(stats, flags);
        dest.writeString(url);
        dest.writeParcelable(likes, flags);
        dest.writeByte((byte) (dislike ? 1 : 0));
        dest.writeByte((byte) (ok ? 1 : 0));
        dest.writeInt(rating);
        dest.writeString(ratingColor);
        dest.writeInt(ratingSignals);
        dest.writeByte((byte) (venueRatingBlacklisted ? 1 : 0));
        dest.writeByte((byte) (allowMenuUrlEdit ? 1 : 0));
        dest.writeParcelable(beenHere, flags);
        dest.writeParcelable(hours, flags);
        dest.writeString(referralId);
        dest.writeByte((byte) (hasPerk ? 1 : 0));
        dest.writeParcelable(price, flags);
    }
}
