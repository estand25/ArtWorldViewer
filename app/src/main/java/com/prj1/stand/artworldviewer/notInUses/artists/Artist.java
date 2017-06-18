
package com.prj1.stand.artworldviewer.notInUses.artists;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Artist implements Parcelable
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
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("sortable_name")
    @Expose
    private String sortableName;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("birthday")
    @Expose
    private String birthday;
    @SerializedName("hometown")
    @Expose
    private String hometown;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("nationality")
    @Expose
    private String nationality;
    @SerializedName("_links")
    @Expose
    private Links_ links;
    @SerializedName("image_versions")
    @Expose
    private List<String> imageVersions = null;
    public final static Parcelable.Creator<Artist> CREATOR = new Creator<Artist>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Artist createFromParcel(Parcel in) {
            Artist instance = new Artist();
            instance.id = ((String) in.readValue((String.class.getClassLoader())));
            instance.slug = ((String) in.readValue((String.class.getClassLoader())));
            instance.createdAt = ((String) in.readValue((String.class.getClassLoader())));
            instance.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.sortableName = ((String) in.readValue((String.class.getClassLoader())));
            instance.gender = ((String) in.readValue((String.class.getClassLoader())));
            instance.birthday = ((String) in.readValue((String.class.getClassLoader())));
            instance.hometown = ((String) in.readValue((String.class.getClassLoader())));
            instance.location = ((String) in.readValue((String.class.getClassLoader())));
            instance.nationality = ((String) in.readValue((String.class.getClassLoader())));
            instance.links = ((Links_) in.readValue((Links_.class.getClassLoader())));
            in.readList(instance.imageVersions, (java.lang.String.class.getClassLoader()));
            return instance;
        }

        public Artist[] newArray(int size) {
            return (new Artist[size]);
        }

    }
    ;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Artist() {
    }

    /**
     * 
     * @param birthday
     * @param hometown
     * @param location
     * @param imageVersions
     * @param links
     * @param id
     * @param updatedAt
     * @param nationality
     * @param sortableName
     * @param createdAt
     * @param name
     * @param gender
     * @param slug
     */
    public Artist(String id, String slug, String createdAt, String updatedAt, String name, String sortableName, String gender, String birthday, String hometown, String location, String nationality, Links_ links, List<String> imageVersions) {
        super();
        this.id = id;
        this.slug = slug;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.name = name;
        this.sortableName = sortableName;
        this.gender = gender;
        this.birthday = birthday;
        this.hometown = hometown;
        this.location = location;
        this.nationality = nationality;
        this.links = links;
        this.imageVersions = imageVersions;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSortableName() {
        return sortableName;
    }

    public void setSortableName(String sortableName) {
        this.sortableName = sortableName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Links_ getLinks() {
        return links;
    }

    public void setLinks(Links_ links) {
        this.links = links;
    }

    public List<String> getImageVersions() {
        return imageVersions;
    }

    public void setImageVersions(List<String> imageVersions) {
        this.imageVersions = imageVersions;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(slug);
        dest.writeValue(createdAt);
        dest.writeValue(updatedAt);
        dest.writeValue(name);
        dest.writeValue(sortableName);
        dest.writeValue(gender);
        dest.writeValue(birthday);
        dest.writeValue(hometown);
        dest.writeValue(location);
        dest.writeValue(nationality);
        dest.writeValue(links);
        dest.writeList(imageVersions);
    }

    public int describeContents() {
        return  0;
    }

}
