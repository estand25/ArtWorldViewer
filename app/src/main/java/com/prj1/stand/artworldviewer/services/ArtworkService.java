package com.prj1.stand.artworldviewer.services;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

import com.prj1.stand.artworldviewer.Utilities.ApiUtility;
import com.prj1.stand.artworldviewer.Utilities.TokenUtility;
import com.prj1.stand.artworldviewer.model.Artwork;
import com.prj1.stand.artworldviewer.model.Artworks;
import com.prj1.stand.artworldviewer.model.Artworks_Embedded;
import com.prj1.stand.artworldviewer.services.fetching.ApiFetchingService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * IntentService that handles that retrieve of Artist information from the Art World API
 * extends IntentService
 * Created by Stand on 5/6/2017.
 */

public class ArtworkService extends IntentService{
    // Local Api fetching Service
    private ApiFetchingService apiFetchingService;

    /**
     * An IntentService must always have a constructor that calls super
     * constructor. The string supplied to the super constructor is used to give
     * a name to the IntentService's background thread
     *
     */
    public ArtworkService(){
        super("ArtworkService");
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
        apiFetchingService.getArtworksInRangeBySize(0,"25", TokenUtility.getInstance().getOurToken())
                .enqueue(new Callback<Artworks>() {
                    @Override
                    public void onResponse(Call<Artworks> call, Response<Artworks> response) {
                        Log.v("ArtworkService", "OnResponse - Success ..."+response.message());
                        Log.v("ArtworkService", "OnResponse - Getting Artwork size ..."+String.valueOf(response.body().getEmbedded().getArtworks().size()));
                    }

                    @Override
                    public void onFailure(Call<Artworks> call, Throwable t) {
                        Log.v("ArtworkService", "onFailure - Failure on the request");
                        Log.v("ArtworkService", "onFailure - "+call.request());
                    }
                });
    }
}
