package com.prj1.stand.artworldviewer.services;

import android.app.IntentService;
import android.content.ContentResolver;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

import com.prj1.stand.artworldviewer.Utilities.ApiUtility;
import com.prj1.stand.artworldviewer.Utilities.TokenUtility;
import com.prj1.stand.artworldviewer.model.Genes;
import com.prj1.stand.artworldviewer.model.Genes_Embedded;
import com.prj1.stand.artworldviewer.services.fetching.ApiFetchingService;

import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * IntentService that handles that retrieve of genes information from the Art World API
 * extends IntentService
 * Created by Stand on 5/6/2017.
 */

public class GenesService extends IntentService{
    // Local Api fetching Service
    private ApiFetchingService apiFetchingService;

    /**
     * An IntentService must always have a constructor that calls super
     * constructor. The string supplied to the super constructor is used to give
     * a name to the IntentService's background thread
     *
     */
    public GenesService(){
        super("GenesService");
    }

    /**
     * On the IntentService create
     */
    @Override
    public void onCreate() {
        super.onCreate();
    }

    /**
     * Handles retrieving the genes based on the intent specification
     * of where to start and size of the page
     * @param genesIntent
     */
    @Override
    protected void onHandleIntent(Intent genesIntent) {
        apiFetchingService = ApiUtility.getApiService();
        apiFetchingService.getGenesInRangeBySize(0,"5", TokenUtility.getInstance().getOurToken())
                .enqueue(new Callback<Genes>() {
                    @Override
                    public void onResponse(Call<Genes> call, Response<Genes> response) {
                        Log.v("ArtGenesService", "OnResponse - Success ..."+response.message());
                        Log.v("ArtGenesService", "OnResponse - Getting Genes size ..."+response.body().describeContents());
                        Log.v("ArtGenesService", "OnResponse - Request ..."+call.request());
                    }

                    @Override
                    public void onFailure(Call<Genes> call, Throwable t) {
                        Log.v("ArtGenesService", "onFailure - Failure on the request");
                        Log.v("ArtGenesService", "onFailure - "+call.request());
                    }
                });
    }
}
