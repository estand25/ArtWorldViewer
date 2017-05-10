package com.prj1.stand.artworldviewer.services;


import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import com.prj1.stand.artworldviewer.Utilities.ApiUtility;
import com.prj1.stand.artworldviewer.Utilities.TokenUtility;
import com.prj1.stand.artworldviewer.model.Show;
import com.prj1.stand.artworldviewer.model.Shows;
import com.prj1.stand.artworldviewer.services.fetching.ApiFetchingService;

import java.util.List;

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
                .enqueue(new Callback<Shows>() {
                    @Override
                    public void onResponse(Call<Shows> call, Response<Shows> response) {
                        Log.v("ShowsService", "OnResponse - Success ..."+response.isSuccessful());
                        Log.v("ShowsService", "OnResponse - "+call.request());

                        // Grab the response (a list of Shows) from the API
                        // and puts it in the local list of variable
                        List<Show> Shows = response.body().getEmbedded().getShows();

                        for(Show show: Shows)
                        {
                            Log.v("ShowsService","Show Name: "+show.getName());
                            Log.v("ShowsService","Show Press Release: "+show.getPressRelease());
                            Log.v("ShowsService","Show Description: "+show.getDescription());
                            Log.v("ShowsService","Show Start at: "+show.getStartAt());
                            Log.v("ShowsService","Show End at: "+show.getEndAt());
                            Log.v("ShowsService","Show Creation at: "+show.getCreatedAt());
                            Log.v("ShowsService","Show Updated at: "+show.getUpdatedAt());
                        }

                    }

                    @Override
                    public void onFailure(Call<Shows> call, Throwable t) {
                        Log.v("ShowsService", "onFailure - Failure on the request");
                        Log.v("ShowsService", "onFailure - "+call.request());

                    }
                });
    }
}
