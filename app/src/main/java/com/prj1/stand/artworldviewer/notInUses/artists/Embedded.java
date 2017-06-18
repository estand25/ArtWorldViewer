
package com.prj1.stand.artworldviewer.notInUses.artists;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Embedded implements Parcelable
{

    @SerializedName("artists")
    @Expose
    private List<Artist> artists = null;
    public final static Parcelable.Creator<Embedded> CREATOR = new Creator<Embedded>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Embedded createFromParcel(Parcel in) {
            Embedded instance = new Embedded();
            in.readList(instance.artists, (Artists.class.getClassLoader()));
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
     * @param artists
     */
    public Embedded(List<Artist> artists) {
        super();
        this.artists = artists;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(artists);
    }

    public int describeContents() {
        return  0;
    }

}
