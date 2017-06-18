
package com.prj1.stand.artworldviewer.notInUses.shows;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Partner implements Parcelable
{

    @SerializedName("href")
    @Expose
    private String href;
    public final static Parcelable.Creator<Partner> CREATOR = new Creator<Partner>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Partner createFromParcel(Parcel in) {
            Partner instance = new Partner();
            instance.href = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Partner[] newArray(int size) {
            return (new Partner[size]);
        }

    }
    ;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Partner() {
    }

    /**
     * 
     * @param href
     */
    public Partner(String href) {
        super();
        this.href = href;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(href);
    }

    public int describeContents() {
        return  0;
    }

}
