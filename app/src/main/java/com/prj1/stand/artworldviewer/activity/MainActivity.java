package com.prj1.stand.artworldviewer.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import android.support.v4.app.FragmentActivity;

import com.prj1.stand.artworldviewer.BuildConfig;
import com.prj1.stand.artworldviewer.R;
import com.prj1.stand.artworldviewer.Utilities.TokenUtility;
import com.prj1.stand.artworldviewer.model.authorization.Token;
import com.prj1.stand.artworldviewer.services.fetching.ApiFetchingService;
import com.prj1.stand.artworldviewer.Utilities.ApiUtility;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends FragmentActivity{
    private ApiFetchingService apiFetchingService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create new instance of the MainFragment, but get the MainFragment from
        // the getSupportFragmentManager found fragment
        MainFragment mainFragment = ((MainFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment));

        mainFragment.getLayoutInflater(savedInstanceState);

        // First thing I do is get my token
        apiFetchingService = ApiUtility.getApiService();
        apiFetchingService.sendAccessRequestToService(BuildConfig.AWV_Client_Id,BuildConfig.AWV_Client_Secret)
                .enqueue(new Callback<Token>() {
                    @Override
                    public void onResponse(Call<Token> call, Response<Token> response) {
                        TokenUtility.getInstance().setToken(new Token(response.body().getType(),
                                response.body().getToken(),
                                response.body().getExpiresAt(),
                                response.body().getLinks()));

                        Log.v("MA - onResponse","Got the Token "+TokenUtility.getInstance().getOurToken());
                    }

                    @Override
                    public void onFailure(Call<Token> call, Throwable t) {
                        Log.v(this.toString() + " - onFailure","Got nothing, not Token set");
                    }
                });
        //Log.v("onCreate - onResponse",TokenUtility.getInstance().getOurToken());

        // Find the SwipeRefreshLayout and associate to local one
        //mSwipeRefreshLayout = (SwipeRefreshLayout)
        //        findViewById(R.id.activity_main_swipe_refresh_layout);

        //apiFetchingService = ApiUtility.getApiService();


        //tokanUtility = TokenUtility.getInstance();

        //apiFetchingService.getGenesInRangeBySize(0,"25", tokenUtility.getOurToken())
        //        .enqueue(new Callback<Genes_Embedded>() {
        //    @Override
        //    public void onResponse(Call<Genes_Embedded> call, Response<Genes_Embedded> response) {
        //        Log.v("onResponse","success in Getting something");
                //genes_embedded = response.body();
        //        Log.v("onResponse",response.errorBody().toString());
        //    }

        //    @Override
        //    public void onFailure(Call<Genes_Embedded> call, Throwable t) {
        //        Log.v("onFailure","failure I got nothing");
        //    }
        //});

        //GenesAdapters genesAdapters = new GenesAdapters(MainActivity.this,genes_embedded);

        // Find the GridView on the MainActivity layout and set it
        // to the local representation
        //mGridView = (GridView) findViewById(R.id.activity_main_gridView);

        //mGridView.setAdapter(genesAdapters);
        // Set-up gridview & gridViewColum
        //setupAdapter();



    }

    public void goGetToken(){

    }

    //public void setupAdapter(){
        // Populate the Gridview with the custom adapter information
    //}
}
