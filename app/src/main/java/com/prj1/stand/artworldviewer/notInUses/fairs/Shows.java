
package com.prj1.stand.artworldviewer.notInUses.fairs;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Shows implements Parcelable
{

    @SerializedName("href")
    @Expose
    private String href;
    public final static Parcelable.Creator<Shows> CREATOR = new Creator<Shows>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Shows createFromParcel(Parcel in) {
            Shows instance = new Shows();
            instance.href = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Shows[] newArray(int size) {
            return (new Shows[size]);
        }

    }
    ;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Shows() {
    }

    /**
     * 
     * @param href
     */
    public Shows(String href) {
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
