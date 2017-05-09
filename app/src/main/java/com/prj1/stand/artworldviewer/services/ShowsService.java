package com.prj1.stand.artworldviewer.services;


import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.prj1.stand.artworldviewer.Utilities.ApiUtility;
import com.prj1.stand.artworldviewer.Utilities.TokenUtility;
import com.prj1.stand.artworldviewer.model.Shows_Embedded;
import com.prj1.stand.artworldviewer.services.fetching.ApiFetchingService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * IntentService that handles that retrieve of Show information from the Art World API
 * extends IntentService
 * Created by Stand on 5/6/2017.
 */

public class ShowsService extends IntentService{
    // Local Api fetching Service
    private ApiFetchingService apiFetchingService;

    /**
     * An IntentService must always have a constructor that calls super
     * constructor. The string supplied to the super constructor is used to give
     * a name to the IntentService's background thread
     *
     */
    public ShowsService() {
        super("ShowsService");
    }

    /**
     * On the IntentService create
     */
    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected void onHandleIntent(Intent showsIntent) {
        apiFetchingService = ApiUtility.getApiService();
        apiFetchingService.getShowsInRangeBySize(0,"5", TokenUtility.getInstance().getOurToken())
                .enqueue(new Callback<Shows_Embedded>() {
                    @Override
                    public void onResponse(Call<Shows_Embedded> call, Response<Shows_Embedded> response) {

                    }

                    @Override
                    public void onFailure(Call<Shows_Embedded> call, Throwable t) {

                    }
                });
    }
}
