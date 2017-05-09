package com.prj1.stand.artworldviewer.services;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import com.prj1.stand.artworldviewer.Utilities.ApiUtility;
import com.prj1.stand.artworldviewer.Utilities.TokenUtility;
import com.prj1.stand.artworldviewer.model.Artwork;
import com.prj1.stand.artworldviewer.model.Artworks_Embedded;
import com.prj1.stand.artworldviewer.services.fetching.ApiFetchingService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * IntentService that handles that retrieve of Artist information from the Art World API
 * extends IntentService
 * Created by Stand on 5/6/2017.
 */

public class ArtworksService extends IntentService{
    // Local Api fetching Service
    private ApiFetchingService apiFetchingService;

    /**
     * An IntentService must always have a constructor that calls super
     * constructor. The string supplied to the super constructor is used to give
     * a name to the IntentService's background thread
     *
     */
    public ArtworksService(){
        super("ArtworksService");
    }

    /**
     * On the IntentService create
     */
    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected void onHandleIntent(Intent artworkIntent) {
        apiFetchingService = ApiUtility.getApiService();
        apiFetchingService.getArtworksInRangeBySize(0,"50", TokenUtility.getInstance().getOurToken())
                .enqueue(new Callback<Artworks_Embedded>() {
                    @Override
                    public void onResponse(Call<Artworks_Embedded> call, Response<Artworks_Embedded> response) {
                        Log.v("ArtworksService", "OnResponse - Success ..."+response.isSuccessful());
                        Log.v("ArtworksService", "OnResponse - "+call.request());
                        Log.v("ArtworksService", "OnResponse - "+String.valueOf(response.body().getArtworks().size()));

                        List<Artwork> Artworks = response.body().getArtworks();

                        for(Artwork artwork: Artworks)
                        {
                            Log.v("ArtworksService","Artwork Slug: "+artwork.getSlug());
                            Log.v("ArtworksService","Artwork Title: "+artwork.getTitle());
                            Log.v("ArtworksService","Artwork Category: "+artwork.getCategory());
                            Log.v("ArtworksService","Artwork Medium: "+artwork.getMedium());
                            Log.v("ArtworksService","Artwork Date: "+artwork.getDate());
                            Log.v("ArtworksService","Artwork Dimensions: "+artwork.getDimensions().getIn().getText());
                            Log.v("ArtworksService","Artwork Published: "+artwork.getPublished());
                            Log.v("ArtworksService","Artwork Website: "+artwork.getWebsite());
                            Log.v("ArtworksService","Artwork Signature: "+artwork.getSignature());
                            Log.v("ArtworksService","Artwork Collecting Institution: "+artwork.getCollectingInstitution());
                            Log.v("ArtworksService","Artwork Cultural Maker: "+artwork.getCulturalMaker());
                            Log.v("ArtworksService","Artwork Thumbnail: "+artwork.getLinks().getThumbnail());
                            Log.v("ArtworksService","Artwork Created at: "+artwork.getCreatedAt());
                            Log.v("ArtworksService","Artwork Updated at: "+artwork.getUpdatedAt());
                        }
                    }

                    @Override
                    public void onFailure(Call<Artworks_Embedded> call, Throwable t) {
                        Log.v("ArtworksService", "onFailure - Failure on the request");
                        Log.v("ArtworksService", "onFailure - "+call.request().body());
                    }
                });
    }
}
