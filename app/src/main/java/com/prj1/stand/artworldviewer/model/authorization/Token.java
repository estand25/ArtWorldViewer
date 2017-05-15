
package com.prj1.stand.artworldviewer.model.authorization;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Token implements Parcelable
{

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("expires_at")
    @Expose
    private String expiresAt;
    @SerializedName("_links")
    @Expose
    private Links links;
    public final static Parcelable.Creator<Token> CREATOR = new Creator<Token>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Token createFromParcel(Parcel in) {
            Token instance = new Token();
            instance.type = ((String) in.readValue((String.class.getClassLoader())));
            instance.token = ((String) in.readValue((String.class.getClassLoader())));
            instance.expiresAt = ((String) in.readValue((String.class.getClassLoader())));
            instance.links = ((Links) in.readValue((Links.class.getClassLoader())));
            return instance;
        }

        public Token[] newArray(int size) {
            return (new Token[size]);
        }

    }
    ;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Token() {
    }

    /**
     * 
     * @param expiresAt
     * @param token
     * @param links
     * @param type
     */
    public Token(String type, String token, String expiresAt, Links links) {
        super();
        this.type = type;
        this.token = token;
        this.expiresAt = expiresAt;
        this.links = links;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(String expiresAt) {
        this.expiresAt = expiresAt;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(type);
        dest.writeValue(token);
        dest.writeValue(expiresAt);
        dest.writeValue(links);
    }

    public int describeContents() {
        return  0;
    }

}
