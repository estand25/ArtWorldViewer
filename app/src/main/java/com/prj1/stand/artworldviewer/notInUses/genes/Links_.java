
package com.prj1.stand.artworldviewer.notInUses.genes;

import android.os.Parcel;
import android.os.Parcelable;

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
    @SerializedName("artworks")
    @Expose
    private Artworks artworks;
    @SerializedName("published_artworks")
    @Expose
    private PublishedArtworks publishedArtworks;
    @SerializedName("artists")
    @Expose
    private Artists artists;
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
            instance.artworks = ((Artworks) in.readValue((Artworks.class.getClassLoader())));
            instance.publishedArtworks = ((PublishedArtworks) in.readValue((PublishedArtworks.class.getClassLoader())));
            instance.artists = ((Artists) in.readValue((Artists.class.getClassLoader())));
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
     * @param publishedArtworks
     * @param artists
     * @param thumbnail
     * @param artworks
     * @param permalink
     * @param image
     * @param self
     */
    public Links_(Thumbnail thumbnail, Image image, Self_ self, Permalink permalink, Artworks artworks, PublishedArtworks publishedArtworks, Artists artists) {
        super();
        this.thumbnail = thumbnail;
        this.image = image;
        this.self = self;
        this.permalink = permalink;
        this.artworks = artworks;
        this.publishedArtworks = publishedArtworks;
        this.artists = artists;
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

    public Artworks getArtworks() {
        return artworks;
    }

    public void setArtworks(Artworks artworks) {
        this.artworks = artworks;
    }

    public PublishedArtworks getPublishedArtworks() {
        return publishedArtworks;
    }

    public void setPublishedArtworks(PublishedArtworks publishedArtworks) {
        this.publishedArtworks = publishedArtworks;
    }

    public Artists getArtists() {
        return artists;
    }

    public void setArtists(Artists artists) {
        this.artists = artists;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(thumbnail);
        dest.writeValue(image);
        dest.writeValue(self);
        dest.writeValue(permalink);
        dest.writeValue(artworks);
        dest.writeValue(publishedArtworks);
        dest.writeValue(artists);
    }

    public int describeContents() {
        return  0;
    }

}
