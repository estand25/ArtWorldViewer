
package com.prj1.stand.artworldviewer.model;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Genes_Embedded {

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

}
