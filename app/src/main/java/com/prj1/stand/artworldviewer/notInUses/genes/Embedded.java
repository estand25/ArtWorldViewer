
package com.prj1.stand.artworldviewer.notInUses.genes;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Embedded implements Parcelable
{

    @SerializedName("genes")
    @Expose
    private List<Gene> genes = null;
    public final static Parcelable.Creator<Embedded> CREATOR = new Creator<Embedded>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Embedded createFromParcel(Parcel in) {
            Embedded instance = new Embedded();
            in.readList(instance.genes, (Genes.class.getClassLoader()));
            return instance;
        }

        public Embedded[] newArray(int size) {
            return (new Embedded[size]);
        }

    }
    ;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Embedded() {
    }

    /**
     * 
     * @param genes
     */
    public Embedded(List<Gene> genes) {
        super();
        this.genes = genes;
    }

    public List<Gene> getGenes() {
        return genes;
    }

    public void setGenes(List<Gene> genes) {
        this.genes = genes;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(genes);
    }

    public int describeContents() {
        return  0;
    }

}
