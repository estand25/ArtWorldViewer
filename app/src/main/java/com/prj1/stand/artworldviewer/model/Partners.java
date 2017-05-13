
package com.prj1.stand.artworldviewer.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Partners implements Parcelable
{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("region")
    @Expose
    private String region;
    @SerializedName("_links")
    @Expose
    private Links links;
    public final static Parcelable.Creator<Partners> CREATOR = new Creator<Partners>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Partners createFromParcel(Parcel in) {
            Partners instance = new Partners();
            instance.id = ((String) in.readValue((String.class.getClassLoader())));
            instance.slug = ((String) in.readValue((String.class.getClassLoader())));
            instance.createdAt = ((String) in.readValue((String.class.getClassLoader())));
            instance.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
            instance.type = ((String) in.readValue((String.class.getClassLoader())));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.email = ((String) in.readValue((String.class.getClassLoader())));
            instance.region = ((String) in.readValue((String.class.getClassLoader())));
            instance.links = ((Links) in.readValue((Links.class.getClassLoader())));
            return instance;
        }

        public Partners[] newArray(int size) {
            return (new Partners[size]);
        }

    }
    ;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Partners() {
    }

    /**
     * 
     * @param region
     * @param updatedAt
     * @param id
     * @param email
     * @param createdAt
     * @param name
     * @param links
     * @param slug
     * @param type
     */
    public Partners(String id, String slug, String createdAt, String updatedAt, String type, String name, String email, String region, Links links) {
        super();
        this.id = id;
        this.slug = slug;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.type = type;
        this.name = name;
        this.email = email;
        this.region = region;
        this.links = links;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(slug);
        dest.writeValue(createdAt);
        dest.writeValue(updatedAt);
        dest.writeValue(type);
        dest.writeValue(name);
        dest.writeValue(email);
        dest.writeValue(region);
        dest.writeValue(links);
    }

    public int describeContents() {
        return  0;
    }

}
