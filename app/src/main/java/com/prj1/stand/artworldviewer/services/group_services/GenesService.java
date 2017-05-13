package com.prj1.stand.artworldviewer.services.group_services;

import android.app.IntentService;
import android.content.ContentResolver;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

import com.prj1.stand.artworldviewer.Utilities.ApiUtility;
import com.prj1.stand.artworldviewer.Utilities.TokenUtility;
import com.prj1.stand.artworldviewer.model.Gene;
import com.prj1.stand.artworldviewer.model.Genes;
import com.prj1.stand.artworldviewer.model.Genes_Embedded;
import com.prj1.stand.artworldviewer.services.fetching.ApiFetchingService;

import java.util.List;
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
                        Log.v("GenesService", "OnResponse - Success ..."+response.isSuccessful());
                        Log.v("GenesService", "OnResponse - "+call.request());

                        // Grab the response (a list of Genes) from the API
                        // and puts it in the local list of variable
                        List<Gene> Genes = response.body().getEmbedded().getGenes();

                        for(Gene gene: Genes){
                            Log.v("GenesService","Gene Name: "+gene.getName());
                            Log.v("GenesService","Gene Description: "+gene.getDescription());
                            Log.v("GenesService","Gene Thumbnail: "+gene.getLinks().getThumbnail().toString());
                            Log.v("GenesService","Gene Created At: "+gene.getCreatedAt());
                            Log.v("GenesService","Gene Updated At: "+gene.getUpdatedAt());
                        }
                    }

                    @Override
                    public void onFailure(Call<Genes> call, Throwable t) {
                        Log.v("GenesService", "onFailure - Failure on the request");
                        Log.v("GenesService", "onFailure - "+call.request());
                    }
                });
    }
}
