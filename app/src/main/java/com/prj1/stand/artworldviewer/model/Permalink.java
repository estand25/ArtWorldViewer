package com.prj1.stand.artworldviewer.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Permalink implements Parcelable {

    @SerializedName("href")
    @Expose
    private String href;

    /**
     * No args constructor for use in serialization
     *
     */
    public Permalink() {
    }

    /**
     *
     * @param href
     */
    public Permalink(String href) {
        super();
        this.href = href;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Permalink withHref(String href) {
        this.href = href;
        return this;
    }


    protected Permalink(Parcel in) {
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
    public static final Parcelable.Creator<Permalink> CREATOR = new Parcelable.Creator<Permalink>() {
        @Override
        public Permalink createFromParcel(Parcel in) {
            return new Permalink(in);
        }

        @Override
        public Permalink[] newArray(int size) {
            return new Permalink[size];
        }
    };
}