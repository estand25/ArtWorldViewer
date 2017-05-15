
package com.prj1.stand.artworldviewer.model.artworks;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Genes implements Parcelable
{

    @SerializedName("href")
    @Expose
    private String href;
    public final static Parcelable.Creator<Genes> CREATOR = new Creator<Genes>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Genes createFromParcel(Parcel in) {
            Genes instance = new Genes();
            instance.href = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Genes[] newArray(int size) {
            return (new Genes[size]);
        }

    }
    ;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Genes() {
    }

    /**
     * 
     * @param href
     */
    public Genes(String href) {
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
