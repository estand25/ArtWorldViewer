package com.prj1.stand.artworldviewer.activity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.androidquery.AQuery;
import com.prj1.stand.artworldviewer.R;
import com.prj1.stand.artworldviewer.data.DbContract;
import com.prj1.stand.artworldviewer.model.display_object.ArtworkCard;
import com.prj1.stand.artworldviewer.model.display_object.SectionHeader;

import net.idik.lib.slimadapter.SlimAdapter;
import net.idik.lib.slimadapter.SlimInjector;
import net.idik.lib.slimadapter.viewinjector.IViewInjector;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
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
    private Spinner spinner;
    
    public ArtGalleryActivityFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v("ArtGActivityFragment", "OnCreate");
        refresh();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.v("ArtGActivityFragment", "onSaveInstanceState");
	    
	}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.v("ArtGActivityFragment", "onCreateView");
        // Inflate all the items on the fragment_art_gallery
        View rootView = inflater.inflate(R.layout.fragment_art_gallery, container, false);
        
        recyclerView = (RecyclerView)rootView.findViewById(R.id.recycler_view);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return slimAdapter.getItem(position) instanceof ArtworkCard ? 1 :3;
            }
        });
        
        recyclerView.setLayoutManager(gridLayoutManager);
        
        slimAdapter = SlimAdapter.createEx()
                .register(R.layout.item_artwork, new SlimInjector<ArtworkCard>() {
                    @Override
                    public void onInject(final ArtworkCard data, IViewInjector injector) {
                        injector.with(R.id.cover, new IViewInjector.Action() {
                            @Override
                            public void action(View view) {
                                AQuery aq = new AQuery(view);
                                aq.id(view.getId()).image(data.getAc_image()).visible();
                            }
                        }).clicked(R.id.cover, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Log.v("clicked","Title: "+data.getAc_description() +" URL Link: "+data.getAc_image());
                                
                                //ArrayList<String> image = new ArrayList<String>();
                                //image.add("https://d32dm0rphc51dk.cloudfront.net/NOpIAwQa-3r51Cg9qXKbfA/medium.jpg");
                                //image.add("https://d32dm0rphc51dk.cloudfront.net/NOpIAwQa-3r51Cg9qXKbfA/medium.jpg");
                                
                                //Intent singleImageIntent = new Intent(v.getContext(),ImageActivity.class);
                                //singleImageIntent.putExtra(ImageActivity.EXTRA_IMAGE, data.getAc_image());
                                //singleImageIntent.putExtra(ImageActivity.EXTRA_DESCRIPTION, data.getAc_description());
                                //singleImageIntent.putStringArrayListExtra(ImageActivity.EXTRA_IMAGE,image);
                                //v.getContext().startActivity(singleImageIntent);
                                
                                Intent sIntent = new Intent(v.getContext(),GalleryActivity.class);
                                sIntent.putExtra(GalleryActivity.EXTRA_IMAGE2, data.getAc_image());
                                sIntent.putExtra(GalleryActivity.EXTRA_TiTLE2, data.getAc_description());
                                v.getContext().startActivity(sIntent);
                            }
                        });
                    }
                })
                .register(R.layout.item_section_header, new SlimInjector<SectionHeader>() {
                    @Override
                    public void onInject(SectionHeader data, IViewInjector injector) {
                        injector.text(R.id.section_title, data.getTitle())
                                .with(R.id.displaySpinner, new IViewInjector.Action() {
                                    @Override
                                    public void action(View view) {
                                        List<String> list = new ArrayList<>();
                                        list.add("Gallery");
                                        list.add("Gallery+");
                                
                                        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(view.getContext(),
                                                android.R.layout.simple_spinner_item,list);
                                
                                        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                        spinner = (Spinner) view.findViewById(R.id.displaySpinner);
                                        spinner.setAdapter(spinnerAdapter);
                                    }
                                });
                    }
                })
                .enableDiff()
                .attachTo(recyclerView);
        slimAdapter.updateData(data);
        
        // Find the SwipeRefreshLayout and associate to local one
        mSwipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.mainFragment_swipe_refresh_layout);
	    
        // Set-up the SwipeRefreshLayout color order
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorBlack,R.color.colorGray,R.color.colorDarkGray);
        
        // Set-up the SwipeRefreshLayout pull-down response
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh();
                slimAdapter.updateData(data).attachTo(recyclerView);
            }
        });
        return rootView;
    }
    
    public void refresh(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                data.clear();
                data.add(new SectionHeader("Artwork"));
                Cursor artwork_cursor= getContext().getContentResolver().query(DbContract.ArtworkEntry.buildAllArtworkThumbnailSection(),
                        null,
                        null,
                        null,
                        null);
    
                if(artwork_cursor.getCount() >= 1){
                    while(artwork_cursor.moveToNext()){
                        data.add(new ArtworkCard(artwork_cursor.getString(1),artwork_cursor.getString(2)));
                        //Log.v("ArtGActivityFragment","Des: "+artwork_cursor.getString(1)+" URL image: "+artwork_cursor.getString(2));
                    }
                    artwork_cursor.close();
                }
                
                // Show the progress of the refresh per the color scheme above
                mSwipeRefreshLayout.setRefreshing(false);
            }
        },150);
    }
    
    public void startIndividualImageGallery(){
        ArrayList<String> imageIndividual = new ArrayList<String>();
        
        //Cursor image_cursor = getContext().getContentResolver().query(DbContract.ArtworkEntry.)
    }
}
