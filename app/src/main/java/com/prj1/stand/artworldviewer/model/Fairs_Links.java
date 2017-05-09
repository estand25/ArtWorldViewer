package com.prj1.stand.artworldviewer.model;

import android.os.Parcelable;
import android.os.Parcel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Fairs_Links implements Parcelable {

    @SerializedName("self")
    @Expose
    private Self_ self;
    @SerializedName("shows")
    @Expose
    private Shows shows;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Fairs_Links() {
    }

    /**
     * 
     * @param self
     * @param shows
     */
    public Fairs_Links(Self_ self, Shows shows) {
        super();
        this.self = self;
        this.shows = shows;
    }

    public Self_ getSelf() {
        return self;
    }

    public void setSelf(Self_ self) {
        this.self = self;
    }

    public Shows getShows() {
        return shows;
    }

    public void setShows(Shows shows) {
        this.shows = shows;
    }


    protected Fairs_Links(Parcel in) {
        self = (Self_) in.readValue(Self_.class.getClassLoader());
        shows = (Shows) in.readValue(Shows.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(self);
        dest.writeValue(shows);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Fairs_Links> CREATOR = new Parcelable.Creator<Fairs_Links>() {
        @Override
        public Fairs_Links createFromParcel(Parcel in) {
            return new Fairs_Links(in);
        }

        @Override
        public Fairs_Links[] newArray(int size) {
            return new Fairs_Links[size];
        }
    };
}