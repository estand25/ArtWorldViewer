
package com.prj1.stand.artworldviewer.model.fairs;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Embedded implements Parcelable
{

    @SerializedName("fairs")
    @Expose
    private List<Fair> fairs = null;
    public final static Parcelable.Creator<Embedded> CREATOR = new Creator<Embedded>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Embedded createFromParcel(Parcel in) {
            Embedded instance = new Embedded();
            in.readList(instance.fairs, (Fairs.class.getClassLoader()));
            return instance;
        }

        public Embedded[] newArray(int size) {
            return (new Embedded[size]);
        }

    }
    ;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Embedded() {
    }

    /**
     * 
     * @param fairs
     */
    public Embedded(List<Fair> fairs) {
        super();
        this.fairs = fairs;
    }

    public List<Fair> getFairs() {
        return fairs;
    }

    public void setFairs(List<Fair> fairs) {
        this.fairs = fairs;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(fairs);
    }

    public int describeContents() {
        return  0;
    }

}
