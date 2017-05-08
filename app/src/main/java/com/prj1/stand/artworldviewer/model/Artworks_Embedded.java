package com.prj1.stand.artworldviewer.model;


import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Artworks_Embedded implements Parcelable {

    @SerializedName("artworks")
    @Expose
    private List<Artwork> artworks = new ArrayList<Artwork>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Artworks_Embedded() {
    }

    /**
     *
     * @param artworks
     */
    public Artworks_Embedded(List<Artwork> artworks) {
        super();
        this.artworks = artworks;
    }

    public List<Artwork> getArtworks() {
        return artworks;
    }

    public void setArtworks(List<Artwork> artworks) {
        this.artworks = artworks;
    }

    public Artworks_Embedded withArtworks(List<Artwork> artworks) {
        this.artworks = artworks;
        return this;
    }


    protected Artworks_Embedded(Parcel in) {
        if (in.readByte() == 0x01) {
            artworks = new ArrayList<Artwork>();
            in.readList(artworks, Artwork.class.getClassLoader());
        } else {
            artworks = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (artworks == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(artworks);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Artworks_Embedded> CREATOR = new Parcelable.Creator<Artworks_Embedded>() {
        @Override
        public Artworks_Embedded createFromParcel(Parcel in) {
            return new Artworks_Embedded(in);
        }

        @Override
        public Artworks_Embedded[] newArray(int size) {
            return new Artworks_Embedded[size];
        }
    };
}