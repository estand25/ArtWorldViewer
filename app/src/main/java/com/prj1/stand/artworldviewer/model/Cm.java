
package com.prj1.stand.artworldviewer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cm {

    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("height")
    @Expose
    private Double height;
    @SerializedName("width")
    @Expose
    private Double width;
    @SerializedName("depth")
    @Expose
    private Object depth;
    @SerializedName("diameter")
    @Expose
    private Object diameter;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Cm() {
    }

    /**
     * 
     * @param diameter
     * @param text
     * @param height
     * @param width
     * @param depth
     */
    public Cm(String text, Double height, Double width, Object depth, Object diameter) {
        super();
        this.text = text;
        this.height = height;
        this.width = width;
        this.depth = depth;
        this.diameter = diameter;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Cm withText(String text) {
        this.text = text;
        return this;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Cm withHeight(Double height) {
        this.height = height;
        return this;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Cm withWidth(Double width) {
        this.width = width;
        return this;
    }

    public Object getDepth() {
        return depth;
    }

    public void setDepth(Object depth) {
        this.depth = depth;
    }

    public Cm withDepth(Object depth) {
        this.depth = depth;
        return this;
    }

    public Object getDiameter() {
        return diameter;
    }

    public void setDiameter(Object diameter) {
        this.diameter = diameter;
    }

    public Cm withDiameter(Object diameter) {
        this.diameter = diameter;
        return this;
    }

}
