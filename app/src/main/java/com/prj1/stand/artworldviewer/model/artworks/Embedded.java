
package com.prj1.stand.artworldviewer.model.artworks;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Embedded implements Parcelable
{

    @SerializedName("artworks")
    @Expose
    private List<Artwork> artworks = null;
    public final static Parcelable.Creator<Embedded> CREATOR = new Creator<Embedded>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Embedded createFromParcel(Parcel in) {
            Embedded instance = new Embedded();
            in.readList(instance.artworks, (Artworks.class.getClassLoader()));
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
     * @param artworks
     */
    public Embedded(List<Artwork> artworks) {
        super();
        this.artworks = artworks;
    }

    public List<Artwork> getArtworks() {
        return artworks;
    }

    public void setArtworks(List<Artwork> artworks) {
        this.artworks = artworks;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(artworks);
    }

    public int describeContents() {
        return  0;
    }

}
