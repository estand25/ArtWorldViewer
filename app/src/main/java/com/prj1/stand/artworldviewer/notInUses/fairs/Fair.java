
package com.prj1.stand.artworldviewer.notInUses.fairs;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Fair implements Parcelable
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
    @SerializedName("about")
    @Expose
    private String about;
    @SerializedName("contact")
    @Expose
    private String contact;
    @SerializedName("summary")
    @Expose
    private String summary;
    @SerializedName("start_at")
    @Expose
    private String startAt;
    @SerializedName("end_at")
    @Expose
    private String endAt;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("published")
    @Expose
    private Boolean published;
    @SerializedName("_links")
    @Expose
    private Links_ links;
    public final static Parcelable.Creator<Fair> CREATOR = new Creator<Fair>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Fair createFromParcel(Parcel in) {
            Fair instance = new Fair();
            instance.id = ((String) in.readValue((String.class.getClassLoader())));
            instance.createdAt = ((String) in.readValue((String.class.getClassLoader())));
            instance.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.about = ((String) in.readValue((String.class.getClassLoader())));
            instance.contact = ((String) in.readValue((String.class.getClassLoader())));
            instance.summary = ((String) in.readValue((String.class.getClassLoader())));
            instance.startAt = ((String) in.readValue((String.class.getClassLoader())));
            instance.endAt = ((String) in.readValue((String.class.getClassLoader())));
            instance.status = ((String) in.readValue((String.class.getClassLoader())));
            instance.published = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.links = ((Links_) in.readValue((Links_.class.getClassLoader())));
            return instance;
        }

        public Fair[] newArray(int size) {
            return (new Fair[size]);
        }

    }
    ;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Fair() {
    }

    /**
     * 
     * @param summary
     * @param updatedAt
     * @param id
     * @param status
     * @param createdAt
     * @param name
     * @param about
     * @param links
     * @param startAt
     * @param endAt
     * @param published
     * @param contact
     */
    public Fair(String id, String createdAt, String updatedAt, String name, String about, String contact, String summary, String startAt, String endAt, String status, Boolean published, Links_ links) {
        super();
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.name = name;
        this.about = about;
        this.contact = contact;
        this.summary = summary;
        this.startAt = startAt;
        this.endAt = endAt;
        this.status = status;
        this.published = published;
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

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getStartAt() {
        return startAt;
    }

    public void setStartAt(String startAt) {
        this.startAt = startAt;
    }

    public String getEndAt() {
        return endAt;
    }

    public void setEndAt(String endAt) {
        this.endAt = endAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
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
        dest.writeValue(about);
        dest.writeValue(contact);
        dest.writeValue(summary);
        dest.writeValue(startAt);
        dest.writeValue(endAt);
        dest.writeValue(status);
        dest.writeValue(published);
        dest.writeValue(links);
    }

    public int describeContents() {
        return  0;
    }

}
