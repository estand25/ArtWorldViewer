
package com.prj1.stand.artworldviewer.model;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Editions_Embedded {

    @SerializedName("editions")
    @Expose
    private List<Object> editions = new ArrayList<Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Editions_Embedded() {
    }

    /**
     * 
     * @param editions
     */
    public Editions_Embedded(List<Object> editions) {
        super();
        this.editions = editions;
    }

    public List<Object> getEditions() {
        return editions;
    }

    public void setEditions(List<Object> editions) {
        this.editions = editions;
    }

    public Editions_Embedded withEditions(List<Object> editions) {
        this.editions = editions;
        return this;
    }

}
