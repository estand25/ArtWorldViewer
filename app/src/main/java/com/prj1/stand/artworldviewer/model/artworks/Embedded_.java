
package com.prj1.stand.artworldviewer.model.artworks;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Embedded_ implements Parcelable
{

    @SerializedName("editions")
    @Expose
    private List<Object> editions = null;
    public final static Parcelable.Creator<Embedded_> CREATOR = new Creator<Embedded_>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Embedded_ createFromParcel(Parcel in) {
            Embedded_ instance = new Embedded_();
            in.readList(instance.editions, (java.lang.Object.class.getClassLoader()));
            return instance;
        }

        public Embedded_[] newArray(int size) {
            return (new Embedded_[size]);
        }

    }
    ;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Embedded_() {
    }

    /**
     * 
     * @param editions
     */
    public Embedded_(List<Object> editions) {
        super();
        this.editions = editions;
    }

    public List<Object> getEditions() {
        return editions;
    }

    public void setEditions(List<Object> editions) {
        this.editions = editions;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(editions);
    }

    public int describeContents() {
        return  0;
    }

}
