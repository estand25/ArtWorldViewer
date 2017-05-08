package com.prj1.stand.artworldviewer.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class In implements Parcelable {

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


    protected In(Parcel in) {
        text = in.readString();
        height = in.readByte() == 0x00 ? null : in.readInt();
        width = in.readByte() == 0x00 ? null : in.readInt();
        depth = (Object) in.readValue(Object.class.getClassLoader());
        diameter = (Object) in.readValue(Object.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(text);
        if (height == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(height);
        }
        if (width == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeInt(width);
        }
        dest.writeValue(depth);
        dest.writeValue(diameter);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<In> CREATOR = new Parcelable.Creator<In>() {
        @Override
        public In createFromParcel(Parcel in) {
            return new In(in);
        }

        @Override
        public In[] newArray(int size) {
            return new In[size];
        }
    };
}