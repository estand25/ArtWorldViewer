package com.prj1.stand.artworldviewer.services.single_services;

import android.app.IntentService;
import android.content.Intent;

import com.prj1.stand.artworldviewer.Utilities.ApiUtility;
import com.prj1.stand.artworldviewer.Utilities.TokenUtility;
import com.prj1.stand.artworldviewer.model.fairs.Fair;
import com.prj1.stand.artworldviewer.services.fetching.ApiFetchingService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * IntentService that handles that retrieve a single Artist information from the Art World API
 * extends IntentService
 * Created by Stand on 5/6/2017.
 */


public class FairSingleService extends IntentService {
    // Local Api fetching Service
    private ApiFetchingService apiFetchingService;

    /**
     * An IntentService must always have a constructor that calls super
     * constructor. The string supplied to the super constructor is used to give
     * a name to the IntentService's background thread
     *
     */
    public FairSingleService(){
        super("FairSingleService");
    }

    /**
     * On the IntentService create
     */
    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected void onHandleIntent(Intent fairSingleIntent) {
        // Get the data from the artist single intent
        final String fair_id = fairSingleIntent.getStringExtra("FairSingle");

        apiFetchingService = ApiUtility.getApiService();
        apiFetchingService.getFair(fair_id, TokenUtility.getInstance().getOurToken())
                .enqueue(new Callback<Fair>() {
                    @Override
                    public void onResponse(Call<Fair> call, Response<Fair> response) {

                    }

                    @Override
                    public void onFailure(Call<Fair> call, Throwable t) {

                    }
                });

    }
}
