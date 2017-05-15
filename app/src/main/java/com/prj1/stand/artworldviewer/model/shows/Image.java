
package com.prj1.stand.artworldviewer.model.shows;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Image implements Parcelable
{

    @SerializedName("href")
    @Expose
    private Object href;
    @SerializedName("templated")
    @Expose
    private Boolean templated;
    public final static Parcelable.Creator<Image> CREATOR = new Creator<Image>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Image createFromParcel(Parcel in) {
            Image instance = new Image();
            instance.href = ((Object) in.readValue((Object.class.getClassLoader())));
            instance.templated = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            return instance;
        }

        public Image[] newArray(int size) {
            return (new Image[size]);
        }

    }
    ;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Image() {
    }

    /**
     * 
     * @param templated
     * @param href
     */
    public Image(Object href, Boolean templated) {
        super();
        this.href = href;
        this.templated = templated;
    }

    public Object getHref() {
        return href;
    }

    public void setHref(Object href) {
        this.href = href;
    }

    public Boolean getTemplated() {
        return templated;
    }

    public void setTemplated(Boolean templated) {
        this.templated = templated;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(href);
        dest.writeValue(templated);
    }

    public int describeContents() {
        return  0;
    }

}