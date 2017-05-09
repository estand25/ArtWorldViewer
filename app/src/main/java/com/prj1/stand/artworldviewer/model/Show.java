
package com.prj1.stand.artworldviewer.model;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Show implements Parcelable
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
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("press_release")
    @Expose
    private String pressRelease;
    @SerializedName("start_at")
    @Expose
    private String startAt;
    @SerializedName("end_at")
    @Expose
    private String endAt;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("image_versions")
    @Expose
    private List<String> imageVersions = null;
    @SerializedName("_links")
    @Expose
    private Shows_Links links;
    public final static Parcelable.Creator<Show> CREATOR = new Creator<Show>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Show createFromParcel(Parcel in) {
            Show instance = new Show();
            instance.id = ((String) in.readValue((String.class.getClassLoader())));
            instance.createdAt = ((String) in.readValue((String.class.getClassLoader())));
            instance.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.description = ((String) in.readValue((String.class.getClassLoader())));
            instance.pressRelease = ((String) in.readValue((String.class.getClassLoader())));
            instance.startAt = ((String) in.readValue((String.class.getClassLoader())));
            instance.endAt = ((String) in.readValue((String.class.getClassLoader())));
            instance.status = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(instance.imageVersions, (java.lang.String.class.getClassLoader()));
            instance.links = ((Shows_Links) in.readValue((Shows_Links.class.getClassLoader())));
            return instance;
        }

        public Show[] newArray(int size) {
            return (new Show[size]);
        }

    }
    ;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Show() {
    }

    /**
     * 
     * @param updatedAt
     * @param id
     * @param status
     * @param description
     * @param createdAt
     * @param name
     * @param imageVersions
     * @param links
     * @param startAt
     * @param endAt
     * @param pressRelease
     */
    public Show(String id, String createdAt, String updatedAt, String name, String description, String pressRelease, String startAt, String endAt, String status, List<String> imageVersions, Shows_Links links) {
        super();
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.name = name;
        this.description = description;
        this.pressRelease = pressRelease;
        this.startAt = startAt;
        this.endAt = endAt;
        this.status = status;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPressRelease() {
        return pressRelease;
    }

    public void setPressRelease(String pressRelease) {
        this.pressRelease = pressRelease;
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

    public List<String> getImageVersions() {
        return imageVersions;
    }

    public void setImageVersions(List<String> imageVersions) {
        this.imageVersions = imageVersions;
    }

    public Shows_Links getLinks() {
        return links;
    }

    public void setLinks(Shows_Links links) {
        this.links = links;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(createdAt);
        dest.writeValue(updatedAt);
        dest.writeValue(name);
        dest.writeValue(description);
        dest.writeValue(pressRelease);
        dest.writeValue(startAt);
        dest.writeValue(endAt);
        dest.writeValue(status);
        dest.writeList(imageVersions);
        dest.writeValue(links);
    }

    public int describeContents() {
        return  0;
    }

}
