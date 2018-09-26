package com.prj1.stand.artworldviewer.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.androidquery.AQuery;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.prj1.stand.artworldviewer.R;
import com.prj1.stand.artworldviewer.activity.CustonUI.TouchImageView;
import com.prj1.stand.artworldviewer.model.display_object.ArtworkCard;
import com.prj1.stand.artworldviewer.model.display_object.SectionHeader;

import net.idik.lib.slimadapter.SlimAdapter;
import net.idik.lib.slimadapter.SlimInjector;
import net.idik.lib.slimadapter.viewinjector.IViewInjector;

import java.util.ArrayList;
import java.util.List;

public class ImageDetailFragment extends Fragment {
	public static final String EXTRA_IMAGE_DETAIL = "image_detail";

	ImageView imageView;
	TextView artWorkTitle;
	TextView artCollInstit;
	TextView artAddInform;
	ImageButton closeButton;

	public ImageDetailFragment() {
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.v("ImageDetailFragment", "OnCreate");
	}
	
	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		Log.v("ImageDetailFragment", "onSaveInstanceState");
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		Log.v("ImageDetailFragment", "onCreateView");
		
		// Inflate the layout for this fragment
		final View rootView =  inflater.inflate(R.layout.item_image_details, container, false);

        artWorkTitle = (TextView) rootView.findViewById(R.id.image_title);
        artCollInstit = (TextView) rootView.findViewById(R.id.image_collection_Institution);
        artAddInform = (TextView) rootView.findViewById(R.id.image_additional_information);
        closeButton = (ImageButton) rootView.findViewById(R.id.btnImage_close);

		ArtworkCard artworkCard = this.getArguments().getParcelable(EXTRA_IMAGE_DETAIL);

		AQuery aq  = new AQuery(rootView);
		aq.id(R.id.pic_image).image(artworkCard.getAc_thumbnail()).visible();

		artWorkTitle.setText(artworkCard.getAc_title());
		artCollInstit.setText(artworkCard.getAc_collective_institution());
		artAddInform.setText(artworkCard.getAc_additional_information());

		closeButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				getActivity().finish();
			}
		});

		return rootView;
	}
}
