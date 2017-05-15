
package com.prj1.stand.artworldviewer.model.artworks;

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
    public final static Parcelable.Creator<Links_> CREATOR = new Creator<Links_>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Links_ createFromParcel(Parcel in) {
            Links_ instance = new Links_();
            instance.thumbnail = ((Thumbnail) in.readValue((Thumbnail.class.getClassLoader())));
            instance.image = ((Image) in.readValue((Image.class.getClassLoader())));
            instance.partner = ((Partner) in.readValue((Partner.class.getClassLoader())));
            instance.self = ((Self_) in.readValue((Self_.class.getClassLoader())));
            instance.permalink = ((Permalink) in.readValue((Permalink.class.getClassLoader())));
            instance.genes = ((Genes) in.readValue((Genes.class.getClassLoader())));
            instance.artists = ((Artists) in.readValue((Artists.class.getClassLoader())));
            instance.similarArtworks = ((SimilarArtworks) in.readValue((SimilarArtworks.class.getClassLoader())));
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
     * @param artists
     * @param thumbnail
     * @param permalink
     * @param genes
     * @param image
     * @param self
     * @param partner
     * @param similarArtworks
     */
    public Links_(Thumbnail thumbnail, Image image, Partner partner, Self_ self, Permalink permalink, Genes genes, Artists artists, SimilarArtworks similarArtworks) {
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

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
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

    public Genes getGenes() {
        return genes;
    }

    public void setGenes(Genes genes) {
        this.genes = genes;
    }

    public Artists getArtists() {
        return artists;
    }

    public void setArtists(Artists artists) {
        this.artists = artists;
    }

    public SimilarArtworks getSimilarArtworks() {
        return similarArtworks;
    }

    public void setSimilarArtworks(SimilarArtworks similarArtworks) {
        this.similarArtworks = similarArtworks;
    }

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

    public int describeContents() {
        return  0;
    }

}
