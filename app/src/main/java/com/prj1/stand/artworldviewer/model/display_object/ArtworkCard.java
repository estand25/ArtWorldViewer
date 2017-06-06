package com.prj1.stand.artworldviewer.model.display_object;

import java.util.List;
import java.util.ArrayList;
import android.os.Parcelable;
import android.os.Parcel;

/**
 * Display class used in the recycle view for display
 *
 * Created by Stand on 5/31/2017.
 */

public class ArtworkCard implements Parcelable {
	private String ac_title;
	private ArrayList<String>   ac_imageHref;
	private String ac_slug;
	private String ac_category;
	private String ac_medium;
	private String ac_date;
	private String ac_website;
	private String ac_collective_institution;
	private String ac_additional_information;
	private String ac_image_rights;
	private ArrayList<String>  ac_image_version;
	private String ac_thumbnail;
	
	
	public ArtworkCard(String title, ArrayList<String> image, String slug, String category, String medium, String date,
	                   String website, String collective_institution, String additional_information, String image_right,
	                   ArrayList<String> image_version, String thumbnail){
		ac_title = title;
		ac_imageHref = image;
		ac_slug = slug;
		ac_category = category;
		ac_medium = medium;
		ac_date = date;
		ac_website = website;
		ac_collective_institution = collective_institution;
		ac_additional_information = additional_information;
		ac_image_rights = image_right;
		ac_image_version = image_version;
		ac_thumbnail = thumbnail;
	}
	
	public String getAc_title() {
		return ac_title;
	}
	
	public ArrayList<String>  getAc_imageHref() {
		return ac_imageHref;
	}
	
	public String getAc_slug() {
		return ac_slug;
	}
	
	public String getAc_category() {
		return ac_category;
	}
	
	public String getAc_medium() {
		return ac_medium;
	}
	
	public String getAc_date() {
		return ac_date;
	}
	
	public String getAc_website() {
		return ac_website;
	}
	
	public String getAc_collective_institution() {
		return ac_collective_institution;
	}
	
	public String getAc_additional_information() {
		return ac_additional_information;
	}
	
	public String getAc_image_rights() {
		return ac_image_rights;
	}
	
	public ArrayList<String>  getAc_image_version() {
		return ac_image_version;
	}
	
	public String getAc_thumbnail() {
		return ac_thumbnail;
	}
	
	
	protected ArtworkCard(Parcel in) {
		ac_title = in.readString();
		if (in.readByte() == 0x01) {
			ac_imageHref = new ArrayList<String>();
			in.readList(ac_imageHref, String.class.getClassLoader());
		} else {
			ac_imageHref = null;
		}
		ac_slug = in.readString();
		ac_category = in.readString();
		ac_medium = in.readString();
		ac_date = in.readString();
		ac_website = in.readString();
		ac_collective_institution = in.readString();
		ac_additional_information = in.readString();
		ac_image_rights = in.readString();
		if (in.readByte() == 0x01) {
			ac_image_version = new ArrayList<String>();
			in.readList(ac_image_version, String.class.getClassLoader());
		} else {
			ac_image_version = null;
		}
		ac_thumbnail = in.readString();
	}
	
	@Override
	public int describeContents() {
		return 0;
	}
	
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(ac_title);
		if (ac_imageHref == null) {
			dest.writeByte((byte) (0x00));
		} else {
			dest.writeByte((byte) (0x01));
			dest.writeList(ac_imageHref);
		}
		dest.writeString(ac_slug);
		dest.writeString(ac_category);
		dest.writeString(ac_medium);
		dest.writeString(ac_date);
		dest.writeString(ac_website);
		dest.writeString(ac_collective_institution);
		dest.writeString(ac_additional_information);
		dest.writeString(ac_image_rights);
		if (ac_image_version == null) {
			dest.writeByte((byte) (0x00));
		} else {
			dest.writeByte((byte) (0x01));
			dest.writeList(ac_image_version);
		}
		dest.writeString(ac_thumbnail);
	}
	
	@SuppressWarnings("unused")
	public static final Parcelable.Creator<ArtworkCard> CREATOR = new Parcelable.Creator<ArtworkCard>() {
		@Override
		public ArtworkCard createFromParcel(Parcel in) {
			return new ArtworkCard(in);
		}
		
		@Override
		public ArtworkCard[] newArray(int size) {
			return new ArtworkCard[size];
		}
	};
}