package com.prj1.stand.artworldviewer.data;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * ArtWorldViewer handle the SQLite query create (insertion, deletion, and updates)
 *
 * Created by Stand on 5/13/2017.
 */

public class DbProvider extends ContentProvider {
    private static final UriMatcher dbProviderUriMatcher = buildUriMatcher();
    private DbHelper dbHelper;

    /**
     * Static constants for app tables
     */
    static final int ARTIST = 100;
    static final int ARTWORK = 101;
    static final int FAIR = 102;
    static final int GENE = 103;
    static final int SHOW = 104;
    static final int DIMENSION = 105;
    static final int CM = 106;
    static final int IN = 107;
    static final int IMAGE = 108;
    static final int IMAGE_VERSION = 109;
    static final int LINK = 110;
    static final int PARTNER = 111;
    static final int PERMALINK = 112;
    static final int PROFILE = 113;
    static final int THUMBNAIL = 114;
    static final int WEBSITE = 115;
    static final int SELF = 116;
    static final int PARTNER_CONTACT = 117;

    /**
     * Static constants for app unique row identifies
     */
    static final int ARTIST_ID = 200;
    static final int ARTWORK_ID = 201;
    static final int FAIR_ID = 202;
    static final int GENE_ID = 203;
    static final int SHOW_ID = 204;
    static final int DIMENSION_ID = 205;
    static final int IMAGE_ID = 206;
    static final int IMAGE_VERSION_ID = 207;
    static final int LINK_ID = 208;
    static final int PARTNER_ID = 209;
    static final int PERMALINK_ID = 210;
    static final int PROFILE_ID = 211;
    static final int THUMBNAIL_ID = 212;
    static final int WEBSITE_ID = 213;
    static final int SELF_ID = 214;
    static final int PARTNER_CONACT_ID = 215;

    /**
     * Declaring the query object that will hold the inner join for the table
     */
    private static final SQLiteQueryBuilder SLQB_ArtistWithLinks;
    private static final SQLiteQueryBuilder SLQB_ArtworkWithDimensions;
    private static final SQLiteQueryBuilder SLQB_ArtworkWithWebsites;
    private static final SQLiteQueryBuilder SLQB_ArtworkWithImageVersions;
    private static final SQLiteQueryBuilder SLQB_ArtworkWithLinks;
    private static final SQLiteQueryBuilder SLQB_FairWithLinks;
    private static final SQLiteQueryBuilder SLQB_GeneWithLinks;
    private static final SQLiteQueryBuilder SLQB_ShowWithImageVersions;
    private static final SQLiteQueryBuilder SLQB_ShowWithLinks;
    private static final SQLiteQueryBuilder SLQB_LinkWithSelf;
    private static final SQLiteQueryBuilder SLQB_LinkWithImage;
    private static final SQLiteQueryBuilder SLQB_LinkWithThumbnail;
    private static final SQLiteQueryBuilder SLQB_LinkWithPermalink;
    private static final SQLiteQueryBuilder SLQB_LinkWithPartnerContact;
    private static final SQLiteQueryBuilder SLQB_LinkWithWebsite;
    private static final SQLiteQueryBuilder SLQB_LinkWithProfile;
    private static final SQLiteQueryBuilder SLQB_DimensionWithCM;
    private static final SQLiteQueryBuilder SLQB_DimensionWithIN;

    /**
     * Defining the query objects and its inner join
     */
    static {
        SLQB_ArtistWithLinks = new SQLiteQueryBuilder();
        SLQB_ArtworkWithDimensions = new SQLiteQueryBuilder();
        SLQB_ArtworkWithWebsites = new SQLiteQueryBuilder();
        SLQB_ArtworkWithImageVersions = new SQLiteQueryBuilder();
        SLQB_ArtworkWithLinks = new SQLiteQueryBuilder();
        SLQB_FairWithLinks = new SQLiteQueryBuilder();
        SLQB_GeneWithLinks = new SQLiteQueryBuilder();
        SLQB_ShowWithImageVersions = new SQLiteQueryBuilder();
        SLQB_ShowWithLinks = new SQLiteQueryBuilder();
        SLQB_LinkWithSelf = new SQLiteQueryBuilder();
        SLQB_LinkWithImage = new SQLiteQueryBuilder();
        SLQB_LinkWithThumbnail = new SQLiteQueryBuilder();
        SLQB_LinkWithPermalink = new SQLiteQueryBuilder();
        SLQB_LinkWithPartnerContact = new SQLiteQueryBuilder();
        SLQB_LinkWithWebsite = new SQLiteQueryBuilder();
        SLQB_LinkWithProfile = new SQLiteQueryBuilder();
        SLQB_DimensionWithCM = new SQLiteQueryBuilder();
        SLQB_DimensionWithIN = new SQLiteQueryBuilder();

        /**
         * This is an inner join which looks at
         * Link INNER JOIN Artist on Artist.link_id = Link.link_id
          */
        SLQB_ArtistWithLinks.setTables(
                DbContract.LinkEntry.TABLE_NAME + " INNER JOIN " +
                        DbContract.ArtistEntry.TABLE_NAME +
                        " ON " + DbContract.ArtistEntry.TABLE_NAME +
                        "." + DbContract.ArtistEntry.COLUMN_LINK_ID +
                        " = " + DbContract.LinkEntry.TABLE_NAME +
                        "." + DbContract.LinkEntry.COLUMN_LINK_ID
        );

        /**
         * This is an inner join which looks at
         * Dimension INNER JOIN Artwork on Artwork.dimension_id = Dimension.dimension_id
         */
        SLQB_ArtworkWithDimensions.setTables(
                DbContract.DimensionEntry.TABLE_NAME + " INNER JOIN " +
                        DbContract.ArtworkEntry.TABLE_NAME +
                        " ON " + DbContract.ArtworkEntry.TABLE_NAME +
                        "." + DbContract.ArtworkEntry.COLUMN_DIMESIONS_ID +
                        " = " + DbContract.DimensionEntry.TABLE_NAME +
                        "." + DbContract.DimensionEntry.COLUMN_DIMENSION_ID
        );

        /**
         * This is an inner join which looks at
         * Website INNER JOIN Artwork on Artwork.website_id = Website.website_id
         */
        SLQB_ArtworkWithWebsites.setTables(
                DbContract.WebsiteEntry.TABLE_NAME + " INNER JOIN " +
                        DbContract.ArtworkEntry.TABLE_NAME +
                        " ON " + DbContract.ArtworkEntry.TABLE_NAME +
                        "." + DbContract.ArtworkEntry.COLUMN_WEBSITE_ID +
                        " = " + DbContract.WebsiteEntry.TABLE_NAME +
                        "." + DbContract.WebsiteEntry.COLUMN_WEBSITE_ID
        );

        /**
         * This is an inner join which looks at
         * ImageVersion INNER JOIN Artwork on Artwork.image_version_id = ImageVersion.image_version_id
         */
        SLQB_ArtworkWithImageVersions.setTables(
                DbContract.ImageVersionEntry.TABLE_NAME + " INNER JOIN " +
                        DbContract.ArtworkEntry.TABLE_NAME +
                        " ON " + DbContract.ArtworkEntry.TABLE_NAME +
                        "." + DbContract.ArtworkEntry.COLUMN_IMAGE_VERSION_ID +
                        " = " + DbContract.ImageVersionEntry.TABLE_NAME +
                        "." + DbContract.ImageVersionEntry.COLUMN_IMAGE_VERSION_ID
        );

        /**
         * This is an inner join which looks at
         * Link INNER JOIN Artwork on Artwork.link_id = Link.link_id
         */
        SLQB_ArtworkWithLinks.setTables(
                DbContract.LinkEntry.TABLE_NAME + " INNER JOIN " +
                        DbContract.ArtworkEntry.TABLE_NAME +
                        " ON " + DbContract.ArtworkEntry.TABLE_NAME +
                        "." + DbContract.ArtworkEntry.COLUMN_LINK_ID +
                        " = " + DbContract.LinkEntry.TABLE_NAME +
                        "." + DbContract.LinkEntry.COLUMN_LINK_ID
        );

        /**
         * This is an inner join which looks at
         * Link INNER JOIN Fair on Fair.link_id = Link.link_id
         */
        SLQB_FairWithLinks.setTables(
                DbContract.LinkEntry.TABLE_NAME + " INNER JOIN " +
                        DbContract.FairEntry.TABLE_NAME +
                        " ON " + DbContract.FairEntry.TABLE_NAME +
                        "." + DbContract.FairEntry.COLUMN_LINK_ID +
                        " = " + DbContract.LinkEntry.TABLE_NAME +
                        "." + DbContract.LinkEntry.COLUMN_LINK_ID
        );

        /**
         * This is an inner join which looks at
         * Link INNER JOIN Gene on Gene.link_id = Link.link_id
         */
        SLQB_GeneWithLinks.setTables(
                DbContract.LinkEntry.TABLE_NAME + " INNER JOIN " +
                        DbContract.GeneEntry.TABLE_NAME +
                        " ON " + DbContract.GeneEntry.TABLE_NAME +
                        "." + DbContract.GeneEntry.COLUMN_LINK_ID +
                        " = " + DbContract.LinkEntry.TABLE_NAME +
                        "." + DbContract.LinkEntry.COLUMN_LINK_ID
        );

        /**
         * This is an inner join which looks at
         * ImageVersion INNER JOIN Show on Show.image_version_id = ImageVersion.image_version_id
         */
        SLQB_ShowWithImageVersions.setTables(
                DbContract.ImageVersionEntry.TABLE_NAME + " INNER JOIN " +
                        DbContract.ShowEntry.TABLE_NAME +
                        " ON " + DbContract.ShowEntry.TABLE_NAME +
                        "." + DbContract.ShowEntry.COLUMN_IMAGE_VERSION_ID +
                        " = " + DbContract.ImageVersionEntry.TABLE_NAME +
                        "." + DbContract.ImageVersionEntry.COLUMN_IMAGE_VERSION_ID
        );

        /**
         * This is an inner join which looks at
         * Link INNER JOIN Show on Show.link_id = Link.link_id
         */
        SLQB_ShowWithLinks.setTables(
                DbContract.LinkEntry.TABLE_NAME + " INNER JOIN " +
                        DbContract.ShowEntry.TABLE_NAME +
                        " ON " + DbContract.ShowEntry.TABLE_NAME +
                        "." + DbContract.ShowEntry.COLUMN_LINK_ID +
                        " = " + DbContract.LinkEntry.TABLE_NAME +
                        "." + DbContract.LinkEntry.COLUMN_LINK_ID
        );

        /**
         * This inner join which looks at
         * Self INNER JOIN Link on Link.self_id = Self.self_id
         */
        SLQB_LinkWithSelf.setTables(
                DbContract.SelfEntry.TABLE_NAME + " INNER JOIN " +
                        DbContract.LinkEntry.TABLE_NAME +
                        " ON " + DbContract.LinkEntry.TABLE_NAME +
                        "." + DbContract.LinkEntry.COLUMN_SELF_ID +
                        " = " + DbContract.SelfEntry.TABLE_NAME +
                        "." + DbContract.SelfEntry.COLUMN_SELF_ID
        );

        /**
         * This inner join which looks at
         * Image INNER JOIN Link on Link.image_id = Self.image_id
         */
        SLQB_LinkWithImage.setTables(
                DbContract.ImageEntry.TABLE_NAME + " INNER JOIN " +
                        DbContract.LinkEntry.TABLE_NAME +
                        " ON " + DbContract.LinkEntry.TABLE_NAME +
                        "." + DbContract.LinkEntry.COLUMN_IMAGE_ID +
                        " = " + DbContract.ImageEntry.TABLE_NAME +
                        "." + DbContract.ImageEntry.COLUMN_IMAGE_ID
        );

        /**
         * This inner join which looks at
         * Thumbnail INNER JOIN Link on Link.thumbnail_id = Thumbnail.thumbnail_id
         */
        SLQB_LinkWithThumbnail.setTables(
                DbContract.ThumbnailEntry.TABLE_NAME + " INNER JOIN " +
                        DbContract.LinkEntry.TABLE_NAME +
                        " ON " + DbContract.LinkEntry.TABLE_NAME +
                        "." + DbContract.LinkEntry.COLUMN_THUMBNAIL_ID +
                        " = " + DbContract.ThumbnailEntry.TABLE_NAME +
                        "." + DbContract.ThumbnailEntry.COLUMN_THUMBNAIL_ID
        );

        /**
         * This inner join which looks at
         * Permalink INNER JOIN Link on Link.permalink_id = Permalink.permalink_id
         */
        SLQB_LinkWithPermalink.setTables(
                DbContract.PermalinkEntry.TABLE_NAME + " INNER JOIN " +
                        DbContract.LinkEntry.TABLE_NAME +
                        " ON " + DbContract.LinkEntry.TABLE_NAME +
                        "." + DbContract.LinkEntry.COLUMN_PERMALINK_ID +
                        " = " + DbContract.PermalinkEntry.TABLE_NAME +
                        "." + DbContract.PermalinkEntry.COLUMN_PERMALINK_ID
        );

        /**
         * This inner join which looks at
         * PartnerContact INNER JOIN Link on Link.partnerContact_id = PartnerContact.partnerContact_id
         */
        SLQB_LinkWithPartnerContact.setTables(
                DbContract.PartnerContactEntry.TABLE_NAME + " INNER JOIN " +
                        DbContract.LinkEntry.TABLE_NAME +
                        " ON " + DbContract.LinkEntry.TABLE_NAME +
                        "." + DbContract.LinkEntry.COLUMN_PARTNER_CONTACT_ID +
                        " = " + DbContract.PartnerContactEntry.TABLE_NAME +
                        "." + DbContract.PartnerContactEntry.COLUMN_PARTNER_CONTACT_ID
        );

        /**
         * This inner join which looks at
         * Website INNER JOIN Link on Link.website_id = Website.website_id
         */
        SLQB_LinkWithWebsite.setTables(
                DbContract.WebsiteEntry.TABLE_NAME + " INNER JOIN " +
                        DbContract.LinkEntry.TABLE_NAME +
                        " ON " + DbContract.LinkEntry.TABLE_NAME +
                        "." + DbContract.LinkEntry.COLUMN_WEBSITE_ID +
                        " = " + DbContract.WebsiteEntry.TABLE_NAME +
                        "." + DbContract.WebsiteEntry.COLUMN_WEBSITE_ID
        );

        /**
         * This inner join which looks at
         * Profile INNER JOIN Link on Link.profile_id = Profile.profile_id
         */
        SLQB_LinkWithProfile.setTables(
                DbContract.ProfileEntry.TABLE_NAME + " INNER JOIN " +
                        DbContract.LinkEntry.TABLE_NAME +
                        " ON " + DbContract.LinkEntry.TABLE_NAME +
                        "." + DbContract.LinkEntry.COLUMN_PROFILE_ID +
                        " = " + DbContract.ProfileEntry.TABLE_NAME +
                        "." + DbContract.ProfileEntry.COLUMN_PROFILE_ID
        );

        /**
         * This inner join which looks at
         * CM INNER JOIN dimension on Dimension.cm_id = In.cm_id
         */
        SLQB_DimensionWithCM.setTables(
                DbContract.CMEntry.TABLE_NAME + " INNER JOIN " +
                        DbContract.DimensionEntry.TABLE_NAME +
                        " ON " + DbContract.DimensionEntry.TABLE_NAME +
                        "." + DbContract.DimensionEntry.COLUMN_CM_ID +
                        " = " + DbContract.CMEntry.TABLE_NAME +
                        "." + DbContract.CMEntry.COLUMN_CM_ID
        );

        /**
         * This inner join which looks at
         * IN INNER JOIN dimension on Dimension.in_id = In.in_id
         */
        SLQB_DimensionWithIN.setTables(
                DbContract.INEntry.TABLE_NAME + " INNER JOIN " +
                        DbContract.DimensionEntry.TABLE_NAME +
                        " ON " + DbContract.DimensionEntry.TABLE_NAME +
                        "." + DbContract.DimensionEntry.COLUMN_IN_ID +
                        " = " + DbContract.INEntry.TABLE_NAME +
                        "." + DbContract.INEntry.COLUMN_IN_ID
        );
    }

    /**
     * SQL for setting selection for Artist.artist_id = ?
     */
    public static final String SQL_ArtistIdSettingSelection =
            DbContract.ArtistEntry.TABLE_NAME +
                    "." + DbContract.ArtistEntry.COLUMN_ARTIST_ID + " = ? ";

    /**
     * SQL for setting selection for Artwork.artwork_id = ?
     */
    public static final String SQL_ArtworkIdSettingSelection =
            DbContract.ArtworkEntry.TABLE_NAME +
                    "." + DbContract.ArtworkEntry.COLUMN_ARTWORK_ID + " = ? ";

    /**
     * SQL for setting selection for Fair.fair_id = ?
     */
    public static final String SQL_FairIdSettingSelection =
            DbContract.FairEntry.TABLE_NAME +
                    "." + DbContract.FairEntry.COLUMN_FAIR_ID + " = ? ";

    /**
     * SQL for setting selection for Gene.gene_id = ?
     */
    public static final String SQL_GeneIdSettingSelection =
            DbContract.GeneEntry.TABLE_NAME +
                    "." + DbContract.GeneEntry.COLUMN_GENE_ID + " = ? ";

    /**
     * SQL for setting selection for Show.show_id = ?
     */
    public static final String SQL_ShowIdSettingSelection =
            DbContract.ShowEntry.TABLE_NAME +
                    "." + DbContract.ShowEntry.COLUMN_SHOW_ID + " = ? ";

    /**
     * SQL for setting selection for Dimension.dimension_id = ?
     */
    public static final String SQL_DimensionIdSettingSelection =
            DbContract.DimensionEntry.TABLE_NAME +
                    "." + DbContract.DimensionEntry.COLUMN_DIMENSION_ID + " = ? ";

    /**
     * SQL for setting selection for CM.cm_id = ?
     */
    public static final String SQL_CMIdSettingSelection =
            DbContract.CMEntry.TABLE_NAME +
                    "." + DbContract.CMEntry.COLUMN_CM_ID + " = ? ";

    /**
     * SQL for setting selection for IN.in_id = ?
     */
    public static final String SQL_INIdSettingSelection =
            DbContract.INEntry.TABLE_NAME +
                    "." + DbContract.INEntry.COLUMN_IN_ID + " = ? ";

    /**
     * SQL for setting selection for Image.image_id = ?
     */
    public static final String SQL_ImageIdSettingSelection =
            DbContract.ImageEntry.TABLE_NAME +
                    "." + DbContract.ImageEntry.COLUMN_IMAGE_ID + " = ? ";

    /**
     * SQL for setting selection for ImageVersion.image_version_id = ?
     */
    public static final String SQL_ImageVersionIdSettingSelection =
            DbContract.ImageVersionEntry.TABLE_NAME +
                    "." + DbContract.ImageVersionEntry.COLUMN_IMAGE_VERSION_ID + " = ? ";

    /**
     * SQL for setting selection for Link.link_id = ?
     */
    public static final String SQL_LinkIdSettingSelection =
            DbContract.LinkEntry.TABLE_NAME +
                    "." + DbContract.LinkEntry.COLUMN_LINK_ID + " = ? ";

    /**
     * SQL for setting selection for Partner.partner_id = ?
     */
    public static final String SQL_PartnerIdSettingSelection =
            DbContract.PartnerEntry.TABLE_NAME +
                    "." + DbContract.PartnerEntry.COLUMN_PARTNER_ID + " = ? ";

    /**
     * SQL for setting selection for Permalink.permalink_id = ?
     */
    public static final String SQL_PermalinkIdSettingSelection =
            DbContract.PermalinkEntry.TABLE_NAME +
                    "." + DbContract.PermalinkEntry.COLUMN_PERMALINK_ID + " = ? ";

    /**
     * SQL for setting selection for Profile.profile_id = ?
     */
    public static final String SQL_ProfileIdSettingSelection =
            DbContract.ProfileEntry.TABLE_NAME +
                    "." + DbContract.ProfileEntry.COLUMN_PROFILE_ID + " = ? ";

    /**
     * SQL for setting selection for Thumbnail.thumbnail_id = ?
     */
    public static final String SQL_ThumbnailIdSettingSelection =
            DbContract.ThumbnailEntry.TABLE_NAME +
                    "." + DbContract.ThumbnailEntry.COLUMN_THUMBNAIL_ID + " = ? ";

    /**
     * SQL for setting selection for Website.website_id = ?
     */
    public static final String SQL_WebsiteIdSettingSelection =
            DbContract.WebsiteEntry.TABLE_NAME +
                    "." + DbContract.WebsiteEntry.COLUMN_WEBSITE_ID + " = ? ";

    /**
     * SQL for setting selection for Self.self_id = ?
     */
    public static final String SQL_SelfIdSettingSelection =
            DbContract.SelfEntry.TABLE_NAME +
                    "." + DbContract.SelfEntry.COLUMN_SELF_ID + " = ? ";

    /**
     * SQL for setting selection for PartnerContact.partner_contact_id = ?
     */
    public static final String SQL_PartnerContactIdSettingSelection =
            DbContract.PartnerContactEntry.TABLE_NAME +
                    "." + DbContract.PartnerContactEntry.COLUMN_PARTNER_CONTACT_ID + " = ? ";

    /**
     * Create private cursor for the above table
     */

    /**
     * Uri Matcher that determine how the Uri is handling inputs
     * @return - Returns a UriMatcher
     */
    static UriMatcher buildUriMatcher(){
        final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        final String authority = DbContract.CONTENT_AUTHORITY;

        /**
         * For each type of URI you want to add, create a corresponding code
         */
        uriMatcher.addURI(authority, DbContract.PATH_ARTIST, ARTIST);
        uriMatcher.addURI(authority, DbContract.PATH_ARTWORK, ARTWORK);
        uriMatcher.addURI(authority, DbContract.PATH_FAIR, FAIR);
        uriMatcher.addURI(authority, DbContract.PATH_GENE, GENE);
        uriMatcher.addURI(authority, DbContract.PATH_SHOW, SHOW);
        uriMatcher.addURI(authority, DbContract.PATH_DIMENSION, DIMENSION);
        uriMatcher.addURI(authority, DbContract.PATH_CM, CM);
        uriMatcher.addURI(authority, DbContract.PATH_IN, IN);
        uriMatcher.addURI(authority, DbContract.PATH_IMAGE, IMAGE);
        uriMatcher.addURI(authority, DbContract.PATH_IMAGE_VERSION, IMAGE_VERSION);
        uriMatcher.addURI(authority, DbContract.PATH_LINK, LINK);
        uriMatcher.addURI(authority, DbContract.PATH_PARTNER, PARTNER);
        uriMatcher.addURI(authority, DbContract.PATH_PERMALINK, PERMALINK);
        uriMatcher.addURI(authority, DbContract.PATH_PROFILE, PROFILE);
        uriMatcher.addURI(authority, DbContract.PATH_THUMBNAIL, THUMBNAIL);
        uriMatcher.addURI(authority, DbContract.PATH_WEBSITE, WEBSITE);
        uriMatcher.addURI(authority, DbContract.PATH_SELF, SELF);
        uriMatcher.addURI(authority, DbContract.PATH_PARTNER_CONTACT, PARTNER_CONTACT);

        return uriMatcher;
    }

    /**
     * Create a local variable for the DbHelper
     * @return - Return the boolean result
     */
    @Override
    public boolean onCreate() {
        dbHelper = new DbHelper(getContext());
        return true;
    }

    /**
     * Determine the Uri type based on the Uri
     * @param uri - Pass in the Uri
     * @return - Returns the string for the content name
     */
    @Override
    public String getType(Uri uri) {

        // User the Uri Matcher to determine what kind of URI this is
        final int match = dbProviderUriMatcher.match(uri);

        switch(match){
            case ARTIST:
                return DbContract.ArtistEntry.CONTENT_TYPE;
            case ARTWORK:
                return DbContract.ArtworkEntry.CONTENT_TYPE;
            case FAIR:
                return DbContract.FairEntry.CONTENT_TYPE;
            case GENE:
                return DbContract.GeneEntry.CONTENT_TYPE;
            case SHOW:
                return DbContract.ShowEntry.CONTENT_TYPE;
            case DIMENSION:
                return DbContract.DimensionEntry.CONTENT_TYPE;
            case CM:
                return DbContract.CMEntry.CONTENT_TYPE;
            case IN:
                return DbContract.INEntry.CONTENT_TYPE;
            case IMAGE:
                return DbContract.ImageEntry.CONTENT_TYPE;
            case IMAGE_VERSION:
                return DbContract.ImageVersionEntry.CONTENT_TYPE;
            case LINK:
                return DbContract.LinkEntry.CONTENT_TYPE;
            case PARTNER:
                return DbContract.PartnerEntry.CONTENT_TYPE;
            case PERMALINK:
                return DbContract.PermalinkEntry.CONTENT_TYPE;
            case THUMBNAIL:
                return DbContract.ThumbnailEntry.CONTENT_TYPE;
            case WEBSITE:
                return DbContract.WebsiteEntry.CONTENT_TYPE;
            case SELF:
                return DbContract.SelfEntry.CONTENT_TYPE;
            case PARTNER_CONTACT:
                return DbContract.PartnerContactEntry.CONTENT_TYPE;
            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }
    }

    /**
     *  Query the specified table using specific project, selection, selectionArgs, and SortOrder
     * @param uri - Uri that content the path of the table
     * @param projection - The individual column to select
     * @param selection - The fields that should be included in the Where criteria
     * @param selectionArgs - The field value that should be included in the Where criteria
     * @param sortOrder - The sort order for the query
     * @return - Returns the Cursor of the specified table
     */
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs,
                        String sortOrder){
        Cursor retCursor = null;
        switch(dbProviderUriMatcher.match(uri)){
            case ARTIST: {
                retCursor = dbHelper.getReadableDatabase().query(
                        DbContract.ArtistEntry.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder
                );
                break;
            }
            case ARTWORK:{
                retCursor = dbHelper.getReadableDatabase().query(
                        DbContract.ArtworkEntry.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder
                );
                break;
            }
            case FAIR:{
                retCursor = dbHelper.getReadableDatabase().query(
                        DbContract.FairEntry.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder
                );
                break;
            }
            case GENE:{
                retCursor = dbHelper.getReadableDatabase().query(
                        DbContract.GeneEntry.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder
                );
                break;
            }
            case SHOW:{
                retCursor = dbHelper.getReadableDatabase().query(
                        DbContract.ShowEntry.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder
                );
                break;
            }
            case DIMENSION:{
                retCursor = dbHelper.getReadableDatabase().query(
                        DbContract.DimensionEntry.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder
                );
                break;
            }
            case CM:{
                retCursor = dbHelper.getReadableDatabase().query(
                        DbContract.CMEntry.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder
                );
                break;
            }
            case IN:{
                retCursor = dbHelper.getReadableDatabase().query(
                        DbContract.INEntry.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder
                );
                break;
            }
            case IMAGE:{
                retCursor = dbHelper.getReadableDatabase().query(
                        DbContract.ImageEntry.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder
                );
                break;
            }
            case IMAGE_VERSION:{
                retCursor = dbHelper.getReadableDatabase().query(
                        DbContract.ImageVersionEntry.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder
                );
                break;
            }
            case LINK:{
                retCursor = dbHelper.getReadableDatabase().query(
                        DbContract.LinkEntry.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder
                );
                break;
            }
            case PARTNER:{
                retCursor = dbHelper.getReadableDatabase().query(
                        DbContract.PartnerEntry.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder
                );
                break;
            }
            case PERMALINK:{
                retCursor = dbHelper.getReadableDatabase().query(
                        DbContract.PermalinkEntry.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder
                );
                break;
            }
            case THUMBNAIL:{
                retCursor = dbHelper.getReadableDatabase().query(
                        DbContract.ThumbnailEntry.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder
                );
                break;
            }
            case WEBSITE:{
                retCursor = dbHelper.getReadableDatabase().query(
                        DbContract.WebsiteEntry.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder
                );
                break;
            }
            case SELF:{
                retCursor = dbHelper.getReadableDatabase().query(
                        DbContract.SelfEntry.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder
                );
                break;
            }
            case PARTNER_CONTACT:{
                retCursor = dbHelper.getReadableDatabase().query(
                        DbContract.PartnerContactEntry.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder
                );
                break;
            }
        }

        retCursor.setNotificationUri(getContext().getContentResolver(),uri);
        return retCursor;
    }

    /**
     * Insert the specified table using specific project, selection, selectionArgs, and SortOrder
     * @param uri - Uri that content the path of the table
     * @param contentValues - Content value to pass into the table
     * @return - Return the Uri of the inserted table
     */
    @Override
    public Uri insert(Uri uri,ContentValues contentValues) {
        final SQLiteDatabase db = dbHelper.getWritableDatabase();
        final int match = dbProviderUriMatcher.match(uri);
        Uri returnUri = null;

        switch (match){
            case ARTIST:{
                long _id = db.insert(DbContract.ArtistEntry.TABLE_NAME, null, contentValues);
                if(_id > 0)
                    returnUri = DbContract.ArtistEntry.buildArtistUri(_id);
                else
                    throw new android.database.SQLException("Failed to insert row into " + uri);
                break;
            }
            case ARTWORK:{
                long _id = db.insert(DbContract.ArtworkEntry.TABLE_NAME, null, contentValues);
                if(_id > 0)
                    returnUri = DbContract.ArtworkEntry.buildArtworkUri(_id);
                else
                    throw new android.database.SQLException("Failed to insert row into " + uri);
                break;
            }
            case FAIR:{
                long _id = db.insert(DbContract.FairEntry.TABLE_NAME, null, contentValues);
                if(_id > 0)
                    returnUri = DbContract.FairEntry.buildFairUri(_id);
                else
                    throw new android.database.SQLException("Failed to insert row into " + uri);
                break;
            }
            case GENE:{
                long _id = db.insert(DbContract.GeneEntry.TABLE_NAME, null, contentValues);
                if(_id > 0)
                    returnUri = DbContract.GeneEntry.buildGeneUri(_id);
                else
                    throw new android.database.SQLException("Failed to insert row into " + uri);
                break;
            }
            case SHOW:{
                long _id = db.insert(DbContract.ShowEntry.TABLE_NAME, null, contentValues);
                if(_id > 0)
                    returnUri = DbContract.ShowEntry.buildShowUri(_id);
                else
                    throw new android.database.SQLException("Failed to insert row into " + uri);
                break;
            }
            case DIMENSION:{
                long _id = db.insert(DbContract.DimensionEntry.TABLE_NAME, null, contentValues);
                if(_id > 0)
                    returnUri = DbContract.DimensionEntry.buildDimensionUri(_id);
                else
                    throw new android.database.SQLException("Failed to insert row into " + uri);
                break;
            }
            case CM:{
                long _id = db.insert(DbContract.CMEntry.TABLE_NAME, null, contentValues);
                if(_id > 0)
                    returnUri = DbContract.CMEntry.buildCMUri(_id);
                else
                    throw new android.database.SQLException("Failed to insert row into " + uri);
                break;
            }
            case IN:{
                long _id = db.insert(DbContract.INEntry.TABLE_NAME, null, contentValues);
                if(_id > 0)
                    returnUri = DbContract.INEntry.buildINUri(_id);
                else
                    throw new android.database.SQLException("Failed to insert row into " + uri);
                break;
            }
            case IMAGE:{
                long _id = db.insert(DbContract.ImageEntry.TABLE_NAME, null, contentValues);
                if(_id > 0)
                    returnUri = DbContract.ImageEntry.buildImageUri(_id);
                else
                    throw new android.database.SQLException("Failed to insert row into " + uri);
                break;
            }
            case IMAGE_VERSION:{
                long _id = db.insert(DbContract.ImageVersionEntry.TABLE_NAME, null, contentValues);
                if(_id > 0)
                    returnUri = DbContract.ImageVersionEntry.buildImageVersionUri(_id);
                else
                    throw new android.database.SQLException("Failed to insert row into " + uri);
                break;
            }
            case LINK:{
                long _id = db.insert(DbContract.LinkEntry.TABLE_NAME, null, contentValues);
                if(_id > 0)
                    returnUri = DbContract.LinkEntry.buildLinkUri(_id);
                else
                    throw new android.database.SQLException("Failed to insert row into " + uri);
                break;
            }
            case PARTNER:{
                long _id = db.insert(DbContract.PartnerEntry.TABLE_NAME, null, contentValues);
                if(_id > 0)
                    returnUri = DbContract.PartnerEntry.buildPartnerUri(_id);
                else
                    throw new android.database.SQLException("Failed to insert row into " + uri);
                break;
            }
            case PERMALINK:{
                long _id = db.insert(DbContract.PermalinkEntry.TABLE_NAME, null, contentValues);
                if(_id > 0)
                    returnUri = DbContract.PermalinkEntry.buildPermalinkUri(_id);
                else
                    throw new android.database.SQLException("Failed to insert row into " + uri);
                break;
            }
            case THUMBNAIL:{
                long _id = db.insert(DbContract.ThumbnailEntry.TABLE_NAME, null, contentValues);
                if(_id > 0)
                    returnUri = DbContract.ThumbnailEntry.buildThumbnailUri(_id);
                else
                    throw new android.database.SQLException("Failed to insert row into " + uri);
                break;
            }
            case WEBSITE:{
                long _id = db.insert(DbContract.WebsiteEntry.TABLE_NAME, null, contentValues);
                if(_id > 0)
                    returnUri = DbContract.WebsiteEntry.buildWebsiteUri(_id);
                else
                    throw new android.database.SQLException("Failed to insert row into " + uri);
                break;
            }
            case SELF:{
                long _id = db.insert(DbContract.SelfEntry.TABLE_NAME, null, contentValues);
                if(_id > 0)
                    returnUri = DbContract.SelfEntry.buildSelfUri(_id);
                else
                    throw new android.database.SQLException("Failed to insert row into " + uri);
                break;
            }
            case PARTNER_CONTACT:{
                long _id = db.insert(DbContract.PartnerContactEntry.TABLE_NAME, null, contentValues);
                if(_id > 0)
                    returnUri = DbContract.PartnerContactEntry.buildPartnerContactUri(_id);
                else
                    throw new android.database.SQLException("Failed to insert row into " + uri);
                break;
            }
        }

        getContext().getContentResolver().notifyChange(uri, null);
        return returnUri;
    }

    /**
     * Delete the specified table using specific project, selection, selectionArgs
     * @param uri - Uri that content the path of the table
     * @param selection - The fields that should be included in the Where criteria
     * @param selectionArgs - The field value that should be included in the Where criteria
     * @return - Returns the int number of row deleted
     */
    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        final SQLiteDatabase db = dbHelper.getWritableDatabase();
        final int match = dbProviderUriMatcher.match(uri);
        int rowDeleted = 0;

        if(null == selection) selection = "1";

        switch (match){
            case ARTIST:{
                rowDeleted = db.delete(
                        DbContract.ArtistEntry.TABLE_NAME,
                        selection,
                        selectionArgs
                );
                break;
            }
            case ARTWORK:{
                rowDeleted = db.delete(
                        DbContract.ArtworkEntry.TABLE_NAME,
                        selection,
                        selectionArgs
                );
                break;
            }
            case FAIR:{
                rowDeleted = db.delete(
                        DbContract.FairEntry.TABLE_NAME,
                        selection,
                        selectionArgs
                );
                break;
            }
            case GENE:{
                rowDeleted = db.delete(
                        DbContract.GeneEntry.TABLE_NAME,
                        selection,
                        selectionArgs
                );
                break;
            }
            case SHOW:{
                rowDeleted = db.delete(
                        DbContract.ShowEntry.TABLE_NAME,
                        selection,
                        selectionArgs
                );
                break;
            }
            case DIMENSION:{
                rowDeleted = db.delete(
                        DbContract.DimensionEntry.TABLE_NAME,
                        selection,
                        selectionArgs
                );
                break;
            }
            case CM:{
                rowDeleted = db.delete(
                        DbContract.CMEntry.TABLE_NAME,
                        selection,
                        selectionArgs
                );
                break;
            }
            case IN:{
                rowDeleted = db.delete(
                        DbContract.INEntry.TABLE_NAME,
                        selection,
                        selectionArgs
                );
                break;
            }
            case IMAGE:{
                rowDeleted = db.delete(
                        DbContract.ImageEntry.TABLE_NAME,
                        selection,
                        selectionArgs
                );
                break;
            }
            case IMAGE_VERSION:{
                rowDeleted = db.delete(
                        DbContract.ImageVersionEntry.TABLE_NAME,
                        selection,
                        selectionArgs
                );
                break;
            }
            case LINK:{
                rowDeleted = db.delete(
                        DbContract.LinkEntry.TABLE_NAME,
                        selection,
                        selectionArgs
                );
                break;
            }
            case PARTNER:{
                rowDeleted = db.delete(
                        DbContract.PartnerEntry.TABLE_NAME,
                        selection,
                        selectionArgs
                );
                break;
            }
            case PERMALINK:{
                rowDeleted = db.delete(
                        DbContract.PermalinkEntry.TABLE_NAME,
                        selection,
                        selectionArgs
                );
                break;
            }
            case THUMBNAIL:{
                rowDeleted = db.delete(
                        DbContract.ThumbnailEntry.TABLE_NAME,
                        selection,
                        selectionArgs
                );
                break;
            }
            case WEBSITE:{
                rowDeleted = db.delete(
                        DbContract.WebsiteEntry.TABLE_NAME,
                        selection,
                        selectionArgs
                );
                break;
            }
            case SELF:{
                rowDeleted = db.delete(
                        DbContract.SelfEntry.TABLE_NAME,
                        selection,
                        selectionArgs
                );
                break;
            }
            case PARTNER_CONTACT:{
                rowDeleted = db.delete(
                        DbContract.PartnerContactEntry.TABLE_NAME,
                        selection,
                        selectionArgs
                );
                break;
            }
        }

        // Because a null deletes all row
        if(rowDeleted != 0){
            if(getContext().getContentResolver() != null){
                getContext().getContentResolver().notifyChange(uri,null);
            }
        }
        return rowDeleted;
    }

    /**
     *  Update the specified table using specific project, selection, selectionArgs
     * @param uri - Uri that content the path of the table
     * @param contentValues - Content value to pass into the table
     * @param selection - The fields that should be included in the Where criteria
     * @param selectionArgs - The field value that should be included in the Where criteria
     * @return - Returns the int number of row update
     */
    @Override
    public int update(Uri uri, ContentValues contentValues, String selection,
                      String[] selectionArgs) {
        final SQLiteDatabase db = dbHelper.getWritableDatabase();
        final int match = dbProviderUriMatcher.match(uri);
        int rowUpdated = 0;

        switch (match){
            case ARTIST:{
                rowUpdated = db.update(DbContract.ArtistEntry.TABLE_NAME,
                        contentValues,
                        selection,
                        selectionArgs);
                break;
            }
            case ARTWORK:{
                rowUpdated = db.update(DbContract.ArtworkEntry.TABLE_NAME,
                        contentValues,
                        selection,
                        selectionArgs);
                break;
            }
            case FAIR:{
                rowUpdated = db.update(DbContract.FairEntry.TABLE_NAME,
                        contentValues,
                        selection,
                        selectionArgs);
                break;
            }
            case GENE:{
                rowUpdated = db.update(DbContract.GeneEntry.TABLE_NAME,
                        contentValues,
                        selection,
                        selectionArgs);
                break;
            }
            case SHOW:{
                rowUpdated = db.update(DbContract.ShowEntry.TABLE_NAME,
                        contentValues,
                        selection,
                        selectionArgs);
                break;
            }
            case DIMENSION:{
                rowUpdated = db.update(DbContract.DimensionEntry.TABLE_NAME,
                        contentValues,
                        selection,
                        selectionArgs);
                break;
            }
            case CM:{
                rowUpdated = db.update(DbContract.CMEntry.TABLE_NAME,
                        contentValues,
                        selection,
                        selectionArgs);
                break;
            }
            case IN:{
                rowUpdated = db.update(DbContract.INEntry.TABLE_NAME,
                        contentValues,
                        selection,
                        selectionArgs);
                break;
            }
            case IMAGE:{
                rowUpdated = db.update(DbContract.ImageEntry.TABLE_NAME,
                        contentValues,
                        selection,
                        selectionArgs);
                break;
            }
            case IMAGE_VERSION:{
                rowUpdated = db.update(DbContract.ImageVersionEntry.TABLE_NAME,
                        contentValues,
                        selection,
                        selectionArgs);
                break;
            }
            case LINK:{
                rowUpdated = db.update(DbContract.LinkEntry.TABLE_NAME,
                        contentValues,
                        selection,
                        selectionArgs);
                break;
            }
            case PARTNER:{
                rowUpdated = db.update(DbContract.PartnerEntry.TABLE_NAME,
                        contentValues,
                        selection,
                        selectionArgs);
                break;
            }
            case PERMALINK:{
                rowUpdated = db.update(DbContract.PermalinkEntry.TABLE_NAME,
                        contentValues,
                        selection,
                        selectionArgs);
                break;
            }
            case THUMBNAIL:{
                rowUpdated = db.update(DbContract.ThumbnailEntry.TABLE_NAME,
                        contentValues,
                        selection,
                        selectionArgs);
                break;
            }
            case WEBSITE:{
                rowUpdated = db.update(DbContract.WebsiteEntry.TABLE_NAME,
                        contentValues,
                        selection,
                        selectionArgs);
                break;
            }
            case SELF:{
                rowUpdated = db.update(DbContract.SelfEntry.TABLE_NAME,
                        contentValues,
                        selection,
                        selectionArgs);
                break;
            }
            case PARTNER_CONTACT:{
                rowUpdated = db.update(DbContract.PartnerContactEntry.TABLE_NAME,
                        contentValues,
                        selection,
                        selectionArgs);
                break;
            }
        }
        if (rowUpdated != 0) {
            if(getContext().getContentResolver() != null) {
                getContext().getContentResolver().notifyChange(uri, null);
            }
        }
        return rowUpdated;
    }

    /**
     * Bulkd insert the specified table using specific project, selection, selectionArgs, and SortOrder
     * @param uri - Uri that content the path of the table
     * @param values - Content value to pass into the table
     * @return - Returns the int number of row inserted
     */
    @Override
    public int bulkInsert(Uri uri, ContentValues[] values) {
        final SQLiteDatabase db = dbHelper.getWritableDatabase();
        final int match = dbProviderUriMatcher.match(uri);

        db.beginTransaction();
        int returnCount = 0;
        long _id;

        try{
            for(ContentValues value : values){
                if(value != null){
                    switch (match){
                        case ARTIST:{
                            _id = db.insert(DbContract.ArtistEntry.TABLE_NAME, null, value);
                            if(_id != -1){
                                returnCount++;
                            }
                            break;
                        }
                        case ARTWORK:{
                            _id = db.insert(DbContract.ArtworkEntry.TABLE_NAME, null, value);
                            if(_id != -1){
                                returnCount++;
                            }
                            break;
                        }
                        case FAIR:{
                            _id = db.insert(DbContract.FairEntry.TABLE_NAME, null, value);
                            if(_id != -1){
                                returnCount++;
                            }
                            break;
                        }
                        case GENE:{
                            _id = db.insert(DbContract.GeneEntry.TABLE_NAME, null, value);
                            if(_id != -1){
                                returnCount++;
                            }
                            break;
                        }
                        case SHOW:{
                            _id = db.insert(DbContract.ShowEntry.TABLE_NAME, null, value);
                            if(_id != -1){
                                returnCount++;
                            }
                            break;
                        }
                        case DIMENSION:{
                            _id = db.insert(DbContract.DimensionEntry.TABLE_NAME, null, value);
                            if(_id != -1){
                                returnCount++;
                            }
                            break;
                        }
                        case CM:{
                            _id = db.insert(DbContract.CMEntry.TABLE_NAME, null, value);
                            if(_id != -1){
                                returnCount++;
                            }
                            break;
                        }
                        case IN:{
                            _id = db.insert(DbContract.INEntry.TABLE_NAME, null, value);
                            if(_id != -1){
                                returnCount++;
                            }
                            break;
                        }
                        case IMAGE:{
                            _id = db.insert(DbContract.ImageEntry.TABLE_NAME, null, value);
                            if(_id != -1){
                                returnCount++;
                            }
                            break;
                        }
                        case IMAGE_VERSION:{
                            _id = db.insert(DbContract.ImageVersionEntry.TABLE_NAME, null, value);
                            if(_id != -1){
                                returnCount++;
                            }
                            break;
                        }
                        case LINK:{
                            _id = db.insert(DbContract.LinkEntry.TABLE_NAME, null, value);
                            if(_id != -1){
                                returnCount++;
                            }
                            break;
                        }
                        case PARTNER:{
                            _id = db.insert(DbContract.PartnerEntry.TABLE_NAME, null, value);
                            if(_id != -1){
                                returnCount++;
                            }
                            break;
                        }
                        case PERMALINK:{
                            _id = db.insert(DbContract.PermalinkEntry.TABLE_NAME, null, value);
                            if(_id != -1){
                                returnCount++;
                            }
                            break;
                        }
                        case THUMBNAIL:{
                            _id = db.insert(DbContract.ThumbnailEntry.TABLE_NAME, null, value);
                            if(_id != -1){
                                returnCount++;
                            }
                            break;
                        }
                        case WEBSITE:{
                            _id = db.insert(DbContract.WebsiteEntry.TABLE_NAME, null, value);
                            if(_id != -1){
                                returnCount++;
                            }
                            break;
                        }
                        case SELF:{
                            _id = db.insert(DbContract.SelfEntry.TABLE_NAME, null, value);
                            if(_id != -1){
                                returnCount++;
                            }
                            break;
                        }
                        case PARTNER_CONTACT:{
                            _id = db.insert(DbContract.PartnerContactEntry.TABLE_NAME, null, value);
                            if(_id != -1){
                                returnCount++;
                            }
                            break;
                        }
                        default:
                            return super.bulkInsert(uri, values);
                    }
                }
            }

            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return returnCount;
    }
}
