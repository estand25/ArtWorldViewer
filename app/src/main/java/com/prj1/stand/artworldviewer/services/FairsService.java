package com.prj1.stand.artworldviewer.services;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import com.prj1.stand.artworldviewer.Utilities.ApiUtility;
import com.prj1.stand.artworldviewer.Utilities.TokenUtility;
import com.prj1.stand.artworldviewer.model.Fair;
import com.prj1.stand.artworldviewer.model.Fairs;
import com.prj1.stand.artworldviewer.services.fetching.ApiFetchingService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * IntentService that handles that retrieve of Fairs information from the Art World API
 * extends IntentService
 * Created by Stand on 5/6/2017.
 */

public class FairsService extends IntentService{
    // Local Api fetching Service
    private ApiFetchingService apiFetchingService;


    /**
     * An IntentService must always have a constructor that calls super
     * constructor. The string supplied to the super constructor is used to give
     * a name to the IntentService's background thread
     *
     */
    public FairsService() {
        super("FairsService");
    }

    /**
     * On the IntentService create
     */
    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        apiFetchingService = ApiUtility.getApiService();
        apiFetchingService.getFairsInRangeBySize(0,"5", TokenUtility.getInstance().getOurToken())
                .enqueue(new Callback<Fairs>() {
                    @Override
                    public void onResponse(Call<Fairs> call, Response<Fairs> response) {
                        Log.v("FairsService", "OnResponse - Success ..."+response.isSuccessful());
                        Log.v("FairsService", "OnResponse - "+call.request());

                        // Grab the response (a list of Fairs) from the API
                        // and puts it in the local list of variable
                        List<Fair> Fairs = response.body().getEmbedded().getFairs();

                        for(Fair fair: Fairs){
                            Log.v("FairsService","Fair Name: "+fair.getName());
                            Log.v("FairsService","About Fair: "+fair.getAbout());
                            Log.v("FairsService","Fair Summary: "+fair.getSummary());
                            Log.v("FairsService","Contact Fair: "+fair.getContact());
                            Log.v("FairsService","Fair Published: "+fair.getPublished());
                            Log.v("FairsService","Fair Status: "+fair.getStatus());
                            Log.v("FairsService","Fair Start at: "+fair.getStartAt());
                            Log.v("FairsService","Fair End at: "+fair.getEndAt());
                            Log.v("FairsService","Fair Created at: "+fair.getCreatedAt());
                            Log.v("FairsService","Fair Updated at: "+fair.getUpdatedAt());

                        }

                    }

                    @Override
                    public void onFailure(Call<Fairs> call, Throwable t) {
                        Log.v("FairsService", "onFailure - Failure on the request");
                        Log.v("FairsService", "onFailure - "+call.request());
                    }
                });
    }
}
