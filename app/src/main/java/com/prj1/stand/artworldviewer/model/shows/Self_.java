
package com.prj1.stand.artworldviewer.model.shows;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Self_ implements Parcelable
{

    @SerializedName("href")
    @Expose
    private String href;
    public final static Parcelable.Creator<Self_> CREATOR = new Creator<Self_>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Self_ createFromParcel(Parcel in) {
            Self_ instance = new Self_();
            instance.href = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Self_[] newArray(int size) {
            return (new Self_[size]);
        }

    }
    ;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Self_() {
    }

    /**
     * 
     * @param href
     */
    public Self_(String href) {
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
