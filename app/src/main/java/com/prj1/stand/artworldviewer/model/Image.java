package com.prj1.stand.artworldviewer.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Image implements Parcelable {

    @SerializedName("href")
    @Expose
    private String href;
    @SerializedName("templated")
    @Expose
    private Boolean templated;

    /**
     * No args constructor for use in serialization
     *
     */
    public Image() {
    }

    /**
     *
     * @param templated
     * @param href
     */
    public Image(String href, Boolean templated) {
        super();
        this.href = href;
        this.templated = templated;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Image withHref(String href) {
        this.href = href;
        return this;
    }

    public Boolean getTemplated() {
        return templated;
    }

    public void setTemplated(Boolean templated) {
        this.templated = templated;
    }

    public Image withTemplated(Boolean templated) {
        this.templated = templated;
        return this;
    }


    protected Image(Parcel in) {
        href = in.readString();
        byte templatedVal = in.readByte();
        templated = templatedVal == 0x02 ? null : templatedVal != 0x00;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(href);
        if (templated == null) {
            dest.writeByte((byte) (0x02));
        } else {
            dest.writeByte((byte) (templated ? 0x01 : 0x00));
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Image> CREATOR = new Parcelable.Creator<Image>() {
        @Override
        public Image createFromParcel(Parcel in) {
            return new Image(in);
        }

        @Override
        public Image[] newArray(int size) {
            return new Image[size];
        }
    };
}