package com.prj1.stand.artworldviewer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Artists_Links {

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

    /**
     * No args constructor for use in serialization
     *
     */
    public Artists_Links() {
    }

    /**
     *
     * @param publishedArtworks
     * @param artworks
     * @param permalink
     * @param genes
     * @param self
     * @param similarArtists
     * @param similarContemporaryArtists
     */
    public Artists_Links(Self_ self, Permalink permalink, Artworks artworks, PublishedArtworks publishedArtworks, SimilarArtists similarArtists, SimilarContemporaryArtists similarContemporaryArtists, Genes genes) {
        super();
        this.self = self;
        this.permalink = permalink;
        this.artworks = artworks;
        this.publishedArtworks = publishedArtworks;
        this.similarArtists = similarArtists;
        this.similarContemporaryArtists = similarContemporaryArtists;
        this.genes = genes;
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

}