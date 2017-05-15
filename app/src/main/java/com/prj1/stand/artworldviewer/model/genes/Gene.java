
package com.prj1.stand.artworldviewer.model.genes;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Gene implements Parcelable
{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("display_name")
    @Expose
    private String displayName;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("image_versions")
    @Expose
    private List<String> imageVersions = null;
    @SerializedName("_links")
    @Expose
    private Links_ links;
    public final static Parcelable.Creator<Gene> CREATOR = new Creator<Gene>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Gene createFromParcel(Parcel in) {
            Gene instance = new Gene();
            instance.id = ((String) in.readValue((String.class.getClassLoader())));
            instance.createdAt = ((String) in.readValue((String.class.getClassLoader())));
            instance.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.displayName = ((String) in.readValue((String.class.getClassLoader())));
            instance.description = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(instance.imageVersions, (java.lang.String.class.getClassLoader()));
            instance.links = ((Links_) in.readValue((Links_.class.getClassLoader())));
            return instance;
        }

        public Gene[] newArray(int size) {
            return (new Gene[size]);
        }

    }
    ;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Gene() {
    }

    /**
     * 
     * @param updatedAt
     * @param id
     * @param description
     * @param createdAt
     * @param name
     * @param imageVersions
     * @param links
     * @param displayName
     */
    public Gene(String id, String createdAt, String updatedAt, String name, String displayName, String description, List<String> imageVersions, Links_ links) {
        super();
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.name = name;
        this.displayName = displayName;
        this.description = description;
        this.imageVersions = imageVersions;
        this.links = links;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getImageVersions() {
        return imageVersions;
    }

    public void setImageVersions(List<String> imageVersions) {
        this.imageVersions = imageVersions;
    }

    public Links_ getLinks() {
        return links;
    }

    public void setLinks(Links_ links) {
        this.links = links;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(createdAt);
        dest.writeValue(updatedAt);
        dest.writeValue(name);
        dest.writeValue(displayName);
        dest.writeValue(description);
        dest.writeList(imageVersions);
        dest.writeValue(links);
    }

    public int describeContents() {
        return  0;
    }

}
