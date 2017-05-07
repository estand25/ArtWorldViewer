package com.prj1.stand.artworldviewer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SimilarArtists {

    @SerializedName("href")
    @Expose
    private String href;

    /**
     * No args constructor for use in serialization
     *
     */
    public SimilarArtists() {
    }

    /**
     *
     * @param href
     */
    public SimilarArtists(String href) {
        super();
        this.href = href;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

}