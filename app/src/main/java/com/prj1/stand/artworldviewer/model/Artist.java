package com.prj1.stand.artworldviewer.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Artist implements Parcelable {

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
    private Object gender;
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
    private Artists_Links links;

    /**
     * No args constructor for use in serialization
     *
     */
    public Artist() {
    }

    /**
     *
     * @param updatedAt
     * @param id
     * @param birthday
     * @param nationality
     * @param hometown
     * @param sortableName
     * @param location
     * @param createdAt
     * @param name
     * @param gender
     * @param links
     * @param slug
     */
    public Artist(String id, String slug, String createdAt, String updatedAt, String name, String sortableName, Object gender, String birthday, String hometown, String location, String nationality, Artists_Links links) {
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

    public Object getGender() {
        return gender;
    }

    public void setGender(Object gender) {
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

    public Artists_Links getLinks() {
        return links;
    }

    public void setLinks(Artists_Links links) {
        this.links = links;
    }


    protected Artist(Parcel in) {
        id = in.readString();
        slug = in.readString();
        createdAt = in.readString();
        updatedAt = in.readString();
        name = in.readString();
        sortableName = in.readString();
        gender = (Object) in.readValue(Object.class.getClassLoader());
        birthday = in.readString();
        hometown = in.readString();
        location = in.readString();
        nationality = in.readString();
        links = (Artists_Links) in.readValue(Artists_Links.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(slug);
        dest.writeString(createdAt);
        dest.writeString(updatedAt);
        dest.writeString(name);
        dest.writeString(sortableName);
        dest.writeValue(gender);
        dest.writeString(birthday);
        dest.writeString(hometown);
        dest.writeString(location);
        dest.writeString(nationality);
        dest.writeValue(links);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Artist> CREATOR = new Parcelable.Creator<Artist>() {
        @Override
        public Artist createFromParcel(Parcel in) {
            return new Artist(in);
        }

        @Override
        public Artist[] newArray(int size) {
            return new Artist[size];
        }
    };
}