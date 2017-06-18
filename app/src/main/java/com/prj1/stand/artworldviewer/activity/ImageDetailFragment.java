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
	
	List<Object> imageInfoData = new ArrayList<>();
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
		
		ArtworkCard artworkCard = savedInstanceState.getParcelable(EXTRA_IMAGE_DETAIL);
		
		imageInfoData.add(new SectionHeader("Image Details"));
		imageInfoData.add(new ArtworkCard(artworkCard.getAc_title(),
				artworkCard.getAc_imageHref(),
				artworkCard.getAc_slug(),
				artworkCard.getAc_category(),
				artworkCard.getAc_medium(),
				artworkCard.getAc_date(),
				artworkCard.getAc_website(),
				artworkCard.getAc_collective_institution(),
				artworkCard.getAc_additional_information(),
				artworkCard.getAc_image_rights(),
				artworkCard.getAc_image_version(),
				artworkCard.getAc_thumbnail()));
		
		imageSlimAdpater = SlimAdapter.createEx()
				.register(R.layout.item_image_details, new SlimInjector<ArtworkCard>() {
					@Override
					public void onInject(final ArtworkCard data, IViewInjector injector) {
						injector.text(R.id.image_title,data.getAc_title())
								.text(R.id.image_collection_Institution, data.getAc_collective_institution())
								.text(R.id.image_additional_information, data.getAc_additional_information())
								.with(R.id.image, new IViewInjector.Action() {
									@Override
									public void action(View view) {
										
										Glide.with(getContext())
												.load(data.getAc_thumbnail())
												.asBitmap()
												.into(new SimpleTarget<Bitmap>() {
													@Override
													public void onResourceReady(Bitmap  bitmap, GlideAnimation anim) {
														touchImageView.setImageBitmap(bitmap);
													}
												});
									}
								})
								.clicked(R.id.btnImage_close, new View.OnClickListener() {
									@Override
									public void onClick(View v) {
										
									}
								});
					}
				})
				.enableDiff()
				.attachTo(imageRecycleView);
		
		
		imageSlimAdpater.updateData(imageInfoData).attachTo(imageRecycleView);
		return rootView;
	}
}
