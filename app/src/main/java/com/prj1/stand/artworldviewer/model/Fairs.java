package com.prj1.stand.artworldviewer.model;

import android.os.Parcelable;
import android.os.Parcel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Fairs implements Parcelable {

    @SerializedName("total_count")
    @Expose
    private Object totalCount;
    @SerializedName("_links")
    @Expose
    private Fairs_Links links;
    @SerializedName("_embedded")
    @Expose
    private Fairs_Embedded embedded;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Fairs() {
    }

    /**
     * 
     * @param totalCount
     * @param links
     * @param embedded
     */
    public Fairs(Object totalCount, Fairs_Links links, Fairs_Embedded embedded) {
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

    public Fairs_Links getLinks() {
        return links;
    }

    public void setLinks(Fairs_Links links) {
        this.links = links;
    }

    public Fairs_Embedded getEmbedded() {
        return embedded;
    }

    public void setEmbedded(Fairs_Embedded embedded) {
        this.embedded = embedded;
    }


    protected Fairs(Parcel in) {
        totalCount = (Object) in.readValue(Object.class.getClassLoader());
        links = (Fairs_Links) in.readValue(Fairs_Links.class.getClassLoader());
        embedded = (Fairs_Embedded) in.readValue(Fairs_Embedded.class.getClassLoader());
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
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Fairs> CREATOR = new Parcelable.Creator<Fairs>() {
        @Override
        public Fairs createFromParcel(Parcel in) {
            return new Fairs(in);
        }

        @Override
        public Fairs[] newArray(int size) {
            return new Fairs[size];
        }
    };
}