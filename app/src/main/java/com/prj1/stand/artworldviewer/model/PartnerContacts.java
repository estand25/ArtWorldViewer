
package com.prj1.stand.artworldviewer.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PartnerContacts implements Parcelable
{

    @SerializedName("href")
    @Expose
    private String href;
    public final static Parcelable.Creator<PartnerContacts> CREATOR = new Creator<PartnerContacts>() {


        @SuppressWarnings({
            "unchecked"
        })
        public PartnerContacts createFromParcel(Parcel in) {
            PartnerContacts instance = new PartnerContacts();
            instance.href = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public PartnerContacts[] newArray(int size) {
            return (new PartnerContacts[size]);
        }

    }
    ;

    /**
     * No args constructor for use in serialization
     * 
     */
    public PartnerContacts() {
    }

    /**
     * 
     * @param href
     */
    public PartnerContacts(String href) {
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
