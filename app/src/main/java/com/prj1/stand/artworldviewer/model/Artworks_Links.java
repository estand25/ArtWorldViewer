package com.prj1.stand.artworldviewer.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Artworks_Links implements Parcelable {

    @SerializedName("thumbnail")
    @Expose
    private Thumbnail thumbnail;
    @SerializedName("image")
    @Expose
    private Image image;
    @SerializedName("partner")
    @Expose
    private Partner partner;
    @SerializedName("self")
    @Expose
    private Self_ self;
    @SerializedName("permalink")
    @Expose
    private Permalink permalink;
    @SerializedName("genes")
    @Expose
    private Genes genes;
    @SerializedName("artists")
    @Expose
    private Artists artists;
    @SerializedName("similar_artworks")
    @Expose
    private SimilarArtworks similarArtworks;

    /**
     * No args constructor for use in serialization
     *
     */
    public Artworks_Links() {
    }

    /**
     *
     * @param artists
     * @param thumbnail
     * @param permalink
     * @param genes
     * @param image
     * @param self
     * @param partner
     * @param similarArtworks
     */
    public Artworks_Links(Thumbnail thumbnail, Image image, Partner partner, Self_ self, Permalink permalink, Genes genes, Artists artists, SimilarArtworks similarArtworks) {
        super();
        this.thumbnail = thumbnail;
        this.image = image;
        this.partner = partner;
        this.self = self;
        this.permalink = permalink;
        this.genes = genes;
        this.artists = artists;
        this.similarArtworks = similarArtworks;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Artworks_Links withThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
        return this;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Artworks_Links withImage(Image image) {
        this.image = image;
        return this;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }

    public Artworks_Links withPartner(Partner partner) {
        this.partner = partner;
        return this;
    }

    public Self_ getSelf() {
        return self;
    }

    public void setSelf(Self_ self) {
        this.self = self;
    }

    public Artworks_Links withSelf(Self_ self) {
        this.self = self;
        return this;
    }

    public Permalink getPermalink() {
        return permalink;
    }

    public void setPermalink(Permalink permalink) {
        this.permalink = permalink;
    }

    public Artworks_Links withPermalink(Permalink permalink) {
        this.permalink = permalink;
        return this;
    }

    public Genes getGenes() {
        return genes;
    }

    public void setGenes(Genes genes) {
        this.genes = genes;
    }

    public Artworks_Links withGenes(Genes genes) {
        this.genes = genes;
        return this;
    }

    public Artists getArtists() {
        return artists;
    }

    public void setArtists(Artists artists) {
        this.artists = artists;
    }

    public Artworks_Links withArtists(Artists artists) {
        this.artists = artists;
        return this;
    }

    public SimilarArtworks getSimilarArtworks() {
        return similarArtworks;
    }

    public void setSimilarArtworks(SimilarArtworks similarArtworks) {
        this.similarArtworks = similarArtworks;
    }

    public Artworks_Links withSimilarArtworks(SimilarArtworks similarArtworks) {
        this.similarArtworks = similarArtworks;
        return this;
    }


    protected Artworks_Links(Parcel in) {
        thumbnail = (Thumbnail) in.readValue(Thumbnail.class.getClassLoader());
        image = (Image) in.readValue(Image.class.getClassLoader());
        partner = (Partner) in.readValue(Partner.class.getClassLoader());
        self = (Self_) in.readValue(Self_.class.getClassLoader());
        permalink = (Permalink) in.readValue(Permalink.class.getClassLoader());
        genes = (Genes) in.readValue(Genes.class.getClassLoader());
        artists = (Artists) in.readValue(Artists.class.getClassLoader());
        similarArtworks = (SimilarArtworks) in.readValue(SimilarArtworks.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(thumbnail);
        dest.writeValue(image);
        dest.writeValue(partner);
        dest.writeValue(self);
        dest.writeValue(permalink);
        dest.writeValue(genes);
        dest.writeValue(artists);
        dest.writeValue(similarArtworks);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Artworks_Links> CREATOR = new Parcelable.Creator<Artworks_Links>() {
        @Override
        public Artworks_Links createFromParcel(Parcel in) {
            return new Artworks_Links(in);
        }

        @Override
        public Artworks_Links[] newArray(int size) {
            return new Artworks_Links[size];
        }
    };
}