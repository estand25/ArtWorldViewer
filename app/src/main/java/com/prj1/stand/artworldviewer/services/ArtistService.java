package com.prj1.stand.artworldviewer.services;


import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import com.prj1.stand.artworldviewer.Utilities.ApiUtility;
import com.prj1.stand.artworldviewer.Utilities.TokenUtility;
import com.prj1.stand.artworldviewer.model.Artists;
import com.prj1.stand.artworldviewer.model.Artists_Embedded;
import com.prj1.stand.artworldviewer.services.fetching.ApiFetchingService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * IntentService that handles that retrieve of Artist information from the Art World API
 * extends IntentService
 * Created by Stand on 5/6/2017.
 */

public class ArtistService extends IntentService{
    // Local Api fetching Service
    private ApiFetchingService apiFetchingService;

    /**
     * An IntentService must always have a constructor that calls super
     * constructor. The string supplied to the super constructor is used to give
     * a name to the IntentService's background thread
     *
     */
    public ArtistService() {
        super("ArtistService");
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
                        Log.v("ArtistService", "OnResponse - Success ..."+response.message());
                        Log.v("ArtistService", "OnResponse - Getting Artist size ..."+response.body().describeContents());
                        Log.v("ArtistService", "OnResponse - Request ..."+call.request());
                    }

                    @Override
                    public void onFailure(Call<Artists> call, Throwable t) {
                        Log.v("ArtistService", "onFailure - Failure on the request");
                        Log.v("ArtistService", "onFailure - "+call.request());
                    }
                });
    }
}
