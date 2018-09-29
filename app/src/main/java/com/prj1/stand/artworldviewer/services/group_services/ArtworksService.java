package com.prj1.stand.artworldviewer.services.group_services;

import android.app.IntentService;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.util.Log;

import com.prj1.stand.artworldviewer.constants.Constants;
import com.prj1.stand.artworldviewer.utilities.ApiUtility;
import com.prj1.stand.artworldviewer.utilities.ArtPage;
import com.prj1.stand.artworldviewer.data.DbContract;
import com.prj1.stand.artworldviewer.model.artworks.Artwork;
import com.prj1.stand.artworldviewer.model.artworks.Artworks;
import com.prj1.stand.artworldviewer.services.fetching.ApiFetchingService;

import java.util.List;
import java.util.UUID;

import com.prj1.stand.artworldviewer.utilities.ProgressStatusUtility;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * IntentService that handles that retrieve of Artist information from the Art World API
 * extends IntentService
 * Created by Stand on 5/6/2017.
 */

public class ArtworksService extends IntentService{
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
    public ArtworksService(){
        super("ArtworksService");
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

    @Override
    protected void onHandleIntent(Intent artworkIntent) {
        ArtPage artPage = artworkIntent.getParcelableExtra(Constants.ARTPAGE);
        
        apiFetchingService = ApiUtility.getApiService();
        apiFetchingService.getArtworksInRangeBySize(artPage.getpageOffset(),artPage.getPageSize(), artPage.getToken())
                .enqueue(new Callback<Artworks>() {
                    @Override
                    public void onResponse(Call<Artworks> call, Response<Artworks> response) {
                        Log.v("ArtworksService", "OnResponse - Success ..."+response.isSuccessful());
                        Log.v("ArtworksService", "OnResponse - "+call.request());
                        Log.v("ArtworksService", "OnResponse - "+response.body().getEmbedded().getArtworks().size());

                        // Grab the response (a list of artworks) from the API
                        // and puts it in the local list variable and table
                        List<Artwork> Artworks = response.body().getEmbedded().getArtworks();

                        // Content value array that I will pass to bulk insert
                        ContentValues[] bulkArtwork = new ContentValues[Artworks.size()];

                        // Index counter
                        int i = 0;

                        for(Artwork artwork: Artworks)
                        {
                            // Content that holds all the artwork information retrieved
                            // from the API
                            ContentValues artworkContent = new ContentValues();

                            // Generate unique identify for foreign keys record
                            String dimension_id = UUID.randomUUID().toString();
                            String cm_id = UUID.randomUUID().toString();
                            String in_id = UUID.randomUUID().toString();
                            String website_id = UUID.randomUUID().toString();
                            String image_version_id = UUID.randomUUID().toString();
                            String link_id = UUID.randomUUID().toString();
                            String thumbnail_id = UUID.randomUUID().toString();
                            String image_id = UUID.randomUUID().toString();
                            String partner_id = UUID.randomUUID().toString();
                            String self_id = UUID.randomUUID().toString();
                            String permalink_id = UUID.randomUUID().toString();

                            // Set the value of each column and insert the artwork properties
                            artworkContent.put(DbContract.ArtworkEntry.COLUMN_ARTWORK_ID, artwork.getId());
                            artworkContent.put(DbContract.ArtworkEntry.COLUMN_SLUG, artwork.getSlug());
                            artworkContent.put(DbContract.ArtworkEntry.COLUMN_CREATED_AT, artwork.getCreatedAt());
                            artworkContent.put(DbContract.ArtworkEntry.COLUMN_UPDATED_AT, artwork.getUpdatedAt());
                            artworkContent.put(DbContract.ArtworkEntry.COLUMN_TITLE, artwork.getTitle());
                            artworkContent.put(DbContract.ArtworkEntry.COLUMN_CATEGORY, artwork.getCategory());
                            artworkContent.put(DbContract.ArtworkEntry.COLUMN_MEDIUM, artwork.getMedium());
                            artworkContent.put(DbContract.ArtworkEntry.COLUMN_DATE, artwork.getDate());
                            artworkContent.put(DbContract.ArtworkEntry.COLUMN_DIMENSIONS_ID, dimension_id);
                            artworkContent.put(DbContract.ArtworkEntry.COLUMN_PUBLISHED, artwork.getPublished());
                            artworkContent.put(DbContract.ArtworkEntry.COLUMN_WEBSITE_ID, website_id);
                            artworkContent.put(DbContract.ArtworkEntry.COLUMN_SIGNATURE, artwork.getSignature());
                            artworkContent.put(DbContract.ArtworkEntry.COLUMN_PROVENANCE, artwork.getProvenance());
                            artworkContent.put(DbContract.ArtworkEntry.COLUMN_LITERATURE, artwork.getLiterature());
                            artworkContent.put(DbContract.ArtworkEntry.COLUMN_EXHIBITION_HISTORY, artwork.getExhibitionHistory());
                            artworkContent.put(DbContract.ArtworkEntry.COLUMN_COLLECTING_INSTITUTION, artwork.getCollectingInstitution());
                            artworkContent.put(DbContract.ArtworkEntry.COLUMN_ADDITIONAL_INFORMATION, artwork.getAdditionalInformation());
                            artworkContent.put(DbContract.ArtworkEntry.COLUMN_IMAGE_RIGHTS, artwork.getImageRights());
                            artworkContent.put(DbContract.ArtworkEntry.COLUMN_BLURB, artwork.getBlurb());
                            artworkContent.put(DbContract.ArtworkEntry.COLUMN_UNIQUE, artwork.getUnique());
                            artworkContent.put(DbContract.ArtworkEntry.COLUMN_CULTURAL_MAKER, (String) artwork.getCulturalMaker());
                            artworkContent.put(DbContract.ArtworkEntry.COLUMN_ICONICITY, artwork.getIconicity());
                            artworkContent.put(DbContract.ArtworkEntry.COLUMN_CAN_INQUIRE, artwork.getCanInquire());
                            artworkContent.put(DbContract.ArtworkEntry.COLUMN_CAN_ACQUIRE, artwork.getCanAcquire());
                            artworkContent.put(DbContract.ArtworkEntry.COLUMN_CAN_SHARE, artwork.getCanShare());
                            artworkContent.put(DbContract.ArtworkEntry.COLUMN_SOLD, artwork.getSold());
                            artworkContent.put(DbContract.ArtworkEntry.COLUMN_IMAGE_VERSION_ID, image_version_id);
                            artworkContent.put(DbContract.ArtworkEntry.COLUMN_LINK_ID, link_id);

                            // Content that holds the dimension, websites, and links information
                            // retrieved from the API
                            ContentValues dimensionValue = new ContentValues();
                            ContentValues _cmValue = new ContentValues();
                            ContentValues _inValue = new ContentValues();
                            ContentValues websiteValue = new ContentValues();
                            ContentValues linkValue = new ContentValues();
                            ContentValues thumbnailValue = new ContentValues();
                            ContentValues imageValue = new ContentValues();
                            ContentValues partnerValue = new ContentValues();
                            ContentValues selfValue = new ContentValues();
                            ContentValues permalinkValue = new ContentValues();

                            dimensionValue.put(DbContract.DimensionEntry.COLUMN_DIMENSION_ID, dimension_id);
                            dimensionValue.put(DbContract.DimensionEntry.COLUMN_CM_ID, cm_id);
                            dimensionValue.put(DbContract.DimensionEntry.COLUMN_IN_ID, in_id);

                            String cm_Height = "";
                            String cm_Width = "";

                            if(artwork.getDimensions().getCm().getHeight() != null) {
                                cm_Height = artwork.getDimensions().getCm().getHeight().toString();
                            }

                            if(artwork.getDimensions().getIn().getWidth() != null) {
                                cm_Width = artwork.getDimensions().getIn().getWidth().toString();
                            }

                            _cmValue.put(DbContract.CMEntry.COLUMN_CM_ID, cm_id);
                            _cmValue.put(DbContract.CMEntry.COLUMN_TEXT, artwork.getDimensions().getCm().getText());
                            _cmValue.put(DbContract.CMEntry.COLUMN_HEIGHT, cm_Height);
                            _cmValue.put(DbContract.CMEntry.COLUMN_WIDTH, cm_Width);
                            _cmValue.put(DbContract.CMEntry.COLUMN_DEPTH, (String) artwork.getDimensions().getCm().getDepth());
                            _cmValue.put(DbContract.CMEntry.COLUMN_DIAMETER, (String) artwork.getDimensions().getCm().getDiameter());

                            String in_Height = "";
                            String in_Width = "";

                            if(artwork.getDimensions().getIn().getHeight() != null) {
                                in_Height = artwork.getDimensions().getCm().getHeight().toString();
                            }

                            if(artwork.getDimensions().getIn().getWidth() != null) {
                                in_Width = artwork.getDimensions().getIn().getWidth().toString();
                            }
                            _inValue.put(DbContract.INEntry.COLUMN_IN_ID, in_id);
                            _inValue.put(DbContract.INEntry.COLUMN_TEXT, artwork.getDimensions().getIn().getText());
                            _inValue.put(DbContract.INEntry.COLUMN_HEIGHT, in_Height);
                            _inValue.put(DbContract.INEntry.COLUMN_WIDTH, in_Width);
                            _inValue.put(DbContract.INEntry.COLUMN_DEPTH, (String) artwork.getDimensions().getIn().getDepth());
                            _inValue.put(DbContract.INEntry.COLUMN_DIAMETER,(String) artwork.getDimensions().getIn().getDiameter());

                            websiteValue.put(DbContract.WebsiteEntry.COLUMN_WEBSITE_ID, website_id);
                            websiteValue.put(DbContract.WebsiteEntry.COLUMN_HREF, artwork.getWebsite());

                            linkValue.put(DbContract.LinkEntry.COLUMN_LINK_ID, link_id);
                            linkValue.put(DbContract.LinkEntry.COLUMN_SELF_ID, self_id);
                            linkValue.put(DbContract.LinkEntry.COLUMN_LINK_TYPE, "artwork");
                            linkValue.put(DbContract.LinkEntry.COLUMN_IMAGE_ID, image_id);
                            linkValue.put(DbContract.LinkEntry.COLUMN_THUMBNAIL_ID, thumbnail_id);
                            linkValue.put(DbContract.LinkEntry.COLUMN_PERMALINK_ID, permalink_id);
                            linkValue.put(DbContract.LinkEntry.COLUMN_PARTNER_CONTACT_ID, partner_id);

                            thumbnailValue.put(DbContract.ThumbnailEntry.COLUMN_THUMBNAIL_ID, thumbnail_id);
                            thumbnailValue.put(DbContract.ThumbnailEntry.COLUMN_HREF, artwork.getLinks().getThumbnail().getHref());

                            imageValue.put(DbContract.ImageEntry.COLUMN_IMAGE_ID, image_id);
                            imageValue.put(DbContract.ImageEntry.COLUMN_TEMPLATED, artwork.getLinks().getImage().getTemplated());
                            imageValue.put(DbContract.ImageEntry.COLUMN_HREF, artwork.getLinks().getImage().getHref());

                            partnerValue.put(DbContract.PartnerContactEntry.COLUMN_PARTNER_CONTACT_ID , partner_id);
                            partnerValue.put(DbContract.PartnerContactEntry.COLUMN_HREF, artwork.getLinks().getPartner().getHref());

                            selfValue.put(DbContract.SelfEntry.COLUMN_SELF_ID, self_id);
                            selfValue.put(DbContract.SelfEntry.COLUMN_HREF, artwork.getLinks().getSelf().getHref());

                            permalinkValue.put(DbContract.PermalinkEntry.COLUMN_PERMALINK_ID, permalink_id);
                            permalinkValue.put(DbContract.PermalinkEntry.COLUMN_HREF, artwork.getLinks().getPermalink().getHref());

                            List<String> ImageVersions = artwork.getImageVersions();
                            //Log.v("ArtworksService", "OnResponse ImageVersions - "+String.valueOf(ImageVersions.size()));
                            ContentValues[] bulkImageVersions = new ContentValues[ImageVersions.size()];

                            for(int iv = 0; iv < ImageVersions.size();iv++) {
                                ContentValues imageVersionValue = new ContentValues();

                                //Log.v("ArtworksService", "OnResponse ImageVersions "+String.valueOf(iv)+" - "+ImageVersions.get(iv));
                                imageVersionValue.put(DbContract.ImageVersionEntry.COLUMN_IMAGE_VERSION_ID, image_version_id);
                                imageVersionValue.put(DbContract.ImageVersionEntry.COLUMN_VERSION_TYPE, ImageVersions.get(iv));

                                bulkImageVersions[iv] = imageVersionValue;

                                //Log.v("ArtworksService", "OnResponse ImageVersions  - "+String.valueOf(bulkImageVersions.length));
                            }

                            contentResolver.bulkInsert(DbContract.ImageVersionEntry.CONTENT_URI, bulkImageVersions);
                            contentResolver.insert(DbContract.DimensionEntry.CONTENT_URI, dimensionValue);
                            contentResolver.insert(DbContract.CMEntry.CONTENT_URI, _cmValue);
                            contentResolver.insert(DbContract.INEntry.CONTENT_URI, _inValue);
                            contentResolver.insert(DbContract.WebsiteEntry.CONTENT_URI, websiteValue);
                            contentResolver.insert(DbContract.LinkEntry.CONTENT_URI, linkValue);
                            contentResolver.insert(DbContract.ThumbnailEntry.CONTENT_URI, thumbnailValue);
                            contentResolver.insert(DbContract.ImageEntry.CONTENT_URI, imageValue);
                            contentResolver.insert(DbContract.PartnerContactEntry.CONTENT_URI, partnerValue);
                            contentResolver.insert(DbContract.SelfEntry.CONTENT_URI, selfValue);
                            contentResolver.insert(DbContract.PermalinkEntry.CONTENT_URI, permalinkValue);

                            // Add Artworks details to the contentValue array
                            bulkArtwork[i] = artworkContent;

                            // Increment index
                            i++;
                        }
                        
                        // Insert the content array to our local DB
                        contentResolver.bulkInsert(DbContract.ArtworkEntry.CONTENT_URI, bulkArtwork);
                        
                        Log.v("ArtworksService", "OnResponse - Completed and updated to db");
                        
                        Intent refreshRecycleView = new Intent("android.intent.action.MAIN")
                                .putExtra(Constants.IMAGE_LOADER, Constants.IMAGE_LOADER);
                        
                        sendBroadcast(refreshRecycleView);

                        ProgressStatusUtility.getInstance().setProgressStatus(true);
                    }

                    @Override
                    public void onFailure(Call<Artworks> call, Throwable t) {
                        Log.v("ArtworksService", "onFailure - Failure on the request");
                        Log.v("ArtworksService", "onFailure - "+call.request());
                    }
                });
    }
}
