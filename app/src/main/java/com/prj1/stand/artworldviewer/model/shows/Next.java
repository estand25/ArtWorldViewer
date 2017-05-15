
package com.prj1.stand.artworldviewer.model.shows;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Next implements Parcelable
{

    @SerializedName("href")
    @Expose
    private String href;
    public final static Parcelable.Creator<Next> CREATOR = new Creator<Next>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Next createFromParcel(Parcel in) {
            Next instance = new Next();
            instance.href = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Next[] newArray(int size) {
            return (new Next[size]);
        }

    }
    ;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Next() {
    }

    /**
     * 
     * @param href
     */
    public Next(String href) {
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
