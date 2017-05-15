
package com.prj1.stand.artworldviewer.model.authorization;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Links implements Parcelable
{

    public final static Parcelable.Creator<Links> CREATOR = new Creator<Links>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Links createFromParcel(Parcel in) {
            Links instance = new Links();
            return instance;
        }

        public Links[] newArray(int size) {
            return (new Links[size]);
        }

    }
    ;

    public void writeToParcel(Parcel dest, int flags) {
    }

    public int describeContents() {
        return  0;
    }

}
