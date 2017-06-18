
package com.prj1.stand.artworldviewer.notInUses.artists;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Thumbnail implements Parcelable
{

    @SerializedName("href")
    @Expose
    private String href;
    public final static Parcelable.Creator<Thumbnail> CREATOR = new Creator<Thumbnail>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Thumbnail createFromParcel(Parcel in) {
            Thumbnail instance = new Thumbnail();
            instance.href = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Thumbnail[] newArray(int size) {
            return (new Thumbnail[size]);
        }

    }
    ;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Thumbnail() {
    }

    /**
     * 
     * @param href
     */
    public Thumbnail(String href) {
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
