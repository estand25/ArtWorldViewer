package com.prj1.stand.artworldviewer.model;


import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PublishedArtworks implements Parcelable {

    @SerializedName("href")
    @Expose
    private String href;

    /**
     * No args constructor for use in serialization
     *
     */
    public PublishedArtworks() {
    }

    /**
     *
     * @param href
     */
    public PublishedArtworks(String href) {
        super();
        this.href = href;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public PublishedArtworks withHref(String href) {
        this.href = href;
        return this;
    }


    protected PublishedArtworks(Parcel in) {
        href = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(href);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<PublishedArtworks> CREATOR = new Parcelable.Creator<PublishedArtworks>() {
        @Override
        public PublishedArtworks createFromParcel(Parcel in) {
            return new PublishedArtworks(in);
        }

        @Override
        public PublishedArtworks[] newArray(int size) {
            return new PublishedArtworks[size];
        }
    };
}