
package com.prj1.stand.artworldviewer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class In {

    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("height")
    @Expose
    private Integer height;
    @SerializedName("width")
    @Expose
    private Integer width;
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
    public In() {
    }

    /**
     * 
     * @param diameter
     * @param text
     * @param height
     * @param width
     * @param depth
     */
    public In(String text, Integer height, Integer width, Object depth, Object diameter) {
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

    public In withText(String text) {
        this.text = text;
        return this;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public In withHeight(Integer height) {
        this.height = height;
        return this;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public In withWidth(Integer width) {
        this.width = width;
        return this;
    }

    public Object getDepth() {
        return depth;
    }

    public void setDepth(Object depth) {
        this.depth = depth;
    }

    public In withDepth(Object depth) {
        this.depth = depth;
        return this;
    }

    public Object getDiameter() {
        return diameter;
    }

    public void setDiameter(Object diameter) {
        this.diameter = diameter;
    }

    public In withDiameter(Object diameter) {
        this.diameter = diameter;
        return this;
    }

}
