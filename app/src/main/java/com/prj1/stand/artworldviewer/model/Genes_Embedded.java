package com.prj1.stand.artworldviewer.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Genes_Embedded implements Parcelable {

    @SerializedName("genes")
    @Expose
    private List<Gene> genes = new ArrayList<Gene>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Genes_Embedded() {
    }

    /**
     *
     * @param genes
     */
    public Genes_Embedded(List<Gene> genes) {
        super();
        this.genes = genes;
    }

    public List<Gene> getGenes() {
        return genes;
    }

    public void setGenes(List<Gene> genes) {
        this.genes = genes;
    }

    public Genes_Embedded withGenes(List<Gene> genes) {
        this.genes = genes;
        return this;
    }


    protected Genes_Embedded(Parcel in) {
        if (in.readByte() == 0x01) {
            genes = new ArrayList<Gene>();
            in.readList(genes, Gene.class.getClassLoader());
        } else {
            genes = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (genes == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(genes);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Genes_Embedded> CREATOR = new Parcelable.Creator<Genes_Embedded>() {
        @Override
        public Genes_Embedded createFromParcel(Parcel in) {
            return new Genes_Embedded(in);
        }

        @Override
        public Genes_Embedded[] newArray(int size) {
            return new Genes_Embedded[size];
        }
    };
}