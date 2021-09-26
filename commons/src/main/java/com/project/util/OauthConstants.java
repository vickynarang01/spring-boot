package com.project.util;

public class OauthConstants {

    public static final boolean OAUTH_FLAG = true;
    public static final String SECRET = "your-256-bit-secret";
    public static final long EXPIRATION_TIME = 864_000_000; // 10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/users/sign-up";

    //KEYS
    public static final String APPID_KEY = "appid";
    public static final String AUDIENCE_KEY = "aud";
    public static final String ISSUER_KEY = "iss";
    public static final String TENANT_KEY = "tid";
    public static final String UPN_KEY = "upn";
    public static final String NAME = "name";
    public static final String GROUP_KEY = "groups";
    public static final String AUDIENCE_GRAPH = "https://graph.windows.net";
    
    public static final String CORRELATION_ID = "correlation-id";


}