package com.prj1.stand.artworldviewer.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SimilarArtists implements Parcelable {

    @SerializedName("href")
    @Expose
    private String href;

    /**
     * No args constructor for use in serialization
     *
     */
    public SimilarArtists() {
    }

    /**
     *
     * @param href
     */
    public SimilarArtists(String href) {
        super();
        this.href = href;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }


    protected SimilarArtists(Parcel in) {
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
    public static final Parcelable.Creator<SimilarArtists> CREATOR = new Parcelable.Creator<SimilarArtists>() {
        @Override
        public SimilarArtists createFromParcel(Parcel in) {
            return new SimilarArtists(in);
        }

        @Override
        public SimilarArtists[] newArray(int size) {
            return new SimilarArtists[size];
        }
    };
}