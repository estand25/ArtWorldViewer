package com.prj1.stand.artworldviewer.services.fetching;

import com.prj1.stand.artworldviewer.model.Artist;
import com.prj1.stand.artworldviewer.model.Artists;
import com.prj1.stand.artworldviewer.model.Artwork;
import com.prj1.stand.artworldviewer.model.Artworks;
import com.prj1.stand.artworldviewer.model.Fair;
import com.prj1.stand.artworldviewer.model.Fairs;
import com.prj1.stand.artworldviewer.model.Gene;
import com.prj1.stand.artworldviewer.model.Genes;
import com.prj1.stand.artworldviewer.model.Show;
import com.prj1.stand.artworldviewer.model.Shows;
import com.prj1.stand.artworldviewer.model.authorization.Token;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * The Art World API connect string interface
 *
 * Created by Stand on 5/6/2017.
 */
public interface ApiFetchingService {
    // Get the Art World Token to perform API requires
    @POST("api/tokens/xapp_token")
    @FormUrlEncoded
    Call<Token> sendAccessRequestToService(
            @Field("client_id") String client_id,
            @Field("client_secret") String client_secret
    );

    // Get Genes starting at resultStart with total retrieve size as numToRetrieve
    @GET("api/genes")
    Call<Genes> getGenesInRangeBySize(
            @Query("offset") Integer resultStart,
            @Query("size") String numToRetrieve,
            @Query("xapp_token") String header
    );

    // Get specific Gene
    @GET("api/genes/{id}")
    Call<Gene> getGene(
            @Path("id") String id,
            @Query("xapp_token") String header
    );

    // Get Artists starting at resultStart with total retrieve size as numToRetrieve
    @GET("api/artists")
    Call<Artists> getArtistsInRangeBySize(
            @Query("offset") Integer resultStart,
            @Query("size") String numToRetrieve,
            @Query("xapp_token") String header
    );

    // Get specific Artist
    @GET("api/artists/{id}")
    Call<Artist> getArtist(
            @Path("id") String id,
            @Query("xapp_token") String header
    );

    // Get Artworks starting at resultStart with total retrieve size as numToRetrieve
    @GET("api/artworks")
    Call<Artworks> getArtworksInRangeBySize(
            @Query("offset") Integer resultStart,
            @Query("size") String numToRetrieve,
            @Query("xapp_token") String header
    );

    // Get specific Artwork
    @GET("api/artworks/{id}")
    Call<Artwork> getArtwork(
            @Path("id") String id,
            @Query("xapp_token") String header
    );

    // Get Fairs Starting at resultStart with total retrieve size as numToRetrieve
    @GET("api/fairs")
    Call<Fairs> getFairsInRangeBySize(
            @Query("offset") Integer resultStart,
            @Query("size") String numToRetrieve,
            @Query("xapp_token") String header
    );

    // Get specific fair
    @GET("/api/fairs/{id}")
    Call<Fair> getFair(
            @Path("id") String id,
            @Query("xapp_token") String header
    );


    // Get Shows Starting at resultStart with total retrieve size as numToRetrieve
    @GET("api/shows")
    Call<Shows> getShowsInRangeBySize(
            @Query("offset") Integer resultStart,
            @Query("size") String numToRetrieve,
            @Query("xapp_token") String header
    );

    // Get specific Show
    @GET("/api/shows/{id}")
    Call<Show> getShow(
            @Path("id") String id,
            @Query("xapp_token") String header
    );
}
