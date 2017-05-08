package com.prj1.stand.artworldviewer.model;


import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Self_ implements Parcelable {

    @SerializedName("href")
    @Expose
    private String href;

    /**
     * No args constructor for use in serialization
     *
     */
    public Self_() {
    }

    /**
     *
     * @param href
     */
    public Self_(String href) {
        super();
        this.href = href;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Self_ withHref(String href) {
        this.href = href;
        return this;
    }


    protected Self_(Parcel in) {
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
    public static final Parcelable.Creator<Self_> CREATOR = new Parcelable.Creator<Self_>() {
        @Override
        public Self_ createFromParcel(Parcel in) {
            return new Self_(in);
        }

        @Override
        public Self_[] newArray(int size) {
            return new Self_[size];
        }
    };
}