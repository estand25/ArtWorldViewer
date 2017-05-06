package com.prj1.stand.artworldviewer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Artworks {

    @SerializedName("total_count")
    @Expose
    private Object totalCount;
    @SerializedName("_links")
    @Expose
    private Artworks_Links links;
    @SerializedName("_embedded")
    @Expose
    private Artworks_Embedded embedded;
    @SerializedName("href")
    @Expose
    private String href;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Artworks() {
    }

    /**
     * 
     * @param href
     */
    public Artworks(String href) {
        super();
        this.href = href;
    }

    /**
     * 
     * @param totalCount
     * @param links
     * @param embedded
     */
    public Artworks(Object totalCount, Artworks_Links links, Artworks_Embedded embedded) {
        super();
        this.totalCount = totalCount;
        this.links = links;
        this.embedded = embedded;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Artworks withHref(String href) {
        this.href = href;
        return this;
    }

    public Object getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Object totalCount) {
        this.totalCount = totalCount;
    }

    public Artworks withTotalCount(Object totalCount) {
        this.totalCount = totalCount;
        return this;
    }

    public Artworks_Links getLinks() {
        return links;
    }

    public void setLinks(Artworks_Links links) {
        this.links = links;
    }

    public Artworks withLinks(Artworks_Links links) {
        this.links = links;
        return this;
    }

    public Artworks_Embedded getEmbedded() {
        return embedded;
    }

    public void setEmbedded(Artworks_Embedded embedded) {
        this.embedded = embedded;
    }

    public Artworks withEmbedded(Artworks_Embedded embedded) {
        this.embedded = embedded;
        return this;
    }
}