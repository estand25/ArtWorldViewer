package com.prj1.stand.artworldviewer.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
	
	RecyclerView imageRecycleView;
	SlimAdapter imageSlimAdpater;
	TouchImageView touchImageView;

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
		View rootView =  inflater.inflate(R.layout.fragment_image_detail, container, false);
		
		imageRecycleView = (RecyclerView) rootView.findViewById(R.id.image_recycler_view);

		ArtworkCard artworkCard = this.getArguments().getParcelable(EXTRA_IMAGE_DETAIL);

		return rootView;
	}
}
