package com.prj1.stand.artworldviewer.services.group_services;

import android.app.IntentService;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.util.Log;

import com.prj1.stand.artworldviewer.utilities.ApiUtility;
import com.prj1.stand.artworldviewer.utilities.TokenUtility;
import com.prj1.stand.artworldviewer.data.DbContract;
import com.prj1.stand.artworldviewer.model.genes.Gene;
import com.prj1.stand.artworldviewer.model.genes.Genes;
import com.prj1.stand.artworldviewer.services.fetching.ApiFetchingService;

import java.util.List;
import java.util.UUID;

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

    // Define a variable to contain a content resolver instance
    ContentResolver contentResolver;

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

        // Set the current context content resolver
        contentResolver = getApplicationContext().getContentResolver();
    }

    /**
     * Handles retrieving the genes based on the intent specification
     * of where to start and size of the page
     * @param genesIntent
     */
    @Override
    protected void onHandleIntent(Intent genesIntent) {
        apiFetchingService = ApiUtility.getApiService();
        apiFetchingService.getGenesInRangeBySize(0,"25", TokenUtility.getInstance().getOurToken())
                .enqueue(new Callback<Genes>() {
                    @Override
                    public void onResponse(Call<Genes> call, Response<Genes> response) {
                        Log.v("GenesService", "OnResponse - Success ..."+response.isSuccessful());
                        Log.v("GenesService", "OnResponse - "+call.request());
                        Log.v("GenesService", "OnResponse - "+response.body().getEmbedded().getGenes().size());

                        // Grab the response (a list of Genes) from the API
                        // and puts it in the local list of variable
                        List<Gene> Genes = response.body().getEmbedded().getGenes();

                        // Content value array that I will pass to bulk insert
                        ContentValues[] bulkGene = new ContentValues[Genes.size()];

                        // Index counter
                        int i = 0;

                        for(Gene gene: Genes){
                            // Content that holds all the gene information retrieved
                            // from the API
                            ContentValues geneContent = new ContentValues();

                            // Generate unique identify for foreign keys record
                            String link_id = UUID.randomUUID().toString();
                            String image_version_id = UUID.randomUUID().toString();

                            // Set the value of each column and insert the artwork properties
                            geneContent.put(DbContract.GeneEntry.COLUMN_GENE_ID, gene.getId());
                            geneContent.put(DbContract.GeneEntry.COLUMN_CREATED_AT, gene.getCreatedAt());
                            geneContent.put(DbContract.GeneEntry.COLUMN_UPDATED_AT, gene.getUpdatedAt());
                            geneContent.put(DbContract.GeneEntry.COLUMN_NAME, gene.getName());
                            geneContent.put(DbContract.GeneEntry.COLUMN_DISPLAY_NAME, gene.getDisplayName());
                            geneContent.put(DbContract.GeneEntry.COLUMN_DESCRIPTION, gene.getDescription());
                            geneContent.put(DbContract.GeneEntry.COLUMN_IMAGE_VERSION_ID, image_version_id);
                            geneContent.put(DbContract.GeneEntry.COLUMN_LINK_ID, link_id);

                            // Add Genes details to the contentValue array
                            bulkGene[i] = geneContent;

                            // Increment index
                            i++;
                        }

                        // Insert the content array to our local DB
                        contentResolver.bulkInsert(DbContract.GeneEntry.CONTENT_URI, bulkGene);
                    }

                    @Override
                    public void onFailure(Call<Genes> call, Throwable t) {
                        Log.v("GenesService", "onFailure - Failure on the request");
                        Log.v("GenesService", "onFailure - "+call.request());
                    }
                });
    }
}
