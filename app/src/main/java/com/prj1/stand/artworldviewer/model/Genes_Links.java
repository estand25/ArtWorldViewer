
package com.prj1.stand.artworldviewer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Genes_Links {

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

    /**
     * No args constructor for use in serialization
     * 
     */
    public Genes_Links() {
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
    public Genes_Links(Thumbnail thumbnail, Image image, Self_ self, Permalink permalink, Artworks artworks, PublishedArtworks publishedArtworks, Artists artists) {
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

    public Genes_Links withThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
        return this;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Genes_Links withImage(Image image) {
        this.image = image;
        return this;
    }

    public Self_ getSelf() {
        return self;
    }

    public void setSelf(Self_ self) {
        this.self = self;
    }

    public Genes_Links withSelf(Self_ self) {
        this.self = self;
        return this;
    }

    public Permalink getPermalink() {
        return permalink;
    }

    public void setPermalink(Permalink permalink) {
        this.permalink = permalink;
    }

    public Genes_Links withPermalink(Permalink permalink) {
        this.permalink = permalink;
        return this;
    }

    public Artworks getArtworks() {
        return artworks;
    }

    public void setArtworks(Artworks artworks) {
        this.artworks = artworks;
    }

    public Genes_Links withArtworks(Artworks artworks) {
        this.artworks = artworks;
        return this;
    }

    public PublishedArtworks getPublishedArtworks() {
        return publishedArtworks;
    }

    public void setPublishedArtworks(PublishedArtworks publishedArtworks) {
        this.publishedArtworks = publishedArtworks;
    }

    public Genes_Links withPublishedArtworks(PublishedArtworks publishedArtworks) {
        this.publishedArtworks = publishedArtworks;
        return this;
    }

    public Artists getArtists() {
        return artists;
    }

    public void setArtists(Artists artists) {
        this.artists = artists;
    }

    public Genes_Links withArtists(Artists artists) {
        this.artists = artists;
        return this;
    }

}
