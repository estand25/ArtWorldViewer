package com.prj1.stand.artworldviewer.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Artwork implements Parcelable {

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
    private List<String> imageVersions = new ArrayList<String>();
    @SerializedName("_links")
    @Expose
    private Artworks_Links links;
    @SerializedName("_embedded")
    @Expose
    private Artworks_Embedded embedded;

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
    public Artwork(String id, String slug, String createdAt, String updatedAt, String title, String category, String medium, String date, Dimensions dimensions, Boolean published, String website, String signature, Object series, String provenance, String literature, String exhibitionHistory, String collectingInstitution, String additionalInformation, String imageRights, String blurb, Boolean unique, Object culturalMaker, Double iconicity, Boolean canInquire, Boolean canAcquire, Boolean canShare, Object saleMessage, Boolean sold, List<String> imageVersions, Artworks_Links links, Artworks_Embedded embedded) {
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

    public Artwork withId(String id) {
        this.id = id;
        return this;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Artwork withSlug(String slug) {
        this.slug = slug;
        return this;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Artwork withCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Artwork withUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Artwork withTitle(String title) {
        this.title = title;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Artwork withCategory(String category) {
        this.category = category;
        return this;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public Artwork withMedium(String medium) {
        this.medium = medium;
        return this;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Artwork withDate(String date) {
        this.date = date;
        return this;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public void setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
    }

    public Artwork withDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
        return this;
    }

    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }

    public Artwork withPublished(Boolean published) {
        this.published = published;
        return this;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Artwork withWebsite(String website) {
        this.website = website;
        return this;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Artwork withSignature(String signature) {
        this.signature = signature;
        return this;
    }

    public Object getSeries() {
        return series;
    }

    public void setSeries(Object series) {
        this.series = series;
    }

    public Artwork withSeries(Object series) {
        this.series = series;
        return this;
    }

    public String getProvenance() {
        return provenance;
    }

    public void setProvenance(String provenance) {
        this.provenance = provenance;
    }

    public Artwork withProvenance(String provenance) {
        this.provenance = provenance;
        return this;
    }

    public String getLiterature() {
        return literature;
    }

    public void setLiterature(String literature) {
        this.literature = literature;
    }

    public Artwork withLiterature(String literature) {
        this.literature = literature;
        return this;
    }

    public String getExhibitionHistory() {
        return exhibitionHistory;
    }

    public void setExhibitionHistory(String exhibitionHistory) {
        this.exhibitionHistory = exhibitionHistory;
    }

    public Artwork withExhibitionHistory(String exhibitionHistory) {
        this.exhibitionHistory = exhibitionHistory;
        return this;
    }

    public String getCollectingInstitution() {
        return collectingInstitution;
    }

    public void setCollectingInstitution(String collectingInstitution) {
        this.collectingInstitution = collectingInstitution;
    }

    public Artwork withCollectingInstitution(String collectingInstitution) {
        this.collectingInstitution = collectingInstitution;
        return this;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public Artwork withAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
        return this;
    }

    public String getImageRights() {
        return imageRights;
    }

    public void setImageRights(String imageRights) {
        this.imageRights = imageRights;
    }

    public Artwork withImageRights(String imageRights) {
        this.imageRights = imageRights;
        return this;
    }

    public String getBlurb() {
        return blurb;
    }

    public void setBlurb(String blurb) {
        this.blurb = blurb;
    }

    public Artwork withBlurb(String blurb) {
        this.blurb = blurb;
        return this;
    }

    public Boolean getUnique() {
        return unique;
    }

    public void setUnique(Boolean unique) {
        this.unique = unique;
    }

    public Artwork withUnique(Boolean unique) {
        this.unique = unique;
        return this;
    }

    public Object getCulturalMaker() {
        return culturalMaker;
    }

    public void setCulturalMaker(Object culturalMaker) {
        this.culturalMaker = culturalMaker;
    }

    public Artwork withCulturalMaker(Object culturalMaker) {
        this.culturalMaker = culturalMaker;
        return this;
    }

    public Double getIconicity() {
        return iconicity;
    }

    public void setIconicity(Double iconicity) {
        this.iconicity = iconicity;
    }

    public Artwork withIconicity(Double iconicity) {
        this.iconicity = iconicity;
        return this;
    }

    public Boolean getCanInquire() {
        return canInquire;
    }

    public void setCanInquire(Boolean canInquire) {
        this.canInquire = canInquire;
    }

    public Artwork withCanInquire(Boolean canInquire) {
        this.canInquire = canInquire;
        return this;
    }

    public Boolean getCanAcquire() {
        return canAcquire;
    }

    public void setCanAcquire(Boolean canAcquire) {
        this.canAcquire = canAcquire;
    }

    public Artwork withCanAcquire(Boolean canAcquire) {
        this.canAcquire = canAcquire;
        return this;
    }

    public Boolean getCanShare() {
        return canShare;
    }

    public void setCanShare(Boolean canShare) {
        this.canShare = canShare;
    }

    public Artwork withCanShare(Boolean canShare) {
        this.canShare = canShare;
        return this;
    }

    public Object getSaleMessage() {
        return saleMessage;
    }

    public void setSaleMessage(Object saleMessage) {
        this.saleMessage = saleMessage;
    }

    public Artwork withSaleMessage(Object saleMessage) {
        this.saleMessage = saleMessage;
        return this;
    }

    public Boolean getSold() {
        return sold;
    }

    public void setSold(Boolean sold) {
        this.sold = sold;
    }

    public Artwork withSold(Boolean sold) {
        this.sold = sold;
        return this;
    }

    public List<String> getImageVersions() {
        return imageVersions;
    }

    public void setImageVersions(List<String> imageVersions) {
        this.imageVersions = imageVersions;
    }

    public Artwork withImageVersions(List<String> imageVersions) {
        this.imageVersions = imageVersions;
        return this;
    }

    public Artworks_Links getLinks() {
        return links;
    }

    public void setLinks(Artworks_Links links) {
        this.links = links;
    }

    public Artwork withLinks(Artworks_Links links) {
        this.links = links;
        return this;
    }

    public Artworks_Embedded getEmbedded() {
        return embedded;
    }

    public void setEmbedded(Artworks_Embedded embedded) {
        this.embedded = embedded;
    }

    public Artwork withEmbedded(Artworks_Embedded embedded) {
        this.embedded = embedded;
        return this;
    }


    protected Artwork(Parcel in) {
        id = in.readString();
        slug = in.readString();
        createdAt = in.readString();
        updatedAt = in.readString();
        title = in.readString();
        category = in.readString();
        medium = in.readString();
        date = in.readString();
        dimensions = (Dimensions) in.readValue(Dimensions.class.getClassLoader());
        byte publishedVal = in.readByte();
        published = publishedVal == 0x02 ? null : publishedVal != 0x00;
        website = in.readString();
        signature = in.readString();
        series = (Object) in.readValue(Object.class.getClassLoader());
        provenance = in.readString();
        literature = in.readString();
        exhibitionHistory = in.readString();
        collectingInstitution = in.readString();
        additionalInformation = in.readString();
        imageRights = in.readString();
        blurb = in.readString();
        byte uniqueVal = in.readByte();
        unique = uniqueVal == 0x02 ? null : uniqueVal != 0x00;
        culturalMaker = (Object) in.readValue(Object.class.getClassLoader());
        iconicity = in.readByte() == 0x00 ? null : in.readDouble();
        byte canInquireVal = in.readByte();
        canInquire = canInquireVal == 0x02 ? null : canInquireVal != 0x00;
        byte canAcquireVal = in.readByte();
        canAcquire = canAcquireVal == 0x02 ? null : canAcquireVal != 0x00;
        byte canShareVal = in.readByte();
        canShare = canShareVal == 0x02 ? null : canShareVal != 0x00;
        saleMessage = (Object) in.readValue(Object.class.getClassLoader());
        byte soldVal = in.readByte();
        sold = soldVal == 0x02 ? null : soldVal != 0x00;
        if (in.readByte() == 0x01) {
            imageVersions = new ArrayList<String>();
            in.readList(imageVersions, String.class.getClassLoader());
        } else {
            imageVersions = null;
        }
        links = (Artworks_Links) in.readValue(Artworks_Links.class.getClassLoader());
        embedded = (Artworks_Embedded) in.readValue(Artworks_Embedded.class.getClassLoader());
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
        dest.writeString(title);
        dest.writeString(category);
        dest.writeString(medium);
        dest.writeString(date);
        dest.writeValue(dimensions);
        if (published == null) {
            dest.writeByte((byte) (0x02));
        } else {
            dest.writeByte((byte) (published ? 0x01 : 0x00));
        }
        dest.writeString(website);
        dest.writeString(signature);
        dest.writeValue(series);
        dest.writeString(provenance);
        dest.writeString(literature);
        dest.writeString(exhibitionHistory);
        dest.writeString(collectingInstitution);
        dest.writeString(additionalInformation);
        dest.writeString(imageRights);
        dest.writeString(blurb);
        if (unique == null) {
            dest.writeByte((byte) (0x02));
        } else {
            dest.writeByte((byte) (unique ? 0x01 : 0x00));
        }
        dest.writeValue(culturalMaker);
        if (iconicity == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeDouble(iconicity);
        }
        if (canInquire == null) {
            dest.writeByte((byte) (0x02));
        } else {
            dest.writeByte((byte) (canInquire ? 0x01 : 0x00));
        }
        if (canAcquire == null) {
            dest.writeByte((byte) (0x02));
        } else {
            dest.writeByte((byte) (canAcquire ? 0x01 : 0x00));
        }
        if (canShare == null) {
            dest.writeByte((byte) (0x02));
        } else {
            dest.writeByte((byte) (canShare ? 0x01 : 0x00));
        }
        dest.writeValue(saleMessage);
        if (sold == null) {
            dest.writeByte((byte) (0x02));
        } else {
            dest.writeByte((byte) (sold ? 0x01 : 0x00));
        }
        if (imageVersions == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(imageVersions);
        }
        dest.writeValue(links);
        dest.writeValue(embedded);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Artwork> CREATOR = new Parcelable.Creator<Artwork>() {
        @Override
        public Artwork createFromParcel(Parcel in) {
            return new Artwork(in);
        }

        @Override
        public Artwork[] newArray(int size) {
            return new Artwork[size];
        }
    };
}