
package com.prj1.stand.artworldviewer.notInUses.genes;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Genes implements Parcelable
{

    @SerializedName("total_count")
    @Expose
    private Object totalCount;
    @SerializedName("_links")
    @Expose
    private Links links;
    @SerializedName("_embedded")
    @Expose
    private Embedded embedded;
    public final static Parcelable.Creator<Genes> CREATOR = new Creator<Genes>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Genes createFromParcel(Parcel in) {
            Genes instance = new Genes();
            instance.totalCount = ((Object) in.readValue((Object.class.getClassLoader())));
            instance.links = ((Links) in.readValue((Links.class.getClassLoader())));
            instance.embedded = ((Embedded) in.readValue((Embedded.class.getClassLoader())));
            return instance;
        }

        public Genes[] newArray(int size) {
            return (new Genes[size]);
        }

    }
    ;

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
    public Genes(Object totalCount, Links links, Embedded embedded) {
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

    public Embedded getEmbedded() {
        return embedded;
    }

    public void setEmbedded(Embedded embedded) {
        this.embedded = embedded;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(totalCount);
        dest.writeValue(links);
        dest.writeValue(embedded);
    }

    public int describeContents() {
        return  0;
    }

}
