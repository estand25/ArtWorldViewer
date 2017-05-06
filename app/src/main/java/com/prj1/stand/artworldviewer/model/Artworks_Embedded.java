
package com.prj1.stand.artworldviewer.model;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Artworks_Embedded {

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

}
