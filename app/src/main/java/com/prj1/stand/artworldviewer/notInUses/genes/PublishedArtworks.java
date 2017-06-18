
package com.prj1.stand.artworldviewer.notInUses.genes;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PublishedArtworks implements Parcelable
{

    @SerializedName("href")
    @Expose
    private String href;
    public final static Parcelable.Creator<PublishedArtworks> CREATOR = new Creator<PublishedArtworks>() {


        @SuppressWarnings({
            "unchecked"
        })
        public PublishedArtworks createFromParcel(Parcel in) {
            PublishedArtworks instance = new PublishedArtworks();
            instance.href = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public PublishedArtworks[] newArray(int size) {
            return (new PublishedArtworks[size]);
        }

    }
    ;

    /**
     * No args constructor for use in serialization
     * 
     */
    public PublishedArtworks() {
    }

    /**
     * 
     * @param href
     */
    public PublishedArtworks(String href) {
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
