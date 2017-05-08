package com.prj1.stand.artworldviewer.model;


import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Artists_Embedded implements Parcelable {

    @SerializedName("artists")
    @Expose
    private List<Artist> artists = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public Artists_Embedded() {
    }

    /**
     *
     * @param artists
     */
    public Artists_Embedded(List<Artist> artists) {
        super();
        this.artists = artists;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    protected Artists_Embedded(Parcel in) {
        if (in.readByte() == 0x01) {
            artists = new ArrayList<Artist>();
            in.readList(artists, Artist.class.getClassLoader());
        } else {
            artists = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (artists == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(artists);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Artists_Embedded> CREATOR = new Parcelable.Creator<Artists_Embedded>() {
        @Override
        public Artists_Embedded createFromParcel(Parcel in) {
            return new Artists_Embedded(in);
        }

        @Override
        public Artists_Embedded[] newArray(int size) {
            return new Artists_Embedded[size];
        }
    };
}