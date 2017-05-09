package com.prj1.stand.artworldviewer.services;


import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import com.prj1.stand.artworldviewer.Utilities.ApiUtility;
import com.prj1.stand.artworldviewer.Utilities.TokenUtility;
import com.prj1.stand.artworldviewer.model.Artist;
import com.prj1.stand.artworldviewer.model.Artists;
import com.prj1.stand.artworldviewer.services.fetching.ApiFetchingService;

import java.util.List;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * IntentService that handles that retrieve of Artist information from the Art World API
 * extends IntentService
 * Created by Stand on 5/6/2017.
 */

public class ArtistsService extends IntentService{
    // Local Api fetching Service
    private ApiFetchingService apiFetchingService;

    /**
     * An IntentService must always have a constructor that calls super
     * constructor. The string supplied to the super constructor is used to give
     * a name to the IntentService's background thread
     *
     */
    public ArtistsService() {
        super("ArtistsService");
    }

    /**
     * On the IntentService create
     */
    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected void onHandleIntent(Intent artistIntent) {
        apiFetchingService = ApiUtility.getApiService();
        apiFetchingService.getArtistsInRangeBySize(0,"5", TokenUtility.getInstance().getOurToken())
                .enqueue(new Callback<Artists>() {
                    @Override
                    public void onResponse(Call<Artists> call, Response<Artists> response) {
                        Log.v("ArtistsService", "OnResponse - Success ..."+response.isSuccessful());
                        Log.v("ArtistsService", "OnResponse - "+call.request());

                        // Grab the response (a list of artist) from the API
                        // and puts it in the local list of variables
                        List<Artist> Artists = response.body().getEmbedded().getArtists();

                        for(Artist artist: Artists){
                            Log.v("ArtistsService","Artist Name: "+artist.getName());
                            Log.v("ArtistsService","Artist Gender: "+artist.getGender());
                            Log.v("ArtistsService","Artist Birthday: "+artist.getBirthday());
                            Log.v("ArtistsService","Artist Hometown: "+artist.getHometown());
                            Log.v("ArtistsService","Artist Nationality: "+artist.getNationality());
                            Log.v("ArtistsService","Artist Slug: "+artist.getSlug());
                            Log.v("ArtistsService","Artist Created at: "+artist.getCreatedAt());
                            Log.v("ArtistsService","Artist Updated at: "+artist.getUpdatedAt());
                            Log.v("ArtistsService","Artist Self: "+artist.getLinks().getSelf().getHref());
                        }
                    }

                    @Override
                    public void onFailure(Call<Artists> call, Throwable t) {
                        Log.v("ArtistsService", "onFailure - Failure on the request");
                        Log.v("ArtistsService", "onFailure - "+call.request());
                    }
                });
    }
}
