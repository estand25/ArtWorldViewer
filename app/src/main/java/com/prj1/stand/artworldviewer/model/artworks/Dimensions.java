
package com.prj1.stand.artworldviewer.model.artworks;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Dimensions implements Parcelable
{

    @SerializedName("in")
    @Expose
    private In in;
    @SerializedName("cm")
    @Expose
    private Cm cm;
    public final static Parcelable.Creator<Dimensions> CREATOR = new Creator<Dimensions>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Dimensions createFromParcel(Parcel in) {
            Dimensions instance = new Dimensions();
            instance.in = ((In) in.readValue((In.class.getClassLoader())));
            instance.cm = ((Cm) in.readValue((Cm.class.getClassLoader())));
            return instance;
        }

        public Dimensions[] newArray(int size) {
            return (new Dimensions[size]);
        }

    }
    ;

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

    public Cm getCm() {
        return cm;
    }

    public void setCm(Cm cm) {
        this.cm = cm;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(in);
        dest.writeValue(cm);
    }

    public int describeContents() {
        return  0;
    }

}
