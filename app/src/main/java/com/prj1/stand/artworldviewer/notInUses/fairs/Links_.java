
package com.prj1.stand.artworldviewer.notInUses.fairs;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Links_ implements Parcelable
{

    @SerializedName("self")
    @Expose
    private Self_ self;
    @SerializedName("shows")
    @Expose
    private Shows shows;
    public final static Parcelable.Creator<Links_> CREATOR = new Creator<Links_>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Links_ createFromParcel(Parcel in) {
            Links_ instance = new Links_();
            instance.self = ((Self_) in.readValue((Self_.class.getClassLoader())));
            instance.shows = ((Shows) in.readValue((Shows.class.getClassLoader())));
            return instance;
        }

        public Links_[] newArray(int size) {
            return (new Links_[size]);
        }

    }
    ;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Links_() {
    }

    /**
     * 
     * @param self
     * @param shows
     */
    public Links_(Self_ self, Shows shows) {
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

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(self);
        dest.writeValue(shows);
    }

    public int describeContents() {
        return  0;
    }

}
