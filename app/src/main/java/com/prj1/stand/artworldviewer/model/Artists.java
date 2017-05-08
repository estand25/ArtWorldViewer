package com.prj1.stand.artworldviewer.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Artists implements Parcelable {

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


    protected Artists(Parcel in) {
        totalCount = (Object) in.readValue(Object.class.getClassLoader());
        links = (Links) in.readValue(Links.class.getClassLoader());
        embedded = (Artists_Embedded) in.readValue(Artists_Embedded.class.getClassLoader());
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
    public static final Parcelable.Creator<Artists> CREATOR = new Parcelable.Creator<Artists>() {
        @Override
        public Artists createFromParcel(Parcel in) {
            return new Artists(in);
        }

        @Override
        public Artists[] newArray(int size) {
            return new Artists[size];
        }
    };
}