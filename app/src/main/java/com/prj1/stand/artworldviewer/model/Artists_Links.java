package com.prj1.stand.artworldviewer.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Artists_Links implements Parcelable {

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


    protected Artists_Links(Parcel in) {
        self = (Self_) in.readValue(Self_.class.getClassLoader());
        permalink = (Permalink) in.readValue(Permalink.class.getClassLoader());
        artworks = (Artworks) in.readValue(Artworks.class.getClassLoader());
        publishedArtworks = (PublishedArtworks) in.readValue(PublishedArtworks.class.getClassLoader());
        similarArtists = (SimilarArtists) in.readValue(SimilarArtists.class.getClassLoader());
        similarContemporaryArtists = (SimilarContemporaryArtists) in.readValue(SimilarContemporaryArtists.class.getClassLoader());
        genes = (Genes) in.readValue(Genes.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(self);
        dest.writeValue(permalink);
        dest.writeValue(artworks);
        dest.writeValue(publishedArtworks);
        dest.writeValue(similarArtists);
        dest.writeValue(similarContemporaryArtists);
        dest.writeValue(genes);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Artists_Links> CREATOR = new Parcelable.Creator<Artists_Links>() {
        @Override
        public Artists_Links createFromParcel(Parcel in) {
            return new Artists_Links(in);
        }

        @Override
        public Artists_Links[] newArray(int size) {
            return new Artists_Links[size];
        }
    };
}