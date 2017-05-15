
package com.prj1.stand.artworldviewer.model.shows;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Artworks implements Parcelable
{

    @SerializedName("href")
    @Expose
    private String href;
    public final static Parcelable.Creator<Artworks> CREATOR = new Creator<Artworks>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Artworks createFromParcel(Parcel in) {
            Artworks instance = new Artworks();
            instance.href = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Artworks[] newArray(int size) {
            return (new Artworks[size]);
        }

    }
    ;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Artworks() {
    }

    /**
     * 
     * @param href
     */
    public Artworks(String href) {
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
