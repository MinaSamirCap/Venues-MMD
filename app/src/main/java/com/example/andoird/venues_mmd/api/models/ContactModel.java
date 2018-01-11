package com.example.andoird.venues_mmd.api.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by mina on 07/12/17.
 */

public class ContactModel implements Parcelable {

    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("formattedPhone")
    @Expose
    private String formattedPhone;
    @SerializedName("facebook")
    @Expose
    private String facebook;
    @SerializedName("facebookUsername")
    @Expose
    private String facebookUsername;
    @SerializedName("facebookName")
    @Expose
    private String facebookName;

    @SerializedName("twitter")
    @Expose
    private String twitter;


    ContactModel(Parcel in) {
        this.phone = in.readString();
        this.formattedPhone = in.readString();
        this.facebook = in.readString();
        this.facebookUsername = in.readString();
        this.facebookName = in.readString();
        this.twitter = in.readString();
    }


    public final static Parcelable.Creator<ContactModel> CREATOR = new Creator<ContactModel>() {


        @Override
        public ContactModel createFromParcel(Parcel in) {
            return new ContactModel(in);
        }

        @Override
        public ContactModel[] newArray(int size) {
            return (new ContactModel[size]);
        }

    };

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFormattedPhone() {
        return formattedPhone;
    }

    public void setFormattedPhone(String formattedPhone) {
        this.formattedPhone = formattedPhone;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getFacebookUsername() {
        return facebookUsername;
    }

    public void setFacebookUsername(String facebookUsername) {
        this.facebookUsername = facebookUsername;
    }

    public String getFacebookName() {
        return facebookName;
    }

    public void setFacebookName(String facebookName) {
        this.facebookName = facebookName;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(phone);
        dest.writeString(formattedPhone);
        dest.writeString(facebook);
        dest.writeString(facebookUsername);
        dest.writeString(facebookName);
        dest.writeString(twitter);
    }

    public int describeContents() {
        return 0;
    }

}