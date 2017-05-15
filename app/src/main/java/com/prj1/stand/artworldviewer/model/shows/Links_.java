
package com.prj1.stand.artworldviewer.model.shows;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Links_ implements Parcelable
{

    @SerializedName("thumbnail")
    @Expose
    private Thumbnail thumbnail;
    @SerializedName("image")
    @Expose
    private Image image;
    @SerializedName("self")
    @Expose
    private Self_ self;
    @SerializedName("permalink")
    @Expose
    private Permalink permalink;
    @SerializedName("partner")
    @Expose
    private Partner partner;
    @SerializedName("artworks")
    @Expose
    private Artworks artworks;
    public final static Parcelable.Creator<Links_> CREATOR = new Creator<Links_>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Links_ createFromParcel(Parcel in) {
            Links_ instance = new Links_();
            instance.thumbnail = ((Thumbnail) in.readValue((Thumbnail.class.getClassLoader())));
            instance.image = ((Image) in.readValue((Image.class.getClassLoader())));
            instance.self = ((Self_) in.readValue((Self_.class.getClassLoader())));
            instance.permalink = ((Permalink) in.readValue((Permalink.class.getClassLoader())));
            instance.partner = ((Partner) in.readValue((Partner.class.getClassLoader())));
            instance.artworks = ((Artworks) in.readValue((Artworks.class.getClassLoader())));
            return instance;
        }

        public Links_[] newArray(int size) {
            return (new Links_[size]);
        }

    }
    ;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Links_() {
    }

    /**
     * 
     * @param thumbnail
     * @param artworks
     * @param permalink
     * @param image
     * @param partner
     * @param self
     */
    public Links_(Thumbnail thumbnail, Image image, Self_ self, Permalink permalink, Partner partner, Artworks artworks) {
        super();
        this.thumbnail = thumbnail;
        this.image = image;
        this.self = self;
        this.permalink = permalink;
        this.partner = partner;
        this.artworks = artworks;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Self_ getSelf() {
        return self;
    }

    public void setSelf(Self_ self) {
        this.self = self;
    }

    public Permalink getPermalink() {
        return permalink;
    }

    public void setPermalink(Permalink permalink) {
        this.permalink = permalink;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }

    public Artworks getArtworks() {
        return artworks;
    }

    public void setArtworks(Artworks artworks) {
        this.artworks = artworks;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(thumbnail);
        dest.writeValue(image);
        dest.writeValue(self);
        dest.writeValue(permalink);
        dest.writeValue(partner);
        dest.writeValue(artworks);
    }

    public int describeContents() {
        return  0;
    }

}
