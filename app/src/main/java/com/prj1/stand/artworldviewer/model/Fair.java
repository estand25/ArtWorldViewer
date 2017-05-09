package com.prj1.stand.artworldviewer.model;

import android.os.Parcelable;
import android.os.Parcel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Fair implements Parcelable {

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
    private Fairs_Links links;

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
    public Fair(String id, String createdAt, String updatedAt, String name, String about, String contact, String summary, String startAt, String endAt, String status, Boolean published, Fairs_Links links) {
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

    public Fairs_Links getLinks() {
        return links;
    }

    public void setLinks(Fairs_Links links) {
        this.links = links;
    }


    protected Fair(Parcel in) {
        id = in.readString();
        createdAt = in.readString();
        updatedAt = in.readString();
        name = in.readString();
        about = in.readString();
        contact = in.readString();
        summary = in.readString();
        startAt = in.readString();
        endAt = in.readString();
        status = in.readString();
        byte publishedVal = in.readByte();
        published = publishedVal == 0x02 ? null : publishedVal != 0x00;
        links = (Fairs_Links) in.readValue(Fairs_Links.class.getClassLoader());
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
        dest.writeString(about);
        dest.writeString(contact);
        dest.writeString(summary);
        dest.writeString(startAt);
        dest.writeString(endAt);
        dest.writeString(status);
        if (published == null) {
            dest.writeByte((byte) (0x02));
        } else {
            dest.writeByte((byte) (published ? 0x01 : 0x00));
        }
        dest.writeValue(links);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Fair> CREATOR = new Parcelable.Creator<Fair>() {
        @Override
        public Fair createFromParcel(Parcel in) {
            return new Fair(in);
        }

        @Override
        public Fair[] newArray(int size) {
            return new Fair[size];
        }
    };
}