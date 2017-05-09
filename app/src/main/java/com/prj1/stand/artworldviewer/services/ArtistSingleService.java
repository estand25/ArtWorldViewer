package com.prj1.stand.artworldviewer.services;


import android.app.IntentService;
import android.content.Intent;

import com.prj1.stand.artworldviewer.Utilities.ApiUtility;
import com.prj1.stand.artworldviewer.Utilities.TokenUtility;
import com.prj1.stand.artworldviewer.model.Artist;
import com.prj1.stand.artworldviewer.services.fetching.ApiFetchingService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * IntentService that handles that retrieve a single Artist information from the Art World API
 * extends IntentService
 * Created by Stand on 5/6/2017.
 */

public class ArtistSingleService extends IntentService{
    // Local Api fetching Service
    private ApiFetchingService apiFetchingService;

    /**
     * An IntentService must always have a constructor that calls super
     * constructor. The string supplied to the super constructor is used to give
     * a name to the IntentService's background thread
     *
     */
    public ArtistSingleService(){
        super("ArtistSingleService");
    }

    /**
     * On the IntentService create
     */
    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected void onHandleIntent(Intent artistSingleIntent) {
        // Get the data from the artist single intent
        final String artist_id = artistSingleIntent.getStringExtra("ArtistSingle");

        apiFetchingService = ApiUtility.getApiService();
        apiFetchingService.getArtist(artist_id, TokenUtility.getInstance().getOurToken())
                .enqueue(new Callback<Artist>() {
                    @Override
                    public void onResponse(Call<Artist> call, Response<Artist> response) {

                    }

                    @Override
                    public void onFailure(Call<Artist> call, Throwable t) {

                    }
                });
    }
}
