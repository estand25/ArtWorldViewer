package com.prj1.stand.artworldviewer.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Genes implements Parcelable {

    @SerializedName("total_count")
    @Expose
    private Object totalCount;
    @SerializedName("_links")
    @Expose
    private Genes_Links links;
    @SerializedName("_embedded")
    @Expose
    private Genes_Embedded embedded;
    @SerializedName("href")
    @Expose
    private String href;

    /**
     * No args constructor for use in serialization
     *
     */
    public Genes() {
    }

    /**
     *
     * @param totalCount
     * @param links
     * @param embedded
     */
    public Genes(Object totalCount, Genes_Links links, Genes_Embedded embedded) {
        super();
        this.totalCount = totalCount;
        this.links = links;
        this.embedded = embedded;
    }

    /**
     *
     * @param href
     */
    public Genes(String href) {
        super();
        this.href = href;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Genes withHref(String href) {
        this.href = href;
        return this;
    }

    public Object getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Object totalCount) {
        this.totalCount = totalCount;
    }

    public Genes withTotalCount(Object totalCount) {
        this.totalCount = totalCount;
        return this;
    }

    public Genes_Links getLinks() {
        return links;
    }

    public void setLinks(Genes_Links links) {
        this.links = links;
    }

    public Genes withLinks(Genes_Links links) {
        this.links = links;
        return this;
    }

    public Genes_Embedded getEmbedded() {
        return embedded;
    }

    public void setEmbedded(Genes_Embedded embedded) {
        this.embedded = embedded;
    }

    public Genes withEmbedded(Genes_Embedded embedded) {
        this.embedded = embedded;
        return this;
    }


    protected Genes(Parcel in) {
        totalCount = (Object) in.readValue(Object.class.getClassLoader());
        links = (Genes_Links) in.readValue(Genes_Links.class.getClassLoader());
        embedded = (Genes_Embedded) in.readValue(Genes_Embedded.class.getClassLoader());
        href = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(totalCount);
        dest.writeValue(links);
        dest.writeValue(embedded);
        dest.writeString(href);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Genes> CREATOR = new Parcelable.Creator<Genes>() {
        @Override
        public Genes createFromParcel(Parcel in) {
            return new Genes(in);
        }

        @Override
        public Genes[] newArray(int size) {
            return new Genes[size];
        }
    };
}