package com.prj1.stand.artworldviewer.activity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.support.annotation.Dimension;
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
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.prj1.stand.artworldviewer.R;
import com.prj1.stand.artworldviewer.data.DbContract;
import com.prj1.stand.artworldviewer.data.DbProvider;
import com.prj1.stand.artworldviewer.model.artworks.Artists;
import com.prj1.stand.artworldviewer.model.artworks.Cm;
import com.prj1.stand.artworldviewer.model.artworks.Dimensions;
import com.prj1.stand.artworldviewer.model.artworks.Embedded;
import com.prj1.stand.artworldviewer.model.artworks.Genes;
import com.prj1.stand.artworldviewer.model.artworks.Image;
import com.prj1.stand.artworldviewer.model.artworks.In;
import com.prj1.stand.artworldviewer.model.artworks.Links;
import com.prj1.stand.artworldviewer.model.artworks.Links_;
import com.prj1.stand.artworldviewer.model.artworks.Partner;
import com.prj1.stand.artworldviewer.model.artworks.Permalink;
import com.prj1.stand.artworldviewer.model.artworks.Self_;
import com.prj1.stand.artworldviewer.model.artworks.SimilarArtworks;
import com.prj1.stand.artworldviewer.model.artworks.Thumbnail;
import com.prj1.stand.artworldviewer.model.display_object.ArtworkCard;
import com.prj1.stand.artworldviewer.model.display_object.SectionHeader;

import net.idik.lib.slimadapter.SlimAdapter;
import net.idik.lib.slimadapter.SlimInjector;
import net.idik.lib.slimadapter.viewinjector.IViewInjector;

import com.prj1.stand.artworldviewer.model.artworks.Artwork;
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
    private Spinner spinner;
    private ImageButton rightButton;
    private ImageButton leftButton;
    private EditText pageNumber;
    
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
        
        // Check if LastActivity is SettingActivity then refresh
        if(LastSelectionGalleryType.getInstance().getStringKey().equals(Utility.getPreferredGalleryType(getContext()))){
            
            //  Set the Last Gallery Type String
            LastSelectionGalleryType.getInstance().setStringKey(Utility.getPreferredGalleryType(getContext()));
            
            //  Refresh
            onArtworkChanged();
        }
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
                                aq.id(view.getId()).image(data.getAc_thumbnail()).visible();
                            }
                        }).clicked(R.id.cover, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Log.v("clicked","Title: "+data.getAc_title() +" URL Link: "+data.getAc_thumbnail());
                                
                                //Intent singleImageIntent = new Intent(v.getContext(),ImageActivity.class);
                                //singleImageIntent.putExtra(ImageActivity.EXTRA_IMAGE,data);
                                Intent singleImageIntent = new Intent(v.getContext(),GalleryActivity.class);
                                singleImageIntent.putExtra(GalleryActivity.EXTRA_GALLERY,data);
                                startActivity(singleImageIntent);
                            }
                        });
                    }
                })
                .register(R.layout.item_section_header, new SlimInjector<SectionHeader>() {
                    @Override
                    public void onInject(SectionHeader data, final IViewInjector injector) {
                        injector.text(R.id.section_title, data.getTitle())
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
                                        pageNumber = (EditText) injector.findViewById(R.id.page_number); //v.findViewById(R.id.page_number);
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
                                        pageNumber = (EditText) injector.findViewById(R.id.page_number); //v.findViewById(R.id.page_number);
                                        int currentNum = Integer.parseInt(pageNumber.getText().toString());
                                        int addNum = currentNum+1;
                                        pageNumber.setText(Integer.toString(addNum));
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
                        Image image = new Image("",false);
                        
                        if(image_version_Cursor.getCount() >= 1) {
                            while (image_version_Cursor.moveToNext()) {
                                image_version_list.add(image_version_Cursor.getPosition(), image_version_Cursor.getString(4));
                                image_list.add(image_version_Cursor.getPosition(), image_version_Cursor.getString(3));
                                
                                if(image_version_Cursor.getPosition() == 1) {
                                    image = new Image(image_version_Cursor.getString(5), false);
                                }
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
        },150);
    }
    
    public void onArtworkChanged(){
        refresh();
        slimAdapter.updateData(data).attachTo(recyclerView);
    }
}
