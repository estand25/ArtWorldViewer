package com.prj1.stand.artworldviewer.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SimilarArtworks implements Parcelable {

    @SerializedName("href")
    @Expose
    private String href;

    /**
     * No args constructor for use in serialization
     *
     */
    public SimilarArtworks() {
    }

    /**
     *
     * @param href
     */
    public SimilarArtworks(String href) {
        super();
        this.href = href;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public SimilarArtworks withHref(String href) {
        this.href = href;
        return this;
    }


    protected SimilarArtworks(Parcel in) {
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
    public static final Parcelable.Creator<SimilarArtworks> CREATOR = new Parcelable.Creator<SimilarArtworks>() {
        @Override
        public SimilarArtworks createFromParcel(Parcel in) {
            return new SimilarArtworks(in);
        }

        @Override
        public SimilarArtworks[] newArray(int size) {
            return new SimilarArtworks[size];
        }
    };
}