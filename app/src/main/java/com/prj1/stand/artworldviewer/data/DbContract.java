package com.prj1.stand.artworldviewer.data;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Art World Viewer classes that handles the individual table defines
 * Created by Stand on 5/9/2017.
 */

public class DbContract {
    /**
     * The base location where the tables will be location
     */
    public static final String CONTENT_AUTHORITY = "com.prj1.stand.artworldviewer";

    /**
     * URI representation of the root table location
     */
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    /**
     * Individual tables name
     */
    public static final String PATH_ARTIST = "artist";
    public static final String PATH_ARTWORK = "artwork";
    public static final String PATH_FAIR ="fair";
    public static final String PATH_GENE = "gene";
    public static final String PATH_SHOW = "show";

    /**
     * Class that create the Artist (ArtistEntry) table
     */
    public static final class ArtistEntry implements BaseColumns {
        /**
         * Location for the specific table (used to access table data)
         */
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_ARTIST).build();

        /**
         * The type of data I will be send if retrieved
         */
        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE +"/"+CONTENT_AUTHORITY+"/"+PATH_ARTIST;

        /**
         * Build the artist
         * @param ArtistId - Artist unique id
         * @return - Returns Uri
         */
        public static Uri buildArtistDetailSection(int ArtistId){
            return BASE_CONTENT_URI.buildUpon().appendPath("artist_detail")
                    .appendPath(Integer.toString(ArtistId)).build();
        }

        /**
         * URI for the specific Artist row in the artist table
         * @param id - Artist identifier
         * @return - Returns Uri
         */
        public static Uri buildArtistUri(long id){
            return ContentUris.withAppendedId(CONTENT_URI,id);
        }

        /**
         * Uri for specific Artist ID int he Artist table
         * @param ArtistId - Artist unique id
         * @return - Returns Uri
         */
        public static Uri buildArtistIDUri(int ArtistId){
            return CONTENT_URI.buildUpon().appendPath(Integer.toString(ArtistId)).build();
        }

        /**
         * Uri to get the movie id
         * @param uri
         * @return
         */
        public static String getArtistID(Uri uri){
            return uri.getPathSegments().get(1);
        }

        /**
         * Uri to get the movie id in Integer
         * @param uri
         * @return
         */
        public static int getIntegerArtistID(Uri uri){
            return Integer.parseInt(uri.getPathSegments().get(1));
        }

        /**
         * String holds the table name
         */
        public static final String TABLE_NAME = "artist";

        /**
         * Columns in the artist DB
         */
        public static final String COLUMN_ARTIST_ID = "artist_id";
        public static final String COLUMN_SLUG = "slug";
        public static final String COLUMN_CREATED_AT = "created_at";
        public static final String COLUMN_UPDATED_AT = "updated_at";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_SORTABLE_NAME = "sortable_name";
        public static final String COLUMN_GENDER = "gender";
        public static final String COLUMN_BIRTHDAY = "birthday";
        public static final String COLUMN_HOMETOWN = "hometown";
        public static final String COLUMN_LOCATION = "location";
        public static final String COLUMN_NATIONALITY = "nationality";
        public static final String COLUMN_LINK_ID = "link_Id";
    }

    /**
     * Class that creates the Artwork (ArtworkEntry) table
     */
    public static final class ArtworkEntry implements BaseColumns {
        /**
         * Location for the specific table (used to access table data)
         */
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_ARTWORK).build();

        /**
         * The type of data I will be sending if retrieved
         */
        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_ARTWORK;

        /**
         * Build the artist
         * @param ArtworkId - Artwork unique id
         * @return - Returns Uri
         */
        public static Uri buildArtworkDetailAllSection(int ArtworkId){
            return BASE_CONTENT_URI.buildUpon().appendPath("artwork_detail")
                    .appendPath(Integer.toString(ArtworkId)).build();
        }

        /**
         * URI for the specific Artwork row in the Artwork table
         * @param id
         * @return
         */
        public static Uri buildArtworkUri(long id){
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

        /**
         * Uri for getting the Artwork id
         * @param ArtWorkId
         * @return
         */
        public static Uri buildArtworkUri(int ArtWorkId){
            return CONTENT_URI.buildUpon().appendPath(Integer.toString(ArtWorkId)).build();
        }

        /**
         * Uri for getting the Artwork id
         * @param uri
         * @return
         */
        public static int getIntegerArtworkId(Uri uri){
            return Integer.parseInt(uri.getPathSegments().get(1));
        }

        /**
         * String holds the table name
         */
        public static final String TABLE_NAME = "artwork";

        /**
         * Columns in the artwork DB
         */
        public static final String COLUMN_ARTWORK_ID = "artwork_id";
        public static final String COLUMN_SLUG = "slug";
        public static final String COLUMN_CREATED_AT = "created_at";
        public static final String COLUMN_UPDATED_AT = "updated_at";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_CATEGORY = "category";
        public static final String COLUMN_MEDIUM = "medium";
        public static final String COLUMN_DATE = "date";
        public static final String COLUMN_DIMESIONS_ID = "dimension_id";
        public static final String COLUMN_PUBLISHED = "published";
        public static final String COLUMN_WEBSITE = "website";
        public static final String COLUMN_SIGNATURE = "signature";
        public static final String COLUMN_PROVENANCE = "provenance";
        public static final String COLUMN_LITERATURE = "literature";
        public static final String COLUMN_EXHIBITION_HISTORY = "exhibition_history";
        public static final String COLUMN_COLLECTING_INSTITUTION = "collecting_institution";
        public static final String COLUMN_ADDITIONAL_INFORMATION = "additional_information";
        public static final String COLUMN_IMAGE_RIGHTS = "image_rights";
        public static final String COLUMN_BLURB = "blurb";
        public static final String COLUMN_UNIQUE = "unique";
        public static final String COLUMN_CULTURAL_MAKER = "cultural_maker";
        public static final String COLUMN_ICONICITY = "iconicity";
        public static final String COLUMN_CAN_ACQUIRE = "can_acquire";
        public static final String COLUMN_CAN_SHARE = "can_share";
        public static final String COLUMN_SALE_MESSAGE = "sale_message";
        public static final String COLUMN_SOLD = "sold";
        public static final String COLUMN_IMAGE_VERSION_ID = "image_version";
        public static final String COLUMN_LINK_ID = "link_id";
    }

    /**
     * Class that creates the Fair (FairEntry) table
     */
    public static final class FairEntry implements BaseColumns{
        /**
         * Location for the specific table (used to access table data)
         */
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_FAIR).build();

        /**
         * The type of data I will be send if retrieved
         */
        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_FAIR;

        /**
         * Fair details sections
         * @param FairId
         * @return
         */
        public static Uri buildFairDetailAllSection(int FairId){
            return BASE_CONTENT_URI.buildUpon().appendPath("fair_detail")
                    .appendPath(Integer.toString(FairId)).build();
        }

        /**
         * Uri for the specific Fair ID in the fair table
         * @param id
         * @return
         */
        public static Uri buildFairUri(long id){
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

        /**
         * Uri for the specific Fair ID in the Fair table
         * @param FairID
         * @return
         */
        public static Uri buildFairIDUri(int FairID){
            return CONTENT_URI.buildUpon().appendPath(Integer.toString(FairID)).build();
        }

        /**
         * Uri for getting the movie id
         * @param uri
         * @return
         */
        public static String getFairID(Uri uri){
            return uri.getPathSegments().get(1);
        }

        /**
         * Uri for getting the movie id
         * @param uri
         * @return
         */
        public static int getInegerFairID(Uri uri){
            return Integer.parseInt(uri.getPathSegments().get(1));
        }

        /**
         * String holds the table name
         */
        public static final String TABLE_NAME = "fair";

        /**
         * Columns in the fair DB
         */
        public static final String COLUMN_FAIR_ID = "fair_id";
        public static final String COLUMN_CREATED_AT = "created_at";
        public static final String COLUMN_UPDATED_AT = "updated_at";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_ABOUT = "about";
        public static final String COLUMN_CONTACT = "contact";
        public static final String COLUMN_SUMMARY = "summary";
        public static final String COLUMN_START_AT = "start_at";
        public static final String COLUMN_END_AT = "end_at";
        public static final String COLUMN_STATUS = "status";
        public static final String COLUMN_PUBLISHED = "published";
        public static final String COLUMN_LINK_ID = "link_id";
    }

    /**
     * Class that creates the Gene (GeneEntry) table
     */
    public static final class GeneEntry implements BaseColumns{

    }
}
