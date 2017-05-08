package com.prj1.stand.artworldviewer.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Next implements Parcelable {

    @SerializedName("href")
    @Expose
    private String href;

    /**
     * No args constructor for use in serialization
     *
     */
    public Next() {
    }

    /**
     *
     * @param href
     */
    public Next(String href) {
        super();
        this.href = href;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Next withHref(String href) {
        this.href = href;
        return this;
    }


    protected Next(Parcel in) {
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
    public static final Parcelable.Creator<Next> CREATOR = new Parcelable.Creator<Next>() {
        @Override
        public Next createFromParcel(Parcel in) {
            return new Next(in);
        }

        @Override
        public Next[] newArray(int size) {
            return new Next[size];
        }
    };
}