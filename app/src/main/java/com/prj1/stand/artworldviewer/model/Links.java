package com.prj1.stand.artworldviewer.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Links implements Parcelable {

    @SerializedName("self")
    @Expose
    private Self self;
    @SerializedName("next")
    @Expose
    private Next next;

    /**
     * No args constructor for use in serialization
     *
     */
    public Links() {
    }

    /**
     *
     * @param next
     * @param self
     */
    public Links(Self self, Next next) {
        super();
        this.self = self;
        this.next = next;
    }

    public Self getSelf() {
        return self;
    }

    public void setSelf(Self self) {
        this.self = self;
    }

    public Links withSelf(Self self) {
        this.self = self;
        return this;
    }

    public Next getNext() {
        return next;
    }

    public void setNext(Next next) {
        this.next = next;
    }

    public Links withNext(Next next) {
        this.next = next;
        return this;
    }


    protected Links(Parcel in) {
        self = (Self) in.readValue(Self.class.getClassLoader());
        next = (Next) in.readValue(Next.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(self);
        dest.writeValue(next);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Links> CREATOR = new Parcelable.Creator<Links>() {
        @Override
        public Links createFromParcel(Parcel in) {
            return new Links(in);
        }

        @Override
        public Links[] newArray(int size) {
            return new Links[size];
        }
    };
}