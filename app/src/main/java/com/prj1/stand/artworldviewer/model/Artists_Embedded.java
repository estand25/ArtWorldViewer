package com.prj1.stand.artworldviewer.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Artists_Embedded {

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

}