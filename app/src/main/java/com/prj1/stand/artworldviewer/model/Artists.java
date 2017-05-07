
package com.prj1.stand.artworldviewer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Artists {

    @SerializedName("total_count")
    @Expose
    private Object totalCount;
    @SerializedName("_links")
    @Expose
    private Links links;
    @SerializedName("_embedded")
    @Expose
    private Artists_Embedded embedded;

    /**
     * No args constructor for use in serialization
     *
     */
    public Artists() {
    }

    /**
     *
     * @param totalCount
     * @param links
     * @param embedded
     */
    public Artists(Object totalCount, Links links, Artists_Embedded embedded) {
        super();
        this.totalCount = totalCount;
        this.links = links;
        this.embedded = embedded;
    }

    public Object getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Object totalCount) {
        this.totalCount = totalCount;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public Artists_Embedded getEmbedded() {
        return embedded;
    }

    public void setEmbedded(Artists_Embedded embedded) {
        this.embedded = embedded;
    }

}