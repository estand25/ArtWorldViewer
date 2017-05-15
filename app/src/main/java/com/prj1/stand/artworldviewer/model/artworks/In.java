
package com.prj1.stand.artworldviewer.model.artworks;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class In implements Parcelable
{

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
    public final static Parcelable.Creator<In> CREATOR = new Creator<In>() {


        @SuppressWarnings({
            "unchecked"
        })
        public In createFromParcel(Parcel in) {
            In instance = new In();
            instance.text = ((String) in.readValue((String.class.getClassLoader())));
            instance.height = ((Double) in.readValue((Double.class.getClassLoader())));
            instance.width = ((Double) in.readValue((Double.class.getClassLoader())));
            instance.depth = ((Object) in.readValue((Object.class.getClassLoader())));
            instance.diameter = ((Object) in.readValue((Object.class.getClassLoader())));
            return instance;
        }

        public In[] newArray(int size) {
            return (new In[size]);
        }

    }
    ;

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
    public In(String text, Double height, Double width, Object depth, Object diameter) {
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

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Object getDepth() {
        return depth;
    }

    public void setDepth(Object depth) {
        this.depth = depth;
    }

    public Object getDiameter() {
        return diameter;
    }

    public void setDiameter(Object diameter) {
        this.diameter = diameter;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(text);
        dest.writeValue(height);
        dest.writeValue(width);
        dest.writeValue(depth);
        dest.writeValue(diameter);
    }

    public int describeContents() {
        return  0;
    }

}
