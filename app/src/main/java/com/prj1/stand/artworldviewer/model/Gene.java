package com.prj1.stand.artworldviewer.model;


import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Gene implements Parcelable {

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
    private List<String> imageVersions = new ArrayList<String>();
    @SerializedName("_links")
    @Expose
    private Genes_Links links;

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
    public Gene(String id, String createdAt, String updatedAt, String name, String displayName, String description, List<String> imageVersions, Genes_Links links) {
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

    public Gene withId(String id) {
        this.id = id;
        return this;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Gene withCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Gene withUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gene withName(String name) {
        this.name = name;
        return this;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Gene withDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Gene withDescription(String description) {
        this.description = description;
        return this;
    }

    public List<String> getImageVersions() {
        return imageVersions;
    }

    public void setImageVersions(List<String> imageVersions) {
        this.imageVersions = imageVersions;
    }

    public Gene withImageVersions(List<String> imageVersions) {
        this.imageVersions = imageVersions;
        return this;
    }

    public Genes_Links getLinks() {
        return links;
    }

    public void setLinks(Genes_Links links) {
        this.links = links;
    }

    public Gene withLinks(Genes_Links links) {
        this.links = links;
        return this;
    }


    protected Gene(Parcel in) {
        id = in.readString();
        createdAt = in.readString();
        updatedAt = in.readString();
        name = in.readString();
        displayName = in.readString();
        description = in.readString();
        if (in.readByte() == 0x01) {
            imageVersions = new ArrayList<String>();
            in.readList(imageVersions, String.class.getClassLoader());
        } else {
            imageVersions = null;
        }
        links = (Genes_Links) in.readValue(Genes_Links.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(createdAt);
        dest.writeString(updatedAt);
        dest.writeString(name);
        dest.writeString(displayName);
        dest.writeString(description);
        if (imageVersions == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(imageVersions);
        }
        dest.writeValue(links);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Gene> CREATOR = new Parcelable.Creator<Gene>() {
        @Override
        public Gene createFromParcel(Parcel in) {
            return new Gene(in);
        }

        @Override
        public Gene[] newArray(int size) {
            return new Gene[size];
        }
    };
}