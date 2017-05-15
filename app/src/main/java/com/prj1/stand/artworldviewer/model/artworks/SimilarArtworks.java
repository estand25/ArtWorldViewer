
package com.prj1.stand.artworldviewer.model.artworks;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SimilarArtworks implements Parcelable
{

    @SerializedName("href")
    @Expose
    private String href;
    public final static Parcelable.Creator<SimilarArtworks> CREATOR = new Creator<SimilarArtworks>() {


        @SuppressWarnings({
            "unchecked"
        })
        public SimilarArtworks createFromParcel(Parcel in) {
            SimilarArtworks instance = new SimilarArtworks();
            instance.href = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public SimilarArtworks[] newArray(int size) {
            return (new SimilarArtworks[size]);
        }

    }
    ;

    /**
     * No args constructor for use in serialization
     * 
     */
    public SimilarArtworks() {
    }

    /**
     * 
     * @param href
     */
    public SimilarArtworks(String href) {
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
