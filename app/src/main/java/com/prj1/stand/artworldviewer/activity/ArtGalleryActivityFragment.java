package com.prj1.stand.artworldviewer.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.androidquery.AQuery;
import com.prj1.stand.artworldviewer.R;
import com.prj1.stand.artworldviewer.constants.Constants;
import com.prj1.stand.artworldviewer.data.DbContract;
import com.prj1.stand.artworldviewer.model.display_object.ArtworkCard;
import com.prj1.stand.artworldviewer.model.display_object.SectionHeader;

import net.idik.lib.slimadapter.SlimAdapter;
import net.idik.lib.slimadapter.SlimInjector;
import net.idik.lib.slimadapter.viewinjector.IViewInjector;

import com.prj1.stand.artworldviewer.utilities.LastSelectionGalleryType;
import com.prj1.stand.artworldviewer.utilities.Utility;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class ArtGalleryActivityFragment extends Fragment {
    public SwipeRefreshLayout mSwipeRefreshLayout;
    List<Object> data = new ArrayList<>();
    RecyclerView recyclerView;
    private SlimAdapter slimAdapter;
    private EditText pageNumber;
    
    private BroadcastReceiver imageReceiver;
    
    public ArtGalleryActivityFragment() {
    }
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v("ArtGActivityFragment", "OnCreate");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.v("ArtGActivityFragment", "onSaveInstanceState");
        Log.v("ArtGActivityFragment", LastSelectionGalleryType.getInstance().getStringKey());
        Log.v("ArtGActivityFragment", Utility.getPreferredGalleryType(getContext()));
        
        // Check if LastActivity is SettingActivity then refresh
        if(!LastSelectionGalleryType.getInstance().getStringKey().equals(Utility.getPreferredGalleryType(getContext()))){
            
            //  Set the Last Gallery Type String
            LastSelectionGalleryType.getInstance().setStringKey(Utility.getPreferredGalleryType(getContext()));
            
            //  Retrieve the artwork - All for now
            retrieveArtwork(250);
            
            // Re-inflate the slimAdapter with the different possible xml activities
            inflateSlimAdapter();
        }
	}
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.v("ArtGActivityFragment", "onCreateView");
        
        // Inflate all the items on the fragment_art_gallery
        View rootView = inflater.inflate(R.layout.fragment_art_gallery, container, false);
         
        // Connect the local recycleView with the xml element on the current activity
        recyclerView = (RecyclerView)rootView.findViewById(R.id.recycler_view);
        
        // Create object to handle the layout of the recycleView with the current context
        // and the number of columns
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        
        // Detail the gridlayout per slimAdapter item
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return slimAdapter.getItem(position) instanceof ArtworkCard ? 1 :3;
            }
        });
        
        // Attach the layout manager to the recycleView
        recyclerView.setLayoutManager(gridLayoutManager);
        
        // Get the artwork data from the db
        retrieveArtwork(250);
        
        // Populate the slimAdapter sections with custom object data
        // then display to screen after everything is updated
        inflateSlimAdapter();
        
        // Find the SwipeRefreshLayout and associate to local one
        mSwipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.mainFragment_swipe_refresh_layout);
	    
        // Set-up the SwipeRefreshLayout color order
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorBlack,R.color.colorGray,R.color.colorDarkGray);
        
        // Set-up the SwipeRefreshLayout pull-down response
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                retrieveArtwork(250);
                inflateSlimAdapter();
            }
        });
        
        return rootView;
    }
    
    @Override
    public void onResume() {
        super.onResume();
        Log.v("ArtGActivityFragment", "onResume");

        // Create IntentFilter for the main activity
        IntentFilter imageFilter = new IntentFilter("android.intent.action.MAIN");

        // Set local BroadcastReceiver to new instance of the BroadcastReceiver
        // then goes to onReceive to refresh the screen if other service has completed
        imageReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
	            Log.v("ArtGActivityFragment","onReceive possible reload location");
                String completed_loader = intent.getStringExtra(Constants.IMAGE_LOADER);

	            if(!completed_loader.isEmpty()){
                    refresh();
	            }
            }
        };

        // registering our receiver
        this.getContext().registerReceiver(imageReceiver,imageFilter);


        refresh();
    }
    
    @Override
    public void onPause() {
        super.onPause();
        Log.v("ArtGActivityFragment", "onPause");

        // unregister our receiver after we done using
        this.getContext().unregisterReceiver(imageReceiver);
    }
    
    /**
     * Refresh the screen after the artwork is loaded
     */
    public void refresh(){
        retrieveArtwork();
        inflateSlimAdapter();
    }
    
    /**
     * Retrieved the artwork information from the local db with a build in delay
     * @param delay - Amount to delay retrieving the artwork
     */
    public void retrieveArtwork(int delay){
        Log.v("ArtGActivityFragment", "refresh");
        
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                retrieveArtwork();
            }
        },delay);
    }
    
    /**
     * On rotating the screen re-display the shown
     */
    public void onArtworkChanged(){
        Log.v("ArtGActivityFragment", "onArtworkChanged");
        retrieveArtwork(1);
        slimAdapter.updateData(data).attachTo(recyclerView);
    }
    
    /**
     * Retrieved the artwork information from the local db
     */
    public void retrieveArtwork(){
        // Clear the List<Object>
        data.clear();
    
        // Add the header to the List<Object>
        data.add(new SectionHeader("Artwork"));
    
        // Retrieve all the artwork - get additional information about the artwork as necessary
        // then add the artwork object into the data List<Object> for display
        Cursor artwork_cursor= getContext().getContentResolver().query(DbContract.ArtworkEntry.CONTENT_URI,
                null,
                null,
                null,
                null);
    
        if(artwork_cursor.getCount() >= 1){
            while(artwork_cursor.moveToNext()){
                Cursor image_version_Cursor = getContext().getContentResolver().query(
                        DbContract.LinkEntry.buildLinkDetailUri(artwork_cursor.getString(29)),
                        null,
                        null,
                        null,
                        null);
            
                ArrayList<String>  image_version_list = new ArrayList<String>();
                ArrayList<String>  image_list = new ArrayList<String>();
            
                if(image_version_Cursor.getCount() >= 1) {
                    while (image_version_Cursor.moveToNext()) {
                        image_version_list.add(image_version_Cursor.getPosition(), image_version_Cursor.getString(4));
                        image_list.add(image_version_Cursor.getPosition(), image_version_Cursor.getString(3));
                    }
                }
                image_version_Cursor.close();
            
                Cursor thumbnail_Cursor = getContext().getContentResolver().query(
                        DbContract.ArtworkEntry.buildArtworkThumbnail(artwork_cursor.getString(1)),
                        null,
                        null,
                        null,
                        null);
            
                String thumbnail = null;
            
                if(thumbnail_Cursor.getCount() >= 1){
                    while(thumbnail_Cursor.moveToNext()){
                        thumbnail = thumbnail_Cursor.getString(1);
                    }
                }
                thumbnail_Cursor.close();
            
                data.add(new ArtworkCard(artwork_cursor.getString(5),
                        image_list,
                        artwork_cursor.getString(2),
                        artwork_cursor.getString(6),
                        artwork_cursor.getString(7),
                        artwork_cursor.getString(8),
                        artwork_cursor.getString(11),
                        artwork_cursor.getString(16),
                        artwork_cursor.getString(17),
                        artwork_cursor.getString(18),
                        image_version_list,
                        thumbnail));
            }
            artwork_cursor.close();
        }
    
        // Show the progress of the refresh per the color scheme above
        mSwipeRefreshLayout.setRefreshing(false);
    }
    
    /**
     * Inflate the individual sections of the screen with data to display
     */
    public void inflateSlimAdapter() {
        slimAdapter = SlimAdapter.create()
                .register(R.layout.item_artwork, new SlimInjector<ArtworkCard>() {
                    @Override
                    public void onInject(final ArtworkCard data, IViewInjector injector) {
                        injector.with(R.id.cover, new IViewInjector.Action() {
                            @Override
                            public void action(View view) {
                                AQuery aq = new AQuery(view);
                                aq.id(view.getId()).image(data.getAc_thumbnail()).visible();
                            }
                        }).clicked(R.id.cover, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Log.v("clicked","Title: "+data.getAc_title() +" URL Link: "+data.getAc_thumbnail());
                                Log.v("clicked","LastSelectionGalleryType: " + LastSelectionGalleryType.getInstance().getStringKey());
                            
                                if(LastSelectionGalleryType.getInstance().getStringKey().equals("gallery+")) {
                                    Log.v("clicked", "Image View");
                                    Intent singleImageIntent = new Intent(v.getContext(),ImageActivity.class);
                                    singleImageIntent.putExtra(ImageActivity.EXTRA_IMAGE,data);
                                    startActivity(singleImageIntent);
                                }
                                else {
                                    Log.v("clicked", "Image SlideView");
                                    Intent singleImageIntent = new Intent(v.getContext(),GalleryActivity.class);
                                    singleImageIntent.putExtra(GalleryActivity.EXTRA_GALLERY,data);
                                    startActivity(singleImageIntent);
                                }
                            }
                        });
                    }
                })
                .register(R.layout.item_section_header, new SlimInjector<SectionHeader>() {
                    @Override
                    public void onInject(SectionHeader data, final IViewInjector injector) {
                        injector.text(R.id.section_title, data.getTitle())
                                .text(R.id.displayOption, Utility.getPreferredGalleryType(getContext()))
                                .with(R.id.page_number, new IViewInjector.Action() {
                                    @Override
                                    public void action(View view) {
                                        pageNumber = (EditText) injector.findViewById(R.id.page_number);
                                        pageNumber.setShowSoftInputOnFocus(false);
                                        pageNumber.setClickable(false);
                                        pageNumber.setText(Integer.toString(0));
                                    }
                                })
                                .clicked(R.id.left_imageButton, new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        pageNumber = (EditText) injector.findViewById(R.id.page_number);
                                        int currentNum = Integer.parseInt(pageNumber.getText().toString());
                                        int addNum;
                                        if(currentNum <= 0)
                                        {
                                            addNum = 0;
                                        }
                                        else {
                                            addNum = currentNum-1;
                                        }
                                        pageNumber.setText(Integer.toString(addNum));
                                    }
                                })
                                .clicked(R.id.right_imageButton, new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        pageNumber = (EditText) injector.findViewById(R.id.page_number);
                                        int currentNum = Integer.parseInt(pageNumber.getText().toString());
                                        int addNum = currentNum+1;
                                        pageNumber.setText(Integer.toString(addNum));
                                    }
                                });
                    }
                })
                .enableDiff()
                .attachTo(recyclerView);
    
        // Added the recycleView to the slimAdapter with updated data
        slimAdapter.updateData(data).attachTo(recyclerView);
    }

}
