
package com.prj1.stand.artworldviewer.model.artists;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Links_ implements Parcelable
{

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
    @SerializedName("similar_artists")
    @Expose
    private SimilarArtists similarArtists;
    @SerializedName("similar_contemporary_artists")
    @Expose
    private SimilarContemporaryArtists similarContemporaryArtists;
    @SerializedName("genes")
    @Expose
    private Genes genes;
    @SerializedName("thumbnail")
    @Expose
    private Thumbnail thumbnail;
    @SerializedName("image")
    @Expose
    private Image image;
    public final static Parcelable.Creator<Links_> CREATOR = new Creator<Links_>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Links_ createFromParcel(Parcel in) {
            Links_ instance = new Links_();
            instance.self = ((Self_) in.readValue((Self_.class.getClassLoader())));
            instance.permalink = ((Permalink) in.readValue((Permalink.class.getClassLoader())));
            instance.artworks = ((Artworks) in.readValue((Artworks.class.getClassLoader())));
            instance.publishedArtworks = ((PublishedArtworks) in.readValue((PublishedArtworks.class.getClassLoader())));
            instance.similarArtists = ((SimilarArtists) in.readValue((SimilarArtists.class.getClassLoader())));
            instance.similarContemporaryArtists = ((SimilarContemporaryArtists) in.readValue((SimilarContemporaryArtists.class.getClassLoader())));
            instance.genes = ((Genes) in.readValue((Genes.class.getClassLoader())));
            instance.thumbnail = ((Thumbnail) in.readValue((Thumbnail.class.getClassLoader())));
            instance.image = ((Image) in.readValue((Image.class.getClassLoader())));
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
     * @param thumbnail
     * @param artworks
     * @param permalink
     * @param genes
     * @param image
     * @param self
     * @param similarArtists
     * @param similarContemporaryArtists
     */
    public Links_(Self_ self, Permalink permalink, Artworks artworks, PublishedArtworks publishedArtworks, SimilarArtists similarArtists, SimilarContemporaryArtists similarContemporaryArtists, Genes genes, Thumbnail thumbnail, Image image) {
        super();
        this.self = self;
        this.permalink = permalink;
        this.artworks = artworks;
        this.publishedArtworks = publishedArtworks;
        this.similarArtists = similarArtists;
        this.similarContemporaryArtists = similarContemporaryArtists;
        this.genes = genes;
        this.thumbnail = thumbnail;
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

    public SimilarArtists getSimilarArtists() {
        return similarArtists;
    }

    public void setSimilarArtists(SimilarArtists similarArtists) {
        this.similarArtists = similarArtists;
    }

    public SimilarContemporaryArtists getSimilarContemporaryArtists() {
        return similarContemporaryArtists;
    }

    public void setSimilarContemporaryArtists(SimilarContemporaryArtists similarContemporaryArtists) {
        this.similarContemporaryArtists = similarContemporaryArtists;
    }

    public Genes getGenes() {
        return genes;
    }

    public void setGenes(Genes genes) {
        this.genes = genes;
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

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(self);
        dest.writeValue(permalink);
        dest.writeValue(artworks);
        dest.writeValue(publishedArtworks);
        dest.writeValue(similarArtists);
        dest.writeValue(similarContemporaryArtists);
        dest.writeValue(genes);
        dest.writeValue(thumbnail);
        dest.writeValue(image);
    }

    public int describeContents() {
        return  0;
    }

}
