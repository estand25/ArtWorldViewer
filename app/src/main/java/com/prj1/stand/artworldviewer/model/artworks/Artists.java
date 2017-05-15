
package com.prj1.stand.artworldviewer.model.artworks;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Artists implements Parcelable
{

    @SerializedName("href")
    @Expose
    private String href;
    public final static Parcelable.Creator<Artists> CREATOR = new Creator<Artists>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Artists createFromParcel(Parcel in) {
            Artists instance = new Artists();
            instance.href = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Artists[] newArray(int size) {
            return (new Artists[size]);
        }

    }
    ;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Artists() {
    }

    /**
     * 
     * @param href
     */
    public Artists(String href) {
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
