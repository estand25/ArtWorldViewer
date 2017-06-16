package com.prj1.stand.artworldviewer.utilities;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Handles the individual pages of the display item
 *
 * Created by Stand on 6/14/2017.
 */

public class ArtPage implements Parcelable {
	private int pageOffset;
	private String pageSize;
	private String token;
	
	public ArtPage(int _offset, String _size, String _token){
		pageOffset = _offset;
		pageSize = _size;
		token = _token;
	}
	
	public int getpageOffset(){
		return pageOffset;
	}
	
	public String getPageSize() {
		return pageSize;
	}
	
	public String getToken() {
		return token;
	}
	
	protected ArtPage(Parcel in) {
		pageOffset = in.readInt();
		pageSize = in.readString();
		token = in.readString();;
	}
	
	@Override
	public int describeContents() {
		return 0;
	}
	
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(pageOffset);
		dest.writeString(pageSize);
		dest.writeString(token);
	}
	
	@SuppressWarnings("unused")
	public static final Parcelable.Creator<ArtPage> CREATOR = new Parcelable.Creator<ArtPage>() {
		@Override
		public ArtPage createFromParcel(Parcel in) {
			return new ArtPage(in);
		}
		
		@Override
		public ArtPage[] newArray(int size) {
			return new ArtPage[size];
		}
	};
}