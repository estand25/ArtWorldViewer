package com.prj1.stand.artworldviewer.model;


import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Editions_Embedded implements Parcelable {

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


    protected Editions_Embedded(Parcel in) {
        if (in.readByte() == 0x01) {
            editions = new ArrayList<Object>();
            in.readList(editions, Object.class.getClassLoader());
        } else {
            editions = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (editions == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(editions);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Editions_Embedded> CREATOR = new Parcelable.Creator<Editions_Embedded>() {
        @Override
        public Editions_Embedded createFromParcel(Parcel in) {
            return new Editions_Embedded(in);
        }

        @Override
        public Editions_Embedded[] newArray(int size) {
            return new Editions_Embedded[size];
        }
    };
}