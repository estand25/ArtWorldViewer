
package com.prj1.stand.artworldviewer.notInUses.genes;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Permalink implements Parcelable
{

    @SerializedName("href")
    @Expose
    private String href;
    public final static Parcelable.Creator<Permalink> CREATOR = new Creator<Permalink>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Permalink createFromParcel(Parcel in) {
            Permalink instance = new Permalink();
            instance.href = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Permalink[] newArray(int size) {
            return (new Permalink[size]);
        }

    }
    ;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Permalink() {
    }

    /**
     * 
     * @param href
     */
    public Permalink(String href) {
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
