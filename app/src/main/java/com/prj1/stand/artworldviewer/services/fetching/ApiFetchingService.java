package com.prj1.stand.artworldviewer.services.fetching;

import com.prj1.stand.artworldviewer.model.Artist;
import com.prj1.stand.artworldviewer.model.Artists_Embedded;
import com.prj1.stand.artworldviewer.model.Artwork;
import com.prj1.stand.artworldviewer.model.Artworks_Embedded;
import com.prj1.stand.artworldviewer.model.Gene;
import com.prj1.stand.artworldviewer.model.Genes_Embedded;
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
    Call<Genes_Embedded> getGenesInRangeBySize(
            @Query("offset") Integer resultStart,
            @Query("size") String numToRetrieve,
            @Header("xapp_token") String header
    );

    // Get specific Gene
    @GET("api/genes/{id}")
    Call<Gene> getGene(
            @Path("id") String id,
            @Header("xapp_token") String header
    );

    // Get Artists starting at resultStart with total retrieve size as numToRetrieve
    @GET("api/artists")
    Call<Artists_Embedded> getArtistsInRangeBySize(
            @Query("offset") Integer resultStart,
            @Query("size") String numToRetrieve,
            @Header("xapp_token") String header
    );

    // Get specific Artist
    @GET("api/artists/{id}")
    Call<Artist> getArtist(
            @Path("id") String id,
            @Header("xapp_token") String header
    );

    // Get Artworks starting at resultStart with total retrieve size as numToRetrieve
    @GET("api/artworks")
    Call<Artworks_Embedded> getArtworksInRangeBySize(
            @Query("offset") Integer resultStart,
            @Query("size") String numToRetrieve,
            @Header("xapp_token") String header
    );

    // Get specific Artwork
    @GET("api/artworks/{id}")
    Call<Artwork> getArtwork(
            @Path("id") String id,
            @Header("xapp_token") String header
    );
}
