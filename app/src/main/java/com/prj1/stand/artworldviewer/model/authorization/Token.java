package com.prj1.stand.artworldviewer.model.authorization;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.prj1.stand.artworldviewer.model.Links;

public class Token {

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

}

