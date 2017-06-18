package com.prj1.stand.artworldviewer.notInUses.single_services;

import android.app.IntentService;
import android.content.Intent;

import com.prj1.stand.artworldviewer.utilities.ApiUtility;
import com.prj1.stand.artworldviewer.utilities.TokenUtility;
import com.prj1.stand.artworldviewer.notInUses.shows.Show;
import com.prj1.stand.artworldviewer.services.fetching.ApiFetchingService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * IntentService that handles that retrieve a single Showinformation from the Art World API
 * extends IntentService
 * Created by Stand on 5/6/2017.
 */


public class ShowSingleService extends IntentService{
    // Local Api fetching Service
    private ApiFetchingService apiFetchingService;

    /**
     * An IntentService must always have a constructor that calls super
     * constructor. The string supplied to the super constructor is used to give
     * a name to the IntentService's background thread
     *
     */
    public ShowSingleService(){
        super("ShowSingleService");
    }

    /**
     * On the IntentService create
     */
    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected void onHandleIntent(Intent showSingleIntent) {
        // Get the data from the artist single intent
        final String show_id = showSingleIntent.getStringExtra("ShowSingle");

        apiFetchingService = ApiUtility.getApiService();
        apiFetchingService.getShow(show_id, TokenUtility.getInstance().getOurToken())
                .enqueue(new Callback<Show>() {
                    @Override
                    public void onResponse(Call<Show> call, Response<Show> response) {

                    }

                    @Override
                    public void onFailure(Call<Show> call, Throwable t) {

                    }
                });
    }
}
