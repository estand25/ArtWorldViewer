package com.prj1.stand.artworldviewer.utilities;

import com.prj1.stand.artworldviewer.model.authorization.Token;

/**
 * Singleton class to handling Token retrieval from the api
 *
 * Created by Stand on 5/6/2017.
 */

public class TokenUtility {
    private static TokenUtility ourInstance;
    private static Token ourToken;

    public static TokenUtility getInstance() {
        if(ourInstance == null)
        {
            ourInstance = new TokenUtility();
        }
        return ourInstance;
    }

    private TokenUtility() {
    }

    public void setToken(Token token){
        ourToken = token;
    }

    public String getOurToken(){
        return ourToken.getToken();
    }

    public String getOurTokenType() {
        return ourToken.getType();
    }

    public String getOurTokenExpire(){
        return ourToken.getExpiresAt();
    }
}
