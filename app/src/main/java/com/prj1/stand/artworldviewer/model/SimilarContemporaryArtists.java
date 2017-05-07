package com.prj1.stand.artworldviewer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SimilarContemporaryArtists {

    @SerializedName("href")
    @Expose
    private String href;

    /**
     * No args constructor for use in serialization
     *
     */
    public SimilarContemporaryArtists() {
    }

    /**
     *
     * @param href
     */
    public SimilarContemporaryArtists(String href) {
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
