
package com.prj1.stand.artworldviewer.notInUses.artists;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SimilarArtists implements Parcelable
{

    @SerializedName("href")
    @Expose
    private String href;
    public final static Parcelable.Creator<SimilarArtists> CREATOR = new Creator<SimilarArtists>() {


        @SuppressWarnings({
            "unchecked"
        })
        public SimilarArtists createFromParcel(Parcel in) {
            SimilarArtists instance = new SimilarArtists();
            instance.href = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public SimilarArtists[] newArray(int size) {
            return (new SimilarArtists[size]);
        }

    }
    ;

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

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(href);
    }

    public int describeContents() {
        return  0;
    }

}
