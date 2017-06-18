
package com.prj1.stand.artworldviewer.notInUses.fairs;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Self implements Parcelable
{

    @SerializedName("href")
    @Expose
    private String href;
    public final static Parcelable.Creator<Self> CREATOR = new Creator<Self>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Self createFromParcel(Parcel in) {
            Self instance = new Self();
            instance.href = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Self[] newArray(int size) {
            return (new Self[size]);
        }

    }
    ;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Self() {
    }

    /**
     * 
     * @param href
     */
    public Self(String href) {
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
