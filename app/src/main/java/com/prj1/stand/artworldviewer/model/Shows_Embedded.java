
package com.prj1.stand.artworldviewer.model;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Shows_Embedded implements Parcelable
{

    @SerializedName("shows")
    @Expose
    private List<Show> shows = null;
    public final static Parcelable.Creator<Shows_Embedded> CREATOR = new Creator<Shows_Embedded>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Shows_Embedded createFromParcel(Parcel in) {
            Shows_Embedded instance = new Shows_Embedded();
            in.readList(instance.shows, (com.prj1.stand.artworldviewer.model.Show.class.getClassLoader()));
            return instance;
        }

        public Shows_Embedded[] newArray(int size) {
            return (new Shows_Embedded[size]);
        }

    }
    ;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Shows_Embedded() {
    }

    /**
     * 
     * @param shows
     */
    public Shows_Embedded(List<Show> shows) {
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
