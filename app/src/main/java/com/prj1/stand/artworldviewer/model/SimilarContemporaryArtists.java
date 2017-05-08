package com.prj1.stand.artworldviewer.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SimilarContemporaryArtists implements Parcelable {

    @SerializedName("href")
    @Expose
    private String href;

    /**
     * No args constructor for use in serialization
     *
     */
    public SimilarContemporaryArtists() {
    }

    /**
     *
     * @param href
     */
    public SimilarContemporaryArtists(String href) {
        super();
        this.href = href;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }


    protected SimilarContemporaryArtists(Parcel in) {
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
    public static final Parcelable.Creator<SimilarContemporaryArtists> CREATOR = new Parcelable.Creator<SimilarContemporaryArtists>() {
        @Override
        public SimilarContemporaryArtists createFromParcel(Parcel in) {
            return new SimilarContemporaryArtists(in);
        }

        @Override
        public SimilarContemporaryArtists[] newArray(int size) {
            return new SimilarContemporaryArtists[size];
        }
    };
}