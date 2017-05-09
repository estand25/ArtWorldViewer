package com.prj1.stand.artworldviewer.model;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcelable;
import android.os.Parcel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Fairs_Embedded implements Parcelable {

    @SerializedName("fairs")
    @Expose
    private List<Fair> fairs = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Fairs_Embedded() {
    }

    /**
     * 
     * @param fairs
     */
    public Fairs_Embedded(List<Fair> fairs) {
        super();
        this.fairs = fairs;
    }

    public List<Fair> getFairs() {
        return fairs;
    }

    public void setFairs(List<Fair> fairs) {
        this.fairs = fairs;
    }


    protected Fairs_Embedded(Parcel in) {
        if (in.readByte() == 0x01) {
            fairs = new ArrayList<Fair>();
            in.readList(fairs, Fair.class.getClassLoader());
        } else {
            fairs = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (fairs == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(fairs);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Fairs_Embedded> CREATOR = new Parcelable.Creator<Fairs_Embedded>() {
        @Override
        public Fairs_Embedded createFromParcel(Parcel in) {
            return new Fairs_Embedded(in);
        }

        @Override
        public Fairs_Embedded[] newArray(int size) {
            return new Fairs_Embedded[size];
        }
    };
}