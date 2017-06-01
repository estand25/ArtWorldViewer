package com.prj1.stand.artworldviewer.activity;

import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.prj1.stand.artworldviewer.R;
import com.prj1.stand.artworldviewer.activity.adapters.ArtworkAdapter;
import com.prj1.stand.artworldviewer.constants.Constants;
import com.prj1.stand.artworldviewer.data.DbContract;
import com.prj1.stand.artworldviewer.data.DbProvider;
import com.prj1.stand.artworldviewer.model.artworks.Artwork;
import com.prj1.stand.artworldviewer.model.display_object.ArtworkCard;
import com.prj1.stand.artworldviewer.model.display_object.SectionHeader;

import net.idik.lib.slimadapter.SlimAdapter;
import net.idik.lib.slimadapter.SlimInjector;
import net.idik.lib.slimadapter.ex.loadmore.SlimMoreLoader;
import net.idik.lib.slimadapter.viewinjector.IViewInjector;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * A placeholder fragment containing a simple view.
 */
public class ArtGalleryActivityFragment extends Fragment {
    public SwipeRefreshLayout mSwipeRefreshLayout;
    List<Object> data = new ArrayList<>();
    RecyclerView recyclerView;
    private SlimAdapter slimAdapter;
    
    public ArtGalleryActivityFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v("ArtGActivityFragment", "OnCreate");
    
        data.add(new SectionHeader("Artwork"));
        
        //DbContract.ArtworkEntry.buildAllArtworkThumbnailSection()
        Cursor artwork_cursor= getContext().getContentResolver().query(DbContract.ArtworkEntry.buildAllArtworkThumbnailSection(),
                null,
                null,
                null,
                null);
        try{
            if(artwork_cursor.getCount() >= 1){
                while(artwork_cursor.moveToNext()){
                    data.add(new ArtworkCard(artwork_cursor.getString(1),artwork_cursor.getString(2)));
                    Log.v("ArtGActivityFragment","Des: "+artwork_cursor.getString(1)+" URL image: "+artwork_cursor.getString(2));
                }
                artwork_cursor.close();
            }
        }catch (NullPointerException n){
            n.printStackTrace();
        }
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
                .addHeaderView(getContext(), R.layout.item_section_header)
                .register(R.layout.item_artwork, new SlimInjector<ArtworkCard>() {
                    @Override
                    public void onInject(ArtworkCard data, IViewInjector injector) {
                        injector.text(R.id.name, data.getAc_description())
                                .image(R.id.cover, data.getAc_image());
                    }
                })
                .register(R.layout.item_section_header, new SlimInjector<SectionHeader>() {
                    @Override
                    public void onInject(SectionHeader data, IViewInjector injector) {
                        injector.text(R.id.section_title, data.getTitle());
                    }
                })
                .enableDiff()
                .attachTo(recyclerView);
        slimAdapter.updateData(data);
        
        // Find the SwipeRefreshLayout and associate to local one
        mSwipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.mainFragment_swipe_refresh_layout);
	    
        // Set-up the SwipeRefreshLayout color order
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorBlack,R.color.colorGray,R.color.colorDarkGray);
        return rootView;
    }
}
