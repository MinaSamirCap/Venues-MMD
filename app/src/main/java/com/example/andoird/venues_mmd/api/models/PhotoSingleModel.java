package com.example.andoird.venues_mmd.api.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by mina on 07/12/17.
 */

public class PhotoSingleModel implements Parcelable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("createdAt")
    @Expose
    private int createdAt;
    @SerializedName("prefix")
    @Expose
    private String prefix;
    @SerializedName("suffix")
    @Expose
    private String suffix;
    @SerializedName("width")
    @Expose
    private int width;
    @SerializedName("height")
    @Expose
    private int height;
    @SerializedName("visibility")
    @Expose
    private String visibility;


    PhotoSingleModel(Parcel in) {
        this.id = in.readString();
        this.createdAt = in.readInt();
        this.prefix = in.readString();
        this.suffix = in.readString();
        this.width = in.readInt();
        this.height = in.readInt();
        this.visibility = in.readString();
    }

    public final static Creator<PhotoSingleModel> CREATOR = new Creator<PhotoSingleModel>() {


        @Override
        public PhotoSingleModel createFromParcel(Parcel in) {
            return new PhotoSingleModel(in);
        }

        @Override
        public PhotoSingleModel[] newArray(int size) {
            return (new PhotoSingleModel[size]);
        }

    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(int createdAt) {
        this.createdAt = createdAt;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public int describeContents() {
        return 0;
    }


    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeInt(createdAt);
        dest.writeString(prefix);
        dest.writeString(suffix);
        dest.writeInt(width);
        dest.writeInt(height);
        dest.writeString(visibility);
    }


}