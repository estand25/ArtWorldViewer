
package com.prj1.stand.artworldviewer.model.shows;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Embedded implements Parcelable
{

    @SerializedName("shows")
    @Expose
    private List<Show> shows = null;
    public final static Parcelable.Creator<Embedded> CREATOR = new Creator<Embedded>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Embedded createFromParcel(Parcel in) {
            Embedded instance = new Embedded();
            in.readList(instance.shows, (Shows.class.getClassLoader()));
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
     * @param shows
     */
    public Embedded(List<Show> shows) {
        super();
        this.shows = shows;
    }

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(shows);
    }

    public int describeContents() {
        return  0;
    }

}
