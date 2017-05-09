package com.prj1.stand.artworldviewer.services;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.media.session.MediaSessionCompat;

import com.prj1.stand.artworldviewer.Utilities.ApiUtility;
import com.prj1.stand.artworldviewer.Utilities.TokenUtility;
import com.prj1.stand.artworldviewer.model.Fairs_Embedded;
import com.prj1.stand.artworldviewer.services.fetching.ApiFetchingService;

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
    protected void onHandleIntent(@Nullable Intent intent) {
        apiFetchingService = ApiUtility.getApiService();
        apiFetchingService.getFairsInRangeBySize(0,"5", TokenUtility.getInstance().getOurToken())
                .enqueue(new Callback<Fairs_Embedded>() {
                    @Override
                    public void onResponse(Call<Fairs_Embedded> call, Response<Fairs_Embedded> response) {

                    }

                    @Override
                    public void onFailure(Call<Fairs_Embedded> call, Throwable t) {

                    }
                });
    }
}
