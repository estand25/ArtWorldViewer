package com.prj1.stand.artworldviewer.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Dimensions implements Parcelable {

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


    protected Dimensions(Parcel an) {
        in = (In) an.readValue(In.class.getClassLoader());
        cm = (Cm) an.readValue(Cm.class.getClassLoader());
    }

    @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeValue(in);
            dest.writeValue(cm);
        }

        @SuppressWarnings("unused")
        public static final Parcelable.Creator<Dimensions> CREATOR = new Parcelable.Creator<Dimensions>() {
            @Override
            public Dimensions createFromParcel(Parcel in) {
                return new Dimensions(in);
        }

        @Override
        public Dimensions[] newArray(int size) {
            return new Dimensions[size];
        }
    };
}