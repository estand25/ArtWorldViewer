
package com.prj1.stand.artworldviewer.model.artists;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SimilarContemporaryArtists implements Parcelable
{

    @SerializedName("href")
    @Expose
    private String href;
    public final static Parcelable.Creator<SimilarContemporaryArtists> CREATOR = new Creator<SimilarContemporaryArtists>() {


        @SuppressWarnings({
            "unchecked"
        })
        public SimilarContemporaryArtists createFromParcel(Parcel in) {
            SimilarContemporaryArtists instance = new SimilarContemporaryArtists();
            instance.href = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public SimilarContemporaryArtists[] newArray(int size) {
            return (new SimilarContemporaryArtists[size]);
        }

    }
    ;

    /**
     * No args constructor for use in serialization
     * 
     */
    public SimilarContemporaryArtists() {
    }

    /**
     * 
     * @param href
     */
    public SimilarContemporaryArtists(String href) {
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
