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
    public static final String PATH_TOKEN = "token";
    public static final String PATH_ARTIST = "artist";
    public static final String PATH_ARTWORK = "artwork";
    public static final String PATH_FAIR ="fair";
    public static final String PATH_GENE = "gene";
    public static final String PATH_SHOW = "show";
    public static final String PATH_LINK = "link";
    public static final String PATH_IMAGE_VERSION = "image_version";
    public static final String PATH_IMAGE = "image";
    public static final String PATH_THUMBNAIL = "thumbnail";
    public static final String PATH_PERMALINK = "permalink";
    public static final String PATH_DIMENSION = "dimension";
    public static final String PATH_CM = "cm";
    public static final String PATH_IN = "in";
    public static final String PATH_PROFILE = "profile";
    public static final String PATH_PARTNER = "partner";
    public static final String PATH_WEBSITE = "website";
    public static final String PATH_SELF = "self";
    public static final String PATH_PARTNER_CONTACT = "partner_contact";

    /**
     * Class that creates the authorization token for the API
     */
    public static final class TokenEntry implements BaseColumns{
        /**
         * Location for the specific table (used to access table data) & api
         */
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_TOKEN).build();

        /**
         * The type of data i will be send if retrieved
         */
        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_TOKEN;

        /**
         * URI for the specific Artist row in the artist table
         * @param id - Artist identifier
         * @return - Returns Uri
         */
        public static Uri buildTokenUri(long id){
            return ContentUris.withAppendedId(CONTENT_URI,id);
        }

        /**
         * Uri for specific Artist ID int he Artist table
         * @param TokenId - Artist unique id
         * @return - Returns Uri
         */
        public static Uri buildTokenIDUri(int TokenId){
            return CONTENT_URI.buildUpon().appendPath(Integer.toString(TokenId)).build();
        }

        /**
         * Uri to get the movie id
         * @param uri
         * @return
         */
        public static String getTokenID(Uri uri){
            return uri.getPathSegments().get(1);
        }

        /**
         * Uri to get the movie id in Integer
         * @param uri
         * @return
         */
        public static int getIntegerTokenID(Uri uri){
            return Integer.parseInt(uri.getPathSegments().get(1));
        }

        /**
         * String holds the table name
         */
        public static final String TABLE_NAME = "token";

        /**
         * Columns in the token DB
         */
        public static final String COLUMN_TYPE = "type";
        public static final String COLUMN_TOKEN = "token";
        public static final String COLUMN_EXPIRES_AT = "expires_at";
    }

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
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_ARTIST;

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

        public static Uri buildArtworkImagesSection(){
            return BASE_CONTENT_URI.buildUpon().appendPath("artwork_link_image")
                    .appendPath("*").build();
        }

        public static Uri buildAllArtworkThumbnailSection(){
            return BASE_CONTENT_URI.buildUpon().appendPath("artwork_link_thumbnail")
                    .appendPath("*").build();
        }
    
        public static Uri buildArtworkThumbnail(String ArtworkId){
            return BASE_CONTENT_URI.buildUpon().appendPath("specific_artwork_link_thumbnail")
                    .appendPath(ArtworkId).build();
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

        public static String getArtworkId(Uri uri){
            return uri.getPathSegments().get(1);
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
        public static final String COLUMN_DIMENSIONS_ID = "dimension_id";
        public static final String COLUMN_PUBLISHED = "published";
        public static final String COLUMN_WEBSITE_ID = "website_id";
        public static final String COLUMN_SIGNATURE = "signature";
        public static final String COLUMN_PROVENANCE = "provenance";
        public static final String COLUMN_LITERATURE = "literature";
        public static final String COLUMN_EXHIBITION_HISTORY = "exhibition_history";
        public static final String COLUMN_COLLECTING_INSTITUTION = "collecting_institution";
        public static final String COLUMN_ADDITIONAL_INFORMATION = "additional_information";
        public static final String COLUMN_IMAGE_RIGHTS = "image_rights";
        public static final String COLUMN_BLURB = "blurb";
        public static final String COLUMN_UNIQUE = "is_unique";
        public static final String COLUMN_CULTURAL_MAKER = "cultural_maker";
        public static final String COLUMN_ICONICITY = "iconicity";
        public static final String COLUMN_CAN_INQUIRE = "can_inquire";
        public static final String COLUMN_CAN_ACQUIRE = "can_acquire";
        public static final String COLUMN_CAN_SHARE = "can_share";
        public static final String COLUMN_SALE_MESSAGE = "sale_message";
        public static final String COLUMN_SOLD = "sold";
        public static final String COLUMN_IMAGE_VERSION_ID = "image_version_id";
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
        /**
         * Location for the specific table (used to access table data)
         */
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_GENE).build();

        /**
         * The type of data I will be sending if retrieved
         */
        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" +PATH_GENE;

        /**
         * Builds gene details
         */
        public static Uri buildGeneDetailAllSection(int GeneId){
            return BASE_CONTENT_URI.buildUpon().appendPath("gene_detail")
                    .appendPath(Integer.toString(GeneId)).build();
        }

        /**
         * URI for the specific Gene row in the Gene table
         */
        public static Uri buildGeneUri(long id){
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

        /**
         * Uri for the specific Gene id in the gene table
         */
        public static Uri buildGeneIDUri(int GeneID){
            return CONTENT_URI.buildUpon().appendPath(Integer.toString(GeneID)).build();
        }

        /**
         * Uri for getting the gene id
         */
        public static String getGeneID(Uri uri){
            return uri.getPathSegments().get(1);
        }

        /**
         * Uri for getting the gene id
         */
        public static int getIntegerGeneID(Uri uri){
            return Integer.parseInt(uri.getPathSegments().get(1));
        }

        /**
         * String holds the table name
         */
        public static final String TABLE_NAME = "gene";

        /**
         * Columns in the gene table
         */
        public static final String COLUMN_GENE_ID = "gene_id";
        public static final String COLUMN_CREATED_AT = "created_at";
        public static final String COLUMN_UPDATED_AT = "updated_at";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_DISPLAY_NAME = "display_name";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_IMAGE_VERSION_ID = "image_version_id";
        public static final String COLUMN_LINK_ID = "link_id";
    }

    /**
     * Class that creates the Show (ShowEntry) table
     */
    public static final class ShowEntry implements BaseColumns{
        /**
         * Location for the specific table (used to access table data)
         */
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_SHOW).build();

        /**
         * The type of data I will be send if retrieved
         */
        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE +"/"+CONTENT_AUTHORITY +"/"+PATH_SHOW;

        /**
         * Build show detail section
         */
        public static Uri buildShowDetailAllSection(int showID){
            return BASE_CONTENT_URI.buildUpon().appendPath("show_detail")
                    .appendPath(Integer.toString(showID)).build();
        }

        /**
         * URI for the specific show row in the Show table
         */
        public static Uri buildShowUri(long id){
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

        /**
         * Uri for the specific show id in the Show table
         */
        public static Uri buildShowIDUri(int ShowID){
            return CONTENT_URI.buildUpon().appendPath(Integer.toString(ShowID)).build();
        }

        /**
         * Uri for getting the show id
         */
        public static String getShowID(Uri uri){
            return uri.getPathSegments().get(1);
        }

        /**
         * Uri for getting the show id
         */
        public static int getIntegerShowID(Uri uri){
            return Integer.parseInt(uri.getPathSegments().get(1));
        }

        /**
         * String holds the table name
         */
        public static final String TABLE_NAME = "show";

        /**
         * Columns in the show table for db
         */
        public static final String COLUMN_SHOW_ID = "show_id";
        public static final String COLUMN_CREATED_AT = "created_at";
        public static final String COLUMN_UPDATED_AT = "updated_at";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_PRESS_RELEASE = "press_release";
        public static final String COLUMN_START_AT = "start_at";
        public static final String COLUMN_END_AT = "end_at";
        public static final String COLUMN_STATUS = "status";
        public static final String COLUMN_IMAGE_VERSION_ID = "image_version_id";
        public static final String COLUMN_LINK_ID = "link_id";
    }

    /**
     * Class that creates the Link (LinkEntry) table
     */
    public static final class LinkEntry implements BaseColumns{
        /**
         * Location for the specific table (used to access table data)
         */
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_LINK).build();

        /**
         * The type of data I will be send if retrieved
         */
        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE +"/" +CONTENT_AUTHORITY + "/"+PATH_LINK;

        /**
         * Build Link section detail
         */
        public static Uri buildLinkDetailAllSection(int LinkId){
            return BASE_CONTENT_URI.buildUpon().appendPath("link_detail")
                    .appendPath(Integer.toString(LinkId)).build();
        }

        /**
         * URI for the specific Link row in the Link table
         */
        public static Uri buildLinkUri(long id){
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    
        /**
         * Link details for the URI for the specific link id
         */
        public static Uri buildLinkDetailUri(String LinkId){
            return CONTENT_URI.buildUpon().appendPath("link_detail")
                    .appendPath(LinkId).build();
        }
        
        /**
         * URI for the specific Link Id in the Link Table
         */
        public static Uri buildLinkIdUri(int LinkID){
            return CONTENT_URI.buildUpon().appendPath(Integer.toString(LinkID)).build();
        }

        /**
         * Uri for getting the link id
         */
        public static String getLinkID(Uri uri){
            return uri.getPathSegments().get(1);
        }

        /**
         * Uri for getting the link id
         */
        public static int getIntegerLinkID(Uri uri){
            return Integer.parseInt(uri.getPathSegments().get(1));
        }

        /**
         * String holds the table name
         */
        public static final String TABLE_NAME = "link";

        /**
         * Columns in the Link table for the DB
         */
        public static final String COLUMN_LINK_ID = "link_id";
        public static final String COLUMN_SELF_ID = "self_id";
        public static final String COLUMN_LINK_TYPE = "link_type";
        public static final String COLUMN_IMAGE_ID = "image_id";
        public static final String COLUMN_THUMBNAIL_ID = "thumbnail_id";
        public static final String COLUMN_PERMALINK_ID = "permalink_id";
        public static final String COLUMN_PARTNER_CONTACT_ID = "partner_contact_id";
        public static final String COLUMN_WEBSITE_ID = "website_id";
        public static final String COLUMN_PROFILE_ID = "profile_id";
        public static final String COLUMN_PARTNER_ID = "partner_id";
    }

    /**
     * Class that creates the Image Version (ImageVersionEntry) table
     */
    public static final class ImageVersionEntry implements BaseColumns{
        /**
         * Location for the specific table (used to access table data)
         */
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_IMAGE_VERSION).build();

        /**
         * The type of data I will be sending if retrieved
         */
        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/"+ CONTENT_AUTHORITY+"/"+PATH_IMAGE_VERSION;

        /**
         * Build the Image Version detail section
         */
        public static Uri buildImageVersionDetailAllSection(int IV_Id){
            return BASE_CONTENT_URI.buildUpon().appendPath("image_version_detail")
                    .appendPath(Integer.toString(IV_Id)).build();
        }

        /**
         * URI for the specific Image Version row in the Image Version Table
         */
        public static Uri buildImageVersionUri(long id){
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

        /**
         * Uri for the specific Image Version ID in the Image Version table
         */
        public static Uri buildImageVersionIDUri(int IV_ID){
            return CONTENT_URI.buildUpon().appendPath(Integer.toString(IV_ID)).build();
        }

        /**
         * Uri for getting the ImageVersion id
         */
        public static String getImageVersionID(Uri uri){
            return uri.getPathSegments().get(1);
        }

        /**
         * Uri for getting the ImageVersion id
         */
        public static int getIntegerImageVersionId(Uri uri){
            return Integer.parseInt(uri.getPathSegments().get(1));
        }

        /**
         * String holds the table name
         */
        public static final String TABLE_NAME = "image_version";

        /**
         * Columns in the image_version table in the db
         */
        public static final String COLUMN_IMAGE_VERSION_ID = "image_version_id";
        public static final String COLUMN_VERSION_TYPE = "version_type";
    }

    /**
     * Class that creates the Image (ImageEntry) table
     */
    public static final class ImageEntry implements BaseColumns{
        /**
         * Location for the specific table (used to access table data)
         */
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_IMAGE).build();

        /**
         * The type of data I will be sending if retrieved
         */
        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_IMAGE;

        /**
         * URI for the specific Image row in the movie table
         */
        public static Uri buildImageUri(long id){
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

        /**
         * Uri for the specific Image ID in the Image table
         */
        public static Uri buildImageIDUri(int ImageID){
            return CONTENT_URI.buildUpon().appendPath(Integer.toString(ImageID)).build();
        }

        /**
         * Uri for getting the Image id
         */
        public static String getImageID(Uri uri){
            return uri.getPathSegments().get(1);
        }

        /**
         * Uri for getting the Image Id
         */
        public static int getIntegerImageID(Uri uri){
            return Integer.parseInt(uri.getPathSegments().get(1));
        }

        /**
         * String holds the table name
         */
        public static final String TABLE_NAME = "image";

        /**
         * Column in the Image table for DB
         */
        public static final String COLUMN_IMAGE_ID = "image_id";
        public static final String COLUMN_TEMPLATED = "templated";
        public static final String COLUMN_HREF = "href";
    }

    /**
     * Class that creates the Thumbnail (ThumbnailEntry) table
     */
    public static final class ThumbnailEntry implements BaseColumns{
        /**
         * Location for the specific table (used to access table data)
         */
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_THUMBNAIL).build();

        /**
         * The type of data I will be sending if retrieved
         */
        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_THUMBNAIL;

        /**
         * URI for the specific Thumbnail row in the Thumbnail table
         */
        public static Uri buildThumbnailUri(long id){
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

        /**
         * Uri for the specific Thumbnail ID in the Thumbnail table
         */
        public static Uri buildThumbnailIDUri(int ThumbnailID){
            return CONTENT_URI.buildUpon().appendPath(Integer.toString(ThumbnailID)).build();
        }

        /**
         * Uri for getting the Thumbnail id
         */
        public static String getThumbnailID(Uri uri){
            return uri.getPathSegments().get(1);
        }

        /**
         * Uri for getting the Thumbnail Id
         */
        public static int getIntegerThumbnailID(Uri uri){
            return Integer.parseInt(uri.getPathSegments().get(1));
        }

        /**
         * String holds the table name
         */
        public static final String TABLE_NAME = "thumbnail";

        /**
         * Column in the Thumbnail table for DB
         */
        public static final String COLUMN_THUMBNAIL_ID = "thumbnail_id";
        public static final String COLUMN_HREF = "href";
    }

    /**
     * Class that creates the Permalink (PermalinkEntry) table
     */
    public static final class PermalinkEntry implements BaseColumns{
        /**
         * Location for the specific table (used to access table data)
         */
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_PERMALINK).build();

        /**
         * The type of data I will be sending if retrieved
         */
        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PERMALINK;

        /**
         * URI for the specific Permalink row in the Permalink table
         */
        public static Uri buildPermalinkUri(long id){
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

        /**
         * Uri for the specific Permalink ID in the Permalink table
         */
        public static Uri buildPermalinkIDUri(int PermalinkID){
            return CONTENT_URI.buildUpon().appendPath(Integer.toString(PermalinkID)).build();
        }

        /**
         * Uri for getting the Permalink id
         */
        public static String getPermalinkID(Uri uri){
            return uri.getPathSegments().get(1);
        }

        /**
         * Uri for getting the Permalink Id
         */
        public static int getIntegerPermalinkID(Uri uri){
            return Integer.parseInt(uri.getPathSegments().get(1));
        }

        /**
         * String holds the table name
         */
        public static final String TABLE_NAME = "permalink";

        /**
         * Column in the Permalink table for DB
         */
        public static final String COLUMN_PERMALINK_ID = "permalink_id";
        public static final String COLUMN_HREF = "href";
    }

    /**
     * Class that creates the Profile (ProfileEntry) table
     */
    public static final class ProfileEntry implements BaseColumns{
        /**
         * Location for the specific table (used to access table data)
         */
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_PROFILE).build();

        /**
         * The type of data I will be sending if retrieved
         */
        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PROFILE;

        /**
         * URI for the specific Profile row in the Profile table
         */
        public static Uri buildProfileUri(long id){
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

        /**
         * Uri for the specific Profile ID in the Profile table
         */
        public static Uri buildProfileIDUri(int ProfileID){
            return CONTENT_URI.buildUpon().appendPath(Integer.toString(ProfileID)).build();
        }

        /**
         * Uri for getting the Profile id
         */
        public static String getProfileID(Uri uri){
            return uri.getPathSegments().get(1);
        }

        /**
         * Uri for getting the Profile Id
         */
        public static int getIntegerProfileID(Uri uri){
            return Integer.parseInt(uri.getPathSegments().get(1));
        }

        /**
         * String holds the table name
         */
        public static final String TABLE_NAME = "profile";

        /**
         * Column in the Profile table for DB
         */
        public static final String COLUMN_PROFILE_ID = "profile_id";
        public static final String COLUMN_HREF = "href";
    }

    /**
     * Class that creates the Website (WebsiteEntry) table
     */
    public static final class WebsiteEntry implements BaseColumns{
        /**
         * Location for the specific table (used to access table data)
         */
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_WEBSITE).build();

        /**
         * The type of data I will be sending if retrieved
         */
        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_WEBSITE;

        /**
         * URI for the specific Website row in the Website table
         */
        public static Uri buildWebsiteUri(long id){
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

        /**
         * Uri for the specific Website ID in the Website table
         */
        public static Uri buildWebsiteIDUri(int WebsiteID){
            return CONTENT_URI.buildUpon().appendPath(Integer.toString(WebsiteID)).build();
        }

        /**
         * Uri for getting the Website id
         */
        public static String getWebsiteID(Uri uri){
            return uri.getPathSegments().get(1);
        }

        /**
         * Uri for getting the Website Id
         */
        public static int getIntegerWebsiteID(Uri uri){
            return Integer.parseInt(uri.getPathSegments().get(1));
        }

        /**
         * String holds the table name
         */
        public static final String TABLE_NAME = "website";

        /**
         * Column in the Website table for DB
         */
        public static final String COLUMN_WEBSITE_ID = "website_id";
        public static final String COLUMN_HREF = "href";
    }

    /**
     * Class that creates the Self (SelfEntry) table
     */
    public static final class SelfEntry implements BaseColumns{
        /**
         * Location for the specific table (used to access table data)
         */
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_SELF).build();

        /**
         * The type of data I will be sending if retrieved
         */
        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_SELF;

        /**
         * URI for the specific Self row in the Self table
         */
        public static Uri buildSelfUri(long id){
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

        /**
         * Uri for the specific Self ID in the Self table
         */
        public static Uri buildSelfIDUri(int SelfID){
            return CONTENT_URI.buildUpon().appendPath(Integer.toString(SelfID)).build();
        }

        /**
         * Uri for getting the Self id
         */
        public static String getSelfID(Uri uri){
            return uri.getPathSegments().get(1);
        }

        /**
         * Uri for getting the Self Id
         */
        public static int getIntegerSelfID(Uri uri){
            return Integer.parseInt(uri.getPathSegments().get(1));
        }

        /**
         * String holds the table name
         */
        public static final String TABLE_NAME = "self";

        /**
         * Column in the Self table for DB
         */
        public static final String COLUMN_SELF_ID = "self_id";
        public static final String COLUMN_HREF = "href";
    }

    /**
     * Class that creates the PartnerContacts (PartnerContactsEntry) table
     */
    public static final class PartnerContactEntry implements BaseColumns{
        /**
         * Location for the specific table (used to access table data)
         */
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_PARTNER_CONTACT).build();

        /**
         * The type of data I will be sending if retrieved
         */
        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PARTNER_CONTACT;

        /**
         * URI for the specific Partner Contact row in the Partner Contact table
         */
        public static Uri buildPartnerContactUri(long id){
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

        /**
         * Uri for the specific Partner Contact ID in the Partner Contact table
         */
        public static Uri buildPartnerContactIDUri(int PCID){
            return CONTENT_URI.buildUpon().appendPath(Integer.toString(PCID)).build();
        }

        /**
         * Uri for getting the Partner Contact id
         */
        public static String getSelfID(Uri uri){
            return uri.getPathSegments().get(1);
        }

        /**
         * Uri for getting the Partner Contact Id
         */
        public static int getIntegerSelfID(Uri uri){
            return Integer.parseInt(uri.getPathSegments().get(1));
        }

        /**
         * String holds the table name
         */
        public static final String TABLE_NAME = "partner_contact";

        /**
         * Column in the Partner Contact table for DB
         */
        public static final String COLUMN_PARTNER_CONTACT_ID = "partner_contact_id";
        public static final String COLUMN_HREF = "href";
    }

    /**
     * Class that creates the Partner (PartnerEntry) table
     */
    public static final class PartnerEntry implements BaseColumns {
        /**
         * Location for the specific table (used to access table data)
         */
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_PARTNER).build();

        /**
         * The type of data I will be sending if retrieved
         */
        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PARTNER;

        /**
         * URI for the specific Partner row in the Partner table
         */
        public static Uri buildPartnerUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

        /**
         * Uri for the specific Partner ID in the Partner table
         */
        public static Uri buildPartnerIDUri(int PartnerID) {
            return CONTENT_URI.buildUpon().appendPath(Integer.toString(PartnerID)).build();
        }

        /**
         * Uri for getting the Partner id
         */
        public static String getPartnerID(Uri uri) {
            return uri.getPathSegments().get(1);
        }

        /**
         * Uri for getting the Partner Id
         */
        public static int getIntegerPartnerID(Uri uri) {
            return Integer.parseInt(uri.getPathSegments().get(1));
        }

        /**
         * String holds the table name
         */
        public static final String TABLE_NAME = "partner";

        /**
         * Column in the Partner table for DB
         */
        public static final String COLUMN_PARTNER_ID = "partners_id";
        public static final String COLUMN_SLUG = "slug";
        public static final String COLUMN_CREATEDAT = "created_at";
        public static final String COLUMN_UPDATEDAT = "updated_at";
        public static final String COLUMN_TYPE = "type";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_EMAIL = "email";
        public static final String COLUMN_REGION = "region";
    }

    /**
     * Class that creates the Dimension (DimensionEntry) table
     */
    public static final class DimensionEntry implements BaseColumns{
        /**
         * Location for the specific table (used to access table data)
         */
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_DIMENSION).build();

        /**
         * The type of data I will be sending if retrieved
         */
        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_DIMENSION;

        /**
         * URI for the specific Dimension row in the Dimension table
         */
        public static Uri buildDimensionUri(long id){
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

        /**
         * Uri for the specific Dimension ID in the Dimension table
         */
        public static Uri buildDimensionDUri(int DimensionID){
            return CONTENT_URI.buildUpon().appendPath(Integer.toString(DimensionID)).build();
        }

        /**
         * Uri for getting the Dimension id
         */
        public static String getDimensionID(Uri uri){
            return uri.getPathSegments().get(1);
        }

        /**
         * Uri for getting the Dimension Id
         */
        public static int getIntegerDimensionID(Uri uri){
            return Integer.parseInt(uri.getPathSegments().get(1));
        }

        /**
         * String holds the table name
         */
        public static final String TABLE_NAME = "dimension";

        /**
         * Column in the Dimension table for DB
         */
        public static final String COLUMN_DIMENSION_ID = "dimension_id";
        public static final String COLUMN_CM_ID = "cm_id";
        public static final String COLUMN_IN_ID = "in_id";
    }

    /**
     * Class that creates the CM (CMEntry) table
     */
    public static final class CMEntry implements BaseColumns{
        /**
         * Location for the specific table (used to access table data)
         */
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_CM).build();

        /**
         * The type of data I will be sending if retrieved
         */
        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_CM;

        /**
         * URI for the specific CM row in the CM table
         */
        public static Uri buildCMUri(long id){
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

        /**
         * Uri for the specific CM ID in the CM table
         */
        public static Uri buildCMDUri(int CMID){
            return CONTENT_URI.buildUpon().appendPath(Integer.toString(CMID)).build();
        }

        /**
         * Uri for getting the CM id
         */
        public static String getCMID(Uri uri){
            return uri.getPathSegments().get(1);
        }

        /**
         * Uri for getting the CM Id
         */
        public static int getIntegerCMID(Uri uri){
            return Integer.parseInt(uri.getPathSegments().get(1));
        }

        /**
         * String holds the table name
         */
        public static final String TABLE_NAME = "cm";

        /**
         * Column in the CM table for DB
         */
        public static final String COLUMN_CM_ID = "cm_id";
        public static final String COLUMN_TEXT = "text";
        public static final String COLUMN_HEIGHT = "height";
        public static final String COLUMN_WIDTH = "width";
        public static final String COLUMN_DEPTH = "depth";
        public static final String COLUMN_DIAMETER = "diameter";
    }

    /**
     * Class that creates the IN (INEntry) table
     */
    public static final class INEntry implements BaseColumns{
        /**
         * Location for the specific table (used to access table data)
         */
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_IN).build();

        /**
         * The type of data I will be sending if retrieved
         */
        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_IN;

        /**
         * URI for the specific IN row in the CM table
         */
        public static Uri buildINUri(long id){
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

        /**
         * Uri for the specific IN ID in the IN table
         */
        public static Uri buildINIDUri(int INID){
            return CONTENT_URI.buildUpon().appendPath(Integer.toString(INID)).build();
        }

        /**
         * Uri for getting the IN id
         */
        public static String getINID(Uri uri){
            return uri.getPathSegments().get(1);
        }

        /**
         * Uri for getting the IN Id
         */
        public static int getIntegerINID(Uri uri){
            return Integer.parseInt(uri.getPathSegments().get(1));
        }

        /**
         * String holds the table name
         */
        public static final String TABLE_NAME = "in_";

        /**
         * Column in the IN table for DB
         */
        public static final String COLUMN_IN_ID = "in_id";
        public static final String COLUMN_TEXT = "text";
        public static final String COLUMN_HEIGHT = "height";
        public static final String COLUMN_WIDTH = "width";
        public static final String COLUMN_DEPTH = "depth";
        public static final String COLUMN_DIAMETER = "diameter";
    }

}
