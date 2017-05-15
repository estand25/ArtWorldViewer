
package com.prj1.stand.artworldviewer.model.shows;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
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
    private Object description;
    @SerializedName("press_release")
    @Expose
    private Object pressRelease;
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
    private Links_ links;
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
            instance.description = ((Object) in.readValue((Object.class.getClassLoader())));
            instance.pressRelease = ((Object) in.readValue((Object.class.getClassLoader())));
            instance.startAt = ((String) in.readValue((String.class.getClassLoader())));
            instance.endAt = ((String) in.readValue((String.class.getClassLoader())));
            instance.status = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(instance.imageVersions, (java.lang.String.class.getClassLoader()));
            instance.links = ((Links_) in.readValue((Links_.class.getClassLoader())));
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
    public Show(String id, String createdAt, String updatedAt, String name, Object description, Object pressRelease, String startAt, String endAt, String status, List<String> imageVersions, Links_ links) {
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

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public Object getPressRelease() {
        return pressRelease;
    }

    public void setPressRelease(Object pressRelease) {
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
