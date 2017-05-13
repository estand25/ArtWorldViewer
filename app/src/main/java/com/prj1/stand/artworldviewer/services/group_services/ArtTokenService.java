package com.prj1.stand.artworldviewer.services.group_services;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import com.prj1.stand.artworldviewer.BuildConfig;
import com.prj1.stand.artworldviewer.Utilities.ApiUtility;
import com.prj1.stand.artworldviewer.Utilities.TokenUtility;
import com.prj1.stand.artworldviewer.model.authorization.Token;
import com.prj1.stand.artworldviewer.services.fetching.ApiFetchingService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * IntentService that handle retrieving the Token or replaced if expired
 *
 * Created by Stand on 5/7/2017.
 */

public class ArtTokenService extends IntentService{
    // Local Api fetching Service
    private ApiFetchingService apiFetchingService;

    /**
      An IntentService must always have a constructor that calls super
     * constructor. The string supplied to the super constructor is used to give
     * a name to the IntentService's background thread
     *
     */
    public ArtTokenService(){
        super("ArtTokenService");
    }

    /**
     * On the IntentService create
     */
    @Override
    public void onCreate() {
        super.onCreate();
    }

    /**
     * Intent handler that populates the TokenUtility token class
     * for future use in query the API
     *
     * @param artTokenIntent
     */
    @Override
    protected void onHandleIntent(final Intent artTokenIntent) {
        apiFetchingService = ApiUtility.getApiService();
        apiFetchingService.sendAccessRequestToService(BuildConfig.AWV_Client_Id,BuildConfig.AWV_Client_Secret)
                .enqueue(new Callback<Token>() {
                    @Override
                    public void onResponse(Call<Token> call, Response<Token> response) {
                        TokenUtility.getInstance().setToken(new Token(response.body().getType(),
                                response.body().getToken(),
                                response.body().getExpiresAt(),
                                response.body().getLinks()));

                        Log.v("ArtTokenService","onResponse - Got the Token "+TokenUtility.getInstance().getOurToken());
                        startService(new Intent(getApplicationContext(), AllModelService.class));
                    }

                    @Override
                    public void onFailure(Call<Token> call, Throwable t) {
                        Log.v("ArtTokenService","onFailure - Got nothing, not Token set");
                    }
                });
    }
}
