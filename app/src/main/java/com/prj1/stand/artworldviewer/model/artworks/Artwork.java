
package com.prj1.stand.artworldviewer.model.artworks;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Artwork implements Parcelable
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
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("medium")
    @Expose
    private String medium;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("dimensions")
    @Expose
    private Dimensions dimensions;
    @SerializedName("published")
    @Expose
    private Boolean published;
    @SerializedName("website")
    @Expose
    private String website;
    @SerializedName("signature")
    @Expose
    private String signature;
    @SerializedName("series")
    @Expose
    private Object series;
    @SerializedName("provenance")
    @Expose
    private String provenance;
    @SerializedName("literature")
    @Expose
    private String literature;
    @SerializedName("exhibition_history")
    @Expose
    private String exhibitionHistory;
    @SerializedName("collecting_institution")
    @Expose
    private String collectingInstitution;
    @SerializedName("additional_information")
    @Expose
    private String additionalInformation;
    @SerializedName("image_rights")
    @Expose
    private String imageRights;
    @SerializedName("blurb")
    @Expose
    private String blurb;
    @SerializedName("unique")
    @Expose
    private Boolean unique;
    @SerializedName("cultural_maker")
    @Expose
    private Object culturalMaker;
    @SerializedName("iconicity")
    @Expose
    private Double iconicity;
    @SerializedName("can_inquire")
    @Expose
    private Boolean canInquire;
    @SerializedName("can_acquire")
    @Expose
    private Boolean canAcquire;
    @SerializedName("can_share")
    @Expose
    private Boolean canShare;
    @SerializedName("sale_message")
    @Expose
    private Object saleMessage;
    @SerializedName("sold")
    @Expose
    private Boolean sold;
    @SerializedName("image_versions")
    @Expose
    private List<String> imageVersions = null;
    @SerializedName("_links")
    @Expose
    private Links_ links;
    @SerializedName("_embedded")
    @Expose
    private Embedded_ embedded;
    public final static Parcelable.Creator<Artwork> CREATOR = new Creator<Artwork>() {
        
        @SuppressWarnings({
            "unchecked"
        })
        public Artwork createFromParcel(Parcel in) {
            Artwork instance = new Artwork();
            instance.id = ((String) in.readValue((String.class.getClassLoader())));
            instance.slug = ((String) in.readValue((String.class.getClassLoader())));
            instance.createdAt = ((String) in.readValue((String.class.getClassLoader())));
            instance.updatedAt = ((String) in.readValue((String.class.getClassLoader())));
            instance.title = ((String) in.readValue((String.class.getClassLoader())));
            instance.category = ((String) in.readValue((String.class.getClassLoader())));
            instance.medium = ((String) in.readValue((String.class.getClassLoader())));
            instance.date = ((String) in.readValue((String.class.getClassLoader())));
            instance.dimensions = ((Dimensions) in.readValue((Dimensions.class.getClassLoader())));
            instance.published = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.website = ((String) in.readValue((String.class.getClassLoader())));
            instance.signature = ((String) in.readValue((String.class.getClassLoader())));
            instance.series = ((Object) in.readValue((Object.class.getClassLoader())));
            instance.provenance = ((String) in.readValue((String.class.getClassLoader())));
            instance.literature = ((String) in.readValue((String.class.getClassLoader())));
            instance.exhibitionHistory = ((String) in.readValue((String.class.getClassLoader())));
            instance.collectingInstitution = ((String) in.readValue((String.class.getClassLoader())));
            instance.additionalInformation = ((String) in.readValue((String.class.getClassLoader())));
            instance.imageRights = ((String) in.readValue((String.class.getClassLoader())));
            instance.blurb = ((String) in.readValue((String.class.getClassLoader())));
            instance.unique = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.culturalMaker = ((Object) in.readValue((Object.class.getClassLoader())));
            instance.iconicity = ((Double) in.readValue((Double.class.getClassLoader())));
            instance.canInquire = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.canAcquire = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.canShare = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            instance.saleMessage = ((Object) in.readValue((Object.class.getClassLoader())));
            instance.sold = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            in.readList(instance.imageVersions, (java.lang.String.class.getClassLoader()));
            instance.links = ((Links_) in.readValue((Links_.class.getClassLoader())));
            instance.embedded = ((Embedded_) in.readValue((Embedded_.class.getClassLoader())));
            return instance;
        }

        public Artwork[] newArray(int size) {
            return (new Artwork[size]);
        }

    }
    ;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Artwork() {
    }

    /**
     * 
     * @param series
     * @param unique
     * @param canAcquire
     * @param iconicity
     * @param date
     * @param id
     * @param imageRights
     * @param collectingInstitution
     * @param canShare
     * @param title
     * @param canInquire
     * @param createdAt
     * @param dimensions
     * @param published
     * @param signature
     * @param sold
     * @param website
     * @param literature
     * @param imageVersions
     * @param culturalMaker
     * @param links
     * @param blurb
     * @param saleMessage
     * @param embedded
     * @param medium
     * @param updatedAt
     * @param provenance
     * @param category
     * @param slug
     * @param exhibitionHistory
     * @param additionalInformation
     */
    public Artwork(String id, String slug, String createdAt, String updatedAt, String title, String category, String medium, String date, Dimensions dimensions, Boolean published, String website, String signature, Object series, String provenance, String literature, String exhibitionHistory, String collectingInstitution, String additionalInformation, String imageRights, String blurb, Boolean unique, Object culturalMaker, Double iconicity, Boolean canInquire, Boolean canAcquire, Boolean canShare, Object saleMessage, Boolean sold, List<String> imageVersions, Links_ links, Embedded_ embedded) {
        super();
        this.id = id;
        this.slug = slug;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.title = title;
        this.category = category;
        this.medium = medium;
        this.date = date;
        this.dimensions = dimensions;
        this.published = published;
        this.website = website;
        this.signature = signature;
        this.series = series;
        this.provenance = provenance;
        this.literature = literature;
        this.exhibitionHistory = exhibitionHistory;
        this.collectingInstitution = collectingInstitution;
        this.additionalInformation = additionalInformation;
        this.imageRights = imageRights;
        this.blurb = blurb;
        this.unique = unique;
        this.culturalMaker = culturalMaker;
        this.iconicity = iconicity;
        this.canInquire = canInquire;
        this.canAcquire = canAcquire;
        this.canShare = canShare;
        this.saleMessage = saleMessage;
        this.sold = sold;
        this.imageVersions = imageVersions;
        this.links = links;
        this.embedded = embedded;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public void setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
    }

    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Object getSeries() {
        return series;
    }

    public void setSeries(Object series) {
        this.series = series;
    }

    public String getProvenance() {
        return provenance;
    }

    public void setProvenance(String provenance) {
        this.provenance = provenance;
    }

    public String getLiterature() {
        return literature;
    }

    public void setLiterature(String literature) {
        this.literature = literature;
    }

    public String getExhibitionHistory() {
        return exhibitionHistory;
    }

    public void setExhibitionHistory(String exhibitionHistory) {
        this.exhibitionHistory = exhibitionHistory;
    }

    public String getCollectingInstitution() {
        return collectingInstitution;
    }

    public void setCollectingInstitution(String collectingInstitution) {
        this.collectingInstitution = collectingInstitution;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public String getImageRights() {
        return imageRights;
    }

    public void setImageRights(String imageRights) {
        this.imageRights = imageRights;
    }

    public String getBlurb() {
        return blurb;
    }

    public void setBlurb(String blurb) {
        this.blurb = blurb;
    }

    public Boolean getUnique() {
        return unique;
    }

    public void setUnique(Boolean unique) {
        this.unique = unique;
    }

    public Object getCulturalMaker() {
        return culturalMaker;
    }

    public void setCulturalMaker(Object culturalMaker) {
        this.culturalMaker = culturalMaker;
    }

    public Double getIconicity() {
        return iconicity;
    }

    public void setIconicity(Double iconicity) {
        this.iconicity = iconicity;
    }

    public Boolean getCanInquire() {
        return canInquire;
    }

    public void setCanInquire(Boolean canInquire) {
        this.canInquire = canInquire;
    }

    public Boolean getCanAcquire() {
        return canAcquire;
    }

    public void setCanAcquire(Boolean canAcquire) {
        this.canAcquire = canAcquire;
    }

    public Boolean getCanShare() {
        return canShare;
    }

    public void setCanShare(Boolean canShare) {
        this.canShare = canShare;
    }

    public Object getSaleMessage() {
        return saleMessage;
    }

    public void setSaleMessage(Object saleMessage) {
        this.saleMessage = saleMessage;
    }

    public Boolean getSold() {
        return sold;
    }

    public void setSold(Boolean sold) {
        this.sold = sold;
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

    public Embedded_ getEmbedded() {
        return embedded;
    }

    public void setEmbedded(Embedded_ embedded) {
        this.embedded = embedded;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(slug);
        dest.writeValue(createdAt);
        dest.writeValue(updatedAt);
        dest.writeValue(title);
        dest.writeValue(category);
        dest.writeValue(medium);
        dest.writeValue(date);
        dest.writeValue(dimensions);
        dest.writeValue(published);
        dest.writeValue(website);
        dest.writeValue(signature);
        dest.writeValue(series);
        dest.writeValue(provenance);
        dest.writeValue(literature);
        dest.writeValue(exhibitionHistory);
        dest.writeValue(collectingInstitution);
        dest.writeValue(additionalInformation);
        dest.writeValue(imageRights);
        dest.writeValue(blurb);
        dest.writeValue(unique);
        dest.writeValue(culturalMaker);
        dest.writeValue(iconicity);
        dest.writeValue(canInquire);
        dest.writeValue(canAcquire);
        dest.writeValue(canShare);
        dest.writeValue(saleMessage);
        dest.writeValue(sold);
        dest.writeList(imageVersions);
        dest.writeValue(links);
        dest.writeValue(embedded);
    }

    public int describeContents() {
        return  0;
    }

}
