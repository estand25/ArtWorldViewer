
package com.prj1.stand.artworldviewer.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Website implements Parcelable
{

    @SerializedName("href")
    @Expose
    private String href;
    public final static Parcelable.Creator<Website> CREATOR = new Creator<Website>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Website createFromParcel(Parcel in) {
            Website instance = new Website();
            instance.href = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Website[] newArray(int size) {
            return (new Website[size]);
        }

    }
    ;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Website() {
    }

    /**
     * 
     * @param href
     */
    public Website(String href) {
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
