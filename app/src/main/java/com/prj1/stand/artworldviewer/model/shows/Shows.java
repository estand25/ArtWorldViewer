
package com.prj1.stand.artworldviewer.model.shows;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Shows implements Parcelable
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
    public final static Parcelable.Creator<Shows> CREATOR = new Creator<Shows>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Shows createFromParcel(Parcel in) {
            Shows instance = new Shows();
            instance.totalCount = ((Object) in.readValue((Object.class.getClassLoader())));
            instance.links = ((Links) in.readValue((Links.class.getClassLoader())));
            instance.embedded = ((Embedded) in.readValue((Embedded.class.getClassLoader())));
            return instance;
        }

        public Shows[] newArray(int size) {
            return (new Shows[size]);
        }

    }
    ;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Shows() {
    }

    /**
     * 
     * @param totalCount
     * @param links
     * @param embedded
     */
    public Shows(Object totalCount, Links links, Embedded embedded) {
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
