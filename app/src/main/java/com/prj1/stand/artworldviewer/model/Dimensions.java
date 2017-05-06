
package com.prj1.stand.artworldviewer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Dimensions {

    @SerializedName("in")
    @Expose
    private In in;
    @SerializedName("cm")
    @Expose
    private Cm cm;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Dimensions() {
    }

    /**
     * 
     * @param cm
     * @param in
     */
    public Dimensions(In in, Cm cm) {
        super();
        this.in = in;
        this.cm = cm;
    }

    public In getIn() {
        return in;
    }

    public void setIn(In in) {
        this.in = in;
    }

    public Dimensions withIn(In in) {
        this.in = in;
        return this;
    }

    public Cm getCm() {
        return cm;
    }

    public void setCm(Cm cm) {
        this.cm = cm;
    }

    public Dimensions withCm(Cm cm) {
        this.cm = cm;
        return this;
    }

}
